package com.baidu.live;

import android.content.SharedPreferences;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
/* loaded from: classes3.dex */
public class c extends SharedPrefHelper {
    private static volatile c asv;

    @Override // com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper
    public synchronized SharedPreferences getSharedPreferences() {
        return TbadkCoreApplication.getInst().getSharedPreferences(AlaSharedPrefConfig.ALA_SHARED_PRE_FILE_NAME, 0);
    }

    public static c uN() {
        if (asv == null) {
            synchronized (c.class) {
                if (asv == null) {
                    asv = new c();
                }
            }
        }
        return asv;
    }
}
