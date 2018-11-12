package com.baidu.b.a.h;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    private static int aaB = -1;

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        ConnectivityManager connectivityManager;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    public static boolean isWifiNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 1;
    }

    public static String sf() {
        Application application = AppRuntime.getApplication();
        try {
            return application.getPackageManager().getPackageInfo(application.getPackageName(), 64).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String ae(String str, String str2) {
        return l(str, str2, File.separator);
    }

    public static String l(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            if (str.endsWith(str3)) {
                if (str2.startsWith(str3)) {
                    return str.concat(str2.substring(str3.length()));
                }
                return str.concat(str2);
            } else if (str2.startsWith(str3)) {
                return str.concat(str2);
            } else {
                return str.concat(str3).concat(str2);
            }
        }
        return str2;
    }

    public static boolean g(String str, long j) {
        File file = new File(str);
        return file.exists() && file.length() == j;
    }

    public static boolean af(String str, String str2) {
        if (str2 == null) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return i.toMd5(file, true).equals(str2.toUpperCase());
        }
        return false;
    }

    public static byte[] d(OutputStream outputStream) {
        if (!(outputStream instanceof ByteArrayOutputStream)) {
            return null;
        }
        return ((ByteArrayOutputStream) outputStream).toByteArray();
    }

    public static String sg() {
        return c.se().processor;
    }

    public static String sh() {
        return c.se().features;
    }

    public static String si() {
        long availableInternalMemorySize = (j.getAvailableInternalMemorySize() / 1024) * 1024;
        return availableInternalMemorySize < 0 ? String.valueOf((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) : String.valueOf(availableInternalMemorySize);
    }

    public static String sj() {
        long totalInternalMemorySize = (j.getTotalInternalMemorySize() / 1024) * 1024;
        return totalInternalMemorySize < 0 ? String.valueOf((int) ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) : String.valueOf(totalInternalMemorySize);
    }

    public static String bI(int i) {
        return AppRuntime.getApplication().getResources().getString(i);
    }

    public static String n(String... strArr) {
        JSONObject jSONObject = new JSONObject();
        if (strArr != null) {
            try {
                if (strArr.length > 0 && strArr.length % 2 == 0) {
                    for (int i = 0; i < strArr.length; i += 2) {
                        String str = strArr[i];
                        String str2 = strArr[i + 1];
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                            jSONObject.put(str, str2);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ",errmsg:" + jSONObject.toString();
    }
}
