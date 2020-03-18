package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes13.dex */
public class d implements c {
    private static volatile d Tl = null;
    private c Tm;

    public static d oE() {
        if (Tl == null) {
            synchronized (d.class) {
                if (Tl == null) {
                    Tl = new d();
                }
            }
        }
        return Tl;
    }

    public void b(c cVar) {
        this.Tm = cVar;
    }

    @Override // com.baidu.c.a.b.c
    public View P(Context context, String str) {
        if (this.Tm == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.Tm.P(context, str);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar) {
        if (this.Tm == null || view == null || aVar == null) {
            return false;
        }
        return this.Tm.a(str, view, aVar);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.Tm == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.Tm.a(str, view, str2, str3);
    }
}
