package com.baidu.searchbox.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.baidu.android.common.util.DeviceId;
import java.util.Locale;
/* loaded from: classes3.dex */
public class BaiduIdentityUtils {
    public static final int SYSTEM_APP = 1;
    public static final int SYSTEM_UPDATE_APP = 2;
    public static final int USER_APP = 0;

    public static int getAppType(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            if ((applicationInfo.flags & 128) == 128) {
                return 2;
            }
            if ((applicationInfo.flags & 1) != 1) {
                return 0;
            }
            return 1;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getSoftwareUUID(Context context) {
        String deviceID = DeviceId.getDeviceID(context);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("10");
        stringBuffer.append(deviceID.substring(0, deviceID.length() / 2));
        int parseInt = Integer.parseInt(Character.toString(deviceID.charAt(2)), 16);
        for (int i = 0; i < 4; i++) {
            stringBuffer.append(deviceID.charAt((((i * 8) + parseInt) + 1) % deviceID.length()));
        }
        stringBuffer.append(deviceID.substring(deviceID.length() / 2));
        return stringBuffer.toString().toUpperCase(Locale.getDefault());
    }
}
