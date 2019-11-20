package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class d implements c {
    private static volatile d KT = null;
    private c KU;

    public static d mH() {
        if (KT == null) {
            synchronized (d.class) {
                if (KT == null) {
                    KT = new d();
                }
            }
        }
        return KT;
    }

    public void b(c cVar) {
        this.KU = cVar;
    }

    @Override // com.baidu.b.a.b.c
    public View J(Context context, String str) {
        if (this.KU == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.KU.J(context, str);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view, com.baidu.b.a.a.a aVar) {
        if (this.KU == null || view == null || aVar == null) {
            return false;
        }
        return this.KU.a(str, view, aVar);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.KU == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.KU.a(str, view, str2, str3);
    }
}
