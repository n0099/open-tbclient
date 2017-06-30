package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.d {
    private static a aeb = null;

    private a() {
    }

    public static synchronized a uo() {
        a aVar;
        synchronized (a.class) {
            if (aeb == null) {
                aeb = new a();
            }
            aVar = aeb;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.d
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(de(str), j);
    }

    @Override // com.baidu.adp.lib.stats.d
    public long ak(String str) {
        return TbadkSettings.getInst().loadLong(de(str), 0L);
    }

    private String de(String str) {
        return "new_log_upload_time_" + str;
    }
}
