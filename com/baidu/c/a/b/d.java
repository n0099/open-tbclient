package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes13.dex */
public class d implements c {
    private static volatile d Ta = null;
    private c Tb;

    public static d oz() {
        if (Ta == null) {
            synchronized (d.class) {
                if (Ta == null) {
                    Ta = new d();
                }
            }
        }
        return Ta;
    }

    public void b(c cVar) {
        this.Tb = cVar;
    }

    @Override // com.baidu.c.a.b.c
    public View P(Context context, String str) {
        if (this.Tb == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.Tb.P(context, str);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar) {
        if (this.Tb == null || view == null || aVar == null) {
            return false;
        }
        return this.Tb.a(str, view, aVar);
    }

    @Override // com.baidu.c.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.Tb == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.Tb.a(str, view, str2, str3);
    }
}
