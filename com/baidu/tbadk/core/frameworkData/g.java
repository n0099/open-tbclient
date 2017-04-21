package com.baidu.tbadk.core.frameworkData;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import com.baidu.tbadk.core.util.az;
/* loaded from: classes.dex */
public class g {
    public static void initial() {
        try {
            if (az.loadStaticClasses()) {
                BdLog.i("loadStaticClasses success");
            } else {
                u.hM();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
