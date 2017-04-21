package com.baidu.tbadk.ala;

import android.content.SharedPreferences;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.sharedPref.b {
    private static a QR;

    @Override // com.baidu.tbadk.core.sharedPref.b
    public synchronized SharedPreferences getSharedPreferences() {
        return TbadkCoreApplication.m9getInst().getSharedPreferences("ala_setting", 0);
    }

    public static a nZ() {
        if (QR == null) {
            synchronized (a.class) {
                if (QR == null) {
                    QR = new a();
                }
            }
        }
        return QR;
    }
}
