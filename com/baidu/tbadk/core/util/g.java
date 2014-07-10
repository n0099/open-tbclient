package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class g implements com.baidu.adp.lib.stats.p {
    private static g a = null;

    private g() {
    }

    public static synchronized g e() {
        g gVar;
        synchronized (g.class) {
            if (a == null) {
                a = new g();
            }
            gVar = a;
        }
        return gVar;
    }

    @Override // com.baidu.adp.lib.stats.p
    public void a(String str) {
        com.baidu.tbadk.i.a().a("log_stat_switch_data", str);
    }

    @Override // com.baidu.adp.lib.stats.p
    public void a(long j) {
        com.baidu.tbadk.i.a().b("log_stat_upload_time ", j);
    }

    @Override // com.baidu.adp.lib.stats.p
    public void b(long j) {
        com.baidu.tbadk.i.a().b("log_stat_debug_time", j);
    }

    @Override // com.baidu.adp.lib.stats.p
    public void c(long j) {
        com.baidu.tbadk.i.a().b("log_stat_error_time", j);
    }

    @Override // com.baidu.adp.lib.stats.p
    public String a() {
        return com.baidu.tbadk.i.a().b("log_stat_switch_data", (String) null);
    }

    @Override // com.baidu.adp.lib.stats.p
    public long b() {
        return com.baidu.tbadk.i.a().a("log_stat_upload_time ", 0L);
    }

    @Override // com.baidu.adp.lib.stats.p
    public long c() {
        return com.baidu.tbadk.i.a().a("log_stat_debug_time", 0L);
    }

    @Override // com.baidu.adp.lib.stats.p
    public long d() {
        return com.baidu.tbadk.i.a().a("log_stat_error_time", 0L);
    }
}
