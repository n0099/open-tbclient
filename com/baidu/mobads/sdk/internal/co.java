package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes3.dex */
public class co {
    public static /* synthetic */ Interceptable $ic;
    public static volatile co a;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean b;
    public boolean c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1833694819, "Lcom/baidu/mobads/sdk/internal/co;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1833694819, "Lcom/baidu/mobads/sdk/internal/co;");
        }
    }

    public co() {
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

    public static co a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (co.class) {
                    if (a == null) {
                        a = new co();
                    }
                }
            }
            return a;
        }
        return (co) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    private Boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, str2)) == null) {
            boolean z = false;
            if (str != null && str.trim().toLowerCase(Locale.getDefault()).indexOf(str2) == 0) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeLL.objValue;
    }

    public Boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return a(str, UrlSchemaHelper.SCHEMA_TYPE_HTTP);
        }
        return (Boolean) invokeL.objValue;
    }

    public Boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return a(str, UrlSchemaHelper.SCHEMA_TYPE_HTTPS);
        }
        return (Boolean) invokeL.objValue;
    }

    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (this.b && a(str).booleanValue()) {
                return str.replaceFirst("(?i)http", "https");
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            try {
                String path = new URI(str).getPath();
                return path.substring(path.lastIndexOf(47) + 1, path.length());
            } catch (URISyntaxException unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.contains("/thefatherofsalmon.com")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            new am(str).b();
        }
    }

    public String a(String str, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            StringBuilder sb = new StringBuilder(str);
            if (hashMap != null && !hashMap.isEmpty()) {
                sb.append("?");
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    try {
                        sb.append(entry.getKey());
                        sb.append("=");
                        sb.append(entry.getValue());
                        sb.append("&");
                    } catch (Exception e) {
                        br.a().c(e);
                    }
                }
                String sb2 = sb.toString();
                return sb2.substring(0, sb2.length() - 1);
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public HttpURLConnection a(URL url) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, url)) == null) {
            if (url.getProtocol().toLowerCase().equals("https")) {
                return (HttpsURLConnection) url.openConnection();
            }
            return (HttpURLConnection) url.openConnection();
        }
        return (HttpURLConnection) invokeL.objValue;
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.b = z;
        }
    }

    public void a(HttpURLConnection httpURLConnection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, httpURLConnection) == null) && httpURLConnection != null) {
            try {
                httpURLConnection.getInputStream().close();
            } catch (Throwable unused) {
            }
            try {
                httpURLConnection.getOutputStream().close();
            } catch (Throwable unused2) {
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused3) {
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.c = z;
        }
    }

    public Boolean d(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (!a(str, UrlSchemaHelper.SCHEMA_TYPE_SMS).booleanValue() && !a(str, "smsto:").booleanValue() && !a(str, "mms:").booleanValue()) {
                z = false;
            } else {
                z = true;
            }
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeL.objValue;
    }

    public String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (str == null) {
                return null;
            }
            if (a(str).booleanValue() || b(str).booleanValue()) {
                return str.split("\\?")[0];
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public String h(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (str == null) {
                return null;
            }
            if (!a(str).booleanValue() && !b(str).booleanValue()) {
                split = null;
            } else {
                split = str.split("\\?");
            }
            if (split == null || split.length < 2) {
                return null;
            }
            return split[1];
        }
        return (String) invokeL.objValue;
    }
}
