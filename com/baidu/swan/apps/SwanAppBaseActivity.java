package com.baidu.swan.apps;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.support.v4.app.FragmentActivity;
import d.a.l0.a.g2.b;
import d.a.l0.a.k;
import d.a.l0.a.s1.g;
import d.a.l0.a.v1.c.a;
import d.a.l0.a.v1.c.c;
import d.a.l0.a.v2.q0;
/* loaded from: classes2.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    public static final boolean DEBUG = k.f43199a;
    public static final String TAG = "SwanAppBaseActivity";
    public g mPermissionHandler;
    public b mSkinDecorator = null;

    public b getSkinDecorator() {
        return this.mSkinDecorator;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, d.a.l0.o.a.a.f, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int Z = q0.Z(this);
        super.onCreate(bundle);
        q0.g(this, Z);
    }

    public void onNightModeCoverChanged(boolean z, boolean z2) {
        Window window = getWindow();
        if (window == null) {
            if (DEBUG) {
                Log.e(TAG, "activity or window is null");
                return;
            }
            return;
        }
        if (this.mSkinDecorator == null) {
            this.mSkinDecorator = new b();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.mSkinDecorator.a(viewGroup);
        } else {
            this.mSkinDecorator.b(viewGroup);
        }
        if (z2) {
            a e2 = a.e();
            c cVar = new c(5);
            cVar.f(true);
            e2.h(cVar);
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        boolean a2 = d.a.l0.a.c1.a.H().a();
        d.a.l0.a.f1.c.a.e(Boolean.valueOf(a2));
        onNightModeCoverChanged(a2, false);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, d.a.l0.o.a.a.a.b
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        g gVar = this.mPermissionHandler;
        if (gVar != null) {
            gVar.f(this, i2, strArr, iArr);
        } else {
            superOnRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    public void requestPermissionsExt(int i2, @NonNull String[] strArr, g.a aVar) {
        g c2 = g.c();
        this.mPermissionHandler = c2;
        c2.g(this, i2, strArr, aVar);
    }

    public void superOnRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }
}
