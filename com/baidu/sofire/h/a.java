package com.baidu.sofire.h;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.base.http.HttpClientWrap;
import com.baidu.sofire.a.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public static void a(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, jSONObject) == null) {
            try {
                JSONObject jSONObject2 = jSONObject.optJSONObject("3").getJSONObject("c");
                com.baidu.sofire.j.a a = com.baidu.sofire.j.a.a(context);
                int optInt = jSONObject2.optInt("n");
                if (optInt > 0) {
                    a.f.putInt("re_net_ty", optInt);
                    a.f.commit();
                }
                int optInt2 = jSONObject2.optInt("i");
                if (optInt2 > 0) {
                    a.f.putInt("re_net_hr", optInt2);
                    a.f.commit();
                }
                int optInt3 = jSONObject2.optInt("i2");
                if (optInt3 > 0) {
                    a.f.putInt("re_net_hr_bc", optInt3);
                    a.f.commit();
                }
                int optInt4 = jSONObject2.optInt("w");
                if (optInt4 > 0) {
                    a.f.putInt("re_net_wt", optInt4);
                    a.f.commit();
                }
                if (jSONObject2.optInt(HttpClientWrap.h) > 0) {
                    a.f.putInt("re_net_one_lt", jSONObject2.optInt(HttpClientWrap.h));
                    a.f.commit();
                }
                int optInt5 = jSONObject2.optInt(Config.SESSTION_TRACK_START_TIME);
                if (optInt5 > 0) {
                    a.f.putInt("re_net_dy_lt", optInt5);
                    a.f.commit();
                }
                int optInt6 = jSONObject2.optInt("t");
                if (optInt6 > 0) {
                    a.f.putInt("re_net_over", optInt6);
                    a.f.commit();
                }
                int optInt7 = jSONObject2.optInt("l1");
                if (optInt7 > 0) {
                    a.f.putInt("up_nu_co", optInt7);
                    a.f.commit();
                }
                int optInt8 = jSONObject2.optInt("l2");
                if (optInt8 > 0) {
                    a.f.putInt("up_nu_li", optInt8);
                    a.f.commit();
                }
            } catch (Throwable unused) {
                int i = b.a;
            }
        }
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            try {
                a = com.baidu.sofire.a.a.a(this.a, com.baidu.sofire.k.a.b() + "p/1/r", str, false, false);
            } catch (Throwable unused) {
                int i = b.a;
            }
            if (TextUtils.isEmpty(a)) {
                return false;
            }
            if (new JSONObject(a).getInt("response") == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
