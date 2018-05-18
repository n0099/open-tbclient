package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a agd = null;

    private a() {
    }

    public static synchronized a uy() {
        a aVar;
        synchronized (a.class) {
            if (agd == null) {
                agd = new a();
            }
            aVar = agd;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(dm(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long as(String str) {
        return TbadkSettings.getInst().loadLong(dm(str), 0L);
    }

    private String dm(String str) {
        return "new_log_upload_time_" + str;
    }
}
