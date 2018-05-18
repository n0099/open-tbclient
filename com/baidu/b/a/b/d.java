package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class d implements c {
    private static volatile d Lx = null;
    private c Ly;

    public static d mc() {
        if (Lx == null) {
            synchronized (d.class) {
                if (Lx == null) {
                    Lx = new d();
                }
            }
        }
        return Lx;
    }

    public void b(c cVar) {
        this.Ly = cVar;
    }

    @Override // com.baidu.b.a.b.c
    public View I(Context context, String str) {
        if (this.Ly == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.Ly.I(context, str);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view2, com.baidu.b.a.a.a aVar) {
        if (this.Ly == null || view2 == null || aVar == null) {
            return false;
        }
        return this.Ly.a(str, view2, aVar);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view2, String str2, String str3) {
        if (this.Ly == null || view2 == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.Ly.a(str, view2, str2, str3);
    }
}
