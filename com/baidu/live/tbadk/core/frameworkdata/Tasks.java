package com.baidu.live.tbadk.core.frameworkdata;

import android.content.pm.ComponentInfo;
import android.util.Log;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.util.TiebaStaticClassesArray;
/* loaded from: classes2.dex */
public class Tasks {
    public static void initial() {
        try {
            if (!TiebaStaticClassesArray.loadStaticClasses()) {
                MultiDexHelper.loadStaticClass(BdBaseApplication.getInst());
                Log.e("Tasks", "============================ Static Class init Failed ================================ ");
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
