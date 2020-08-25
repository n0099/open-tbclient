package com.baidu.h.b;

import android.content.Context;
/* loaded from: classes18.dex */
public class a {
    private static volatile a bxq;
    private com.baidu.h.a.b.a.b bxr;
    private com.baidu.h.a.a.a bxs;
    private com.baidu.h.a.c.a bxt;
    private com.baidu.h.a.d.a bxu;
    private b bxv;
    private Context mContext;

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a aF(Context context) {
        if (bxq == null) {
            synchronized (a.class) {
                if (bxq == null) {
                    bxq = new a(context);
                }
            }
        }
        return bxq;
    }

    public com.baidu.h.a.b.a.b Ri() {
        return this.bxr;
    }

    public void a(com.baidu.h.a.b.a.b bVar) {
        this.bxr = bVar;
    }

    public com.baidu.h.a.a.a Rj() {
        return this.bxs;
    }

    public void a(com.baidu.h.a.a.a aVar) {
        this.bxs = aVar;
    }

    public com.baidu.h.a.c.a Rk() {
        return this.bxt;
    }

    public void a(com.baidu.h.a.c.a aVar) {
        this.bxt = aVar;
    }

    public com.baidu.h.a.d.a Rl() {
        return this.bxu;
    }

    public void a(com.baidu.h.a.d.a aVar) {
        this.bxu = aVar;
    }

    public b Rm() {
        return this.bxv;
    }

    public void a(b bVar) {
        this.bxv = bVar;
    }
}
