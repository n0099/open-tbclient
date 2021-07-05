package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class as {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final as f8689e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f8690a;

    /* renamed from: b  reason: collision with root package name */
    public float f8691b;

    /* renamed from: c  reason: collision with root package name */
    public long f8692c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f8693d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581657408, "Lcom/baidu/mobstat/as;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581657408, "Lcom/baidu/mobstat/as;");
                return;
            }
        }
        f8689e = new as();
    }

    public as() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f8690a = false;
        this.f8691b = 50.0f;
        this.f8692c = 500L;
    }

    public static as a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f8689e : (as) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f8690a : invokeV.booleanValue;
    }

    public float c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            float f2 = this.f8691b;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            } else if (f2 > 100.0f) {
                f2 = 100.0f;
            }
            return f2 / 100.0f;
        }
        return invokeV.floatValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f8692c : invokeV.longValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = (JSONObject) new JSONObject(str).opt("sv");
            if (jSONObject != null) {
                int optInt = jSONObject.optInt(IntentConfig.CLOSE);
                String optString = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA);
                String optString2 = jSONObject.optString("duration");
                this.f8690a = optInt != 0;
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        this.f8691b = Float.valueOf(optString).floatValue();
                    } catch (Exception unused) {
                    }
                }
                if (!TextUtils.isEmpty(optString2)) {
                    this.f8692c = Long.valueOf(optString2).longValue();
                }
            }
        } catch (Exception unused2) {
        }
        this.f8693d = true;
    }
}
