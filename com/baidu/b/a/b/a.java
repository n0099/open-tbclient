package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements b {
    private static volatile a TI = null;
    private b TJ;

    public static a pr() {
        if (TI == null) {
            synchronized (a.class) {
                if (TI == null) {
                    TI = new a();
                }
            }
        }
        return TI;
    }

    public void b(b bVar) {
        this.TJ = bVar;
    }

    @Override // com.baidu.b.a.b.b
    public View J(Context context, String str) {
        if (this.TJ == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.TJ.J(context, str);
    }

    @Override // com.baidu.b.a.b.b
    public boolean a(String str, View view, com.baidu.b.a.a.a aVar, boolean z) {
        if (this.TJ == null || view == null || aVar == null) {
            return false;
        }
        return this.TJ.a(str, view, aVar, z);
    }
}
