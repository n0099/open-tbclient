package com.baidu.searchbox.suspensionball;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import java.util.Arrays;
/* loaded from: classes9.dex */
public class SuspensionBallUtils {
    public static String getCurrentVersion() {
        try {
            return AppRuntime.getAppContext().getPackageManager().getPackageInfo(AppRuntime.getAppContext().getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int compareVersion(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (TextUtils.isEmpty(str2)) {
            return 1;
        }
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        int max = Math.max(split.length, split2.length);
        int[] iArr = new int[max];
        int[] iArr2 = new int[max];
        Arrays.fill(iArr, 0);
        Arrays.fill(iArr2, 0);
        for (int i = 0; i < split.length; i++) {
            try {
                iArr[i] = Integer.parseInt(split[i]);
            } catch (NumberFormatException e) {
                if (AppConfig.isDebug()) {
                    throw e;
                }
                return 0;
            }
        }
        for (int i2 = 0; i2 < split2.length; i2++) {
            iArr2[i2] = Integer.parseInt(split2[i2]);
        }
        for (int i3 = 0; i3 < max; i3++) {
            if (iArr[i3] > iArr2[i3]) {
                return 1;
            }
            if (iArr[i3] < iArr2[i3]) {
                return -1;
            }
        }
        return 0;
    }
}
