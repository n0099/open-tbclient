package com.baidu.cloudsdk.social.share.handler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.ProxyActivityListener;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.cloudsdk.social.share.ShareContent;
/* loaded from: classes.dex */
public class LocalShareActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private String f861a;
    private int b;
    private ShareContent c;
    private ai d;
    private IBaiduListener e;

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.d != null) {
            this.d.onActivityResult(i, i2, intent);
            ai.a(i);
            return;
        }
        super.onActivityResult(i, i2, intent);
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
        this.f861a = bundle.getString(SocialConstants.PARAM_MEDIA_TYPE);
        this.b = bundle.getInt(SocialConstants.PARAM_REQUEST_CODE);
        this.c = (ShareContent) bundle.getParcelable(ai.PARAM_SHARE_CONTENT);
        if (this.f861a == null || this.b == 0 || this.c == null) {
            finish();
            return;
        }
        this.e = ai.a(this.b);
        ProxyActivityListener proxyActivityListener = new ProxyActivityListener(this, this.e);
        this.d = new LocalShareHandlerFactory(this).newInstance(this.f861a, this.b, proxyActivityListener);
        this.d.share(this.c, proxyActivityListener, false);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        finish();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(SocialConstants.PARAM_MEDIA_TYPE, this.f861a);
        bundle.putInt(SocialConstants.PARAM_REQUEST_CODE, this.b);
        bundle.putParcelable(ai.PARAM_SHARE_CONTENT, this.c);
        ai.a(this.b, this.e);
    }
}
