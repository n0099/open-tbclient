package com.baidu.sapi2.result;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class SapiResult {
    public static final int ERROR_CODE_NETWORK_UNAVAILABLE = -201;
    public static final int ERROR_CODE_UNKNOWN = -202;
    public static final String ERROR_MSG_NETWORK_UNAVAILABLE = "网络连接不可用，请检查网络设置";
    public static final String ERROR_MSG_UNKNOWN = "网络连接失败，请检查网络设置";
    public static final int RESULT_CODE_SUCCESS = 0;
    public static final String RESULT_MSG_SUCCESS = "成功";
    protected SparseArray<String> msgMap = new SparseArray<>();
    protected int resultCode = ERROR_CODE_UNKNOWN;
    protected String resultMsg;

    /* loaded from: classes.dex */
    public class Action {
        public ActionMode actionMode;
        public String actionTitle;
        public ActionType actionType;
        public String actionUrl;
    }

    /* loaded from: classes.dex */
    public enum ActionMode {
        MSG(AddFriendActivityConfig.MSG),
        URL(ImageViewerConfig.URL);
        
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
        this.msgMap.put(0, RESULT_MSG_SUCCESS);
        this.msgMap.put(ERROR_CODE_NETWORK_UNAVAILABLE, ERROR_MSG_NETWORK_UNAVAILABLE);
        this.msgMap.put(ERROR_CODE_UNKNOWN, ERROR_MSG_UNKNOWN);
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
            return this.msgMap.get(this.resultCode) != null ? this.msgMap.get(this.resultCode) : ERROR_MSG_UNKNOWN;
        }
        return this.resultMsg;
    }
}
