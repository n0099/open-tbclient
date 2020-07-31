package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes20.dex */
public class a implements b {
    private static volatile a aor = null;
    private b aos;

    public static a ty() {
        if (aor == null) {
            synchronized (a.class) {
                if (aor == null) {
                    aor = new a();
                }
            }
        }
        return aor;
    }

    public void b(b bVar) {
        this.aos = bVar;
    }

    @Override // com.baidu.c.a.b.b
    public View A(Context context, String str) {
        if (this.aos == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.aos.A(context, str);
    }

    @Override // com.baidu.c.a.b.b
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar, boolean z) {
        if (this.aos == null || view == null || aVar == null) {
            return false;
        }
        return this.aos.a(str, view, aVar, z);
    }
}
