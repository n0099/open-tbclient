package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements b {
    private static volatile a acU = null;
    private b acV;

    public static a si() {
        if (acU == null) {
            synchronized (a.class) {
                if (acU == null) {
                    acU = new a();
                }
            }
        }
        return acU;
    }

    public void b(b bVar) {
        this.acV = bVar;
    }

    @Override // com.baidu.c.a.b.b
    public View Y(Context context, String str) {
        if (this.acV == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.acV.Y(context, str);
    }

    @Override // com.baidu.c.a.b.b
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar, boolean z) {
        if (this.acV == null || view == null || aVar == null) {
            return false;
        }
        return this.acV.a(str, view, aVar, z);
    }
}
