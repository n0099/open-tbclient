package com.baidu.live.liveroom.e;

import android.content.Context;
/* loaded from: classes3.dex */
public class e {
    private static volatile e aYN = null;
    private b aYO;
    private b aYP;
    private com.baidu.live.p.d aYQ;

    private e() {
    }

    public static e FL() {
        if (aYN == null) {
            synchronized (e.class) {
                if (aYN == null) {
                    aYN = new e();
                }
            }
        }
        return aYN;
    }

    public void a(b bVar) {
        this.aYO = bVar;
    }

    public void b(b bVar) {
        this.aYP = bVar;
    }

    public boolean FM() {
        return this.aYO != null;
    }

    public a as(Context context) {
        if (this.aYO != null) {
            return this.aYO.ar(context);
        }
        return null;
    }

    public a at(Context context) {
        if (this.aYP != null) {
            return this.aYP.ar(context);
        }
        return null;
    }

    public com.baidu.live.p.d FN() {
        return this.aYQ;
    }
}
