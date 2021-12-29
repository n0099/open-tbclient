package com.baidu.fsg.base.statistics;

import android.content.Context;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.statistics.r;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class n {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "LogSender";

    /* renamed from: b  reason: collision with root package name */
    public static final int f34946b = 10000;

    /* renamed from: c  reason: collision with root package name */
    public static final int f34947c = 10001;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static n a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2004457697, "Lcom/baidu/fsg/base/statistics/n$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2004457697, "Lcom/baidu/fsg/base/statistics/n$a;");
                    return;
                }
            }
            a = new n(null);
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public n() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public /* synthetic */ n(l lVar) {
        this();
    }

    public static n a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.a : (n) invokeV.objValue;
    }

    private JSONArray a(h[] hVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, hVarArr)) == null) {
            JSONArray jSONArray = new JSONArray();
            for (h hVar : hVarArr) {
                LogUtil.d(a, hVar.a().toString());
                jSONArray.put(hVar.a());
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    private void a(String str, r.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, aVar) == null) || str == null || str.trim().length() == 0) {
            return;
        }
        String str2 = str.toString();
        try {
            r rVar = new r();
            String encodeToString = Base64.encodeToString(str2.getBytes(), 2);
            HashMap hashMap = new HashMap();
            hashMap.put("publish_data", encodeToString);
            String signKey = RimStatisticsUtil.getInstance().getSignKey();
            hashMap.put("sign", com.baidu.fsg.base.statistics.a.a((encodeToString + signKey).getBytes("GBK"), false));
            hashMap.put("mk", "rim");
            rVar.a(b.l, hashMap, aVar);
        } catch (Exception unused) {
            aVar.a();
        }
    }

    public String a(JSONArray jSONArray, String str) {
        JSONObject jSONObject;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONArray, str)) == null) {
            try {
                jSONObject = new JSONObject(k.c().a());
            } catch (JSONException e2) {
                e2.printStackTrace();
                jSONObject = null;
            }
            try {
                jSONObject.put(str, jSONArray);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeLL.objValue;
    }

    public void a(String str) {
        Context appContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("=====sendLogData=====");
            sb.append(str);
            LogUtil.d(a, sb.toString() == "normal_log" ? "normal" : "crash");
            if ((str.equals(b.o) && g.b().c()) || (appContext = RimStatisticsUtil.getAppContext()) == null || !com.baidu.fsg.base.statistics.a.c(appContext)) {
                return;
            }
            JSONArray jSONArray = null;
            h[] a2 = i.a(RimStatisticsUtil.getAppContext()).a();
            if ("normal_log".equalsIgnoreCase(str)) {
                jSONArray = a(a2);
            } else if (b.o.equalsIgnoreCase(str)) {
                o oVar = new o(RimStatisticsUtil.getAppContext(), a(g.b().a(), "exception"));
                oVar.setResponseCallback(new l(this, str));
                oVar.execBean();
                return;
            }
            if (jSONArray == null || jSONArray.length() == 0) {
                return;
            }
            a(a(jSONArray, "array"), new m(this, str, a2));
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }
}
