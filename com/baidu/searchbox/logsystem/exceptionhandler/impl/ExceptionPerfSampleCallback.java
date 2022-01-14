package com.baidu.searchbox.logsystem.exceptionhandler.impl;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.PerfSampleManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
@Service
/* loaded from: classes11.dex */
public class ExceptionPerfSampleCallback implements PerfSampleManager.IPerfSampleCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static String ACTIVE_UPLOAD_TYPE = "1";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1885688603, "Lcom/baidu/searchbox/logsystem/exceptionhandler/impl/ExceptionPerfSampleCallback;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1885688603, "Lcom/baidu/searchbox/logsystem/exceptionhandler/impl/ExceptionPerfSampleCallback;");
        }
    }

    public ExceptionPerfSampleCallback() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.PerfSampleManager.IPerfSampleCallback
    public String getSampleFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            return uBCManager != null ? TextUtils.equals(ACTIVE_UPLOAD_TYPE, uBCManager.getUploadType(ExceptionHandlerImpl.UBC_ID)) ? ExceptionHandlerImpl.UBC_ID : "" : "";
        }
        return (String) invokeV.objValue;
    }
}
