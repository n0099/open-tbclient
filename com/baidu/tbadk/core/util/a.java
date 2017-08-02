package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.b {
    private static a aex = null;

    private a() {
    }

    public static synchronized a uu() {
        a aVar;
        synchronized (a.class) {
            if (aex == null) {
                aex = new a();
            }
            aVar = aex;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.b
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(dh(str), j);
    }

    @Override // com.baidu.adp.lib.stats.b
    public long am(String str) {
        return TbadkSettings.getInst().loadLong(dh(str), 0L);
    }

    private String dh(String str) {
        return "new_log_upload_time_" + str;
    }
}
