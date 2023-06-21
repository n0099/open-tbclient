package com.baidu.swan.apps;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.d73;
import com.baidu.tieba.gv2;
import com.baidu.tieba.js1;
import com.baidu.tieba.oh3;
import com.baidu.tieba.p83;
import com.baidu.tieba.r83;
import com.baidu.tieba.rw2;
import com.baidu.tieba.tp3;
/* loaded from: classes4.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    public static final boolean l = js1.a;
    public oh3 j = null;
    public d73 k;

    public oh3 x() {
        return this.j;
    }

    public void A(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.tieba.jp4.b
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        d73 d73Var = this.k;
        if (d73Var != null) {
            d73Var.f(this, i, strArr, iArr);
        } else {
            A(i, strArr, iArr);
        }
    }

    public void z(int i, @NonNull String[] strArr, d73.a aVar) {
        d73 c = d73.c();
        this.k = c;
        c.requestPermissions(this, i, strArr, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.pp4, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = tp3.c0(this);
        super.onCreate(bundle);
        tp3.g(this, c0);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        boolean a = gv2.M().a();
        rw2.e(Boolean.valueOf(a));
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
            this.j = new oh3();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.j.a(viewGroup);
        } else {
            this.j.b(viewGroup);
        }
        if (z2) {
            p83 e = p83.e();
            r83 r83Var = new r83(5);
            r83Var.f(true);
            e.h(r83Var);
        }
    }
}
