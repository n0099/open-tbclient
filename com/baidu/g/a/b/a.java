package com.baidu.g.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes20.dex */
public class a implements b {
    private static volatile a atp = null;
    private b atq;

    public static a yU() {
        if (atp == null) {
            synchronized (a.class) {
                if (atp == null) {
                    atp = new a();
                }
            }
        }
        return atp;
    }

    public void b(b bVar) {
        this.atq = bVar;
    }

    @Override // com.baidu.g.a.b.b
    public View A(Context context, String str) {
        if (this.atq == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.atq.A(context, str);
    }

    @Override // com.baidu.g.a.b.b
    public boolean a(String str, View view, com.baidu.g.a.a.a aVar, boolean z) {
        if (this.atq == null || view == null || aVar == null) {
            return false;
        }
        return this.atq.a(str, view, aVar, z);
    }
}
