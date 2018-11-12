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
public class p {
    private static String a = "";

    private String f(Context context) {
        boolean z;
        boolean z2 = true;
        boolean z3 = false;
        String c = c(context);
        if (TextUtils.isEmpty(c)) {
            c = d(context);
            if (TextUtils.isEmpty(c)) {
                c = e(context);
                if (TextUtils.isEmpty(c)) {
                    c = b(context);
                    z3 = true;
                    z = true;
                } else {
                    z = true;
                    z2 = false;
                    z3 = true;
                }
            } else {
                z = true;
                z2 = false;
            }
        } else {
            z2 = false;
            z = false;
        }
        if (z || TextUtils.isEmpty(c(context))) {
            new com.baidu.sofire.e(context).g(c);
        }
        if (z3 || TextUtils.isEmpty(d(context))) {
            a(context, "com.q.zi.i", c);
        }
        if (b(context, "android.permission.WRITE_EXTERNAL_STORAGE") && (z2 || TextUtils.isEmpty(e(context)))) {
            a(c);
        }
        return c;
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(a)) {
            a = new p().f(context);
        }
        return a;
    }

    public String b(Context context) {
        String e = g.e(context);
        String f = g.f(context);
        if (TextUtils.isEmpty(e) && TextUtils.isEmpty(f)) {
            return "1|" + o.a(UUID.randomUUID().toString());
        }
        return "0|" + o.a(e + f);
    }

    public String c(Context context) {
        try {
            return new com.baidu.sofire.e(context).A();
        } catch (Throwable th) {
            e.a(th);
            return "";
        }
    }

    public String d(Context context) {
        try {
            return a(context, "com.q.zi.i");
        } catch (Throwable th) {
            e.a(th);
            return "";
        }
    }

    public String e(Context context) {
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

    private String a(Context context, String str) {
        try {
            return Settings.System.getString(context.getContentResolver(), str);
        } catch (Throwable th) {
            e.a(th);
            return null;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [144=4] */
    private String a(File file) {
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
            } catch (Throwable th) {
                th = th;
                try {
                    e.a(th);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable th2) {
                            e.a(th2);
                        }
                    }
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

    private boolean b(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        } catch (Throwable th) {
            e.a(th);
            return false;
        }
    }

    private boolean a(Context context, String str, String str2) {
        try {
            return Settings.System.putString(context.getContentResolver(), str, str2);
        } catch (Throwable th) {
            e.a(th);
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    private void a(String str) {
        FileWriter fileWriter;
        FileWriter fileWriter2 = null;
        try {
            File file = new File(Environment.getExternalStorageDirectory(), ".zp");
            File file2 = new File(file, ".icosc");
            if (!file.exists()) {
                file.mkdirs();
            } else if (!file.isDirectory()) {
                file.delete();
                file.mkdirs();
            }
            fileWriter = new FileWriter(file2, false);
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileWriter.write(str);
            fileWriter.flush();
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (Throwable th2) {
                    e.a(th2);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileWriter2 = fileWriter;
            try {
                e.a(th);
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.close();
                    } catch (Throwable th4) {
                        e.a(th4);
                    }
                }
            } catch (Throwable th5) {
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.close();
                    } catch (Throwable th6) {
                        e.a(th6);
                    }
                }
                throw th5;
            }
        }
    }
}
