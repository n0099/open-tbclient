package com.baidu.live.liveroom.e;

import android.content.Context;
/* loaded from: classes3.dex */
public class e {
    private static volatile e awb = null;
    private b awc;
    private b awd;

    private e() {
    }

    public static e yG() {
        if (awb == null) {
            synchronized (e.class) {
                if (awb == null) {
                    awb = new e();
                }
            }
        }
        return awb;
    }

    public void a(b bVar) {
        this.awc = bVar;
    }

    public void b(b bVar) {
        this.awd = bVar;
    }

    public boolean yH() {
        return this.awc != null;
    }

    public a aH(Context context) {
        if (this.awc != null) {
            return this.awc.aG(context);
        }
        return null;
    }

    public a aI(Context context) {
        if (this.awd != null) {
            return this.awd.aG(context);
        }
        return null;
    }
}
