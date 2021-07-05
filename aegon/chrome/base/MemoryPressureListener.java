package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import aegon.chrome.base.memory.MemoryPressureCallback;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class MemoryPressureListener {
    public static /* synthetic */ Interceptable $ic;
    public static final ObserverList<MemoryPressureCallback> sCallbacks;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(394459103, "Laegon/chrome/base/MemoryPressureListener;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(394459103, "Laegon/chrome/base/MemoryPressureListener;");
                return;
            }
        }
        sCallbacks = new ObserverList<>();
    }

    public MemoryPressureListener() {
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

    @CalledByNative
    public static void addNativeCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            sCallbacks.addObserver(MemoryPressureListener$$Lambda$1.$ic);
        }
    }

    public static native void nativeOnMemoryPressure(int i2);
}
