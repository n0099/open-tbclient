package com.baidu.i.b;

import android.content.Context;
/* loaded from: classes11.dex */
public class a {
    private static volatile a bZe;
    private com.baidu.i.a.b.a.b bZf;
    private com.baidu.i.a.a.a bZg;
    private com.baidu.i.a.c.a bZh;
    private com.baidu.i.a.d.a bZi;
    private b bZj;
    private Context mContext;

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a bn(Context context) {
        if (bZe == null) {
            synchronized (a.class) {
                if (bZe == null) {
                    bZe = new a(context);
                }
            }
        }
        return bZe;
    }

    public com.baidu.i.a.b.a.b aaf() {
        return this.bZf;
    }

    public void a(com.baidu.i.a.b.a.b bVar) {
        this.bZf = bVar;
    }

    public com.baidu.i.a.a.a aag() {
        return this.bZg;
    }

    public void a(com.baidu.i.a.a.a aVar) {
        this.bZg = aVar;
    }

    public com.baidu.i.a.c.a aah() {
        return this.bZh;
    }

    public void a(com.baidu.i.a.c.a aVar) {
        this.bZh = aVar;
    }

    public com.baidu.i.a.d.a aai() {
        return this.bZi;
    }

    public void a(com.baidu.i.a.d.a aVar) {
        this.bZi = aVar;
    }

    public b aaj() {
        return this.bZj;
    }

    public void a(b bVar) {
        this.bZj = bVar;
    }
}
