package com.baidu.swan.apps;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes11.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.apps.ak.b bLR = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        j(com.baidu.swan.apps.u.a.ags().getNightModeSwitcherState(), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int releaseFixedOrientation = aj.releaseFixedOrientation(this);
        super.onCreate(bundle);
        aj.fixedOrientation(this, releaseFixedOrientation);
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
        if (this.bLR == null) {
            this.bLR = new com.baidu.swan.apps.ak.b();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.bLR.x(viewGroup);
        } else {
            this.bLR.y(viewGroup);
        }
        if (z2) {
            com.baidu.swan.apps.process.messaging.a.anM().a(new com.baidu.swan.apps.process.messaging.c(5).eN(true));
        }
    }

    public com.baidu.swan.apps.ak.b RZ() {
        return this.bLR;
    }
}
