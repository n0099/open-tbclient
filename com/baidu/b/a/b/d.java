package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class d implements c {
    private static volatile d Lt = null;
    private c Lu;

    public static d mH() {
        if (Lt == null) {
            synchronized (d.class) {
                if (Lt == null) {
                    Lt = new d();
                }
            }
        }
        return Lt;
    }

    public void b(c cVar) {
        this.Lu = cVar;
    }

    @Override // com.baidu.b.a.b.c
    public View J(Context context, String str) {
        if (this.Lu == null || context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.Lu.J(context, str);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view, com.baidu.b.a.a.a aVar) {
        if (this.Lu == null || view == null || aVar == null) {
            return false;
        }
        return this.Lu.a(str, view, aVar);
    }

    @Override // com.baidu.b.a.b.c
    public boolean a(String str, View view, String str2, String str3) {
        if (this.Lu == null || view == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        return this.Lu.a(str, view, str2, str3);
    }
}
