package com.baidu.h.b;

import android.content.Context;
/* loaded from: classes15.dex */
public class a {
    private static volatile a bPO;
    private com.baidu.h.a.b.a.b bPP;
    private com.baidu.h.a.a.a bPQ;
    private com.baidu.h.a.c.a bPR;
    private com.baidu.h.a.d.a bPS;
    private b bPT;
    private Context mContext;

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a aJ(Context context) {
        if (bPO == null) {
            synchronized (a.class) {
                if (bPO == null) {
                    bPO = new a(context);
                }
            }
        }
        return bPO;
    }

    public com.baidu.h.a.b.a.b VM() {
        return this.bPP;
    }

    public void a(com.baidu.h.a.b.a.b bVar) {
        this.bPP = bVar;
    }

    public com.baidu.h.a.a.a VN() {
        return this.bPQ;
    }

    public void a(com.baidu.h.a.a.a aVar) {
        this.bPQ = aVar;
    }

    public com.baidu.h.a.c.a VO() {
        return this.bPR;
    }

    public void a(com.baidu.h.a.c.a aVar) {
        this.bPR = aVar;
    }

    public com.baidu.h.a.d.a VP() {
        return this.bPS;
    }

    public void a(com.baidu.h.a.d.a aVar) {
        this.bPS = aVar;
    }

    public b VQ() {
        return this.bPT;
    }

    public void a(b bVar) {
        this.bPT = bVar;
    }
}
