package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a aAz = null;

    private a() {
    }

    public static synchronized a CO() {
        a aVar;
        synchronized (a.class) {
            if (aAz == null) {
                aAz = new a();
            }
            aVar = aAz;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void e(String str, long j) {
        TbadkSettings.getInst().saveLong(eV(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long aX(String str) {
        return TbadkSettings.getInst().loadLong(eV(str), 0L);
    }

    private String eV(String str) {
        return "new_log_upload_time_" + str;
    }
}
