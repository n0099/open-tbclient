package com.baidu.live.liveroom.d;

import android.content.Context;
/* loaded from: classes2.dex */
public class e {
    private static volatile e asa = null;
    private b asb;
    private b asc;

    private e() {
    }

    public static e wt() {
        if (asa == null) {
            synchronized (e.class) {
                if (asa == null) {
                    asa = new e();
                }
            }
        }
        return asa;
    }

    public void a(b bVar) {
        this.asb = bVar;
    }

    public void b(b bVar) {
        this.asc = bVar;
    }

    public boolean wu() {
        return this.asb != null;
    }

    public a aD(Context context) {
        if (this.asb != null) {
            return this.asb.aC(context);
        }
        return null;
    }

    public a aE(Context context) {
        if (this.asc != null) {
            return this.asc.aC(context);
        }
        return null;
    }
}
