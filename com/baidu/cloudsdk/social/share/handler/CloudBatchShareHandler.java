package com.baidu.cloudsdk.social.share.handler;

import android.content.Context;
import android.location.Location;
import android.net.Uri;
import com.baidu.cloudsdk.BaiduAPIResponseHandler;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.MultipartRequestParams;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.social.core.SessionManager;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.ui.ShareDialog;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class CloudBatchShareHandler implements ISocialShareHandler {
    protected static final String PARAM_CONTENT = "content";
    protected static final String PARAM_LAT = "lat";
    protected static final String PARAM_LONG = "long";
    protected static final String PARAM_PIC = "pic";
    protected static final String PARAM_PIC_URL = "pic_url";
    protected static final String PARAM_TITLE = "title";
    protected static final String PARAM_URL = "url";

    /* renamed from: a  reason: collision with root package name */
    private String[] f861a;
    protected String mClientId;
    protected Context mContext;

    public CloudBatchShareHandler(Context context, String str, String[] strArr) {
        this.mContext = context;
        this.mClientId = str;
        this.f861a = strArr;
    }

    private void a(Uri uri, MultipartRequestParams multipartRequestParams, IBaiduListener iBaiduListener) {
        ImageManager.getInstance().loadImage(this.mContext, uri, new ac(this, multipartRequestParams, iBaiduListener));
    }

    private void a(ShareContent shareContent, List list, IBaiduListener iBaiduListener) {
        if (list.size() == 0) {
            if (iBaiduListener != null) {
                iBaiduListener.onError(new BaiduException("no access token supplied for batch share"));
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                MultipartRequestParams multipartRequestParams = new MultipartRequestParams();
                multipartRequestParams.put(SocialConstants.PARAM_ACCESS_TOKENS, sb.toString());
                doShare(shareContent, multipartRequestParams, iBaiduListener);
                return;
            }
            sb.append((String) list.get(i2));
            if (i2 < list.size() - 1) {
                sb.append(",");
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, MultipartRequestParams multipartRequestParams, IBaiduListener iBaiduListener) {
        String str2 = "https://openapi.baidu.com/social" + str;
        new AsyncHttpClient().post(null, str2, multipartRequestParams, new BaiduAPIResponseHandler(str2, iBaiduListener));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doShare(ShareContent shareContent, MultipartRequestParams multipartRequestParams, IBaiduListener iBaiduListener) {
        multipartRequestParams.put(SocialConstants.PARAM_CLIENT_TYPE, SocialConstants.ANDROID_CLIENT_TYPE);
        multipartRequestParams.put(PARAM_TITLE, shareContent.getTitle());
        multipartRequestParams.put("content", shareContent.getContent());
        multipartRequestParams.put("url", shareContent.getLinkUrl());
        Location location = shareContent.getLocation();
        if (location != null) {
            multipartRequestParams.put(PARAM_LONG, String.valueOf(location.getLongitude()));
            multipartRequestParams.put(PARAM_LAT, String.valueOf(location.getLatitude()));
        }
        SocialShareStatisticsManager.getInstance(this.mContext).setCommonParams(multipartRequestParams);
        byte[] compressedImageData = shareContent.getCompressedImageData();
        if (!Utils.isEmpty(compressedImageData)) {
            multipartRequestParams.put(PARAM_PIC, new ByteArrayInputStream(compressedImageData));
            a(getShareUploadUrl(), multipartRequestParams, iBaiduListener);
            return;
        }
        Uri imageUri = shareContent.getImageUri();
        if (imageUri != null && Utils.isUrl(imageUri)) {
            multipartRequestParams.put(PARAM_PIC_URL, imageUri.toString());
            a(getShareUrl(), multipartRequestParams, iBaiduListener);
        } else if (imageUri != null) {
            a(imageUri, multipartRequestParams, iBaiduListener);
        } else {
            a(getShareUrl(), multipartRequestParams, iBaiduListener);
        }
    }

    public String getShareUploadUrl() {
        return "/api/2.0/share_batch/upload";
    }

    public String getShareUrl() {
        return "/api/2.0/share_batch";
    }

    @Override // com.baidu.cloudsdk.social.share.handler.ISocialShareHandler
    public void share(ShareContent shareContent, IBaiduListener iBaiduListener, boolean z) {
        if (z) {
            new ShareDialog(this.mContext, shareContent, iBaiduListener).show();
            return;
        }
        Map all = SessionManager.getInstance(this.mContext).getAll();
        ArrayList arrayList = new ArrayList();
        if (Utils.isEmpty(this.f861a)) {
            for (SessionManager.Session session : all.values()) {
                if (!session.isExpired()) {
                    arrayList.add(session.getAccessToken());
                }
            }
        } else {
            for (String str : this.f861a) {
                SessionManager.Session session2 = (SessionManager.Session) all.get(str);
                if (session2 != null && !session2.isExpired()) {
                    arrayList.add(session2.getAccessToken());
                }
            }
        }
        a(shareContent, arrayList, iBaiduListener);
    }
}
