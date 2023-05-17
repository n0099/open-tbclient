package com.baidu.swan.apps;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.an3;
import com.baidu.tieba.k43;
import com.baidu.tieba.ns2;
import com.baidu.tieba.qp1;
import com.baidu.tieba.ve3;
import com.baidu.tieba.w53;
import com.baidu.tieba.y53;
import com.baidu.tieba.yt2;
/* loaded from: classes4.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    public static final boolean l = qp1.a;
    public ve3 j = null;
    public k43 k;

    public ve3 y() {
        return this.j;
    }

    public void A(int i, @NonNull String[] strArr, k43.a aVar) {
        k43 c = k43.c();
        this.k = c;
        c.requestPermissions(this, i, strArr, aVar);
    }

    public void B(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.tieba.qm4.b
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        k43 k43Var = this.k;
        if (k43Var != null) {
            k43Var.f(this, i, strArr, iArr);
        } else {
            B(i, strArr, iArr);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.wm4, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = an3.c0(this);
        super.onCreate(bundle);
        an3.g(this, c0);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        boolean a = ns2.M().a();
        yt2.e(Boolean.valueOf(a));
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
            this.j = new ve3();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.j.a(viewGroup);
        } else {
            this.j.b(viewGroup);
        }
        if (z2) {
            w53 e = w53.e();
            y53 y53Var = new y53(5);
            y53Var.f(true);
            e.h(y53Var);
        }
    }
}
