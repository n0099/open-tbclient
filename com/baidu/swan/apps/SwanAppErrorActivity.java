package com.baidu.swan.apps;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.swan.support.v4.app.m;
/* loaded from: classes2.dex */
public class SwanAppErrorActivity extends FragmentActivity {
    private static final boolean DEBUG = c.DEBUG;
    private Fragment ajr;
    private com.baidu.swan.apps.v.b.b ajs;
    private int ajt = 0;
    private int aju = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        y(b.a.aiapps_hold, b.a.aiapps_slide_out_to_bottom);
        super.onCreate(bundle);
        setContentView(b.g.aiapps_error_activity);
        parseIntent(getIntent());
        uF();
        uH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        parseIntent(intent);
    }

    private void uF() {
        m SD = SA().SD();
        this.ajr = new com.baidu.swan.apps.core.c.c();
        SD.a(b.f.ai_apps_error_layout, this.ajr);
        SD.commit();
    }

    private void parseIntent(Intent intent) {
        if (intent != null) {
            this.ajs = com.baidu.swan.apps.v.b.b.G(intent);
        }
    }

    public com.baidu.swan.apps.v.b.b uB() {
        return this.ajs;
    }

    private void y(int i, int i2) {
        this.ajt = i;
        this.aju = i2;
    }

    private void uG() {
        if (this.ajt != 0 || this.aju != 0) {
            overridePendingTransition(this.ajt, this.aju);
            this.ajt = 0;
            this.aju = 0;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        uG();
    }

    private void uH() {
        com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
    }
}
