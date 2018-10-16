package com.baidu.searchbox.dns.a;

import java.util.HashMap;
/* loaded from: classes2.dex */
public class c implements b {
    private HashMap<String, String> o = new HashMap<>();
    private final Object p = new Object();

    @Override // com.baidu.searchbox.dns.a.b
    public void put(String str, String str2) {
        synchronized (this.p) {
            this.o.put(str, str2);
        }
    }

    @Override // com.baidu.searchbox.dns.a.b
    public String get(String str) {
        String str2;
        synchronized (this.p) {
            str2 = this.o.get(str);
        }
        return str2;
    }

    @Override // com.baidu.searchbox.dns.a.b
    public void clear() {
        synchronized (this.p) {
            this.o.clear();
        }
    }
}
