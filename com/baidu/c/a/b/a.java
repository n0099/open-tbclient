package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes11.dex */
public class a implements b {
    private static volatile a Rq = null;
    private b Rr;

    public static a nP() {
        if (Rq == null) {
            synchronized (a.class) {
                if (Rq == null) {
                    Rq = new a();
                }
            }
        }
        return Rq;
    }

    public void b(b bVar) {
        this.Rr = bVar;
    }

    @Override // com.baidu.c.a.b.b
    public View O(Context context, String str) {
        if (this.Rr == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.Rr.O(context, str);
    }

    @Override // com.baidu.c.a.b.b
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar, boolean z) {
        if (this.Rr == null || view == null || aVar == null) {
            return false;
        }
        return this.Rr.a(str, view, aVar, z);
    }
}
