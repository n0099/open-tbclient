package com.baidu.live.adp.lib.util;

import android.content.Context;
/* loaded from: classes10.dex */
public class BdDistanceHelper {
    public static long getPxByEquipWidth(Context context, double d) {
        return Math.round(getEquipmentWidth(context) * d);
    }

    public static long getPxByEquipHeight(Context context, double d) {
        return Math.round(getEquipmentHeight(context) * d);
    }

    public static int getEquipmentWidth(Context context) {
        if (!BdUtilHelper.deviceDataInited) {
            BdUtilHelper.initDeviceData(context);
        }
        return BdUtilHelper.displayMetricsWidthPixels;
    }

    public static int getEquipmentHeight(Context context) {
        if (!BdUtilHelper.deviceDataInited) {
            BdUtilHelper.initDeviceData(context);
        }
        return BdUtilHelper.displayMetricsHeightPixels;
    }
}
