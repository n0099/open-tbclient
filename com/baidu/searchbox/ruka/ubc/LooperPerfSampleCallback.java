package com.baidu.searchbox.ruka.ubc;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.PerfSampleManager;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
@Service
/* loaded from: classes2.dex */
public class LooperPerfSampleCallback implements PerfSampleManager.IPerfSampleCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static String ACTIVE_UPLOAD_TYPE = "1";
    public static String PASSIVE_UPLOAD_TYPE = "0";
    public static String UBC_BLOCK_ID = "1157";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(610596893, "Lcom/baidu/searchbox/ruka/ubc/LooperPerfSampleCallback;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(610596893, "Lcom/baidu/searchbox/ruka/ubc/LooperPerfSampleCallback;");
        }
    }

    public LooperPerfSampleCallback() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            if (uBCManager != null) {
                String uploadType = uBCManager.getUploadType(UBC_BLOCK_ID);
                if (TextUtils.equals(ACTIVE_UPLOAD_TYPE, uploadType)) {
                    if (!UBCLooperRegister.sEnable) {
                        QuickPersistConfig.getInstance().putBoolean(UBCLooperRegister.KEY_BLOCK_ACTIVE_UPLOAD, true);
                    }
                } else if (TextUtils.equals(PASSIVE_UPLOAD_TYPE, uploadType) && UBCLooperRegister.sEnable) {
                    QuickPersistConfig.getInstance().putBoolean(UBCLooperRegister.KEY_BLOCK_ACTIVE_UPLOAD, false);
                }
            }
            return UBCLooperRegister.sEnable ? UBC_BLOCK_ID : "";
        }
        return (String) invokeV.objValue;
    }
}
