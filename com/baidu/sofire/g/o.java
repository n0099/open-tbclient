package com.baidu.sofire.g;

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
public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static String f10309a = "";

    public static String a(Context context) {
        if (TextUtils.isEmpty(f10309a)) {
            new o();
            f10309a = b(context);
        }
        return f10309a;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00da A[Catch: all -> 0x00fa, TryCatch #3 {all -> 0x00fa, blocks: (B:33:0x00b4, B:36:0x00bb, B:39:0x00c2, B:41:0x00da, B:43:0x00e0, B:45:0x00ea, B:44:0x00e7), top: B:64:0x00b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e7 A[Catch: all -> 0x00fa, TryCatch #3 {all -> 0x00fa, blocks: (B:33:0x00b4, B:36:0x00bb, B:39:0x00c2, B:41:0x00da, B:43:0x00e0, B:45:0x00ea, B:44:0x00e7), top: B:64:0x00b4 }] */
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
                    String h2 = r.h(context);
                    String i2 = r.i(context);
                    if (TextUtils.isEmpty(h2) && TextUtils.isEmpty(i2)) {
                        c2 = "1|" + n.a(UUID.randomUUID().toString());
                    } else {
                        StringBuilder sb = new StringBuilder("0|");
                        sb.append(n.a(h2 + i2));
                        c2 = sb.toString();
                    }
                    z = true;
                    z2 = true;
                    if (!z3 || TextUtils.isEmpty(c(context))) {
                        new com.baidu.sofire.e(context).c(c2);
                    }
                    if (!z || TextUtils.isEmpty(d(context))) {
                        a(context, "com.q.zi.i", c2);
                    }
                    if (b(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION) && (z2 || TextUtils.isEmpty(e(context)))) {
                        FileWriter fileWriter2 = null;
                        try {
                            try {
                            } catch (Throwable unused) {
                                d.a();
                            }
                        } catch (Throwable unused2) {
                        }
                        if (Build.VERSION.SDK_INT < 29 && r.e(context)) {
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
                                    d.a();
                                    if (fileWriter2 != null) {
                                        fileWriter2.close();
                                    }
                                    return c2;
                                } catch (Throwable th) {
                                    if (fileWriter2 != null) {
                                        try {
                                            fileWriter2.close();
                                        } catch (Throwable unused4) {
                                            d.a();
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
        new com.baidu.sofire.e(context).c(c2);
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
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            String p = eVar.p();
            if (TextUtils.isEmpty(p)) {
                String string = eVar.f10252b.getString("rpnewuid", "");
                if (TextUtils.isEmpty(string)) {
                    return "";
                }
                eVar.c(string);
                return string;
            }
            return p;
        } catch (Throwable unused) {
            d.a();
            return "";
        }
    }

    public static String d(Context context) {
        try {
            return a(context, "com.q.zi.i");
        } catch (Throwable unused) {
            d.a();
            return "";
        }
    }

    public static String e(Context context) {
        try {
        } catch (Throwable unused) {
            d.a();
        }
        if (r.c(context) && b(context, "android.permission.READ_EXTERNAL_STORAGE")) {
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
            return r.b(context) ? Settings.System.getString(context.getContentResolver(), str) : "";
        } catch (Throwable unused) {
            d.a();
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
                d.a();
            }
            return charArrayWriter2;
        } catch (Throwable unused3) {
            try {
                d.a();
                return null;
            } finally {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (Throwable unused4) {
                        d.a();
                    }
                }
            }
        }
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            if (r.d(context)) {
                return Settings.System.putString(context.getContentResolver(), str, str2);
            }
            return false;
        } catch (Throwable unused) {
            d.a();
            return false;
        }
    }

    public static boolean b(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        } catch (Throwable unused) {
            d.a();
            return false;
        }
    }
}
