package com.baidu.tbadk.ala;

import android.content.SharedPreferences;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.sharedPref.b {
    private static a Lu;

    @Override // com.baidu.tbadk.core.sharedPref.b
    public synchronized SharedPreferences getSharedPreferences() {
        return TbadkCoreApplication.m9getInst().getSharedPreferences("ala_setting", 0);
    }

    public static a no() {
        if (Lu == null) {
            synchronized (a.class) {
                if (Lu == null) {
                    Lu = new a();
                }
            }
        }
        return Lu;
    }
}
