package com.baidu.live.liveroom.e;

import android.content.Context;
/* loaded from: classes4.dex */
public class e {
    private static volatile e aYL = null;
    private b aYM;
    private b aYN;
    private com.baidu.live.p.d aYO;

    private e() {
    }

    public static e FF() {
        if (aYL == null) {
            synchronized (e.class) {
                if (aYL == null) {
                    aYL = new e();
                }
            }
        }
        return aYL;
    }

    public void a(b bVar) {
        this.aYM = bVar;
    }

    public void b(b bVar) {
        this.aYN = bVar;
    }

    public boolean FG() {
        return this.aYM != null;
    }

    public a as(Context context) {
        if (this.aYM != null) {
            return this.aYM.ar(context);
        }
        return null;
    }

    public a at(Context context) {
        if (this.aYN != null) {
            return this.aYN.ar(context);
        }
        return null;
    }

    public com.baidu.live.p.d FH() {
        return this.aYO;
    }
}
