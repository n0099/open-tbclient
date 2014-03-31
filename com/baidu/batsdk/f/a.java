package com.baidu.batsdk.f;

import android.content.Context;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public final class a {
    private static String a = "BAT";
    private static String b = "batsdk.log";
    private static Context c;

    public static void a(Context context) {
        c = context;
        if (com.baidu.batsdk.a.j) {
            try {
                FileOutputStream openFileOutput = c.openFileOutput(b, 0);
                StringBuilder sb = new StringBuilder();
                sb.append(new SimpleDateFormat("MM-dd hh:mm:ss.S").format(new Date())).append("\tBLog init\n");
                openFileOutput.write(sb.toString().getBytes("UTF-8"));
                openFileOutput.close();
            } catch (FileNotFoundException e) {
            } catch (UnsupportedEncodingException e2) {
            } catch (IOException e3) {
            }
        }
    }

    public static int a(String str) {
        if (com.baidu.batsdk.a.j) {
            c(str, null);
        }
        if (com.baidu.batsdk.a.t <= 1) {
            return Log.d(a, str);
        }
        return 0;
    }

    public static int b(String str) {
        if (com.baidu.batsdk.a.j) {
            c(str, null);
        }
        if (com.baidu.batsdk.a.t <= 2) {
            return Log.i(a, str);
        }
        return 0;
    }

    public static int c(String str) {
        if (com.baidu.batsdk.a.j) {
            c(str, null);
        }
        if (com.baidu.batsdk.a.t <= 3) {
            return Log.w(a, str);
        }
        return 0;
    }

    public static int a(String str, Throwable th) {
        if (com.baidu.batsdk.a.j) {
            c(str, th);
        }
        if (com.baidu.batsdk.a.t <= 3) {
            return Log.w(a, str, th);
        }
        return 0;
    }

    public static int d(String str) {
        if (com.baidu.batsdk.a.j) {
            c(str, null);
        }
        if (com.baidu.batsdk.a.t <= 4) {
            return Log.e(a, str);
        }
        return 0;
    }

    public static int b(String str, Throwable th) {
        if (com.baidu.batsdk.a.j) {
            c(str, th);
        }
        if (com.baidu.batsdk.a.t <= 4) {
            return Log.e(a, str, th);
        }
        return 0;
    }

    private static int c(String str, Throwable th) {
        if (c == null) {
            return 0;
        }
        try {
            FileOutputStream openFileOutput = c.openFileOutput(b, 32768);
            StringBuilder sb = new StringBuilder();
            sb.append(new SimpleDateFormat("MM-dd hh:mm:ss.S").format(new Date())).append("\t").append(str).append(IOUtils.LINE_SEPARATOR_UNIX).append(Log.getStackTraceString(th));
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
}
