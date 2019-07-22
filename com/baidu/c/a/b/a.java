package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements b {
    private static volatile a abm = null;
    private b abn;

    public static a rz() {
        if (abm == null) {
            synchronized (a.class) {
                if (abm == null) {
                    abm = new a();
                }
            }
        }
        return abm;
    }

    public void b(b bVar) {
        this.abn = bVar;
    }

    @Override // com.baidu.c.a.b.b
    public View K(Context context, String str) {
        if (this.abn == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.abn.K(context, str);
    }

    @Override // com.baidu.c.a.b.b
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar, boolean z) {
        if (this.abn == null || view == null || aVar == null) {
            return false;
        }
        return this.abn.a(str, view, aVar, z);
    }
}
