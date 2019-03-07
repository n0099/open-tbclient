package com.baidu.android.bbalbs.common.util;

import android.content.Context;
/* loaded from: classes3.dex */
public class CommonParam {
    private static final boolean DEBUG = false;
    private static final String TAG = com.baidu.android.common.util.CommonParam.class.getSimpleName();

    public static String getCUID(Context context) {
        return com.baidu.android.common.util.DeviceId.getCUID(context);
    }

    public static String a(Context context) {
        return com.baidu.android.common.util.DeviceId.getCUID(context);
    }
}
