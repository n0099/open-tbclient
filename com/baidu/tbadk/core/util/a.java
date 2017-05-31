package com.baidu.tbadk.core.util;

import com.baidu.tbadk.TbadkSettings;
/* loaded from: classes.dex */
public class a implements com.baidu.adp.lib.stats.d {
    private static a ads = null;

    private a() {
    }

    public static synchronized a tX() {
        a aVar;
        synchronized (a.class) {
            if (ads == null) {
                ads = new a();
            }
            aVar = ads;
        }
        return aVar;
    }

    @Override // com.baidu.adp.lib.stats.d
    public void d(String str, long j) {
        TbadkSettings.getInst().saveLong(cL(str), j);
    }

    @Override // com.baidu.adp.lib.stats.d
    public long af(String str) {
        return TbadkSettings.getInst().loadLong(cL(str), 0L);
    }

    private String cL(String str) {
        return "new_log_upload_time_" + str;
    }
}
