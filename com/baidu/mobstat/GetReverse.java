package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes14.dex */
public class GetReverse {

    /* renamed from: a  reason: collision with root package name */
    private static ICooperService f3600a;

    private GetReverse() {
    }

    public static ICooperService getCooperService(Context context) {
        if (f3600a == null) {
            f3600a = CooperService.instance();
        }
        return f3600a;
    }
}
