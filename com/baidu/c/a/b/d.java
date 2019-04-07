package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class d implements c {
    private static volatile d adc = null;
    private c ade;

    public static d si() {
        if (adc == null) {
            synchronized (d.class) {
                if (adc == null) {
                    adc = new d();
                }
            }
        }
        return adc;
    }

    public void b(c cVar) {
        this.ade = cVar;
    }

    @Override // com.baidu.c.a.b.c
    public View Z(Context context, String str) {
        if (this.ade == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.ade.Z(context, str);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar) {
        if (this.ade == null || view == null || aVar == null) {
            return false;
        }
        return this.ade.a(str, view, aVar);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.ade == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.ade.a(str, view, str2, str3);
    }
}
