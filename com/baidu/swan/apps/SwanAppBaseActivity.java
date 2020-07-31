package com.baidu.swan.apps;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import com.baidu.swan.apps.ac.c;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes7.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.apps.ak.b bMo = null;
    private com.baidu.swan.apps.ac.c bMp;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState();
            com.baidu.swan.apps.u.a.a.e(Boolean.valueOf(nightModeSwitcherState));
            j(nightModeSwitcherState, false);
            return;
        }
        j(com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState(), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int releaseFixedOrientation = al.releaseFixedOrientation(this);
        super.onCreate(bundle);
        al.fixedOrientation(this, releaseFixedOrientation);
    }

    public void j(boolean z, boolean z2) {
        Window window = getWindow();
        if (window == null) {
            if (DEBUG) {
                Log.e("SwanAppBaseActivity", "activity or window is null");
                return;
            }
            return;
        }
        if (this.bMo == null) {
            this.bMo = new com.baidu.swan.apps.ak.b();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.bMo.y(viewGroup);
        } else {
            this.bMo.z(viewGroup);
        }
        if (z2) {
            com.baidu.swan.apps.process.messaging.a.apw().a(new com.baidu.swan.apps.process.messaging.c(5).eW(true));
        }
    }

    public com.baidu.swan.apps.ak.b So() {
        return this.bMo;
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        this.bMp = com.baidu.swan.apps.ac.c.aoF();
        this.bMp.a(this, i, strArr, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.swan.support.v4.app.a.InterfaceC0475a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.bMp != null) {
            this.bMp.a(this, i, strArr, iArr);
        } else {
            b(i, strArr, iArr);
        }
    }

    public void b(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }
}
