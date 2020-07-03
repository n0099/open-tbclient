package com.baidu.c.b;

import android.content.Context;
/* loaded from: classes6.dex */
public class a {
    private static volatile a brf;
    private com.baidu.c.a.b.a.b brg;
    private com.baidu.c.a.a.a brh;
    private com.baidu.c.a.c.a bri;
    private com.baidu.c.a.d.a brj;
    private b brk;
    private Context mContext;

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a aA(Context context) {
        if (brf == null) {
            synchronized (a.class) {
                if (brf == null) {
                    brf = new a(context);
                }
            }
        }
        return brf;
    }

    public com.baidu.c.a.b.a.b Lb() {
        return this.brg;
    }

    public void a(com.baidu.c.a.b.a.b bVar) {
        this.brg = bVar;
    }

    public com.baidu.c.a.a.a Lc() {
        return this.brh;
    }

    public void a(com.baidu.c.a.a.a aVar) {
        this.brh = aVar;
    }

    public com.baidu.c.a.c.a Ld() {
        return this.bri;
    }

    public void a(com.baidu.c.a.c.a aVar) {
        this.bri = aVar;
    }

    public com.baidu.c.a.d.a Le() {
        return this.brj;
    }

    public void a(com.baidu.c.a.d.a aVar) {
        this.brj = aVar;
    }

    public b Lf() {
        return this.brk;
    }

    public void a(b bVar) {
        this.brk = bVar;
    }
}
