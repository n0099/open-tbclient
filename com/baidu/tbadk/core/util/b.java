package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.stats.e {
    private static b aap = null;

    private b() {
    }

    public static synchronized b tM() {
        b bVar;
        synchronized (b.class) {
            if (aap == null) {
                aap = new b();
            }
            bVar = aap;
        }
        return bVar;
    }

    @Override // com.baidu.adp.lib.stats.e
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(cL(str), j);
    }

    @Override // com.baidu.adp.lib.stats.e
    public long at(String str) {
        return TbadkSettings.getInst().loadLong(cL(str), 0L);
    }

    private String cL(String str) {
        return "new_log_upload_time_" + str;
    }
}
