package com.baidu.h.b;

import android.content.Context;
/* loaded from: classes9.dex */
public class a {
    private static volatile a caY;
    private com.baidu.h.a.b.a.b caZ;
    private com.baidu.h.a.a.a cba;
    private com.baidu.h.a.c.a cbb;
    private com.baidu.h.a.d.a cbc;
    private b cbd;
    private Context mContext;

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a bx(Context context) {
        if (caY == null) {
            synchronized (a.class) {
                if (caY == null) {
                    caY = new a(context);
                }
            }
        }
        return caY;
    }

    public com.baidu.h.a.b.a.b Ya() {
        return this.caZ;
    }

    public void a(com.baidu.h.a.b.a.b bVar) {
        this.caZ = bVar;
    }

    public com.baidu.h.a.a.a Yb() {
        return this.cba;
    }

    public void a(com.baidu.h.a.a.a aVar) {
        this.cba = aVar;
    }

    public com.baidu.h.a.c.a Yc() {
        return this.cbb;
    }

    public void a(com.baidu.h.a.c.a aVar) {
        this.cbb = aVar;
    }

    public com.baidu.h.a.d.a Yd() {
        return this.cbc;
    }

    public void a(com.baidu.h.a.d.a aVar) {
        this.cbc = aVar;
    }

    public b Ye() {
        return this.cbd;
    }

    public void a(b bVar) {
        this.cbd = bVar;
    }
}
