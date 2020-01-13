package com.baidu.swan.apps;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.swan.support.v4.app.m;
/* loaded from: classes10.dex */
public class SwanAppErrorActivity extends FragmentActivity {
    private static final boolean DEBUG = b.DEBUG;
    private Fragment aWH;
    private com.baidu.swan.apps.x.b.b aWI;
    private int mEnterAnimWhenFinishing = 0;
    private int mExitAnimWhenFinishing = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        V(a.C0187a.aiapps_hold, a.C0187a.aiapps_slide_out_to_bottom);
        int releaseFixedOrientation = ai.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ai.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.aiapps_error_activity);
        C(getIntent());
        EA();
        EC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C(intent);
    }

    private void EA() {
        m asp = asm().asp();
        this.aWH = new com.baidu.swan.apps.core.d.c();
        asp.a(a.f.ai_apps_error_layout, this.aWH);
        asp.commit();
    }

    private void C(Intent intent) {
        if (intent != null) {
            this.aWI = com.baidu.swan.apps.x.b.b.G(intent);
        }
    }

    public com.baidu.swan.apps.x.b.b EB() {
        return this.aWI;
    }

    private void V(int i, int i2) {
        this.mEnterAnimWhenFinishing = i;
        this.mExitAnimWhenFinishing = i2;
    }

    private void startExitActivityAnim() {
        if (this.mEnterAnimWhenFinishing != 0 || this.mExitAnimWhenFinishing != 0) {
            overridePendingTransition(this.mEnterAnimWhenFinishing, this.mExitAnimWhenFinishing);
            this.mEnterAnimWhenFinishing = 0;
            this.mExitAnimWhenFinishing = 0;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        startExitActivityAnim();
    }

    private void EC() {
        com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
    }
}
