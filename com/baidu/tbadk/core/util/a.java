package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a aeo = null;

    private a() {
    }

    public static synchronized a tW() {
        a aVar;
        synchronized (a.class) {
            if (aeo == null) {
                aeo = new a();
            }
            aVar = aeo;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(cV(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long an(String str) {
        return TbadkSettings.getInst().loadLong(cV(str), 0L);
    }

    private String cV(String str) {
        return "new_log_upload_time_" + str;
    }
}
