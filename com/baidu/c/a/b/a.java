package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes10.dex */
public class a implements b {
    private static volatile a Rn = null;
    private b Ro;

    public static a nO() {
        if (Rn == null) {
            synchronized (a.class) {
                if (Rn == null) {
                    Rn = new a();
                }
            }
        }
        return Rn;
    }

    public void b(b bVar) {
        this.Ro = bVar;
    }

    @Override // com.baidu.c.a.b.b
    public View O(Context context, String str) {
        if (this.Ro == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.Ro.O(context, str);
    }

    @Override // com.baidu.c.a.b.b
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar, boolean z) {
        if (this.Ro == null || view == null || aVar == null) {
            return false;
        }
        return this.Ro.a(str, view, aVar, z);
    }
}
