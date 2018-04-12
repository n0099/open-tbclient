package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class d implements c {
    private static volatile d LB = null;
    private c LC;

    public static d md() {
        if (LB == null) {
            synchronized (d.class) {
                if (LB == null) {
                    LB = new d();
                }
            }
        }
        return LB;
    }

    public void b(c cVar) {
        this.LC = cVar;
    }

    @Override // com.baidu.b.a.b.c
    public View I(Context context, String str) {
        if (this.LC == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.LC.I(context, str);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view2, com.baidu.b.a.a.a aVar) {
        if (this.LC == null || view2 == null || aVar == null) {
            return false;
        }
        return this.LC.a(str, view2, aVar);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view2, String str2, String str3) {
        if (this.LC == null || view2 == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.LC.a(str, view2, str2, str3);
    }
}
