package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.stats.r {
    private static c GX = null;

    private c() {
    }

    public static synchronized c ok() {
        c cVar;
        synchronized (c.class) {
            if (GX == null) {
                GX = new c();
            }
            cVar = GX;
        }
        return cVar;
    }

    @Override // com.baidu.adp.lib.stats.r
    public void aq(String str) {
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
    public String eN() {
        return TbadkSettings.getInst().loadString("log_stat_switch_data", null);
    }

    @Override // com.baidu.adp.lib.stats.r
    public long eO() {
        return TbadkSettings.getInst().loadLong("log_stat_upload_time ", 0L);
    }

    @Override // com.baidu.adp.lib.stats.r
    public long eP() {
        return TbadkSettings.getInst().loadLong("log_stat_debug_time", 0L);
    }

    @Override // com.baidu.adp.lib.stats.r
    public long eR() {
        return TbadkSettings.getInst().loadLong("log_stat_error_time", 0L);
    }

    @Override // com.baidu.adp.lib.stats.r
    public long eQ() {
        return TbadkSettings.getInst().loadLong("log_stat_perfor_time", 0L);
    }
}
