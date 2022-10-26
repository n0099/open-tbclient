package com.baidu.searchbox.aperf.bosuploader;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class STSInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String ak;
    public String bucket;
    public String endpoint;
    public String expired;
    public long expiredAt;
    public String mOrigin;
    public String sk;
    public String token;

    public STSInfo(String str, String str2, String str3, long j, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, Long.valueOf(j), str4, str5, str6};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.ak = str;
        this.sk = str2;
        this.token = str3;
        this.expiredAt = j;
        this.expired = str4;
        this.bucket = str5;
        this.endpoint = str6;
    }

    public String getOrigin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mOrigin;
        }
        return (String) invokeV.objValue;
    }

    public void setOrigin(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.mOrigin = str;
        }
    }
}
