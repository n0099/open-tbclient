package com.baidu.live;

import android.content.SharedPreferences;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
/* loaded from: classes4.dex */
public class d extends SharedPrefHelper {
    private static volatile d aAN;

    @Override // com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper
    public synchronized SharedPreferences getSharedPreferences() {
        return TbadkCoreApplication.getInst().getSharedPreferences(AlaSharedPrefConfig.ALA_SHARED_PRE_FILE_NAME, 0);
    }

    public static d BM() {
        if (aAN == null) {
            synchronized (d.class) {
                if (aAN == null) {
                    aAN = new d();
                }
            }
        }
        return aAN;
    }
}
