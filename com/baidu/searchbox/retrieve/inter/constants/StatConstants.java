package com.baidu.searchbox.retrieve.inter.constants;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class StatConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ERR_CODE_CLIENT_CHECK_EMPTY = "1";
    public static final String ERR_CODE_CLIENT_CHECK_EXPIRED = "3";
    public static final String ERR_CODE_CLIENT_CHECK_WRONG = "2";
    public static final String ERR_CODE_DISPATCH_NET_WRONG = "2";
    public static final String ERR_CODE_DISPATCH_NOT_REGISTER = "1";
    public static final String ERR_MSG_CHECK_PARAM_FAIL = "check param failed";
    public static final String ERR_MSG_CLIENT_CHECK_EMPTY = "task data null";
    public static final String ERR_MSG_CLIENT_CHECK_EXPIRED = "task data timeout";
    public static final String ERR_MSG_CLIENT_CHECK_WRONG = "task data error";
    public static final String ERR_MSG_DISPATCH_NET_WRONG = "network not support";
    public static final String ERR_MSG_DISPATCH_NOT_REGISTER = "fetch task no register";
    public static final String ERR_MSG_QUERY_FAIL = "query dir not found";
    public static final String ERR_MSG_START_FAIL = "retrieve start failed";
    public static final String ERR_MSG_ZIP_FAIL = "zip failed";
    public static final String KEY_EXT = "ext";
    public static final String KEY_EXT_DATA_ID = "dataId";
    public static final String KEY_EXT_DETAIL = "detail";
    public static final String KEY_EXT_ERR_CODE = "errCode";
    public static final String KEY_EXT_ERR_MSG = "errMsg";
    public static final String KEY_EXT_FILE_ID = "fileId";
    public static final String KEY_EXT_FILE_META = "fileMeta";
    public static final String KEY_EXT_JOB_ID = "jobId";
    public static final String KEY_EXT_TASK_TYPE = "taskType";
    public static final String KEY_EXT_VERSION = "version";
    public static final String KEY_FROM = "from";
    public static final String KEY_PAGE = "page";
    public static final String KEY_TYPE = "type";
    public static final String KEY_VALUE = "value";
    public static final String STAT_ACTIVE_ID = "4465";
    public static final String STAT_RETRIEVE_ID = "4464";
    public static final String VALUE_FAIL = "0";
    public static final String VALUE_FROM_AC_UPLOAD = "activeUpload";
    public static final String VALUE_FROM_RETRIEVE = "retrieve";
    public static final String VALUE_SUCCESS = "1";
    public static final String VALUE_TYPE_CHECK_PARAM = "checkParam";
    public static final String VALUE_TYPE_CLIENT_CHECK = "clientCheckTask";
    public static final String VALUE_TYPE_DISPATCH = "dispatch";
    public static final String VALUE_TYPE_QUERY = "query";
    public static final String VALUE_TYPE_RECEIVE = "receive";
    public static final String VALUE_TYPE_REPORT = "report";
    public static final String VALUE_TYPE_SERVER_CHECK = "serverCheckTask";
    public static final String VALUE_TYPE_START = "start";
    public static final String VALUE_TYPE_UPLOAD = "upload";
    public static final String VALUE_TYPE_ZIP = "zip";
    public transient /* synthetic */ FieldHolder $fh;

    public StatConstants() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
