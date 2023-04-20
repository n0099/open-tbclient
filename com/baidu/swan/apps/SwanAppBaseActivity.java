package com.baidu.swan.apps;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.cr2;
import com.baidu.tieba.fo1;
import com.baidu.tieba.kd3;
import com.baidu.tieba.l43;
import com.baidu.tieba.n43;
import com.baidu.tieba.ns2;
import com.baidu.tieba.pl3;
import com.baidu.tieba.z23;
/* loaded from: classes3.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    public static final boolean l = fo1.a;
    public kd3 j = null;
    public z23 k;

    public kd3 y() {
        return this.j;
    }

    public void A(int i, @NonNull String[] strArr, z23.a aVar) {
        z23 c = z23.c();
        this.k = c;
        c.requestPermissions(this, i, strArr, aVar);
    }

    public void B(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.tieba.fl4.b
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        z23 z23Var = this.k;
        if (z23Var != null) {
            z23Var.f(this, i, strArr, iArr);
        } else {
            B(i, strArr, iArr);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.ll4, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = pl3.c0(this);
        super.onCreate(bundle);
        pl3.g(this, c0);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        boolean a = cr2.M().a();
        ns2.e(Boolean.valueOf(a));
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
            this.j = new kd3();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.j.a(viewGroup);
        } else {
            this.j.b(viewGroup);
        }
        if (z2) {
            l43 e = l43.e();
            n43 n43Var = new n43(5);
            n43Var.f(true);
            e.h(n43Var);
        }
    }
}
