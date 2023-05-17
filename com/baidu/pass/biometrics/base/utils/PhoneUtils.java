package com.baidu.pass.biometrics.base.utils;

import android.content.Context;
import com.baidu.android.common.util.DeviceId;
/* loaded from: classes3.dex */
public final class PhoneUtils {
    public static String getCUID2(Context context) {
        return DeviceId.getCUID(context);
    }
}
