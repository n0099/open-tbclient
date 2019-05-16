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
    private Fragment ajL;
    private com.baidu.swan.apps.v.b.b ajM;
    private int ajN = 0;
    private int ajO = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        w(a.C0108a.aiapps_hold, a.C0108a.aiapps_slide_out_to_bottom);
        super.onCreate(bundle);
        setContentView(a.g.aiapps_error_activity);
        parseIntent(getIntent());
        vo();
        vq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        parseIntent(intent);
    }

    private void vo() {
        m Wn = Wk().Wn();
        this.ajL = new com.baidu.swan.apps.core.d.c();
        Wn.a(a.f.ai_apps_error_layout, this.ajL);
        Wn.commit();
    }

    private void parseIntent(Intent intent) {
        if (intent != null) {
            this.ajM = com.baidu.swan.apps.v.b.b.F(intent);
        }
    }

    public com.baidu.swan.apps.v.b.b vk() {
        return this.ajM;
    }

    private void w(int i, int i2) {
        this.ajN = i;
        this.ajO = i2;
    }

    private void vp() {
        if (this.ajN != 0 || this.ajO != 0) {
            overridePendingTransition(this.ajN, this.ajO);
            this.ajN = 0;
            this.ajO = 0;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        vp();
    }

    private void vq() {
        com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
    }
}
