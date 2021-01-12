package com.baidu.live.utils;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes10.dex */
public class q {
    private static String bKl = "";

    public static String Ef() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            return "ala_subapp_shoubai_android_consume";
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            return "ala_subapp_haokan_android_consume";
        }
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            return "ala_subapp_quanmin_android_consume";
        }
        if (TbadkCoreApplication.getInst().isTieba()) {
            return "ala_tieba_android_consume";
        }
        if (TbadkCoreApplication.getInst().isYinbo()) {
            return "ala_subapp_yinbo_android_consume";
        }
        return "";
    }

    public static String TN() {
        if (TextUtils.isEmpty(bKl)) {
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                return "ala_subapp_shoubai_android_consume";
            }
            if (TbadkCoreApplication.getInst().isHaokan()) {
                return "ala_subapp_haokan_android_consume";
            }
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                return "ala_subapp_quanmin_android_consume";
            }
            if (TbadkCoreApplication.getInst().isTieba()) {
                return "ala_tieba_android_consume";
            }
            if (TbadkCoreApplication.getInst().isYinbo()) {
                return "ala_subapp_yinbo_android_consume";
            }
            return "";
        }
        return bKl;
    }

    public static void hJ(String str) {
        bKl = str;
    }

    public static String TO() {
        return bKl;
    }
}
