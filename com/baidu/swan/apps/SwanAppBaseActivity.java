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
/* loaded from: classes25.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.apps.aj.b czJ = null;
    private com.baidu.swan.apps.ab.c czK;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.azw().getNightModeSwitcherState();
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
        if (this.czJ == null) {
            this.czJ = new com.baidu.swan.apps.aj.b();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.czJ.C(viewGroup);
        } else {
            this.czJ.D(viewGroup);
        }
        if (z2) {
            com.baidu.swan.apps.process.messaging.a.aHE().a(new com.baidu.swan.apps.process.messaging.c(5).gy(true));
        }
    }

    public com.baidu.swan.apps.aj.b aiy() {
        return this.czJ;
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        this.czK = com.baidu.swan.apps.ab.c.aGQ();
        this.czK.a(this, i, strArr, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.swan.support.v4.app.a.InterfaceC0569a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.czK != null) {
            this.czK.a(this, i, strArr, iArr);
        } else {
            b(i, strArr, iArr);
        }
    }

    public void b(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }
}
