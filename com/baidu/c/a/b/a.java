package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements b {
    private static volatile a aaS = null;
    private b aaT;

    public static a sq() {
        if (aaS == null) {
            synchronized (a.class) {
                if (aaS == null) {
                    aaS = new a();
                }
            }
        }
        return aaS;
    }

    public void b(b bVar) {
        this.aaT = bVar;
    }

    @Override // com.baidu.c.a.b.b
    public View Z(Context context, String str) {
        if (this.aaT == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.aaT.Z(context, str);
    }

    @Override // com.baidu.c.a.b.b
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar, boolean z) {
        if (this.aaT == null || view == null || aVar == null) {
            return false;
        }
        return this.aaT.a(str, view, aVar, z);
    }
}
