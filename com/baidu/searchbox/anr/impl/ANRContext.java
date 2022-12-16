package com.baidu.searchbox.anr.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.anr.ioc.IANRContext;
import com.baidu.searchbox.anr.ioc.IANRRegister;
import com.baidu.searchbox.aperf.param.CommonUtils;
import com.baidu.searchbox.block.impl.BlockMonitor;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.track.Track;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.tieba.mf1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Autowired
/* loaded from: classes2.dex */
public class ANRContext {
    public static /* synthetic */ Interceptable $ic;
    public static final IANRContext ANR_CONTEXT_DEFAULT;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-249372474, "Lcom/baidu/searchbox/anr/impl/ANRContext;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-249372474, "Lcom/baidu/searchbox/anr/impl/ANRContext;");
                return;
            }
        }
        ANR_CONTEXT_DEFAULT = new IANRContext() { // from class: com.baidu.searchbox.anr.impl.ANRContext.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.searchbox.anr.ioc.IANRContext
            public void onAppNotResponding(Context context, ANRInfo aNRInfo) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, context, aNRInfo) == null) {
                    if (AppConfig.isDebug()) {
                        Log.d(BlockMonitor.TAG, "onAppNotResponding");
                    }
                    mf1<IANRRegister> iANRUploadList = ANRRuntime.getInstance().getIANRUploadList();
                    if (iANRUploadList != null && iANRUploadList.getList() != null && aNRInfo != null) {
                        if (AppConfig.isDebug()) {
                            Log.i(BlockMonitor.TAG, "ANRInfo = " + aNRInfo.getStackTrace());
                        }
                        TrackUI lastTrackUI = Track.getInstance().getLastTrackUI();
                        if (lastTrackUI != null) {
                            if (!TextUtils.isEmpty(lastTrackUI.getFragmentPage())) {
                                aNRInfo.setCurrentPage(lastTrackUI.getFragmentPage());
                            } else if (!TextUtils.isEmpty(lastTrackUI.getActivityPage())) {
                                aNRInfo.setCurrentPage(lastTrackUI.getActivityPage());
                            }
                        }
                        aNRInfo.setTrackUIs(Track.getInstance().getAllTrackUIs());
                        aNRInfo.setLogId(CommonUtils.getLogId());
                        for (IANRRegister iANRRegister : iANRUploadList.getList()) {
                            iANRRegister.onANR(context, aNRInfo);
                        }
                    }
                }
            }
        };
    }

    public ANRContext() {
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

    @Inject(force = false)
    public static IANRContext getANRContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return ANR_CONTEXT_DEFAULT;
        }
        return (IANRContext) invokeV.objValue;
    }
}
