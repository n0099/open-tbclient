package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a aUU = null;

    private a() {
    }

    public static synchronized a BP() {
        a aVar;
        synchronized (a.class) {
            if (aUU == null) {
                aUU = new a();
            }
            aVar = aUU;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(du(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long av(String str) {
        return TbadkSettings.getInst().loadLong(du(str), 0L);
    }

    private String du(String str) {
        return "new_log_upload_time_" + str;
    }
}
