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
    private Fragment aDP;
    private com.baidu.swan.apps.v.b.b aDQ;
    private int aDR = 0;
    private int aDS = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        D(a.C0146a.aiapps_hold, a.C0146a.aiapps_slide_out_to_bottom);
        super.onCreate(bundle);
        setContentView(a.g.aiapps_error_activity);
        C(getIntent());
        AO();
        AQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C(intent);
    }

    private void AO() {
        m abY = abV().abY();
        this.aDP = new com.baidu.swan.apps.core.d.c();
        abY.a(a.f.ai_apps_error_layout, this.aDP);
        abY.commit();
    }

    private void C(Intent intent) {
        if (intent != null) {
            this.aDQ = com.baidu.swan.apps.v.b.b.L(intent);
        }
    }

    public com.baidu.swan.apps.v.b.b AK() {
        return this.aDQ;
    }

    private void D(int i, int i2) {
        this.aDR = i;
        this.aDS = i2;
    }

    private void AP() {
        if (this.aDR != 0 || this.aDS != 0) {
            overridePendingTransition(this.aDR, this.aDS);
            this.aDR = 0;
            this.aDS = 0;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        AP();
    }

    private void AQ() {
        com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
    }
}
