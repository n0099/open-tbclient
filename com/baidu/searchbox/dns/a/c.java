package com.baidu.searchbox.dns.a;

import java.util.HashMap;
/* loaded from: classes18.dex */
public class c implements b {
    private HashMap<String, String> q = new HashMap<>();
    private final Object r = new Object();

    @Override // com.baidu.searchbox.dns.a.b
    public void put(String str, String str2) {
        synchronized (this.r) {
            this.q.put(str, str2);
        }
    }

    @Override // com.baidu.searchbox.dns.a.b
    public String get(String str) {
        String str2;
        synchronized (this.r) {
            str2 = this.q.get(str);
        }
        return str2;
    }

    @Override // com.baidu.searchbox.dns.a.b
    public void clear() {
        synchronized (this.r) {
            this.q.clear();
        }
    }

    @Override // com.baidu.searchbox.dns.a.b
    public boolean isEmpty() {
        return this.q == null || this.q.size() < 1;
    }
}
