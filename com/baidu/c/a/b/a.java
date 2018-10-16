package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements b {
    private static volatile a aaL = null;
    private b aaM;

    public static a sq() {
        if (aaL == null) {
            synchronized (a.class) {
                if (aaL == null) {
                    aaL = new a();
                }
            }
        }
        return aaL;
    }

    public void b(b bVar) {
        this.aaM = bVar;
    }

    @Override // com.baidu.c.a.b.b
    public View Z(Context context, String str) {
        if (this.aaM == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.aaM.Z(context, str);
    }

    @Override // com.baidu.c.a.b.b
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar, boolean z) {
        if (this.aaM == null || view == null || aVar == null) {
            return false;
        }
        return this.aaM.a(str, view, aVar, z);
    }
}
