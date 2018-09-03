package com.airbnb.lottie;

import android.support.annotation.RestrictTo;
import android.support.v4.os.TraceCompat;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class d {
    private static String[] jI;
    private static long[] jJ;
    private static boolean jH = false;
    private static int jK = 0;
    private static int jL = 0;

    public static void beginSection(String str) {
        if (jH) {
            if (jK == 20) {
                jL++;
                return;
            }
            jI[jK] = str;
            jJ[jK] = System.nanoTime();
            TraceCompat.beginSection(str);
            jK++;
        }
    }

    public static float D(String str) {
        if (jL > 0) {
            jL--;
            return 0.0f;
        } else if (jH) {
            jK--;
            if (jK == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            }
            if (!str.equals(jI[jK])) {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + jI[jK] + ".");
            }
            TraceCompat.endSection();
            return ((float) (System.nanoTime() - jJ[jK])) / 1000000.0f;
        } else {
            return 0.0f;
        }
    }
}
