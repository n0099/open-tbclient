package com.baidu.sofire.utility;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
/* loaded from: classes2.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f10450a = {"On7h9W1_KIkIa50wk9Fnl1friw1cdOsubmr_O-Hrgss=", "73Ry_SRX9WDHPoeAkGWfJbuntGR7RQ3rde1s6KyyCoo=", "iQirV45vitYDQfzxgr68ylBY1DWLBKje2Pl428sE27Q=", "czwe2zUrt14MfnaeH474T5prOCIik3agOnBud_KwFa0=", "JzLix2JtXzSSsVkQFD0Cnf37028Rco5rGb7_-t_C8Qk=", "lUApGLCwwTIqYrpC4ZaqkVItjc8DeoJ5fB_pxizrjnc=", "6PzPHS4JINi0q8yUj180JTMbpq1Q44DuQggknxVmVPA=", "fCbyLrInjq1BOByP4wH4mUGBidquiIKIy6zcJCBuKtk=", "qEeaB7chq_oSIUyWhq_EwETFQIu3w3myIFyGD80p_u8=", "UNzyljxPfmKANfePasqvdfmpLS4aJ1v0S1Aj2BGl75o=", "xbOAOB93VGI-kwCx1KZxzESB35X3hv9xe1VSXGErZbY="};

    public static Bundle a(Context context, String str, Bundle bundle) {
        return b(context, str, bundle, "sofire");
    }

    public static Bundle b(Context context, String str, Bundle bundle, String str2) {
        try {
            context.getApplicationContext().getContentResolver();
            return a(context, str, bundle, Uri.parse("content://" + context.getPackageName() + "." + str2 + ".ac.provider"));
        } catch (Throwable unused) {
            c.a();
            return null;
        }
    }

    public static Bundle a(Context context, String str, Bundle bundle, String str2) {
        ProviderInfo[] providerInfoArr;
        try {
            providerInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 8).providers;
        } catch (Throwable unused) {
            c.a();
        }
        if (providerInfoArr != null && providerInfoArr.length > 0) {
            for (String str3 : f10450a) {
                String str4 = new String(g.a("30212102dicudiab".getBytes(), Base64.decode(str3, 10)), "UTF-8");
                if (!TextUtils.isEmpty(str4)) {
                    if ("sofire".equals(str4)) {
                        return null;
                    }
                    StringBuilder sb = new StringBuilder("content://");
                    sb.append(context.getPackageName());
                    sb.append(".");
                    sb.append(str4);
                    sb.append(".ac.provider");
                    String sb2 = sb.toString();
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        if (sb2.contains(providerInfo.authority)) {
                            Bundle a2 = a(context, str, bundle, Uri.parse(sb.toString()));
                            boolean z = a2.getBoolean("handle_flag");
                            String string = a2.getString("server_version");
                            if (z) {
                                if (a(string, str2)) {
                                    return a2;
                                }
                            }
                        }
                    }
                    continue;
                }
            }
            return null;
        }
        return null;
    }

    public static Bundle a(Context context, String str, Bundle bundle, Uri uri) {
        ContentProviderClient contentProviderClient;
        try {
            ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    contentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
                } catch (Throwable unused) {
                    contentProviderClient = null;
                }
                try {
                    Bundle call = contentProviderClient.call(str, null, bundle);
                    if (contentProviderClient != null) {
                        if (Build.VERSION.SDK_INT < 24) {
                            contentProviderClient.release();
                        } else {
                            contentProviderClient.close();
                        }
                    }
                    return call;
                } catch (Throwable unused2) {
                    c.a();
                    if (contentProviderClient != null) {
                        if (Build.VERSION.SDK_INT < 24) {
                            contentProviderClient.release();
                        } else {
                            contentProviderClient.close();
                        }
                    }
                    return null;
                }
            }
            return contentResolver.call(uri, str, (String) null, bundle);
        } catch (Throwable unused3) {
            c.a();
            return null;
        }
    }

    public static boolean a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        String[] split = str.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
        String[] split2 = str2.split(EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX);
        for (int i2 = 0; i2 < split.length && i2 < split2.length; i2++) {
            int intValue = Integer.valueOf(split[i2]).intValue() - Integer.valueOf(split2[i2]).intValue();
            if (intValue != 0) {
                return intValue > 0;
            }
        }
        return split.length > split2.length;
    }
}
