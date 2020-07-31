package com.baidu.swan.apps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.core.d.d;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.swan.support.v4.app.m;
/* loaded from: classes7.dex */
public class SwanAppErrorActivity extends FragmentActivity {
    public static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.apps.u.c.b bMq;
    private ForbiddenInfo bMr;
    private String bMs;
    private com.baidu.swan.apps.ak.b bMo = null;
    private int mEnterAnimWhenFinishing = 0;
    private int mExitAnimWhenFinishing = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        ac(a.C0290a.aiapps_hold, a.C0290a.aiapps_slide_out_to_bottom);
        int releaseFixedOrientation = al.releaseFixedOrientation(this);
        super.onCreate(bundle);
        al.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.aiapps_error_activity);
        k(getIntent());
        Sp();
        Sr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        k(intent);
        Sp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        di(com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState());
    }

    public void di(boolean z) {
        Window window = getWindow();
        if (window == null) {
            if (DEBUG) {
                Log.e("SwanAppErrorActivity", "activity or window is null");
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
    }

    private void Sp() {
        d dVar;
        m aMy = aMv().aMy();
        if (getIntent() != null) {
            dVar = d.a(this.bMs, this.bMr);
        } else if (this.bMq == null) {
            if (DEBUG) {
                Log.e("SwanAppErrorActivity", "launchInfo is null,error");
                return;
            }
            return;
        } else {
            dVar = new d();
        }
        aMy.a(a.f.ai_apps_error_layout, dVar);
        aMy.commit();
    }

    private void k(Intent intent) {
        if (intent != null) {
            this.bMq = com.baidu.swan.apps.u.c.b.r(intent);
            this.bMr = (ForbiddenInfo) intent.getParcelableExtra("swan_error_forbidden_info");
            if (TextUtils.isEmpty(this.bMq.getAppId()) && this.bMr != null) {
                this.bMq.lE(this.bMr.appId);
            }
            this.bMs = intent.getStringExtra("swan_error_type");
        }
    }

    public com.baidu.swan.apps.u.c.b Sq() {
        return this.bMq;
    }

    private void ac(int i, int i2) {
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

    private void Sr() {
        com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
    }
}
