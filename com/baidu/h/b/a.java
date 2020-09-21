package com.baidu.h.b;

import android.content.Context;
/* loaded from: classes23.dex */
public class a {
    private static volatile a bAQ;
    private com.baidu.h.a.b.a.b bAR;
    private com.baidu.h.a.a.a bAS;
    private com.baidu.h.a.c.a bAT;
    private com.baidu.h.a.d.a bAU;
    private b bAV;
    private Context mContext;

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a aF(Context context) {
        if (bAQ == null) {
            synchronized (a.class) {
                if (bAQ == null) {
                    bAQ = new a(context);
                }
            }
        }
        return bAQ;
    }

    public com.baidu.h.a.b.a.b RZ() {
        return this.bAR;
    }

    public void a(com.baidu.h.a.b.a.b bVar) {
        this.bAR = bVar;
    }

    public com.baidu.h.a.a.a Sa() {
        return this.bAS;
    }

    public void a(com.baidu.h.a.a.a aVar) {
        this.bAS = aVar;
    }

    public com.baidu.h.a.c.a Sb() {
        return this.bAT;
    }

    public void a(com.baidu.h.a.c.a aVar) {
        this.bAT = aVar;
    }

    public com.baidu.h.a.d.a Sc() {
        return this.bAU;
    }

    public void a(com.baidu.h.a.d.a aVar) {
        this.bAU = aVar;
    }

    public b Sd() {
        return this.bAV;
    }

    public void a(b bVar) {
        this.bAV = bVar;
    }
}
