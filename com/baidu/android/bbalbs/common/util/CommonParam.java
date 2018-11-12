package com.baidu.android.bbalbs.common.util;

import android.content.Context;
/* loaded from: classes4.dex */
public class CommonParam {
    private static final String a = CommonParam.class.getSimpleName();

    public static String getCUID(Context context) {
        return DeviceId.getCUID(context);
    }
}
