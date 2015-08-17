package com.baidu.cloudsdk.common.util;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import com.baidu.cloudsdk.social.core.SocialConstants;
/* loaded from: classes.dex */
public class CommonParam extends com.baidu.android.common.util.CommonParam {
    public static String getDeviceInfo() {
        String str = Build.MODEL;
        String str2 = Build.VERSION.RELEASE;
        int i = Build.VERSION.SDK_INT;
        String str3 = Build.MANUFACTURER;
        StringBuilder sb = new StringBuilder();
        sb.append(str.replace("_", "-")).append("_").append(str2).append("_").append(i).append("_").append(str3.replace("_", "-"));
        return sb.toString();
    }

    public static String getUA(Context context, String str, String str2, String str3) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        int i3 = displayMetrics.densityDpi;
        String packageName = context.getPackageName();
        StringBuilder sb = new StringBuilder();
        sb.append(i).append("_").append(i2).append("_").append(i3).append("_").append(SocialConstants.ANDROID_CLIENT_TYPE).append("_").append(str).append("_").append(str2).append("_").append(str3).append("_").append(packageName);
        return sb.toString();
    }
}
