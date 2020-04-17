package com.baidu.live.liveroom.e;

import android.content.Context;
/* loaded from: classes3.dex */
public class e {
    private static volatile e aPP = null;
    private b aPQ;
    private b aPR;
    private com.baidu.live.o.d aPS;

    private e() {
    }

    public static e DF() {
        if (aPP == null) {
            synchronized (e.class) {
                if (aPP == null) {
                    aPP = new e();
                }
            }
        }
        return aPP;
    }

    public void a(b bVar) {
        this.aPQ = bVar;
    }

    public void b(b bVar) {
        this.aPR = bVar;
    }

    public boolean DG() {
        return this.aPQ != null;
    }

    public a at(Context context) {
        if (this.aPQ != null) {
            return this.aPQ.as(context);
        }
        return null;
    }

    public a au(Context context) {
        if (this.aPR != null) {
            return this.aPR.as(context);
        }
        return null;
    }

    public com.baidu.live.o.d DH() {
        return this.aPS;
    }
}
