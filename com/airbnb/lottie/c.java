package com.airbnb.lottie;

import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import java.util.HashSet;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes3.dex */
public class c {
    private static String[] BB;
    private static long[] BC;
    public static boolean DBG = false;
    private static final Set<String> Bz = new HashSet();
    private static boolean BA = false;
    private static int BD = 0;
    private static int BE = 0;

    public static void debug(String str) {
        if (DBG) {
            Log.d("LOTTIE", str);
        }
    }

    public static void warn(String str) {
        if (!Bz.contains(str)) {
            Log.w("LOTTIE", str);
            Bz.add(str);
        }
    }

    public static void beginSection(String str) {
        if (BA) {
            if (BD == 20) {
                BE++;
                return;
            }
            BB[BD] = str;
            BC[BD] = System.nanoTime();
            TraceCompat.beginSection(str);
            BD++;
        }
    }

    public static float bb(String str) {
        if (BE > 0) {
            BE--;
            return 0.0f;
        } else if (BA) {
            BD--;
            if (BD == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            }
            if (!str.equals(BB[BD])) {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + BB[BD] + ".");
            }
            TraceCompat.endSection();
            return ((float) (System.nanoTime() - BC[BD])) / 1000000.0f;
        } else {
            return 0.0f;
        }
    }
}
