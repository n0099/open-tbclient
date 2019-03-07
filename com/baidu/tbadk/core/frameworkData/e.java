package com.baidu.tbadk.core.frameworkData;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.ax;
/* loaded from: classes.dex */
public class e {
    public static void initial() {
        try {
            if (!ax.loadStaticClasses()) {
                c.cL(BdBaseApplication.getInst());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
