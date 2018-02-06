package com.baidu.tbadk.core.frameworkData;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.at;
/* loaded from: classes.dex */
public class e {
    public static void initial() {
        try {
            if (!at.loadStaticClasses()) {
                c.aN(BdBaseApplication.getInst());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
