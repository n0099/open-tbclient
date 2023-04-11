package com.baidu.swan.apps.console.debugger.adbdebug;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.cn3;
import com.baidu.tieba.eo1;
import com.baidu.tieba.m73;
import com.baidu.tieba.tk3;
import com.baidu.tieba.y63;
/* loaded from: classes3.dex */
public class SwanAppAdbDebugActivity extends Activity {
    public static final boolean a = eo1.a;

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
        if (tk3.a(this)) {
            return;
        }
        Intent intent = getIntent();
        if (TextUtils.isEmpty(intent.getStringExtra("adb_debug_path"))) {
            m73.f(this, R.string.obfuscated_res_0x7f0f0104).G();
            if (a) {
                Log.d("SwanAppAdbDebugActivity", "ADB Debug lack of app path");
            }
            finish();
        }
        y63.a aVar = new y63.a(this);
        aVar.V(getString(R.string.obfuscated_res_0x7f0f0102));
        aVar.x(getString(R.string.obfuscated_res_0x7f0f0103));
        aVar.n(new cn3());
        aVar.m(false);
        aVar.O(R.string.obfuscated_res_0x7f0f011c, new b(intent));
        aVar.B(R.string.obfuscated_res_0x7f0f138f, new a());
        aVar.X();
    }
}
