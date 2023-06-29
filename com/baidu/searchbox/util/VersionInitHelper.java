package com.baidu.searchbox.util;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.vg;
/* loaded from: classes4.dex */
public class VersionInitHelper {
    public static boolean hasInitFinish() {
        if (!TextUtils.isEmpty(TbConfig.getVersion()) && TbConfig.getVersionType() != -1) {
            if (TbConfig.getVersionType() != 1 || !TextUtils.isEmpty(TbConfig.getSubVersion())) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static void init() {
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = TbadkCoreApplication.getInst().getContext().getPackageManager().getApplicationInfo(TbadkCoreApplication.getInst().getContext().getPackageName(), 128);
            TbConfig.setVersionType(vg.e(String.valueOf(applicationInfo.metaData.get("versionType")), 3));
        } catch (Exception e) {
            TbConfig.setVersionType(3);
            BdLog.e(e.getMessage());
        }
        try {
            if (TbConfig.getVersionType() == 2) {
                if (applicationInfo != null) {
                    TbConfig.setVersion(String.valueOf(applicationInfo.metaData.get("grayVersion")));
                    return;
                }
                return;
            }
            TbConfig.setVersion(TbadkCoreApplication.getInst().getContext().getPackageManager().getPackageInfo(TbadkCoreApplication.getInst().getContext().getPackageName(), 0).versionName);
            if (TbConfig.getVersionType() == 1 && applicationInfo != null) {
                TbConfig.setSubVersion(String.valueOf(applicationInfo.metaData.get("subVersion")));
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
