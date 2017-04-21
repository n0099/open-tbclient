package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.d {
    private static a aei = null;

    private a() {
    }

    public static synchronized a uP() {
        a aVar;
        synchronized (a.class) {
            if (aei == null) {
                aei = new a();
            }
            aVar = aei;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.d
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(cQ(str), j);
    }

    @Override // com.baidu.adp.lib.stats.d
    public long af(String str) {
        return TbadkSettings.getInst().loadLong(cQ(str), 0L);
    }

    private String cQ(String str) {
        return "new_log_upload_time_" + str;
    }
}
