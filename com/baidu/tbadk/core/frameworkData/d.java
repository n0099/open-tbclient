package com.baidu.tbadk.core.frameworkData;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.as;
/* loaded from: classes.dex */
public class d {
    public static void initial() {
        try {
            if (!as.loadStaticClasses()) {
                b.aF(BdBaseApplication.getInst());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
