package com.baidu.live.utils;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class s {
    private static String bGM = "";

    public static String Hr() {
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

    public static String UK() {
        if (TextUtils.isEmpty(bGM)) {
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
        return bGM;
    }

    public static void iG(String str) {
        bGM = str;
    }

    public static String UL() {
        return bGM;
    }
}
