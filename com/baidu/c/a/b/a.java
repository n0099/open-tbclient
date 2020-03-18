package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes13.dex */
public class a implements b {
    private static volatile a Tj = null;
    private b Tk;

    public static a oD() {
        if (Tj == null) {
            synchronized (a.class) {
                if (Tj == null) {
                    Tj = new a();
                }
            }
        }
        return Tj;
    }

    public void b(b bVar) {
        this.Tk = bVar;
    }

    @Override // com.baidu.c.a.b.b
    public View O(Context context, String str) {
        if (this.Tk == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.Tk.O(context, str);
    }

    @Override // com.baidu.c.a.b.b
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar, boolean z) {
        if (this.Tk == null || view == null || aVar == null) {
            return false;
        }
        return this.Tk.a(str, view, aVar, z);
    }
}
