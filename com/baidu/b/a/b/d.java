package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes13.dex */
public class d implements c {
    private static volatile d aox = null;
    private c aoy;

    public static d tz() {
        if (aox == null) {
            synchronized (d.class) {
                if (aox == null) {
                    aox = new d();
                }
            }
        }
        return aox;
    }

    public void b(c cVar) {
        this.aoy = cVar;
    }

    @Override // com.baidu.b.a.b.c
    public View B(Context context, String str) {
        if (this.aoy == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.aoy.B(context, str);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view, com.baidu.b.a.a.a aVar) {
        if (this.aoy == null || view == null || aVar == null) {
            return false;
        }
        return this.aoy.a(str, view, aVar);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.aoy == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.aoy.a(str, view, str2, str3);
    }
}
