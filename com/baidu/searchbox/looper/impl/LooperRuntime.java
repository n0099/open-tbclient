package com.baidu.searchbox.looper.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.block.impl.BlockMonitor;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.looper.ioc.ILooperNeedContext;
import com.baidu.searchbox.looper.ioc.ILooperNeedContext_LooperRuntime_Provider;
import com.baidu.searchbox.looper.ioc.ILooperRegister;
import com.baidu.searchbox.looper.ioc.ILooperRegister_LooperRuntime_ListProvider;
import com.baidu.searchbox.looper.ioc.ILooperUIContext;
import com.baidu.searchbox.track.Track;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.em9;
import com.repackage.fc1;
import com.repackage.gc1;
import com.repackage.hc1;
import com.repackage.ic1;
/* loaded from: classes2.dex */
public class LooperRuntime {
    public static /* synthetic */ Interceptable $ic;
    public static final ILooperUIContext EMPTY_RUKA_UI_CONTEXT;
    public static LooperRuntime sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    @Inject
    public ic1<ILooperRegister> mLooperMonitordList;
    @Inject
    public hc1<ILooperNeedContext> mLooperNeedContext;
    public hc1<ILooperUIContext> mLooperUIContext;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2098329985, "Lcom/baidu/searchbox/looper/impl/LooperRuntime;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2098329985, "Lcom/baidu/searchbox/looper/impl/LooperRuntime;");
                return;
            }
        }
        EMPTY_RUKA_UI_CONTEXT = new ILooperUIContext() { // from class: com.baidu.searchbox.looper.impl.LooperRuntime.1
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

            @Override // com.baidu.searchbox.looper.ioc.ILooperUIContext
            public boolean displayNotification() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }
        };
    }

    public LooperRuntime() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        initmLooperNeedContext();
        initmLooperMonitordList();
    }

    public static LooperRuntime getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sInstance == null) {
                synchronized (LooperRuntime.class) {
                    if (sInstance == null) {
                        sInstance = new LooperRuntime();
                    }
                }
            }
            return sInstance;
        }
        return (LooperRuntime) invokeV.objValue;
    }

    public void dispatchBlock(Context context, em9 em9Var) {
        ic1<ILooperRegister> ic1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, em9Var) == null) || (ic1Var = this.mLooperMonitordList) == null || ic1Var.getList() == null) {
            return;
        }
        LooperBlock looperBlock = new LooperBlock(em9Var.r, em9Var.q, em9Var.n, em9Var.o, em9Var.w);
        TrackUI lastTrackUI = Track.getInstance().getLastTrackUI();
        if (lastTrackUI != null) {
            if (!TextUtils.isEmpty(lastTrackUI.getFragmentPage())) {
                looperBlock.setCurrentPage(lastTrackUI.getFragmentPage());
            } else if (!TextUtils.isEmpty(lastTrackUI.getActivityPage())) {
                looperBlock.setCurrentPage(lastTrackUI.getActivityPage());
            }
        }
        looperBlock.setTrackUIs(Track.getInstance().getAllTrackUIs());
        for (ILooperRegister iLooperRegister : this.mLooperMonitordList.getList()) {
            iLooperRegister.onBlock(context, looperBlock);
        }
    }

    public boolean enableLooper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ic1<ILooperRegister> ic1Var = this.mLooperMonitordList;
            if (ic1Var == null || ic1Var.getList() == null) {
                return false;
            }
            for (ILooperRegister iLooperRegister : this.mLooperMonitordList.getList()) {
                if (iLooperRegister != null && iLooperRegister.checkEnable()) {
                    if (AppConfig.isDebug()) {
                        Log.d(BlockMonitor.TAG, "enableLooper = true");
                        return true;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ic1<ILooperRegister> getLooperMonitorList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mLooperMonitordList : (ic1) invokeV.objValue;
    }

    public ILooperNeedContext getLooperNeedContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mLooperNeedContext.get() : (ILooperNeedContext) invokeV.objValue;
    }

    public ILooperUIContext getLooperUIContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            hc1<ILooperUIContext> hc1Var = this.mLooperUIContext;
            if (hc1Var == null) {
                return EMPTY_RUKA_UI_CONTEXT;
            }
            return hc1Var.get();
        }
        return (ILooperUIContext) invokeV.objValue;
    }

    public void initmLooperMonitordList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            gc1 b = gc1.b();
            this.mLooperMonitordList = b;
            b.a(new ILooperRegister_LooperRuntime_ListProvider());
        }
    }

    public void initmLooperNeedContext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            fc1 b = fc1.b();
            this.mLooperNeedContext = b;
            b.a(new ILooperNeedContext_LooperRuntime_Provider());
        }
    }
}
