package com.baidu.live.alablmsdk.a;

import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes4.dex */
public class b {
    private static a aAs;
    private static boolean isDebug = false;
    private static StringBuilder aAr = new StringBuilder();

    /* loaded from: classes4.dex */
    public interface a {
        void fI(String str);
    }

    public static void a(a aVar) {
        aAs = aVar;
    }

    public static void Bf() {
        if (aAs != null) {
            aAs = null;
        }
    }

    public static void aZ(boolean z) {
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

    public static void ah(String str, String str2) {
        if (isDebug) {
            Log.d("blmsdk", str + str2);
        }
        fJ(str);
    }

    public static void fJ(String str) {
        String f = f(4000, str);
        if (aAs != null) {
            aAs.fI(f);
        }
    }

    public static String b(long j, String str) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date(j));
    }

    public static synchronized String f(int i, String str) {
        String Bg;
        synchronized (b.class) {
            try {
                if (aAr == null) {
                    aAr = new StringBuilder();
                }
                if (aAr.length() != 0) {
                    aAr.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                aAr.append("[").append(b(System.currentTimeMillis(), "HH:mm:ss.SSS")).append("|").append(i).append("|").append(str).append("]");
            } catch (Exception e) {
            }
            Bg = Bg();
        }
        return Bg;
    }

    public static synchronized String Bg() {
        String sb;
        synchronized (b.class) {
            if (aAr == null) {
                sb = "";
            } else {
                sb = aAr.toString();
                try {
                    aAr.delete(0, aAr.length());
                } catch (Exception e) {
                    aAr = new StringBuilder();
                }
            }
        }
        return sb;
    }
}
