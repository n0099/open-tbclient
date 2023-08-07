package com.baidu.pass.biometrics.base.result;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.pass.biometrics.base.utils.ResUtils;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class PassBiometricResult {
    public static final int ERROR_CODE_CONFIG_ERROR = -210;
    public static final int ERROR_CODE_DANGEROUS_PROTOCOL_ERROR = -208;
    public static final int ERROR_CODE_LACK_SO_ERROR = -211;
    public static final int ERROR_CODE_NETWORK_UNAVAILABLE = -201;
    public static final int ERROR_CODE_NOT_IMPORT_VIS_SDK = -212;
    public static final int ERROR_CODE_NOT_INIT_PASS_SDK = -213;
    public static final int ERROR_CODE_NO_LOGIN = 101;
    public static final int ERROR_CODE_PARAM = -205;
    public static final int ERROR_CODE_SERVER_ERROR = -206;
    public static final int ERROR_CODE_SO_ERROR = -207;
    public static final int ERROR_CODE_SSL_PEER_UNVERIFIED = -203;
    public static final int ERROR_CODE_SYSTEM_VERSION_LOW_ERROR = -209;
    public static final int ERROR_CODE_UNKNOWN = -202;
    public static final int ERROR_CODE_USER_CANCEL = -204;
    public static final int RESULT_CODE_SUCCESS = 0;
    public SparseArray<String> msgMap;
    public int resultCode;
    public String resultMsg;
    public static final String RESULT_MSG_SUCCESS = ResUtils.getString(R.string.obfuscated_res_0x7f0f0f4e);
    public static final String ERROR_MSG_NETWORK_UNAVAILABLE = ResUtils.getString(R.string.obfuscated_res_0x7f0f0f3c);
    public static final String ERROR_MSG_UNKNOWN = ResUtils.getString(R.string.obfuscated_res_0x7f0f0f45);
    public static final String ERROR_MSG_SSL_PEER_UNVERIFIED = ResUtils.getString(R.string.obfuscated_res_0x7f0f0f43);
    public static final String ERROR_MSG_USER_CANCEL = ResUtils.getString(R.string.obfuscated_res_0x7f0f0f46);
    public static final String ERROR_MSG_PARAM = ResUtils.getString(R.string.obfuscated_res_0x7f0f0f3f);
    public static final String ERROR_MSG_SERVER_ERROR = ResUtils.getString(R.string.obfuscated_res_0x7f0f0f41);
    public static final String ERROR_MSG_SO_ERROR = ResUtils.getString(R.string.obfuscated_res_0x7f0f0f42);
    public static final String ERROR_MSG_DANGEROUS_PROTOCOL_ERROR = ResUtils.getString(R.string.obfuscated_res_0x7f0f0f35);
    public static final String ERROR_MSG_SYSTEM_VERSION_LOW_ERROR = ResUtils.getString(R.string.obfuscated_res_0x7f0f0f44);
    public static final String ERROR_MSG_CONFIG_ERROR = ResUtils.getString(R.string.obfuscated_res_0x7f0f0f33);
    public static final String ERROR_MSG_LACK_SO_ERROR = ResUtils.getString(R.string.obfuscated_res_0x7f0f0f38);
    public static final String ERROR_MSG_NOT_IMPORT_VIS_SDK = ResUtils.getString(R.string.obfuscated_res_0x7f0f0f3b);
    public static final String ERROR_MSG_NOT_INIT_PASS_SDK = ResUtils.getString(R.string.obfuscated_res_0x7f0f0f40);
    public static final String ERROR_MSG_NO_LOGIN = ResUtils.getString(R.string.obfuscated_res_0x7f0f0f3d);

    public PassBiometricResult() {
        SparseArray<String> sparseArray = new SparseArray<>();
        this.msgMap = sparseArray;
        this.resultCode = -202;
        sparseArray.put(0, RESULT_MSG_SUCCESS);
        this.msgMap.put(-202, ERROR_MSG_UNKNOWN);
        this.msgMap.put(-201, ERROR_MSG_NETWORK_UNAVAILABLE);
        this.msgMap.put(-203, ERROR_MSG_SSL_PEER_UNVERIFIED);
        this.msgMap.put(-204, ERROR_MSG_USER_CANCEL);
        this.msgMap.put(-205, ERROR_MSG_PARAM);
        this.msgMap.put(-206, ERROR_MSG_SERVER_ERROR);
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getResultMsg() {
        SparseArray<String> sparseArray;
        int i;
        if (!TextUtils.isEmpty(this.resultMsg)) {
            return this.resultMsg;
        }
        if (this.msgMap.get(this.resultCode) != null) {
            sparseArray = this.msgMap;
            i = this.resultCode;
        } else {
            sparseArray = this.msgMap;
            i = -202;
        }
        return sparseArray.get(i);
    }

    public void setResultCode(int i) {
        this.resultCode = i;
    }

    public void setResultMsg(String str) {
        this.resultMsg = str;
    }
}
