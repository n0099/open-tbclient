package com.baidu.c.b;

import android.content.Context;
/* loaded from: classes6.dex */
public class a {
    private static volatile a bme;
    private com.baidu.c.a.b.a.b bmf;
    private com.baidu.c.a.a.a bmg;
    private com.baidu.c.a.c.a bmh;
    private com.baidu.c.a.d.a bmi;
    private b bmj;
    private Context mContext;

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a az(Context context) {
        if (bme == null) {
            synchronized (a.class) {
                if (bme == null) {
                    bme = new a(context);
                }
            }
        }
        return bme;
    }

    public com.baidu.c.a.b.a.b JS() {
        return this.bmf;
    }

    public void a(com.baidu.c.a.b.a.b bVar) {
        this.bmf = bVar;
    }

    public com.baidu.c.a.a.a JT() {
        return this.bmg;
    }

    public void a(com.baidu.c.a.a.a aVar) {
        this.bmg = aVar;
    }

    public com.baidu.c.a.c.a JU() {
        return this.bmh;
    }

    public void a(com.baidu.c.a.c.a aVar) {
        this.bmh = aVar;
    }

    public com.baidu.c.a.d.a JV() {
        return this.bmi;
    }

    public void a(com.baidu.c.a.d.a aVar) {
        this.bmi = aVar;
    }

    public b JW() {
        return this.bmj;
    }

    public void a(b bVar) {
        this.bmj = bVar;
    }
}
