package com.baidu.live.utils;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public class o {
    private static String arw = "";

    public static String wt() {
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

    public static String wu() {
        if (!TextUtils.isEmpty(arw)) {
            return arw;
        }
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

    public static void cY(String str) {
        arw = str;
    }

    public static String wv() {
        return arw;
    }
}
