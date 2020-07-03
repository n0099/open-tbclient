package com.baidu.live.utils;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class p {
    private static String bkB = "";

    public static String yU() {
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
        return "";
    }

    public static String Jq() {
        if (TextUtils.isEmpty(bkB)) {
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
            return "";
        }
        return bkB;
    }

    public static void fV(String str) {
        bkB = str;
    }

    public static String Jr() {
        return bkB;
    }
}
