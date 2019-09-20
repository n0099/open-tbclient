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
    private Fragment akL;
    private com.baidu.swan.apps.v.b.b akM;
    private int akN = 0;
    private int akO = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        z(a.C0119a.aiapps_hold, a.C0119a.aiapps_slide_out_to_bottom);
        super.onCreate(bundle);
        setContentView(a.g.aiapps_error_activity);
        parseIntent(getIntent());
        vT();
        vV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        parseIntent(intent);
    }

    private void vT() {
        m Xl = Xi().Xl();
        this.akL = new com.baidu.swan.apps.core.d.c();
        Xl.a(a.f.ai_apps_error_layout, this.akL);
        Xl.commit();
    }

    private void parseIntent(Intent intent) {
        if (intent != null) {
            this.akM = com.baidu.swan.apps.v.b.b.F(intent);
        }
    }

    public com.baidu.swan.apps.v.b.b vP() {
        return this.akM;
    }

    private void z(int i, int i2) {
        this.akN = i;
        this.akO = i2;
    }

    private void vU() {
        if (this.akN != 0 || this.akO != 0) {
            overridePendingTransition(this.akN, this.akO);
            this.akN = 0;
            this.akO = 0;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        vU();
    }

    private void vV() {
        com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
    }
}
