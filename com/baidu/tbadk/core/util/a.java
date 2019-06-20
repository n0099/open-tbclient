package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a bQi = null;

    private a() {
    }

    public static synchronized a agS() {
        a aVar;
        synchronized (a.class) {
            if (bQi == null) {
                bQi = new a();
            }
            aVar = bQi;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(mR(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long aI(String str) {
        return TbadkSettings.getInst().loadLong(mR(str), 0L);
    }

    private String mR(String str) {
        return "new_log_upload_time_" + str;
    }
}
