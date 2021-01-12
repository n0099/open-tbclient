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
/* loaded from: classes8.dex */
public class SwanAppErrorActivity extends FragmentActivity {
    public static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.apps.u.c.b czN;
    private ForbiddenInfo czO;
    private String czP;
    private com.baidu.swan.apps.ai.b czL = null;
    private int czQ = 0;
    private int czR = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        ab(a.C0355a.aiapps_hold, a.C0355a.aiapps_slide_out_to_bottom);
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ak.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.aiapps_error_activity);
        k(getIntent());
        afM();
        afP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        k(intent);
        afM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        eD(com.baidu.swan.apps.t.a.awU().ahK());
    }

    public void eD(boolean z) {
        Window window = getWindow();
        if (window == null) {
            if (DEBUG) {
                Log.e("SwanAppErrorActivity", "activity or window is null");
                return;
            }
            return;
        }
        if (this.czL == null) {
            this.czL = new com.baidu.swan.apps.ai.b();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.czL.J(viewGroup);
        } else {
            this.czL.K(viewGroup);
        }
    }

    private void afM() {
        d dVar;
        m bdO = bdL().bdO();
        if (getIntent() != null) {
            dVar = d.a(this.czP, this.czO);
        } else if (this.czN == null) {
            if (DEBUG) {
                Log.e("SwanAppErrorActivity", "launchInfo is null,error");
                return;
            }
            return;
        } else {
            dVar = new d();
        }
        bdO.a(a.f.ai_apps_error_layout, dVar);
        bdO.commit();
    }

    private void k(Intent intent) {
        if (intent != null) {
            this.czN = com.baidu.swan.apps.u.c.b.t(intent);
            this.czO = (ForbiddenInfo) intent.getParcelableExtra("swan_error_forbidden_info");
            if (TextUtils.isEmpty(this.czN.getAppId()) && this.czO != null) {
                this.czN.oz(this.czO.appId);
            }
            this.czP = intent.getStringExtra("swan_error_type");
        }
    }

    public com.baidu.swan.apps.u.c.b afN() {
        return this.czN;
    }

    private void ab(int i, int i2) {
        this.czQ = i;
        this.czR = i2;
    }

    private void afO() {
        if (this.czQ != 0 || this.czR != 0) {
            overridePendingTransition(this.czQ, this.czR);
            this.czQ = 0;
            this.czR = 0;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        afO();
    }

    private void afP() {
        com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
    }
}
