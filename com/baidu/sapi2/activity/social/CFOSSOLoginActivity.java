package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.tieba.R;
import com.example.oauthsdk.CFOauth;
import com.example.oauthsdk.other.CFWebError;
import com.example.oauthsdk.widget.CFAuthCallback;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class CFOSSOLoginActivity extends BaseSSOLoginActivity {
    public static final String n = "CFOSSOLoginActivity";

    /* loaded from: classes3.dex */
    public class a implements CFAuthCallback {
        public a() {
        }

        public void onError(CFWebError cFWebError) {
            Log.e(CFOSSOLoginActivity.n, String.format("onError: [%s] %s", cFWebError.getErrorCode(), cFWebError.getMessage()));
            CFOSSOLoginActivity cFOSSOLoginActivity = CFOSSOLoginActivity.this;
            cFOSSOLoginActivity.a(-202, cFOSSOLoginActivity.getString(R.string.sapi_sdk_cfo_login_fail));
        }

        public void onCancel() {
            Log.e(CFOSSOLoginActivity.n, "用户取消授权");
            CFOSSOLoginActivity.this.a(-301, "您已取消操作");
        }

        public void onComplete(Bundle bundle) {
            try {
                String string = bundle.getString("code");
                if (CFOSSOLoginActivity.this.sapiWebView != null) {
                    CFOSSOLoginActivity.this.a(ParamsUtil.addExtras(ParamsUtil.getUrlCFOLogin(CFOSSOLoginActivity.this.configuration, string), new HashMap()), "春风授权登录中");
                } else {
                    CFOSSOLoginActivity.this.a(-202, CFOSSOLoginActivity.this.getString(R.string.sapi_sdk_cfo_login_fail));
                }
            } catch (Exception unused) {
                CFOSSOLoginActivity.this.a(-205, "服务端数据异常，请稍后再试");
            }
        }
    }

    private void d() {
        CFOauth.getInstance().initCFOauth(this.configuration.cfoAppKey);
        if (this.configuration.cfoOpenDebugMode) {
            CFOauth.getInstance().openDebugMode();
        }
        CFOauth.getInstance().getCFAuthCode(this, new a());
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(R.string.sapi_sdk_title_login_cfo);
        try {
            d();
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null) {
            sapiWebView.mIsCFProess = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        if (((BaseSSOLoginActivity) this).g == 2001) {
            Intent intent = new Intent();
            intent.putExtra("result_code", i);
            intent.putExtra("result_msg", str);
            setResult(1002, intent);
        } else if (CoreViewRouter.getInstance().getWebAuthListener() != null) {
            ((BaseSSOLoginActivity) this).h.setResultCode(i);
            ((BaseSSOLoginActivity) this).h.setResultMsg(str);
            CoreViewRouter.getInstance().getWebAuthListener().onFailure(((BaseSSOLoginActivity) this).h);
            CoreViewRouter.getInstance().release();
        }
        finish();
    }
}
