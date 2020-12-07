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
/* loaded from: classes25.dex */
public class SwanAppErrorActivity extends FragmentActivity {
    public static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.apps.u.c.b czL;
    private ForbiddenInfo czM;
    private String czN;
    private com.baidu.swan.apps.aj.b czJ = null;
    private int mEnterAnimWhenFinishing = 0;
    private int mExitAnimWhenFinishing = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        ag(a.C0379a.aiapps_hold, a.C0379a.aiapps_slide_out_to_bottom);
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ak.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.aiapps_error_activity);
        k(getIntent());
        aiz();
        aiB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        k(intent);
        aiz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ez(com.baidu.swan.apps.t.a.azw().getNightModeSwitcherState());
    }

    public void ez(boolean z) {
        Window window = getWindow();
        if (window == null) {
            if (DEBUG) {
                Log.e("SwanAppErrorActivity", "activity or window is null");
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
    }

    private void aiz() {
        d dVar;
        m bfk = bfh().bfk();
        if (getIntent() != null) {
            dVar = d.a(this.czN, this.czM);
        } else if (this.czL == null) {
            if (DEBUG) {
                Log.e("SwanAppErrorActivity", "launchInfo is null,error");
                return;
            }
            return;
        } else {
            dVar = new d();
        }
        bfk.a(a.f.ai_apps_error_layout, dVar);
        bfk.commit();
    }

    private void k(Intent intent) {
        if (intent != null) {
            this.czL = com.baidu.swan.apps.u.c.b.t(intent);
            this.czM = (ForbiddenInfo) intent.getParcelableExtra("swan_error_forbidden_info");
            if (TextUtils.isEmpty(this.czL.getAppId()) && this.czM != null) {
                this.czL.pR(this.czM.appId);
            }
            this.czN = intent.getStringExtra("swan_error_type");
        }
    }

    public com.baidu.swan.apps.u.c.b aiA() {
        return this.czL;
    }

    private void ag(int i, int i2) {
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

    private void aiB() {
        com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
    }
}
