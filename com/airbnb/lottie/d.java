package com.airbnb.lottie;

import android.support.annotation.RestrictTo;
import android.support.v4.os.TraceCompat;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class d {
    private static String[] mW;
    private static long[] mZ;
    private static boolean mV = false;
    private static int na = 0;
    private static int nb = 0;

    public static void beginSection(String str) {
        if (mV) {
            if (na == 20) {
                nb++;
                return;
            }
            mW[na] = str;
            mZ[na] = System.nanoTime();
            TraceCompat.beginSection(str);
            na++;
        }
    }

    public static float U(String str) {
        if (nb > 0) {
            nb--;
            return 0.0f;
        } else if (mV) {
            na--;
            if (na == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            }
            if (!str.equals(mW[na])) {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + mW[na] + ".");
            }
            TraceCompat.endSection();
            return ((float) (System.nanoTime() - mZ[na])) / 1000000.0f;
        } else {
            return 0.0f;
        }
    }
}
