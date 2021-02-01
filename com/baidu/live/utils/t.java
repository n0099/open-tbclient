package com.baidu.live.utils;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes11.dex */
public class t {
    private static String bNV = "";

    public static String Fv() {
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

    public static String Vu() {
        if (TextUtils.isEmpty(bNV)) {
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
        return bNV;
    }

    public static void ie(String str) {
        bNV = str;
    }

    public static String Vv() {
        return bNV;
    }
}
