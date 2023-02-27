package com.baidu.searchbox.pms.utils;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class ABIUtils {
    public static final String ABI_32 = "1";
    public static final String ABI_32_64 = "3";
    public static final String ABI_64 = "2";

    public static boolean checkCpuAbiIs64() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return Process.is64Bit();
        }
        if (i < 21) {
            return false;
        }
        String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
        if (strArr.length <= 0) {
            return false;
        }
        return Build.CPU_ABI.equals(strArr[0]);
    }

    public static boolean checkABIIsValid(String str) {
        if (!checkCpuAbiIs64() || !"1".equals(str)) {
            if (!checkCpuAbiIs64() && "2".equals(str)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean checkLocalABIIsValid(String str, String str2) {
        if (!"".equals(str2) && !"3".equals(str2)) {
            if (!TextUtils.isEmpty(str) || "3".equals(str2)) {
                if (!"1".equals(str) || !"2".equals(str2)) {
                    if ("2".equals(str) && "1".equals(str2)) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
