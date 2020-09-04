package com.baidu.g.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes20.dex */
public class a implements b {
    private static volatile a atr = null;
    private b ats;

    public static a yU() {
        if (atr == null) {
            synchronized (a.class) {
                if (atr == null) {
                    atr = new a();
                }
            }
        }
        return atr;
    }

    public void b(b bVar) {
        this.ats = bVar;
    }

    @Override // com.baidu.g.a.b.b
    public View A(Context context, String str) {
        if (this.ats == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.ats.A(context, str);
    }

    @Override // com.baidu.g.a.b.b
    public boolean a(String str, View view, com.baidu.g.a.a.a aVar, boolean z) {
        if (this.ats == null || view == null || aVar == null) {
            return false;
        }
        return this.ats.a(str, view, aVar, z);
    }
}
