package com.baidu.live.utils;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class q {
    private static String aDS = "";

    public static String sI() {
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

    public static String Bg() {
        if (TextUtils.isEmpty(aDS)) {
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
        return aDS;
    }

    public static void ei(String str) {
        aDS = str;
    }

    public static String Bh() {
        return aDS;
    }
}
