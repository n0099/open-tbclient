package com.baidu.g.b;

import android.content.Context;
/* loaded from: classes3.dex */
public class a {
    private static volatile a aIt;
    private com.baidu.g.a.b.a.b aIu;
    private com.baidu.g.a.a.a aIv;
    private com.baidu.g.a.c.a aIw;
    private com.baidu.g.a.d.a aIx;
    private b aIy;
    private Context mContext;

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a aP(Context context) {
        if (aIt == null) {
            synchronized (a.class) {
                if (aIt == null) {
                    aIt = new a(context);
                }
            }
        }
        return aIt;
    }

    public com.baidu.g.a.b.a.b BP() {
        return this.aIu;
    }

    public void a(com.baidu.g.a.b.a.b bVar) {
        this.aIu = bVar;
    }

    public com.baidu.g.a.a.a BQ() {
        return this.aIv;
    }

    public void a(com.baidu.g.a.a.a aVar) {
        this.aIv = aVar;
    }

    public com.baidu.g.a.c.a BR() {
        return this.aIw;
    }

    public void a(com.baidu.g.a.c.a aVar) {
        this.aIw = aVar;
    }

    public com.baidu.g.a.d.a BS() {
        return this.aIx;
    }

    public void a(com.baidu.g.a.d.a aVar) {
        this.aIx = aVar;
    }

    public b BT() {
        return this.aIy;
    }

    public void a(b bVar) {
        this.aIy = bVar;
    }
}
