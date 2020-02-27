package com.airbnb.lottie;

import android.support.annotation.RestrictTo;
import android.support.v4.os.TraceCompat;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class d {
    private static String[] dM;
    private static long[] dN;
    public static boolean DBG = false;
    private static final Set<String> dK = new HashSet();
    private static boolean dL = false;
    private static int dO = 0;
    private static int dP = 0;

    public static void debug(String str) {
        if (DBG) {
            Log.d("LOTTIE", str);
        }
    }

    public static void warn(String str) {
        if (!dK.contains(str)) {
            Log.w("LOTTIE", str);
            dK.add(str);
        }
    }

    public static void beginSection(String str) {
        if (dL) {
            if (dO == 20) {
                dP++;
                return;
            }
            dM[dO] = str;
            dN[dO] = System.nanoTime();
            TraceCompat.beginSection(str);
            dO++;
        }
    }

    public static float F(String str) {
        if (dP > 0) {
            dP--;
            return 0.0f;
        } else if (dL) {
            dO--;
            if (dO == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            }
            if (!str.equals(dM[dO])) {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + dM[dO] + ".");
            }
            TraceCompat.endSection();
            return ((float) (System.nanoTime() - dN[dO])) / 1000000.0f;
        } else {
            return 0.0f;
        }
    }
}
