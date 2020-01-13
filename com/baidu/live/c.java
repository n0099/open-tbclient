package com.baidu.live;

import android.content.SharedPreferences;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
/* loaded from: classes2.dex */
public class c extends SharedPrefHelper {
    private static c TU;

    @Override // com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper
    public synchronized SharedPreferences getSharedPreferences() {
        return TbadkCoreApplication.getInst().getSharedPreferences(AlaSharedPrefConfig.ALA_SHARED_PRE_FILE_NAME, 0);
    }

    public static c oJ() {
        if (TU == null) {
            synchronized (c.class) {
                if (TU == null) {
                    TU = new c();
                }
            }
        }
        return TU;
    }
}
