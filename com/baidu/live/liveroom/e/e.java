package com.baidu.live.liveroom.e;

import android.content.Context;
/* loaded from: classes3.dex */
public class e {
    private static volatile e aWe = null;
    private b aWf;
    private b aWg;
    private com.baidu.live.o.d aWh;

    private e() {
    }

    public static e Fc() {
        if (aWe == null) {
            synchronized (e.class) {
                if (aWe == null) {
                    aWe = new e();
                }
            }
        }
        return aWe;
    }

    public void a(b bVar) {
        this.aWf = bVar;
    }

    public void b(b bVar) {
        this.aWg = bVar;
    }

    public boolean Fd() {
        return this.aWf != null;
    }

    public a ar(Context context) {
        if (this.aWf != null) {
            return this.aWf.aq(context);
        }
        return null;
    }

    public a as(Context context) {
        if (this.aWg != null) {
            return this.aWg.aq(context);
        }
        return null;
    }

    public com.baidu.live.o.d Fe() {
        return this.aWh;
    }
}
