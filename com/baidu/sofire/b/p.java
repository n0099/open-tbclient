package com.baidu.sofire.b;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.UUID;
/* loaded from: classes.dex */
public final class p {
    private static String a = "";

    private static String b(Context context) {
        String str;
        boolean z;
        FileWriter fileWriter;
        String str2;
        boolean z2 = true;
        boolean z3 = false;
        String c = c(context);
        if (TextUtils.isEmpty(c)) {
            String d = d(context);
            if (TextUtils.isEmpty(d)) {
                String e = e(context);
                if (TextUtils.isEmpty(e)) {
                    String d2 = g.d(context);
                    String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    if (TextUtils.isEmpty(string)) {
                        string = "";
                    }
                    if (TextUtils.isEmpty(d2) && TextUtils.isEmpty(string)) {
                        str2 = "1|" + n.a(UUID.randomUUID().toString());
                    } else {
                        str2 = "0|" + n.a(d2 + string);
                    }
                    str = str2;
                    z3 = true;
                    z = true;
                } else {
                    str = e;
                    z = false;
                    z3 = true;
                }
            } else {
                str = d;
                z = false;
                z3 = true;
                z2 = false;
            }
        } else {
            str = c;
            z2 = false;
            z = false;
        }
        if (z3 || TextUtils.isEmpty(c(context))) {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            eVar.d.putString("rpnewuid", str);
            eVar.d.commit();
        }
        if (z2 || TextUtils.isEmpty(d(context))) {
            a(context, "com.q.zi.i", str);
        }
        if (b(context, "android.permission.WRITE_EXTERNAL_STORAGE") && (z || TextUtils.isEmpty(e(context)))) {
            FileWriter fileWriter2 = null;
            try {
                File file = new File(Environment.getExternalStorageDirectory(), ".zp");
                File file2 = new File(file, ".icosc");
                if (file.exists()) {
                    if (!file.isDirectory()) {
                        file.delete();
                        file.mkdirs();
                    }
                } else {
                    file.mkdirs();
                }
                fileWriter = new FileWriter(file2, false);
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileWriter.write(str);
                fileWriter.flush();
                try {
                    fileWriter.close();
                } catch (Throwable th2) {
                    e.a(th2);
                }
            } catch (Throwable th3) {
                th = th3;
                fileWriter2 = fileWriter;
                try {
                    e.a(th);
                    return str;
                } finally {
                    if (fileWriter2 != null) {
                        try {
                            fileWriter2.close();
                        } catch (Throwable th4) {
                            e.a(th4);
                        }
                    }
                }
            }
        }
        return str;
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(a)) {
            new p();
            a = b(context);
        }
        return a;
    }

    private static String c(Context context) {
        try {
            return new com.baidu.sofire.e(context).b.getString("rpnewuid", "");
        } catch (Throwable th) {
            e.a(th);
            return "";
        }
    }

    private static String d(Context context) {
        try {
            return a(context, "com.q.zi.i");
        } catch (Throwable th) {
            e.a(th);
            return "";
        }
    }

    private static String e(Context context) {
        try {
        } catch (Throwable th) {
            e.a(th);
        }
        if (!b(context, "android.permission.READ_EXTERNAL_STORAGE")) {
            return "";
        }
        File file = new File(Environment.getExternalStorageDirectory(), ".zp/.icosc");
        if (file.exists()) {
            return a(file);
        }
        return "";
    }

    private static String a(Context context, String str) {
        try {
            return Settings.System.getString(context.getContentResolver(), str);
        } catch (Throwable th) {
            e.a(th);
            return null;
        }
    }

    private static String a(File file) {
        FileReader fileReader;
        String str = null;
        try {
            fileReader = new FileReader(file);
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
                str = charArrayWriter.toString();
                try {
                    fileReader.close();
                } catch (Throwable th) {
                    e.a(th);
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    e.a(th);
                    return str;
                } finally {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable th3) {
                            e.a(th3);
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
        }
        return str;
    }

    private static boolean b(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        } catch (Throwable th) {
            e.a(th);
            return false;
        }
    }

    private static boolean a(Context context, String str, String str2) {
        try {
            return Settings.System.putString(context.getContentResolver(), str, str2);
        } catch (Throwable th) {
            e.a(th);
            return false;
        }
    }
}
