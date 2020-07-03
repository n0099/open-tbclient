package com.baidu.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* loaded from: classes13.dex */
public class a implements b {
    private static volatile a aov = null;
    private b aow;

    public static a ty() {
        if (aov == null) {
            synchronized (a.class) {
                if (aov == null) {
                    aov = new a();
                }
            }
        }
        return aov;
    }

    public void b(b bVar) {
        this.aow = bVar;
    }

    @Override // com.baidu.b.a.b.b
    public View A(Context context, String str) {
        if (this.aow == null || str == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.aow.A(context, str);
    }

    @Override // com.baidu.b.a.b.b
    public boolean a(String str, View view, com.baidu.b.a.a.a aVar, boolean z) {
        if (this.aow == null || view == null || aVar == null) {
            return false;
        }
        return this.aow.a(str, view, aVar, z);
    }
}
