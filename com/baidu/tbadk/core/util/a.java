package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a aqS = null;

    private a() {
    }

    public static synchronized a zi() {
        a aVar;
        synchronized (a.class) {
            if (aqS == null) {
                aqS = new a();
            }
            aVar = aqS;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void e(String str, long j) {
        TbadkSettings.getInst().saveLong(ee(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long aY(String str) {
        return TbadkSettings.getInst().loadLong(ee(str), 0L);
    }

    private String ee(String str) {
        return "new_log_upload_time_" + str;
    }
}
