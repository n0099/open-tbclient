package com.baidu.searchbox.ai;

import android.util.Log;
import com.baidu.android.util.soloader.SoLoader;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class Common {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "Common";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1785335005, "Lcom/baidu/searchbox/ai/Common;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1785335005, "Lcom/baidu/searchbox/ai/Common;");
        }
    }

    public Common() {
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

    public static native int getJniVersion();

    public static String getSDKVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                int jniVersion = getJniVersion();
                return "mml" + jniVersion;
            } catch (UnsatisfiedLinkError unused) {
                SoLoader.load(AppRuntime.getAppContext(), "protobuf-lite");
                SoLoader.load(AppRuntime.getAppContext(), "ai-entry");
                try {
                    int jniVersion2 = getJniVersion();
                    return "mml" + jniVersion2;
                } catch (Throwable unused2) {
                    return null;
                }
            } catch (Throwable th) {
                String str = TAG;
                Log.e(str, "invoke getJniVersion e: " + th.getLocalizedMessage());
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
