package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a aoJ = null;

    private a() {
    }

    public static synchronized a yk() {
        a aVar;
        synchronized (a.class) {
            if (aoJ == null) {
                aoJ = new a();
            }
            aVar = aoJ;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(dP(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long aG(String str) {
        return TbadkSettings.getInst().loadLong(dP(str), 0L);
    }

    private String dP(String str) {
        return "new_log_upload_time_" + str;
    }
}
