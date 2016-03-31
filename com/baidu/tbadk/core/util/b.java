package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.stats.e {
    private static b ZZ = null;

    private b() {
    }

    public static synchronized b vn() {
        b bVar;
        synchronized (b.class) {
            if (ZZ == null) {
                ZZ = new b();
            }
            bVar = ZZ;
        }
        return bVar;
    }

    @Override // com.baidu.adp.lib.stats.e
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(cN(str), j);
    }

    @Override // com.baidu.adp.lib.stats.e
    public long au(String str) {
        return TbadkSettings.getInst().loadLong(cN(str), 0L);
    }

    private String cN(String str) {
        return "new_log_upload_time_" + str;
    }
}
