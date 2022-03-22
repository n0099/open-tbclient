package com.baidu.tbadk.core.util.schemeaction;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class SchemeActionHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SchemeActionHelper() {
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

    public static JSONObject getParams(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, uri)) == null) {
            if (uri == null) {
                return new JSONObject();
            }
            String queryParameter = uri.getQueryParameter("params");
            if (m.isEmpty(queryParameter)) {
                return new JSONObject();
            }
            try {
                return new JSONObject(queryParameter);
            } catch (Exception unused) {
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static String getSafeQueryParameter(Uri uri, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, uri, str)) == null) {
            try {
                return uri.getQueryParameter(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String getSchemeAction(UriBuilder uriBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, uriBuilder)) == null) {
            if (uriBuilder == null || !uriBuilder.isValidated()) {
                return null;
            }
            return parserSchemeAction(uriBuilder.getUriString());
        }
        return (String) invokeL.objValue;
    }

    public static String getSchemeHeaderFromLink(String str) {
        InterceptResult invokeL;
        String[] split;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (m.isEmpty(str) || (split = str.split("\\:\\/\\/")) == null || split.length == 0 || (str2 = split[0]) == null || str2.length() <= 0) {
                return null;
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static String getValueFromParams(Uri uri, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, uri, str)) == null) {
            JSONObject params = getParams(uri);
            return params != null ? params.optString(str, "") : "";
        }
        return (String) invokeLL.objValue;
    }

    public static boolean isSchemeAction(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) {
            if (m.isEmpty(str)) {
                return false;
            }
            String parserSchemeAction = parserSchemeAction(str);
            if (m.isEmpty(parserSchemeAction)) {
                return false;
            }
            return str2.equalsIgnoreCase(parserSchemeAction);
        }
        return invokeLL.booleanValue;
    }

    public static boolean isTieBaAppSchemeHeader(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? !m.isEmpty(str) && str.startsWith("tiebaapp") : invokeL.booleanValue;
    }

    public static String parserSchemeAction(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (m.isEmpty(str)) {
                return null;
            }
            String[] split = str.split("\\?");
            if (split == null || split.length == 0) {
                return str;
            }
            String str2 = split[0];
            String[] split2 = str2.split("\\/\\/");
            if (split2 == null || split2.length < 2) {
                return null;
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static void printLog(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, str) == null) && TbadkCoreApplication.getInst().isDebugMode()) {
            Log.d("TiebaSchemeAction", str);
        }
    }

    public static Uri replaceUriParameter(Uri uri, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, uri, str, str2)) == null) {
            if (uri == null || TextUtils.isEmpty(str)) {
                return null;
            }
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            Uri.Builder clearQuery = uri.buildUpon().clearQuery();
            for (String str3 : queryParameterNames) {
                clearQuery.appendQueryParameter(str3, str3.equals(str) ? str2 : uri.getQueryParameter(str3));
            }
            return clearQuery.build();
        }
        return (Uri) invokeLLL.objValue;
    }

    public static String replaceUrlParameter(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Uri replaceUriParameter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, str, str2, str3)) == null) {
            if (str == null || TextUtils.isEmpty(str2) || (replaceUriParameter = replaceUriParameter(Uri.parse(str), str2, str3)) == null) {
                return null;
            }
            return replaceUriParameter.toString();
        }
        return (String) invokeLLL.objValue;
    }
}
