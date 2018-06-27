package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.c.a.a.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.result.SapiResult;
/* loaded from: classes2.dex */
public class HuaweiSSOLoginActivity extends BaseSSOLoginActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(a.c.sapi_sdk_title_login_hw);
        this.sapiWebView.setHuaweiHandler(new SapiWebView.HuaweiHandler() { // from class: com.baidu.sapi2.activity.social.HuaweiSSOLoginActivity.1
            @Override // com.baidu.sapi2.SapiWebView.HuaweiHandler
            public void handleHuaweiLoginFailure() {
                if (HuaweiSSOLoginActivity.this.businessFrom == 2001) {
                    Intent intent = new Intent();
                    intent.putExtra("result_code", -204);
                    intent.putExtra("result_msg", SapiResult.ERROR_MSG_PARAMS_ERROR);
                    HuaweiSSOLoginActivity.this.setResult(1002, intent);
                } else if (PassportSDK.getInstance().getWebAuthListener() != null) {
                    HuaweiSSOLoginActivity.this.webAuthResult.setResultCode(-204);
                    HuaweiSSOLoginActivity.this.webAuthResult.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
                    PassportSDK.getInstance().getWebAuthListener().onFailure(HuaweiSSOLoginActivity.this.webAuthResult);
                    PassportSDK.getInstance().release();
                }
                HuaweiSSOLoginActivity.this.finish();
            }
        });
        this.sapiWebView.loadHuaWeiSSOLogin(getStatParamList());
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }
}
