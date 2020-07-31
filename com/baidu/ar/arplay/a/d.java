package com.baidu.ar.arplay.a;

import android.content.Context;
import android.os.Vibrator;
/* loaded from: classes11.dex */
public class d {
    private static d dM;
    long[] dL = {800, 60, 400, 60};
    private Vibrator dN;

    private d(Context context) {
        this.dN = (Vibrator) context.getSystemService("vibrator");
    }

    public static synchronized d c(Context context) {
        d dVar;
        synchronized (d.class) {
            if (dM == null) {
                dM = new d(context);
            }
            dVar = dM;
        }
        return dVar;
    }

    public void a(long[] jArr) {
        this.dN.vibrate(jArr, -1);
    }

    public void c(long j) {
        this.dN.vibrate(j);
    }
}
