package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements b {
    private static volatile a Wh = null;
    private b Wi;

    public static a qx() {
        if (Wh == null) {
            synchronized (a.class) {
                if (Wh == null) {
                    Wh = new a();
                }
            }
        }
        return Wh;
    }

    public void b(b bVar) {
        this.Wi = bVar;
    }

    @Override // com.baidu.b.a.b.b
    public View Y(Context context, String str) {
        if (this.Wi == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.Wi.Y(context, str);
    }

    @Override // com.baidu.b.a.b.b
    public boolean a(String str, View view, com.baidu.b.a.a.a aVar, boolean z) {
        if (this.Wi == null || view == null || aVar == null) {
            return false;
        }
        return this.Wi.a(str, view, aVar, z);
    }
}
