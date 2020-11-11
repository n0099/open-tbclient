package com.baidu.swan.apps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.d.d;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.swan.support.v4.app.m;
/* loaded from: classes10.dex */
public class SwanAppErrorActivity extends FragmentActivity {
    public static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.apps.u.c.b cuD;
    private ForbiddenInfo cuE;
    private String cuF;
    private com.baidu.swan.apps.aj.b cuB = null;
    private int mEnterAnimWhenFinishing = 0;
    private int mExitAnimWhenFinishing = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        ae(a.C0369a.aiapps_hold, a.C0369a.aiapps_slide_out_to_bottom);
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ak.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.aiapps_error_activity);
        k(getIntent());
        afZ();
        agb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        k(intent);
        afZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        eh(com.baidu.swan.apps.t.a.awW().getNightModeSwitcherState());
    }

    public void eh(boolean z) {
        Window window = getWindow();
        if (window == null) {
            if (DEBUG) {
                Log.e("SwanAppErrorActivity", "activity or window is null");
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
    }

    private void afZ() {
        d dVar;
        m bcM = bcJ().bcM();
        if (getIntent() != null) {
            dVar = d.a(this.cuF, this.cuE);
        } else if (this.cuD == null) {
            if (DEBUG) {
                Log.e("SwanAppErrorActivity", "launchInfo is null,error");
                return;
            }
            return;
        } else {
            dVar = new d();
        }
        bcM.a(a.f.ai_apps_error_layout, dVar);
        bcM.commit();
    }

    private void k(Intent intent) {
        if (intent != null) {
            this.cuD = com.baidu.swan.apps.u.c.b.t(intent);
            this.cuE = (ForbiddenInfo) intent.getParcelableExtra("swan_error_forbidden_info");
            if (TextUtils.isEmpty(this.cuD.getAppId()) && this.cuE != null) {
                this.cuD.pq(this.cuE.appId);
            }
            this.cuF = intent.getStringExtra("swan_error_type");
        }
    }

    public com.baidu.swan.apps.u.c.b aga() {
        return this.cuD;
    }

    private void ae(int i, int i2) {
        this.mEnterAnimWhenFinishing = i;
        this.mExitAnimWhenFinishing = i2;
    }

    private void startExitActivityAnim() {
        if (this.mEnterAnimWhenFinishing != 0 || this.mExitAnimWhenFinishing != 0) {
            overridePendingTransition(this.mEnterAnimWhenFinishing, this.mExitAnimWhenFinishing);
            this.mEnterAnimWhenFinishing = 0;
            this.mExitAnimWhenFinishing = 0;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        startExitActivityAnim();
    }

    private void agb() {
        com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
    }
}
