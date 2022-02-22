package com.baidu.mobstat.dxmpay;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class LaunchInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f37018b;

    /* renamed from: c  reason: collision with root package name */
    public String f37019c;

    public LaunchInfo() {
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

    public static JSONObject getConvertedJson(int i2, String str, String str2) {
        InterceptResult invokeILL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65537, null, i2, str, str2)) == null) {
            JSONObject jSONObject2 = null;
            try {
                jSONObject = new JSONObject();
            } catch (Exception unused) {
            }
            try {
                jSONObject.put("type", String.valueOf(i2));
                if (str == null) {
                    str = "";
                }
                jSONObject.put("referer", str);
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
            String a = k.a(context);
            return !TextUtils.isEmpty(a) ? a : "";
        }
        return (String) invokeL.objValue;
    }

    public int getLaunchType(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (TextUtils.isEmpty(this.a)) {
                String packageName = context != null ? context.getPackageName() : "";
                if (TextUtils.isEmpty(this.f37019c) || this.f37019c.equals(packageName)) {
                    return 0;
                }
                String a = k.a(context);
                return !TextUtils.isEmpty(a) ? !this.f37019c.equals(a) ? 1 : 0 : !k.a(context, this.f37019c) ? 1 : 0;
            }
            return 2;
        }
        return invokeL.intValue;
    }

    public String getPushContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !TextUtils.isEmpty(this.f37018b) ? this.f37018b : "" : (String) invokeV.objValue;
    }

    public String getPushLandingPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? !TextUtils.isEmpty(this.a) ? this.a : "" : (String) invokeV.objValue;
    }

    public String getRefererPkgName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? !TextUtils.isEmpty(this.f37019c) ? this.f37019c : "" : (String) invokeV.objValue;
    }

    public void setPushInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.a = str;
            this.f37018b = x.a(str2, 1024);
        }
    }

    public void setRefererPkgName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f37019c = str;
        }
    }
}
