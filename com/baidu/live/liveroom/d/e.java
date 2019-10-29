package com.baidu.live.liveroom.d;

import android.content.Context;
/* loaded from: classes6.dex */
public class e {
    private static volatile e ajJ = null;
    private b ajK;

    private e() {
    }

    public static e uh() {
        if (ajJ == null) {
            synchronized (e.class) {
                if (ajJ == null) {
                    ajJ = new e();
                }
            }
        }
        return ajJ;
    }

    public void a(b bVar) {
        this.ajK = bVar;
    }

    public boolean ui() {
        return this.ajK != null;
    }

    public a as(Context context) {
        if (this.ajK != null) {
            return this.ajK.ar(context);
        }
        return null;
    }
}
