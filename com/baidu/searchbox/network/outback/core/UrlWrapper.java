package com.baidu.searchbox.network.outback.core;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.internal.Util;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.text.Typography;
/* loaded from: classes2.dex */
public class UrlWrapper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String host;
    public HttpUrl httpUrl;
    public int port;
    public String scheme;
    public String url;

    public UrlWrapper(HttpUrl httpUrl) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpUrl};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setParams(httpUrl);
    }

    private void setParams(HttpUrl httpUrl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, httpUrl) == null) {
            this.scheme = httpUrl.scheme;
            this.host = httpUrl.host;
            this.port = httpUrl.port;
            this.url = httpUrl.toString();
            this.httpUrl = httpUrl;
        }
    }

    public int defaultPort(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str.equals("http")) {
                return 80;
            }
            if (str.equals("https")) {
                return 443;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public void setHttpUrl(HttpUrl httpUrl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, httpUrl) == null) {
            this.url = httpUrl.toString();
            this.httpUrl = httpUrl;
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.url = str;
        }
    }

    public UrlWrapper(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.url = str;
        partParse(str);
    }

    public String encodedPath(UrlWrapper urlWrapper) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, urlWrapper)) == null) {
            String urlWrapper2 = urlWrapper.toString();
            int indexOf = urlWrapper2.indexOf(47, urlWrapper.scheme().length() + 3);
            if (indexOf == -1) {
                return "/";
            }
            return urlWrapper2.substring(indexOf, delimiterOffset(urlWrapper2, indexOf, urlWrapper2.length(), "?#"));
        }
        return (String) invokeL.objValue;
    }

    private int delimiterOffset(String str, int i, int i2, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2})) == null) {
            while (i < i2) {
                if (str2.indexOf(str.charAt(i)) != -1) {
                    return i;
                }
                i++;
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    private int parsePort(String str, int i, int i2) {
        InterceptResult invokeLII;
        int parseInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, this, str, i, i2)) == null) {
            try {
                parseInt = Integer.parseInt(str.substring(i, i2));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }
        return invokeLII.intValue;
    }

    private int portColonOffset(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, this, str, i, i2)) == null) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != ':') {
                    if (charAt != '[') {
                        i++;
                    } else {
                        return -1;
                    }
                } else {
                    return i;
                }
            }
            return i2;
        }
        return invokeLII.intValue;
    }

    private int slashCount(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65543, this, str, i, i2)) == null) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }
        return invokeLII.intValue;
    }

    private int schemeDelimiterOffset(String str, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65541, this, str, i, i2)) == null) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }
        return invokeLII.intValue;
    }

    public HttpUrl getDefaultHttpUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.httpUrl;
        }
        return (HttpUrl) invokeV.objValue;
    }

    public HttpUrl getHttpUrl() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.httpUrl == null && (str = this.url) != null) {
                this.httpUrl = HttpUrl.get(str);
            }
            return this.httpUrl;
        }
        return (HttpUrl) invokeV.objValue;
    }

    public boolean isHttps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return scheme().equals("https");
        }
        return invokeV.booleanValue;
    }

    public int port() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i = this.port;
            if (i != -1) {
                return i;
            }
            HttpUrl httpUrl = this.httpUrl;
            if (httpUrl == null) {
                return -1;
            }
            int port = httpUrl.port();
            this.port = port;
            return port;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            String str = this.url;
            if (str == null) {
                HttpUrl httpUrl = this.httpUrl;
                if (httpUrl == null) {
                    return "";
                }
                return httpUrl.toString();
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public URL url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            HttpUrl httpUrl = this.httpUrl;
            if (httpUrl != null) {
                return httpUrl.url();
            }
            try {
                return new URL(this.url);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        return (URL) invokeV.objValue;
    }

    public String host() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!TextUtils.isEmpty(this.host)) {
                return this.host;
            }
            HttpUrl httpUrl = this.httpUrl;
            if (httpUrl != null) {
                String host = httpUrl.host();
                this.host = host;
                if (!TextUtils.isEmpty(host)) {
                    return this.host;
                }
            }
            throw new IllegalStateException("host == null");
        }
        return (String) invokeV.objValue;
    }

    public String scheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!TextUtils.isEmpty(this.scheme)) {
                return this.scheme;
            }
            HttpUrl httpUrl = this.httpUrl;
            if (httpUrl != null) {
                String scheme = httpUrl.scheme();
                this.scheme = scheme;
                if (!TextUtils.isEmpty(scheme)) {
                    return this.scheme;
                }
            }
            throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
        }
        return (String) invokeV.objValue;
    }

    public void partParse(String str) {
        int i;
        int delimiterOffset;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            int skipLeadingAsciiWhitespace = Util.skipLeadingAsciiWhitespace(str, 0, str.length());
            int skipTrailingAsciiWhitespace = Util.skipTrailingAsciiWhitespace(str, skipLeadingAsciiWhitespace, str.length());
            int schemeDelimiterOffset = schemeDelimiterOffset(str, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace);
            if (schemeDelimiterOffset != -1) {
                String substring = str.substring(skipLeadingAsciiWhitespace, schemeDelimiterOffset);
                this.scheme = substring;
                if (substring.equals("https")) {
                    i = skipLeadingAsciiWhitespace + 6;
                } else if (this.scheme.equals("http")) {
                    i = skipLeadingAsciiWhitespace + 5;
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, schemeDelimiterOffset) + "'");
                }
                int slashCount = slashCount(str, i, skipTrailingAsciiWhitespace);
                if (slashCount >= 2) {
                    int i2 = i + slashCount;
                    do {
                        delimiterOffset = delimiterOffset(str, i2, skipTrailingAsciiWhitespace, "/\\");
                        if (delimiterOffset != skipTrailingAsciiWhitespace) {
                            c = str.charAt(delimiterOffset);
                        } else {
                            c = 65535;
                        }
                        if (c == 65535 || c == '/') {
                            break;
                        }
                    } while (c != '\\');
                    int portColonOffset = portColonOffset(str, i2, delimiterOffset);
                    if (portColonOffset == -1) {
                        setParams(HttpUrl.get(this.url));
                        return;
                    }
                    int i3 = portColonOffset + 1;
                    if (i3 < delimiterOffset) {
                        this.host = str.substring(i2, portColonOffset);
                        this.port = parsePort(str, i3, delimiterOffset);
                    } else {
                        this.host = str.substring(i2, portColonOffset);
                        this.port = defaultPort(this.scheme);
                    }
                    String str2 = this.host;
                    if (str2 != null) {
                        int length = str2.length();
                        for (int i4 = 0; i4 < length; i4++) {
                            char charAt = this.host.charAt(i4);
                            if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                                setParams(HttpUrl.get(this.url));
                                return;
                            }
                        }
                        return;
                    }
                    throw new IllegalArgumentException("Invalid URL hos: \"" + str.substring(i2, portColonOffset) + Typography.quote);
                }
                return;
            }
            throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
        }
    }

    public String redact() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.port != defaultPort(this.scheme)) {
                return this.scheme + "://" + this.host + ":" + this.port + "/...";
            }
            return this.scheme + "://" + this.host + "/...";
        }
        return (String) invokeV.objValue;
    }
}
