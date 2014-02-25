package com.baidu.adp.lib.stats;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.s;
/* loaded from: classes.dex */
public class k {
    private static k b;
    private s<String> a = null;

    public static k a() {
        if (b == null) {
            synchronized (k.class) {
                if (b == null) {
                    b = new k();
                }
            }
        }
        return b;
    }

    private s<String> b() {
        if (this.a == null) {
            this.a = BdCacheService.c().a("adp.stat.uploadtime", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 100);
        }
        return this.a;
    }

    public void a(long j, String str) {
        if (j > 0) {
            String str2 = "adp.stat.stat_upload_time ";
            if (!TextUtils.isEmpty(str)) {
                str2 = String.valueOf("adp.stat.stat_upload_time ") + str;
            }
            b().a(str2, String.valueOf(j));
        }
    }

    public long a(String str) {
        String str2 = "adp.stat.stat_upload_time ";
        if (!TextUtils.isEmpty(str)) {
            str2 = String.valueOf("adp.stat.stat_upload_time ") + str;
        }
        String a = b().a(str2);
        if (!TextUtils.isEmpty(a)) {
            try {
                return Long.parseLong(a);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.d(e.getMessage());
            }
        }
        return 0L;
    }

    public void b(long j, String str) {
        if (j > 0) {
            String str2 = "adp.stat.stat_debug_time";
            if (!TextUtils.isEmpty(str)) {
                str2 = String.valueOf("adp.stat.stat_debug_time") + str;
            }
            b().a(str2, String.valueOf(j));
        }
    }

    public long b(String str) {
        String str2 = "adp.stat.stat_debug_time";
        if (!TextUtils.isEmpty(str)) {
            str2 = String.valueOf("adp.stat.stat_debug_time") + str;
        }
        String a = b().a(str2);
        if (!TextUtils.isEmpty(a)) {
            try {
                return Long.parseLong(a);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.d(e.getMessage());
            }
        }
        return 0L;
    }

    public void c(long j, String str) {
        if (j > 0) {
            String str2 = "adp.stat.stat_error_time";
            if (!TextUtils.isEmpty(str)) {
                str2 = String.valueOf("adp.stat.stat_error_time") + str;
            }
            b().a(str2, String.valueOf(j));
        }
    }

    public long c(String str) {
        String str2 = "adp.stat.stat_error_time";
        if (!TextUtils.isEmpty(str)) {
            str2 = String.valueOf("adp.stat.stat_error_time") + str;
        }
        String a = b().a(str2);
        if (!TextUtils.isEmpty(a)) {
            try {
                return Long.parseLong(a);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.d(e.getMessage());
            }
        }
        return 0L;
    }
}
