package com.baidu.searchbox.ng.ai.apps.impl.map.data;

import com.baidu.searchbox.bdmapsdk.BdMapLibLoader;
import com.baidu.searchbox.ng.ai.apps.impl.map.aps.AiAppsPreloadMapLibHelper;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
/* loaded from: classes4.dex */
public class BdMapPreLoadDelegation extends ActivityDelegation implements BdMapLibLoader.OnFetchMapLibCallback {
    public static final String MAP_INFO_KEY = "ai_apps_data";
    public static final String RESULT_KEY = "ok";

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        AiAppsPreloadMapLibHelper.processLoadMapLibMessage(BdMapLibApsInfoWrapper.wrapBdMapLibApsInfo((BdMapLibApsInfo) this.mParams.getParcelable("ai_apps_data"), this));
        return false;
    }

    @Override // com.baidu.searchbox.bdmapsdk.BdMapLibLoader.OnFetchMapLibCallback
    public void onSuccess() {
        this.mResult.putBoolean("ok", true);
        finish();
    }

    @Override // com.baidu.searchbox.bdmapsdk.BdMapLibLoader.OnFetchMapLibCallback
    public void onFailure() {
        this.mResult.putBoolean("ok", false);
        finish();
    }
}
