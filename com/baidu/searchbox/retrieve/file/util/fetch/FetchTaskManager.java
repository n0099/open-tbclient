package com.baidu.searchbox.retrieve.file.util.fetch;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.KVStorageFactory;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class FetchTaskManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SP_FETCH_DEBUG_KEY = "fetch_debug_key";
    public static final String SP_FETCH_TASK_STORE = "com.baidu.searchbox.fetch.task";
    public static final String SP_TASK_ORIGIN_KEY = "fetch_task_origin";
    public static final String SP_TASK_RETRY_COUNT_KEY = "fetch_task_retry_count";
    public static volatile FetchTaskManager sSingleton;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPrefsWrapper mSharedPrefsWrapper;

    public FetchTaskManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSharedPrefsWrapper = new SharedPrefsWrapper(KVStorageFactory.getSharedPreferences(SP_FETCH_TASK_STORE));
    }

    public static FetchTaskManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sSingleton == null) {
                synchronized (FetchTaskManager.class) {
                    if (sSingleton == null) {
                        sSingleton = new FetchTaskManager();
                    }
                }
            }
            return sSingleton;
        }
        return (FetchTaskManager) invokeV.objValue;
    }

    public void clearOriginData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            saveOriginData("");
        }
    }

    public String getOriginData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mSharedPrefsWrapper.getString(SP_TASK_ORIGIN_KEY, "");
        }
        return (String) invokeV.objValue;
    }

    public int getRetryCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mSharedPrefsWrapper.getInt(SP_TASK_RETRY_COUNT_KEY, 0);
        }
        return invokeV.intValue;
    }

    public boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mSharedPrefsWrapper.getBoolean(SP_FETCH_DEBUG_KEY, false);
        }
        return invokeV.booleanValue;
    }

    public void saveOriginData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SharedPrefsWrapper sharedPrefsWrapper = this.mSharedPrefsWrapper;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sharedPrefsWrapper.putString(SP_TASK_ORIGIN_KEY, str);
        }
    }

    public void saveRetryCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.mSharedPrefsWrapper.putInt(SP_TASK_RETRY_COUNT_KEY, i);
        }
    }

    public void setDebug(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.mSharedPrefsWrapper.putBoolean(SP_FETCH_DEBUG_KEY, z);
        }
    }
}
