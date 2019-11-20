package com.baidu.live.liveroom.d;

import android.content.Context;
/* loaded from: classes6.dex */
public class e {
    private static volatile e ajr = null;
    private b ajs;

    private e() {
    }

    public static e ui() {
        if (ajr == null) {
            synchronized (e.class) {
                if (ajr == null) {
                    ajr = new e();
                }
            }
        }
        return ajr;
    }

    public void a(b bVar) {
        this.ajs = bVar;
    }

    public boolean uj() {
        return this.ajs != null;
    }

    public a as(Context context) {
        if (this.ajs != null) {
            return this.ajs.ar(context);
        }
        return null;
    }
}
