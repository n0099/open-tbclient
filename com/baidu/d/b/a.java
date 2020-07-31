package com.baidu.d.b;

import android.content.Context;
/* loaded from: classes4.dex */
public class a {
    private static volatile a brA;
    private com.baidu.d.a.b.a.b brB;
    private com.baidu.d.a.a.a brC;
    private com.baidu.d.a.c.a brD;
    private com.baidu.d.a.d.a brE;
    private b brF;
    private Context mContext;

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a aA(Context context) {
        if (brA == null) {
            synchronized (a.class) {
                if (brA == null) {
                    brA = new a(context);
                }
            }
        }
        return brA;
    }

    public com.baidu.d.a.b.a.b Li() {
        return this.brB;
    }

    public void a(com.baidu.d.a.b.a.b bVar) {
        this.brB = bVar;
    }

    public com.baidu.d.a.a.a Lj() {
        return this.brC;
    }

    public void a(com.baidu.d.a.a.a aVar) {
        this.brC = aVar;
    }

    public com.baidu.d.a.c.a Lk() {
        return this.brD;
    }

    public void a(com.baidu.d.a.c.a aVar) {
        this.brD = aVar;
    }

    public com.baidu.d.a.d.a Ll() {
        return this.brE;
    }

    public void a(com.baidu.d.a.d.a aVar) {
        this.brE = aVar;
    }

    public b Lm() {
        return this.brF;
    }

    public void a(b bVar) {
        this.brF = bVar;
    }
}
