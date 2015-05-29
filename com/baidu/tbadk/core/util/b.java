package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.stats.r {
    private static b TP = null;

    private b() {
    }

    public static synchronized b so() {
        b bVar;
        synchronized (b.class) {
            if (TP == null) {
                TP = new b();
            }
            bVar = TP;
        }
        return bVar;
    }

    @Override // com.baidu.adp.lib.stats.r
    public void az(String str) {
        TbadkSettings.getInst().saveString("log_stat_switch_data", str);
    }

    @Override // com.baidu.adp.lib.stats.r
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(cs(str), j);
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
    public String hW() {
        return TbadkSettings.getInst().loadString("log_stat_switch_data", null);
    }

    @Override // com.baidu.adp.lib.stats.r
    public long aA(String str) {
        return TbadkSettings.getInst().loadLong(cs(str), 0L);
    }

    @Override // com.baidu.adp.lib.stats.r
    public long hX() {
        return TbadkSettings.getInst().loadLong("log_stat_upload_time ", 0L);
    }

    @Override // com.baidu.adp.lib.stats.r
    public long hY() {
        return TbadkSettings.getInst().loadLong("log_stat_debug_time", 0L);
    }

    @Override // com.baidu.adp.lib.stats.r
    public long ia() {
        return TbadkSettings.getInst().loadLong("log_stat_error_time", 0L);
    }

    @Override // com.baidu.adp.lib.stats.r
    public long hZ() {
        return TbadkSettings.getInst().loadLong("log_stat_perfor_time", 0L);
    }

    private String cs(String str) {
        return "new_log_upload_time_" + str;
    }
}
