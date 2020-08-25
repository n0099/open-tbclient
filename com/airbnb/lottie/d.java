package com.airbnb.lottie;

import android.support.annotation.RestrictTo;
import android.support.v4.os.TraceCompat;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes18.dex */
public class d {
    private static String[] AF;
    private static long[] AG;
    public static boolean DBG = false;
    private static final Set<String> AC = new HashSet();
    private static boolean AE = false;
    private static int AH = 0;
    private static int AI = 0;

    public static void debug(String str) {
        if (DBG) {
            Log.d("LOTTIE", str);
        }
    }

    public static void warn(String str) {
        if (!AC.contains(str)) {
            Log.w("LOTTIE", str);
            AC.add(str);
        }
    }

    public static void beginSection(String str) {
        if (AE) {
            if (AH == 20) {
                AI++;
                return;
            }
            AF[AH] = str;
            AG[AH] = System.nanoTime();
            TraceCompat.beginSection(str);
            AH++;
        }
    }

    public static float bb(String str) {
        if (AI > 0) {
            AI--;
            return 0.0f;
        } else if (AE) {
            AH--;
            if (AH == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            }
            if (!str.equals(AF[AH])) {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + AF[AH] + ".");
            }
            TraceCompat.endSection();
            return ((float) (System.nanoTime() - AG[AH])) / 1000000.0f;
        } else {
            return 0.0f;
        }
    }
}
