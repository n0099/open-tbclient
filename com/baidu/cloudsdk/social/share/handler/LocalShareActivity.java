package com.baidu.cloudsdk.social.share.handler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.ProxyActivityListener;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.c;
/* loaded from: classes.dex */
public class LocalShareActivity extends Activity {
    private static final String a = LocalShareActivity.class.getSimpleName();
    private String b;
    private int c;
    private ShareContent d;
    private c e;
    private boolean f = false;
    private IBaiduListener g;

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.e == null) {
            super.onActivityResult(i, i2, intent);
            finish();
            return;
        }
        this.e.onActivityResult(i, i2, intent);
        c.a(i);
        this.f = false;
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getIntent().getExtras();
        }
        if (bundle == null) {
            finish();
            return;
        }
        this.b = bundle.getString(SocialConstants.PARAM_MEDIA_TYPE);
        this.c = bundle.getInt("request_code");
        this.d = (ShareContent) bundle.getParcelable(c.PARAM_SHARE_CONTENT);
        this.f = bundle.getBoolean(SocialConstants.PARAM_ACTIVITY_STATE_FLAG);
        if (this.b == null || this.c == 0 || this.d == null) {
            finish();
            return;
        }
        this.g = c.a(this.c);
        ProxyActivityListener proxyActivityListener = new ProxyActivityListener(this, this.g);
        this.e = new LocalShareHandlerFactory(this).newInstance(this.b, this.c, proxyActivityListener);
        if (this.f) {
            return;
        }
        this.e.share(this.d, proxyActivityListener, false);
        this.f = true;
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        finish();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(SocialConstants.PARAM_MEDIA_TYPE, this.b);
        bundle.putInt("request_code", this.c);
        bundle.putParcelable(c.PARAM_SHARE_CONTENT, this.d);
        bundle.putBoolean(SocialConstants.PARAM_ACTIVITY_STATE_FLAG, this.f);
        c.a(this.c, this.g);
    }
}
