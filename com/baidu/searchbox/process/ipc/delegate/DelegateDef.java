package com.baidu.searchbox.process.ipc.delegate;
/* loaded from: classes6.dex */
public interface DelegateDef {
    public static final String EXTRA_DELEGATION_NAME = "extra_delegation_name";
    public static final String EXTRA_PARAMS = "extra_params";
    public static final String EXTRA_RESULT = "extra_result";
    public static final String EXTRA_RESULT_CODE = "extra_result_code";
    public static final String EXTRA_RESULT_DESC = "extra_result_desc";

    /* loaded from: classes6.dex */
    public interface ResultCode {
        public static final int ERR_ACTIVITY_RESULT = 3;
        public static final int ERR_CALLER = 2;
        public static final int ERR_ILLEGAL_DELEGATION_CLASS = 4;
        public static final int ERR_SELF_FINISH = 6;
        public static final int ERR_UNKNOWN = 1;
        public static final int ERR_USER_CANCEL = 5;
        public static final int OK = 0;
    }
}
