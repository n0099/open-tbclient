package com.baidu.ar.util;

import android.content.Context;
import com.baidu.ar.task.HttpTaskUtility;
/* loaded from: classes3.dex */
public final class DeviceSupportAbility {
    public static String getBlacklistParams(Context context, String str) {
        return HttpTaskUtility.getHttpParamsForMM(context);
    }
}
