package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.d {
    private static a adA = null;

    private a() {
    }

    public static synchronized a ub() {
        a aVar;
        synchronized (a.class) {
            if (adA == null) {
                adA = new a();
            }
            aVar = adA;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.d
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(cO(str), j);
    }

    @Override // com.baidu.adp.lib.stats.d
    public long af(String str) {
        return TbadkSettings.getInst().loadLong(cO(str), 0L);
    }

    private String cO(String str) {
        return "new_log_upload_time_" + str;
    }
}
