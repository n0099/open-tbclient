package com.baidu.tbadk.core.util;

import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes3.dex */
public class TiebaStaticClassesArray {
    public String[] staticClassesArray = new String[0];

    public boolean loadStaticClasses() {
        try {
            if (this.staticClassesArray.length <= 0) {
                return false;
            }
            for (String str : this.staticClassesArray) {
                try {
                    Class.forName(str);
                } catch (Throwable th) {
                    BdLog.e(th);
                    Log.e("TiebaStaticClassesArray", "classforName failed. " + th.getMessage());
                }
            }
            return true;
        } catch (Throwable th2) {
            BdLog.e(th2);
            Log.e("TiebaStaticClassesArray", "init class failed. " + th2.getMessage());
            return false;
        }
    }
}
