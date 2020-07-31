package com.airbnb.lottie;

import android.support.annotation.RestrictTo;
import android.support.v4.os.TraceCompat;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes20.dex */
public class d {
    private static long[] Aa;
    private static String[] zZ;
    public static boolean DBG = false;
    private static final Set<String> zX = new HashSet();
    private static boolean zY = false;
    private static int Ab = 0;
    private static int Ac = 0;

    public static void debug(String str) {
        if (DBG) {
            Log.d("LOTTIE", str);
        }
    }

    public static void warn(String str) {
        if (!zX.contains(str)) {
            Log.w("LOTTIE", str);
            zX.add(str);
        }
    }

    public static void beginSection(String str) {
        if (zY) {
            if (Ab == 20) {
                Ac++;
                return;
            }
            zZ[Ab] = str;
            Aa[Ab] = System.nanoTime();
            TraceCompat.beginSection(str);
            Ab++;
        }
    }

    public static float aW(String str) {
        if (Ac > 0) {
            Ac--;
            return 0.0f;
        } else if (zY) {
            Ab--;
            if (Ab == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            }
            if (!str.equals(zZ[Ab])) {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + zZ[Ab] + ".");
            }
            TraceCompat.endSection();
            return ((float) (System.nanoTime() - Aa[Ab])) / 1000000.0f;
        } else {
            return 0.0f;
        }
    }
}
