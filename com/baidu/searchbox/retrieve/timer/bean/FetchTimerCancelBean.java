package com.baidu.searchbox.retrieve.timer.bean;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class FetchTimerCancelBean extends FetchTimerBasicBean {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String mCancelJobId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FetchTimerCancelBean(String str, String str2, String str3, long j, String str4) {
        super(str, str2, str3, j);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r8;
            Object[] objArr = {str, str2, str3, Long.valueOf(j), str4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], ((Long) objArr2[3]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCancelJobId = str4;
    }

    public String getCancelJobId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mCancelJobId;
        }
        return (String) invokeV.objValue;
    }

    public void setCancelJobId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.mCancelJobId = str;
        }
    }

    @Override // com.baidu.searchbox.retrieve.timer.bean.FetchTimerBasicBean
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "FetchTimerCancelBean{mJobId='" + getJobId() + "', mType='" + getType() + "', mVersion='" + getVersion() + "', mExpiredTime=" + getExpiredTime() + ", mCancelJobId='" + this.mCancelJobId + "'}";
        }
        return (String) invokeV.objValue;
    }
}
