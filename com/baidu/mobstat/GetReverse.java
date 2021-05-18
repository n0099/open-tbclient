package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes2.dex */
public class GetReverse {

    /* renamed from: a  reason: collision with root package name */
    public static ICooperService f8487a;

    public static ICooperService getCooperService(Context context) {
        if (f8487a == null) {
            f8487a = CooperService.instance();
        }
        return f8487a;
    }
}
