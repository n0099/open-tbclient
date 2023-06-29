package com.baidu.swan.apps;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.g73;
import com.baidu.tieba.jv2;
import com.baidu.tieba.ms1;
import com.baidu.tieba.rh3;
import com.baidu.tieba.s83;
import com.baidu.tieba.u83;
import com.baidu.tieba.uw2;
import com.baidu.tieba.wp3;
/* loaded from: classes4.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    public static final boolean l = ms1.a;
    public rh3 j = null;
    public g73 k;

    public rh3 x() {
        return this.j;
    }

    public void A(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.tieba.mp4.b
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        g73 g73Var = this.k;
        if (g73Var != null) {
            g73Var.f(this, i, strArr, iArr);
        } else {
            A(i, strArr, iArr);
        }
    }

    public void z(int i, @NonNull String[] strArr, g73.a aVar) {
        g73 c = g73.c();
        this.k = c;
        c.requestPermissions(this, i, strArr, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.sp4, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = wp3.c0(this);
        super.onCreate(bundle);
        wp3.g(this, c0);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        boolean a = jv2.M().a();
        uw2.e(Boolean.valueOf(a));
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
            this.j = new rh3();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.j.a(viewGroup);
        } else {
            this.j.b(viewGroup);
        }
        if (z2) {
            s83 e = s83.e();
            u83 u83Var = new u83(5);
            u83Var.f(true);
            e.h(u83Var);
        }
    }
}
