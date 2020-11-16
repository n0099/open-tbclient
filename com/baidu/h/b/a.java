package com.baidu.h.b;

import android.content.Context;
/* loaded from: classes9.dex */
public class a {
    private static volatile a bTO;
    private com.baidu.h.a.b.a.b bTP;
    private com.baidu.h.a.a.a bTQ;
    private com.baidu.h.a.c.a bTR;
    private com.baidu.h.a.d.a bTS;
    private b bTT;
    private Context mContext;

    private a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static a aJ(Context context) {
        if (bTO == null) {
            synchronized (a.class) {
                if (bTO == null) {
                    bTO = new a(context);
                }
            }
        }
        return bTO;
    }

    public com.baidu.h.a.b.a.b XC() {
        return this.bTP;
    }

    public void a(com.baidu.h.a.b.a.b bVar) {
        this.bTP = bVar;
    }

    public com.baidu.h.a.a.a XD() {
        return this.bTQ;
    }

    public void a(com.baidu.h.a.a.a aVar) {
        this.bTQ = aVar;
    }

    public com.baidu.h.a.c.a XE() {
        return this.bTR;
    }

    public void a(com.baidu.h.a.c.a aVar) {
        this.bTR = aVar;
    }

    public com.baidu.h.a.d.a XF() {
        return this.bTS;
    }

    public void a(com.baidu.h.a.d.a aVar) {
        this.bTS = aVar;
    }

    public b XG() {
        return this.bTT;
    }

    public void a(b bVar) {
        this.bTT = bVar;
    }
}
