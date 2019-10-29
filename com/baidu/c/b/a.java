package com.baidu.c.b;

import android.content.Context;
/* loaded from: classes6.dex */
public class a {
    private static volatile a avU;
    private com.baidu.c.a.b.a.b avV;
    private com.baidu.c.a.a.a avW;
    private com.baidu.c.a.c.a avX;
    private com.baidu.c.a.d.a avY;
    private b avZ;
    private Context mContext;

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a aB(Context context) {
        if (avU == null) {
            synchronized (a.class) {
                if (avU == null) {
                    avU = new a(context);
                }
            }
        }
        return avU;
    }

    public com.baidu.c.a.b.a.b xc() {
        return this.avV;
    }

    public void a(com.baidu.c.a.b.a.b bVar) {
        this.avV = bVar;
    }

    public com.baidu.c.a.a.a xd() {
        return this.avW;
    }

    public void a(com.baidu.c.a.a.a aVar) {
        this.avW = aVar;
    }

    public com.baidu.c.a.c.a xe() {
        return this.avX;
    }

    public void a(com.baidu.c.a.c.a aVar) {
        this.avX = aVar;
    }

    public com.baidu.c.a.d.a xf() {
        return this.avY;
    }

    public void a(com.baidu.c.a.d.a aVar) {
        this.avY = aVar;
    }

    public b xg() {
        return this.avZ;
    }

    public void a(b bVar) {
        this.avZ = bVar;
    }
}
