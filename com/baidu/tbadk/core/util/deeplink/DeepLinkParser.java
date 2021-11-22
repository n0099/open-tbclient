package com.baidu.tbadk.core.util.deeplink;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.k;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class DeepLinkParser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public DeepLinkParser() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getActionFromScheme(String str) {
        InterceptResult invokeL;
        String[] split;
        String[] split2;
        String[] split3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (k.isEmpty(str) || (split = str.split("\\?")) == null || split.length == 0 || (split2 = split[0].split("\\/\\/")) == null || split2.length < 2 || (split3 = split2[1].split("\\/")) == null || split2.length < 2) {
                return null;
            }
            return split3[split3.length - 1];
        }
        return (String) invokeL.objValue;
    }

    public static String getModuleFromScheme(String str) {
        InterceptResult invokeL;
        String[] split;
        String[] split2;
        String str2;
        String[] split3;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                if (!k.isEmpty(str) && (split = str.split("\\?")) != null && split.length != 0 && (split2 = split[0].split("\\/\\/")) != null && split2.length >= 2 && (split3 = (str2 = split2[1]).split("\\/")) != null && split2.length >= 2 && (str3 = split3[split3.length - 1]) != null && str3.length() != 0) {
                    return str2.substring(0, (str2.length() - str3.length()) - 1);
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2);
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static JSONObject getParams(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, uri)) == null) {
            if (uri == null) {
                return new JSONObject();
            }
            String queryParameter = uri.getQueryParameter("params");
            if (k.isEmpty(queryParameter)) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, uri, str)) == null) {
            try {
                return uri.getQueryParameter(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static void printLog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            TbadkCoreApplication.getInst().isDebugMode();
        }
    }
}
