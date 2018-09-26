package cn.jiguang.d.d;

import android.content.Context;
/* loaded from: classes3.dex */
public final class d {
    public static String a(Context context) {
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            if (str.length() > 30) {
                cn.jiguang.e.c.d("ServiceHelper", "The versionName is not valid, Please check your AndroidManifest.xml");
                return str.substring(0, 30);
            }
            return str;
        } catch (Throwable th) {
            return "Unknown";
        }
    }
}
