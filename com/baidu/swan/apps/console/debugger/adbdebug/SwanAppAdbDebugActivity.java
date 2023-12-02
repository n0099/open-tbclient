package com.baidu.swan.apps.console.debugger.adbdebug;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.c63;
import com.baidu.tieba.jj3;
import com.baidu.tieba.o53;
import com.baidu.tieba.sl3;
import com.baidu.tieba.vm1;
/* loaded from: classes4.dex */
public class SwanAppAdbDebugActivity extends Activity {
    public static final boolean a = vm1.a;

    /* loaded from: classes4.dex */
    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            SwanAppAdbDebugActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ Intent a;

        public b(Intent intent) {
            this.a = intent;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.a.setClass(SwanAppAdbDebugActivity.this, SwanAppLauncherActivity.class);
            SwanAppAdbDebugActivity.this.startActivity(this.a);
            SwanAppAdbDebugActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (a) {
            Log.d("SwanAppAdbDebugActivity", "ADB Debug onCreate");
        }
        if (jj3.a(this)) {
            return;
        }
        Intent intent = getIntent();
        if (TextUtils.isEmpty(intent.getStringExtra("adb_debug_path"))) {
            c63.f(this, R.string.obfuscated_res_0x7f0f0139).G();
            if (a) {
                Log.d("SwanAppAdbDebugActivity", "ADB Debug lack of app path");
            }
            finish();
        }
        o53.a aVar = new o53.a(this);
        aVar.V(getString(R.string.obfuscated_res_0x7f0f0137));
        aVar.x(getString(R.string.obfuscated_res_0x7f0f0138));
        aVar.n(new sl3());
        aVar.m(false);
        aVar.O(R.string.obfuscated_res_0x7f0f0151, new b(intent));
        aVar.B(R.string.obfuscated_res_0x7f0f156a, new a());
        aVar.X();
    }
}
