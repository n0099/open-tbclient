package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes2.dex */
public class GetReverse {
    public static ICooperService a;

    public static ICooperService getCooperService(Context context) {
        if (a == null) {
            a = CooperService.instance();
        }
        return a;
    }
}
