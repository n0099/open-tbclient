package com.baidu.swan.apps;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.b33;
import com.baidu.tieba.er2;
import com.baidu.tieba.ho1;
import com.baidu.tieba.md3;
import com.baidu.tieba.n43;
import com.baidu.tieba.p43;
import com.baidu.tieba.ps2;
import com.baidu.tieba.rl3;
/* loaded from: classes3.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    public static final boolean l = ho1.a;
    public md3 j = null;
    public b33 k;

    public md3 y() {
        return this.j;
    }

    public void A(int i, @NonNull String[] strArr, b33.a aVar) {
        b33 c = b33.c();
        this.k = c;
        c.requestPermissions(this, i, strArr, aVar);
    }

    public void B(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.tieba.hl4.b
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        b33 b33Var = this.k;
        if (b33Var != null) {
            b33Var.f(this, i, strArr, iArr);
        } else {
            B(i, strArr, iArr);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.nl4, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = rl3.c0(this);
        super.onCreate(bundle);
        rl3.g(this, c0);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        boolean a = er2.M().a();
        ps2.e(Boolean.valueOf(a));
        z(a, false);
    }

    public void z(boolean z, boolean z2) {
        Window window = getWindow();
        if (window == null) {
            if (l) {
                Log.e("SwanAppBaseActivity", "activity or window is null");
                return;
            }
            return;
        }
        if (this.j == null) {
            this.j = new md3();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.j.a(viewGroup);
        } else {
            this.j.b(viewGroup);
        }
        if (z2) {
            n43 e = n43.e();
            p43 p43Var = new p43(5);
            p43Var.f(true);
            e.h(p43Var);
        }
    }
}
