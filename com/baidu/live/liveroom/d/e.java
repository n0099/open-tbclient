package com.baidu.live.liveroom.d;

import android.content.Context;
/* loaded from: classes2.dex */
public class e {
    private static volatile e aro = null;
    private b arp;
    private b arq;

    private e() {
    }

    public static e wc() {
        if (aro == null) {
            synchronized (e.class) {
                if (aro == null) {
                    aro = new e();
                }
            }
        }
        return aro;
    }

    public void a(b bVar) {
        this.arp = bVar;
    }

    public void b(b bVar) {
        this.arq = bVar;
    }

    public boolean wd() {
        return this.arp != null;
    }

    public a aD(Context context) {
        if (this.arp != null) {
            return this.arp.aC(context);
        }
        return null;
    }

    public a aE(Context context) {
        if (this.arq != null) {
            return this.arq.aC(context);
        }
        return null;
    }
}
