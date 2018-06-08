package com.airbnb.lottie;

import android.support.annotation.RestrictTo;
import android.support.v4.os.TraceCompat;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class d {
    private static String[] jP;
    private static long[] jQ;
    private static boolean traceEnabled = false;
    private static int jR = 0;
    private static int jS = 0;

    public static void beginSection(String str) {
        if (traceEnabled) {
            if (jR == 20) {
                jS++;
                return;
            }
            jP[jR] = str;
            jQ[jR] = System.nanoTime();
            TraceCompat.beginSection(str);
            jR++;
        }
    }

    public static float D(String str) {
        if (jS > 0) {
            jS--;
            return 0.0f;
        } else if (traceEnabled) {
            jR--;
            if (jR == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            }
            if (!str.equals(jP[jR])) {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + jP[jR] + ".");
            }
            TraceCompat.endSection();
            return ((float) (System.nanoTime() - jQ[jR])) / 1000000.0f;
        } else {
            return 0.0f;
        }
    }
}
