package com.baidu.searchbox.dns.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.dns.util.DnsUtil;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b {
    public HashMap<String, com.baidu.searchbox.dns.d.a> I;
    public final Object J;

    /* loaded from: classes2.dex */
    public static class a {
        public static b K = new b();
    }

    public static b o() {
        return a.K;
    }

    public com.baidu.searchbox.dns.d.a a(String str, boolean z, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.J) {
            if (this.I.get(str) == null) {
                if (DnsUtil.DEBUG) {
                    Log.d(DnsUtil.TAG, " creat dns transmit task isBatch: " + z + " host: " + str);
                }
                return new com.baidu.searchbox.dns.d.a(z, str, i2);
            }
            return null;
        }
    }

    public void j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.J) {
            this.I.remove(str);
        }
        if (DnsUtil.DEBUG) {
            Log.d(DnsUtil.TAG, " remove dns transmit task: " + str);
        }
    }

    public b() {
        this.J = new Object();
        this.I = new HashMap<>(10);
    }

    public void a(String str, com.baidu.searchbox.dns.d.a aVar) {
        if (TextUtils.isEmpty(str) || aVar == null) {
            return;
        }
        synchronized (this.J) {
            this.I.put(str, aVar);
        }
        if (DnsUtil.DEBUG) {
            Log.d(DnsUtil.TAG, " add dns transmit task: " + str);
        }
    }
}
