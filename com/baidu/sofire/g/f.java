package com.baidu.sofire.g;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.android.internal.http.multipart.Part;
import com.baidu.tbadk.core.util.FieldBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f11252a = {"On7h9W1_KIkIa50wk9Fnl1friw1cdOsubmr_O-Hrgss=", "73Ry_SRX9WDHPoeAkGWfJbuntGR7RQ3rde1s6KyyCoo=", "iQirV45vitYDQfzxgr68ylBY1DWLBKje2Pl428sE27Q=", "czwe2zUrt14MfnaeH474T5prOCIik3agOnBud_KwFa0=", "JzLix2JtXzSSsVkQFD0Cnf37028Rco5rGb7_-t_C8Qk=", "lUApGLCwwTIqYrpC4ZaqkVItjc8DeoJ5fB_pxizrjnc=", "6PzPHS4JINi0q8yUj180JTMbpq1Q44DuQggknxVmVPA=", "fCbyLrInjq1BOByP4wH4mUGBidquiIKIy6zcJCBuKtk=", "qEeaB7chq_oSIUyWhq_EwETFQIu3w3myIFyGD80p_u8=", "UNzyljxPfmKANfePasqvdfmpLS4aJ1v0S1Aj2BGl75o="};

    /* renamed from: b  reason: collision with root package name */
    public static String f11253b = "";

    public static void a(Context context) {
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            String m = eVar.m();
            if (TextUtils.isEmpty(m)) {
                return;
            }
            String f2 = d.f(m);
            if (TextUtils.isEmpty(f2) || f2.equals(eVar.l())) {
                return;
            }
            eVar.a(f2);
        } catch (Throwable unused) {
            d.a();
        }
    }

    public static synchronized String b(Context context) {
        synchronized (f.class) {
            try {
                if (!TextUtils.isEmpty(f11253b)) {
                    return f11253b;
                }
                com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
                String m = eVar.m();
                if (!TextUtils.isEmpty(m)) {
                    String f2 = d.f(m);
                    if (!TextUtils.isEmpty(f2)) {
                        f11253b = f2;
                        return f2;
                    }
                }
                String l = eVar.l();
                if (!TextUtils.isEmpty(l)) {
                    eVar.b(new String(Base64.encode(a.a("30212102dicudiab".getBytes(), l.getBytes("UTF-8")), 10), "UTF-8"));
                    f11253b = l;
                    return l;
                }
                String i2 = i(context);
                String h2 = r.h(context);
                if (TextUtils.isEmpty(h2)) {
                    h2 = "0";
                }
                String str = i2 + FieldBuilder.SE + new StringBuffer(h2).reverse().toString();
                String str2 = new String(Base64.encode(a.a("30212102dicudiab".getBytes(), str.getBytes("UTF-8")), 10), "UTF-8");
                String l2 = eVar.l();
                if (TextUtils.isEmpty(l2)) {
                    eVar.a(str);
                    eVar.b(str2);
                    f11253b = str;
                    return str;
                }
                f11253b = l2;
                return l2;
            } catch (Throwable unused) {
                d.a();
                return "";
            }
        }
    }

    public static String c(Context context) {
        if (!TextUtils.isEmpty(f11253b)) {
            return f11253b;
        }
        String h2 = h(context);
        if (!TextUtils.isEmpty(h2)) {
            f11253b = h2;
            return h2;
        }
        return b(context);
    }

    public static String d(Context context) {
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            String string = eVar.f11222b.getString("sgud", "");
            if (TextUtils.isEmpty(string)) {
                if (Build.VERSION.SDK_INT > 25) {
                    return "";
                }
                String h2 = r.h(context);
                String i2 = r.i(context);
                if (TextUtils.isEmpty(h2) && TextUtils.isEmpty(i2)) {
                    return "";
                }
                byte[] bytes = (h2 + ":" + i2).getBytes();
                for (int i3 = 0; i3 < bytes.length; i3++) {
                    bytes[i3] = (byte) (bytes[i3] ^ 246);
                }
                String a2 = n.a(bytes);
                if (TextUtils.isEmpty(a2)) {
                    return "";
                }
                eVar.f11224d.putString("sgud", a2);
                eVar.f11224d.commit();
                return a2;
            }
            return string;
        } catch (Throwable unused) {
            d.a();
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037 A[Catch: all -> 0x0091, TryCatch #1 {all -> 0x0091, blocks: (B:3:0x0002, B:11:0x0023, B:13:0x0037, B:16:0x0062, B:19:0x006e, B:10:0x0020), top: B:25:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0062 A[Catch: all -> 0x0091, TryCatch #1 {all -> 0x0091, blocks: (B:3:0x0002, B:11:0x0023, B:13:0x0037, B:16:0x0062, B:19:0x006e, B:10:0x0020), top: B:25:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String e(Context context) {
        String str;
        String string;
        try {
            String i2 = r.i(context);
            try {
                str = Settings.System.getString(context.getContentResolver(), d.f("ARQJ8IArCy4jLSUJ6i4PbDdNue2ww1CwfUTDQn8F4ug="));
                try {
                    if (TextUtils.isEmpty(str)) {
                        str = r.h(context);
                    }
                } catch (Throwable unused) {
                    d.a();
                    string = Settings.System.getString(context.getContentResolver(), d.f("FLI7RPHK558lhmIMdK5V18TV2libLOeHJlQPRa8lKBaxRs4pujQo1mXKtiCUFVkg"));
                    if (TextUtils.isEmpty(string)) {
                    }
                    if (string != null) {
                    }
                }
            } catch (Throwable unused2) {
                str = "";
            }
            string = Settings.System.getString(context.getContentResolver(), d.f("FLI7RPHK558lhmIMdK5V18TV2libLOeHJlQPRa8lKBaxRs4pujQo1mXKtiCUFVkg"));
            if (TextUtils.isEmpty(string)) {
                string = Settings.System.getString(context.getContentResolver(), a((d.f("q6R8gqLUgHDSsH6dbL27xN7Qr9sa0MxMqXTV66AWUUE=") + str + i2).getBytes()));
            }
            if (string != null) {
                return "";
            }
            String h2 = r.h(context);
            if (TextUtils.isEmpty(h2)) {
                h2 = "0";
            }
            String stringBuffer = new StringBuffer(h2).reverse().toString();
            return string + FieldBuilder.SE + stringBuffer;
        } catch (Throwable unused3) {
            return "";
        }
    }

    public static String f(Context context) {
        try {
            try {
                String string = r.b(context) ? Settings.System.getString(context.getContentResolver(), d.f("ARQJ8IArCy4jLSUJ6i4PbDdNue2ww1CwfUTDQn8F4ug=")) : "";
                if (TextUtils.isEmpty(string)) {
                    string = r.h(context);
                }
                String h2 = r.h(context);
                if (TextUtils.isEmpty(h2)) {
                    h2 = "0";
                }
                String stringBuffer = new StringBuffer(h2).reverse().toString();
                String a2 = a(context, string);
                if (!TextUtils.isEmpty(a2)) {
                    return a2 + FieldBuilder.SE + stringBuffer;
                }
            } catch (Exception unused) {
            }
            return "";
        } catch (Throwable unused2) {
            d.a();
            return "";
        }
    }

    public static String g(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
                return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
            }
            return displayMetrics.heightPixels + "*" + displayMetrics.widthPixels;
        } catch (Exception unused) {
            d.a();
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00c2 A[Catch: all -> 0x00d2, TRY_LEAVE, TryCatch #4 {all -> 0x00dd, blocks: (B:3:0x0002, B:11:0x0021, B:14:0x0026, B:16:0x0032, B:21:0x0051, B:23:0x0057, B:7:0x0009, B:18:0x0035, B:27:0x0062, B:29:0x0085, B:31:0x008f, B:37:0x00a5, B:51:0x00c2, B:42:0x00af, B:49:0x00bc, B:40:0x00aa), top: B:67:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00cf A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String h(Context context) {
        ContentProviderClient contentProviderClient;
        Bundle bundle;
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                ProviderInfo[] providerInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 8).providers;
                if (providerInfoArr != null && providerInfoArr.length > 0) {
                    ContentResolver contentResolver = context.getContentResolver();
                    boolean z = false;
                    for (String str : f11252a) {
                        String str2 = new String(a.a("30212102dicudiab".getBytes(), Base64.decode(str, 10), true), "UTF-8");
                        if (!TextUtils.isEmpty(str2)) {
                            boolean z2 = "sofire".equals(str2) ? true : z;
                            String str3 = "content://" + context.getPackageName() + "." + str2 + ".ac.provider";
                            for (ProviderInfo providerInfo : providerInfoArr) {
                                if (str3.contains(providerInfo.authority)) {
                                    Uri parse = Uri.parse(str3);
                                    if (Build.VERSION.SDK_INT >= 17) {
                                        try {
                                            contentProviderClient = contentResolver.acquireUnstableContentProviderClient(parse);
                                        } catch (Throwable unused) {
                                            contentProviderClient = null;
                                        }
                                        try {
                                            bundle = contentProviderClient.call("getRemoteZid", null, null);
                                            if (contentProviderClient != null) {
                                                contentProviderClient.release();
                                            }
                                        } catch (Throwable unused2) {
                                            d.a();
                                            if (contentProviderClient != null) {
                                                contentProviderClient.release();
                                            }
                                            bundle = null;
                                            if (bundle == null) {
                                            }
                                        }
                                    } else {
                                        bundle = contentResolver.call(parse, "getRemoteZid", (String) null, (Bundle) null);
                                    }
                                    if (bundle == null) {
                                        String string = bundle.getString("_zid");
                                        if (!TextUtils.isEmpty(string)) {
                                            return string;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                            if (z2) {
                                break;
                            }
                            z = z2;
                        }
                    }
                }
                return "";
            }
        } catch (Throwable unused3) {
            d.a();
        }
        return "";
    }

    public static String i(Context context) {
        String str;
        String str2 = "";
        try {
            str = r.h(context);
        } catch (Throwable unused) {
            str = "";
        }
        try {
            str2 = r.i(context);
        } catch (Throwable unused2) {
            d.a();
            String uuid = UUID.randomUUID().toString();
            return a((str + str2 + uuid).getBytes());
        }
        String uuid2 = UUID.randomUUID().toString();
        return a((str + str2 + uuid2).getBytes());
    }

    public static String c() {
        return Build.MANUFACTURER;
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
            d.a();
            return null;
        }
    }

    public static String d() {
        return Build.MODEL;
    }

    public static String e() {
        return Build.VERSION.RELEASE;
    }

    public static String a(Context context, String str) {
        if (!TextUtils.isEmpty(str) && r.c(context)) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(externalStorageDirectory, d.f("u_lhldj5Nkwulw6YvIU2wr_ieZRcYQnQZ7zSlbUYnYY=") + "/" + d.f("u2fjUEpcZJL7IE6RlBqIRmFJW_FjZrNApjdMKDgt7FM="))));
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
                Object[] split = new String(a.a("30212102dicudiab", "30212102dicudiab", Base64.decode(sb.toString().getBytes(), 0))).split("=");
                return (split != null && split.length == 2 && str.equals(split[0])) ? split[1] : "";
            } catch (Exception unused) {
                d.a();
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
