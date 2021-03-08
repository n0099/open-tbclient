package com.baidu.swan.apps;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.ab.c;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes8.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.apps.ai.b cDH = null;
    private com.baidu.swan.apps.ab.c cDI;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        boolean ail = com.baidu.swan.apps.t.a.axv().ail();
        com.baidu.swan.apps.u.a.a.i(Boolean.valueOf(ail));
        l(ail, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ak.fixedOrientation(this, releaseFixedOrientation);
    }

    public void l(boolean z, boolean z2) {
        Window window = getWindow();
        if (window == null) {
            if (DEBUG) {
                Log.e("SwanAppBaseActivity", "activity or window is null");
                return;
            }
            return;
        }
        if (this.cDH == null) {
            this.cDH = new com.baidu.swan.apps.ai.b();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.cDH.H(viewGroup);
        } else {
            this.cDH.I(viewGroup);
        }
        if (z2) {
            com.baidu.swan.apps.process.messaging.a.aFC().a(new com.baidu.swan.apps.process.messaging.c(5).gF(true));
        }
    }

    public com.baidu.swan.apps.ai.b agm() {
        return this.cDH;
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        this.cDI = com.baidu.swan.apps.ab.c.aEO();
        this.cDI.a(this, i, strArr, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.swan.support.v4.app.a.InterfaceC0546a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.cDI != null) {
            this.cDI.b(this, i, strArr, iArr);
        } else {
            b(i, strArr, iArr);
        }
    }

    public void b(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }
}
