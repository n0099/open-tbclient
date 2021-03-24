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
import com.baidu.sapi2.share.a;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class ShareResultProxyActivity extends Activity implements NoProguard {
    public static final String KEY_EXTRA_PARAMS = "key_extra_params";
    public static final String KEY_PKG = "key_pkg";
    public static final String KEY_SESSION_ID = "key_session_id";
    public static final String KEY_TRACE_ID = "key_trace_id";
    public static final String KEY_URL = "key_url";
    public static final String KEY_VERSION = "key_version";

    /* renamed from: g  reason: collision with root package name */
    public static final String f11062g = "ShareResultProxyActivity";

    /* renamed from: a  reason: collision with root package name */
    public String f11063a;

    /* renamed from: b  reason: collision with root package name */
    public String f11064b;

    /* renamed from: c  reason: collision with root package name */
    public String f11065c;

    /* renamed from: d  reason: collision with root package name */
    public String f11066d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<PassNameValuePair> f11067e;

    /* renamed from: f  reason: collision with root package name */
    public String f11068f;

    private void a() {
        Intent intent = getIntent();
        this.f11063a = intent.getStringExtra(KEY_PKG);
        this.f11064b = intent.getStringExtra("key_url");
        this.f11065c = intent.getStringExtra(KEY_TRACE_ID);
        this.f11066d = intent.getStringExtra("key_session_id");
        this.f11067e = (ArrayList) intent.getSerializableExtra(KEY_EXTRA_PARAMS);
        this.f11068f = intent.getStringExtra("key_version");
        new a().a(this, this.f11063a, this.f11064b, this.f11065c, this.f11066d, this.f11067e, this.f11068f, "product");
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 20001) {
            CoreViewRouter.getInstance().onShareLoginActivityResult(i, i2, intent, "");
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
        a();
    }
}
