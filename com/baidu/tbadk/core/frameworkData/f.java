package com.baidu.tbadk.core.frameworkData;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import com.baidu.tbadk.core.util.bf;
/* loaded from: classes.dex */
public class f {
    public static void initial() {
        try {
            if (bf.loadStaticClasses()) {
                BdLog.i("loadStaticClasses success");
            } else {
                u.fT();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
