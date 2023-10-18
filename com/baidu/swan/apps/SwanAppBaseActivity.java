package com.baidu.swan.apps;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.am1;
import com.baidu.tieba.eb3;
import com.baidu.tieba.f23;
import com.baidu.tieba.h23;
import com.baidu.tieba.hq2;
import com.baidu.tieba.jj3;
import com.baidu.tieba.t03;
import com.baidu.tieba.wo2;
/* loaded from: classes4.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    public static final boolean l = am1.a;
    public eb3 j = null;
    public t03 k;

    public eb3 x() {
        return this.j;
    }

    public void A(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.tieba.zi4.b
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        t03 t03Var = this.k;
        if (t03Var != null) {
            t03Var.f(this, i, strArr, iArr);
        } else {
            A(i, strArr, iArr);
        }
    }

    public void z(int i, @NonNull String[] strArr, t03.a aVar) {
        t03 c = t03.c();
        this.k = c;
        c.g(this, i, strArr, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.ej4, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = jj3.c0(this);
        super.onCreate(bundle);
        jj3.g(this, c0);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        boolean a = wo2.M().a();
        hq2.e(Boolean.valueOf(a));
        y(a, false);
    }

    public void y(boolean z, boolean z2) {
        Window window = getWindow();
        if (window == null) {
            if (l) {
                Log.e("SwanAppBaseActivity", "activity or window is null");
                return;
            }
            return;
        }
        if (this.j == null) {
            this.j = new eb3();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.j.a(viewGroup);
        } else {
            this.j.b(viewGroup);
        }
        if (z2) {
            f23 e = f23.e();
            h23 h23Var = new h23(5);
            h23Var.f(true);
            e.h(h23Var);
        }
    }
}
