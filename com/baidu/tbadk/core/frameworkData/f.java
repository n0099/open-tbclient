package com.baidu.tbadk.core.frameworkData;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
public class f {
    public static void initial() {
        try {
            if (bc.kC()) {
                BdLog.i("loadStaticClasses success");
            } else {
                u.jp();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
