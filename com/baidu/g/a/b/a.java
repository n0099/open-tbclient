package com.baidu.g.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes25.dex */
public class a implements b {
    private static volatile a atT = null;
    private b atU;

    public static a zi() {
        if (atT == null) {
            synchronized (a.class) {
                if (atT == null) {
                    atT = new a();
                }
            }
        }
        return atT;
    }

    public void b(b bVar) {
        this.atU = bVar;
    }

    @Override // com.baidu.g.a.b.b
    public View A(Context context, String str) {
        if (this.atU == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.atU.A(context, str);
    }

    @Override // com.baidu.g.a.b.b
    public boolean a(String str, View view, com.baidu.g.a.a.a aVar, boolean z) {
        if (this.atU == null || view == null || aVar == null) {
            return false;
        }
        return this.atU.a(str, view, aVar, z);
    }
}
