package com.baidu.searchbox.launch;

import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
/* loaded from: classes4.dex */
public class LaunchStatsUtils {
    public static final String AD = "ad";
    public static final int COLD_LAUNCH_TYPE = 0;
    public static final String EXTERNAL_LAUNCH = "external";
    public static final int HOT_LAUNCH_TYPE = 1;
    public static final long INVALID_LONG = -1;
    public static final String NEW_INSTALL_LAUNCH = "newInstall";
    public static final String NORMAL_LAUNCH = "normal";
    public static final String SKIN = "skin";
    public static final String TAG = "LaunchStatsUtils";
    public static final String UPGRADE_LAUNCH = "upgrade";
    public static String sLaunchTypeDetail;
    public static final boolean DEBUG = AppConfig.isDebug();
    public static long sAppCreateTimeStamp = -1;
    public static long sHomePageFirstRenderEndTimeStamp = -1;
    public static int sLaunchType = 0;

    public static long getAppCreateTime() {
        return sAppCreateTimeStamp;
    }

    public static long getHomePageFirstRenderEndTime() {
        return sHomePageFirstRenderEndTimeStamp;
    }

    public static int getLaunchType() {
        return sLaunchType;
    }

    public static String getLaunchTypeDetail() {
        return sLaunchTypeDetail;
    }

    public static boolean isAppCreateTimeValid() {
        if (sAppCreateTimeStamp != -1) {
            return true;
        }
        return false;
    }

    public static boolean isHomePageFirstRenderEndTimeValid() {
        if (sHomePageFirstRenderEndTimeStamp != -1) {
            return true;
        }
        return false;
    }

    public static void setAppCreateTime(long j) {
        sAppCreateTimeStamp = j;
    }

    public static void setHomePageFirstRenderEndTime(long j) {
        sHomePageFirstRenderEndTimeStamp = j;
    }

    public static void setLaunchType(int i) {
        sLaunchType = i;
    }

    public static void setLaunchTypeDetail(int i, boolean z, boolean z2, boolean z3) {
        if (!z) {
            sLaunchTypeDetail = EXTERNAL_LAUNCH;
        } else if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    sLaunchTypeDetail = NEW_INSTALL_LAUNCH;
                }
            } else {
                sLaunchTypeDetail = "upgrade";
            }
        } else {
            sLaunchTypeDetail = "normal";
        }
        if (z2) {
            sLaunchTypeDetail += "_skin";
        }
        if (z3 && i != 2) {
            sLaunchTypeDetail += "_ad";
        }
        if (DEBUG) {
            Log.d(TAG, "isLaunchFromLauncher: " + z + " hasSkin " + z2 + " hasAd " + z3);
            StringBuilder sb = new StringBuilder();
            sb.append("sLaunchType: ");
            sb.append(sLaunchType);
            Log.d(TAG, sb.toString());
        }
    }
}
