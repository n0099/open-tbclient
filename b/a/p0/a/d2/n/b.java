package b.a.p0.a.d2.n;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f4505b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, g> f4506a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1895145019, "Lb/a/p0/a/d2/n/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1895145019, "Lb/a/p0/a/d2/n/b;");
                return;
            }
        }
        f4505b = k.f6863a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4506a = null;
    }

    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            File d2 = b.a.p0.a.w1.c.a.d(str2);
            if (d2 == null || !d2.exists()) {
                if (str.endsWith(File.separator)) {
                    d2 = new File(str + str2 + ".json");
                } else {
                    d2 = new File(str + File.separator + str2 + ".json");
                }
            }
            if (f4505b) {
                String str3 = "parseConfigFile baseUrl : " + str + " ,page: " + str2 + " file exist:" + d2.exists();
            }
            if (d2.exists()) {
                return b.a.p0.a.a1.d.m(d2);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public g a(String str, @NonNull String str2, @NonNull g gVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, gVar)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return gVar;
            }
            g d2 = d(str, str2, gVar);
            this.f4506a.put(str2, d2);
            return d2;
        }
        return (g) invokeLLL.objValue;
    }

    public g b(String str, String str2, @NonNull g gVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, gVar)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return gVar;
            }
            if (this.f4506a == null) {
                this.f4506a = new TreeMap();
            }
            g gVar2 = this.f4506a.get(str2);
            if (gVar2 != null) {
                return gVar2;
            }
            g d2 = d(str, str2, gVar);
            this.f4506a.put(str2, d2);
            return d2;
        }
        return (g) invokeLLL.objValue;
    }

    public final g d(String str, String str2, @NonNull g gVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, gVar)) == null) {
            String c2 = c(str, str2);
            return TextUtils.isEmpty(c2) ? gVar : g.b(c2, gVar);
        }
        return (g) invokeLLL.objValue;
    }
}
