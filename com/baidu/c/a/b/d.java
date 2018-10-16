package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class d implements c {
    private static volatile d aaN = null;
    private c aaO;

    public static d sr() {
        if (aaN == null) {
            synchronized (d.class) {
                if (aaN == null) {
                    aaN = new d();
                }
            }
        }
        return aaN;
    }

    public void b(c cVar) {
        this.aaO = cVar;
    }

    @Override // com.baidu.c.a.b.c
    public View aa(Context context, String str) {
        if (this.aaO == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.aaO.aa(context, str);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar) {
        if (this.aaO == null || view == null || aVar == null) {
            return false;
        }
        return this.aaO.a(str, view, aVar);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.aaO == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.aaO.a(str, view, str2, str3);
    }
}
