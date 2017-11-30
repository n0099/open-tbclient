package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a aff = null;

    private a() {
    }

    public static synchronized a ug() {
        a aVar;
        synchronized (a.class) {
            if (aff == null) {
                aff = new a();
            }
            aVar = aff;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(dc(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long an(String str) {
        return TbadkSettings.getInst().loadLong(dc(str), 0L);
    }

    private String dc(String str) {
        return "new_log_upload_time_" + str;
    }
}
