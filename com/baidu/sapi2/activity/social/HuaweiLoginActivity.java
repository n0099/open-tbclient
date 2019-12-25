package com.baidu.sapi2.activity.social;

import android.os.Bundle;
import com.baidu.i.a.a.a.a;
/* loaded from: classes4.dex */
public class HuaweiLoginActivity extends BaseSSOLoginActivity {
    public static final String ACCESS_TOKEN = "access_token";
    public static final String UID = "uid";

    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
        this.sapiWebView.loadHuaWeiSSOLogin(getIntent().getStringExtra("access_token"), getStatParamList());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(a.c.sapi_sdk_title_login_hw);
    }
}
