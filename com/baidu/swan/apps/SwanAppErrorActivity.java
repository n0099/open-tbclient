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
    private com.baidu.swan.apps.u.c.b cDJ;
    private ForbiddenInfo cDK;
    private String cDL;
    private com.baidu.swan.apps.ai.b cDH = null;
    private int cDM = 0;
    private int cDN = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        Y(a.C0358a.aiapps_hold, a.C0358a.aiapps_slide_out_to_bottom);
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ak.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.aiapps_error_activity);
        k(getIntent());
        agn();
        agq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        k(intent);
        agn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        eF(com.baidu.swan.apps.t.a.axv().ail());
    }

    public void eF(boolean z) {
        Window window = getWindow();
        if (window == null) {
            if (DEBUG) {
                Log.e("SwanAppErrorActivity", "activity or window is null");
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
    }

    private void agn() {
        d dVar;
        m bed = bea().bed();
        if (getIntent() != null) {
            dVar = d.a(this.cDL, this.cDK);
        } else if (this.cDJ == null) {
            if (DEBUG) {
                Log.e("SwanAppErrorActivity", "launchInfo is null,error");
                return;
            }
            return;
        } else {
            dVar = new d();
        }
        bed.a(a.f.ai_apps_error_layout, dVar);
        bed.commit();
    }

    private void k(Intent intent) {
        if (intent != null) {
            this.cDJ = com.baidu.swan.apps.u.c.b.t(intent);
            this.cDK = (ForbiddenInfo) intent.getParcelableExtra("swan_error_forbidden_info");
            if (TextUtils.isEmpty(this.cDJ.getAppId()) && this.cDK != null) {
                this.cDJ.oY(this.cDK.appId);
            }
            this.cDL = intent.getStringExtra("swan_error_type");
        }
    }

    public com.baidu.swan.apps.u.c.b ago() {
        return this.cDJ;
    }

    private void Y(int i, int i2) {
        this.cDM = i;
        this.cDN = i2;
    }

    private void agp() {
        if (this.cDM != 0 || this.cDN != 0) {
            overridePendingTransition(this.cDM, this.cDN);
            this.cDM = 0;
            this.cDN = 0;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        agp();
    }

    private void agq() {
        com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
    }
}
