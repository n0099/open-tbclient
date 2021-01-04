package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes15.dex */
public class GetReverse {

    /* renamed from: a  reason: collision with root package name */
    private static ICooperService f3637a;

    private GetReverse() {
    }

    public static ICooperService getCooperService(Context context) {
        if (f3637a == null) {
            f3637a = CooperService.instance();
        }
        return f3637a;
    }
}
