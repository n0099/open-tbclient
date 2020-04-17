package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes13.dex */
public class a implements b {
    private static volatile a alv = null;
    private b alw;

    public static a sX() {
        if (alv == null) {
            synchronized (a.class) {
                if (alv == null) {
                    alv = new a();
                }
            }
        }
        return alv;
    }

    public void b(b bVar) {
        this.alw = bVar;
    }

    @Override // com.baidu.b.a.b.b
    public View M(Context context, String str) {
        if (this.alw == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.alw.M(context, str);
    }

    @Override // com.baidu.b.a.b.b
    public boolean a(String str, View view, com.baidu.b.a.a.a aVar, boolean z) {
        if (this.alw == null || view == null || aVar == null) {
            return false;
        }
        return this.alw.a(str, view, aVar, z);
    }
}
