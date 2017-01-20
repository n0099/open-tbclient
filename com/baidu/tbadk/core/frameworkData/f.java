package com.baidu.tbadk.core.frameworkData;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
public class f {
    public static void initial() {
        try {
            if (ay.loadStaticClasses()) {
                BdLog.i("loadStaticClasses success");
            } else {
                u.gM();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
