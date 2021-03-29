package com.baidu.searchbox.track.ui;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.searchbox.appframework.SimpleActivityLifeCycle;
/* loaded from: classes2.dex */
public class TraceActivityCallbacks extends SimpleActivityLifeCycle {
    public TraceManager mTraceManager = TraceManager.getInstance();
    public TraceFragmentCallbackWrapper mTraceFragmentCallbackWrapper = new TraceFragmentCallbackWrapper();

    @Override // com.baidu.searchbox.appframework.SimpleActivityLifeCycle, com.baidu.searchbox.appframework.BdBoxActivityLifecycle.IActivityLifecycle
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (this.mTraceManager.isRegistered()) {
            this.mTraceFragmentCallbackWrapper.register(activity);
            this.mTraceManager.saveTraceInfo(activity, (!TraceManager.checkAPSActivity(activity) || bundle == null) ? null : bundle.getString("ActivityName"), null, "onCreated");
        }
    }

    @Override // com.baidu.searchbox.appframework.SimpleActivityLifeCycle, com.baidu.searchbox.appframework.BdBoxActivityLifecycle.IActivityLifecycle
    public void onActivityDestroyed(Activity activity) {
        if (this.mTraceManager.isRegistered()) {
            this.mTraceFragmentCallbackWrapper.unregister(activity);
            this.mTraceManager.saveTraceInfo(activity, null, null, "onDestroyed");
        }
    }

    @Override // com.baidu.searchbox.appframework.SimpleActivityLifeCycle, com.baidu.searchbox.appframework.BdBoxActivityLifecycle.IActivityLifecycle
    public void onActivityResumed(Activity activity) {
        if (this.mTraceManager.isRegistered()) {
            this.mTraceManager.saveTraceInfo(activity, null, null, "onResumed");
        }
    }

    @Override // com.baidu.searchbox.appframework.SimpleActivityLifeCycle, com.baidu.searchbox.appframework.BdBoxActivityLifecycle.IActivityLifecycle
    public void onBackgroundToForeground(Activity activity) {
        super.onBackgroundToForeground(activity);
        if (this.mTraceManager.isRegistered()) {
            this.mTraceManager.saveTraceInfo(activity, true);
        }
    }

    @Override // com.baidu.searchbox.appframework.SimpleActivityLifeCycle, com.baidu.searchbox.appframework.BdBoxActivityLifecycle.IActivityLifecycle
    public void onForegroundToBackground(Activity activity) {
        super.onForegroundToBackground(activity);
        if (this.mTraceManager.isRegistered()) {
            this.mTraceManager.saveTraceInfo(activity, false);
        }
    }

    public void registerTraceFragment(Activity activity) {
        this.mTraceFragmentCallbackWrapper.register(activity);
    }
}
