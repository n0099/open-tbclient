package com.baidu.tbadk.core.frameworkData;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
public class d {
    public static void initial() {
        try {
            if (!ar.loadStaticClasses()) {
                b.aD(BdBaseApplication.getInst());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
