package com.baidu.tbadk.core.frameworkData;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import com.baidu.tbadk.core.util.bb;
/* loaded from: classes.dex */
public class f {
    public static void initial() {
        try {
            if (bb.kO()) {
                BdLog.i("loadStaticClasses success");
            } else {
                u.jz();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
