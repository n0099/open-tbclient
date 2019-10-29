package com.baidu.swan.apps;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.swan.support.v4.app.m;
/* loaded from: classes2.dex */
public class SwanAppErrorActivity extends FragmentActivity {
    private static final boolean DEBUG = b.DEBUG;
    private Fragment aEh;
    private com.baidu.swan.apps.v.b.b aEi;
    private int aEj = 0;
    private int aEk = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        F(a.C0151a.aiapps_hold, a.C0151a.aiapps_slide_out_to_bottom);
        super.onCreate(bundle);
        setContentView(a.g.aiapps_error_activity);
        C(getIntent());
        AN();
        AP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C(intent);
    }

    private void AN() {
        m aca = abX().aca();
        this.aEh = new com.baidu.swan.apps.core.d.c();
        aca.a(a.f.ai_apps_error_layout, this.aEh);
        aca.commit();
    }

    private void C(Intent intent) {
        if (intent != null) {
            this.aEi = com.baidu.swan.apps.v.b.b.L(intent);
        }
    }

    public com.baidu.swan.apps.v.b.b AJ() {
        return this.aEi;
    }

    private void F(int i, int i2) {
        this.aEj = i;
        this.aEk = i2;
    }

    private void AO() {
        if (this.aEj != 0 || this.aEk != 0) {
            overridePendingTransition(this.aEj, this.aEk);
            this.aEj = 0;
            this.aEk = 0;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        AO();
    }

    private void AP() {
        com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
    }
}
