package com.baidu.live.liveroom.e;

import android.content.Context;
/* loaded from: classes3.dex */
public class e {
    private static volatile e awc = null;
    private b awd;
    private b awe;
    private com.baidu.live.o.c awf;

    private e() {
    }

    public static e yG() {
        if (awc == null) {
            synchronized (e.class) {
                if (awc == null) {
                    awc = new e();
                }
            }
        }
        return awc;
    }

    public void a(b bVar) {
        this.awd = bVar;
    }

    public void b(b bVar) {
        this.awe = bVar;
    }

    public boolean yH() {
        return this.awd != null;
    }

    public a aH(Context context) {
        if (this.awd != null) {
            return this.awd.aG(context);
        }
        return null;
    }

    public a aI(Context context) {
        if (this.awe != null) {
            return this.awe.aG(context);
        }
        return null;
    }

    public com.baidu.live.o.c yI() {
        return this.awf;
    }
}
