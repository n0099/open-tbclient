package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.stats.r {
    private static b Tg = null;

    private b() {
    }

    public static synchronized b rF() {
        b bVar;
        synchronized (b.class) {
            if (Tg == null) {
                Tg = new b();
            }
            bVar = Tg;
        }
        return bVar;
    }

    @Override // com.baidu.adp.lib.stats.r
    public void ax(String str) {
        TbadkSettings.getInst().saveString("log_stat_switch_data", str);
    }

    @Override // com.baidu.adp.lib.stats.r
    public void h(long j) {
        TbadkSettings.getInst().saveLong("log_stat_upload_time ", j);
    }

    @Override // com.baidu.adp.lib.stats.r
    public void i(long j) {
        TbadkSettings.getInst().saveLong("log_stat_debug_time", j);
    }

    @Override // com.baidu.adp.lib.stats.r
    public void k(long j) {
        TbadkSettings.getInst().saveLong("log_stat_error_time", j);
    }

    @Override // com.baidu.adp.lib.stats.r
    public void j(long j) {
        TbadkSettings.getInst().saveLong("log_stat_perfor_time", j);
    }

    @Override // com.baidu.adp.lib.stats.r
    public String in() {
        return TbadkSettings.getInst().loadString("log_stat_switch_data", null);
    }

    @Override // com.baidu.adp.lib.stats.r
    public long io() {
        return TbadkSettings.getInst().loadLong("log_stat_upload_time ", 0L);
    }

    @Override // com.baidu.adp.lib.stats.r
    public long ip() {
        return TbadkSettings.getInst().loadLong("log_stat_debug_time", 0L);
    }

    @Override // com.baidu.adp.lib.stats.r
    public long ir() {
        return TbadkSettings.getInst().loadLong("log_stat_error_time", 0L);
    }

    @Override // com.baidu.adp.lib.stats.r
    public long iq() {
        return TbadkSettings.getInst().loadLong("log_stat_perfor_time", 0L);
    }
}
