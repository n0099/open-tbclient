package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class d implements c {
    private static volatile d acX = null;
    private c acY;

    public static d sj() {
        if (acX == null) {
            synchronized (d.class) {
                if (acX == null) {
                    acX = new d();
                }
            }
        }
        return acX;
    }

    public void b(c cVar) {
        this.acY = cVar;
    }

    @Override // com.baidu.c.a.b.c
    public View Z(Context context, String str) {
        if (this.acY == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.acY.Z(context, str);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar) {
        if (this.acY == null || view == null || aVar == null) {
            return false;
        }
        return this.acY.a(str, view, aVar);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.acY == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.acY.a(str, view, str2, str3);
    }
}
