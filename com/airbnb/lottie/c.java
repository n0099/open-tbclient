package com.airbnb.lottie;

import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import java.util.HashSet;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes5.dex */
public class c {
    private static String[] CZ;
    private static long[] Da;
    public static boolean DBG = false;
    private static final Set<String> CX = new HashSet();
    private static boolean CY = false;
    private static int Db = 0;
    private static int Dc = 0;

    public static void debug(String str) {
        if (DBG) {
            Log.d("LOTTIE", str);
        }
    }

    public static void warn(String str) {
        if (!CX.contains(str)) {
            Log.w("LOTTIE", str);
            CX.add(str);
        }
    }

    public static void beginSection(String str) {
        if (CY) {
            if (Db == 20) {
                Dc++;
                return;
            }
            CZ[Db] = str;
            Da[Db] = System.nanoTime();
            TraceCompat.beginSection(str);
            Db++;
        }
    }

    public static float bf(String str) {
        if (Dc > 0) {
            Dc--;
            return 0.0f;
        } else if (CY) {
            Db--;
            if (Db == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            }
            if (!str.equals(CZ[Db])) {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + CZ[Db] + ".");
            }
            TraceCompat.endSection();
            return ((float) (System.nanoTime() - Da[Db])) / 1000000.0f;
        } else {
            return 0.0f;
        }
    }
}
