package com.baidu.h.b;

import android.content.Context;
/* loaded from: classes15.dex */
public class a {
    private static volatile a bHt;
    private com.baidu.h.a.b.a.b bHu;
    private com.baidu.h.a.a.a bHv;
    private com.baidu.h.a.c.a bHw;
    private com.baidu.h.a.d.a bHx;
    private b bHy;
    private Context mContext;

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a aJ(Context context) {
        if (bHt == null) {
            synchronized (a.class) {
                if (bHt == null) {
                    bHt = new a(context);
                }
            }
        }
        return bHt;
    }

    public com.baidu.h.a.b.a.b TS() {
        return this.bHu;
    }

    public void a(com.baidu.h.a.b.a.b bVar) {
        this.bHu = bVar;
    }

    public com.baidu.h.a.a.a TT() {
        return this.bHv;
    }

    public void a(com.baidu.h.a.a.a aVar) {
        this.bHv = aVar;
    }

    public com.baidu.h.a.c.a TU() {
        return this.bHw;
    }

    public void a(com.baidu.h.a.c.a aVar) {
        this.bHw = aVar;
    }

    public com.baidu.h.a.d.a TV() {
        return this.bHx;
    }

    public void a(com.baidu.h.a.d.a aVar) {
        this.bHx = aVar;
    }

    public b TW() {
        return this.bHy;
    }

    public void a(b bVar) {
        this.bHy = bVar;
    }
}
