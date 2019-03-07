package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class d implements c {
    private static volatile d acW = null;
    private c acX;

    public static d sj() {
        if (acW == null) {
            synchronized (d.class) {
                if (acW == null) {
                    acW = new d();
                }
            }
        }
        return acW;
    }

    public void b(c cVar) {
        this.acX = cVar;
    }

    @Override // com.baidu.c.a.b.c
    public View Z(Context context, String str) {
        if (this.acX == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.acX.Z(context, str);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar) {
        if (this.acX == null || view == null || aVar == null) {
            return false;
        }
        return this.acX.a(str, view, aVar);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.acX == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.acX.a(str, view, str2, str3);
    }
}
