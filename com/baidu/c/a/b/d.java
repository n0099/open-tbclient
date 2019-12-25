package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes10.dex */
public class d implements c {
    private static volatile d Rp = null;
    private c Rq;

    public static d nP() {
        if (Rp == null) {
            synchronized (d.class) {
                if (Rp == null) {
                    Rp = new d();
                }
            }
        }
        return Rp;
    }

    public void b(c cVar) {
        this.Rq = cVar;
    }

    @Override // com.baidu.c.a.b.c
    public View P(Context context, String str) {
        if (this.Rq == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.Rq.P(context, str);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar) {
        if (this.Rq == null || view == null || aVar == null) {
            return false;
        }
        return this.Rq.a(str, view, aVar);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.Rq == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.Rq.a(str, view, str2, str3);
    }
}
