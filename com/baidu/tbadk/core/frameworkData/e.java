package com.baidu.tbadk.core.frameworkData;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.av;
/* loaded from: classes.dex */
public class e {
    public static void initial() {
        try {
            if (!av.loadStaticClasses()) {
                c.bx(BdBaseApplication.getInst());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
