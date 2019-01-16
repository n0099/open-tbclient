package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class d implements c {
    private static volatile d aaU = null;
    private c aaV;

    public static d sr() {
        if (aaU == null) {
            synchronized (d.class) {
                if (aaU == null) {
                    aaU = new d();
                }
            }
        }
        return aaU;
    }

    public void b(c cVar) {
        this.aaV = cVar;
    }

    @Override // com.baidu.c.a.b.c
    public View aa(Context context, String str) {
        if (this.aaV == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.aaV.aa(context, str);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar) {
        if (this.aaV == null || view == null || aVar == null) {
            return false;
        }
        return this.aaV.a(str, view, aVar);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.aaV == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.aaV.a(str, view, str2, str3);
    }
}
