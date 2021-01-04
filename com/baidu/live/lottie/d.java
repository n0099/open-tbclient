package com.baidu.live.lottie;

import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import java.util.HashSet;
import java.util.Set;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes10.dex */
public class d {
    private static String[] BD;
    private static long[] BE;
    public static boolean DBG = false;
    private static final Set<String> BB = new HashSet();
    private static boolean BC = false;
    private static int BF = 0;
    private static int BG = 0;

    public static void debug(String str) {
        if (DBG) {
            Log.d("LOTTIE", str);
        }
    }

    public static void warn(String str) {
        if (!BB.contains(str)) {
            Log.w("LOTTIE", str);
            BB.add(str);
        }
    }

    public static void beginSection(String str) {
        if (BC) {
            if (BF == 20) {
                BG++;
                return;
            }
            BD[BF] = str;
            BE[BF] = System.nanoTime();
            TraceCompat.beginSection(str);
            BF++;
        }
    }

    public static float bb(String str) {
        if (BG > 0) {
            BG--;
            return 0.0f;
        } else if (BC) {
            BF--;
            if (BF == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            }
            if (!str.equals(BD[BF])) {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + BD[BF] + ".");
            }
            TraceCompat.endSection();
            return ((float) (System.nanoTime() - BE[BF])) / 1000000.0f;
        } else {
            return 0.0f;
        }
    }
}
