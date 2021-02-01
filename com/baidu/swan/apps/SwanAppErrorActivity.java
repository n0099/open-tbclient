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
    private com.baidu.swan.apps.u.c.b cCj;
    private ForbiddenInfo cCk;
    private String cCl;
    private com.baidu.swan.apps.ai.b cCh = null;
    private int cCm = 0;
    private int cCn = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        Y(a.C0352a.aiapps_hold, a.C0352a.aiapps_slide_out_to_bottom);
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ak.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.aiapps_error_activity);
        k(getIntent());
        agk();
        agn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        k(intent);
        agk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        eF(com.baidu.swan.apps.t.a.axs().aii());
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
        if (this.cCh == null) {
            this.cCh = new com.baidu.swan.apps.ai.b();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.cCh.H(viewGroup);
        } else {
            this.cCh.I(viewGroup);
        }
    }

    private void agk() {
        d dVar;
        m beb = bdY().beb();
        if (getIntent() != null) {
            dVar = d.a(this.cCl, this.cCk);
        } else if (this.cCj == null) {
            if (DEBUG) {
                Log.e("SwanAppErrorActivity", "launchInfo is null,error");
                return;
            }
            return;
        } else {
            dVar = new d();
        }
        beb.a(a.f.ai_apps_error_layout, dVar);
        beb.commit();
    }

    private void k(Intent intent) {
        if (intent != null) {
            this.cCj = com.baidu.swan.apps.u.c.b.t(intent);
            this.cCk = (ForbiddenInfo) intent.getParcelableExtra("swan_error_forbidden_info");
            if (TextUtils.isEmpty(this.cCj.getAppId()) && this.cCk != null) {
                this.cCj.oR(this.cCk.appId);
            }
            this.cCl = intent.getStringExtra("swan_error_type");
        }
    }

    public com.baidu.swan.apps.u.c.b agl() {
        return this.cCj;
    }

    private void Y(int i, int i2) {
        this.cCm = i;
        this.cCn = i2;
    }

    private void agm() {
        if (this.cCm != 0 || this.cCn != 0) {
            overridePendingTransition(this.cCm, this.cCn);
            this.cCm = 0;
            this.cCn = 0;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        agm();
    }

    private void agn() {
        com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
    }
}
