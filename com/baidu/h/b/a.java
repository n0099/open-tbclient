package com.baidu.h.b;

import android.content.Context;
/* loaded from: classes18.dex */
public class a {
    private static volatile a bxt;
    private com.baidu.h.a.b.a.b bxu;
    private com.baidu.h.a.a.a bxv;
    private com.baidu.h.a.c.a bxw;
    private com.baidu.h.a.d.a bxx;
    private b bxy;
    private Context mContext;

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a aF(Context context) {
        if (bxt == null) {
            synchronized (a.class) {
                if (bxt == null) {
                    bxt = new a(context);
                }
            }
        }
        return bxt;
    }

    public com.baidu.h.a.b.a.b Ri() {
        return this.bxu;
    }

    public void a(com.baidu.h.a.b.a.b bVar) {
        this.bxu = bVar;
    }

    public com.baidu.h.a.a.a Rj() {
        return this.bxv;
    }

    public void a(com.baidu.h.a.a.a aVar) {
        this.bxv = aVar;
    }

    public com.baidu.h.a.c.a Rk() {
        return this.bxw;
    }

    public void a(com.baidu.h.a.c.a aVar) {
        this.bxw = aVar;
    }

    public com.baidu.h.a.d.a Rl() {
        return this.bxx;
    }

    public void a(com.baidu.h.a.d.a aVar) {
        this.bxx = aVar;
    }

    public b Rm() {
        return this.bxy;
    }

    public void a(b bVar) {
        this.bxy = bVar;
    }
}
