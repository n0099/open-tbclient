package com.baidu.ar.arplay.a;

import android.content.Context;
import android.os.Vibrator;
/* loaded from: classes3.dex */
public class d {
    private static d dA;
    private Vibrator dB;
    long[] dz = {800, 60, 400, 60};

    private d(Context context) {
        this.dB = (Vibrator) context.getSystemService("vibrator");
    }

    public static synchronized d c(Context context) {
        d dVar;
        synchronized (d.class) {
            if (dA == null) {
                dA = new d(context);
            }
            dVar = dA;
        }
        return dVar;
    }

    public void a(long[] jArr) {
        this.dB.vibrate(jArr, -1);
    }

    public void c(long j) {
        this.dB.vibrate(j);
    }
}
