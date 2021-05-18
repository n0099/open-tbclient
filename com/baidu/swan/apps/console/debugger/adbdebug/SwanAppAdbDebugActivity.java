package com.baidu.swan.apps.console.debugger.adbdebug;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import d.a.i0.a.h;
import d.a.i0.a.k;
import d.a.i0.a.v2.v;
import d.a.i0.a.z1.b.b.h;
import d.a.i0.a.z1.b.f.e;
/* loaded from: classes2.dex */
public class SwanAppAdbDebugActivity extends Activity {
    public static final boolean DEBUG = k.f43025a;
    public static final String TAG = "SwanAppAdbDebugActivity";

    /* loaded from: classes2.dex */
    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            SwanAppAdbDebugActivity.this.finish();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f10778e;

        public b(Intent intent) {
            this.f10778e = intent;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            this.f10778e.setClass(SwanAppAdbDebugActivity.this, SwanAppLauncherActivity.class);
            SwanAppAdbDebugActivity.this.startActivity(this.f10778e);
            SwanAppAdbDebugActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (DEBUG) {
            Log.d(TAG, "ADB Debug onCreate");
        }
        if (v.a(this)) {
            return;
        }
        Intent intent = getIntent();
        if (TextUtils.isEmpty(intent.getStringExtra("adb_debug_path"))) {
            e.f(this, h.aiapps_adb_debug_lack_path).F();
            if (DEBUG) {
                Log.d(TAG, "ADB Debug lack of app path");
            }
            finish();
        }
        h.a aVar = new h.a(this);
        aVar.V(getString(d.a.i0.a.h.aiapps_adb_debug));
        aVar.x(getString(d.a.i0.a.h.aiapps_adb_debug_alert));
        aVar.n(new d.a.i0.a.w2.h.a());
        aVar.m(false);
        aVar.O(d.a.i0.a.h.aiapps_confirm, new b(intent));
        aVar.B(d.a.i0.a.h.swanapp_close, new a());
        aVar.X();
    }
}
