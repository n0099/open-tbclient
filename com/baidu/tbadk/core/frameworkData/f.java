package com.baidu.tbadk.core.frameworkData;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import com.baidu.tbadk.core.util.bd;
/* loaded from: classes.dex */
public class f {
    public static void initial() {
        try {
            if (bd.loadStaticClasses()) {
                BdLog.i("loadStaticClasses success");
            } else {
                u.jF();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
