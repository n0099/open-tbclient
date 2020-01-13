package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes11.dex */
public class d implements c {
    private static volatile d Rs = null;
    private c Rt;

    public static d nQ() {
        if (Rs == null) {
            synchronized (d.class) {
                if (Rs == null) {
                    Rs = new d();
                }
            }
        }
        return Rs;
    }

    public void b(c cVar) {
        this.Rt = cVar;
    }

    @Override // com.baidu.c.a.b.c
    public View P(Context context, String str) {
        if (this.Rt == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.Rt.P(context, str);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar) {
        if (this.Rt == null || view == null || aVar == null) {
            return false;
        }
        return this.Rt.a(str, view, aVar);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.Rt == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.Rt.a(str, view, str2, str3);
    }
}
