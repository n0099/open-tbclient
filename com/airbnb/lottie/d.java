package com.airbnb.lottie;

import android.support.annotation.RestrictTo;
import android.support.v4.os.TraceCompat;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class d {
    private static String[] kq;
    private static long[] kr;
    private static boolean kp = false;
    private static int ks = 0;
    private static int kt = 0;

    public static void beginSection(String str) {
        if (kp) {
            if (ks == 20) {
                kt++;
                return;
            }
            kq[ks] = str;
            kr[ks] = System.nanoTime();
            TraceCompat.beginSection(str);
            ks++;
        }
    }

    public static float D(String str) {
        if (kt > 0) {
            kt--;
            return 0.0f;
        } else if (kp) {
            ks--;
            if (ks == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            }
            if (!str.equals(kq[ks])) {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + kq[ks] + ".");
            }
            TraceCompat.endSection();
            return ((float) (System.nanoTime() - kr[ks])) / 1000000.0f;
        } else {
            return 0.0f;
        }
    }
}
