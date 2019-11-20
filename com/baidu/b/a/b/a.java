package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements b {
    private static volatile a KR = null;
    private b KS;

    public static a mG() {
        if (KR == null) {
            synchronized (a.class) {
                if (KR == null) {
                    KR = new a();
                }
            }
        }
        return KR;
    }

    public void b(b bVar) {
        this.KS = bVar;
    }

    @Override // com.baidu.b.a.b.b
    public View I(Context context, String str) {
        if (this.KS == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.KS.I(context, str);
    }

    @Override // com.baidu.b.a.b.b
    public boolean a(String str, View view, com.baidu.b.a.a.a aVar, boolean z) {
        if (this.KS == null || view == null || aVar == null) {
            return false;
        }
        return this.KS.a(str, view, aVar, z);
    }
}
