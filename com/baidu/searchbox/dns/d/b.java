package com.baidu.searchbox.dns.d;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b {
    private HashMap<String, com.baidu.searchbox.dns.d.a> B;
    private final Object C;

    private b() {
        this.C = new Object();
        this.B = new HashMap<>(10);
    }

    /* loaded from: classes2.dex */
    private static class a {
        private static b D = new b();
    }

    public static b m() {
        return a.D;
    }

    public void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.C) {
                this.B.remove(str);
            }
        }
    }

    public com.baidu.searchbox.dns.d.a c(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.C) {
                if (this.B.get(str) == null) {
                    return new com.baidu.searchbox.dns.d.a(z, str);
                }
            }
        }
        return null;
    }

    public void a(String str, com.baidu.searchbox.dns.d.a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            synchronized (this.C) {
                this.B.put(str, aVar);
            }
        }
    }
}
