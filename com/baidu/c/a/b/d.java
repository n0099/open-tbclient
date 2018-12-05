package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class d implements c {
    private static volatile d aaL = null;
    private c aaM;

    public static d sn() {
        if (aaL == null) {
            synchronized (d.class) {
                if (aaL == null) {
                    aaL = new d();
                }
            }
        }
        return aaL;
    }

    public void b(c cVar) {
        this.aaM = cVar;
    }

    @Override // com.baidu.c.a.b.c
    public View aa(Context context, String str) {
        if (this.aaM == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.aaM.aa(context, str);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar) {
        if (this.aaM == null || view == null || aVar == null) {
            return false;
        }
        return this.aaM.a(str, view, aVar);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.aaM == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.aaM.a(str, view, str2, str3);
    }
}
