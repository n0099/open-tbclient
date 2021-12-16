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
/* loaded from: classes10.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public List<f> f34566b;

    public g() {
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
        this.a = new c(DpStatConstants.SESSION_TYPE_PLAY_COMMON);
        this.f34566b = new ArrayList();
    }

    public JSONObject a() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            c cVar = this.a;
            if (cVar != null) {
                cVar.a(jSONObject);
            }
            if (this.f34566b != null) {
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < this.f34566b.size(); i2++) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("type", this.f34566b.get(i2).a());
                    if (this.f34566b.get(i2).a(jSONObject2) != null) {
                        jSONArray.put(jSONObject2);
                    }
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("data", jSONArray);
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void a(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, str2) == null) {
            c cVar = this.a;
            if (cVar != null && i2 == 24322) {
                cVar.a(new e(i2, str, str2));
            } else if (this.f34566b != null) {
                e eVar = new e(i2, str, str2);
                for (int i3 = 0; i3 < this.f34566b.size(); i3++) {
                    f fVar = this.f34566b.get(i3);
                    if (fVar.a() == i2) {
                        fVar.a(eVar);
                        return;
                    }
                }
                f fVar2 = new f(i2);
                fVar2.a(eVar);
                this.f34566b.add(fVar2);
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c cVar = this.a;
            if (cVar != null) {
                cVar.b();
            }
            List<f> list = this.f34566b;
            if (list != null) {
                list.clear();
            }
        }
    }
}
