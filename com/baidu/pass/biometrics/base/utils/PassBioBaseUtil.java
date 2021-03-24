package com.baidu.pass.biometrics.base.utils;

import android.content.Context;
import com.baidu.android.common.util.DeviceId;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.ServiceManager;
import java.util.List;
import java.util.Random;
/* loaded from: classes2.dex */
public class PassBioBaseUtil {
    public static String getClientId(Context context) {
        SapiConfiguration confignation = ServiceManager.getInstance().getIsAccountManager().getConfignation();
        if (confignation == null || !confignation.isAgreeDangerousProtocol()) {
            return null;
        }
        try {
            return DeviceId.getDeviceID(context);
        } catch (Throwable unused) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            return "123456789" + SecurityUtil.md5(String.valueOf(random.nextInt(100)).getBytes(), false);
        }
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            return "0";
        }
    }

    public static boolean listValueEqual(List<Integer> list, List<Integer> list2) {
        if (list == null || list2 == null || list.isEmpty() || list2.isEmpty() || list.size() != list2.size()) {
            return false;
        }
        for (Integer num : list) {
            if (!list2.contains(Integer.valueOf(num.intValue()))) {
                return false;
            }
        }
        return true;
    }
}
