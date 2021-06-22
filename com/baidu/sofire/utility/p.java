package com.baidu.sofire.utility;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.UUID;
/* loaded from: classes2.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static String f10435a = "";

    public static String a(Context context) {
        if (TextUtils.isEmpty(f10435a)) {
            new p();
            f10435a = b(context);
        }
        return f10435a;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d9 A[Catch: all -> 0x00f9, TryCatch #3 {all -> 0x00f9, blocks: (B:33:0x00b3, B:36:0x00ba, B:39:0x00c1, B:41:0x00d9, B:43:0x00df, B:45:0x00e9, B:44:0x00e6), top: B:64:0x00b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e6 A[Catch: all -> 0x00f9, TryCatch #3 {all -> 0x00f9, blocks: (B:33:0x00b3, B:36:0x00ba, B:39:0x00c1, B:41:0x00d9, B:43:0x00df, B:45:0x00e9, B:44:0x00e6), top: B:64:0x00b3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context) {
        boolean z;
        boolean z2;
        File file;
        FileWriter fileWriter;
        String c2 = c(context);
        boolean z3 = true;
        if (TextUtils.isEmpty(c2)) {
            c2 = d(context);
            if (TextUtils.isEmpty(c2)) {
                c2 = e(context);
                if (TextUtils.isEmpty(c2)) {
                    String h2 = s.h(context);
                    String i2 = s.i(context);
                    if (TextUtils.isEmpty(h2) && TextUtils.isEmpty(i2)) {
                        c2 = "1|" + o.a(UUID.randomUUID().toString());
                    } else {
                        StringBuilder sb = new StringBuilder("0|");
                        sb.append(o.a(h2 + i2));
                        c2 = sb.toString();
                    }
                    z = true;
                    z2 = true;
                    if (!z3 || TextUtils.isEmpty(c(context))) {
                        com.baidu.sofire.h.a.a(context).d(c2);
                    }
                    if (!z || TextUtils.isEmpty(d(context))) {
                        a(context, "com.q.zi.i", c2);
                    }
                    if (b(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION) && (z2 || TextUtils.isEmpty(e(context)))) {
                        FileWriter fileWriter2 = null;
                        try {
                            try {
                            } catch (Throwable unused) {
                                c.a();
                            }
                        } catch (Throwable unused2) {
                        }
                        if (Build.VERSION.SDK_INT < 29 && s.e(context)) {
                            file = new File(Environment.getExternalStorageDirectory(), ".zp");
                            File file2 = new File(file, ".icosc");
                            if (!file.exists()) {
                                if (!file.isDirectory()) {
                                    file.delete();
                                    file.mkdirs();
                                }
                            } else {
                                file.mkdirs();
                            }
                            fileWriter = new FileWriter(file2, false);
                            try {
                                fileWriter.write(c2);
                                fileWriter.flush();
                                fileWriter.close();
                            } catch (Throwable unused3) {
                                fileWriter2 = fileWriter;
                                try {
                                    c.a();
                                    if (fileWriter2 != null) {
                                        fileWriter2.close();
                                    }
                                    return c2;
                                } catch (Throwable th) {
                                    if (fileWriter2 != null) {
                                        try {
                                            fileWriter2.close();
                                        } catch (Throwable unused4) {
                                            c.a();
                                        }
                                    }
                                    throw th;
                                }
                            }
                        }
                    }
                    return c2;
                }
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
            z3 = false;
        }
        z2 = false;
        if (!z3) {
        }
        com.baidu.sofire.h.a.a(context).d(c2);
        if (!z) {
        }
        a(context, "com.q.zi.i", c2);
        if (b(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION)) {
            FileWriter fileWriter22 = null;
            if (Build.VERSION.SDK_INT < 29) {
                file = new File(Environment.getExternalStorageDirectory(), ".zp");
                File file22 = new File(file, ".icosc");
                if (!file.exists()) {
                }
                fileWriter = new FileWriter(file22, false);
                fileWriter.write(c2);
                fileWriter.flush();
                fileWriter.close();
            }
        }
        return c2;
    }

    public static String c(Context context) {
        try {
            com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
            String o = a2.o();
            if (TextUtils.isEmpty(o)) {
                String string = a2.f10323c.getString("rpnewuid", "");
                if (TextUtils.isEmpty(string)) {
                    return "";
                }
                a2.d(string);
                return string;
            }
            return o;
        } catch (Throwable unused) {
            c.a();
            return "";
        }
    }

    public static String d(Context context) {
        try {
            return a(context, "com.q.zi.i");
        } catch (Throwable unused) {
            c.a();
            return "";
        }
    }

    public static String e(Context context) {
        try {
        } catch (Throwable unused) {
            c.a();
        }
        if (s.c(context) && b(context, "android.permission.READ_EXTERNAL_STORAGE")) {
            File file = new File(Environment.getExternalStorageDirectory(), ".zp/.icosc");
            if (file.exists()) {
                return a(file);
            }
            return "";
        }
        return "";
    }

    public static String a(Context context, String str) {
        try {
            return s.b(context) ? Settings.System.getString(context.getContentResolver(), str) : "";
        } catch (Throwable unused) {
            c.a();
            return null;
        }
    }

    public static String a(File file) {
        FileReader fileReader;
        try {
            fileReader = new FileReader(file);
        } catch (Throwable unused) {
            fileReader = null;
        }
        try {
            char[] cArr = new char[8192];
            CharArrayWriter charArrayWriter = new CharArrayWriter();
            while (true) {
                int read = fileReader.read(cArr);
                if (read <= 0) {
                    break;
                }
                charArrayWriter.write(cArr, 0, read);
            }
            String charArrayWriter2 = charArrayWriter.toString();
            try {
                fileReader.close();
            } catch (Throwable unused2) {
                c.a();
            }
            return charArrayWriter2;
        } catch (Throwable unused3) {
            try {
                c.a();
                return null;
            } finally {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable unused4) {
                        c.a();
                    }
                }
            }
        }
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            if (s.d(context)) {
                return Settings.System.putString(context.getContentResolver(), str, str2);
            }
            return false;
        } catch (Throwable unused) {
            c.a();
            return false;
        }
    }

    public static boolean b(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        } catch (Throwable unused) {
            c.a();
            return false;
        }
    }
}
