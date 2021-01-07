package com.baidu.j.b;

import android.content.Context;
/* loaded from: classes10.dex */
public class a {
    private static volatile a cfO;
    private com.baidu.j.a.b.a.b cfP;
    private com.baidu.j.a.a.a cfQ;
    private com.baidu.j.a.c.a cfR;
    private com.baidu.j.a.d.a cfS;
    private b cfT;
    private Context mContext;

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a by(Context context) {
        if (cfO == null) {
            synchronized (a.class) {
                if (cfO == null) {
                    cfO = new a(context);
                }
            }
        }
        return cfO;
    }

    public com.baidu.j.a.b.a.b abT() {
        return this.cfP;
    }

    public void a(com.baidu.j.a.b.a.b bVar) {
        this.cfP = bVar;
    }

    public com.baidu.j.a.a.a abU() {
        return this.cfQ;
    }

    public void a(com.baidu.j.a.a.a aVar) {
        this.cfQ = aVar;
    }

    public com.baidu.j.a.c.a abV() {
        return this.cfR;
    }

    public void a(com.baidu.j.a.c.a aVar) {
        this.cfR = aVar;
    }

    public com.baidu.j.a.d.a abW() {
        return this.cfS;
    }

    public void a(com.baidu.j.a.d.a aVar) {
        this.cfS = aVar;
    }

    public b abX() {
        return this.cfT;
    }

    public void a(b bVar) {
        this.cfT = bVar;
    }
}
