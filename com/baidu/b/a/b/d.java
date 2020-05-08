package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes13.dex */
public class d implements c {
    private static volatile d alD = null;
    private c alE;

    public static d sX() {
        if (alD == null) {
            synchronized (d.class) {
                if (alD == null) {
                    alD = new d();
                }
            }
        }
        return alD;
    }

    public void b(c cVar) {
        this.alE = cVar;
    }

    @Override // com.baidu.b.a.b.c
    public View B(Context context, String str) {
        if (this.alE == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.alE.B(context, str);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view, com.baidu.b.a.a.a aVar) {
        if (this.alE == null || view == null || aVar == null) {
            return false;
        }
        return this.alE.a(str, view, aVar);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.alE == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.alE.a(str, view, str2, str3);
    }
}
