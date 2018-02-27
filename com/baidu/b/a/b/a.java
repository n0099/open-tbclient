package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements b {
    private static volatile a azm = null;
    private b azn;

    public static a tw() {
        if (azm == null) {
            synchronized (a.class) {
                if (azm == null) {
                    azm = new a();
                }
            }
        }
        return azm;
    }

    public void b(b bVar) {
        this.azn = bVar;
    }

    @Override // com.baidu.b.a.b.b
    public View M(Context context, String str) {
        if (this.azn == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.azn.M(context, str);
    }

    @Override // com.baidu.b.a.b.b
    public boolean a(String str, View view, com.baidu.b.a.a.a aVar, boolean z) {
        if (this.azn == null || view == null || aVar == null) {
            return false;
        }
        return this.azn.a(str, view, aVar, z);
    }
}
