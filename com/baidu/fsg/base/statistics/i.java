package com.baidu.fsg.base.statistics;

import android.content.Context;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.restnet.beans.IBeanResponseCallback;
import com.baidu.fsg.base.statistics.k;
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
/* loaded from: classes5.dex */
public class i {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f39529a = "LogSender";

    /* renamed from: b  reason: collision with root package name */
    public static final int f39530b = 10000;

    /* renamed from: c  reason: collision with root package name */
    public static final int f39531c = 10001;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static i f39537a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2004308742, "Lcom/baidu/fsg/base/statistics/i$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2004308742, "Lcom/baidu/fsg/base/statistics/i$a;");
                    return;
                }
            }
            f39537a = new i();
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

    public i() {
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

    public static i a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f39537a : (i) invokeV.objValue;
    }

    private JSONArray a(f[] fVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, fVarArr)) == null) {
            JSONArray jSONArray = new JSONArray();
            for (f fVar : fVarArr) {
                LogUtil.d(f39529a, fVar.a().toString());
                jSONArray.put(fVar.a());
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    private void a(String str, k.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, aVar) == null) || str == null || str.trim().length() == 0) {
            return;
        }
        String str2 = str.toString();
        try {
            k kVar = new k();
            String encodeToString = Base64.encodeToString(str2.getBytes(), 2);
            HashMap hashMap = new HashMap();
            hashMap.put("publish_data", encodeToString);
            String signKey = RimStatisticsUtil.getInstance().getSignKey();
            hashMap.put("sign", com.baidu.fsg.base.statistics.a.a((encodeToString + signKey).getBytes("GBK"), false));
            hashMap.put("mk", "rim");
            kVar.a(b.l, hashMap, aVar);
        } catch (Exception unused) {
            aVar.b();
        }
    }

    public String a(JSONArray jSONArray, String str) {
        JSONObject jSONObject;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONArray, str)) == null) {
            try {
                jSONObject = new JSONObject(h.c().a());
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
        }
    }

    public void b(String str) {
        Context appContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("=====sendLogData=====");
            sb.append(str);
            LogUtil.d(f39529a, sb.toString() == "normal_log" ? "normal" : "crash");
            if ((str.equals(b.o) && e.a().c()) || (appContext = RimStatisticsUtil.getAppContext()) == null || !com.baidu.fsg.base.statistics.a.a(appContext)) {
                return;
            }
            JSONArray jSONArray = null;
            f[] b2 = g.a(RimStatisticsUtil.getAppContext()).b();
            if ("normal_log".equalsIgnoreCase(str)) {
                jSONArray = a(b2);
            } else if (b.o.equalsIgnoreCase(str)) {
                j jVar = new j(RimStatisticsUtil.getAppContext(), a(e.a().d(), "exception"));
                jVar.setResponseCallback(new IBeanResponseCallback(this, str) { // from class: com.baidu.fsg.base.statistics.i.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String f39532a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ i f39533b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f39533b = this;
                        this.f39532a = str;
                    }

                    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponseCallback
                    public void onBeanExecFailure(int i2, int i3, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIIL(1048576, this, i2, i3, str2) == null) {
                        }
                    }

                    @Override // com.baidu.fsg.base.restnet.beans.IBeanResponseCallback
                    public void onBeanExecSuccess(int i2, Object obj, String str2, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), obj, str2, str3}) == null) {
                            e.a().a(this.f39532a);
                        }
                    }
                });
                jVar.execBean();
                return;
            }
            if (jSONArray == null || jSONArray.length() == 0) {
                return;
            }
            a(a(jSONArray, "array"), new k.a(this, str, b2) { // from class: com.baidu.fsg.base.statistics.i.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f39534a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ f[] f39535b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ i f39536c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, b2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39536c = this;
                    this.f39534a = str;
                    this.f39535b = b2;
                }

                @Override // com.baidu.fsg.base.statistics.k.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        LogUtil.d(i.f39529a, "====send-success==");
                        if (b.o.equals(this.f39534a)) {
                            e.a().a(this.f39534a);
                        } else {
                            g.a(RimStatisticsUtil.getAppContext()).a(this.f39535b);
                        }
                    }
                }

                @Override // com.baidu.fsg.base.statistics.k.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        LogUtil.d(i.f39529a, "====send-fail=====");
                    }
                }
            });
        }
    }
}
