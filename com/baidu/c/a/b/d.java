package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class d implements c {
    private static volatile d abo = null;
    private c abp;

    public static d rA() {
        if (abo == null) {
            synchronized (d.class) {
                if (abo == null) {
                    abo = new d();
                }
            }
        }
        return abo;
    }

    public void b(c cVar) {
        this.abp = cVar;
    }

    @Override // com.baidu.c.a.b.c
    public View L(Context context, String str) {
        if (this.abp == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.abp.L(context, str);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar) {
        if (this.abp == null || view == null || aVar == null) {
            return false;
        }
        return this.abp.a(str, view, aVar);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.abp == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.abp.a(str, view, str2, str3);
    }
}
