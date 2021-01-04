package com.baidu.sapi2.activity.social;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.RelativeLayout;
import com.baidu.l.a.a.a;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.enums.SocialType;
import com.xiaomi.account.openauth.XiaomiOAuthFuture;
import com.xiaomi.account.openauth.XiaomiOAuthResults;
import com.xiaomi.account.openauth.XiaomiOAuthorize;
/* loaded from: classes4.dex */
public class XiaomiSSOLoginActivity extends BaseSSOLoginActivity {
    private boolean isCancle;
    private XiaoMiCallback xiaoMiCallback;
    private Thread xiaoMiThread;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface XiaoMiCallback {
        void onFailure();

        void onSuccess(String str, String str2, String str3);
    }

    private void getXiaoMiSSOToken() {
        final XiaomiOAuthFuture startGetAccessToken = new XiaomiOAuthorize().setAppId(this.configuration.xiaomiAppID.longValue()).setUseSystemAccountLogin(true).setScope(new int[]{1, 3}).setRedirectUrl(this.configuration.xiaomiRedirectUri).startGetAccessToken(this);
        this.xiaoMiThread = new Thread(new Runnable() { // from class: com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    XiaomiOAuthResults xiaomiOAuthResults = (XiaomiOAuthResults) startGetAccessToken.getResult();
                    if (xiaomiOAuthResults.hasError()) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                XiaomiSSOLoginActivity.this.xiaoMiCallback.onFailure();
                            }
                        });
                    } else {
                        final String accessToken = xiaomiOAuthResults.getAccessToken();
                        final String macKey = xiaomiOAuthResults.getMacKey();
                        final String macAlgorithm = xiaomiOAuthResults.getMacAlgorithm();
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                XiaomiSSOLoginActivity.this.xiaoMiCallback.onSuccess(accessToken, macKey, macAlgorithm);
                            }
                        });
                    }
                } catch (Exception e) {
                    Log.e(e);
                }
            }
        });
        this.xiaoMiThread.start();
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void finish() {
        super.finish();
        Thread thread = this.xiaoMiThread;
        if (thread == null || !thread.isAlive()) {
            return;
        }
        this.xiaoMiThread.interrupt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.isCancle) {
            this.xiaoMiCallback.onFailure();
        }
        this.isCancle = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(a.c.sapi_sdk_title_login_xiaomi);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        this.xiaoMiCallback = new XiaoMiCallback() { // from class: com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity.1
            @Override // com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity.XiaoMiCallback
            public void onFailure() {
                XiaomiSSOLoginActivity xiaomiSSOLoginActivity = XiaomiSSOLoginActivity.this;
                xiaomiSSOLoginActivity.handleBack(xiaomiSSOLoginActivity.businessFrom);
            }

            @Override // com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity.XiaoMiCallback
            public void onSuccess(String str, String str2, String str3) {
                if (((SocialLoginBase) XiaomiSSOLoginActivity.this).sapiWebView != null) {
                    XiaomiSSOLoginActivity.this.loadLoginInNA(ParamsUtil.getUrlBind(((SocialLoginBase) XiaomiSSOLoginActivity.this).configuration, SocialType.XIAOMI, str, str2, ((SocialLoginBase) XiaomiSSOLoginActivity.this).configuration.xiaomiAppID + ""), "小米授权登录中");
                    XiaomiSSOLoginActivity.this.isCancle = false;
                }
            }
        };
        getXiaoMiSSOToken();
    }
}
