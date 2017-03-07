package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.d {
    private static a adT = null;

    private a() {
    }

    public static synchronized a us() {
        a aVar;
        synchronized (a.class) {
            if (adT == null) {
                adT = new a();
            }
            aVar = adT;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.d
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(cJ(str), j);
    }

    @Override // com.baidu.adp.lib.stats.d
    public long aj(String str) {
        return TbadkSettings.getInst().loadLong(cJ(str), 0L);
    }

    private String cJ(String str) {
        return "new_log_upload_time_" + str;
    }
}
