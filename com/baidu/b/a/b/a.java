package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements b {
    private static volatile a Lr = null;
    private b Ls;

    public static a mG() {
        if (Lr == null) {
            synchronized (a.class) {
                if (Lr == null) {
                    Lr = new a();
                }
            }
        }
        return Lr;
    }

    public void b(b bVar) {
        this.Ls = bVar;
    }

    @Override // com.baidu.b.a.b.b
    public View I(Context context, String str) {
        if (this.Ls == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.Ls.I(context, str);
    }

    @Override // com.baidu.b.a.b.b
    public boolean a(String str, View view, com.baidu.b.a.a.a aVar, boolean z) {
        if (this.Ls == null || view == null || aVar == null) {
            return false;
        }
        return this.Ls.a(str, view, aVar, z);
    }
}
