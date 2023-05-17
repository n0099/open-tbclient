package com.baidu.live.arch.utils;

import android.text.TextUtils;
import com.baidu.common.param.CommonUrlParamManager;
/* loaded from: classes3.dex */
public class MiniCommonUrlParamUtils {
    public static boolean hasCheck;
    public static boolean isMappingAvailable;

    public static void checkMapping() {
        try {
            boolean z = false;
            if (Class.forName("com.baidu.common.param.CommonUrlParamManager").getMethod("appendParam", String.class, Integer.TYPE) != null) {
                z = true;
            }
            isMappingAvailable = z;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        }
        hasCheck = true;
    }

    public static boolean isMappingAvailable() {
        if (!hasCheck) {
            checkMapping();
        }
        return isMappingAvailable;
    }

    public static String appendParam(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!hasCheck) {
            checkMapping();
        }
        return invokeParamMethod(str);
    }

    public static String invokeParamMethod(String str) {
        if (isMappingAvailable) {
            return CommonUrlParamManager.getInstance().appendParam(str, 1);
        }
        return CommonUrlParamManager.getInstance().processUrl(str);
    }
}
