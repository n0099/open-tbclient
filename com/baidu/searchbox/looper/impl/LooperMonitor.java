package com.baidu.searchbox.looper.impl;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.ruka.ioc.ILooperMonitor;
import com.baidu.searchbox.track.Track;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bj9;
import com.repackage.cj9;
import com.repackage.dj9;
@Singleton
@Service
/* loaded from: classes2.dex */
public class LooperMonitor implements ILooperMonitor {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean sIsStartTrack;
    public static LooperContextDispatcher sLooperContextDispatcher;
    public transient /* synthetic */ FieldHolder $fh;
    public cj9 mBlockCanaryCore;
    public boolean mMonitorStarted;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1032636733, "Lcom/baidu/searchbox/looper/impl/LooperMonitor;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1032636733, "Lcom/baidu/searchbox/looper/impl/LooperMonitor;");
        }
    }

    public LooperMonitor() {
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
        this.mMonitorStarted = false;
    }

    private void startLooperPrint() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || this.mMonitorStarted) {
            return;
        }
        this.mMonitorStarted = true;
        sLooperContextDispatcher.addLooperPrinter(this.mBlockCanaryCore.g());
    }

    public static void startTrack(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, context) == null) || sIsStartTrack) {
            return;
        }
        sIsStartTrack = true;
        Track.getInstance().startTrack(context);
    }

    public void addBlockInterceptor(dj9 dj9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dj9Var) == null) || dj9Var == null) {
            return;
        }
        this.mBlockCanaryCore.b(dj9Var);
    }

    @Override // com.baidu.searchbox.ruka.ioc.ILooperMonitor
    public boolean enableMonitor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? LooperRuntime.getInstance().enableLooper() : invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.ruka.ioc.ILooperMonitor
    public boolean isMonitorStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mMonitorStarted : invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.ruka.ioc.ILooperMonitor
    public void startLooperMonitor(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, context, i) == null) {
            if (sLooperContextDispatcher == null) {
                sLooperContextDispatcher = new LooperContextDispatcher();
            }
            bj9.init(context, sLooperContextDispatcher, i);
            cj9.k(bj9.get());
            cj9 e = cj9.e();
            this.mBlockCanaryCore = e;
            e.b(bj9.get());
            startLooperPrint();
            startTrack(context);
        }
    }

    @Override // com.baidu.searchbox.ruka.ioc.ILooperMonitor
    public void stopLooperMonitor() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.mMonitorStarted) {
            this.mMonitorStarted = false;
            sLooperContextDispatcher.removeLooperPrinter(this.mBlockCanaryCore.g());
            this.mBlockCanaryCore.j().d();
            this.mBlockCanaryCore.d().d();
        }
    }
}
