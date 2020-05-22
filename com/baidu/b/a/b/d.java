package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes13.dex */
public class d implements c {
    private static volatile d anf = null;
    private c ang;

    public static d tg() {
        if (anf == null) {
            synchronized (d.class) {
                if (anf == null) {
                    anf = new d();
                }
            }
        }
        return anf;
    }

    public void b(c cVar) {
        this.ang = cVar;
    }

    @Override // com.baidu.b.a.b.c
    public View B(Context context, String str) {
        if (this.ang == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.ang.B(context, str);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view, com.baidu.b.a.a.a aVar) {
        if (this.ang == null || view == null || aVar == null) {
            return false;
        }
        return this.ang.a(str, view, aVar);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.ang == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.ang.a(str, view, str2, str3);
    }
}
