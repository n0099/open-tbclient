package com.baidu.c.b;

import android.content.Context;
/* loaded from: classes6.dex */
public class a {
    private static volatile a beE;
    private com.baidu.c.a.b.a.b beF;
    private com.baidu.c.a.a.a beG;
    private com.baidu.c.a.c.a beH;
    private com.baidu.c.a.d.a beI;
    private b beJ;
    private Context mContext;

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a ap(Context context) {
        if (beE == null) {
            synchronized (a.class) {
                if (beE == null) {
                    beE = new a(context);
                }
            }
        }
        return beE;
    }

    public com.baidu.c.a.b.a.b HZ() {
        return this.beF;
    }

    public void a(com.baidu.c.a.b.a.b bVar) {
        this.beF = bVar;
    }

    public com.baidu.c.a.a.a Ia() {
        return this.beG;
    }

    public void a(com.baidu.c.a.a.a aVar) {
        this.beG = aVar;
    }

    public com.baidu.c.a.c.a Ib() {
        return this.beH;
    }

    public void a(com.baidu.c.a.c.a aVar) {
        this.beH = aVar;
    }

    public com.baidu.c.a.d.a Ic() {
        return this.beI;
    }

    public void a(com.baidu.c.a.d.a aVar) {
        this.beI = aVar;
    }

    public b Id() {
        return this.beJ;
    }

    public void a(b bVar) {
        this.beJ = bVar;
    }
}
