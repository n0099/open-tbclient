package com.baidu.searchbox.ng.ai.apps.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.searchbox.ng.ai.apps.AiAppsActivity;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
/* loaded from: classes2.dex */
public class AiAppsLifecycle implements Application.ActivityLifecycleCallbacks {
    private static final boolean DEBUG = false;
    private static final String TAG = "AiAppsLifecycle";
    private static AiAppsLifecycle mInstance;
    private int mActivityCount;
    private boolean mIsForeground = false;

    public static AiAppsLifecycle get() {
        if (mInstance == null) {
            synchronized (AiAppsLifecycle.class) {
                if (mInstance == null) {
                    mInstance = new AiAppsLifecycle();
                }
            }
        }
        return mInstance;
    }

    private AiAppsLifecycle() {
    }

    public void registerSelf() {
        AiAppsRuntime.getAppContext().registerActivityLifecycleCallbacks(this);
    }

    public void unRegisterSelf() {
        AiAppsRuntime.getAppContext().unregisterActivityLifecycleCallbacks(this);
    }

    private void onBackgroundToForeground(Activity activity) {
        if (activity instanceof AiAppsActivity) {
            this.mIsForeground = true;
        }
    }

    private void onForegroundToBackground(Activity activity) {
        if (activity instanceof AiAppsActivity) {
            this.mIsForeground = false;
        }
    }

    public boolean isForeground() {
        return this.mIsForeground;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.mActivityCount++;
        if (this.mActivityCount == 1) {
            onBackgroundToForeground(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        this.mActivityCount--;
        if (this.mActivityCount == 0) {
            onForegroundToBackground(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }
}
