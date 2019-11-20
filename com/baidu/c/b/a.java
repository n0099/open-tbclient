package com.baidu.c.b;

import android.content.Context;
/* loaded from: classes6.dex */
public class a {
    private static volatile a avC;
    private com.baidu.c.a.b.a.b avD;
    private com.baidu.c.a.a.a avE;
    private com.baidu.c.a.c.a avF;
    private com.baidu.c.a.d.a avG;
    private b avH;
    private Context mContext;

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a aB(Context context) {
        if (avC == null) {
            synchronized (a.class) {
                if (avC == null) {
                    avC = new a(context);
                }
            }
        }
        return avC;
    }

    public com.baidu.c.a.b.a.b xd() {
        return this.avD;
    }

    public void a(com.baidu.c.a.b.a.b bVar) {
        this.avD = bVar;
    }

    public com.baidu.c.a.a.a xe() {
        return this.avE;
    }

    public void a(com.baidu.c.a.a.a aVar) {
        this.avE = aVar;
    }

    public com.baidu.c.a.c.a xf() {
        return this.avF;
    }

    public void a(com.baidu.c.a.c.a aVar) {
        this.avF = aVar;
    }

    public com.baidu.c.a.d.a xg() {
        return this.avG;
    }

    public void a(com.baidu.c.a.d.a aVar) {
        this.avG = aVar;
    }

    public b xh() {
        return this.avH;
    }

    public void a(b bVar) {
        this.avH = bVar;
    }
}
