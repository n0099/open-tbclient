package com.baidu.cloudsdk.social.share.handler;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Toast;
import com.b;
import com.baidu.cloudsdk.BaiduAPIResponseHandler;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.MultipartRequestParams;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SessionManager;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import com.bg;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public class FacebookShareHandler implements ISocialShareHandler {
    private IBaiduListener a;
    private boolean b;
    protected String mClientId;
    protected Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements AsyncImageLoader.IAsyncImageLoaderListener {
        private ShareContent b;
        private SessionManager.Session c;

        public a(ShareContent shareContent, SessionManager.Session session) {
            this.b = shareContent;
            this.c = session;
        }

        @Override // com.baidu.cloudsdk.common.imgloader.AsyncImageLoader.IAsyncImageLoaderListener
        public void onComplete(Bitmap bitmap) {
            if (bitmap == null || bitmap.isRecycled()) {
                if (FacebookShareHandler.this.a != null) {
                    FacebookShareHandler.this.a.onError(new BaiduException("failed to load image uri "));
                    return;
                }
                return;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] byteArray = bitmap.compress(Bitmap.CompressFormat.PNG, this.b.getCompressDataQuality(), byteArrayOutputStream) ? byteArrayOutputStream.toByteArray() : null;
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
            }
            FacebookShareHandler.this.a(this.b, this.c, byteArray, false);
        }
    }

    public FacebookShareHandler(Context context, String str, boolean z) {
        this.mContext = context;
        this.mClientId = str;
        this.b = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareContent shareContent, SessionManager.Session session) {
        if (shareContent.getImageData() != null) {
            a(shareContent, session, shareContent.getCompressedImageData(), false);
        } else if (shareContent.getImageUri() == null) {
            a(shareContent, session, null, false);
        } else {
            if (Utils.isUrl(shareContent.getImageUri())) {
                a(shareContent, session, null, true);
            }
            ImageManager.getInstance().loadImage(this.mContext, shareContent.getImageUri(), new a(shareContent, session));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareContent shareContent, SessionManager.Session session, byte[] bArr, boolean z) {
        if (bArr == null && !z) {
            RequestParams requestParams = new RequestParams();
            requestParams.put("message", shareContent.getContent());
            requestParams.put("link", shareContent.getLinkUrl());
            requestParams.put(SocialConstants.PARAM_ACCESS_TOKEN, session.getAccessToken());
            new AsyncHttpClient().post(null, "https://graph.facebook.com/me/feed", requestParams, new BaiduAPIResponseHandler(MediaType.FACEBOOK, "https://graph.facebook.com/me/feed", this.a));
        } else if (bArr == null && z) {
            MultipartRequestParams multipartRequestParams = new MultipartRequestParams();
            multipartRequestParams.put("message", shareContent.getContent() + " " + shareContent.getLinkUrl());
            multipartRequestParams.put("url", shareContent.getImageUri().toString());
            multipartRequestParams.put(SocialConstants.PARAM_ACCESS_TOKEN, session.getAccessToken());
            new AsyncHttpClient().post(null, "https://graph.facebook.com/me/photos", multipartRequestParams, new BaiduAPIResponseHandler(MediaType.FACEBOOK, "https://graph.facebook.com/me/photos", this.a));
        } else if (bArr != null && !z) {
            MultipartRequestParams multipartRequestParams2 = new MultipartRequestParams();
            multipartRequestParams2.put("message", shareContent.getContent() + " " + shareContent.getLinkUrl());
            multipartRequestParams2.put("source", new ByteArrayInputStream(bArr));
            multipartRequestParams2.put(SocialConstants.PARAM_ACCESS_TOKEN, session.getAccessToken());
            new AsyncHttpClient().post(null, "https://graph.facebook.com/me/photos", multipartRequestParams2, new BaiduAPIResponseHandler(MediaType.FACEBOOK, "https://graph.facebook.com/me/photos", this.a));
        }
        SocialShareStatisticsManager.getInstance(this.mContext).statistics(MediaType.FACEBOOK, shareContent);
    }

    @Override // com.baidu.cloudsdk.social.share.handler.ISocialShareHandler
    public void share(ShareContent shareContent, IBaiduListener iBaiduListener, boolean z) {
        this.a = iBaiduListener;
        SocialShareConfig socialShareConfig = SocialShareConfig.getInstance(this.mContext);
        if (!Utils.isNetWorkAvaliable(this.mContext)) {
            Toast.makeText(this.mContext, socialShareConfig.getString("network_not_avaliable_cannotshare"), 0).show();
            if (this.a != null) {
                this.a.onError(new BaiduException("Network not avaliable"));
                return;
            }
            return;
        }
        Toast.makeText(this.mContext, socialShareConfig.getString("sharing"), 0).show();
        SessionManager sessionManager = SessionManager.getInstance(this.mContext);
        SessionManager.Session session = sessionManager.get(MediaType.FACEBOOK.toString());
        if (session != null && !session.isExpired()) {
            SocialShareStatisticsManager.getInstance(this.mContext).getBackUrl(shareContent.getLinkUrl(), MediaType.TWITTER.toString(), new bg(this, shareContent, session));
        } else if (!this.b) {
            this.a.onError(new BaiduException("Facebook need authorization"));
        } else {
            if (session != null) {
                sessionManager.remove(MediaType.FACEBOOK.toString());
            }
            b bVar = new b(this, iBaiduListener, shareContent, z);
            Bundle bundle = new Bundle();
            bundle.putString("client_id", this.mClientId);
            bundle.putString(SocialConstants.PARAM_MEDIA_TYPE, MediaType.FACEBOOK.toString());
            Intent intent = new Intent(this.mContext, SocialOAuthActivity.class);
            intent.addFlags(268435456);
            intent.putExtras(bundle);
            SocialOAuthActivity.setListener(bVar);
            this.mContext.getApplicationContext().startActivity(intent);
        }
    }
}
