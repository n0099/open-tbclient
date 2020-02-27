package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes13.dex */
public class a implements b {
    private static volatile a SY = null;
    private b SZ;

    public static a oy() {
        if (SY == null) {
            synchronized (a.class) {
                if (SY == null) {
                    SY = new a();
                }
            }
        }
        return SY;
    }

    public void b(b bVar) {
        this.SZ = bVar;
    }

    @Override // com.baidu.c.a.b.b
    public View O(Context context, String str) {
        if (this.SZ == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.SZ.O(context, str);
    }

    @Override // com.baidu.c.a.b.b
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar, boolean z) {
        if (this.SZ == null || view == null || aVar == null) {
            return false;
        }
        return this.SZ.a(str, view, aVar, z);
    }
}
