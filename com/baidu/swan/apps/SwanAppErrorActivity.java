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
    private Fragment ajw;
    private com.baidu.swan.apps.v.b.b ajx;
    private int ajy = 0;
    private int ajz = 0;

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
        this.ajw = new com.baidu.swan.apps.core.c.c();
        SB.a(a.f.ai_apps_error_layout, this.ajw);
        SB.commit();
    }

    private void parseIntent(Intent intent) {
        if (intent != null) {
            this.ajx = com.baidu.swan.apps.v.b.b.G(intent);
        }
    }

    public com.baidu.swan.apps.v.b.b uA() {
        return this.ajx;
    }

    private void y(int i, int i2) {
        this.ajy = i;
        this.ajz = i2;
    }

    private void uF() {
        if (this.ajy != 0 || this.ajz != 0) {
            overridePendingTransition(this.ajy, this.ajz);
            this.ajy = 0;
            this.ajz = 0;
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
