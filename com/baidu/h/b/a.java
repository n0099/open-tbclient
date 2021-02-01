package com.baidu.h.b;

import android.content.Context;
/* loaded from: classes10.dex */
public class a {
    private static volatile a cfk;
    private com.baidu.h.a.b.a.b cfl;
    private com.baidu.h.a.a.a cfm;
    private com.baidu.h.a.c.a cfn;
    private com.baidu.h.a.d.a cfo;
    private b cfp;
    private Context mContext;

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a bA(Context context) {
        if (cfk == null) {
            synchronized (a.class) {
                if (cfk == null) {
                    cfk = new a(context);
                }
            }
        }
        return cfk;
    }

    public com.baidu.h.a.b.a.b ZU() {
        return this.cfl;
    }

    public void a(com.baidu.h.a.b.a.b bVar) {
        this.cfl = bVar;
    }

    public com.baidu.h.a.a.a ZV() {
        return this.cfm;
    }

    public void a(com.baidu.h.a.a.a aVar) {
        this.cfm = aVar;
    }

    public com.baidu.h.a.c.a ZW() {
        return this.cfn;
    }

    public void a(com.baidu.h.a.c.a aVar) {
        this.cfn = aVar;
    }

    public com.baidu.h.a.d.a ZX() {
        return this.cfo;
    }

    public void a(com.baidu.h.a.d.a aVar) {
        this.cfo = aVar;
    }

    public b ZY() {
        return this.cfp;
    }

    public void a(b bVar) {
        this.cfp = bVar;
    }
}
