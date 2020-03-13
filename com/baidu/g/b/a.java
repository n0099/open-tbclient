package com.baidu.g.b;

import android.content.Context;
/* loaded from: classes3.dex */
public class a {
    private static volatile a aIu;
    private com.baidu.g.a.b.a.b aIv;
    private com.baidu.g.a.a.a aIw;
    private com.baidu.g.a.c.a aIx;
    private com.baidu.g.a.d.a aIy;
    private b aIz;
    private Context mContext;

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a aP(Context context) {
        if (aIu == null) {
            synchronized (a.class) {
                if (aIu == null) {
                    aIu = new a(context);
                }
            }
        }
        return aIu;
    }

    public com.baidu.g.a.b.a.b BP() {
        return this.aIv;
    }

    public void a(com.baidu.g.a.b.a.b bVar) {
        this.aIv = bVar;
    }

    public com.baidu.g.a.a.a BQ() {
        return this.aIw;
    }

    public void a(com.baidu.g.a.a.a aVar) {
        this.aIw = aVar;
    }

    public com.baidu.g.a.c.a BR() {
        return this.aIx;
    }

    public void a(com.baidu.g.a.c.a aVar) {
        this.aIx = aVar;
    }

    public com.baidu.g.a.d.a BS() {
        return this.aIy;
    }

    public void a(com.baidu.g.a.d.a aVar) {
        this.aIy = aVar;
    }

    public b BT() {
        return this.aIz;
    }

    public void a(b bVar) {
        this.aIz = bVar;
    }
}
