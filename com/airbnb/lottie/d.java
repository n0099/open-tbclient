package com.airbnb.lottie;

import android.support.annotation.RestrictTo;
import android.support.v4.os.TraceCompat;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class d {
    private static String[] jH;
    private static long[] jI;
    private static boolean traceEnabled = false;
    private static int jJ = 0;
    private static int jK = 0;

    public static void beginSection(String str) {
        if (traceEnabled) {
            if (jJ == 20) {
                jK++;
                return;
            }
            jH[jJ] = str;
            jI[jJ] = System.nanoTime();
            TraceCompat.beginSection(str);
            jJ++;
        }
    }

    public static float D(String str) {
        if (jK > 0) {
            jK--;
            return 0.0f;
        } else if (traceEnabled) {
            jJ--;
            if (jJ == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            }
            if (!str.equals(jH[jJ])) {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + jH[jJ] + ".");
            }
            TraceCompat.endSection();
            return ((float) (System.nanoTime() - jI[jJ])) / 1000000.0f;
        } else {
            return 0.0f;
        }
    }
}
