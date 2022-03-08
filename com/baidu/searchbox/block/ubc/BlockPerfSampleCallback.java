package com.baidu.searchbox.block.ubc;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.PerfSampleManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
@Service
/* loaded from: classes4.dex */
public class BlockPerfSampleCallback implements PerfSampleManager.IPerfSampleCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTIVE_BLOCK_UPLOAD_TYPE = "1";
    public static final String PASSIVE_BLOCK_UPLOAD_TYPE = "0";
    public static final String UBC_BLOCK_ID = "3256";
    public transient /* synthetic */ FieldHolder $fh;

    public BlockPerfSampleCallback() {
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
                String uploadType = uBCManager.getUploadType("3256");
                if (AppConfig.isDebug()) {
                    String str = "getSampleFlag uploadType " + uploadType;
                }
                if (TextUtils.equals("1", uploadType)) {
                    if (!UbcBlockRegister.sEnable) {
                        QuickPersistConfig.getInstance().putBoolean(UbcBlockRegister.KEY_BLOCK_CATCH_ACTIVE_UPLOAD, true);
                    }
                } else if (TextUtils.equals("0", uploadType) && UbcBlockRegister.sEnable) {
                    QuickPersistConfig.getInstance().putBoolean(UbcBlockRegister.KEY_BLOCK_CATCH_ACTIVE_UPLOAD, false);
                }
            }
            return UbcBlockRegister.sEnable ? "3256" : "";
        }
        return (String) invokeV.objValue;
    }
}
