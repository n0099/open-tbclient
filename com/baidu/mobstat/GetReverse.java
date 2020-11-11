package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes17.dex */
public class GetReverse {

    /* renamed from: a  reason: collision with root package name */
    private static ICooperService f2496a;

    private GetReverse() {
    }

    public static ICooperService getCooperService(Context context) {
        if (f2496a == null) {
            f2496a = CooperService.instance();
        }
        return f2496a;
    }
}
