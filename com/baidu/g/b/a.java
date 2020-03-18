package com.baidu.g.b;

import android.content.Context;
/* loaded from: classes3.dex */
public class a {
    private static volatile a aII;
    private com.baidu.g.a.b.a.b aIJ;
    private com.baidu.g.a.a.a aIK;
    private com.baidu.g.a.c.a aIL;
    private com.baidu.g.a.d.a aIM;
    private b aIN;
    private Context mContext;

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a aO(Context context) {
        if (aII == null) {
            synchronized (a.class) {
                if (aII == null) {
                    aII = new a(context);
                }
            }
        }
        return aII;
    }

    public com.baidu.g.a.b.a.b BW() {
        return this.aIJ;
    }

    public void a(com.baidu.g.a.b.a.b bVar) {
        this.aIJ = bVar;
    }

    public com.baidu.g.a.a.a BX() {
        return this.aIK;
    }

    public void a(com.baidu.g.a.a.a aVar) {
        this.aIK = aVar;
    }

    public com.baidu.g.a.c.a BY() {
        return this.aIL;
    }

    public void a(com.baidu.g.a.c.a aVar) {
        this.aIL = aVar;
    }

    public com.baidu.g.a.d.a BZ() {
        return this.aIM;
    }

    public void a(com.baidu.g.a.d.a aVar) {
        this.aIM = aVar;
    }

    public b Ca() {
        return this.aIN;
    }

    public void a(b bVar) {
        this.aIN = bVar;
    }
}
