package com.baidu.sapi2.activity.social;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.ParamsUtil;
/* loaded from: classes2.dex */
public class YYInnerSSOLoginActivity extends BaseSSOLoginActivity {
    public static final String o = "accessCode";
    public String n;

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.social.SocialLoginBase, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
        String stringExtra = getIntent().getStringExtra(o);
        this.n = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
            if (webAuthListener != null) {
                WebAuthResult webAuthResult = new WebAuthResult();
                webAuthResult.setResultCode(SapiErrorCode.ACCESS_CODE_EMPTY);
                webAuthListener.onFailure(webAuthResult);
            }
            finish();
            return;
        }
        a(ParamsUtil.getUrlYYLogin(this.n, SapiAccountManager.getInstance().getConfignation()), "YY账号登录中");
    }

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText("YY登录");
    }
}
