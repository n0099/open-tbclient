package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements b {
    private static volatile a Lz = null;
    private b LA;

    public static a mc() {
        if (Lz == null) {
            synchronized (a.class) {
                if (Lz == null) {
                    Lz = new a();
                }
            }
        }
        return Lz;
    }

    public void b(b bVar) {
        this.LA = bVar;
    }

    @Override // com.baidu.b.a.b.b
    public View H(Context context, String str) {
        if (this.LA == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.LA.H(context, str);
    }

    @Override // com.baidu.b.a.b.b
    public boolean a(String str, View view2, com.baidu.b.a.a.a aVar, boolean z) {
        if (this.LA == null || view2 == null || aVar == null) {
            return false;
        }
        return this.LA.a(str, view2, aVar, z);
    }
}
