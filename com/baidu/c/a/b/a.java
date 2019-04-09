package com.baidu.c.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes3.dex */
public class a implements b {
    private static volatile a adb = null;
    private b adc;

    public static a sh() {
        if (adb == null) {
            synchronized (a.class) {
                if (adb == null) {
                    adb = new a();
                }
            }
        }
        return adb;
    }

    public void b(b bVar) {
        this.adc = bVar;
    }

    @Override // com.baidu.c.a.b.b
    public View Y(Context context, String str) {
        if (this.adc == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.adc.Y(context, str);
    }

    @Override // com.baidu.c.a.b.b
    public boolean a(String str, View view, com.baidu.c.a.a.a aVar, boolean z) {
        if (this.adc == null || view == null || aVar == null) {
            return false;
        }
        return this.adc.a(str, view, aVar, z);
    }
}
