package com.baidu.live.liveroom.e;

import android.content.Context;
/* loaded from: classes3.dex */
public class e {
    private static volatile e awm = null;
    private b awn;
    private b awo;
    private com.baidu.live.o.d awp;

    private e() {
    }

    public static e yL() {
        if (awm == null) {
            synchronized (e.class) {
                if (awm == null) {
                    awm = new e();
                }
            }
        }
        return awm;
    }

    public void a(b bVar) {
        this.awn = bVar;
    }

    public void b(b bVar) {
        this.awo = bVar;
    }

    public boolean yM() {
        return this.awn != null;
    }

    public a aG(Context context) {
        if (this.awn != null) {
            return this.awn.aF(context);
        }
        return null;
    }

    public a aH(Context context) {
        if (this.awo != null) {
            return this.awo.aF(context);
        }
        return null;
    }

    public com.baidu.live.o.d yN() {
        return this.awp;
    }
}
