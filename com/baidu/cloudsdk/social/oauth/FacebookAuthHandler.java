package com.baidu.cloudsdk.social.oauth;

import android.content.Intent;
import android.os.Bundle;
import com.ax;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SocialConfig;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.share.uiwithlayout.SocialOAuthDialogFacebook;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class FacebookAuthHandler extends ax {
    public static final String FACEBOOK_PROXY_AUTH_APP_ID_KEY = "client_id";
    public static final String FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY = "scope";
    public static final String PARAM_DISPLAY = "display";
    public static final String PARAM_REDIRECT_URI = "redirect_uri";
    public static final String PARAM_SCOPE = "scope";
    public static final String PARAM_TYPE = "type";
    public static final String REDIRECT_URI = "fbconnect://success";
    private static final String a = FacebookAuthHandler.class.getSimpleName();
    private SocialOAuthDialogFacebook b;

    public FacebookAuthHandler(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        super(socialOAuthActivity, str, MediaType.FACEBOOK.toString(), iBaiduListener);
    }

    private void a() {
        String clientId = SocialConfig.getInstance(this.mActivity).getClientId(MediaType.FACEBOOK);
        RequestParams requestParams = new RequestParams();
        requestParams.put("client_id", clientId);
        requestParams.put("redirect_uri", REDIRECT_URI);
        requestParams.put("display", "touch");
        requestParams.put("type", "user_agent");
        requestParams.put("scope", "publish_actions");
        this.b = new SocialOAuthDialogFacebook(this.mActivity, "https://m.facebook.com/dialog/oauth?" + requestParams.getQueryString(), this.mListener);
        this.b.show();
    }

    @Override // com.ax
    protected Intent getIntentForSSO() {
        Intent putExtra = new Intent().setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth").putExtra("client_id", SocialConfig.getInstance(this.mActivity).getClientId(MediaType.FACEBOOK));
        putExtra.putExtra("scope", "publish_actions");
        return putExtra;
    }

    @Override // com.ax
    protected int getSSORequestCode() {
        return 0;
    }

    @Override // com.ax
    protected String getSSOSignatureHash() {
        return "cddf6938d49a6e53edff43d41132ebd2";
    }

    @Override // com.av
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == getSSORequestCode()) {
            if (intent == null) {
                this.mListener.onCancel();
            } else if (i2 != -1) {
                if (i2 == 0) {
                    this.mListener.onCancel();
                } else {
                    this.mListener.onError(new BaiduException("facebook sso returns unknown error"));
                }
            } else {
                Bundle extras = intent.getExtras();
                String string = extras.getString("error");
                if (string == null) {
                    string = extras.getString("error_type");
                }
                String string2 = extras.getString(SocialConstants.PARAM_ERROR_CODE);
                String string3 = extras.getString("error_message");
                if (string3 == null) {
                    string3 = extras.getString("error_description");
                }
                if (string != null || string2 != null || string3 != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(SocialConstants.PARAM_ERROR_CODE, string2);
                        jSONObject.put("error_message", string3);
                    } catch (JSONException e) {
                    }
                    this.mListener.onError(new BaiduException(jSONObject.toString()));
                    return;
                }
                String string4 = extras.getString(SocialConstants.PARAM_ACCESS_TOKEN);
                String string5 = extras.getString(SocialConstants.PARAM_EXPIRES_IN);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(SocialConstants.PARAM_ACCESS_TOKEN, string4).put(SocialConstants.PARAM_EXPIRES_IN, string5).put(SocialConstants.PARAM_MEDIA_TYPE, this.mMediaType);
                } catch (JSONException e2) {
                }
                this.mListener.onComplete(jSONObject2);
            }
        }
    }

    @Override // com.ax, com.av
    public void onDestroy() {
        if (this.b == null || !this.b.isShowing()) {
            return;
        }
        this.b.dismiss();
    }

    @Override // com.av
    public void startAuthorize() {
        if (!SocialConfig.getInstance(this.mActivity).getSsoMediaTypes().contains(MediaType.FACEBOOK)) {
            a();
        } else if (startSingleSignOn()) {
        } else {
            a();
        }
    }
}
