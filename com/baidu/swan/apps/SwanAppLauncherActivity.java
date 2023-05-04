package com.baidu.swan.apps;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.tieba.ho1;
import com.baidu.tieba.ol3;
import com.baidu.tieba.rl3;
import com.baidu.tieba.w73;
import com.baidu.tieba.wk3;
import com.baidu.tieba.y23;
@Autowired
/* loaded from: classes3.dex */
public class SwanAppLauncherActivity extends Activity {
    public static final boolean b = ho1.a;
    public Object a;

    /* loaded from: classes3.dex */
    public class a implements y23.b {
        public a() {
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppLauncherActivity.this.finish();
        }
    }

    @Inject(force = false)
    public y23 a() {
        return y23.a;
    }

    public final void b() {
        SwanLauncher.j().m(getIntent().getExtras());
        w73.M().post(new b());
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
        int c0 = rl3.c0(this);
        super.onCreate(bundle);
        rl3.g(this, c0);
        ol3.b(this);
        if (b) {
            Log.d("SwanAppLauncherActivity", "onCreate");
        }
        if (wk3.a(this)) {
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
