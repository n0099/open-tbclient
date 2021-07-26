package com.baidu.cyberplayer.sdk.statistics;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f5077a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<e> f5078b;

    public c(int i2) {
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
        this.f5077a = i2;
        this.f5078b = new ArrayList<>();
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f5077a : invokeV.intValue;
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return jSONObject;
            }
            int i2 = this.f5077a;
            if (i2 != 24321 && i2 != 24323 && i2 != 24322 && i2 != 20488) {
                jSONObject.put("type", i2);
            }
            int size = this.f5078b.size();
            for (int i3 = 0; i3 < size; i3++) {
                e eVar = this.f5078b.get(i3);
                if (eVar != null) {
                    jSONObject.put(eVar.a(), eVar.b());
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            this.f5078b.add(eVar);
        }
    }

    public void b() {
        ArrayList<e> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (arrayList = this.f5078b) == null) {
            return;
        }
        arrayList.clear();
    }
}
