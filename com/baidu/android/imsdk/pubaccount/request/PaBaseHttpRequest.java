package com.baidu.android.imsdk.pubaccount.request;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public abstract class PaBaseHttpRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mOsType;

    public PaBaseHttpRequest() {
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
        this.mOsType = 1;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            HashMap hashMap = new HashMap();
            String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
            hashMap.put("Cookie", "BDUSS=" + bduss);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (getHostUrl() == null) {
                return null;
            }
            return getHostUrl() + "rest/3.0/im/box";
        }
        return (String) invokeV.objValue;
    }

    public String getHostUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int readIntData = Utility.readIntData(this.mContext, Constants.KEY_ENV, 0);
            if (readIntData != 0) {
                if (readIntData != 1) {
                    if (readIntData != 2) {
                        if (readIntData != 3) {
                            return null;
                        }
                        return Constants.URL_HTTP_BOX;
                    }
                    return Constants.URL_HTTP_QA;
                }
                return "http://rd-im-server.bcc-szth.baidu.com:8080/";
            }
            return "https://pim.baidu.com/";
        }
        return (String) invokeV.objValue;
    }

    public String getSignByMd5Error(String str, long j, long j2, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2), str2})) == null) {
            try {
                if (!TextUtils.isEmpty(str2)) {
                    if (str2.equals(Constants.ERROR_MSG_MD5_NULL)) {
                        return j + str.substring(0, 28) + j2;
                    } else if (str2.equals(Constants.ERROR_MSG_MD5_EMPTY)) {
                        return j + str.substring(0, 24) + j2;
                    } else {
                        return str2;
                    }
                }
                return j + str.substring(0, 20) + j2;
            } catch (Exception unused) {
                return "" + j + j2;
            }
        }
        return (String) invokeCommon.objValue;
    }
}
