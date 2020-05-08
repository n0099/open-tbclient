package com.baidu.live;

import android.content.SharedPreferences;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
/* loaded from: classes3.dex */
public class c extends SharedPrefHelper {
    private static volatile c anB;

    @Override // com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper
    public synchronized SharedPreferences getSharedPreferences() {
        return TbadkCoreApplication.getInst().getSharedPreferences(AlaSharedPrefConfig.ALA_SHARED_PRE_FILE_NAME, 0);
    }

    public static c tG() {
        if (anB == null) {
            synchronized (c.class) {
                if (anB == null) {
                    anB = new c();
                }
            }
        }
        return anB;
    }
}
