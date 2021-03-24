package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.yy.open.OnUIListener;
import com.yy.open.UIError;
import com.yy.open.YYOpenSDK;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class YYSSOLoginActivity extends BaseSSOLoginActivity {
    public static final String TAG = "YYSSOLoginActivity";
    public String accessCode;
    public OnUIListener uiListener = new OnUIListener() { // from class: com.baidu.sapi2.activity.social.YYSSOLoginActivity.1
        public void onCancel() {
            Log.d(YYSSOLoginActivity.TAG, "YY授权登录 已取消");
            YYSSOLoginActivity yYSSOLoginActivity = YYSSOLoginActivity.this;
            yYSSOLoginActivity.handleBack(yYSSOLoginActivity.businessFrom, -1000, AbstractThirdPartyService.RESULT_AUTH_CANCEL_MSG);
        }

        public void onComplete(JSONObject jSONObject) {
            Log.d(YYSSOLoginActivity.TAG, "onComplete " + jSONObject.toString());
            if (jSONObject != null) {
                if (jSONObject.has("access_code")) {
                    YYSSOLoginActivity.this.accessCode = jSONObject.optString("access_code");
                } else if (jSONObject.has("token")) {
                    YYSSOLoginActivity.this.accessCode = jSONObject.optString("token");
                }
            }
            if (!TextUtils.isEmpty(YYSSOLoginActivity.this.accessCode)) {
                Log.d(YYSSOLoginActivity.TAG, "accessCode=" + YYSSOLoginActivity.this.accessCode);
                YYSSOLoginActivity.this.startLogin();
                return;
            }
            YYSSOLoginActivity yYSSOLoginActivity = YYSSOLoginActivity.this;
            yYSSOLoginActivity.handleBack(yYSSOLoginActivity.businessFrom, -1, "未知错误");
        }

        public void onError(UIError uIError) {
            Log.d(YYSSOLoginActivity.TAG, "onError " + uIError.code + " " + uIError.desc);
            YYSSOLoginActivity yYSSOLoginActivity = YYSSOLoginActivity.this;
            yYSSOLoginActivity.handleBack(yYSSOLoginActivity.businessFrom, uIError.code, uIError.desc);
        }
    };
    public YYOpenSDK yyOpenSDK;

    /* JADX INFO: Access modifiers changed from: private */
    public void startLogin() {
        loadLoginInNA(ParamsUtil.getUrlYYLogin(this.accessCode, SapiAccountManager.getInstance().getConfignation()), "授权YY账号登录中");
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.yyOpenSDK.handleActivityResult(i, i2, intent, this.uiListener);
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        if (confignation != null && !TextUtils.isEmpty(confignation.yyAppId)) {
            YYOpenSDK createInstance = YYOpenSDK.createInstance(this, confignation.yyAppId);
            this.yyOpenSDK = createInstance;
            createInstance.authorize(this, this.uiListener);
            return;
        }
        handleBack(this.businessFrom, -10, AbstractThirdPartyService.RESULT_AUTH_UNSUPPORT_MSG);
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText("YY授权登录");
    }
}
