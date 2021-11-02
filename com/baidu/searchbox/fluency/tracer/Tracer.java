package com.baidu.searchbox.fluency.tracer;

import androidx.annotation.CallSuper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.fluency.core.FrameRefreshMonitor;
import com.baidu.searchbox.fluency.utils.Logcat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/fluency/tracer/Tracer;", "Lcom/baidu/searchbox/fluency/tracer/ITracer;", "com/baidu/searchbox/fluency/core/FrameRefreshMonitor$FrameRefreshObserver", "", "isAlive", "()Z", "", "onAlive", "()V", "onCloseTrace", "onDead", "onStartTrace", "", "TAG", "Ljava/lang/String;", "Z", "<init>", "lib-fps_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public abstract class Tracer extends FrameRefreshMonitor.FrameRefreshObserver implements ITracer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public boolean isAlive;

    public Tracer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.TAG = "FrameRateTracer";
    }

    @Override // com.baidu.searchbox.fluency.tracer.ITracer
    public boolean isAlive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.isAlive : invokeV.booleanValue;
    }

    @CallSuper
    public void onAlive() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Logcat logcat = Logcat.INSTANCE;
            String str = this.TAG;
            logcat.d(str, "[onAlive] " + getClass().getName());
        }
    }

    @Override // com.baidu.searchbox.fluency.tracer.ITracer
    public void onCloseTrace() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.isAlive) {
            this.isAlive = false;
            onDead();
        }
    }

    @CallSuper
    public void onDead() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Logcat logcat = Logcat.INSTANCE;
            String str = this.TAG;
            logcat.d(str, "[onDead] " + getClass().getName());
        }
    }

    @Override // com.baidu.searchbox.fluency.tracer.ITracer
    public void onStartTrace() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.isAlive) {
            return;
        }
        this.isAlive = true;
        onAlive();
    }
}
