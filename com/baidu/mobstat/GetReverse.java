package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes2.dex */
public class GetReverse {

    /* renamed from: a  reason: collision with root package name */
    public static ICooperService f8387a;

    public static ICooperService getCooperService(Context context) {
        if (f8387a == null) {
            f8387a = CooperService.instance();
        }
        return f8387a;
    }
}
