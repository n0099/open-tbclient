package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a afd = null;

    private a() {
    }

    public static synchronized a uA() {
        a aVar;
        synchronized (a.class) {
            if (afd == null) {
                afd = new a();
            }
            aVar = afd;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(dg(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long an(String str) {
        return TbadkSettings.getInst().loadLong(dg(str), 0L);
    }

    private String dg(String str) {
        return "new_log_upload_time_" + str;
    }
}
