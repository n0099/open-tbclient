package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes2.dex */
public class GetReverse {

    /* renamed from: a  reason: collision with root package name */
    public static ICooperService f8375a;

    public static ICooperService getCooperService(Context context) {
        if (f8375a == null) {
            f8375a = CooperService.instance();
        }
        return f8375a;
    }
}
