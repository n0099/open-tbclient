package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements b {
    private static volatile a Lv = null;
    private b Lw;

    public static a mb() {
        if (Lv == null) {
            synchronized (a.class) {
                if (Lv == null) {
                    Lv = new a();
                }
            }
        }
        return Lv;
    }

    public void b(b bVar) {
        this.Lw = bVar;
    }

    @Override // com.baidu.b.a.b.b
    public View H(Context context, String str) {
        if (this.Lw == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.Lw.H(context, str);
    }

    @Override // com.baidu.b.a.b.b
    public boolean a(String str, View view2, com.baidu.b.a.a.a aVar, boolean z) {
        if (this.Lw == null || view2 == null || aVar == null) {
            return false;
        }
        return this.Lw.a(str, view2, aVar, z);
    }
}
