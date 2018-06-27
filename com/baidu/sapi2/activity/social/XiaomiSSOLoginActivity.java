package com.baidu.sapi2.activity.social;

import android.os.Bundle;
import com.baidu.c.a.a.a.a;
/* loaded from: classes2.dex */
public class XiaomiSSOLoginActivity extends BaseSSOLoginActivity {
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.social.BaseSSOLoginActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(a.c.sapi_sdk_title_login_xiaomi);
        this.sapiWebView.loadXiaomiSSOLogin(getStatParamList());
    }
}
