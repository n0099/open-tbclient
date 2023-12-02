package com.baidu.swan.apps;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.a33;
import com.baidu.tieba.c33;
import com.baidu.tieba.cr2;
import com.baidu.tieba.ek3;
import com.baidu.tieba.o13;
import com.baidu.tieba.rp2;
import com.baidu.tieba.vm1;
import com.baidu.tieba.zb3;
/* loaded from: classes4.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    public static final boolean l = vm1.a;
    public zb3 j = null;
    public o13 k;

    public zb3 y() {
        return this.j;
    }

    public void A(int i, @NonNull String[] strArr, o13.a aVar) {
        o13 c = o13.c();
        this.k = c;
        c.g(this, i, strArr, aVar);
    }

    public void B(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.tieba.uj4.b
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        o13 o13Var = this.k;
        if (o13Var != null) {
            o13Var.f(this, i, strArr, iArr);
        } else {
            B(i, strArr, iArr);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.zj4, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = ek3.c0(this);
        super.onCreate(bundle);
        ek3.g(this, c0);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        boolean a = rp2.M().a();
        cr2.e(Boolean.valueOf(a));
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
            this.j = new zb3();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.j.a(viewGroup);
        } else {
            this.j.b(viewGroup);
        }
        if (z2) {
            a33 e = a33.e();
            c33 c33Var = new c33(5);
            c33Var.f(true);
            e.h(c33Var);
        }
    }
}
