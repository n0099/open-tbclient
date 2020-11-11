package com.baidu.h.b;

import android.content.Context;
/* loaded from: classes15.dex */
public class a {
    private static volatile a bVy;
    private com.baidu.h.a.a.a bVA;
    private com.baidu.h.a.c.a bVB;
    private com.baidu.h.a.d.a bVC;
    private b bVD;
    private com.baidu.h.a.b.a.b bVz;
    private Context mContext;

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a aJ(Context context) {
        if (bVy == null) {
            synchronized (a.class) {
                if (bVy == null) {
                    bVy = new a(context);
                }
            }
        }
        return bVy;
    }

    public com.baidu.h.a.b.a.b Yl() {
        return this.bVz;
    }

    public void a(com.baidu.h.a.b.a.b bVar) {
        this.bVz = bVar;
    }

    public com.baidu.h.a.a.a Ym() {
        return this.bVA;
    }

    public void a(com.baidu.h.a.a.a aVar) {
        this.bVA = aVar;
    }

    public com.baidu.h.a.c.a Yn() {
        return this.bVB;
    }

    public void a(com.baidu.h.a.c.a aVar) {
        this.bVB = aVar;
    }

    public com.baidu.h.a.d.a Yo() {
        return this.bVC;
    }

    public void a(com.baidu.h.a.d.a aVar) {
        this.bVC = aVar;
    }

    public b Yp() {
        return this.bVD;
    }

    public void a(b bVar) {
        this.bVD = bVar;
    }
}
