package com.baidu.searchbox.aideviceperformance.inference;
/* loaded from: classes2.dex */
public class ModelLoadException extends Exception {
    public static final int ERR_MODEL_ONLOAD = -2;
    public static final int ERR_NO_MODEL = -1;
    public int mErrCode;
    public String mErrMsg;

    public ModelLoadException() {
    }

    public ModelLoadException(int i, String str) {
        this.mErrCode = i;
        this.mErrMsg = str;
    }
}
