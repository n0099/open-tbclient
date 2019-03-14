package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a bIu = null;

    private a() {
    }

    public static synchronized a abY() {
        a aVar;
        synchronized (a.class) {
            if (bIu == null) {
                bIu = new a();
            }
            aVar = bIu;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void e(String str, long j) {
        TbadkSettings.getInst().saveLong(lJ(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long aY(String str) {
        return TbadkSettings.getInst().loadLong(lJ(str), 0L);
    }

    private String lJ(String str) {
        return "new_log_upload_time_" + str;
    }
}
