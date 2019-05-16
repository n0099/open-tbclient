package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class d implements c {
    private static volatile d aaQ = null;
    private c aaR;

    public static d rd() {
        if (aaQ == null) {
            synchronized (d.class) {
                if (aaQ == null) {
                    aaQ = new d();
                }
            }
        }
        return aaQ;
    }

    public void b(c cVar) {
        this.aaR = cVar;
    }

    @Override // com.baidu.c.a.b.c
    public View L(Context context, String str) {
        if (this.aaR == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.aaR.L(context, str);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar) {
        if (this.aaR == null || view == null || aVar == null) {
            return false;
        }
        return this.aaR.a(str, view, aVar);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.aaR == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.aaR.a(str, view, str2, str3);
    }
}
