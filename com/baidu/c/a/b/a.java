package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements b {
    private static volatile a aaJ = null;
    private b aaK;

    public static a sn() {
        if (aaJ == null) {
            synchronized (a.class) {
                if (aaJ == null) {
                    aaJ = new a();
                }
            }
        }
        return aaJ;
    }

    public void b(b bVar) {
        this.aaK = bVar;
    }

    @Override // com.baidu.c.a.b.b
    public View Z(Context context, String str) {
        if (this.aaK == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.aaK.Z(context, str);
    }

    @Override // com.baidu.c.a.b.b
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar, boolean z) {
        if (this.aaK == null || view == null || aVar == null) {
            return false;
        }
        return this.aaK.a(str, view, aVar, z);
    }
}
