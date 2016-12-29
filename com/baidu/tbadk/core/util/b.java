package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.stats.e {
    private static b Zq = null;

    private b() {
    }

    public static synchronized b ua() {
        b bVar;
        synchronized (b.class) {
            if (Zq == null) {
                Zq = new b();
            }
            bVar = Zq;
        }
        return bVar;
    }

    @Override // com.baidu.adp.lib.stats.e
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(cS(str), j);
    }

    @Override // com.baidu.adp.lib.stats.e
    public long aq(String str) {
        return TbadkSettings.getInst().loadLong(cS(str), 0L);
    }

    private String cS(String str) {
        return "new_log_upload_time_" + str;
    }
}
