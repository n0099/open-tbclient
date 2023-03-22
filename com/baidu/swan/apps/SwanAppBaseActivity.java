package com.baidu.swan.apps;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.ar2;
import com.baidu.tieba.do1;
import com.baidu.tieba.id3;
import com.baidu.tieba.j43;
import com.baidu.tieba.l43;
import com.baidu.tieba.ls2;
import com.baidu.tieba.nl3;
import com.baidu.tieba.x23;
/* loaded from: classes3.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    public static final boolean l = do1.a;
    public id3 j = null;
    public x23 k;

    public id3 y() {
        return this.j;
    }

    public void A(int i, @NonNull String[] strArr, x23.a aVar) {
        x23 c = x23.c();
        this.k = c;
        c.requestPermissions(this, i, strArr, aVar);
    }

    public void B(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.tieba.dl4.b
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        x23 x23Var = this.k;
        if (x23Var != null) {
            x23Var.f(this, i, strArr, iArr);
        } else {
            B(i, strArr, iArr);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.jl4, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = nl3.c0(this);
        super.onCreate(bundle);
        nl3.g(this, c0);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        boolean a = ar2.M().a();
        ls2.e(Boolean.valueOf(a));
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
            this.j = new id3();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.j.a(viewGroup);
        } else {
            this.j.b(viewGroup);
        }
        if (z2) {
            j43 e = j43.e();
            l43 l43Var = new l43(5);
            l43Var.f(true);
            e.h(l43Var);
        }
    }
}
