package aegon.chrome.base;

import android.os.StrictMode;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
/* loaded from: classes.dex */
public final class StrictModeContext implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final StrictMode.ThreadPolicy mThreadPolicy;
    public final StrictMode.VmPolicy mVmPolicy;

    public StrictModeContext(StrictMode.ThreadPolicy threadPolicy) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadPolicy};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mThreadPolicy = threadPolicy;
        this.mVmPolicy = null;
    }

    public StrictModeContext(StrictMode.ThreadPolicy threadPolicy, StrictMode.VmPolicy vmPolicy) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadPolicy, vmPolicy};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mThreadPolicy = threadPolicy;
        this.mVmPolicy = vmPolicy;
    }

    public static StrictModeContext allowAllVmPolicies() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
            StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
            return new StrictModeContext(null, vmPolicy);
        }
        return (StrictModeContext) invokeV.objValue;
    }

    public static StrictModeContext allowDiskReads() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new StrictModeContext(StrictMode.allowThreadDiskReads()) : (StrictModeContext) invokeV.objValue;
    }

    public static StrictModeContext allowDiskWrites() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? new StrictModeContext(StrictMode.allowThreadDiskWrites()) : (StrictModeContext) invokeV.objValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StrictMode.ThreadPolicy threadPolicy = this.mThreadPolicy;
            if (threadPolicy != null) {
                StrictMode.setThreadPolicy(threadPolicy);
            }
            StrictMode.VmPolicy vmPolicy = this.mVmPolicy;
            if (vmPolicy != null) {
                StrictMode.setVmPolicy(vmPolicy);
            }
        }
    }
}
