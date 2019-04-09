package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class d implements c {
    private static volatile d ade = null;
    private c adf;

    public static d si() {
        if (ade == null) {
            synchronized (d.class) {
                if (ade == null) {
                    ade = new d();
                }
            }
        }
        return ade;
    }

    public void b(c cVar) {
        this.adf = cVar;
    }

    @Override // com.baidu.c.a.b.c
    public View Z(Context context, String str) {
        if (this.adf == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.adf.Z(context, str);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar) {
        if (this.adf == null || view == null || aVar == null) {
            return false;
        }
        return this.adf.a(str, view, aVar);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.adf == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.adf.a(str, view, str2, str3);
    }
}
