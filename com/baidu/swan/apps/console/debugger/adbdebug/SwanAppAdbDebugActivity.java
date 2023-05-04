package com.baidu.swan.apps.console.debugger.adbdebug;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.b73;
import com.baidu.tieba.fn3;
import com.baidu.tieba.ho1;
import com.baidu.tieba.p73;
import com.baidu.tieba.wk3;
/* loaded from: classes3.dex */
public class SwanAppAdbDebugActivity extends Activity {
    public static final boolean a = ho1.a;

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
        if (wk3.a(this)) {
            return;
        }
        Intent intent = getIntent();
        if (TextUtils.isEmpty(intent.getStringExtra("adb_debug_path"))) {
            p73.f(this, R.string.obfuscated_res_0x7f0f0102).G();
            if (a) {
                Log.d("SwanAppAdbDebugActivity", "ADB Debug lack of app path");
            }
            finish();
        }
        b73.a aVar = new b73.a(this);
        aVar.V(getString(R.string.obfuscated_res_0x7f0f0100));
        aVar.x(getString(R.string.obfuscated_res_0x7f0f0101));
        aVar.n(new fn3());
        aVar.m(false);
        aVar.O(R.string.obfuscated_res_0x7f0f011a, new b(intent));
        aVar.B(R.string.obfuscated_res_0x7f0f13a8, new a());
        aVar.X();
    }
}
