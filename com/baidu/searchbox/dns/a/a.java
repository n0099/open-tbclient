package com.baidu.searchbox.dns.a;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class a {
    private static volatile a n;
    private b m = new c();

    private a(Context context) {
    }

    public static void b(Context context) {
        if (n == null) {
            synchronized (a.class) {
                if (n == null) {
                    n = new a(context.getApplicationContext());
                }
            }
        }
    }

    public static a e() {
        return n;
    }

    public void a(String str, com.baidu.searchbox.dns.d.a.a aVar) {
        if (aVar != null) {
            String aVar2 = aVar.toString();
            if (!TextUtils.isEmpty(aVar2)) {
                this.m.put(str, aVar2);
            }
        }
    }

    public com.baidu.searchbox.dns.d.a.a c(String str) {
        String str2 = this.m.get(str);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return new com.baidu.searchbox.dns.d.a.a(str2);
    }

    public void clear() {
        this.m.clear();
    }
}
