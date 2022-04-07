package com.airbnb.lottie;

import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
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
            int i = traceDepth;
            if (i == 20) {
                depthPastMaxDepth++;
                return;
            }
            sections[i] = str;
            startTimeNs[i] = System.nanoTime();
            TraceCompat.beginSection(str);
            traceDepth++;
        }
    }

    public static float endSection(String str) {
        int i = depthPastMaxDepth;
        if (i > 0) {
            depthPastMaxDepth = i - 1;
            return 0.0f;
        } else if (traceEnabled) {
            int i2 = traceDepth - 1;
            traceDepth = i2;
            if (i2 != -1) {
                if (str.equals(sections[i2])) {
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
