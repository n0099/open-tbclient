package com.baidu.g.b;

import android.content.Context;
/* loaded from: classes2.dex */
public class a {
    private static volatile a aDu;
    private com.baidu.g.a.b.a.b aDv;
    private com.baidu.g.a.a.a aDw;
    private com.baidu.g.a.c.a aDx;
    private com.baidu.g.a.d.a aDy;
    private b aDz;
    private Context mContext;

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a aL(Context context) {
        if (aDu == null) {
            synchronized (a.class) {
                if (aDu == null) {
                    aDu = new a(context);
                }
            }
        }
        return aDu;
    }

    public com.baidu.g.a.b.a.b zb() {
        return this.aDv;
    }

    public void a(com.baidu.g.a.b.a.b bVar) {
        this.aDv = bVar;
    }

    public com.baidu.g.a.a.a zc() {
        return this.aDw;
    }

    public void a(com.baidu.g.a.a.a aVar) {
        this.aDw = aVar;
    }

    public com.baidu.g.a.c.a zd() {
        return this.aDx;
    }

    public void a(com.baidu.g.a.c.a aVar) {
        this.aDx = aVar;
    }

    public com.baidu.g.a.d.a ze() {
        return this.aDy;
    }

    public void a(com.baidu.g.a.d.a aVar) {
        this.aDy = aVar;
    }

    public b zf() {
        return this.aDz;
    }

    public void a(b bVar) {
        this.aDz = bVar;
    }
}
