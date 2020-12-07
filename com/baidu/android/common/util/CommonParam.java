package com.baidu.android.common.util;

import android.content.Context;
@Deprecated
/* loaded from: classes14.dex */
public class CommonParam {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f992a = false;
    private static final String b = CommonParam.class.getSimpleName();

    @Deprecated
    public static String getCUID(Context context) {
        return DeviceId.getCUID(context);
    }
}
