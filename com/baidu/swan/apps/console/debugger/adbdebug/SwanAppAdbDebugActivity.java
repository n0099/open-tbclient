package com.baidu.swan.apps.console.debugger.adbdebug;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import d.a.h0.a.h;
import d.a.h0.a.i2.u;
import d.a.h0.a.k;
import d.a.h0.a.q1.b.b.g;
import d.a.h0.a.q1.b.f.d;
/* loaded from: classes2.dex */
public class SwanAppAdbDebugActivity extends Activity {
    public static final boolean DEBUG = k.f43101a;
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
        public final /* synthetic */ Intent f11632e;

        public b(Intent intent) {
            this.f11632e = intent;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            this.f11632e.setClass(SwanAppAdbDebugActivity.this, SwanAppLauncherActivity.class);
            SwanAppAdbDebugActivity.this.startActivity(this.f11632e);
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
        aVar.n(new d.a.h0.a.j2.g.a());
        aVar.m(false);
        aVar.O(h.aiapps_confirm, new b(intent));
        aVar.C(h.aiapps_adb_debug_close, new a());
        aVar.X();
    }
}
