package com.baidu.g.b;

import android.content.Context;
/* loaded from: classes2.dex */
public class a {
    private static volatile a aEm;
    private com.baidu.g.a.b.a.b aEn;
    private com.baidu.g.a.a.a aEo;
    private com.baidu.g.a.c.a aEp;
    private com.baidu.g.a.d.a aEq;
    private b aEr;
    private Context mContext;

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a aL(Context context) {
        if (aEm == null) {
            synchronized (a.class) {
                if (aEm == null) {
                    aEm = new a(context);
                }
            }
        }
        return aEm;
    }

    public com.baidu.g.a.b.a.b zx() {
        return this.aEn;
    }

    public void a(com.baidu.g.a.b.a.b bVar) {
        this.aEn = bVar;
    }

    public com.baidu.g.a.a.a zy() {
        return this.aEo;
    }

    public void a(com.baidu.g.a.a.a aVar) {
        this.aEo = aVar;
    }

    public com.baidu.g.a.c.a zz() {
        return this.aEp;
    }

    public void a(com.baidu.g.a.c.a aVar) {
        this.aEp = aVar;
    }

    public com.baidu.g.a.d.a zA() {
        return this.aEq;
    }

    public void a(com.baidu.g.a.d.a aVar) {
        this.aEq = aVar;
    }

    public b zB() {
        return this.aEr;
    }

    public void a(b bVar) {
        this.aEr = bVar;
    }
}
