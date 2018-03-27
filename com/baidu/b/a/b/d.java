package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class d implements c {
    private static volatile d azp = null;
    private c azq;

    public static d tx() {
        if (azp == null) {
            synchronized (d.class) {
                if (azp == null) {
                    azp = new d();
                }
            }
        }
        return azp;
    }

    public void b(c cVar) {
        this.azq = cVar;
    }

    @Override // com.baidu.b.a.b.c
    public View N(Context context, String str) {
        if (this.azq == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.azq.N(context, str);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view, com.baidu.b.a.a.a aVar) {
        if (this.azq == null || view == null || aVar == null) {
            return false;
        }
        return this.azq.a(str, view, aVar);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.azq == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.azq.a(str, view, str2, str3);
    }
}
