package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class d implements c {
    private static volatile d TK = null;
    private c TL;

    public static d ps() {
        if (TK == null) {
            synchronized (d.class) {
                if (TK == null) {
                    TK = new d();
                }
            }
        }
        return TK;
    }

    public void b(c cVar) {
        this.TL = cVar;
    }

    @Override // com.baidu.b.a.b.c
    public View K(Context context, String str) {
        if (this.TL == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.TL.K(context, str);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view, com.baidu.b.a.a.a aVar) {
        if (this.TL == null || view == null || aVar == null) {
            return false;
        }
        return this.TL.a(str, view, aVar);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.TL == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.TL.a(str, view, str2, str3);
    }
}
