package com.baidu.ala.player;

import android.app.ActivityManager;
import android.content.Context;
import com.baidu.ala.adp.lib.util.BdLog;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes5.dex */
public class AlaLivePlayerUtil {
    private static final String LOG_TAG = "liveplayer";
    public static final int MAX_LOG_DECODEYUV_COUNT = 5;
    private static boolean isSupportGL = false;
    public static int sDecodeYUVErrorCount = 0;

    public static boolean isSupported(Context context) {
        if (isSupportGL) {
            return true;
        }
        try {
            if (((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getDeviceConfigurationInfo().reqGlEsVersion >= 131072) {
                isSupportGL = true;
                return true;
            }
            return false;
        } catch (Exception e) {
            BdLog.e(e);
            return true;
        }
    }

    public static void log(Object... objArr) {
    }
}
