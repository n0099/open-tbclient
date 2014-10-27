package com.baidu.tbadk.core.frameworkData;

import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.v;
/* loaded from: classes.dex */
public class e {
    public static void initial() {
        String packageName = BdBaseApplication.getInst().getApp().getPackageName();
        try {
            v.fA();
            PackageInfo packageInfo = BdBaseApplication.getInst().getApp().getPackageManager().getPackageInfo(packageName, 7);
            a(packageInfo.activities);
            a(packageInfo.services);
            a(packageInfo.receivers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void a(ComponentInfo[] componentInfoArr) {
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
