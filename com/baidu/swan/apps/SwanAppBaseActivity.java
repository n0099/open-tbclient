package com.baidu.swan.apps;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.bp3;
import com.baidu.tieba.l63;
import com.baidu.tieba.ou2;
import com.baidu.tieba.rr1;
import com.baidu.tieba.wg3;
import com.baidu.tieba.x73;
import com.baidu.tieba.z73;
import com.baidu.tieba.zv2;
/* loaded from: classes4.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    public static final boolean l = rr1.a;
    public wg3 j = null;
    public l63 k;

    public wg3 x() {
        return this.j;
    }

    public void A(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.tieba.ro4.b
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        l63 l63Var = this.k;
        if (l63Var != null) {
            l63Var.f(this, i, strArr, iArr);
        } else {
            A(i, strArr, iArr);
        }
    }

    public void z(int i, @NonNull String[] strArr, l63.a aVar) {
        l63 c = l63.c();
        this.k = c;
        c.requestPermissions(this, i, strArr, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.xo4, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = bp3.c0(this);
        super.onCreate(bundle);
        bp3.g(this, c0);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        boolean a = ou2.M().a();
        zv2.e(Boolean.valueOf(a));
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
            this.j = new wg3();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.j.a(viewGroup);
        } else {
            this.j.b(viewGroup);
        }
        if (z2) {
            x73 e = x73.e();
            z73 z73Var = new z73(5);
            z73Var.f(true);
            e.h(z73Var);
        }
    }
}
