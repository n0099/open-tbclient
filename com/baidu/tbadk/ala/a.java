package com.baidu.tbadk.ala;

import android.content.SharedPreferences;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.sharedPref.b {
    private static a Qi;

    @Override // com.baidu.tbadk.core.sharedPref.b
    public synchronized SharedPreferences getSharedPreferences() {
        return TbadkCoreApplication.m9getInst().getSharedPreferences("ala_setting", 0);
    }

    public static a nG() {
        if (Qi == null) {
            synchronized (a.class) {
                if (Qi == null) {
                    Qi = new a();
                }
            }
        }
        return Qi;
    }
}
