package com.baidu.adp.lib.util;

import android.content.Context;
/* loaded from: classes.dex */
public class e {
    public static int getEquipmentWidth(Context context) {
        if (!l.deviceDataInited) {
            l.initDeviceData(context);
        }
        return l.displayMetricsWidthPixels;
    }
}
