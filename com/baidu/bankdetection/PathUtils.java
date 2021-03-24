package com.baidu.bankdetection;

import android.os.Environment;
/* loaded from: classes2.dex */
public class PathUtils {
    public static final String DATA_DIR = "";
    public static final String captcha_path = "bankcard-2.bundle/model/bank_card_captcha.txt";
    public static final String dtc_mean_path_fst = null;
    public static final String dtc_mean_path_scd = null;
    public static final String dtc_model_path_fst = "bankcard-2.bundle/model/dtc_model_bank_card_fst_64";
    public static final String dtc_model_path_scd = "bankcard-2.bundle/model/dtc_model_bank_card_scd_64";
    public static final String mean_path = "bankcard-2.bundle/mean/data_mean_32_bank_card";
    public static final String model_path = "bankcard-2.bundle/model/cdnn_model_bank_card_32";
    public static final boolean use_new_captcha = true;
    public static final boolean use_new_dtc_fst = true;
    public static final boolean use_new_dtc_scd = true;
    public static final boolean use_new_recog = true;

    public static String getSDPath() {
        return (Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null).toString();
    }
}
