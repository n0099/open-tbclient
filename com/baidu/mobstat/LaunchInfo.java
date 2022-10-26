package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LaunchInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;

    public LaunchInfo() {
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

    public String getPushContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!TextUtils.isEmpty(this.b)) {
                return this.b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public String getPushLandingPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!TextUtils.isEmpty(this.a)) {
                return this.a;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public String getRefererPkgName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!TextUtils.isEmpty(this.c)) {
                return this.c;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static JSONObject getConvertedJson(int i, String str, String str2) {
        InterceptResult invokeILL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65537, null, i, str, str2)) == null) {
            JSONObject jSONObject2 = null;
            try {
                jSONObject = new JSONObject();
            } catch (Exception unused) {
            }
            try {
                jSONObject.put("type", String.valueOf(i));
                if (str == null) {
                    str = "";
                }
                jSONObject.put(Config.LAUNCH_REFERER, str);
                if (str2 == null) {
                    str2 = "";
                }
                jSONObject.put("info", str2);
                jSONObject.put("content", "");
                return jSONObject;
            } catch (Exception unused2) {
                jSONObject2 = jSONObject;
                return jSONObject2;
            }
        }
        return (JSONObject) invokeILL.objValue;
    }

    public static String getLauncherHomePkgName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            String a = bi.a(context);
            if (TextUtils.isEmpty(a)) {
                return "";
            }
            return a;
        }
        return (String) invokeL.objValue;
    }

    public void setRefererPkgName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.c = str;
        }
    }

    public int getLaunchType(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (!TextUtils.isEmpty(this.a)) {
                return 2;
            }
            if (context != null) {
                str = context.getPackageName();
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(this.c) && !this.c.equals(str)) {
                String a = bi.a(context);
                if (!TextUtils.isEmpty(a)) {
                    if (!this.c.equals(a)) {
                        return 1;
                    }
                    return 0;
                } else if (!bi.a(context, this.c)) {
                    return 1;
                } else {
                    return 0;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public void setPushInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.a = str;
            this.b = bx.a(str2, 1024);
        }
    }
}
