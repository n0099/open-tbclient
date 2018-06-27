package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.c.a.a.a.a;
/* loaded from: classes2.dex */
public class SinaSSOLoginActivity extends BaseSSOLoginActivity {
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
        setTitleText(a.c.sapi_sdk_title_login_sina);
        this.sapiWebView.loadSinaSSOLogin(getStatParamList());
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.sapiWebView.onAuthorizedResult(i, i2, intent);
    }
}
