package com.airbnb.lottie;

import android.support.annotation.RestrictTo;
import android.support.v4.os.TraceCompat;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class d {
    private static String[] mg;
    private static long[] mh;
    private static boolean mf = false;
    private static int mi = 0;
    private static int mj = 0;

    public static void beginSection(String str) {
        if (mf) {
            if (mi == 20) {
                mj++;
                return;
            }
            mg[mi] = str;
            mh[mi] = System.nanoTime();
            TraceCompat.beginSection(str);
            mi++;
        }
    }

    public static float U(String str) {
        if (mj > 0) {
            mj--;
            return 0.0f;
        } else if (mf) {
            mi--;
            if (mi == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            }
            if (!str.equals(mg[mi])) {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + mg[mi] + ".");
            }
            TraceCompat.endSection();
            return ((float) (System.nanoTime() - mh[mi])) / 1000000.0f;
        } else {
            return 0.0f;
        }
    }
}
