package com.baidu.ar.arplay.a;

import android.content.Context;
import android.os.Vibrator;
/* loaded from: classes3.dex */
public class d {
    private static d dB;
    long[] dA = {800, 60, 400, 60};
    private Vibrator dC;

    private d(Context context) {
        this.dC = (Vibrator) context.getSystemService("vibrator");
    }

    public static synchronized d d(Context context) {
        d dVar;
        synchronized (d.class) {
            if (dB == null) {
                dB = new d(context);
            }
            dVar = dB;
        }
        return dVar;
    }

    public void a(long[] jArr) {
        this.dC.vibrate(jArr, -1);
    }

    public void c(long j) {
        this.dC.vibrate(j);
    }
}
