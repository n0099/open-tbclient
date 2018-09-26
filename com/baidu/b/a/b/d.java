package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class d implements c {
    private static volatile d Wj = null;
    private c Wk;

    public static d qy() {
        if (Wj == null) {
            synchronized (d.class) {
                if (Wj == null) {
                    Wj = new d();
                }
            }
        }
        return Wj;
    }

    public void b(c cVar) {
        this.Wk = cVar;
    }

    @Override // com.baidu.b.a.b.c
    public View Z(Context context, String str) {
        if (this.Wk == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.Wk.Z(context, str);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view, com.baidu.b.a.a.a aVar) {
        if (this.Wk == null || view == null || aVar == null) {
            return false;
        }
        return this.Wk.a(str, view, aVar);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.Wk == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.Wk.a(str, view, str2, str3);
    }
}
