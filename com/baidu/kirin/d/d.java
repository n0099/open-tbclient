package com.baidu.kirin.d;

import android.content.Context;
import android.util.Log;
import com.baidu.kirin.KirinConfig;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class d {
    public static String a = "KIRINUPDATE";
    public static String b = "kirin_update.log";
    private static Context c;

    public static int a(String str) {
        if (KirinConfig.DEBUG_MODE) {
            a(d(str), null);
        }
        if (KirinConfig.LOG_LEVEL <= 1) {
            return Log.d(a, d(str));
        }
        return 0;
    }

    public static int a(String str, Throwable th) {
        if (c == null) {
            return 0;
        }
        try {
            FileOutputStream openFileOutput = c.openFileOutput(b, 32768);
            StringBuilder sb = new StringBuilder();
            sb.append(new SimpleDateFormat("MM-dd hh:mm:ss.S").format(new Date())).append("\t").append(d(str)).append(IOUtils.LINE_SEPARATOR_UNIX).append(Log.getStackTraceString(th));
            byte[] bytes = sb.toString().getBytes("UTF-8");
            int length = bytes.length;
            openFileOutput.write(bytes);
            openFileOutput.close();
            return length;
        } catch (FileNotFoundException e) {
            return 0;
        } catch (UnsupportedEncodingException e2) {
            return 0;
        } catch (IOException e3) {
            return 0;
        }
    }

    private static String a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals("com.baidu.kirin.util.KirinLog")) {
                return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "]";
            }
        }
        return null;
    }

    public static int b(String str) {
        if (KirinConfig.DEBUG_MODE) {
            a(d(str), null);
        }
        if (KirinConfig.LOG_LEVEL <= 3) {
            return Log.w(a, d(str));
        }
        return 0;
    }

    public static int c(String str) {
        if (KirinConfig.DEBUG_MODE) {
            a(d(str), null);
        }
        if (KirinConfig.LOG_LEVEL <= 4) {
            return Log.e(a, d(str));
        }
        return 0;
    }

    private static String d(String str) {
        String a2 = a();
        return a2 == null ? str : a2 + " - " + str;
    }
}
