package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes2.dex */
public class GetReverse {

    /* renamed from: a  reason: collision with root package name */
    public static ICooperService f8449a;

    public static ICooperService getCooperService(Context context) {
        if (f8449a == null) {
            f8449a = CooperService.instance();
        }
        return f8449a;
    }
}
