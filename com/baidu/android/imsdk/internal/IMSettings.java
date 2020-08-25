package com.baidu.android.imsdk.internal;

import android.content.Context;
import com.baidu.android.imsdk.utils.Utility;
/* loaded from: classes9.dex */
public class IMSettings {
    public static final int DEBUG_MODE = 1;
    public static final int INVALIDE_MODE = -1;
    public static final int UNDEBUG_MODE = 0;
    private static Context sContext = null;
    private static int mDebugMode = -1;

    public static boolean enableDebugMode(Context context, boolean z) {
        if (z) {
            mDebugMode = 1;
        } else {
            mDebugMode = 0;
        }
        sContext = context;
        Utility.writeIntData(sContext, Constants.SETTING_DEBUG_MODE, mDebugMode);
        return true;
    }

    public static Context getsContext() {
        return sContext;
    }

    public static boolean isDebugMode() {
        if (mDebugMode != -1) {
            return mDebugMode == 1;
        } else if (sContext == null) {
            return false;
        } else {
            int readIntData = Utility.readIntData(sContext, Constants.SETTING_DEBUG_MODE, 0);
            mDebugMode = readIntData;
            return readIntData == 1;
        }
    }

    public static void setContext(Context context) {
        sContext = context;
    }
}
