package com.baidu.pass.biometrics.base.utils;

import android.content.Context;
/* loaded from: classes3.dex */
public class PassBioBaseUtil {
    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            return "0";
        }
    }
}
