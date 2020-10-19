package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes17.dex */
public class GetReverse {

    /* renamed from: a  reason: collision with root package name */
    private static ICooperService f2494a;

    private GetReverse() {
    }

    public static ICooperService getCooperService(Context context) {
        if (f2494a == null) {
            f2494a = CooperService.instance();
        }
        return f2494a;
    }
}
