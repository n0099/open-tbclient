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
    private Fragment ajx;
    private com.baidu.swan.apps.v.b.b ajy;
    private int ajz = 0;
    private int ajA = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        y(a.C0107a.aiapps_hold, a.C0107a.aiapps_slide_out_to_bottom);
        super.onCreate(bundle);
        setContentView(a.g.aiapps_error_activity);
        parseIntent(getIntent());
        uE();
        uG();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        parseIntent(intent);
    }

    private void uE() {
        m SB = Sy().SB();
        this.ajx = new com.baidu.swan.apps.core.c.c();
        SB.a(a.f.ai_apps_error_layout, this.ajx);
        SB.commit();
    }

    private void parseIntent(Intent intent) {
        if (intent != null) {
            this.ajy = com.baidu.swan.apps.v.b.b.G(intent);
        }
    }

    public com.baidu.swan.apps.v.b.b uA() {
        return this.ajy;
    }

    private void y(int i, int i2) {
        this.ajz = i;
        this.ajA = i2;
    }

    private void uF() {
        if (this.ajz != 0 || this.ajA != 0) {
            overridePendingTransition(this.ajz, this.ajA);
            this.ajz = 0;
            this.ajA = 0;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        uF();
    }

    private void uG() {
        com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
    }
}
