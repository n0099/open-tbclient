package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes7.dex */
public class GetReverse {

    /* renamed from: a  reason: collision with root package name */
    private static ICooperService f2498a;

    private GetReverse() {
    }

    public static ICooperService getCooperService(Context context) {
        if (f2498a == null) {
            f2498a = CooperService.instance();
        }
        return f2498a;
    }
}
