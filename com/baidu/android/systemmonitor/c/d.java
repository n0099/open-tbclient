package com.baidu.android.systemmonitor.c;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.android.nebula.util.BDLocationManager;
import com.google.protobuf.CodedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class d {
    private static final HashMap a = new HashMap();

    static {
        a.put("&lt;", "<");
        a.put("&gt;", ">");
        a.put("&amp;", "&");
        a.put("&quot;", "\"");
        a.put("&#039;", "'");
    }

    private d() {
    }

    public static int a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0 ? 1 : 0;
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : a.keySet()) {
                str = str.replaceAll(str2, (String) a.get(str2));
            }
        }
        return str;
    }

    public static boolean a() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    public static boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        for (NetworkInfo networkInfo : allNetworkInfo) {
            if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(File file, File file2) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            boolean a2 = a(fileInputStream, file2);
            fileInputStream.close();
            return a2;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean a(InputStream inputStream, File file) {
        boolean z = false;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
            while (true) {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            try {
                fileOutputStream.getFD().sync();
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileOutputStream.close();
            z = true;
            return true;
        } catch (IOException e2) {
            return z;
        }
    }

    public static int b(Context context) {
        String str;
        NetworkInfo activeNetworkInfo;
        if (context != null && (activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isConnectedOrConnecting()) {
            if (!activeNetworkInfo.getTypeName().toLowerCase().equals("wifi")) {
                str = "2G";
                switch (activeNetworkInfo.getSubtype()) {
                    case 3:
                        str = "3G";
                        break;
                    case 5:
                        str = "3G";
                        break;
                    case 6:
                        str = "3G";
                        break;
                    case 7:
                        str = "3G";
                        break;
                    case 8:
                        str = "3G";
                        break;
                    case 9:
                        str = "3G";
                        break;
                    case 10:
                        str = "3G";
                        break;
                    case 12:
                        str = "3G";
                        break;
                    case 13:
                        str = "4G";
                        break;
                    case 14:
                        str = "3G";
                        break;
                    case 15:
                        str = "3G";
                        break;
                }
            } else {
                str = "WF";
            }
        } else {
            str = "";
        }
        if (str.equals("WF")) {
            return 1;
        }
        if (str.equals("2G")) {
            return 2;
        }
        if (str.equals("3G")) {
            return 3;
        }
        return str.equals("4G") ? 4 : 0;
    }

    public static long b() {
        if (a()) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        }
        return -1L;
    }

    private static String b(String str) {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(str), 256);
        try {
            return bufferedReader.readLine();
        } finally {
            bufferedReader.close();
        }
    }

    public static long c() {
        if (a()) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        }
        return -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(Context context) {
        String str;
        String stringBuffer;
        TelephonyManager telephonyManager;
        String d = b.d(context);
        if (d == null || d.length() <= 0) {
            try {
                telephonyManager = (TelephonyManager) context.getSystemService("phone");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (telephonyManager != null) {
                str = telephonyManager.getDeviceId();
                if (TextUtils.isEmpty(str)) {
                    stringBuffer = new StringBuffer(str).reverse().toString();
                } else {
                    Random random = new Random();
                    StringBuffer stringBuffer2 = new StringBuffer(15);
                    for (int i = 0; i < 15; i++) {
                        stringBuffer2.append(random.nextInt(10));
                    }
                    stringBuffer = stringBuffer2.toString();
                }
                b.b(context, stringBuffer);
                return stringBuffer;
            }
            str = d;
            if (TextUtils.isEmpty(str)) {
            }
            b.b(context, stringBuffer);
            return stringBuffer;
        }
        return d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
        r0 = r0.getHostAddress().toString();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d() {
        String str;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            loop0: while (true) {
                if (!networkInterfaces.hasMoreElements()) {
                    str = null;
                    break;
                }
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        break loop0;
                    }
                }
            }
        } catch (Exception e) {
            str = null;
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static String d(Context context) {
        String subscriberId = ((TelephonyManager) context.getApplicationContext().getSystemService("phone")).getSubscriberId();
        return subscriberId == null ? "" : subscriberId;
    }

    public static long e() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    public static String e(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        String valueOf = String.valueOf(displayMetrics.widthPixels);
        return valueOf + "*" + String.valueOf(displayMetrics.heightPixels);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x001f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int f(Context context) {
        Cursor cursor;
        int count;
        Cursor cursor2 = null;
        try {
            Cursor query = context.getContentResolver().query(MediaStore.Images.Media.INTERNAL_CONTENT_URI, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        count = query.getCount();
                        if (query == null) {
                            try {
                                query.close();
                                return count;
                            } catch (Exception e) {
                                return count;
                            }
                        }
                        return count;
                    }
                } catch (Exception e2) {
                    cursor = query;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e3) {
                        }
                        return 0;
                    }
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = query;
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            }
            count = 0;
            if (query == null) {
            }
        } catch (Exception e5) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static long f() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockCount() * statFs.getBlockSize();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x001f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int g(Context context) {
        Cursor cursor;
        int count;
        Cursor cursor2 = null;
        try {
            Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        count = query.getCount();
                        if (query == null) {
                            try {
                                query.close();
                                return count;
                            } catch (Exception e) {
                                return count;
                            }
                        }
                        return count;
                    }
                } catch (Exception e2) {
                    cursor = query;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e3) {
                        }
                        return 0;
                    }
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = query;
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            }
            count = 0;
            if (query == null) {
            }
        } catch (Exception e5) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String g() {
        try {
            Matcher matcher = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(b("/proc/version"));
            if (matcher.matches() && matcher.groupCount() >= 4) {
                return matcher.group(1) + "\n" + matcher.group(2) + " " + matcher.group(3) + "\n" + matcher.group(4);
            }
            return "Unavailable";
        } catch (IOException e) {
            return "Unavailable";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x001f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int h(Context context) {
        Cursor cursor;
        int count;
        Cursor cursor2 = null;
        try {
            Cursor query = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        count = query.getCount();
                        if (query == null) {
                            try {
                                query.close();
                                return count;
                            } catch (Exception e) {
                                return count;
                            }
                        }
                        return count;
                    }
                } catch (Exception e2) {
                    cursor = query;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e3) {
                        }
                        return 0;
                    }
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = query;
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            }
            count = 0;
            if (query == null) {
            }
        } catch (Exception e5) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String h() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls.newInstance(), "gsm.version.baseband", "no message");
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x001f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int i(Context context) {
        Cursor cursor;
        int count;
        Cursor cursor2 = null;
        try {
            Cursor query = context.getContentResolver().query(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        count = query.getCount();
                        if (query == null) {
                            try {
                                query.close();
                                return count;
                            } catch (Exception e) {
                                return count;
                            }
                        }
                        return count;
                    }
                } catch (Exception e2) {
                    cursor = query;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e3) {
                        }
                        return 0;
                    }
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = query;
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            }
            count = 0;
            if (query == null) {
            }
        } catch (Exception e5) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x001f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int j(Context context) {
        Cursor cursor;
        int count;
        Cursor cursor2 = null;
        try {
            Cursor query = context.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        count = query.getCount();
                        if (query == null) {
                            try {
                                query.close();
                                return count;
                            } catch (Exception e) {
                                return count;
                            }
                        }
                        return count;
                    }
                } catch (Exception e2) {
                    cursor = query;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e3) {
                        }
                        return 0;
                    }
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = query;
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            }
            count = 0;
            if (query == null) {
            }
        } catch (Exception e5) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0028 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int k(Context context) {
        Cursor cursor;
        int count;
        Cursor cursor2 = null;
        try {
            Cursor query = context.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, new String[]{"_id"}, null, null, null);
            if (query == null) {
            }
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        count = query.getCount();
                        if (query == null) {
                            try {
                                query.close();
                                return count;
                            } catch (Exception e) {
                                return count;
                            }
                        }
                        return count;
                    }
                } catch (Exception e2) {
                    cursor = query;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e3) {
                        }
                    }
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = query;
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            }
            count = 0;
            if (query == null) {
            }
        } catch (Exception e5) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0023 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int l(Context context) {
        Cursor cursor;
        Cursor cursor2;
        int count;
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://icc/adn"), null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        count = cursor.getCount();
                        if (cursor == null) {
                            try {
                                cursor.close();
                                return count;
                            } catch (Exception e) {
                                return count;
                            }
                        }
                        return count;
                    }
                } catch (Exception e2) {
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e3) {
                        }
                    }
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            }
            count = 0;
            if (cursor == null) {
            }
        } catch (Exception e5) {
            cursor2 = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    public static int m(Context context) {
        return a(context, "android.permission.INSTALL_PACKAGES");
    }

    public static int n(Context context) {
        return BDLocationManager.a(context) ? 1 : 0;
    }

    public static int o(Context context) {
        return a(context, "android.permission.ACCESS_FINE_LOCATION");
    }

    public static int p(Context context) {
        return a(context, "android.permission.GET_TASKS");
    }

    public static int q(Context context) {
        return a(context, "android.permission.READ_CONTACTS");
    }

    public static int r(Context context) {
        if (Build.VERSION.SDK_INT > 15) {
            return a(context, "android.permission.READ_CALL_LOG");
        }
        return 1;
    }

    public static int s(Context context) {
        return a(context, "android.permission.READ_SMS");
    }

    public static int t(Context context) {
        return a(context, "android.permission.RECEIVE_BOOT_COMPLETED");
    }
}
