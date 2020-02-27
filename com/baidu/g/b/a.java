package com.baidu.g.b;

import android.content.Context;
/* loaded from: classes3.dex */
public class a {
    private static volatile a aIs;
    private com.baidu.g.a.b.a.b aIt;
    private com.baidu.g.a.a.a aIu;
    private com.baidu.g.a.c.a aIv;
    private com.baidu.g.a.d.a aIw;
    private b aIx;
    private Context mContext;

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a aP(Context context) {
        if (aIs == null) {
            synchronized (a.class) {
                if (aIs == null) {
                    aIs = new a(context);
                }
            }
        }
        return aIs;
    }

    public com.baidu.g.a.b.a.b BN() {
        return this.aIt;
    }

    public void a(com.baidu.g.a.b.a.b bVar) {
        this.aIt = bVar;
    }

    public com.baidu.g.a.a.a BO() {
        return this.aIu;
    }

    public void a(com.baidu.g.a.a.a aVar) {
        this.aIu = aVar;
    }

    public com.baidu.g.a.c.a BP() {
        return this.aIv;
    }

    public void a(com.baidu.g.a.c.a aVar) {
        this.aIv = aVar;
    }

    public com.baidu.g.a.d.a BQ() {
        return this.aIw;
    }

    public void a(com.baidu.g.a.d.a aVar) {
        this.aIw = aVar;
    }

    public b BR() {
        return this.aIx;
    }

    public void a(b bVar) {
        this.aIx = bVar;
    }
}
