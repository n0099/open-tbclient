package com.airbnb.lottie;

import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes9.dex */
public class L {
    public static boolean DBG = false;
    public static final int MAX_DEPTH = 20;
    public static final String TAG = "LOTTIE";
    public static int depthPastMaxDepth;
    public static String[] sections;
    public static long[] startTimeNs;
    public static int traceDepth;
    public static boolean traceEnabled;

    public static void beginSection(String str) {
        if (traceEnabled) {
            int i2 = traceDepth;
            if (i2 == 20) {
                depthPastMaxDepth++;
                return;
            }
            sections[i2] = str;
            startTimeNs[i2] = System.nanoTime();
            TraceCompat.beginSection(str);
            traceDepth++;
        }
    }

    public static float endSection(String str) {
        int i2 = depthPastMaxDepth;
        if (i2 > 0) {
            depthPastMaxDepth = i2 - 1;
            return 0.0f;
        } else if (traceEnabled) {
            int i3 = traceDepth - 1;
            traceDepth = i3;
            if (i3 != -1) {
                if (str.equals(sections[i3])) {
                    TraceCompat.endSection();
                    return ((float) (System.nanoTime() - startTimeNs[traceDepth])) / 1000000.0f;
                }
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + sections[traceDepth] + ".");
            }
            throw new IllegalStateException("Can't end trace section. There are none.");
        } else {
            return 0.0f;
        }
    }

    public static void setTraceEnabled(boolean z) {
        if (traceEnabled == z) {
            return;
        }
        traceEnabled = z;
        if (z) {
            sections = new String[20];
            startTimeNs = new long[20];
        }
    }
}
