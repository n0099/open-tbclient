package com.baidu.sapi2.result;

import android.util.Pair;
/* loaded from: classes.dex */
public class SafeFacadeResult extends SapiResult {
    public static final int ERROR_CODE_CALL_FORBID = -1;
    public static final int ERROR_CODE_INIT_FAILED = 4;
    public static final int ERROR_CODE_INNER = 3;
    public static final int ERROR_CODE_INVALID_METHOD = 2;
    public static final int ERROR_CODE_NULL_METHOD = 1;
    public static final String ERROR_MSG_CALL_FORBID = "已禁止调用";
    public static final String ERROR_MSG_INIT_FAILED = "安全SDK初始化失败";
    public static final String ERROR_MSG_INNER = "内部错误";
    public static final String ERROR_MSG_INVALID_METHOD = "未找到对应的接口方法";
    public static final String ERROR_MSG_NULL_METHOD = "接口方法名为空";
    public Pair<Integer, Object> safeItems;
    public Pair<Integer, Object> safeToken = null;

    public SafeFacadeResult() {
        this.msgMap.put(1, ERROR_MSG_NULL_METHOD);
        this.msgMap.put(2, ERROR_MSG_INVALID_METHOD);
        this.msgMap.put(3, ERROR_MSG_INNER);
        this.msgMap.put(4, ERROR_MSG_INIT_FAILED);
        this.msgMap.put(-1, ERROR_MSG_CALL_FORBID);
    }
}
