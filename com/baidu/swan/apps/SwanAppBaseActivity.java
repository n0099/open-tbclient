package com.baidu.swan.apps;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.support.v4.app.FragmentActivity;
/* loaded from: classes9.dex */
public class SwanAppBaseActivity extends FragmentActivity {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.apps.am.b aVO = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        h(com.baidu.swan.apps.w.a.RG().getNightModeSwitcherState(), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int releaseFixedOrientation = ai.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ai.fixedOrientation(this, releaseFixedOrientation);
    }

    public void h(boolean z, boolean z2) {
        Window window = getWindow();
        if (window == null) {
            if (DEBUG) {
                Log.e("SwanAppBaseActivity", "activity or window is null");
                return;
            }
            return;
        }
        if (this.aVO == null) {
            this.aVO = new com.baidu.swan.apps.am.b();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.aVO.m(viewGroup);
        } else {
            this.aVO.n(viewGroup);
        }
        if (z2) {
            com.baidu.swan.apps.process.messaging.a.XY().a(new com.baidu.swan.apps.process.messaging.c(5).dg(true));
        }
    }

    public com.baidu.swan.apps.am.b Ed() {
        return this.aVO;
    }
}
