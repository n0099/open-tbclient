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
/* loaded from: classes8.dex */
public class SwanAppErrorActivity extends FragmentActivity {
    public static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.apps.u.c.b bRM;
    private ForbiddenInfo bRN;
    private String bRO;
    private com.baidu.swan.apps.aj.b bRK = null;
    private int mEnterAnimWhenFinishing = 0;
    private int mExitAnimWhenFinishing = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        ae(a.C0331a.aiapps_hold, a.C0331a.aiapps_slide_out_to_bottom);
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ak.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.aiapps_error_activity);
        k(getIntent());
        Yk();
        Ym();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        k(intent);
        Yk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        dq(com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState());
    }

    public void dq(boolean z) {
        Window window = getWindow();
        if (window == null) {
            if (DEBUG) {
                Log.e("SwanAppErrorActivity", "activity or window is null");
                return;
            }
            return;
        }
        if (this.bRK == null) {
            this.bRK = new com.baidu.swan.apps.aj.b();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.bRK.z(viewGroup);
        } else {
            this.bRK.A(viewGroup);
        }
    }

    private void Yk() {
        d dVar;
        m aUY = aUV().aUY();
        if (getIntent() != null) {
            dVar = d.a(this.bRO, this.bRN);
        } else if (this.bRM == null) {
            if (DEBUG) {
                Log.e("SwanAppErrorActivity", "launchInfo is null,error");
                return;
            }
            return;
        } else {
            dVar = new d();
        }
        aUY.a(a.f.ai_apps_error_layout, dVar);
        aUY.commit();
    }

    private void k(Intent intent) {
        if (intent != null) {
            this.bRM = com.baidu.swan.apps.u.c.b.t(intent);
            this.bRN = (ForbiddenInfo) intent.getParcelableExtra("swan_error_forbidden_info");
            if (TextUtils.isEmpty(this.bRM.getAppId()) && this.bRN != null) {
                this.bRM.nB(this.bRN.appId);
            }
            this.bRO = intent.getStringExtra("swan_error_type");
        }
    }

    public com.baidu.swan.apps.u.c.b Yl() {
        return this.bRM;
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

    private void Ym() {
        com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
    }
}
