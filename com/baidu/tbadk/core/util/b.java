package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.stats.e {
    private static b ZW = null;

    private b() {
    }

    public static synchronized b uq() {
        b bVar;
        synchronized (b.class) {
            if (ZW == null) {
                ZW = new b();
            }
            bVar = ZW;
        }
        return bVar;
    }

    @Override // com.baidu.adp.lib.stats.e
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(cR(str), j);
    }

    @Override // com.baidu.adp.lib.stats.e
    public long aq(String str) {
        return TbadkSettings.getInst().loadLong(cR(str), 0L);
    }

    private String cR(String str) {
        return "new_log_upload_time_" + str;
    }
}
