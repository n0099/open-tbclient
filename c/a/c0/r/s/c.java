package c.a.c0.r.s;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.request.BodyStyle;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f1872g;

    /* renamed from: h  reason: collision with root package name */
    public static final c f1873h;
    public transient /* synthetic */ FieldHolder $fh;
    public BodyStyle a;

    /* renamed from: b  reason: collision with root package name */
    public String f1874b;

    /* renamed from: c  reason: collision with root package name */
    public String f1875c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f1876d;

    /* renamed from: e  reason: collision with root package name */
    public File f1877e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f1878f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1150041677, "Lc/a/c0/r/s/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1150041677, "Lc/a/c0/r/s/c;");
                return;
            }
        }
        byte[] bArr = new byte[0];
        f1872g = bArr;
        f1873h = c(null, bArr);
        a(null, "");
        b(null, new HashMap());
    }

    public c() {
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

    public static c a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            c cVar = new c();
            cVar.i(BodyStyle.STRING);
            cVar.g(str);
            cVar.f(str2);
            return cVar;
        }
        return (c) invokeLL.objValue;
    }

    public static c b(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, map)) == null) {
            c cVar = new c();
            cVar.i(BodyStyle.FORM);
            cVar.g(str);
            cVar.h(map);
            return cVar;
        }
        return (c) invokeLL.objValue;
    }

    public static c c(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, bArr)) == null) {
            c cVar = new c();
            cVar.i(BodyStyle.BYTE);
            cVar.g(str);
            cVar.e(bArr);
            return cVar;
        }
        return (c) invokeLL.objValue;
    }

    public static c d(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) ? c("application/octet-stream", bArr) : (c) invokeL.objValue;
    }

    public c e(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
            this.f1876d = bArr;
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.f1875c = str;
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.f1874b = str;
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c h(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, map)) == null) {
            this.f1878f = map;
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c i(BodyStyle bodyStyle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bodyStyle)) == null) {
            this.a = bodyStyle;
            return this;
        }
        return (c) invokeL.objValue;
    }
}
