package com.baidu.tbadk.core.frameworkData;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.ay;
/* loaded from: classes.dex */
public class e {
    public static void initial() {
        try {
            if (!ay.loadStaticClasses()) {
                c.cr(BdBaseApplication.getInst());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
