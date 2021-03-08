package com.baidu.h.b;

import android.content.Context;
/* loaded from: classes9.dex */
public class a {
    private static volatile a cgK;
    private com.baidu.h.a.b.a.b cgL;
    private com.baidu.h.a.a.a cgM;
    private com.baidu.h.a.c.a cgN;
    private com.baidu.h.a.d.a cgO;
    private b cgP;
    private Context mContext;

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a bz(Context context) {
        if (cgK == null) {
            synchronized (a.class) {
                if (cgK == null) {
                    cgK = new a(context);
                }
            }
        }
        return cgK;
    }

    public com.baidu.h.a.b.a.b ZX() {
        return this.cgL;
    }

    public void a(com.baidu.h.a.b.a.b bVar) {
        this.cgL = bVar;
    }

    public com.baidu.h.a.a.a ZY() {
        return this.cgM;
    }

    public void a(com.baidu.h.a.a.a aVar) {
        this.cgM = aVar;
    }

    public com.baidu.h.a.c.a ZZ() {
        return this.cgN;
    }

    public void a(com.baidu.h.a.c.a aVar) {
        this.cgN = aVar;
    }

    public com.baidu.h.a.d.a aaa() {
        return this.cgO;
    }

    public void a(com.baidu.h.a.d.a aVar) {
        this.cgO = aVar;
    }

    public b aab() {
        return this.cgP;
    }

    public void a(b bVar) {
        this.cgP = bVar;
    }
}
