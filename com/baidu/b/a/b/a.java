package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes13.dex */
public class a implements b {
    private static volatile a alB = null;
    private b alC;

    public static a sW() {
        if (alB == null) {
            synchronized (a.class) {
                if (alB == null) {
                    alB = new a();
                }
            }
        }
        return alB;
    }

    public void b(b bVar) {
        this.alC = bVar;
    }

    @Override // com.baidu.b.a.b.b
    public View A(Context context, String str) {
        if (this.alC == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.alC.A(context, str);
    }

    @Override // com.baidu.b.a.b.b
    public boolean a(String str, View view, com.baidu.b.a.a.a aVar, boolean z) {
        if (this.alC == null || view == null || aVar == null) {
            return false;
        }
        return this.alC.a(str, view, aVar, z);
    }
}
