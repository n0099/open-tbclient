package com.baidu.searchbox.appframework;

import android.app.Activity;
import com.baidu.searchbox.appframework.BdBoxActivityLifecycle;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class BdBoxActivityManager {
    public static BdBoxActivityLifecycle sMainGlobalActivityLifecycle;

    public static void finishAllActivity() {
        BdBoxActivityLifecycle bdBoxActivityLifecycle = sMainGlobalActivityLifecycle;
        if (bdBoxActivityLifecycle != null) {
            bdBoxActivityLifecycle.finishAllActivity();
        }
    }

    public static int getActivityCount() {
        BdBoxActivityLifecycle bdBoxActivityLifecycle = sMainGlobalActivityLifecycle;
        if (bdBoxActivityLifecycle != null) {
            return bdBoxActivityLifecycle.getActivityCount();
        }
        return 0;
    }

    public static LinkedList<WeakReference<Activity>> getActivityStack() {
        BdBoxActivityLifecycle bdBoxActivityLifecycle = sMainGlobalActivityLifecycle;
        if (bdBoxActivityLifecycle != null) {
            return bdBoxActivityLifecycle.getActivityStack();
        }
        return null;
    }

    public static BdBoxActivityLifecycle getMainGlobalActivityLifecycle() {
        BdBoxActivityLifecycle bdBoxActivityLifecycle;
        synchronized (BdBoxActivityLifecycle.class) {
            bdBoxActivityLifecycle = sMainGlobalActivityLifecycle;
        }
        return bdBoxActivityLifecycle;
    }

    public static Activity getPenultimateActivity() {
        BdBoxActivityLifecycle bdBoxActivityLifecycle = sMainGlobalActivityLifecycle;
        if (bdBoxActivityLifecycle != null) {
            return bdBoxActivityLifecycle.getPenultimateActivity();
        }
        return null;
    }

    public static Activity getRealTopActivity() {
        BdBoxActivityLifecycle bdBoxActivityLifecycle = sMainGlobalActivityLifecycle;
        if (bdBoxActivityLifecycle != null) {
            return bdBoxActivityLifecycle.getRealTopActivity();
        }
        return null;
    }

    public static Activity getTopActivity() {
        BdBoxActivityLifecycle bdBoxActivityLifecycle = sMainGlobalActivityLifecycle;
        if (bdBoxActivityLifecycle != null) {
            return bdBoxActivityLifecycle.getTopActivity();
        }
        return null;
    }

    public static boolean isForeground() {
        BdBoxActivityLifecycle bdBoxActivityLifecycle = sMainGlobalActivityLifecycle;
        if (bdBoxActivityLifecycle != null && bdBoxActivityLifecycle.isForeground()) {
            return true;
        }
        return false;
    }

    public static Activity getSpecifiedActivity(Class cls) {
        BdBoxActivityLifecycle bdBoxActivityLifecycle = sMainGlobalActivityLifecycle;
        if (bdBoxActivityLifecycle != null) {
            return bdBoxActivityLifecycle.getSpecifiedActivity(cls);
        }
        return null;
    }

    public static boolean isActivityInStack(Class cls) {
        BdBoxActivityLifecycle bdBoxActivityLifecycle = sMainGlobalActivityLifecycle;
        if (bdBoxActivityLifecycle != null && bdBoxActivityLifecycle.isActivityInStack(cls)) {
            return true;
        }
        return false;
    }

    public static void registerGlobalLifeCycle(BdBoxActivityLifecycle.IActivityLifecycle iActivityLifecycle) {
        BdBoxActivityLifecycle bdBoxActivityLifecycle;
        if (iActivityLifecycle != null && (bdBoxActivityLifecycle = sMainGlobalActivityLifecycle) != null) {
            bdBoxActivityLifecycle.registerGlobalLifeCycle(iActivityLifecycle);
        }
    }

    public static void registerLifeCycle(BdBoxActivityLifecycle.IActivityLifecycle iActivityLifecycle) {
        BdBoxActivityLifecycle bdBoxActivityLifecycle;
        if (iActivityLifecycle != null && (bdBoxActivityLifecycle = sMainGlobalActivityLifecycle) != null) {
            bdBoxActivityLifecycle.registerLifeCycle(iActivityLifecycle);
        }
    }

    public static void setMainGlobalActivityLifecycle(BdBoxActivityLifecycle bdBoxActivityLifecycle) {
        synchronized (BdBoxActivityLifecycle.class) {
            if (sMainGlobalActivityLifecycle == null) {
                sMainGlobalActivityLifecycle = bdBoxActivityLifecycle;
            } else {
                throw new IllegalStateException("The main activity lifecycle has already been initialized.");
            }
        }
    }

    public static void unregisterLifeCycle(BdBoxActivityLifecycle.IActivityLifecycle iActivityLifecycle) {
        BdBoxActivityLifecycle bdBoxActivityLifecycle;
        if (iActivityLifecycle != null && (bdBoxActivityLifecycle = sMainGlobalActivityLifecycle) != null) {
            bdBoxActivityLifecycle.unregisterLifeCycle(iActivityLifecycle);
        }
    }
}
