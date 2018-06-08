package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements b {
    private static volatile a TG = null;
    private b TH;

    public static a pr() {
        if (TG == null) {
            synchronized (a.class) {
                if (TG == null) {
                    TG = new a();
                }
            }
        }
        return TG;
    }

    public void b(b bVar) {
        this.TH = bVar;
    }

    @Override // com.baidu.b.a.b.b
    public View J(Context context, String str) {
        if (this.TH == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.TH.J(context, str);
    }

    @Override // com.baidu.b.a.b.b
    public boolean a(String str, View view, com.baidu.b.a.a.a aVar, boolean z) {
        if (this.TH == null || view == null || aVar == null) {
            return false;
        }
        return this.TH.a(str, view, aVar, z);
    }
}
