package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import dalvik.system.BaseDexClassLoader;
/* loaded from: classes.dex */
public class BundleUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean sIsBundle;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        boolean z;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(882062830, "Laegon/chrome/base/BundleUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(882062830, "Laegon/chrome/base/BundleUtils;");
                return;
            }
        }
        try {
            Class.forName("aegon.chrome.base.BundleCanary");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        sIsBundle = z;
    }

    public BundleUtils() {
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @CalledByNative
    public static String getNativeLibraryPath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, str)) != null) {
            return (String) invokeL.objValue;
        }
        StrictModeContext allowDiskReads = StrictModeContext.allowDiskReads();
        try {
            String findLibrary = ((BaseDexClassLoader) ContextUtils.sApplicationContext.getClassLoader()).findLibrary(str);
            allowDiskReads.close();
            return findLibrary;
        } finally {
        }
    }

    @CalledByNative
    public static boolean isBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? sIsBundle : invokeV.booleanValue;
    }
}
