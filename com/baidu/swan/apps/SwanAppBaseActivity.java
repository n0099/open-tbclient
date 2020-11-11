package com.baidu.swan.apps;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import com.baidu.swan.apps.ab.c;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes10.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.apps.aj.b cuB = null;
    private com.baidu.swan.apps.ab.c cuC;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.awW().getNightModeSwitcherState();
        com.baidu.swan.apps.u.a.a.h(Boolean.valueOf(nightModeSwitcherState));
        k(nightModeSwitcherState, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ak.fixedOrientation(this, releaseFixedOrientation);
    }

    public void k(boolean z, boolean z2) {
        Window window = getWindow();
        if (window == null) {
            if (DEBUG) {
                Log.e("SwanAppBaseActivity", "activity or window is null");
                return;
            }
            return;
        }
        if (this.cuB == null) {
            this.cuB = new com.baidu.swan.apps.aj.b();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.cuB.G(viewGroup);
        } else {
            this.cuB.H(viewGroup);
        }
        if (z2) {
            com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(5).gg(true));
        }
    }

    public com.baidu.swan.apps.aj.b afY() {
        return this.cuB;
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        this.cuC = com.baidu.swan.apps.ab.c.aEq();
        this.cuC.a(this, i, strArr, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.swan.support.v4.app.a.InterfaceC0559a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.cuC != null) {
            this.cuC.a(this, i, strArr, iArr);
        } else {
            b(i, strArr, iArr);
        }
    }

    public void b(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }
}
