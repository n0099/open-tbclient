package com.baidu.android.common.util;

import android.content.Context;
@Deprecated
/* loaded from: classes9.dex */
public class CommonParam {
    private static final boolean a = false;
    private static final String b = CommonParam.class.getSimpleName();

    @Deprecated
    public static String getCUID(Context context) {
        return DeviceId.getCUID(context);
    }
}
