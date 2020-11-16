package com.baidu.live.utils;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class s {
    private static String bFb = "";

    public static String GI() {
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

    public static String Ub() {
        if (TextUtils.isEmpty(bFb)) {
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
        return bFb;
    }

    public static void iA(String str) {
        bFb = str;
    }

    public static String Uc() {
        return bFb;
    }
}
