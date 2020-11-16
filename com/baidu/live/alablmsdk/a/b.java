package com.baidu.live.alablmsdk.a;

import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes4.dex */
public class b {
    private static a ayH;
    private static boolean isDebug = false;
    private static StringBuilder ayG = new StringBuilder();

    /* loaded from: classes4.dex */
    public interface a {
        void fC(String str);
    }

    public static void a(a aVar) {
        ayH = aVar;
    }

    public static void Aw() {
        if (ayH != null) {
            ayH = null;
        }
    }

    public static void bb(boolean z) {
        isDebug = z;
    }

    public static boolean isDebug() {
        return isDebug;
    }

    public static void d(String str) {
        if (isDebug) {
            Log.d("blmsdk", str);
        }
    }

    public static void ag(String str, String str2) {
        if (isDebug) {
            Log.d("blmsdk", str + str2);
        }
        fD(str);
    }

    public static void fD(String str) {
        String f = f(4000, str);
        if (ayH != null) {
            ayH.fC(f);
        }
    }

    public static String b(long j, String str) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date(j));
    }

    public static synchronized String f(int i, String str) {
        String Ax;
        synchronized (b.class) {
            try {
                if (ayG == null) {
                    ayG = new StringBuilder();
                }
                if (ayG.length() != 0) {
                    ayG.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                ayG.append("[").append(b(System.currentTimeMillis(), "HH:mm:ss.SSS")).append("|").append(i).append("|").append(str).append("]");
            } catch (Exception e) {
            }
            Ax = Ax();
        }
        return Ax;
    }

    public static synchronized String Ax() {
        String sb;
        synchronized (b.class) {
            if (ayG == null) {
                sb = "";
            } else {
                sb = ayG.toString();
                try {
                    ayG.delete(0, ayG.length());
                } catch (Exception e) {
                    ayG = new StringBuilder();
                }
            }
        }
        return sb;
    }
}
