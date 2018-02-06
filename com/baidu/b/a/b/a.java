package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements b {
    private static volatile a azv = null;
    private b azw;

    public static a tw() {
        if (azv == null) {
            synchronized (a.class) {
                if (azv == null) {
                    azv = new a();
                }
            }
        }
        return azv;
    }

    public void b(b bVar) {
        this.azw = bVar;
    }

    @Override // com.baidu.b.a.b.b
    public View M(Context context, String str) {
        if (this.azw == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.azw.M(context, str);
    }

    @Override // com.baidu.b.a.b.b
    public boolean a(String str, View view, com.baidu.b.a.a.a aVar, boolean z) {
        if (this.azw == null || view == null || aVar == null) {
            return false;
        }
        return this.azw.a(str, view, aVar, z);
    }
}
