package aegon.chrome.net.impl;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class VersionSafeCallbacks$NetworkQualityRttListenerWrapper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final VersionSafeCallbacks$NetworkQualityRttListenerWrapper mWrappedListener;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == null || !(obj instanceof VersionSafeCallbacks$NetworkQualityRttListenerWrapper)) {
                return false;
            }
            return this.mWrappedListener.equals(((VersionSafeCallbacks$NetworkQualityRttListenerWrapper) obj).mWrappedListener);
        }
        return invokeL.booleanValue;
    }

    public Executor getExecutor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mWrappedListener.getExecutor() : (Executor) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mWrappedListener.hashCode() : invokeV.intValue;
    }

    public void onRttObservation(int i2, long j, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3)}) == null) {
            this.mWrappedListener.onRttObservation(i2, j, i3);
        }
    }
}
