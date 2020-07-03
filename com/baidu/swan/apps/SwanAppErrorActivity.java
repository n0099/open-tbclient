package com.baidu.swan.apps;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.support.v4.app.Fragment;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.swan.support.v4.app.m;
/* loaded from: classes11.dex */
public class SwanAppErrorActivity extends FragmentActivity {
    private static final boolean DEBUG = b.DEBUG;
    private Fragment bLS;
    private com.baidu.swan.apps.v.b.b bLT;
    private int mEnterAnimWhenFinishing = 0;
    private int mExitAnimWhenFinishing = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        ac(a.C0287a.aiapps_hold, a.C0287a.aiapps_slide_out_to_bottom);
        int releaseFixedOrientation = aj.releaseFixedOrientation(this);
        super.onCreate(bundle);
        aj.fixedOrientation(this, releaseFixedOrientation);
        setContentView(a.g.aiapps_error_activity);
        k(getIntent());
        Sa();
        Sc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        k(intent);
    }

    private void Sa() {
        m aIG = aID().aIG();
        this.bLS = new com.baidu.swan.apps.core.d.c();
        aIG.a(a.f.ai_apps_error_layout, this.bLS);
        aIG.commit();
    }

    private void k(Intent intent) {
        if (intent != null) {
            this.bLT = com.baidu.swan.apps.v.b.b.r(intent);
        }
    }

    public com.baidu.swan.apps.v.b.b Sb() {
        return this.bLT;
    }

    private void ac(int i, int i2) {
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

    private void Sc() {
        com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
    }
}
