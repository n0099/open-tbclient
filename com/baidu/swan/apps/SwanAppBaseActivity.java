package com.baidu.swan.apps;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.support.v4.app.FragmentActivity;
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import d.a.h0.a.k1.c;
import d.a.h0.a.n1.c.a;
import d.a.h0.a.x1.b;
/* loaded from: classes.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    public static final boolean DEBUG = k.f43101a;
    public static final String TAG = "SwanAppBaseActivity";
    public c mPermissionHandler;
    public b mSkinDecorator = null;

    public b getSkinDecorator() {
        return this.mSkinDecorator;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, d.a.h0.m.a.a.f, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int V = k0.V(this);
        super.onCreate(bundle);
        k0.h(this, V);
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
            d.a.h0.a.n1.c.c cVar = new d.a.h0.a.n1.c.c(5);
            cVar.f(true);
            e2.h(cVar);
        }
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        boolean a2 = d.a.h0.a.w0.a.z().a();
        d.a.h0.a.y0.c.a.e(Boolean.valueOf(a2));
        onNightModeCoverChanged(a2, false);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, d.a.h0.m.a.a.a.b
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        c cVar = this.mPermissionHandler;
        if (cVar != null) {
            cVar.c(this, i2, strArr, iArr);
        } else {
            superOnRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    public void requestPermissionsExt(int i2, @NonNull String[] strArr, c.a aVar) {
        c b2 = c.b();
        this.mPermissionHandler = b2;
        b2.d(this, i2, strArr, aVar);
    }

    public void superOnRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }
}
