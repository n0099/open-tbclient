package com.baidu.mobads.container.error;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class XAdErrorCodeTransformer {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, String> errorMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1397948094, "Lcom/baidu/mobads/container/error/XAdErrorCodeTransformer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1397948094, "Lcom/baidu/mobads/container/error/XAdErrorCodeTransformer;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        errorMap = hashMap;
        hashMap.put("0100000", "请求错误");
        errorMap.put("0101000", "广告配置缺失");
        errorMap.put("0101001", "广告配置缺失");
        errorMap.put("0101002", "广告配置缺失");
        errorMap.put("0101003", "广告配置错误");
        errorMap.put("0101004", "广告配置错误");
        errorMap.put("0101005", "广告配置错误");
        errorMap.put("0103000", "无广告返回");
        errorMap.put("0103010", "APPSID缺失");
        errorMap.put("0103011", "APPSID失效或错误");
        errorMap.put("0103012", "APPSID失效或错误");
        errorMap.put("0103020", "APPSID失效或错误");
        errorMap.put("0103030", "无广告返回");
        errorMap.put("0103040", "无广告返回");
        errorMap.put("0103050", "无广告返回");
        errorMap.put("0103060", "应用包名信息错误，请保证注册包名和实际请求包名一致");
        errorMap.put("0104000", "无广告返回");
        errorMap.put("0104010", "无广告返回");
        errorMap.put("0104011", "无广告返回");
        errorMap.put("0104020", "无广告返回");
        errorMap.put("0104021", "无广告返回");
        errorMap.put("0104030", "无广告返回");
        errorMap.put("0104040", "无广告返回");
        errorMap.put("0104050", "无广告返回");
        errorMap.put("0104060", "无广告返回");
        errorMap.put("0104070", "无广告返回");
        errorMap.put("0104071", "无广告返回");
        errorMap.put("0104080", "无广告返回");
        errorMap.put("0104081", "无广告返回");
        errorMap.put("0104090", "无广告返回");
        errorMap.put("0104100", "无广告返回");
        errorMap.put("0104110", "无广告返回");
        errorMap.put("0105000", "无广告返回");
        errorMap.put("0105010", "无广告返回");
        errorMap.put("0105011", "无广告返回");
        errorMap.put("0105020", "无广告返回");
        errorMap.put("0105021", "无广告返回");
        errorMap.put("0105030", "无广告返回");
        errorMap.put("0105031", "无广告返回");
        errorMap.put("0105040", "无广告返回");
        errorMap.put("0105041", "无广告返回");
        errorMap.put("0105050", "无广告返回");
        errorMap.put("0105060", "无广告返回");
        errorMap.put("0105070", "无广告返回");
        errorMap.put("0106000", "无广告返回");
        errorMap.put("0106001", "无广告返回");
        errorMap.put("0106010", "无广告返回");
        errorMap.put("0106020", "无广告返回");
        errorMap.put("0106030", "无广告返回");
        errorMap.put("0107000", "广告位ID缺失");
        errorMap.put("0107001", "广告位ID错误或失效");
        errorMap.put("0107002", "广告位ID错误或失效");
        errorMap.put("0107003", "广告位ID与APPSID不匹配");
        errorMap.put("0107010", "广告位信息缺失");
        errorMap.put("0107020", "广告位信息缺失");
        errorMap.put("0107030", "广告位信息缺失");
        errorMap.put("0107040", "广告位信息缺失");
        errorMap.put("0107050", "视频无法播放");
        errorMap.put("0107051", "视频信息错误");
        errorMap.put("0107052", "广告位尺寸和MSSP注册尺寸不符");
        errorMap.put("0200000", "无广告返回");
        errorMap.put("0201000", "无广告返回");
        errorMap.put("0201010", "广告信息错误");
        errorMap.put("0201020", "广告信息错误");
        errorMap.put("0201021", "广告信息错误");
        errorMap.put("0201030", "广告信息错误");
        errorMap.put("0201031", "广告信息错误");
        errorMap.put("0201040", "广告信息错误");
        errorMap.put("0201050", "广告信息错误");
        errorMap.put("0201060", "广告信息错误");
        errorMap.put("0201070", "广告信息错误");
        errorMap.put("0201080", "广告信息错误");
        errorMap.put("0201090", "广告信息错误");
        errorMap.put("0201100", "广告信息错误");
        errorMap.put("0201110", "广告信息错误");
    }

    public XAdErrorCodeTransformer() {
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

    public static String errorCodeConvert(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && str.length() == 6) {
                return "0" + str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String errorMsg(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (str.length() == 6) {
                str = "0" + str;
            }
            String str2 = errorMap.get(str);
            return str2 == null ? "" : str2;
        }
        return (String) invokeL.objValue;
    }
}
