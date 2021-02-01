package com.baidu.pass.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
/* loaded from: classes5.dex */
public class PassUtil implements com.baidu.pass.a {
    public static String getPackageSign(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            return packageInfo.signatures.length > 0 ? SecurityUtil.md5(packageInfo.signatures[0].toByteArray(), false) : "";
        } catch (Throwable th) {
            Log.e(th);
            return "";
        }
    }
}
