package com.baidu.android.common.util;

import android.content.Context;
@Deprecated
/* loaded from: classes6.dex */
public class CommonParam {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f1142a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final String f1143b = CommonParam.class.getSimpleName();

    @Deprecated
    public static String getCUID(Context context) {
        return DeviceId.getCUID(context);
    }
}
