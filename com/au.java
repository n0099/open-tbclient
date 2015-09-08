package com;

import com.baidu.cloudsdk.BaiduException;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.social.core.SessionManager;
import com.baidu.cloudsdk.social.oauth.SocialOAuthActivity;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class au implements IBaiduListener {
    final /* synthetic */ SocialOAuthActivity djz;

    public au(SocialOAuthActivity socialOAuthActivity) {
        this.djz = socialOAuthActivity;
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onCancel() {
        IBaiduListener iBaiduListener;
        IBaiduListener iBaiduListener2;
        this.djz.finish();
        iBaiduListener = SocialOAuthActivity.a;
        if (iBaiduListener != null) {
            iBaiduListener2 = SocialOAuthActivity.a;
            iBaiduListener2.onCancel();
        }
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onComplete() {
        IBaiduListener iBaiduListener;
        IBaiduListener iBaiduListener2;
        this.djz.finish();
        iBaiduListener = SocialOAuthActivity.a;
        if (iBaiduListener != null) {
            iBaiduListener2 = SocialOAuthActivity.a;
            iBaiduListener2.onComplete();
        }
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONArray jSONArray) {
        IBaiduListener iBaiduListener;
        IBaiduListener iBaiduListener2;
        this.djz.finish();
        iBaiduListener = SocialOAuthActivity.a;
        if (iBaiduListener != null) {
            iBaiduListener2 = SocialOAuthActivity.a;
            iBaiduListener2.onComplete(jSONArray);
        }
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onComplete(JSONObject jSONObject) {
        IBaiduListener iBaiduListener;
        IBaiduListener iBaiduListener2;
        if (!SessionManager.getInstance(this.djz).save(jSONObject)) {
            onError(new BaiduException("failed to save social session, it may be an error content"));
            return;
        }
        this.djz.finish();
        iBaiduListener = SocialOAuthActivity.a;
        if (iBaiduListener != null) {
            iBaiduListener2 = SocialOAuthActivity.a;
            iBaiduListener2.onComplete();
        }
    }

    @Override // com.baidu.cloudsdk.IBaiduListener
    public void onError(BaiduException baiduException) {
        IBaiduListener iBaiduListener;
        IBaiduListener iBaiduListener2;
        this.djz.finish();
        iBaiduListener = SocialOAuthActivity.a;
        if (iBaiduListener != null) {
            iBaiduListener2 = SocialOAuthActivity.a;
            iBaiduListener2.onError(baiduException);
        }
    }
}
