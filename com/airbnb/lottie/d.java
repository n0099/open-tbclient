package com.airbnb.lottie;

import android.support.annotation.RestrictTo;
import android.support.v4.os.TraceCompat;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes7.dex */
public class d {
    private static String[] BP;
    private static long[] BQ;
    public static boolean DBG = false;
    private static final Set<String> BN = new HashSet();
    private static boolean BO = false;
    private static int BR = 0;
    private static int BS = 0;

    public static void debug(String str) {
        if (DBG) {
            Log.d("LOTTIE", str);
        }
    }

    public static void warn(String str) {
        if (!BN.contains(str)) {
            Log.w("LOTTIE", str);
            BN.add(str);
        }
    }

    public static void beginSection(String str) {
        if (BO) {
            if (BR == 20) {
                BS++;
                return;
            }
            BP[BR] = str;
            BQ[BR] = System.nanoTime();
            TraceCompat.beginSection(str);
            BR++;
        }
    }

    public static float be(String str) {
        if (BS > 0) {
            BS--;
            return 0.0f;
        } else if (BO) {
            BR--;
            if (BR == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            }
            if (!str.equals(BP[BR])) {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + BP[BR] + ".");
            }
            TraceCompat.endSection();
            return ((float) (System.nanoTime() - BQ[BR])) / 1000000.0f;
        } else {
            return 0.0f;
        }
    }
}
