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
    private Fragment ajs;
    private com.baidu.swan.apps.v.b.b ajt;
    private int aju = 0;
    private int ajv = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        y(a.C0107a.aiapps_hold, a.C0107a.aiapps_slide_out_to_bottom);
        super.onCreate(bundle);
        setContentView(a.g.aiapps_error_activity);
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
        this.ajs = new com.baidu.swan.apps.core.c.c();
        SD.a(a.f.ai_apps_error_layout, this.ajs);
        SD.commit();
    }

    private void parseIntent(Intent intent) {
        if (intent != null) {
            this.ajt = com.baidu.swan.apps.v.b.b.G(intent);
        }
    }

    public com.baidu.swan.apps.v.b.b uB() {
        return this.ajt;
    }

    private void y(int i, int i2) {
        this.aju = i;
        this.ajv = i2;
    }

    private void uG() {
        if (this.aju != 0 || this.ajv != 0) {
            overridePendingTransition(this.aju, this.ajv);
            this.aju = 0;
            this.ajv = 0;
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
