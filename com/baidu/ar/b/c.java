package com.baidu.ar.b;

import android.content.Context;
import android.os.Vibrator;
/* loaded from: classes3.dex */
public class c {
    private static c b;
    long[] a = {800, 60, 400, 60};
    private Vibrator c;

    private c(Context context) {
        this.c = (Vibrator) context.getSystemService("vibrator");
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (c.class) {
            if (b == null) {
                b = new c(context);
            }
            cVar = b;
        }
        return cVar;
    }

    public void a(long j) {
        this.c.vibrate(j);
    }

    public void a(long[] jArr) {
        this.c.vibrate(jArr, -1);
    }
}
