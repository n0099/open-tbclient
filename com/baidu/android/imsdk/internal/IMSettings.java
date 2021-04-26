package com.baidu.android.imsdk.internal;

import android.content.Context;
import com.baidu.android.imsdk.utils.Utility;
/* loaded from: classes.dex */
public class IMSettings {
    public static final int DEBUG_MODE = 1;
    public static final int INVALIDE_MODE = -1;
    public static final int UNDEBUG_MODE = 0;
    public static int mDebugMode = -1;
    public static Context sContext;

    public static boolean enableDebugMode(Context context, boolean z) {
        if (z) {
            mDebugMode = 1;
        } else {
            mDebugMode = 0;
        }
        sContext = context;
        Utility.writeIntData(context, Constants.SETTING_DEBUG_MODE, mDebugMode);
        return true;
    }

    public static Context getsContext() {
        return sContext;
    }

    public static boolean isDebugMode() {
        int i2 = mDebugMode;
        if (i2 != -1) {
            return i2 == 1;
        }
        Context context = sContext;
        if (context == null) {
            return false;
        }
        int readIntData = Utility.readIntData(context, Constants.SETTING_DEBUG_MODE, 0);
        mDebugMode = readIntData;
        return readIntData == 1;
    }

    public static void setContext(Context context) {
        sContext = context;
    }
}
