package com.baidu.swan.apps;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.ak3;
import com.baidu.tieba.k13;
import com.baidu.tieba.np2;
import com.baidu.tieba.rm1;
import com.baidu.tieba.vb3;
import com.baidu.tieba.w23;
import com.baidu.tieba.y23;
import com.baidu.tieba.yq2;
/* loaded from: classes4.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    public static final boolean l = rm1.a;
    public vb3 j = null;
    public k13 k;

    public vb3 y() {
        return this.j;
    }

    public void A(int i, @NonNull String[] strArr, k13.a aVar) {
        k13 c = k13.c();
        this.k = c;
        c.g(this, i, strArr, aVar);
    }

    public void B(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.tieba.qj4.b
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        k13 k13Var = this.k;
        if (k13Var != null) {
            k13Var.f(this, i, strArr, iArr);
        } else {
            B(i, strArr, iArr);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.vj4, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = ak3.c0(this);
        super.onCreate(bundle);
        ak3.g(this, c0);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        boolean a = np2.M().a();
        yq2.e(Boolean.valueOf(a));
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
            this.j = new vb3();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.j.a(viewGroup);
        } else {
            this.j.b(viewGroup);
        }
        if (z2) {
            w23 e = w23.e();
            y23 y23Var = new y23(5);
            y23Var.f(true);
            e.h(y23Var);
        }
    }
}
