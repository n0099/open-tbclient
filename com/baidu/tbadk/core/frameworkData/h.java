package com.baidu.tbadk.core.frameworkData;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.bb;
/* loaded from: classes.dex */
public class h {
    public static void initial() {
        try {
            if (!bb.loadStaticClasses()) {
                c.ax(BdBaseApplication.getInst());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
