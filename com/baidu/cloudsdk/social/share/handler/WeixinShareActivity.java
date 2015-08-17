package com.baidu.cloudsdk.social.share.handler;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.cloudsdk.social.core.util.Weixin;
import com.l;
/* loaded from: classes.dex */
public class WeixinShareActivity extends Activity {
    private static final String a = WeixinShareActivity.class.getName();

    protected void afterHandleIntent() {
        finish();
    }

    protected void beforeHandleIntent() {
    }

    protected boolean handleIntent() {
        return Weixin.handleIntent(getIntent(), new l(this));
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        beforeHandleIntent();
        handleIntent();
        afterHandleIntent();
    }
}
