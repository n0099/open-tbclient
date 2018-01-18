package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a aTm = null;

    private a() {
    }

    public static synchronized a Bv() {
        a aVar;
        synchronized (a.class) {
            if (aTm == null) {
                aTm = new a();
            }
            aVar = aTm;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(dj(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long av(String str) {
        return TbadkSettings.getInst().loadLong(dj(str), 0L);
    }

    private String dj(String str) {
        return "new_log_upload_time_" + str;
    }
}
