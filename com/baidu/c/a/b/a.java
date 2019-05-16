package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements b {
    private static volatile a aaO = null;
    private b aaP;

    public static a rc() {
        if (aaO == null) {
            synchronized (a.class) {
                if (aaO == null) {
                    aaO = new a();
                }
            }
        }
        return aaO;
    }

    public void b(b bVar) {
        this.aaP = bVar;
    }

    @Override // com.baidu.c.a.b.b
    public View K(Context context, String str) {
        if (this.aaP == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.aaP.K(context, str);
    }

    @Override // com.baidu.c.a.b.b
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar, boolean z) {
        if (this.aaP == null || view == null || aVar == null) {
            return false;
        }
        return this.aaP.a(str, view, aVar, z);
    }
}
