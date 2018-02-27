package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class d implements c {
    private static volatile d azo = null;
    private c azp;

    public static d tx() {
        if (azo == null) {
            synchronized (d.class) {
                if (azo == null) {
                    azo = new d();
                }
            }
        }
        return azo;
    }

    public void b(c cVar) {
        this.azp = cVar;
    }

    @Override // com.baidu.b.a.b.c
    public View N(Context context, String str) {
        if (this.azp == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.azp.N(context, str);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view, com.baidu.b.a.a.a aVar) {
        if (this.azp == null || view == null || aVar == null) {
            return false;
        }
        return this.azp.a(str, view, aVar);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.azp == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.azp.a(str, view, str2, str3);
    }
}
