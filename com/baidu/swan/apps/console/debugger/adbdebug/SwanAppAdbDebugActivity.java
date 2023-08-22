package com.baidu.swan.apps.console.debugger.adbdebug;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.co3;
import com.baidu.tieba.ha3;
import com.baidu.tieba.lq3;
import com.baidu.tieba.nr1;
import com.baidu.tieba.va3;
/* loaded from: classes4.dex */
public class SwanAppAdbDebugActivity extends Activity {
    public static final boolean a = nr1.a;

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
        if (co3.a(this)) {
            return;
        }
        Intent intent = getIntent();
        if (TextUtils.isEmpty(intent.getStringExtra("adb_debug_path"))) {
            va3.f(this, R.string.obfuscated_res_0x7f0f012f).G();
            if (a) {
                Log.d("SwanAppAdbDebugActivity", "ADB Debug lack of app path");
            }
            finish();
        }
        ha3.a aVar = new ha3.a(this);
        aVar.V(getString(R.string.obfuscated_res_0x7f0f012d));
        aVar.x(getString(R.string.obfuscated_res_0x7f0f012e));
        aVar.n(new lq3());
        aVar.m(false);
        aVar.O(R.string.obfuscated_res_0x7f0f0147, new b(intent));
        aVar.B(R.string.obfuscated_res_0x7f0f1515, new a());
        aVar.X();
    }
}
