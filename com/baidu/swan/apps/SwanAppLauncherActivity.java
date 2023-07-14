package com.baidu.swan.apps;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.tieba.fs1;
import com.baidu.tieba.mp3;
import com.baidu.tieba.pp3;
import com.baidu.tieba.ub3;
import com.baidu.tieba.uo3;
import com.baidu.tieba.w63;
@Autowired
/* loaded from: classes4.dex */
public class SwanAppLauncherActivity extends Activity {
    public static final boolean b = fs1.a;
    public Object a;

    /* loaded from: classes4.dex */
    public class a implements w63.b {
        public a() {
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppLauncherActivity.this.finish();
        }
    }

    @Inject(force = false)
    public w63 a() {
        return w63.a;
    }

    public final void b() {
        SwanLauncher.j().m(getIntent().getExtras());
        ub3.M().post(new b());
    }

    @Override // android.app.Activity
    public void onDestroy() {
        a().f(this, this.a);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        a().d(this, this.a);
    }

    @Override // android.app.Activity
    @DebugTrace
    public void onCreate(Bundle bundle) {
        String str;
        int c0 = pp3.c0(this);
        super.onCreate(bundle);
        pp3.g(this, c0);
        mp3.b(this);
        if (b) {
            Log.d("SwanAppLauncherActivity", "onCreate");
        }
        if (uo3.a(this)) {
            return;
        }
        if (getIntent() != null) {
            str = getIntent().getStringExtra("mAppId");
        } else {
            str = "";
        }
        a().a(str);
        if (a().b()) {
            this.a = a().c(this, str, new a(), true);
        } else {
            b();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (a().e(this, i, strArr, iArr, this.a)) {
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }
}
