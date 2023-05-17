package com.baidu.android.util.media;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Deprecated
/* loaded from: classes.dex */
public final class WebpUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE_IMG_WEBP = "webp";
    public static final String TYPE_PARAM_H5 = "imgtype";
    public static final String TYPE_PARAM_NA = "imgtype";
    public transient /* synthetic */ FieldHolder $fh;

    @Deprecated
    public static boolean isNAUseWebp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public WebpUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Deprecated
    public static boolean isWebKitSupportWebp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return isNAUseWebp();
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public static String addH5WebpParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return addParam(str, "imgtype", TYPE_IMG_WEBP);
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static String addNAWebpParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return addParam(str, "imgtype", TYPE_IMG_WEBP);
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static String deleteH5WebpParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            HashSet hashSet = new HashSet();
            hashSet.add("imgtype");
            return deleteParam(str, hashSet);
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static String deleteNAWebpParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            HashSet hashSet = new HashSet();
            hashSet.add("imgtype");
            return deleteParam(str, hashSet);
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static String addParam(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        StringBuilder sb;
        StringBuilder sb2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String str4 = str2 + "=";
            int indexOf = str.indexOf("?");
            String str5 = null;
            if (indexOf < 0) {
                int indexOf2 = str.indexOf("#");
                if (indexOf2 < 0) {
                    sb2 = new StringBuilder(str);
                } else {
                    str5 = str.substring(indexOf2);
                    sb2 = new StringBuilder(str.substring(0, indexOf2));
                }
                sb2.append("?");
                sb2.append(str4);
                sb2.append(str3);
                if (str5 != null) {
                    sb2.append(str5);
                }
                return sb2.toString();
            }
            if (str.indexOf("&" + str4, indexOf) < 0) {
                if (str.indexOf("?" + str4, indexOf) < 0) {
                    int indexOf3 = str.indexOf("#");
                    if (indexOf3 < 0) {
                        sb = new StringBuilder(str);
                    } else {
                        str5 = str.substring(indexOf3);
                        str = str.substring(0, indexOf3);
                        sb = new StringBuilder(str);
                    }
                    if (!str.endsWith("&") && !str.endsWith("?")) {
                        sb.append("&");
                    }
                    sb.append(str4);
                    sb.append(str3);
                    if (str5 != null) {
                        sb.append(str5);
                    }
                    return sb.toString();
                }
                return str;
            }
            return str;
        }
        return (String) invokeLLL.objValue;
    }

    @Deprecated
    public static String addParam(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, map)) == null) {
            if (!TextUtils.isEmpty(str)) {
                String mapToString = mapToString(map);
                if (!TextUtils.isEmpty(mapToString)) {
                    if (str.contains("?")) {
                        return str + "&" + mapToString;
                    }
                    return str + "?" + mapToString;
                }
                return str;
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    @Deprecated
    public static String deleteParam(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, set)) == null) {
            if (!TextUtils.isEmpty(str) && str.startsWith("http") && set != null && set.size() != 0) {
                String str2 = null;
                try {
                    str2 = new URL(str).getQuery();
                } catch (MalformedURLException unused) {
                }
                if (TextUtils.isEmpty(str2)) {
                    return str;
                }
                CharSequence deleteQueryParam = deleteQueryParam(str2, set);
                if (TextUtils.isEmpty(deleteQueryParam)) {
                    return str;
                }
                return str.replace(str2, deleteQueryParam);
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    @Deprecated
    public static String deleteQueryParam(String str, Set<String> set) {
        InterceptResult invokeLL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, set)) == null) {
            if (TextUtils.isEmpty(str) || set == null || (split = str.split("&")) == null || split.length == 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : split) {
                String[] split2 = str2.split("=");
                if (split2.length > 0 && !set.contains(split2[0])) {
                    sb.append(str2);
                    sb.append("&");
                }
            }
            int length = sb.length();
            if (length > 0) {
                int i = length - 1;
                if (sb.charAt(i) == '&') {
                    sb.deleteCharAt(i);
                }
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    @Deprecated
    public static String mapToString(Map<String, String> map) {
        InterceptResult invokeL;
        String encode;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, map)) == null) {
            if (map == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : map.keySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                String str3 = map.get(str2);
                if (str2 == null) {
                    encode = "";
                } else {
                    try {
                        encode = URLEncoder.encode(str2, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException("This method requires UTF-8 encoding support", e);
                    }
                }
                sb.append(encode);
                sb.append("=");
                if (str3 == null) {
                    str = "";
                } else {
                    str = URLEncoder.encode(str3, "UTF-8");
                }
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
