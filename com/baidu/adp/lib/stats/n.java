package com.baidu.adp.lib.stats;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class n {
    private static n b;
    private com.baidu.adp.lib.cache.s<String> a = null;

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

    private com.baidu.adp.lib.cache.s<String> c() {
        if (this.a == null) {
            this.a = BdCacheService.c().a("adp.stat.uploadtime", BdCacheService.CacheStorage.SQLite_CACHE_PER_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 100);
        }
        return this.a;
    }

    public void a(String str) {
        if (!com.baidu.adp.lib.util.g.b(str)) {
            c().a("adp.stat.switch_data", str);
        }
    }

    public String b() {
        return c().a("adp.stat.switch_data");
    }

    public void a(long j, String str) {
        if (j > 0) {
            String str2 = "adp.stat.stat_upload_time ";
            if (!TextUtils.isEmpty(str)) {
                str2 = String.valueOf("adp.stat.stat_upload_time ") + str;
            }
            c().a(str2, String.valueOf(j));
        }
    }

    public long b(String str) {
        String str2 = "adp.stat.stat_upload_time ";
        if (!TextUtils.isEmpty(str)) {
            str2 = String.valueOf("adp.stat.stat_upload_time ") + str;
        }
        String a = c().a(str2);
        if (!TextUtils.isEmpty(a)) {
            try {
                return Long.parseLong(a);
            } catch (Exception e) {
                BdLog.i(e.getMessage());
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
            c().a(str2, String.valueOf(j));
        }
    }

    public long c(String str) {
        String str2 = "adp.stat.stat_debug_time";
        if (!TextUtils.isEmpty(str)) {
            str2 = String.valueOf("adp.stat.stat_debug_time") + str;
        }
        String a = c().a(str2);
        if (!TextUtils.isEmpty(a)) {
            try {
                return Long.parseLong(a);
            } catch (Exception e) {
                BdLog.i(e.getMessage());
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
            c().a(str2, String.valueOf(j));
        }
    }

    public long d(String str) {
        String str2 = "adp.stat.stat_error_time";
        if (!TextUtils.isEmpty(str)) {
            str2 = String.valueOf("adp.stat.stat_error_time") + str;
        }
        String a = c().a(str2);
        if (!TextUtils.isEmpty(a)) {
            try {
                return Long.parseLong(a);
            } catch (Exception e) {
                BdLog.i(e.getMessage());
            }
        }
        return 0L;
    }
}
