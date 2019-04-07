package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements b {
    private static volatile a ada = null;
    private b adb;

    public static a sh() {
        if (ada == null) {
            synchronized (a.class) {
                if (ada == null) {
                    ada = new a();
                }
            }
        }
        return ada;
    }

    public void b(b bVar) {
        this.adb = bVar;
    }

    @Override // com.baidu.c.a.b.b
    public View Y(Context context, String str) {
        if (this.adb == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.adb.Y(context, str);
    }

    @Override // com.baidu.c.a.b.b
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar, boolean z) {
        if (this.adb == null || view == null || aVar == null) {
            return false;
        }
        return this.adb.a(str, view, aVar, z);
    }
}
