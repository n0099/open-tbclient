package com.baidu.sofire.utility;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.android.internal.http.multipart.Part;
import com.baidu.sofire.utility.j;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static String f10411a = "";

    public static void a(Context context) {
        try {
            com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
            String l = a2.l();
            if (TextUtils.isEmpty(l)) {
                return;
            }
            String e2 = c.e(l);
            if (TextUtils.isEmpty(e2) || e2.equals(a2.k())) {
                return;
            }
            a2.b(e2);
        } catch (Throwable unused) {
            c.a();
        }
    }

    public static synchronized String b(Context context) {
        synchronized (e.class) {
            try {
                if (!TextUtils.isEmpty(f10411a)) {
                    return f10411a;
                }
                com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
                String l = a2.l();
                if (!TextUtils.isEmpty(l)) {
                    String e2 = c.e(l);
                    if (!TextUtils.isEmpty(e2)) {
                        f10411a = e2;
                        return e2;
                    }
                }
                String k = a2.k();
                if (!TextUtils.isEmpty(k)) {
                    a2.c(new String(Base64.encode(g.a("30212102dicudiab".getBytes(), k.getBytes("UTF-8"), true), 10), "UTF-8"));
                    f10411a = k;
                    return k;
                }
                String g2 = g(context);
                String h2 = s.h(context);
                if (TextUtils.isEmpty(h2)) {
                    h2 = "0";
                }
                String str = g2 + "|" + new StringBuffer(h2).reverse().toString();
                String str2 = new String(Base64.encode(g.a("30212102dicudiab".getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8");
                String k2 = a2.k();
                if (TextUtils.isEmpty(k2)) {
                    a2.b(str);
                    a2.c(str2);
                    f10411a = str;
                    return str;
                }
                f10411a = k2;
                return k2;
            } catch (Throwable unused) {
                c.a();
                return "";
            }
        }
    }

    public static String c(Context context) {
        try {
            com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
            String string = a2.f10323c.getString("sgud", "");
            if (TextUtils.isEmpty(string)) {
                if (Build.VERSION.SDK_INT > 25) {
                    return "";
                }
                String h2 = s.h(context);
                String i2 = s.i(context);
                if (TextUtils.isEmpty(h2) && TextUtils.isEmpty(i2)) {
                    return "";
                }
                byte[] bytes = (h2 + ":" + i2).getBytes();
                for (int i3 = 0; i3 < bytes.length; i3++) {
                    bytes[i3] = (byte) (bytes[i3] ^ 246);
                }
                String a3 = o.a(bytes);
                if (TextUtils.isEmpty(a3)) {
                    return "";
                }
                a2.f10324d.putString("sgud", a3);
                a2.f10324d.commit();
                return a3;
            }
            return string;
        } catch (Throwable unused) {
            c.a();
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037 A[Catch: all -> 0x0091, TryCatch #1 {all -> 0x0091, blocks: (B:3:0x0002, B:11:0x0023, B:13:0x0037, B:16:0x0062, B:19:0x006e, B:10:0x0020), top: B:25:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0062 A[Catch: all -> 0x0091, TryCatch #1 {all -> 0x0091, blocks: (B:3:0x0002, B:11:0x0023, B:13:0x0037, B:16:0x0062, B:19:0x006e, B:10:0x0020), top: B:25:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(Context context) {
        String str;
        String string;
        try {
            String i2 = s.i(context);
            try {
                str = Settings.System.getString(context.getContentResolver(), c.e("ARQJ8IArCy4jLSUJ6i4PbDdNue2ww1CwfUTDQn8F4ug="));
                try {
                    if (TextUtils.isEmpty(str)) {
                        str = s.h(context);
                    }
                } catch (Throwable unused) {
                    c.a();
                    string = Settings.System.getString(context.getContentResolver(), c.e("FLI7RPHK558lhmIMdK5V18TV2libLOeHJlQPRa8lKBaxRs4pujQo1mXKtiCUFVkg"));
                    if (TextUtils.isEmpty(string)) {
                    }
                    if (string != null) {
                    }
                }
            } catch (Throwable unused2) {
                str = "";
            }
            string = Settings.System.getString(context.getContentResolver(), c.e("FLI7RPHK558lhmIMdK5V18TV2libLOeHJlQPRa8lKBaxRs4pujQo1mXKtiCUFVkg"));
            if (TextUtils.isEmpty(string)) {
                string = Settings.System.getString(context.getContentResolver(), a((c.e("q6R8gqLUgHDSsH6dbL27xN7Qr9sa0MxMqXTV66AWUUE=") + str + i2).getBytes()));
            }
            if (string != null) {
                return "";
            }
            String h2 = s.h(context);
            if (TextUtils.isEmpty(h2)) {
                h2 = "0";
            }
            String stringBuffer = new StringBuffer(h2).reverse().toString();
            return string + "|" + stringBuffer;
        } catch (Throwable unused3) {
            return "";
        }
    }

    public static String e(Context context) {
        try {
            try {
                String string = s.b(context) ? Settings.System.getString(context.getContentResolver(), c.e("ARQJ8IArCy4jLSUJ6i4PbDdNue2ww1CwfUTDQn8F4ug=")) : "";
                if (TextUtils.isEmpty(string)) {
                    string = s.h(context);
                }
                String h2 = s.h(context);
                if (TextUtils.isEmpty(h2)) {
                    h2 = "0";
                }
                String stringBuffer = new StringBuffer(h2).reverse().toString();
                String a2 = a(context, string);
                if (!TextUtils.isEmpty(a2)) {
                    return a2 + "|" + stringBuffer;
                }
            } catch (Exception unused) {
            }
            return "";
        } catch (Throwable unused2) {
            c.a();
            return "";
        }
    }

    public static String f(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
                return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
            }
            return displayMetrics.heightPixels + "*" + displayMetrics.widthPixels;
        } catch (Exception unused) {
            c.a();
            return "";
        }
    }

    public static String g(Context context) {
        String str;
        String str2 = "";
        try {
            str = s.h(context);
        } catch (Throwable unused) {
            str = "";
        }
        try {
            str2 = s.i(context);
        } catch (Throwable unused2) {
            c.a();
            String uuid = UUID.randomUUID().toString();
            return a((str + str2 + uuid).getBytes());
        }
        String uuid2 = UUID.randomUUID().toString();
        return a((str + str2 + uuid2).getBytes());
    }

    public static String a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                String upperCase = Integer.toHexString(b2 & 255).toUpperCase();
                if (upperCase.length() == 1) {
                    sb.append("0");
                }
                sb.append(upperCase);
                sb.append("");
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            c.a();
            return null;
        }
    }

    public static String e() {
        return Build.VERSION.RELEASE;
    }

    public static String c() {
        return Build.MANUFACTURER;
    }

    public static String d() {
        return Build.MODEL;
    }

    public static String a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && s.c(context)) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(externalStorageDirectory, c.e("u_lhldj5Nkwulw6YvIU2wr_ieZRcYQnQZ7zSlbUYnYY=") + "/" + c.e("u2fjUEpcZJL7IE6RlBqIRmFJW_FjZrNApjdMKDgt7FM="))));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append(Part.CRLF);
                }
                bufferedReader.close();
                Object[] split = new String(j.a.a("30212102dicudiab", "30212102dicudiab", Base64.decode(sb.toString().getBytes(), 0))).split("=");
                return (split != null && split.length == 2 && str.equals(split[0])) ? split[1] : "";
            } catch (Exception unused) {
                c.a();
                return "";
            }
        }
        return "";
    }

    public static String b() {
        return Build.VERSION.SDK_INT > 7 ? Build.HARDWARE : "";
    }

    public static String a() {
        return Build.DISPLAY;
    }
}
