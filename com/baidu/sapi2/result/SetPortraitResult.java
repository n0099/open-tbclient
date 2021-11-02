package com.baidu.sapi2.result;

import com.baidu.sapi2.NoProguard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class SetPortraitResult extends SapiResult implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ERROR_MSG_UNKNOWN = "设置头像失败";
    public static final int RESULT_CODE_BDUSS_EXPIRED = 160103;
    public static final int RESULT_CODE_FORMAT_ERROR = 1605001;
    public static final int RESULT_CODE_SYSTEM_ERROR = 1605002;
    public static final int RESULT_CODE_UNABLE_CHANGE = 991613;
    public static final int RESULT_CODE_UNDER_REVIEW = 991616;
    public static final String RESULT_MSG_BDUSS_EXPIRED = "用户登录状态失效，请重新登录";
    public static final String RESULT_MSG_FORMAT_ERROR = "头像格式错误";
    public static final String RESULT_MSG_SUCCESS = "设置头像成功";
    public static final String RESULT_MSG_SYSTEM_ERROR = "系统错误";
    public static final String RESULT_MSG_UNABLE_CHANGE = "头像审核中，暂不支持更换";
    public static final String RESULT_MSG_UNDER_REVIEW = "头像已上传，审核中";
    public transient /* synthetic */ FieldHolder $fh;
    public String portraitHttps;
    public String portraitSign;

    public SetPortraitResult() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.msgMap.put(0, RESULT_MSG_SUCCESS);
        this.msgMap.put(110000, RESULT_MSG_SUCCESS);
        this.msgMap.put(160103, "用户登录状态失效，请重新登录");
        this.msgMap.put(1605001, RESULT_MSG_FORMAT_ERROR);
        this.msgMap.put(1605002, RESULT_MSG_SYSTEM_ERROR);
        this.msgMap.put(RESULT_CODE_UNDER_REVIEW, RESULT_MSG_UNDER_REVIEW);
        this.msgMap.put(RESULT_CODE_UNABLE_CHANGE, RESULT_MSG_UNABLE_CHANGE);
        this.msgMap.put(-202, ERROR_MSG_UNKNOWN);
    }
}
