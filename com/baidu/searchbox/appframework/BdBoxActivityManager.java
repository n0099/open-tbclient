package com.baidu.searchbox.appframework;

import android.app.Activity;
import com.baidu.searchbox.appframework.BdBoxActivityLifecycle;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class BdBoxActivityManager {
    private static BdBoxActivityLifecycle sMainGlobalActivityLifecycle;

    public static void setMainGlobalActivityLifecycle(BdBoxActivityLifecycle bdBoxActivityLifecycle) {
        synchronized (BdBoxActivityLifecycle.class) {
            if (sMainGlobalActivityLifecycle != null) {
                throw new IllegalStateException("The main activity lifecycle has already been initialized.");
            }
            sMainGlobalActivityLifecycle = bdBoxActivityLifecycle;
        }
    }

    public static BdBoxActivityLifecycle getMainGlobalActivityLifecycle() {
        BdBoxActivityLifecycle bdBoxActivityLifecycle;
        synchronized (BdBoxActivityLifecycle.class) {
            bdBoxActivityLifecycle = sMainGlobalActivityLifecycle;
        }
        return bdBoxActivityLifecycle;
    }

    public static LinkedList<WeakReference<Activity>> getActivityStack() {
        if (sMainGlobalActivityLifecycle != null) {
            return sMainGlobalActivityLifecycle.getActivityStack();
        }
        return null;
    }

    public static int getActivityCount() {
        if (sMainGlobalActivityLifecycle != null) {
            return sMainGlobalActivityLifecycle.getActivityCount();
        }
        return 0;
    }

    public static boolean isActivityInStack(Class cls) {
        return sMainGlobalActivityLifecycle != null && sMainGlobalActivityLifecycle.isActivityInStack(cls);
    }

    public static Activity getTopActivity() {
        if (sMainGlobalActivityLifecycle != null) {
            return sMainGlobalActivityLifecycle.getTopActivity();
        }
        return null;
    }

    public static Activity getPenultimateActivity() {
        if (sMainGlobalActivityLifecycle != null) {
            return sMainGlobalActivityLifecycle.getPenultimateActivity();
        }
        return null;
    }

    public static Activity getRealTopActivity() {
        if (sMainGlobalActivityLifecycle != null) {
            return sMainGlobalActivityLifecycle.getRealTopActivity();
        }
        return null;
    }

    public static Activity getSpecifiedActivity(Class cls) {
        if (sMainGlobalActivityLifecycle != null) {
            return sMainGlobalActivityLifecycle.getSpecifiedActivity(cls);
        }
        return null;
    }

    public static void finishAllActivity() {
        if (sMainGlobalActivityLifecycle != null) {
            sMainGlobalActivityLifecycle.finishAllActivity();
        }
    }

    public static boolean isForeground() {
        return sMainGlobalActivityLifecycle != null && sMainGlobalActivityLifecycle.isForeground();
    }

    public static void registerGlobalLifeCycle(BdBoxActivityLifecycle.IActivityLifecycle iActivityLifecycle) {
        if (iActivityLifecycle != null && sMainGlobalActivityLifecycle != null) {
            sMainGlobalActivityLifecycle.registerGlobalLifeCycle(iActivityLifecycle);
        }
    }

    public static void registerLifeCycle(BdBoxActivityLifecycle.IActivityLifecycle iActivityLifecycle) {
        if (iActivityLifecycle != null && sMainGlobalActivityLifecycle != null) {
            sMainGlobalActivityLifecycle.registerLifeCycle(iActivityLifecycle);
        }
    }

    public static void unregisterLifeCycle(BdBoxActivityLifecycle.IActivityLifecycle iActivityLifecycle) {
        if (iActivityLifecycle != null && sMainGlobalActivityLifecycle != null) {
            sMainGlobalActivityLifecycle.unregisterLifeCycle(iActivityLifecycle);
        }
    }
}
