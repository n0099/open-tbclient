package com.baidu.swan.apps.console.debugger.adbdebug;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import d.b.g0.a.h;
import d.b.g0.a.i2.u;
import d.b.g0.a.k;
import d.b.g0.a.q1.b.b.g;
import d.b.g0.a.q1.b.f.d;
/* loaded from: classes3.dex */
public class SwanAppAdbDebugActivity extends Activity {
    public static final boolean DEBUG = k.f45050a;
    public static final String TAG = "SwanAppAdbDebugActivity";

    /* loaded from: classes3.dex */
    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            SwanAppAdbDebugActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f12130e;

        public b(Intent intent) {
            this.f12130e = intent;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f12130e.setClass(SwanAppAdbDebugActivity.this, SwanAppLauncherActivity.class);
            SwanAppAdbDebugActivity.this.startActivity(this.f12130e);
            SwanAppAdbDebugActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (DEBUG) {
            Log.d(TAG, "ADB Debug onCreate");
        }
        if (u.a(this)) {
            return;
        }
        Intent intent = getIntent();
        if (TextUtils.isEmpty(intent.getStringExtra("adb_debug_path"))) {
            d.e(this, h.aiapps_adb_debug_lack_path).C();
            if (DEBUG) {
                Log.d(TAG, "ADB Debug lack of app path");
            }
            finish();
        }
        g.a aVar = new g.a(this);
        aVar.V(getString(h.aiapps_adb_debug));
        aVar.y(getString(h.aiapps_adb_debug_alert));
        aVar.n(new d.b.g0.a.j2.g.a());
        aVar.m(false);
        aVar.O(h.aiapps_confirm, new b(intent));
        aVar.C(h.aiapps_adb_debug_close, new a());
        aVar.X();
    }
}
