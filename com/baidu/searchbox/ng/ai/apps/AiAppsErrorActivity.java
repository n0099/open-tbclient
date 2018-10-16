package com.baidu.searchbox.ng.ai.apps;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsErrorFragment;
import com.baidu.searchbox.ng.ai.apps.launch.model.AiAppsLaunchInfo;
import com.baidu.searchbox.ng.ai.apps.statistic.search.AiAppsSearchFlowUBC;
import com.baidu.searchbox.ng.ai.apps.statistic.search.SearchFlowEvent;
import com.baidu.searchbox.support.v4.app.Fragment;
import com.baidu.searchbox.support.v4.app.FragmentActivity;
import com.baidu.searchbox.support.v4.app.FragmentTransaction;
/* loaded from: classes2.dex */
public class AiAppsErrorActivity extends FragmentActivity {
    private static final boolean DEBUG = false;
    protected static final int INVALID_ANIM = 0;
    private static final String TAG = "AiAppsErrorActivity";
    private int mEnterAnimWhenFinishing = 0;
    private int mExitAnimWhenFinishing = 0;
    private Fragment mFragment;
    private AiAppsLaunchInfo mLaunchInfo;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.support.v4.app.FragmentActivity, com.baidu.searchbox.support.v4.app.BaseFragmentActivityDonut, android.app.Activity
    public void onCreate(Bundle bundle) {
        setPendingTransition(R.anim.aiapps_hold, R.anim.aiapps_slide_out_to_bottom);
        super.onCreate(bundle);
        setContentView(R.layout.aiapps_error_activity);
        parseIntent(getIntent());
        loadFragment();
        onErrorForSearchUBC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        parseIntent(intent);
    }

    private void loadFragment() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        this.mFragment = new AiAppsErrorFragment();
        beginTransaction.add(R.id.ai_apps_error_layout, this.mFragment);
        beginTransaction.commit();
    }

    private void parseIntent(Intent intent) {
        if (intent != null) {
            this.mLaunchInfo = AiAppsLaunchInfo.createFromIntent(intent);
        }
    }

    public AiAppsLaunchInfo getLaunchInfo() {
        return this.mLaunchInfo;
    }

    private void setPendingTransition(int i, int i2) {
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

    private void onErrorForSearchUBC() {
        AiAppsSearchFlowUBC.addEvent(new SearchFlowEvent(SearchFlowEvent.ID_NOT_REACH, System.currentTimeMillis(), SearchFlowEvent.ERR_TYPE_SWAN_ERR, "", SearchFlowEvent.EventType.END));
    }
}
