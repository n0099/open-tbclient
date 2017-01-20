package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.e {
    private static a YE = null;

    private a() {
    }

    public static synchronized a tU() {
        a aVar;
        synchronized (a.class) {
            if (YE == null) {
                YE = new a();
            }
            aVar = YE;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.e
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(cQ(str), j);
    }

    @Override // com.baidu.adp.lib.stats.e
    public long ap(String str) {
        return TbadkSettings.getInst().loadLong(cQ(str), 0L);
    }

    private String cQ(String str) {
        return "new_log_upload_time_" + str;
    }
}
