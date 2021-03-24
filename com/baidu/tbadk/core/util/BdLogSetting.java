package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
import d.b.b.e.n.b;
/* loaded from: classes3.dex */
public class BdLogSetting implements b {
    public static BdLogSetting mInstance;

    private String generateKey(String str) {
        return "new_log_upload_time_" + str;
    }

    public static synchronized BdLogSetting getInstance() {
        BdLogSetting bdLogSetting;
        synchronized (BdLogSetting.class) {
            if (mInstance == null) {
                mInstance = new BdLogSetting();
            }
            bdLogSetting = mInstance;
        }
        return bdLogSetting;
    }

    public long getDebugUploadTime() {
        return TbadkSettings.getInst().loadLong("log_stat_debug_time", 0L);
    }

    public long getErrorUploadTime() {
        return TbadkSettings.getInst().loadLong("log_stat_error_time", 0L);
    }

    @Override // d.b.b.e.n.b
    public long getLogUploadTime(String str) {
        return TbadkSettings.getInst().loadLong(generateKey(str), 0L);
    }

    public long getPerformanceUploadTime() {
        return TbadkSettings.getInst().loadLong("log_stat_perfor_time", 0L);
    }

    public long getStatUploadTime() {
        return TbadkSettings.getInst().loadLong("log_stat_upload_time ", 0L);
    }

    public String getSwitchData() {
        return TbadkSettings.getInst().loadString("log_stat_switch_data", null);
    }

    public void setDebugUploadTime(long j) {
        TbadkSettings.getInst().saveLong("log_stat_debug_time", j);
    }

    public void setErrorUploadTime(long j) {
        TbadkSettings.getInst().saveLong("log_stat_error_time", j);
    }

    @Override // d.b.b.e.n.b
    public void setLogUploadTime(String str, long j) {
        TbadkSettings.getInst().saveLong(generateKey(str), j);
    }

    public void setPerformanceUploadTime(long j) {
        TbadkSettings.getInst().saveLong("log_stat_perfor_time", j);
    }

    public void setStatUploadTime(long j) {
        TbadkSettings.getInst().saveLong("log_stat_upload_time ", j);
    }

    public void setSwitchData(String str) {
        TbadkSettings.getInst().saveString("log_stat_switch_data", str);
    }
}
