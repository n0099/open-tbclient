package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.stats.e {
    private static b Zy = null;

    private b() {
    }

    public static synchronized b um() {
        b bVar;
        synchronized (b.class) {
            if (Zy == null) {
                Zy = new b();
            }
            bVar = Zy;
        }
        return bVar;
    }

    @Override // com.baidu.adp.lib.stats.e
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(cP(str), j);
    }

    @Override // com.baidu.adp.lib.stats.e
    public long aq(String str) {
        return TbadkSettings.getInst().loadLong(cP(str), 0L);
    }

    private String cP(String str) {
        return "new_log_upload_time_" + str;
    }
}
