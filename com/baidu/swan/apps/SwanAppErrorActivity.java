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
    private Fragment akn;
    private com.baidu.swan.apps.v.b.b ako;
    private int akp = 0;
    private int akq = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        z(a.C0110a.aiapps_hold, a.C0110a.aiapps_slide_out_to_bottom);
        super.onCreate(bundle);
        setContentView(a.g.aiapps_error_activity);
        parseIntent(getIntent());
        vP();
        vR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        parseIntent(intent);
    }

    private void vP() {
        m Xh = Xe().Xh();
        this.akn = new com.baidu.swan.apps.core.d.c();
        Xh.a(a.f.ai_apps_error_layout, this.akn);
        Xh.commit();
    }

    private void parseIntent(Intent intent) {
        if (intent != null) {
            this.ako = com.baidu.swan.apps.v.b.b.F(intent);
        }
    }

    public com.baidu.swan.apps.v.b.b vL() {
        return this.ako;
    }

    private void z(int i, int i2) {
        this.akp = i;
        this.akq = i2;
    }

    private void vQ() {
        if (this.akp != 0 || this.akq != 0) {
            overridePendingTransition(this.akp, this.akq);
            this.akp = 0;
            this.akq = 0;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        vQ();
    }

    private void vR() {
        com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
    }
}
