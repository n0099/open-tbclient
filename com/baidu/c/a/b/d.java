package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes20.dex */
public class d implements c {
    private static volatile d aot = null;
    private c aou;

    public static d tz() {
        if (aot == null) {
            synchronized (d.class) {
                if (aot == null) {
                    aot = new d();
                }
            }
        }
        return aot;
    }

    public void b(c cVar) {
        this.aou = cVar;
    }

    @Override // com.baidu.c.a.b.c
    public View B(Context context, String str) {
        if (this.aou == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.aou.B(context, str);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar) {
        if (this.aou == null || view == null || aVar == null) {
            return false;
        }
        return this.aou.a(str, view, aVar);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.aou == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.aou.a(str, view, str2, str3);
    }
}
