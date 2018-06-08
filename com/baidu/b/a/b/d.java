package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class d implements c {
    private static volatile d TI = null;
    private c TJ;

    public static d ps() {
        if (TI == null) {
            synchronized (d.class) {
                if (TI == null) {
                    TI = new d();
                }
            }
        }
        return TI;
    }

    public void b(c cVar) {
        this.TJ = cVar;
    }

    @Override // com.baidu.b.a.b.c
    public View K(Context context, String str) {
        if (this.TJ == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.TJ.K(context, str);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view, com.baidu.b.a.a.a aVar) {
        if (this.TJ == null || view == null || aVar == null) {
            return false;
        }
        return this.TJ.a(str, view, aVar);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.TJ == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.TJ.a(str, view, str2, str3);
    }
}
