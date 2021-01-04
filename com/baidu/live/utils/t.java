package com.baidu.live.utils;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes11.dex */
public class t {
    private static String bOX = "";

    public static String Ia() {
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

    public static String XF() {
        if (TextUtils.isEmpty(bOX)) {
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
        return bOX;
    }

    public static void iU(String str) {
        bOX = str;
    }

    public static String XG() {
        return bOX;
    }
}
