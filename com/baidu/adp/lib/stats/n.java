package com.baidu.adp.lib.stats;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.BdCacheService;
/* loaded from: classes.dex */
public class n {
    private static n b;
    private com.baidu.adp.lib.cache.s<byte[]> a = null;

    public static n a() {
        if (b == null) {
            synchronized (n.class) {
                if (b == null) {
                    b = new n();
                }
            }
        }
        return b;
    }

    private com.baidu.adp.lib.cache.s<byte[]> b() {
        if (this.a == null) {
            this.a = BdCacheService.c().b("adp.stat", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 100);
        }
        return this.a;
    }

    public void a(byte[] bArr, String str) {
        if (bArr != null && bArr.length > 0) {
            String str2 = "adp.stat.switch_data";
            if (!TextUtils.isEmpty(str)) {
                str2 = "adp.stat.switch_data" + str;
            }
            b().a(str2, bArr);
        }
    }

    public byte[] a(String str) {
        String str2 = "adp.stat.switch_data";
        if (!TextUtils.isEmpty(str)) {
            str2 = "adp.stat.switch_data" + str;
        }
        return b().a(str2);
    }
}
