package com.baidu.tbadk.core.frameworkData;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.az;
/* loaded from: classes.dex */
public class h {
    public static void initial() {
        try {
            if (!az.loadStaticClasses()) {
                c.ax(BdBaseApplication.getInst());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
