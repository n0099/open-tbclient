package com.baidu.searchbox.datacollector.growth.service;

import android.app.Activity;
import com.baidu.searchbox.appframework.SimpleActivityLifeCycle;
import com.baidu.searchbox.datacollector.growth.GrowthCollectManager;
/* loaded from: classes2.dex */
public class LifeCycleHelper extends SimpleActivityLifeCycle {
    @Override // com.baidu.searchbox.appframework.SimpleActivityLifeCycle, com.baidu.searchbox.appframework.BdBoxActivityLifecycle.IActivityLifecycle
    public void onBackgroundToForeground(Activity activity) {
        GrowthCollectManager.statisticDeviceData(activity);
    }
}
