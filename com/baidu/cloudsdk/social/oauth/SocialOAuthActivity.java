package com.baidu.cloudsdk.social.oauth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.util.Validator;
import com.baidu.cloudsdk.social.core.SocialConstants;
/* loaded from: classes.dex */
public class SocialOAuthActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private static IBaiduListener f853a;
    private String b;
    private String c;
    private cb e;
    private boolean d = false;
    private IBaiduListener f = new u(this);

    public static synchronized void setListener(IBaiduListener iBaiduListener) {
        synchronized (SocialOAuthActivity.class) {
            Validator.notNull(iBaiduListener, "listener");
            f853a = iBaiduListener;
        }
    }

    public void a() {
        this.d = true;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.e != null) {
            this.e.a(i, i2, intent);
        }
        super.onActivityResult(i, i2, intent);
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
        this.c = bundle.getString(SocialConstants.PARAM_CLIENT_ID);
        this.d = bundle.getBoolean(SocialConstants.PARAM_ACTIVITY_STATE_FLAG);
        this.e = new cc(this, this.c, this.f).a(this.b);
        if (this.d) {
            return;
        }
        this.e.f();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.e != null) {
            this.e.a();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(SocialConstants.PARAM_MEDIA_TYPE, this.b);
        bundle.putString(SocialConstants.PARAM_CLIENT_ID, this.c);
        bundle.putBoolean(SocialConstants.PARAM_ACTIVITY_STATE_FLAG, this.d);
    }
}
