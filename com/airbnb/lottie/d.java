package com.airbnb.lottie;

import android.support.annotation.RestrictTo;
import android.support.v4.os.TraceCompat;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class d {
    private static String[] mR;
    private static long[] mS;
    private static boolean mQ = false;
    private static int mT = 0;
    private static int mU = 0;

    public static void beginSection(String str) {
        if (mQ) {
            if (mT == 20) {
                mU++;
                return;
            }
            mR[mT] = str;
            mS[mT] = System.nanoTime();
            TraceCompat.beginSection(str);
            mT++;
        }
    }

    public static float U(String str) {
        if (mU > 0) {
            mU--;
            return 0.0f;
        } else if (mQ) {
            mT--;
            if (mT == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            }
            if (!str.equals(mR[mT])) {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + mR[mT] + ".");
            }
            TraceCompat.endSection();
            return ((float) (System.nanoTime() - mS[mT])) / 1000000.0f;
        } else {
            return 0.0f;
        }
    }
}
