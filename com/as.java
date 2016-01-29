package com;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SocialConfig;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as extends ax {
    private String a;
    private String b;
    private ServiceConnection eDW;

    public as(SocialOAuthActivity socialOAuthActivity, String str, IBaiduListener iBaiduListener) {
        super(socialOAuthActivity, str, MediaType.SINAWEIBO.toString(), iBaiduListener);
        this.eDW = new at(this);
    }

    private boolean a() {
        Context applicationContext = this.mActivity.getApplicationContext();
        Intent intent = new Intent("com.sina.weibo.remotessoservice");
        if (applicationContext.getPackageManager().resolveService(intent, 0) != null) {
            return applicationContext.getApplicationContext().bindService(intent, this.eDW, 1);
        }
        return false;
    }

    @Override // com.ax
    protected Intent getIntentForSSO() {
        String clientId = SocialConfig.getInstance(this.mActivity).getClientId(MediaType.SINAWEIBO);
        Intent intent = new Intent();
        intent.setClassName(this.a, this.b);
        intent.putExtra("appKey", clientId);
        intent.putExtra("redirectUri", "https://openapi.baidu.com/social/oauth/2.0/receiver");
        intent.putExtra("scope", "email,direct_messages_write,direct_messages_read,friendships_groups_read,friendships_groups_write,statuses_to_me_read");
        return intent;
    }

    @Override // com.ax
    protected int getSSORequestCode() {
        return 32973;
    }

    @Override // com.ax
    protected String getSSOSignatureHash() {
        return "a23452bf0194000bdd87c6e0365a900b";
    }

    @Override // com.av
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == getSSORequestCode()) {
            String stringExtra = intent != null ? intent.getStringExtra("error") : null;
            if (i2 != -1 || intent == null) {
                if (i2 != 0) {
                    this.mListener.onError(new BaiduException("sina weibo sso returns unknown error"));
                    return;
                } else if (intent == null) {
                    this.mListener.onCancel();
                    return;
                } else {
                    this.mListener.onError(new BaiduException(stringExtra + ", error_code: " + String.valueOf(intent.getIntExtra(SocialConstants.PARAM_ERROR_CODE, -1)) + ", request for " + intent.getStringExtra("failing_url") + " failed"));
                    return;
                }
            }
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = intent.getStringExtra("error_type");
            }
            if (stringExtra == null) {
                Bundle extras = intent.getExtras();
                getSessionFromServer(extras.getString(SocialConstants.PARAM_ACCESS_TOKEN), extras.getString("uid"), MediaType.SINAWEIBO.toString());
            } else if (stringExtra.equals(SocialConstants.ERROR_ACCESS_DENIED) || stringExtra.equals("OAuthAccessDeniedException")) {
                this.mListener.onCancel();
            } else {
                this.mListener.onError(new BaiduException(intent.getStringExtra("error_description")));
            }
        }
    }

    @Override // com.av
    public void startAuthorize() {
        if (!SocialConfig.getInstance(this.mActivity).getSsoMediaTypes().contains(MediaType.SINAWEIBO)) {
            startAuthDialog();
        } else if (a()) {
        } else {
            startAuthDialog();
        }
    }
}
