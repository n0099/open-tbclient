package com.baidu.platform.comapi.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.vi.VIContext;
/* loaded from: classes2.dex */
public class SysOSUtil {
    public static /* synthetic */ Interceptable $ic;
    public static SysOSUtil g;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.platform.comapi.util.a.b a;
    public com.baidu.platform.comapi.util.a.a b;
    public boolean c;
    public String d;
    public String e;
    public String f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-937703155, "Lcom/baidu/platform/comapi/util/SysOSUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-937703155, "Lcom/baidu/platform/comapi/util/SysOSUtil;");
                return;
            }
        }
        g = new SysOSUtil();
    }

    public static SysOSUtil getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return g;
        }
        return (SysOSUtil) invokeV.objValue;
    }

    public String getCompatibleSdcardPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            com.baidu.platform.comapi.util.a.b bVar = this.a;
            if (bVar != null) {
                return bVar.c();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public float getDensity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            com.baidu.platform.comapi.util.a.a aVar = this.b;
            if (aVar != null) {
                return aVar.c();
            }
            return 1.0f;
        }
        return invokeV.floatValue;
    }

    public int getDensityDPI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            com.baidu.platform.comapi.util.a.a aVar = this.b;
            if (aVar != null) {
                return aVar.d();
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public String getExternalFilesDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            com.baidu.platform.comapi.util.a.b bVar = this.a;
            if (bVar != null) {
                return bVar.e();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public String getGLRenderer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public String getGLVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public String getNetType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public String getOutputCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            com.baidu.platform.comapi.util.a.b bVar = this.a;
            if (bVar != null) {
                return bVar.d();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public String getOutputDirPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            com.baidu.platform.comapi.util.a.b bVar = this.a;
            if (bVar != null) {
                return bVar.a();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public int getScreenHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            com.baidu.platform.comapi.util.a.a aVar = this.b;
            if (aVar != null) {
                return aVar.b();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getScreenWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            com.baidu.platform.comapi.util.a.a aVar = this.b;
            if (aVar != null) {
                return aVar.a();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String getSdcardPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            com.baidu.platform.comapi.util.a.b bVar = this.a;
            if (bVar != null) {
                return bVar.b();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public SysOSUtil() {
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
        this.a = null;
        this.b = null;
        this.c = false;
        this.d = "";
        this.e = "";
        this.f = "";
    }

    public void init(com.baidu.platform.comapi.util.a.b bVar, com.baidu.platform.comapi.util.a.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, bVar, aVar) == null) && !this.c) {
            this.a = bVar;
            this.b = aVar;
            if (bVar == null) {
                this.a = new com.baidu.platform.comapi.util.a.b();
            }
            if (this.b == null) {
                this.b = new com.baidu.platform.comapi.util.a.a();
            }
            this.a.a(VIContext.getContext());
            this.b.a(VIContext.getContext());
            this.d = NetworkUtil.getCurrentNetMode(VIContext.getContext());
            this.c = true;
        }
    }

    public void setGLInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) {
            if (!this.f.equals(str2) || !this.e.equals(str)) {
                this.e = str;
                this.f = str2;
            }
        }
    }

    public void updateNetType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.d = str;
        }
    }
}
