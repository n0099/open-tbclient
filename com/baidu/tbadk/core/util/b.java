package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.stats.e {
    private static b YV = null;

    private b() {
    }

    public static synchronized b tx() {
        b bVar;
        synchronized (b.class) {
            if (YV == null) {
                YV = new b();
            }
            bVar = YV;
        }
        return bVar;
    }

    @Override // com.baidu.adp.lib.stats.e
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(cA(str), j);
    }

    @Override // com.baidu.adp.lib.stats.e
    public long ar(String str) {
        return TbadkSettings.getInst().loadLong(cA(str), 0L);
    }

    private String cA(String str) {
        return "new_log_upload_time_" + str;
    }
}
