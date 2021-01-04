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
/* loaded from: classes9.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.apps.ai.b cEx = null;
    private com.baidu.swan.apps.ab.c cEy;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        boolean alD = com.baidu.swan.apps.t.a.aAN().alD();
        com.baidu.swan.apps.u.a.a.i(Boolean.valueOf(alD));
        k(alD, false);
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
        if (this.cEx == null) {
            this.cEx = new com.baidu.swan.apps.ai.b();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.cEx.J(viewGroup);
        } else {
            this.cEx.K(viewGroup);
        }
        if (z2) {
            com.baidu.swan.apps.process.messaging.a.aIX().a(new com.baidu.swan.apps.process.messaging.c(5).gH(true));
        }
    }

    public com.baidu.swan.apps.ai.b ajE() {
        return this.cEx;
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        this.cEy = com.baidu.swan.apps.ab.c.aIj();
        this.cEy.a(this, i, strArr, aVar);
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity, com.baidu.swan.support.v4.app.a.InterfaceC0560a
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.cEy != null) {
            this.cEy.b(this, i, strArr, iArr);
        } else {
            b(i, strArr, iArr);
        }
    }

    public void b(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }
}
