package com.baidu.baiduarsdk.a;

import android.content.Context;
import android.os.Vibrator;
/* loaded from: classes3.dex */
public class d {
    private static d b;
    long[] a = {800, 60, 400, 60};
    private Vibrator c;

    private d(Context context) {
        this.c = (Vibrator) context.getSystemService("vibrator");
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (b == null) {
                b = new d(context);
            }
            dVar = b;
        }
        return dVar;
    }

    public void a(long j) {
        this.c.vibrate(j);
    }

    public void a(long[] jArr) {
        this.c.vibrate(jArr, -1);
    }
}
