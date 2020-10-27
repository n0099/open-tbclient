package com.baidu.live.alablmsdk.a;

import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes4.dex */
public class c {
    private static a aAv;
    private static boolean isDebug = false;
    private static StringBuilder aAu = new StringBuilder();

    /* loaded from: classes4.dex */
    public interface a {
        void fI(String str);
    }

    public static void a(a aVar) {
        aAv = aVar;
    }

    public static void Bg() {
        if (aAv != null) {
            aAv = null;
        }
    }

    public static boolean isDebug() {
        return isDebug;
    }

    public static void d(String str) {
        if (isDebug) {
            Log.d("blmsdk", str);
        }
    }

    public static void fJ(String str) {
        String f = f(4000, str);
        if (aAv != null) {
            aAv.fI(f);
        }
    }

    public static String b(long j, String str) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date(j));
    }

    public static synchronized String f(int i, String str) {
        String Bh;
        synchronized (c.class) {
            try {
                if (aAu == null) {
                    aAu = new StringBuilder();
                }
                if (aAu.length() != 0) {
                    aAu.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                aAu.append("[").append(b(System.currentTimeMillis(), "HH:mm:ss.SSS")).append("|").append(i).append("|").append(str).append("]");
            } catch (Exception e) {
            }
            Bh = Bh();
        }
        return Bh;
    }

    public static synchronized String Bh() {
        String sb;
        synchronized (c.class) {
            if (aAu == null) {
                sb = "";
            } else {
                sb = aAu.toString();
                try {
                    aAu.delete(0, aAu.length());
                } catch (Exception e) {
                    aAu = new StringBuilder();
                }
                if (!TextUtils.isEmpty(sb)) {
                    d(sb);
                }
            }
        }
        return sb;
    }
}
