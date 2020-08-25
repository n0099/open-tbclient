package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes11.dex */
public class GetReverse {
    private static ICooperService a;

    private GetReverse() {
    }

    public static ICooperService getCooperService(Context context) {
        if (a == null) {
            a = CooperService.instance();
        }
        return a;
    }
}
