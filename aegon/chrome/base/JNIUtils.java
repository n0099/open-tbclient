package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class JNIUtils {
    public static /* synthetic */ Interceptable $ic;
    public static ClassLoader sJniClassLoader;
    public static Boolean sSelectiveJniRegistrationEnabled;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1419354163, "Laegon/chrome/base/JNIUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1419354163, "Laegon/chrome/base/JNIUtils;");
                return;
            }
        }
        JNIUtils.class.desiredAssertionStatus();
    }

    public JNIUtils() {
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
    public static Object getClassLoader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ClassLoader classLoader = sJniClassLoader;
            return classLoader == null ? JNIUtils.class.getClassLoader() : classLoader;
        }
        return invokeV.objValue;
    }

    @CalledByNative
    public static boolean isSelectiveJniRegistrationEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (sSelectiveJniRegistrationEnabled == null) {
                sSelectiveJniRegistrationEnabled = Boolean.FALSE;
            }
            return sSelectiveJniRegistrationEnabled.booleanValue();
        }
        return invokeV.booleanValue;
    }
}
