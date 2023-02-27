package com.baidu.searchbox.dns.cache;

import java.util.HashMap;
/* loaded from: classes2.dex */
public class MemCache implements ICache {
    public HashMap<String, String> cache = new HashMap<>();
    public final Object cacheLock = new Object();

    @Override // com.baidu.searchbox.dns.cache.ICache
    public void clear() {
        synchronized (this.cacheLock) {
            this.cache.clear();
        }
    }

    @Override // com.baidu.searchbox.dns.cache.ICache
    public boolean isEmpty() {
        HashMap<String, String> hashMap = this.cache;
        if (hashMap == null || hashMap.size() < 1) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.dns.cache.ICache
    public String get(String str) {
        String str2;
        synchronized (this.cacheLock) {
            str2 = this.cache.get(str);
        }
        return str2;
    }

    @Override // com.baidu.searchbox.dns.cache.ICache
    public boolean remove(String str) {
        boolean z;
        synchronized (this.cacheLock) {
            if (this.cache.remove(str) != null) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    @Override // com.baidu.searchbox.dns.cache.ICache
    public void put(String str, String str2) {
        synchronized (this.cacheLock) {
            this.cache.put(str, str2);
        }
    }
}
