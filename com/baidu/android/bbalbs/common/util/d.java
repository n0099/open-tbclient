package com.baidu.android.bbalbs.common.util;

import android.content.Context;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileReader;
/* loaded from: classes.dex */
public final class d {
    public static String a(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
    }

    public static String a(Context context, String str) {
        try {
            return Settings.System.getString(context.getContentResolver(), str);
        } catch (Exception e2) {
            a(e2);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(File file) {
        FileReader fileReader;
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader(file);
            try {
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
                    } catch (Exception e2) {
                        a(e2);
                    }
                    return charArrayWriter2;
                } catch (Exception e3) {
                    e = e3;
                    a(e);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Exception e4) {
                            a(e4);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileReader2 = fileReader;
                if (fileReader2 != null) {
                    try {
                        fileReader2.close();
                    } catch (Exception e5) {
                        a(e5);
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            fileReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (fileReader2 != null) {
            }
            throw th;
        }
    }

    public static void a(Throwable th) {
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            return Settings.System.putString(context.getContentResolver(), str, str2);
        } catch (Exception e2) {
            a(e2);
            return false;
        }
    }

    public static boolean a(String str, int i2) {
        if (TextUtils.isEmpty(str) || i2 == 0) {
            return false;
        }
        return str.matches("^[a-zA-Z0-9]{1,5}$");
    }

    public static boolean b(Context context) {
        return b(context, "android.permission.WRITE_SETTINGS");
    }

    public static boolean b(Context context, String str) {
        return context != null && context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }
}
