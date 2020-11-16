package com.baidu.ar.arplay.a;

import android.content.Context;
import android.os.Vibrator;
/* loaded from: classes12.dex */
public class d {

    /* renamed from: do  reason: not valid java name */
    private static d f0do;
    long[] dn = {800, 60, 400, 60};
    private Vibrator dp;

    private d(Context context) {
        this.dp = (Vibrator) context.getSystemService("vibrator");
    }

    public static synchronized d c(Context context) {
        d dVar;
        synchronized (d.class) {
            if (f0do == null) {
                f0do = new d(context);
            }
            dVar = f0do;
        }
        return dVar;
    }

    public void a(long[] jArr) {
        this.dp.vibrate(jArr, -1);
    }

    public void c(long j) {
        this.dp.vibrate(j);
    }
}
