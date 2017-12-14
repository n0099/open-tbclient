package com.baidu.sapi2.result;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class GetTplStokenResult extends SapiResult {
    public static final int ERROR_CODE_BDUSS_NOT_EXIST = -301;
    public static final int ERROR_CODE_GET_STOKEN_FAILURE = 8;
    public static final int ERROR_CODE_PARSE_DATA_FAIL = -304;
    public static final int ERROR_CODE_PTOKEN_EMPTY = -305;
    public static final int ERROR_CODE_STOKENS_NOT_MATCH = -306;
    public static final int ERROR_CODE_TARGET_TPL_LIST_EMPTY = -302;
    public static final String ERROR_MSG_BDUSS_NOT_EXIST = "bduss 本地不存在";
    public Map<String, String> tplStokenMap = new HashMap();
    public FailureType failureType = FailureType.UNKNOWN;

    /* loaded from: classes.dex */
    public enum FailureType {
        PTOKEN_EMPTY,
        BDUSS_PTOKEN_NOT_MATCH,
        BDUSS_EXPIRED,
        UNKNOWN
    }

    public GetTplStokenResult() {
        this.msgMap.put(-301, ERROR_MSG_BDUSS_NOT_EXIST);
    }
}
