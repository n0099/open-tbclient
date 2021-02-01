package com.baidu.pass.biometrics.base.result;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.pass.biometrics.base.R;
import com.baidu.pass.biometrics.base.utils.ResUtils;
/* loaded from: classes6.dex */
public class PassBiometricResult {
    public static final int ERROR_CODE_NETWORK_UNAVAILABLE = -201;
    public static final int ERROR_CODE_NO_LOGIN = 101;
    public static final int ERROR_CODE_PARAM = -205;
    public static final int ERROR_CODE_SERVER_ERROR = -206;
    public static final int ERROR_CODE_SSL_PEER_UNVERIFIED = -203;
    public static final int ERROR_CODE_UNKNOWN = -202;
    public static final int ERROR_CODE_USER_CANCEL = -204;
    public static final int RESULT_CODE_SUCCESS = 0;
    protected SparseArray<String> msgMap = new SparseArray<>();
    protected int resultCode = -202;
    protected String resultMsg;
    public static final String RESULT_MSG_SUCCESS = ResUtils.getString(R.string.pass_bio_result_msg_success);
    public static final String ERROR_MSG_NETWORK_UNAVAILABLE = ResUtils.getString(R.string.pass_bio_error_msg_network_unavailable);
    public static final String ERROR_MSG_UNKNOWN = ResUtils.getString(R.string.pass_bio_error_msg_unknown);
    public static final String ERROR_MSG_SSL_PEER_UNVERIFIED = ResUtils.getString(R.string.pass_bio_error_msg_ssl_peer_unverified);
    public static final String ERROR_MSG_USER_CANCEL = ResUtils.getString(R.string.pass_bio_error_msg_user_cancel);
    public static final String ERROR_MSG_PARAM = ResUtils.getString(R.string.pass_bio_error_msg_param);
    public static final String ERROR_MSG_SERVER_ERROR = ResUtils.getString(R.string.pass_bio_error_msg_server_error);
    public static final String ERROR_MSG_NO_LOGIN = ResUtils.getString(R.string.pass_bio_error_msg_no_login);

    public PassBiometricResult() {
        this.msgMap.put(0, RESULT_MSG_SUCCESS);
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
        if (TextUtils.isEmpty(this.resultMsg)) {
            return this.msgMap.get(this.resultCode) != null ? this.msgMap.get(this.resultCode) : this.msgMap.get(-202);
        }
        return this.resultMsg;
    }

    public void setResultCode(int i) {
        this.resultCode = i;
    }

    public void setResultMsg(String str) {
        this.resultMsg = str;
    }
}
