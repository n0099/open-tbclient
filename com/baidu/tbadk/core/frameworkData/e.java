package com.baidu.tbadk.core.frameworkData;

import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.n;
/* loaded from: classes.dex */
public class e {
    public static void a() {
        String packageName = com.baidu.adp.base.a.getInst().getApp().getPackageName();
        try {
            n.a();
            PackageInfo packageInfo = com.baidu.adp.base.a.getInst().getApp().getPackageManager().getPackageInfo(packageName, 7);
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
