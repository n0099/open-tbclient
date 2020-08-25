package com.baidu.live.tbadk.core.frameworkdata;

import android.content.pm.ComponentInfo;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.util.TiebaStaticClassesArray;
/* loaded from: classes7.dex */
public class Tasks {
    public static void initial() {
        try {
            if (!TiebaStaticClassesArray.loadStaticClasses()) {
                MultiDexHelper.loadStaticClass(BdBaseApplication.getInst());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void LoadClass(ComponentInfo[] componentInfoArr) {
        if (componentInfoArr != null) {
            for (ComponentInfo componentInfo : componentInfoArr) {
                try {
                    Class.forName(componentInfo.name);
                } catch (Exception e) {
                    BdLog.i(e.getMessage());
                }
            }
        }
    }
}
