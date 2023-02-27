package com.baidu.swan.apps;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.bf3;
import com.baidu.tieba.c63;
import com.baidu.tieba.e63;
import com.baidu.tieba.eu2;
import com.baidu.tieba.gn3;
import com.baidu.tieba.q43;
import com.baidu.tieba.ts2;
import com.baidu.tieba.wp1;
/* loaded from: classes3.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    public static final boolean l = wp1.a;
    public bf3 j = null;
    public q43 k;

    public bf3 w() {
        return this.j;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.cn4, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = gn3.c0(this);
        super.onCreate(bundle);
        gn3.g(this, c0);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        boolean a = ts2.M().a();
        eu2.e(Boolean.valueOf(a));
        x(a, false);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.tieba.wm4.b
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        q43 q43Var = this.k;
        if (q43Var != null) {
            q43Var.f(this, i, strArr, iArr);
        } else {
            z(i, strArr, iArr);
        }
    }

    public void y(int i, @NonNull String[] strArr, q43.a aVar) {
        q43 c = q43.c();
        this.k = c;
        c.requestPermissions(this, i, strArr, aVar);
    }

    public void z(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void x(boolean z, boolean z2) {
        Window window = getWindow();
        if (window == null) {
            if (l) {
                Log.e("SwanAppBaseActivity", "activity or window is null");
                return;
            }
            return;
        }
        if (this.j == null) {
            this.j = new bf3();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.j.a(viewGroup);
        } else {
            this.j.b(viewGroup);
        }
        if (z2) {
            c63 e = c63.e();
            e63 e63Var = new e63(5);
            e63Var.f(true);
            e.h(e63Var);
        }
    }
}
