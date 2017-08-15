package com.baidu.tbadk.core.frameworkData;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes.dex */
public class d {
    public static void initial() {
        try {
            if (!aq.loadStaticClasses()) {
                b.ay(BdBaseApplication.getInst());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
