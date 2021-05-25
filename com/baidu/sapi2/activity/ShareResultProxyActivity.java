package com.baidu.sapi2.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.share.ShareCallPacking;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ShareResultProxyActivity extends Activity implements NoProguard {
    public static final String KEY_EXTRA_PARAMS = "key_extra_params";
    public static final String KEY_PKG = "key_pkg";
    public static final String KEY_SESSION_ID = "key_session_id";
    public static final String KEY_TRACE_ID = "key_trace_id";
    public static final String KEY_URL = "key_url";
    public static final String KEY_VERSION = "key_version";

    /* renamed from: h  reason: collision with root package name */
    public static final String f9700h = "ShareResultProxyActivity";

    /* renamed from: i  reason: collision with root package name */
    public static final String f9701i = "key_launch_share_activity_status";

    /* renamed from: a  reason: collision with root package name */
    public String f9702a;

    /* renamed from: b  reason: collision with root package name */
    public String f9703b;

    /* renamed from: c  reason: collision with root package name */
    public String f9704c;

    /* renamed from: d  reason: collision with root package name */
    public String f9705d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<PassNameValuePair> f9706e;

    /* renamed from: f  reason: collision with root package name */
    public String f9707f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f9708g;

    private void a() {
        this.f9708g = true;
        Intent intent = getIntent();
        this.f9702a = intent.getStringExtra(KEY_PKG);
        this.f9703b = intent.getStringExtra("key_url");
        this.f9704c = intent.getStringExtra(KEY_TRACE_ID);
        this.f9705d = intent.getStringExtra("key_session_id");
        this.f9706e = (ArrayList) intent.getSerializableExtra(KEY_EXTRA_PARAMS);
        this.f9707f = intent.getStringExtra("key_version");
        new ShareCallPacking().startLoginShareActivityForResult(this, this.f9702a, this.f9703b, this.f9704c, this.f9705d, this.f9706e, this.f9707f, "product");
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 20001) {
            CoreViewRouter.getInstance().onShareLoginActivityResult(i2, i3, intent, "");
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(51);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.width = 1;
        attributes.height = 1;
        attributes.type = 2002;
        attributes.flags = 32;
        window.setAttributes(attributes);
        if (bundle != null) {
            this.f9708g = bundle.getBoolean(f9701i, false);
        }
        if (this.f9708g) {
            return;
        }
        a();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(f9701i, this.f9708g);
        super.onSaveInstanceState(bundle);
    }
}
