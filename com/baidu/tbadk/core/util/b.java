package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.stats.e {
    private static b Vy = null;

    private b() {
    }

    public static synchronized b sV() {
        b bVar;
        synchronized (b.class) {
            if (Vy == null) {
                Vy = new b();
            }
            bVar = Vy;
        }
        return bVar;
    }

    @Override // com.baidu.adp.lib.stats.e
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(cL(str), j);
    }

    @Override // com.baidu.adp.lib.stats.e
    public long an(String str) {
        return TbadkSettings.getInst().loadLong(cL(str), 0L);
    }

    private String cL(String str) {
        return "new_log_upload_time_" + str;
    }
}
