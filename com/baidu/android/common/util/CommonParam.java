package com.baidu.android.common.util;

import android.content.Context;
@Deprecated
/* loaded from: classes.dex */
public class CommonParam {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f2571a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final String f2572b = "CommonParam";

    @Deprecated
    public static String getCUID(Context context) {
        return DeviceId.getCUID(context);
    }
}
