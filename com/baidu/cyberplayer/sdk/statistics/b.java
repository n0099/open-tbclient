package com.baidu.cyberplayer.sdk.statistics;

import android.content.Context;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberLog;
import com.baidu.cyberplayer.sdk.CyberVersion;
import com.baidu.cyberplayer.sdk.o;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<c> f38069a;

    /* renamed from: b  reason: collision with root package name */
    public c f38070b;

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38069a = new ArrayList<>();
        String networkStatisticsData = DpNetworkUtils.getNetworkStatisticsData(context);
        c cVar = new c(DpStatConstants.SESSION_TYPE_DP_INIT_COMMON);
        this.f38070b = cVar;
        cVar.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, "timestamp", System.currentTimeMillis()));
        this.f38070b.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, "CPU", o.g()));
        this.f38070b.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, "MODEL", Build.MODEL));
        this.f38070b.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, "HARDWARE", Build.HARDWARE));
        this.f38070b.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, "network", networkStatisticsData));
    }

    private JSONObject a(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, jSONObject)) == null) {
            this.f38070b.a(jSONObject);
            JSONArray jSONArray = new JSONArray();
            int size = this.f38069a.size();
            for (int i2 = 0; i2 < size; i2++) {
                JSONObject jSONObject2 = new JSONObject();
                this.f38069a.get(i2).a(jSONObject2);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("data", jSONArray);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void a(Context context, int i2, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65538, null, context, i2, hashMap) == null) || hashMap == null || hashMap.size() <= 0) {
            return;
        }
        b bVar = new b(context);
        bVar.a(i2, hashMap);
        bVar.a();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            DpSessionDatasUploader.getInstance().upload(b(), "sailor_monitor");
        }
    }

    public void a(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, str2) == null) {
            if (24323 == i2) {
                this.f38070b.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, str, str2));
                return;
            }
            e eVar = new e(i2, str, str2);
            int size = this.f38069a.size();
            for (int i3 = 0; i3 < size; i3++) {
                c cVar = this.f38069a.get(i3);
                if (cVar != null && cVar.a() == i2) {
                    cVar.a(eVar);
                    return;
                }
            }
            c cVar2 = new c(i2);
            cVar2.a(eVar);
            this.f38069a.add(cVar2);
        }
    }

    public void a(int i2, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, hashMap) == null) || hashMap == null || hashMap.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            a(i2, entry.getKey(), entry.getValue());
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                a.a().a(jSONObject);
                jSONObject.put(DpStatConstants.KEY_CORE_VERSION, CyberVersion.getCoreVersionInternal());
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                a(jSONObject2);
                jSONArray.put(jSONObject2);
                jSONObject.put("items", jSONArray);
                String jSONObject3 = jSONObject.toString();
                jSONObject.remove("cuid");
                CyberLog.i("DpLibsInitSession", "session=" + jSONObject.toString());
                return jSONObject3;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
