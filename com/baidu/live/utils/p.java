package com.baidu.live.utils;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class p {
    private static String bGM = "";

    public static String Hr() {
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

    public static String UK() {
        if (TextUtils.isEmpty(bGM)) {
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
        return bGM;
    }

    public static void iG(String str) {
        bGM = str;
    }

    public static String UL() {
        return bGM;
    }
}
