package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.stats.e {
    private static b ZL = null;

    private b() {
    }

    public static synchronized b uc() {
        b bVar;
        synchronized (b.class) {
            if (ZL == null) {
                ZL = new b();
            }
            bVar = ZL;
        }
        return bVar;
    }

    @Override // com.baidu.adp.lib.stats.e
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(cI(str), j);
    }

    @Override // com.baidu.adp.lib.stats.e
    public long at(String str) {
        return TbadkSettings.getInst().loadLong(cI(str), 0L);
    }

    private String cI(String str) {
        return "new_log_upload_time_" + str;
    }
}
