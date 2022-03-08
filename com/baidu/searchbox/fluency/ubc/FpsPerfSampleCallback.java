package com.baidu.searchbox.fluency.ubc;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.PerfSampleManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
@Service
/* loaded from: classes4.dex */
public class FpsPerfSampleCallback implements PerfSampleManager.IPerfSampleCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTIVE_FPS_UPLOAD_TYPE = "1";
    public static final String KEY_FPS_ACTIVE_UPLOAD = "key_fluency_fps_active_upload";
    public static final String PASSIVE_FPS_UPLOAD_TYPE = "0";
    public static final String UBC_FPS_ID = "3715";
    public transient /* synthetic */ FieldHolder $fh;

    public FpsPerfSampleCallback() {
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

    @Override // com.baidu.searchbox.PerfSampleManager.IPerfSampleCallback
    public String getSampleFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            if (uBCManager != null) {
                String uploadType = uBCManager.getUploadType(UBC_FPS_ID);
                if (AppConfig.isDebug()) {
                    String str = "getFpsSampleFlag uploadType " + uploadType;
                }
                if (TextUtils.equals("1", uploadType)) {
                    if (!BdTracesManager.INSTANCE.isActiveUploadType()) {
                        QuickPersistConfig.getInstance().putBoolean(KEY_FPS_ACTIVE_UPLOAD, true);
                    }
                } else if (TextUtils.equals("0", uploadType) && BdTracesManager.INSTANCE.isActiveUploadType()) {
                    QuickPersistConfig.getInstance().putBoolean(KEY_FPS_ACTIVE_UPLOAD, false);
                }
            }
            return BdTracesManager.INSTANCE.isActiveUploadType() ? UBC_FPS_ID : "";
        }
        return (String) invokeV.objValue;
    }
}
