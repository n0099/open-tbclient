package c.a.b0.u.s;

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
    public static final byte[] f2025g;

    /* renamed from: h  reason: collision with root package name */
    public static final c f2026h;
    public transient /* synthetic */ FieldHolder $fh;
    public BodyStyle a;

    /* renamed from: b  reason: collision with root package name */
    public String f2027b;

    /* renamed from: c  reason: collision with root package name */
    public String f2028c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f2029d;

    /* renamed from: e  reason: collision with root package name */
    public File f2030e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f2031f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1251583703, "Lc/a/b0/u/s/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1251583703, "Lc/a/b0/u/s/c;");
                return;
            }
        }
        byte[] bArr = new byte[0];
        f2025g = bArr;
        f2026h = d(null, bArr);
        b(null, "");
        c(null, new HashMap());
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

    public static c b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            c cVar = new c();
            cVar.k(BodyStyle.STRING);
            cVar.i(str);
            cVar.h(str2);
            return cVar;
        }
        return (c) invokeLL.objValue;
    }

    public static c c(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, map)) == null) {
            c cVar = new c();
            cVar.k(BodyStyle.FORM);
            cVar.i(str);
            cVar.j(map);
            return cVar;
        }
        return (c) invokeLL.objValue;
    }

    public static c d(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, bArr)) == null) {
            c cVar = new c();
            cVar.k(BodyStyle.BYTE);
            cVar.i(str);
            cVar.g(bArr);
            return cVar;
        }
        return (c) invokeLL.objValue;
    }

    public static c e(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, map)) == null) ? c("application/x-www-form-urlencoded", map) : (c) invokeL.objValue;
    }

    public static c f(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) ? d("application/octet-stream", bArr) : (c) invokeL.objValue;
    }

    public c a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (this.f2031f == null) {
                this.f2031f = new HashMap();
            }
            this.f2031f.put(str, str2);
            return this;
        }
        return (c) invokeLL.objValue;
    }

    public c g(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
            this.f2029d = bArr;
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.f2028c = str;
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.f2027b = str;
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c j(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, map)) == null) {
            this.f2031f = map;
            return this;
        }
        return (c) invokeL.objValue;
    }

    public c k(BodyStyle bodyStyle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bodyStyle)) == null) {
            this.a = bodyStyle;
            return this;
        }
        return (c) invokeL.objValue;
    }
}
