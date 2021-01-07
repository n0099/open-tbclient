package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes15.dex */
public class GetReverse {

    /* renamed from: a  reason: collision with root package name */
    private static ICooperService f3638a;

    private GetReverse() {
    }

    public static ICooperService getCooperService(Context context) {
        if (f3638a == null) {
            f3638a = CooperService.instance();
        }
        return f3638a;
    }
}
