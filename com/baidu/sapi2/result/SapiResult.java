package com.baidu.sapi2.result;

import android.text.TextUtils;
import android.util.SparseArray;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class SapiResult {
    public static final int ERROR_CODE_METHOD_DEPRECATED = -206;
    public static final int ERROR_CODE_NETWORK_UNAVAILABLE = -201;
    public static final int ERROR_CODE_NOT_IMPORT_SOFIRE_SDK = -401;
    public static final int ERROR_CODE_PARAMS_ERROR = -204;
    public static final int ERROR_CODE_PROCESSED_END = -301;
    public static final int ERROR_CODE_SERVER_DATA_ERROR = -205;
    public static final int ERROR_CODE_SSL_PEER_UNVERIFIED = -203;
    public static final int ERROR_CODE_UNKNOWN = -202;
    public static final int ERROR_CODE_V2_SHARE_ACCOUNT_FAIL = -207;
    public static final String ERROR_MSG_METHOD_DEPRECATED = "接口已下线";
    public static final String ERROR_MSG_NETWORK_UNAVAILABLE = "网络连接不可用，请检查网络设置";
    public static final String ERROR_MSG_NOT_IMPORT_SOFIRE_SDK = "没有导入安全SDK";
    public static final String ERROR_MSG_PARAMS_ERROR = "参数错误";
    public static final String ERROR_MSG_PROCESSED_END = "流程已结束";
    public static final String ERROR_MSG_SERVER_DATA_ERROR = "服务端数据异常";
    public static final String ERROR_MSG_SSL_PEER_UNVERIFIED = "网站安全证书已过期或不可信，系统时间错误可能导致此问题";
    public static final String ERROR_MSG_UNKNOWN = "网络连接失败，请检查网络设置";
    public static final String ERROR_MSG_V2_SHARE_ACCOUNT_FAIL = "互通登录失败,请稍后再试";
    public static final int RESULT_CODE_SUCCESS = 0;
    public static final int RESULT_CODE_WAPPASS_SUCCESS = 110000;
    public static final String RESULT_MSG_SUCCESS = "成功";
    protected SparseArray<String> msgMap = new SparseArray<>();
    protected int resultCode = -202;
    protected String resultMsg;

    /* loaded from: classes.dex */
    public static class Action {
        public ActionMode actionMode;
        public String actionTitle;
        public ActionType actionType;
        public String actionUrl;
    }

    /* loaded from: classes.dex */
    public enum ActionMode {
        MSG("msg"),
        URL("url");
        
        private static final Map<String, ActionMode> a = new HashMap();
        private String b;

        static {
            ActionMode[] values;
            for (ActionMode actionMode : values()) {
                a.put(actionMode.toString(), actionMode);
            }
        }

        ActionMode(String str) {
            this.b = str;
        }

        public String getValue() {
            return this.b;
        }

        public static ActionMode fromString(String str) {
            return a.get(str);
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.b;
        }
    }

    /* loaded from: classes.dex */
    public enum ActionType {
        FORCE("force"),
        OPTIONAL("optional");
        
        private static final Map<String, ActionType> a = new HashMap();
        private String b;

        static {
            ActionType[] values;
            for (ActionType actionType : values()) {
                a.put(actionType.toString(), actionType);
            }
        }

        ActionType(String str) {
            this.b = str;
        }

        public String getValue() {
            return this.b;
        }

        public static ActionType fromString(String str) {
            return a.get(str);
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.b;
        }
    }

    public SapiResult() {
        this.msgMap.put(0, "成功");
        this.msgMap.put(110000, "成功");
        this.msgMap.put(-201, ERROR_MSG_NETWORK_UNAVAILABLE);
        this.msgMap.put(-202, ERROR_MSG_UNKNOWN);
        this.msgMap.put(-203, "网站安全证书已过期或不可信，系统时间错误可能导致此问题");
        this.msgMap.put(-204, ERROR_MSG_PARAMS_ERROR);
        this.msgMap.put(-205, ERROR_MSG_SERVER_DATA_ERROR);
        this.msgMap.put(-206, ERROR_MSG_METHOD_DEPRECATED);
        this.msgMap.put(-301, ERROR_MSG_PROCESSED_END);
        this.msgMap.put(ERROR_CODE_V2_SHARE_ACCOUNT_FAIL, ERROR_MSG_V2_SHARE_ACCOUNT_FAIL);
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(int i) {
        this.resultCode = i;
    }

    public void setResultMsg(String str) {
        this.resultMsg = str;
    }

    public String getResultMsg() {
        if (TextUtils.isEmpty(this.resultMsg)) {
            return this.msgMap.get(this.resultCode) != null ? this.msgMap.get(this.resultCode) : this.msgMap.get(-202);
        }
        return this.resultMsg;
    }
}
