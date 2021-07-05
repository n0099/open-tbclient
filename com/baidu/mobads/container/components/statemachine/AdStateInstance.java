package com.baidu.mobads.container.components.statemachine;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class AdStateInstance {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AtomicBoolean isHasSend;
    public AtomicBoolean isReady4Send;
    public IXAdInstanceInfo mAdInstanceInfo;
    public StringBuilder mEventList;
    public HashMap<String, String> mExtraInfo;
    public long mLastUpdateTime;
    public String mProdType;
    public long mRequestTimeMillis;

    public AdStateInstance(long j, String str, IXAdInstanceInfo iXAdInstanceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), str, iXAdInstanceInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isReady4Send = new AtomicBoolean(false);
        this.isHasSend = new AtomicBoolean(false);
        this.mExtraInfo = new HashMap<>();
        this.mEventList = new StringBuilder();
        this.mRequestTimeMillis = j;
        this.mProdType = str;
        this.mAdInstanceInfo = iXAdInstanceInfo;
    }

    public void addEvent(AdStateCode adStateCode) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, adStateCode) == null) || adStateCode == null || adStateCode.getCode() <= 0) {
            return;
        }
        this.mEventList.append(adStateCode.getCode());
        this.mLastUpdateTime = System.currentTimeMillis();
        markReady4Send(false);
    }

    public void addExtra(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.mExtraInfo.put(str, str2);
        this.mLastUpdateTime = System.currentTimeMillis();
        markReady4Send(AdStateEvent.EVENT_AD_TIMEOUT.equals(str));
    }

    public String getAllState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mEventList.toString() : (String) invokeV.objValue;
    }

    public HashMap<String, String> getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mExtraInfo : (HashMap) invokeV.objValue;
    }

    public void markReady4Send(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (this.isReady4Send.get() != z) {
                this.isReady4Send.set(z);
            }
            if (z) {
                return;
            }
            setHasSend(false);
        }
    }

    public void setHasSend(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || this.isHasSend.get() == z) {
            return;
        }
        this.isHasSend.set(z);
    }
}
