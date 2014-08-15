package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.stats.r {
    private static c a = null;

    private c() {
    }

    public static synchronized c e() {
        c cVar;
        synchronized (c.class) {
            if (a == null) {
                a = new c();
            }
            cVar = a;
        }
        return cVar;
    }

    @Override // com.baidu.adp.lib.stats.r
    public void a(String str) {
        com.baidu.tbadk.h.a().a("log_stat_switch_data", str);
    }

    @Override // com.baidu.adp.lib.stats.r
    public void a(long j) {
        com.baidu.tbadk.h.a().b("log_stat_upload_time ", j);
    }

    @Override // com.baidu.adp.lib.stats.r
    public void b(long j) {
        com.baidu.tbadk.h.a().b("log_stat_debug_time", j);
    }

    @Override // com.baidu.adp.lib.stats.r
    public void c(long j) {
        com.baidu.tbadk.h.a().b("log_stat_error_time", j);
    }

    @Override // com.baidu.adp.lib.stats.r
    public String a() {
        return com.baidu.tbadk.h.a().b("log_stat_switch_data", (String) null);
    }

    @Override // com.baidu.adp.lib.stats.r
    public long b() {
        return com.baidu.tbadk.h.a().a("log_stat_upload_time ", 0L);
    }

    @Override // com.baidu.adp.lib.stats.r
    public long c() {
        return com.baidu.tbadk.h.a().a("log_stat_debug_time", 0L);
    }

    @Override // com.baidu.adp.lib.stats.r
    public long d() {
        return com.baidu.tbadk.h.a().a("log_stat_error_time", 0L);
    }
}
