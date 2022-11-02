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
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;
    public List<f> b;

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new c(DpStatConstants.SESSION_TYPE_PLAY_COMMON);
        this.b = new ArrayList();
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
            if (this.b != null) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.b.size(); i++) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("type", this.b.get(i).a());
                    if (this.b.get(i).a(jSONObject2) != null) {
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

    public void a(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, str2) == null) {
            c cVar = this.a;
            if (cVar != null && i == 24322) {
                cVar.a(new e(i, str, str2));
            } else if (this.b != null) {
                e eVar = new e(i, str, str2);
                for (int i2 = 0; i2 < this.b.size(); i2++) {
                    f fVar = this.b.get(i2);
                    if (fVar.a() == i) {
                        fVar.a(eVar);
                        return;
                    }
                }
                f fVar2 = new f(i);
                fVar2.a(eVar);
                this.b.add(fVar2);
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
            List<f> list = this.b;
            if (list != null) {
                list.clear();
            }
        }
    }
}
