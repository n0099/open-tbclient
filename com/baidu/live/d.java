package com.baidu.live;

import android.content.SharedPreferences;
import com.baidu.ala.AlaSharedPrefConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
/* loaded from: classes11.dex */
public class d extends SharedPrefHelper {
    private static volatile d aBe;

    @Override // com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper
    public synchronized SharedPreferences getSharedPreferences() {
        return TbadkCoreApplication.getInst().getSharedPreferences(AlaSharedPrefConfig.ALA_SHARED_PRE_FILE_NAME, 0);
    }

    public static d Ba() {
        if (aBe == null) {
            synchronized (d.class) {
                if (aBe == null) {
                    aBe = new d();
                }
            }
        }
        return aBe;
    }
}
