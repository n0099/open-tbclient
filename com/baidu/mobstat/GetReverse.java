package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes3.dex */
public class GetReverse {

    /* renamed from: a  reason: collision with root package name */
    private static ICooperService f3603a;

    private GetReverse() {
    }

    public static ICooperService getCooperService(Context context) {
        if (f3603a == null) {
            f3603a = CooperService.instance();
        }
        return f3603a;
    }
}
