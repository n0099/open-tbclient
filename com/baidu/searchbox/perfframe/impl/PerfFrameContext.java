package com.baidu.searchbox.perfframe.impl;

import android.content.Context;
import android.util.Log;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.aperf.param.CommonUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.perfframe.ioc.IPerfFrameCallBack;
import com.baidu.searchbox.perfframe.ioc.IPerfFrameRegister;
import com.baidu.searchbox.track.Track;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ic1;
@Autowired
/* loaded from: classes2.dex */
public class PerfFrameContext {
    public static /* synthetic */ Interceptable $ic;
    public static final IPerfFrameCallBack PERFFRAME_CONTEXT_DEFAULT;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1387984774, "Lcom/baidu/searchbox/perfframe/impl/PerfFrameContext;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1387984774, "Lcom/baidu/searchbox/perfframe/impl/PerfFrameContext;");
                return;
            }
        }
        PERFFRAME_CONTEXT_DEFAULT = new IPerfFrameCallBack() { // from class: com.baidu.searchbox.perfframe.impl.PerfFrameContext.1
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

            @Override // com.baidu.searchbox.perfframe.ioc.IPerfFrameCallBack
            public void onPerfFrameCallBack(Context context, PerfExpInfo perfExpInfo) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, context, perfExpInfo) == null) {
                    if (AppConfig.isDebug()) {
                        Log.d("PerfFrame", "onPerfFrameCallBack");
                    }
                    ic1<IPerfFrameRegister> perfFrameRegister = PerfFrameRuntime.getInstance().getPerfFrameRegister();
                    if (perfFrameRegister == null || perfFrameRegister.getList() == null || perfExpInfo == null) {
                        return;
                    }
                    if (AppConfig.isDebug()) {
                        Log.i("PerfFrame", "perfExpInfo = " + perfExpInfo.toString());
                    }
                    perfExpInfo.setTrackUIs(Track.getInstance().getAllTrackUIs());
                    perfExpInfo.setLogId(CommonUtils.getLogId());
                    for (IPerfFrameRegister iPerfFrameRegister : perfFrameRegister.getList()) {
                        iPerfFrameRegister.onEvent(context, perfExpInfo);
                    }
                }
            }
        };
    }

    public PerfFrameContext() {
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
    public static IPerfFrameCallBack getPerfFrameContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? PERFFRAME_CONTEXT_DEFAULT : (IPerfFrameCallBack) invokeV.objValue;
    }
}
