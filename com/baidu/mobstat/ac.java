package com.baidu.mobstat;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ac {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public String f35005b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f35006c;

    public ac() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f35005b = "";
        this.f35006c = false;
    }

    public JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("SDK_BPLUS_SERVICE", this.a);
            } catch (JSONException e2) {
                bb.c().b(e2);
            }
            try {
                jSONObject.put("SDK_PRODUCT_LY", this.f35005b);
            } catch (JSONException e3) {
                bb.c().b(e3);
            }
            try {
                jSONObject.put("SDK_LOCAL_SERVER", this.f35006c);
            } catch (JSONException e4) {
                bb.c().b(e4);
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public ac(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f35005b = "";
        this.f35006c = false;
        try {
            this.a = jSONObject.getBoolean("SDK_BPLUS_SERVICE");
        } catch (Exception e2) {
            bb.c().b(e2);
        }
        try {
            this.f35005b = jSONObject.getString("SDK_PRODUCT_LY");
        } catch (Exception e3) {
            bb.c().b(e3);
        }
        try {
            this.f35006c = jSONObject.getBoolean("SDK_LOCAL_SERVER");
        } catch (Exception e4) {
            bb.c().b(e4);
        }
    }
}
