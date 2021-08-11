package com.baidu.lbsapi.auth;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f40402a;

    /* renamed from: b  reason: collision with root package name */
    public List<HashMap<String, String>> f40403b;

    /* renamed from: c  reason: collision with root package name */
    public a<String> f40404c;

    /* loaded from: classes5.dex */
    public interface a<Result> {
        void a(Result result);
    }

    public e(Context context) {
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
        this.f40403b = null;
        this.f40404c = null;
        this.f40402a = context;
    }

    private List<HashMap<String, String>> a(HashMap<String, String> hashMap, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, hashMap, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            if (strArr == null || strArr.length <= 0) {
                HashMap hashMap2 = new HashMap();
                for (String str : hashMap.keySet()) {
                    String str2 = str.toString();
                    hashMap2.put(str2, hashMap.get(str2));
                }
                arrayList.add(hashMap2);
            } else {
                for (String str3 : strArr) {
                    HashMap hashMap3 = new HashMap();
                    for (String str4 : hashMap.keySet()) {
                        String str5 = str4.toString();
                        hashMap3.put(str5, hashMap.get(str5));
                    }
                    hashMap3.put("mcode", str3);
                    arrayList.add(hashMap3);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    private void a(String str) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            if (str == null) {
                str = "";
            }
            try {
                jSONObject = new JSONObject(str);
                if (!jSONObject.has("status")) {
                    jSONObject.put("status", -1);
                }
            } catch (JSONException unused) {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("status", -1);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            a<String> aVar = this.f40404c;
            if (aVar != null) {
                aVar.a(jSONObject.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<HashMap<String, String>> list) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, list) == null) {
            com.baidu.lbsapi.auth.a.a("syncConnect start Thread id = " + String.valueOf(Thread.currentThread().getId()));
            if (list == null || list.size() == 0) {
                com.baidu.lbsapi.auth.a.c("syncConnect failed,params list is null or size is 0");
                return;
            }
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            while (i3 < list.size()) {
                com.baidu.lbsapi.auth.a.a("syncConnect resuest " + i3 + "  start!!!");
                HashMap<String, String> hashMap = list.get(i3);
                g gVar = new g(this.f40402a);
                if (gVar.a()) {
                    String a2 = gVar.a(hashMap);
                    if (a2 == null) {
                        a2 = "";
                    }
                    com.baidu.lbsapi.auth.a.a("syncConnect resuest " + i3 + "  result:" + a2);
                    arrayList.add(a2);
                    try {
                        JSONObject jSONObject = new JSONObject(a2);
                        if (jSONObject.has("status") && jSONObject.getInt("status") == 0) {
                            com.baidu.lbsapi.auth.a.a("auth end and break");
                            a(a2);
                            return;
                        }
                    } catch (JSONException unused) {
                        com.baidu.lbsapi.auth.a.a("continue-------------------------------");
                    }
                } else {
                    com.baidu.lbsapi.auth.a.a("Current network is not available.");
                    arrayList.add(ErrorMessage.a("Current network is not available."));
                }
                com.baidu.lbsapi.auth.a.a("syncConnect end");
                i3++;
            }
            com.baidu.lbsapi.auth.a.a("--iiiiii:" + i3 + "<><>paramList.size():" + list.size() + "<><>authResults.size():" + arrayList.size());
            if (list.size() <= 0 || i3 != list.size() || arrayList.size() <= 0 || i3 != arrayList.size() || i3 - 1 <= 0) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject((String) arrayList.get(i2));
                if (!jSONObject2.has("status") || jSONObject2.getInt("status") == 0) {
                    return;
                }
                com.baidu.lbsapi.auth.a.a("i-1 result is not 0,return first result");
                a((String) arrayList.get(0));
            } catch (JSONException e2) {
                a(ErrorMessage.a("JSONException:" + e2.getMessage()));
            }
        }
    }

    public void a(HashMap<String, String> hashMap, String[] strArr, a<String> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, hashMap, strArr, aVar) == null) {
            this.f40403b = a(hashMap, strArr);
            this.f40404c = aVar;
            new Thread(new f(this)).start();
        }
    }
}
