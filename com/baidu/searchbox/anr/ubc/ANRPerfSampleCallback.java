package com.baidu.searchbox.anr.ubc;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.PerfSampleManager;
import com.baidu.searchbox.config.AppConfig;
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
/* loaded from: classes4.dex */
public class ANRPerfSampleCallback implements PerfSampleManager.IPerfSampleCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static String ACTIVE_ANR_UPLOAD_TYPE = "1";
    public static String PASSIVE_ANR_UPLOAD_TYPE = "0";
    public static String UBC_ANR_ID = "1794";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1579351163, "Lcom/baidu/searchbox/anr/ubc/ANRPerfSampleCallback;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1579351163, "Lcom/baidu/searchbox/anr/ubc/ANRPerfSampleCallback;");
        }
    }

    public ANRPerfSampleCallback() {
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
            if (uBCManager != null) {
                String uploadType = uBCManager.getUploadType(UBC_ANR_ID);
                if (AppConfig.isDebug()) {
                    String str = "getSampleFlag uploadType " + uploadType;
                }
                if (TextUtils.equals(ACTIVE_ANR_UPLOAD_TYPE, uploadType)) {
                    if (!UbcANRRegister.sEnable) {
                        QuickPersistConfig.getInstance().putBoolean(UbcANRRegister.KEY_ANR_ACTIVE_UPLOAD, true);
                    }
                } else if (TextUtils.equals(PASSIVE_ANR_UPLOAD_TYPE, uploadType) && UbcANRRegister.sEnable) {
                    QuickPersistConfig.getInstance().putBoolean(UbcANRRegister.KEY_ANR_ACTIVE_UPLOAD, false);
                }
            }
            return UbcANRRegister.sEnable ? UBC_ANR_ID : "";
        }
        return (String) invokeV.objValue;
    }
}
