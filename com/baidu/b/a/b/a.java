package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements b {
    private static volatile a TE = null;
    private b TF;

    public static a pv() {
        if (TE == null) {
            synchronized (a.class) {
                if (TE == null) {
                    TE = new a();
                }
            }
        }
        return TE;
    }

    public void b(b bVar) {
        this.TF = bVar;
    }

    @Override // com.baidu.b.a.b.b
    public View K(Context context, String str) {
        if (this.TF == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.TF.K(context, str);
    }

    @Override // com.baidu.b.a.b.b
    public boolean a(String str, View view, com.baidu.b.a.a.a aVar, boolean z) {
        if (this.TF == null || view == null || aVar == null) {
            return false;
        }
        return this.TF.a(str, view, aVar, z);
    }
}
