package com.baidu.swan.apps;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.br2;
import com.baidu.tieba.eo1;
import com.baidu.tieba.jd3;
import com.baidu.tieba.k43;
import com.baidu.tieba.m43;
import com.baidu.tieba.ms2;
import com.baidu.tieba.ol3;
import com.baidu.tieba.y23;
/* loaded from: classes3.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    public static final boolean l = eo1.a;
    public jd3 j = null;
    public y23 k;

    public jd3 y() {
        return this.j;
    }

    public void A(int i, @NonNull String[] strArr, y23.a aVar) {
        y23 c = y23.c();
        this.k = c;
        c.requestPermissions(this, i, strArr, aVar);
    }

    public void B(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.tieba.el4.b
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        y23 y23Var = this.k;
        if (y23Var != null) {
            y23Var.f(this, i, strArr, iArr);
        } else {
            B(i, strArr, iArr);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.kl4, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = ol3.c0(this);
        super.onCreate(bundle);
        ol3.g(this, c0);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        boolean a = br2.M().a();
        ms2.e(Boolean.valueOf(a));
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
            this.j = new jd3();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.j.a(viewGroup);
        } else {
            this.j.b(viewGroup);
        }
        if (z2) {
            k43 e = k43.e();
            m43 m43Var = new m43(5);
            m43Var.f(true);
            e.h(m43Var);
        }
    }
}
