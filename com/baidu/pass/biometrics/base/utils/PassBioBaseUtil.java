package com.baidu.pass.biometrics.base.utils;

import android.content.Context;
import com.baidu.android.common.util.DeviceId;
import com.baidu.pass.common.SecurityUtil;
import java.util.List;
import java.util.Random;
/* loaded from: classes20.dex */
public class PassBioBaseUtil {
    public static String getClientId(Context context) {
        try {
            return DeviceId.getDeviceID(context);
        } catch (Throwable th) {
            Random random = new Random();
            random.setSeed(System.currentTimeMillis());
            return "123456789" + SecurityUtil.md5(String.valueOf(random.nextInt(100)).getBytes(), false);
        }
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            return "0";
        }
    }

    public static boolean listValueEqual(List<Integer> list, List<Integer> list2) {
        if (list == null || list2 == null || list.isEmpty() || list2.isEmpty()) {
            return false;
        }
        if (list.size() != list2.size()) {
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
