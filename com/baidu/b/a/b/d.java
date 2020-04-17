package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes13.dex */
public class d implements c {
    private static volatile d alx = null;
    private c aly;

    public static d sY() {
        if (alx == null) {
            synchronized (d.class) {
                if (alx == null) {
                    alx = new d();
                }
            }
        }
        return alx;
    }

    public void b(c cVar) {
        this.aly = cVar;
    }

    @Override // com.baidu.b.a.b.c
    public View N(Context context, String str) {
        if (this.aly == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.aly.N(context, str);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view, com.baidu.b.a.a.a aVar) {
        if (this.aly == null || view == null || aVar == null) {
            return false;
        }
        return this.aly.a(str, view, aVar);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.aly == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.aly.a(str, view, str2, str3);
    }
}
