package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class b implements com.baidu.adp.lib.stats.e {
    private static b YR = null;

    private b() {
    }

    public static synchronized b tv() {
        b bVar;
        synchronized (b.class) {
            if (YR == null) {
                YR = new b();
            }
            bVar = YR;
        }
        return bVar;
    }

    @Override // com.baidu.adp.lib.stats.e
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(ct(str), j);
    }

    @Override // com.baidu.adp.lib.stats.e
    public long ar(String str) {
        return TbadkSettings.getInst().loadLong(ct(str), 0L);
    }

    private String ct(String str) {
        return "new_log_upload_time_" + str;
    }
}
