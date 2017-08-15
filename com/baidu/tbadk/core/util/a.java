package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a afU = null;

    private a() {
    }

    public static synchronized a uE() {
        a aVar;
        synchronized (a.class) {
            if (afU == null) {
                afU = new a();
            }
            aVar = afU;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void e(String str, long j) {
        TbadkSettings.getInst().saveLong(dn(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long as(String str) {
        return TbadkSettings.getInst().loadLong(dn(str), 0L);
    }

    private String dn(String str) {
        return "new_log_upload_time_" + str;
    }
}
