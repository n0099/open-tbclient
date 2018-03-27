package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements b {
    private static volatile a azn = null;
    private b azo;

    public static a tw() {
        if (azn == null) {
            synchronized (a.class) {
                if (azn == null) {
                    azn = new a();
                }
            }
        }
        return azn;
    }

    public void b(b bVar) {
        this.azo = bVar;
    }

    @Override // com.baidu.b.a.b.b
    public View M(Context context, String str) {
        if (this.azo == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.azo.M(context, str);
    }

    @Override // com.baidu.b.a.b.b
    public boolean a(String str, View view, com.baidu.b.a.a.a aVar, boolean z) {
        if (this.azo == null || view == null || aVar == null) {
            return false;
        }
        return this.azo.a(str, view, aVar, z);
    }
}
