package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.stats.e {
    private static b Za = null;

    private b() {
    }

    public static synchronized b tA() {
        b bVar;
        synchronized (b.class) {
            if (Za == null) {
                Za = new b();
            }
            bVar = Za;
        }
        return bVar;
    }

    @Override // com.baidu.adp.lib.stats.e
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(cz(str), j);
    }

    @Override // com.baidu.adp.lib.stats.e
    public long ar(String str) {
        return TbadkSettings.getInst().loadLong(cz(str), 0L);
    }

    private String cz(String str) {
        return "new_log_upload_time_" + str;
    }
}
