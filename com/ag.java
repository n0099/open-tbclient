package com;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.Toast;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.core.util.RequestCodeManager;
import com.baidu.cloudsdk.social.restapi.SocialRestAPIImpl;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import com.baidu.cloudsdk.social.share.handler.ISocialShareHandler;
import com.baidu.cloudsdk.social.share.handler.LocalShareActivity;
import com.baidu.cloudsdk.social.share.handler.SocialShareStatisticsManager;
/* loaded from: classes.dex */
public class ag implements ISocialShareHandler {
    public static final String PARAM_SHARE_CONTENT = "share_content";
    private static SparseArray a = new SparseArray();
    protected Context mContext;
    protected IBaiduListener mListener;
    protected String mMediaType;
    protected int mRequestCode;
    protected ShareContent mShareContent;
    protected SocialRestAPIImpl mSocialRestAPI;

    /* JADX INFO: Access modifiers changed from: protected */
    public ag(Context context, IBaiduListener iBaiduListener, int i, String str) {
        this.mContext = context;
        this.mMediaType = str;
        this.mRequestCode = i;
        this.mListener = iBaiduListener;
        this.mSocialRestAPI = new SocialRestAPIImpl(context);
    }

    public ag(Context context, String str) {
        this.mContext = context;
        this.mMediaType = str;
    }

    public static synchronized IBaiduListener a(int i) {
        IBaiduListener iBaiduListener;
        synchronized (ag.class) {
            iBaiduListener = (IBaiduListener) a.get(i);
            a.delete(i);
        }
        return iBaiduListener;
    }

    public static void a(int i, IBaiduListener iBaiduListener) {
        IBaiduListener iBaiduListener2;
        synchronized (a) {
            iBaiduListener2 = (IBaiduListener) a.get(i);
            a.put(i, iBaiduListener);
        }
        if (iBaiduListener2 != null) {
            iBaiduListener2.onCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareContent shareContent) {
        int nextCode = RequestCodeManager.nextCode(this.mMediaType);
        shareContent.saveImageDataIfNecessary();
        Bundle bundle = new Bundle();
        bundle.putString(SocialConstants.PARAM_MEDIA_TYPE, this.mMediaType);
        bundle.putInt(SocialConstants.PARAM_REQUEST_CODE, nextCode);
        bundle.putParcelable(PARAM_SHARE_CONTENT, shareContent);
        Intent intent = new Intent(this.mContext, LocalShareActivity.class);
        intent.addFlags(268435456);
        intent.putExtras(bundle);
        a(nextCode, this.mListener);
        this.mContext.getApplicationContext().startActivity(intent);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStartLocalShareFailed(String str, IBaiduListener iBaiduListener) {
        Toast.makeText(this.mContext, SocialShareConfig.getInstance(this.mContext).getString(str), 1).show();
        if (iBaiduListener != null) {
            iBaiduListener.onError(new BaiduException("start local app for share failed, errcode: " + str));
        }
    }

    @Override // com.baidu.cloudsdk.social.share.handler.ISocialShareHandler
    public void share(ShareContent shareContent, IBaiduListener iBaiduListener, boolean z) {
        Toast.makeText(this.mContext, SocialShareConfig.getInstance(this.mContext).getString("pls_waiting"), 0).show();
        this.mListener = iBaiduListener;
        SocialShareStatisticsManager.getInstance(this.mContext).getBackUrl(shareContent.getLinkUrl(), this.mMediaType, new d(this, shareContent));
    }
}
