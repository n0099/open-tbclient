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
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<c> a;
    public c b;

    public b(Context context) {
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
        this.a = new ArrayList<>();
        String networkStatisticsData = DpNetworkUtils.getNetworkStatisticsData(context);
        c cVar = new c(DpStatConstants.SESSION_TYPE_DP_INIT_COMMON);
        this.b = cVar;
        cVar.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, "timestamp", System.currentTimeMillis()));
        this.b.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, "CPU", o.g()));
        this.b.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, "MODEL", Build.MODEL));
        this.b.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, "HARDWARE", Build.HARDWARE));
        this.b.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, "network", networkStatisticsData));
    }

    private JSONObject a(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, jSONObject)) == null) {
            this.b.a(jSONObject);
            JSONArray jSONArray = new JSONArray();
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                JSONObject jSONObject2 = new JSONObject();
                this.a.get(i).a(jSONObject2);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("data", jSONArray);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void a(Context context, int i, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65538, null, context, i, hashMap) == null) || hashMap == null || hashMap.size() <= 0) {
            return;
        }
        b bVar = new b(context);
        bVar.a(i, hashMap);
        bVar.a();
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            DpSessionDatasUploader.getInstance().upload(b(), "sailor_monitor");
        }
    }

    public void a(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, str2) == null) {
            if (24323 == i) {
                this.b.a(new e((int) DpStatConstants.SESSION_TYPE_DP_INIT_COMMON, str, str2));
                return;
            }
            e eVar = new e(i, str, str2);
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                c cVar = this.a.get(i2);
                if (cVar != null && cVar.a() == i) {
                    cVar.a(eVar);
                    return;
                }
            }
            c cVar2 = new c(i);
            cVar2.a(eVar);
            this.a.add(cVar2);
        }
    }

    public void a(int i, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, hashMap) == null) || hashMap == null || hashMap.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            a(i, entry.getKey(), entry.getValue());
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
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
