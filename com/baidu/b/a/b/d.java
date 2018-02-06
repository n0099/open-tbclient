package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class d implements c {
    private static volatile d azx = null;
    private c azy;

    public static d tx() {
        if (azx == null) {
            synchronized (d.class) {
                if (azx == null) {
                    azx = new d();
                }
            }
        }
        return azx;
    }

    public void b(c cVar) {
        this.azy = cVar;
    }

    @Override // com.baidu.b.a.b.c
    public View N(Context context, String str) {
        if (this.azy == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.azy.N(context, str);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view, com.baidu.b.a.a.a aVar) {
        if (this.azy == null || view == null || aVar == null) {
            return false;
        }
        return this.azy.a(str, view, aVar);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.azy == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.azy.a(str, view, str2, str3);
    }
}
