package com.baidu.android.systemmonitor.c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.format.Formatter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes.dex */
public final class c {
    private static final String b = c.class.getSimpleName();
    static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private c() {
    }

    public static com.baidu.android.systemmonitor.localapp.a a(Context context, String str) {
        PackageInfo b2 = b(context, str);
        if (b2 == null) {
            return null;
        }
        com.baidu.android.systemmonitor.localapp.a aVar = new com.baidu.android.systemmonitor.localapp.a();
        if ((b2.applicationInfo.flags & 1) == 1) {
            aVar.g = true;
        }
        aVar.f = b2.versionCode;
        aVar.b = b2.versionName;
        aVar.e(b2.packageName);
        aVar.c((String) b2.applicationInfo.loadLabel(context.getPackageManager()));
        aVar.d(a(b2.packageName, b2.versionCode));
        a(context, b2, aVar);
        try {
            int intValue = ((Integer) b2.getClass().getField("installLocation").get(b2)).intValue();
            if (intValue != 0 && intValue != 2) {
                aVar.i = 1;
            } else if (Build.VERSION.SDK_INT < 8) {
                aVar.i = 2;
            } else if ((b2.applicationInfo.flags & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START) != 0) {
                aVar.i = 3;
            } else {
                aVar.i = 2;
            }
        } catch (IllegalAccessException e) {
        } catch (IllegalArgumentException e2) {
        } catch (NoSuchFieldException e3) {
        }
        return aVar;
    }

    public static String a(String str) {
        long j = 0;
        if (str == null || str.length() < 32) {
            return "-1";
        }
        String substring = str.substring(8, 24);
        long j2 = 0;
        for (int i = 0; i < 8; i++) {
            j2 = (j2 * 16) + Integer.parseInt(substring.substring(i, i + 1), 16);
        }
        for (int i2 = 8; i2 < substring.length(); i2++) {
            j = (j * 16) + Integer.parseInt(substring.substring(i2, i2 + 1), 16);
        }
        return String.valueOf((j + j2) & 4294967295L);
    }

    public static String a(String str, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("@").append(i);
        return sb.toString();
    }

    public static List a(Context context) {
        System.currentTimeMillis();
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        HashMap hashMap = new HashMap();
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            hashMap.put(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.packageName);
        }
        ArrayList arrayList = new ArrayList();
        for (PackageInfo packageInfo : installedPackages) {
            if ((packageInfo.applicationInfo.flags & 1) != 1 || hashMap.containsKey(packageInfo.packageName)) {
                if (!packageInfo.packageName.equalsIgnoreCase(context.getPackageName())) {
                    arrayList.add(packageInfo);
                }
            }
        }
        return arrayList;
    }

    public static void a(Context context, PackageInfo packageInfo, com.baidu.android.systemmonitor.localapp.a aVar) {
        String str = packageInfo.applicationInfo.publicSourceDir;
        File file = new File(str);
        long length = file.length();
        long lastModified = file.lastModified();
        aVar.b(Formatter.formatFileSize(context, length));
        aVar.a(length);
        aVar.a(str);
        aVar.e = lastModified;
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArr2;
        Exception e;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            bArr2 = null;
            e = e2;
        }
        try {
            byteArrayOutputStream.close();
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return bArr2;
        }
        return bArr2;
    }

    public static PackageInfo b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 8256);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static String b(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return c(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List b(Context context) {
        System.currentTimeMillis();
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        ArrayList arrayList = new ArrayList();
        for (PackageInfo packageInfo : installedPackages) {
            com.baidu.android.systemmonitor.localapp.a aVar = new com.baidu.android.systemmonitor.localapp.a();
            if ((packageInfo.applicationInfo.flags & 1) == 1) {
                aVar.g = true;
            }
            aVar.f = packageInfo.versionCode;
            aVar.b = packageInfo.versionName;
            aVar.e(packageInfo.packageName);
            aVar.c((String) packageInfo.applicationInfo.loadLabel(context.getPackageManager()));
            aVar.d(a(packageInfo.packageName, packageInfo.versionCode));
            a(context, packageInfo, aVar);
            try {
                int intValue = ((Integer) packageInfo.getClass().getField("installLocation").get(packageInfo)).intValue();
                if (intValue != 0 && intValue != 2) {
                    aVar.i = 1;
                } else if (Build.VERSION.SDK_INT < 8) {
                    aVar.i = 2;
                } else if ((packageInfo.applicationInfo.flags & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START) != 0) {
                    aVar.i = 3;
                } else {
                    aVar.i = 2;
                }
            } catch (IllegalAccessException e) {
            } catch (IllegalArgumentException e2) {
            } catch (NoSuchFieldException e3) {
            }
            arrayList.add(aVar);
        }
        return arrayList;
    }

    public static com.baidu.android.systemmonitor.localapp.a c(Context context, String str) {
        PackageInfo b2 = b(context, str);
        if (b2 == null) {
            return null;
        }
        com.baidu.android.systemmonitor.localapp.a aVar = new com.baidu.android.systemmonitor.localapp.a();
        ApplicationInfo applicationInfo = b2.applicationInfo;
        if (applicationInfo == null) {
            aVar.g = false;
        } else if ((applicationInfo.flags & 1) == 1) {
            if ((applicationInfo.flags & 128) == 128) {
                aVar.a(true);
            }
            aVar.g = true;
        } else {
            aVar.g = false;
        }
        aVar.e(b2.packageName);
        if (applicationInfo != null) {
            aVar.c((String) applicationInfo.loadLabel(context.getPackageManager()));
        }
        aVar.b = b2.versionName;
        aVar.f = b2.versionCode;
        if (applicationInfo != null) {
            aVar.h = (Build.VERSION.SDK_INT >= 8 ? applicationInfo.flags & AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START : 1) != 0;
        } else {
            aVar.h = false;
        }
        aVar.d(a(b2.packageName, b2.versionCode));
        aVar.b(context);
        a(context, b2, aVar);
        return aVar;
    }

    public static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(a[(bArr[i] & 240) >>> 4]);
            sb.append(a[bArr[i] & 15]);
        }
        return sb.toString();
    }

    public static void d(Context context, String str) {
        Intent intent = new Intent("android.intent.action.DELETE", Uri.parse("package:" + str));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }
}
