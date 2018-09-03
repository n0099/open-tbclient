package com.baidu.tbadk.core.frameworkData;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
public class e {
    public static void initial() {
        try {
            if (!aw.loadStaticClasses()) {
                c.aH(BdBaseApplication.getInst());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
