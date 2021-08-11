package com.baidu.searchbox.aperf.bosuploader;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class UploadUrlProvider {
    public static /* synthetic */ Interceptable $ic;
    public static volatile UploadUrlProvider sSingleton;
    public transient /* synthetic */ FieldHolder $fh;
    public UploadUrlListener mUploadUrlListener;

    public UploadUrlProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static UploadUrlProvider getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sSingleton == null) {
                synchronized (UploadUrlProvider.class) {
                    if (sSingleton == null) {
                        sSingleton = new UploadUrlProvider();
                    }
                }
            }
            return sSingleton;
        }
        return (UploadUrlProvider) invokeV.objValue;
    }

    public String getUploadUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            UploadUrlListener uploadUrlListener = this.mUploadUrlListener;
            if (uploadUrlListener != null) {
                return uploadUrlListener.processUrl();
            }
            return CommonUrlParamManager.getInstance().processUrl(BaseUrlManager.getBaseUploadUrl());
        }
        return (String) invokeV.objValue;
    }

    public void setUploadUrlListener(UploadUrlListener uploadUrlListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uploadUrlListener) == null) {
            this.mUploadUrlListener = uploadUrlListener;
        }
    }
}
