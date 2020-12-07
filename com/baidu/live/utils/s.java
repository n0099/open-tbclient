package com.baidu.live.utils;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class s {
    private static String bKk = "";

    public static String Iz() {
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            return "ala_audio_mobilebaidu_android_consume";
        }
        if (TbadkCoreApplication.getInst().isHaokan()) {
            return "ala_audio_haokan_android_consume";
        }
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            return "ala_audio_quanmin_android_consume";
        }
        if (TbadkCoreApplication.getInst().isTieba()) {
            return "ala_audio_tieba_android_consume";
        }
        if (TbadkCoreApplication.getInst().isYinbo()) {
            return "ala_audio_yinbo_android_consume";
        }
        return "";
    }

    public static String WB() {
        if (TextUtils.isEmpty(bKk)) {
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                return "ala_audio_mobilebaidu_android_consume";
            }
            if (TbadkCoreApplication.getInst().isHaokan()) {
                return "ala_audio_haokan_android_consume";
            }
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                return "ala_audio_quanmin_android_consume";
            }
            if (TbadkCoreApplication.getInst().isTieba()) {
                return "ala_audio_tieba_android_consume";
            }
            if (TbadkCoreApplication.getInst().isYinbo()) {
                return "ala_audio_yinbo_android_consume";
            }
            return "";
        }
        return bKk;
    }

    public static void je(String str) {
        bKk = str;
    }

    public static String WC() {
        return bKk;
    }
}
