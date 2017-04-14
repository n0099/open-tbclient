package com.baidu.tbadk.ala;

import android.content.SharedPreferences;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.sharedPref.b {
    private static a QO;

    @Override // com.baidu.tbadk.core.sharedPref.b
    public synchronized SharedPreferences getSharedPreferences() {
        return TbadkCoreApplication.m9getInst().getSharedPreferences("ala_setting", 0);
    }

    public static a nZ() {
        if (QO == null) {
            synchronized (a.class) {
                if (QO == null) {
                    QO = new a();
                }
            }
        }
        return QO;
    }
}
