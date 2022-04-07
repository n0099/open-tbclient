package com.baidu.searchbox.cloudcontrol.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class CloudControlRequestInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object mCheckInfo;
    public Object mFilter;
    public boolean mIsForceDispatch;
    public Object mPostData;
    public HashMap<String, String> mQueryData;
    public String mServiceName;

    public CloudControlRequestInfo(String str, Object obj, HashMap<String, String> hashMap, Object obj2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, obj, hashMap, obj2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mServiceName = str;
        this.mPostData = obj;
        this.mQueryData = hashMap;
        this.mCheckInfo = obj2;
    }

    public Object getCheckInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mCheckInfo : invokeV.objValue;
    }

    public Object getFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mFilter : invokeV.objValue;
    }

    public Object getPostData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPostData : invokeV.objValue;
    }

    public HashMap<String, String> getQueryData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mQueryData == null) {
                this.mQueryData = new HashMap<>();
            }
            return this.mQueryData;
        }
        return (HashMap) invokeV.objValue;
    }

    public String getServiceName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mServiceName : (String) invokeV.objValue;
    }

    public boolean isForceDispatch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mIsForceDispatch : invokeV.booleanValue;
    }

    public CloudControlRequestInfo(String str, Object obj, HashMap<String, String> hashMap, Object obj2, Object obj3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, obj, hashMap, obj2, obj3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mServiceName = str;
        this.mPostData = obj;
        this.mQueryData = hashMap;
        this.mCheckInfo = obj2;
        this.mFilter = obj3;
    }

    public CloudControlRequestInfo(String str, Object obj, HashMap<String, String> hashMap, Object obj2, Object obj3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, obj, hashMap, obj2, obj3, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mServiceName = str;
        this.mPostData = obj;
        this.mQueryData = hashMap;
        this.mCheckInfo = obj2;
        this.mFilter = obj3;
        this.mIsForceDispatch = z;
    }
}
