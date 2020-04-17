package com.baidu.c.b;

import android.content.Context;
/* loaded from: classes6.dex */
public class a {
    private static volatile a bez;
    private com.baidu.c.a.b.a.b beA;
    private com.baidu.c.a.a.a beB;
    private com.baidu.c.a.c.a beC;
    private com.baidu.c.a.d.a beD;
    private b beE;
    private Context mContext;

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a aB(Context context) {
        if (bez == null) {
            synchronized (a.class) {
                if (bez == null) {
                    bez = new a(context);
                }
            }
        }
        return bez;
    }

    public com.baidu.c.a.b.a.b Ia() {
        return this.beA;
    }

    public void a(com.baidu.c.a.b.a.b bVar) {
        this.beA = bVar;
    }

    public com.baidu.c.a.a.a Ib() {
        return this.beB;
    }

    public void a(com.baidu.c.a.a.a aVar) {
        this.beB = aVar;
    }

    public com.baidu.c.a.c.a Ic() {
        return this.beC;
    }

    public void a(com.baidu.c.a.c.a aVar) {
        this.beC = aVar;
    }

    public com.baidu.c.a.d.a Id() {
        return this.beD;
    }

    public void a(com.baidu.c.a.d.a aVar) {
        this.beD = aVar;
    }

    public b Ie() {
        return this.beE;
    }

    public void a(b bVar) {
        this.beE = bVar;
    }
}
