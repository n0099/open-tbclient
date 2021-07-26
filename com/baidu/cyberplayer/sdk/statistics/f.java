package com.baidu.cyberplayer.sdk.statistics;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f5085a;

    /* renamed from: b  reason: collision with root package name */
    public List<c> f5086b;

    /* renamed from: c  reason: collision with root package name */
    public c f5087c;

    public f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5085a = i2;
        this.f5087c = new c(DpStatConstants.SESSION_TYPE_PLAY_COMMON);
        this.f5086b = new ArrayList();
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f5085a : invokeV.intValue;
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            this.f5087c.a(jSONObject);
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < this.f5086b.size(); i2++) {
                JSONObject jSONObject2 = new JSONObject();
                if (this.f5086b.get(i2).a(jSONObject2) != null) {
                    jSONArray.put(jSONObject2);
                }
            }
            if (jSONArray.length() != 0) {
                jSONObject.put("data", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            this.f5087c.a(eVar);
        }
    }
}
