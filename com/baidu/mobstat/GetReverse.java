package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes2.dex */
public class GetReverse {

    /* renamed from: a  reason: collision with root package name */
    public static ICooperService f8800a;

    public static ICooperService getCooperService(Context context) {
        if (f8800a == null) {
            f8800a = CooperService.instance();
        }
        return f8800a;
    }
}
