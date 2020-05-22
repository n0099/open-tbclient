package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes13.dex */
public class a implements b {
    private static volatile a and = null;
    private b ane;

    public static a tf() {
        if (and == null) {
            synchronized (a.class) {
                if (and == null) {
                    and = new a();
                }
            }
        }
        return and;
    }

    public void b(b bVar) {
        this.ane = bVar;
    }

    @Override // com.baidu.b.a.b.b
    public View A(Context context, String str) {
        if (this.ane == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.ane.A(context, str);
    }

    @Override // com.baidu.b.a.b.b
    public boolean a(String str, View view, com.baidu.b.a.a.a aVar, boolean z) {
        if (this.ane == null || view == null || aVar == null) {
            return false;
        }
        return this.ane.a(str, view, aVar, z);
    }
}
