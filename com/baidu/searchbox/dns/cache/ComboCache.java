package com.baidu.searchbox.dns.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.dns.cache.disk.DiskLruCacheHelper;
import com.baidu.searchbox.dns.util.DnsUtil;
/* loaded from: classes2.dex */
public class ComboCache implements ICache {
    public DiskLruCacheHelper diskLruCacheHelper;
    public MemCache memCache = new MemCache();

    @Override // com.baidu.searchbox.dns.cache.ICache
    public boolean isEmpty() {
        return false;
    }

    public ComboCache(Context context, String str) {
        this.diskLruCacheHelper = new DiskLruCacheHelper(context, str);
    }

    @Override // com.baidu.searchbox.dns.cache.ICache
    public void put(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.memCache.put(str, str2);
            this.diskLruCacheHelper.put(str, str2);
        }
    }

    @Override // com.baidu.searchbox.dns.cache.ICache
    public void clear() {
        this.diskLruCacheHelper.clear();
        this.memCache.clear();
    }

    @Override // com.baidu.searchbox.dns.cache.ICache
    public String get(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.memCache.get(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = this.diskLruCacheHelper.get(str);
                if (DnsUtil.DEBUG) {
                    Log.d(DnsUtil.TAG, " get cache form disk: " + str2);
                }
            } else if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " get cache from memory : " + str2);
            }
            if (str2 != null) {
                this.memCache.put(str, str2);
                return str2;
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.searchbox.dns.cache.ICache
    public boolean remove(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean remove = this.memCache.remove(str);
        if (!this.diskLruCacheHelper.remove(str) && !remove) {
            return false;
        }
        return true;
    }
}
