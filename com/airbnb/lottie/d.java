package com.airbnb.lottie;

import android.support.annotation.RestrictTo;
import android.support.v4.os.TraceCompat;
import com.baidu.android.imsdk.internal.DefaultConfig;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class d {
    private static String[] da;
    private static long[] dc;
    private static boolean cZ = false;
    private static int dd = 0;
    private static int de = 0;

    public static void beginSection(String str) {
        if (cZ) {
            if (dd == 20) {
                de++;
                return;
            }
            da[dd] = str;
            dc[dd] = System.nanoTime();
            TraceCompat.beginSection(str);
            dd++;
        }
    }

    public static float D(String str) {
        if (de > 0) {
            de--;
            return 0.0f;
        } else if (cZ) {
            dd--;
            if (dd == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            }
            if (!str.equals(da[dd])) {
                throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + da[dd] + DefaultConfig.TOKEN_SEPARATOR);
            }
            TraceCompat.endSection();
            return ((float) (System.nanoTime() - dc[dd])) / 1000000.0f;
        } else {
            return 0.0f;
        }
    }
}
