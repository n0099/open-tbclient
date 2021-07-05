package com.baidu.searchbox.pms.utils;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.File;
import java.util.Collection;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CommonUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "pmsCommonUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public CommonUtils() {
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

    public static void closeSafely(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
    }

    public static String createErrorJson(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, strArr)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (strArr != null) {
                try {
                    if (strArr.length > 0 && strArr.length % 2 == 0) {
                        for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                            String str = strArr[i2];
                            String str2 = strArr[i2 + 1];
                            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                                jSONObject.put(str, str2);
                            }
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return ",errmsg:" + jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getCpuAbi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? Build.CPU_ABI : (String) invokeV.objValue;
    }

    public static boolean isEmpty(Collection collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, collection)) == null) ? collection == null || collection.size() == 0 : invokeL.booleanValue;
    }

    public static String mergePath(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2)) == null) ? pathCombine(str, str2, File.separator) : (String) invokeLL.objValue;
    }

    public static String pathCombine(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            if (str.endsWith(str3)) {
                if (str2.startsWith(str3)) {
                    return str.concat(str2.substring(str3.length()));
                }
                return str.concat(str2);
            } else if (str2.startsWith(str3)) {
                return str.concat(str2);
            } else {
                return str.concat(str3).concat(str2);
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static void postThread(Runnable runnable, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, runnable, str) == null) {
            ExecutorUtilsExt.postOnElastic(runnable, str, 3);
        }
    }

    public static boolean isEmpty(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, map)) == null) ? map == null || map.size() == 0 : invokeL.booleanValue;
    }
}
