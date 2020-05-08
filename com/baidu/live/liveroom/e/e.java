package com.baidu.live.liveroom.e;

import android.content.Context;
/* loaded from: classes3.dex */
public class e {
    private static volatile e aPV = null;
    private b aPW;
    private b aPX;
    private com.baidu.live.o.d aPY;

    private e() {
    }

    public static e DE() {
        if (aPV == null) {
            synchronized (e.class) {
                if (aPV == null) {
                    aPV = new e();
                }
            }
        }
        return aPV;
    }

    public void a(b bVar) {
        this.aPW = bVar;
    }

    public void b(b bVar) {
        this.aPX = bVar;
    }

    public boolean DF() {
        return this.aPW != null;
    }

    public a ah(Context context) {
        if (this.aPW != null) {
            return this.aPW.ag(context);
        }
        return null;
    }

    public a ai(Context context) {
        if (this.aPX != null) {
            return this.aPX.ag(context);
        }
        return null;
    }

    public com.baidu.live.o.d DG() {
        return this.aPY;
    }
}
