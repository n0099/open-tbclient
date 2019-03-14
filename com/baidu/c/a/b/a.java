package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements b {
    private static volatile a acV = null;
    private b acW;

    public static a si() {
        if (acV == null) {
            synchronized (a.class) {
                if (acV == null) {
                    acV = new a();
                }
            }
        }
        return acV;
    }

    public void b(b bVar) {
        this.acW = bVar;
    }

    @Override // com.baidu.c.a.b.b
    public View Y(Context context, String str) {
        if (this.acW == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.acW.Y(context, str);
    }

    @Override // com.baidu.c.a.b.b
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar, boolean z) {
        if (this.acW == null || view == null || aVar == null) {
            return false;
        }
        return this.acW.a(str, view, aVar, z);
    }
}
