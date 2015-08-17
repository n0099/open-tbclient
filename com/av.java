package com;

import android.content.Intent;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import com.baidu.cloudsdk.social.oauth.SocialOAuthStatisticsManager;
import com.baidu.cloudsdk.social.share.uiwithlayout.SocialOAuthDialog;
import java.util.Random;
/* loaded from: classes.dex */
public class av {
    public SocialOAuthActivity mActivity;
    protected String mClientId;
    public IBaiduListener mListener;
    protected String mMediaType;
    protected SocialOAuthDialog mSocialOAuthDialog;

    public av(SocialOAuthActivity socialOAuthActivity, String str, String str2, IBaiduListener iBaiduListener) {
        this.mActivity = socialOAuthActivity;
        this.mClientId = str;
        this.mMediaType = str2;
        this.mListener = iBaiduListener;
    }

    private String a() {
        return Utils.md5(String.valueOf(new Random(System.currentTimeMillis()).nextInt()));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onDestroy() {
        if (this.mSocialOAuthDialog != null && this.mSocialOAuthDialog.isShowing()) {
            this.mSocialOAuthDialog.dismiss();
        }
        this.mActivity = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void startAuthDialog() {
        RequestParams requestParams = new RequestParams();
        requestParams.put("client_id", this.mClientId);
        requestParams.put(SocialConstants.PARAM_CLIENT_TYPE, SocialConstants.ANDROID_CLIENT_TYPE);
        requestParams.put(SocialConstants.PARAM_MEDIA_TYPE, this.mMediaType);
        requestParams.put("redirect_uri", SocialConstants.OOB_REDIRECT_URI);
        requestParams.put(SocialConstants.PARAM_RESPONSE_TYPE, SocialConstants.TOKEN_RESPONSE_TYPE);
        requestParams.put("display", SocialConstants.MOBILE_DISPLAY);
        requestParams.put(SocialConstants.PARAM_SECURE, "1");
        String a = a();
        requestParams.put(SocialConstants.PARAM_STATE, a);
        SocialOAuthStatisticsManager.setCommonParams(this.mActivity, requestParams);
        this.mSocialOAuthDialog = new SocialOAuthDialog(this.mActivity, "https://openapi.baidu.com/social/oauth/2.0/authorize?" + requestParams.getQueryString(), a, this.mListener);
        this.mSocialOAuthDialog.show();
    }

    public void startAuthorize() {
        startAuthDialog();
    }
}
