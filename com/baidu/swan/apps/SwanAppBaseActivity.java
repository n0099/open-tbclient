package com.baidu.swan.apps;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.bk3;
import com.baidu.tieba.l13;
import com.baidu.tieba.op2;
import com.baidu.tieba.sm1;
import com.baidu.tieba.wb3;
import com.baidu.tieba.x23;
import com.baidu.tieba.z23;
import com.baidu.tieba.zq2;
/* loaded from: classes4.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    public static final boolean l = sm1.a;
    public wb3 j = null;
    public l13 k;

    public wb3 y() {
        return this.j;
    }

    public void A(int i, @NonNull String[] strArr, l13.a aVar) {
        l13 c = l13.c();
        this.k = c;
        c.g(this, i, strArr, aVar);
    }

    public void B(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.tieba.rj4.b
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        l13 l13Var = this.k;
        if (l13Var != null) {
            l13Var.f(this, i, strArr, iArr);
        } else {
            B(i, strArr, iArr);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.wj4, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = bk3.c0(this);
        super.onCreate(bundle);
        bk3.g(this, c0);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        boolean a = op2.M().a();
        zq2.e(Boolean.valueOf(a));
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
            this.j = new wb3();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.j.a(viewGroup);
        } else {
            this.j.b(viewGroup);
        }
        if (z2) {
            x23 e = x23.e();
            z23 z23Var = new z23(5);
            z23Var.f(true);
            e.h(z23Var);
        }
    }
}
