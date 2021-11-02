package com.baidu.mobads.sdk.internal;

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
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes7.dex */
public class XAdURIUtils {
    public static /* synthetic */ Interceptable $ic;
    public static volatile XAdURIUtils shareInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mLpMultiProcess;
    public boolean mSupportHttps;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1705476281, "Lcom/baidu/mobads/sdk/internal/XAdURIUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1705476281, "Lcom/baidu/mobads/sdk/internal/XAdURIUtils;");
        }
    }

    public XAdURIUtils() {
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

    public static XAdURIUtils getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (shareInstance == null) {
                synchronized (XAdURIUtils.class) {
                    if (shareInstance == null) {
                        shareInstance = new XAdURIUtils();
                    }
                }
            }
            return shareInstance;
        }
        return (XAdURIUtils) invokeV.objValue;
    }

    private Boolean isXProtocol(String str, String str2) {
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

    public String addParameters(String str, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, hashMap)) == null) {
            StringBuilder sb = new StringBuilder(str);
            if (hashMap != null && !hashMap.isEmpty()) {
                sb.append("?");
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    try {
                        sb.append(entry.getKey());
                        sb.append("=");
                        sb.append(entry.getValue());
                        sb.append("&");
                    } catch (Exception e2) {
                        XAdLogger.getInstance().e(e2);
                    }
                }
                String sb2 = sb.toString();
                return sb2.substring(0, sb2.length() - 1);
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public void closeHttpURLConnection(HttpURLConnection httpURLConnection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpURLConnection) == null) || httpURLConnection == null) {
            return;
        }
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

    public String getFileName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                String path = new URI(str).getPath();
                return path.substring(path.lastIndexOf(47) + 1, path.length());
            } catch (URISyntaxException unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public String getFixedString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (str == null) {
                return null;
            }
            return (isHttpProtocol(str).booleanValue() || isHttpsProtocol(str).booleanValue()) ? str.split("\\?")[0] : str;
        }
        return (String) invokeL.objValue;
    }

    public HttpURLConnection getHttpURLConnection(URL url) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, url)) == null) {
            if (url.getProtocol().toLowerCase().equals("https")) {
                SslUtils.ignoreSsl();
                return (HttpsURLConnection) url.openConnection();
            }
            return (HttpURLConnection) url.openConnection();
        }
        return (HttpURLConnection) invokeL.objValue;
    }

    public boolean getLpMultiProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mLpMultiProcess : invokeV.booleanValue;
    }

    public String getQueryString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (str == null) {
                return null;
            }
            String[] split = (isHttpProtocol(str).booleanValue() || isHttpsProtocol(str).booleanValue()) ? str.split("\\?") : null;
            if (split == null || split.length < 2) {
                return null;
            }
            return split[1];
        }
        return (String) invokeL.objValue;
    }

    public Boolean isHttpProtocol(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? isXProtocol(str, UrlSchemaHelper.SCHEMA_TYPE_HTTP) : (Boolean) invokeL.objValue;
    }

    public Boolean isHttpsProtocol(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? isXProtocol(str, UrlSchemaHelper.SCHEMA_TYPE_HTTPS) : (Boolean) invokeL.objValue;
    }

    public Boolean isMessageProtocol(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            return Boolean.valueOf(isXProtocol(str, UrlSchemaHelper.SCHEMA_TYPE_SMS).booleanValue() || isXProtocol(str, "smsto:").booleanValue() || isXProtocol(str, "mms:").booleanValue());
        }
        return (Boolean) invokeL.objValue;
    }

    public String replaceURLWithSupportProtocol(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? (this.mSupportHttps && isHttpProtocol(str).booleanValue()) ? str.replaceFirst("(?i)http", "https") : str : (String) invokeL.objValue;
    }

    public void setHttps(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.mSupportHttps = z;
        }
    }

    public void setLpMultiProcess(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.mLpMultiProcess = z;
        }
    }
}
