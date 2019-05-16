package com.airbnb.lottie;

import android.support.annotation.RestrictTo;
import android.support.v4.os.TraceCompat;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class d {
    private static String[] kr;
    private static long[] ks;
    private static boolean kq = false;
    private static int kt = 0;
    private static int ku = 0;

    public static void beginSection(String str) {
        if (kq) {
            if (kt == 20) {
                ku++;
                return;
            }
            kr[kt] = str;
            ks[kt] = System.nanoTime();
            TraceCompat.beginSection(str);
            kt++;
        }
    }

    public static float D(String str) {
        if (ku > 0) {
            ku--;
            return 0.0f;
        } else if (kq) {
            kt--;
            if (kt == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            }
            if (!str.equals(kr[kt])) {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + kr[kt] + ".");
            }
            TraceCompat.endSection();
            return ((float) (System.nanoTime() - ks[kt])) / 1000000.0f;
        } else {
            return 0.0f;
        }
    }
}
