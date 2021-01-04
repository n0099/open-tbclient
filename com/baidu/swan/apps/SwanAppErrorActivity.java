package com.baidu.swan.apps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.core.d.d;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.swan.support.v4.app.m;
/* loaded from: classes9.dex */
public class SwanAppErrorActivity extends FragmentActivity {
    public static final boolean DEBUG = b.DEBUG;
    private ForbiddenInfo cEA;
    private String cEB;
    private com.baidu.swan.apps.u.c.b cEz;
    private com.baidu.swan.apps.ai.b cEx = null;
    private int cEC = 0;
    private int cED = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        ab(a.C0372a.aiapps_hold, a.C0372a.aiapps_slide_out_to_bottom);
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ak.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.aiapps_error_activity);
        k(getIntent());
        ajF();
        ajI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        k(intent);
        ajF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        eH(com.baidu.swan.apps.t.a.aAN().alD());
    }

    public void eH(boolean z) {
        Window window = getWindow();
        if (window == null) {
            if (DEBUG) {
                Log.e("SwanAppErrorActivity", "activity or window is null");
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
    }

    private void ajF() {
        d dVar;
        m bhH = bhE().bhH();
        if (getIntent() != null) {
            dVar = d.a(this.cEB, this.cEA);
        } else if (this.cEz == null) {
            if (DEBUG) {
                Log.e("SwanAppErrorActivity", "launchInfo is null,error");
                return;
            }
            return;
        } else {
            dVar = new d();
        }
        bhH.a(a.f.ai_apps_error_layout, dVar);
        bhH.commit();
    }

    private void k(Intent intent) {
        if (intent != null) {
            this.cEz = com.baidu.swan.apps.u.c.b.t(intent);
            this.cEA = (ForbiddenInfo) intent.getParcelableExtra("swan_error_forbidden_info");
            if (TextUtils.isEmpty(this.cEz.getAppId()) && this.cEA != null) {
                this.cEz.pK(this.cEA.appId);
            }
            this.cEB = intent.getStringExtra("swan_error_type");
        }
    }

    public com.baidu.swan.apps.u.c.b ajG() {
        return this.cEz;
    }

    private void ab(int i, int i2) {
        this.cEC = i;
        this.cED = i2;
    }

    private void ajH() {
        if (this.cEC != 0 || this.cED != 0) {
            overridePendingTransition(this.cEC, this.cED);
            this.cEC = 0;
            this.cED = 0;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        ajH();
    }

    private void ajI() {
        com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
    }
}
