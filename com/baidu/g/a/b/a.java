package com.baidu.g.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes26.dex */
public class a implements b {
    private static volatile a auD = null;
    private b auE;

    public static a zq() {
        if (auD == null) {
            synchronized (a.class) {
                if (auD == null) {
                    auD = new a();
                }
            }
        }
        return auD;
    }

    public void b(b bVar) {
        this.auE = bVar;
    }

    @Override // com.baidu.g.a.b.b
    public View C(Context context, String str) {
        if (this.auE == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.auE.C(context, str);
    }

    @Override // com.baidu.g.a.b.b
    public boolean a(String str, View view, com.baidu.g.a.a.a aVar, boolean z) {
        if (this.auE == null || view == null || aVar == null) {
            return false;
        }
        return this.auE.a(str, view, aVar, z);
    }
}
