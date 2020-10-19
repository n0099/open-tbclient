package com.baidu.g.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes26.dex */
public class a implements b {
    private static volatile a auC = null;
    private b auD;

    public static a zq() {
        if (auC == null) {
            synchronized (a.class) {
                if (auC == null) {
                    auC = new a();
                }
            }
        }
        return auC;
    }

    public void b(b bVar) {
        this.auD = bVar;
    }

    @Override // com.baidu.g.a.b.b
    public View C(Context context, String str) {
        if (this.auD == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.auD.C(context, str);
    }

    @Override // com.baidu.g.a.b.b
    public boolean a(String str, View view, com.baidu.g.a.a.a aVar, boolean z) {
        if (this.auD == null || view == null || aVar == null) {
            return false;
        }
        return this.auD.a(str, view, aVar, z);
    }
}
