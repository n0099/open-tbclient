package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ar {
    public static /* synthetic */ Interceptable $ic;
    public static final ar e;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public float b;
    public long c;
    public volatile boolean d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581657377, "Lcom/baidu/mobstat/ar;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581657377, "Lcom/baidu/mobstat/ar;");
                return;
            }
        }
        e = new ar();
    }

    public ar() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = 50.0f;
        this.c = 500L;
    }

    public static ar a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return e;
        }
        return (ar) invokeV.objValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public float c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            float f = this.b;
            if (f < 0.0f) {
                f = 0.0f;
            } else if (f > 100.0f) {
                f = 100.0f;
            }
            return f / 100.0f;
        }
        return invokeV.floatValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return invokeV.longValue;
    }

    public void a(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = (JSONObject) new JSONObject(str).opt("sv");
            if (jSONObject != null) {
                int optInt = jSONObject.optInt("close");
                String optString = jSONObject.optString(DnsModel.AREA_KEY);
                String optString2 = jSONObject.optString("duration");
                if (optInt != 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.a = z;
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        this.b = Float.valueOf(optString).floatValue();
                    } catch (Exception unused) {
                    }
                }
                if (!TextUtils.isEmpty(optString2)) {
                    this.c = Long.valueOf(optString2).longValue();
                }
            }
        } catch (Exception unused2) {
        }
        this.d = true;
    }
}
