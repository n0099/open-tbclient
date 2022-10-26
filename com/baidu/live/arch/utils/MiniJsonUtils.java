package com.baidu.live.arch.utils;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0004\u001a\u00020\u00022\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ#\u0010\f\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/baidu/live/arch/utils/MiniJsonUtils;", "", "", "params", "bundleToJsonStr", "(Ljava/util/Map;)Ljava/lang/String;", "url", "Lorg/json/JSONObject;", "paramsToJson", "(Ljava/lang/String;)Lorg/json/JSONObject;", "parent", "key", "parseJSONObject", "(Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;", "<init>", "()V", "lib-live-mini-arch_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MiniJsonUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final MiniJsonUtils INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-761658133, "Lcom/baidu/live/arch/utils/MiniJsonUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-761658133, "Lcom/baidu/live/arch/utils/MiniJsonUtils;");
                return;
            }
        }
        INSTANCE = new MiniJsonUtils();
    }

    public MiniJsonUtils() {
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

    public final String bundleToJsonStr(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
            if (map != null && !map.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                for (String str : map.keySet()) {
                    try {
                        jSONObject.put(str, map.get(str));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "paramsJson.toString()");
                return jSONObject2;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public final JSONObject paramsToJson(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str != null) {
                JSONObject jSONObject = new JSONObject();
                Uri uri = Uri.parse(str);
                Intrinsics.checkExpressionValueIsNotNull(uri, "uri");
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null && (!queryParameterNames.isEmpty())) {
                    for (String str2 : queryParameterNames) {
                        jSONObject.put(str2, uri.getQueryParameter(str2));
                    }
                }
                return jSONObject;
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final JSONObject parseJSONObject(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str)) == null) {
            if (jSONObject != null && str != null && jSONObject.has(str)) {
                Object opt = jSONObject.opt(str);
                if (opt instanceof String) {
                    try {
                        return new JSONObject(jSONObject.optString(str));
                    } catch (JSONException unused) {
                    }
                } else if (opt instanceof JSONObject) {
                    return (JSONObject) opt;
                }
            }
            return null;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
