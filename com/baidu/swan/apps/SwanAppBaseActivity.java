package com.baidu.swan.apps;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.cv2;
import com.baidu.tieba.fs1;
import com.baidu.tieba.kh3;
import com.baidu.tieba.l83;
import com.baidu.tieba.n83;
import com.baidu.tieba.nw2;
import com.baidu.tieba.pp3;
import com.baidu.tieba.z63;
/* loaded from: classes4.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    public static final boolean l = fs1.a;
    public kh3 j = null;
    public z63 k;

    public kh3 x() {
        return this.j;
    }

    public void A(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.tieba.fp4.b
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        z63 z63Var = this.k;
        if (z63Var != null) {
            z63Var.f(this, i, strArr, iArr);
        } else {
            A(i, strArr, iArr);
        }
    }

    public void z(int i, @NonNull String[] strArr, z63.a aVar) {
        z63 c = z63.c();
        this.k = c;
        c.requestPermissions(this, i, strArr, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.lp4, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = pp3.c0(this);
        super.onCreate(bundle);
        pp3.g(this, c0);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        boolean a = cv2.M().a();
        nw2.e(Boolean.valueOf(a));
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
            this.j = new kh3();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.j.a(viewGroup);
        } else {
            this.j.b(viewGroup);
        }
        if (z2) {
            l83 e = l83.e();
            n83 n83Var = new n83(5);
            n83Var.f(true);
            e.h(n83Var);
        }
    }
}
