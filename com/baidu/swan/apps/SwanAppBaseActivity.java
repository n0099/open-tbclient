package com.baidu.swan.apps;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.h63;
import com.baidu.tieba.ku2;
import com.baidu.tieba.nr1;
import com.baidu.tieba.sg3;
import com.baidu.tieba.t73;
import com.baidu.tieba.v73;
import com.baidu.tieba.vv2;
import com.baidu.tieba.xo3;
/* loaded from: classes4.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    public static final boolean l = nr1.a;
    public sg3 j = null;
    public h63 k;

    public sg3 x() {
        return this.j;
    }

    public void A(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.tieba.no4.b
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        h63 h63Var = this.k;
        if (h63Var != null) {
            h63Var.f(this, i, strArr, iArr);
        } else {
            A(i, strArr, iArr);
        }
    }

    public void z(int i, @NonNull String[] strArr, h63.a aVar) {
        h63 c = h63.c();
        this.k = c;
        c.requestPermissions(this, i, strArr, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.to4, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = xo3.c0(this);
        super.onCreate(bundle);
        xo3.g(this, c0);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        boolean a = ku2.M().a();
        vv2.e(Boolean.valueOf(a));
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
            this.j = new sg3();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.j.a(viewGroup);
        } else {
            this.j.b(viewGroup);
        }
        if (z2) {
            t73 e = t73.e();
            v73 v73Var = new v73(5);
            v73Var.f(true);
            e.h(v73Var);
        }
    }
}
