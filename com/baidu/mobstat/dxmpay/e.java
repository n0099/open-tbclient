package com.baidu.mobstat.dxmpay;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.dxmpay.Config;
import com.baidu.mobstat.dxmpay.c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static e f36869b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f36870c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f36871d;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f36872e;

    /* renamed from: f  reason: collision with root package name */
    public int f36873f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f36874g;

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f36875h;

    /* renamed from: i  reason: collision with root package name */
    public JSONArray f36876i;

    /* renamed from: j  reason: collision with root package name */
    public JSONArray f36877j;
    public JSONArray k;
    public boolean l;
    public List<JSONObject> m;
    public List<String> n;
    public List<String> o;

    /* loaded from: classes10.dex */
    public interface a {
        void a(JSONObject jSONObject);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1455169165, "Lcom/baidu/mobstat/dxmpay/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1455169165, "Lcom/baidu/mobstat/dxmpay/e;");
                return;
            }
        }
        f36869b = new e();
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f36870c = new HandlerThread("fullTraceHandleThread");
        this.f36874g = new JSONObject();
        this.f36875h = new JSONArray();
        this.f36876i = new JSONArray();
        this.f36877j = new JSONArray();
        this.k = new JSONArray();
        this.l = false;
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.f36870c.start();
        this.f36870c.setPriority(10);
        this.f36871d = new Handler(this.f36870c.getLooper());
    }

    private void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, jSONObject) == null) {
        }
    }

    private void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, context) == null) {
            this.f36876i = a(this.f36876i, BDStatCore.instance().getPageSessionHead());
            a(context, false);
            b();
        }
    }

    public void b(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, context, z) == null) {
            this.f36874g = new JSONObject();
            a(context);
            this.f36876i = new JSONArray();
            this.f36875h = new JSONArray();
            this.f36877j = new JSONArray();
            this.k = new JSONArray();
            if (!z) {
                c.a().b();
            }
            b(context);
        }
    }

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f36869b : (e) invokeV.objValue;
    }

    public void a(Context context, String str, String str2, String str3, int i2, long j2, String str4, JSONArray jSONArray, String str5, JSONArray jSONArray2, String str6, Map<String, String> map, boolean z, JSONObject jSONObject, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, str2, str3, Integer.valueOf(i2), Long.valueOf(j2), str4, jSONArray, str5, jSONArray2, str6, map, Boolean.valueOf(z), jSONObject, str7}) == null) {
            this.f36871d.post(new Runnable(this, context, str, str2, str3, i2, j2, str4, jSONArray, str5, jSONArray2, str6, map, z, jSONObject, str7) { // from class: com.baidu.mobstat.dxmpay.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f36878b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f36879c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f36880d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ int f36881e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ long f36882f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ String f36883g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ JSONArray f36884h;

                /* renamed from: i  reason: collision with root package name */
                public final /* synthetic */ String f36885i;

                /* renamed from: j  reason: collision with root package name */
                public final /* synthetic */ JSONArray f36886j;
                public final /* synthetic */ String k;
                public final /* synthetic */ Map l;
                public final /* synthetic */ boolean m;
                public final /* synthetic */ JSONObject n;
                public final /* synthetic */ String o;
                public final /* synthetic */ e p;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, str, str2, str3, Integer.valueOf(i2), Long.valueOf(j2), str4, jSONArray, str5, jSONArray2, str6, map, Boolean.valueOf(z), jSONObject, str7};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.p = this;
                    this.a = context;
                    this.f36878b = str;
                    this.f36879c = str2;
                    this.f36880d = str3;
                    this.f36881e = i2;
                    this.f36882f = j2;
                    this.f36883g = str4;
                    this.f36884h = jSONArray;
                    this.f36885i = str5;
                    this.f36886j = jSONArray2;
                    this.k = str6;
                    this.l = map;
                    this.m = z;
                    this.n = jSONObject;
                    this.o = str7;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long sessionStartTime = BDStatCore.instance().getSessionStartTime();
                        if (sessionStartTime <= 0) {
                            return;
                        }
                        this.p.a(this.a, sessionStartTime, this.f36878b, this.f36879c, this.f36880d, this.f36881e, this.f36882f, this.f36883g, this.f36884h, this.f36885i, this.f36886j, this.k, this.l, this.m, this.n, this.o);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, long j2, String str, String str2, String str3, int i2, long j3, String str4, JSONArray jSONArray, String str5, JSONArray jSONArray2, String str6, Map<String, String> map, boolean z, JSONObject jSONObject, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{context, Long.valueOf(j2), str, str2, str3, Integer.valueOf(i2), Long.valueOf(j3), str4, jSONArray, str5, jSONArray2, str6, map, Boolean.valueOf(z), jSONObject, str7}) == null) {
            a(context, EventAnalysis.getEvent(context, j2, str, str2, str3, i2, j3, 0L, "", null, null, k.a(str4), k.a(str5), str6, Config.EventViewType.EDIT.getValue(), 3, null, map, k.c(jSONArray), k.d(jSONArray2), z, jSONObject, str7));
            b(context);
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.f36873f = 0;
        }
    }

    private void c(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65550, this, context, jSONObject) == null) || jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("failed_cnt", 0);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("trace", jSONObject2);
        } catch (Exception unused2) {
        }
    }

    public void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("he", new JSONObject(this.f36874g.toString()));
                jSONObject.put("pr", new JSONArray(this.f36876i.toString()));
                jSONObject.put("ev", new JSONArray(this.f36875h.toString()));
                jSONObject.put("ti", new JSONArray(this.f36877j.toString()));
                jSONObject.put("sv", new JSONArray(this.k.toString()));
                jSONObject.put("pd", c.a().a(c.a.f36867b));
                jSONObject.put("ed", c.a().a(c.a.a));
                jSONObject.put("sd", c.a().a(c.a.f36868c));
            } catch (Exception unused) {
            }
            String jSONObject2 = jSONObject.toString();
            int length = jSONObject2.getBytes().length;
            if (length >= 184320) {
                return;
            }
            this.f36872e = length;
            String k = w.k(context);
            o.a(context, k + Config.STAT_FULL_CACHE_FILE_NAME, jSONObject2, false);
        }
    }

    private void a(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, this, context, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (j.c().b()) {
            j c2 = j.c();
            c2.a("putEvent: " + jSONObject.toString());
        }
        String jSONObject2 = jSONObject.toString();
        if (a(context, jSONObject2)) {
            if (j.c().b()) {
                j c3 = j.c();
                c3.a("checkExceedLogLimit exceed:true; mCacheLogSize: " + this.f36872e + "; addedSize:" + jSONObject2.length());
            }
            c(context);
        }
        EventAnalysis.doEventMerge(this.f36875h, jSONObject);
    }

    private boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, context, str)) == null) {
            return (str != null ? str.getBytes().length : 0) + this.f36872e > 184320;
        }
        return invokeLL.booleanValue;
    }

    public void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, context, z) == null) {
            if (z) {
                c();
            } else {
                b();
            }
            try {
                b(context, this.f36874g);
            } catch (Exception unused) {
            }
            if (this.f36875h.length() == 0 && this.f36876i.length() == 0 && this.f36877j.length() == 0 && this.k.length() == 0) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("he", this.f36874g);
            } catch (Exception unused2) {
            }
            try {
                jSONObject.put("pr", this.f36876i);
            } catch (Exception unused3) {
            }
            try {
                jSONObject.put("ev", this.f36875h);
            } catch (Exception unused4) {
            }
            try {
                jSONObject.put("ti", this.f36877j);
            } catch (Exception unused5) {
            }
            try {
                jSONObject.put("sv", this.k);
            } catch (Exception unused6) {
            }
            try {
                jSONObject.put("pd", c.a().a(c.a.f36867b));
            } catch (Exception unused7) {
            }
            try {
                jSONObject.put("ed", c.a().a(c.a.a));
            } catch (Exception unused8) {
            }
            try {
                jSONObject.put("sd", c.a().a(c.a.f36868c));
            } catch (Exception unused9) {
            }
            c(context, jSONObject);
            a(jSONObject);
            String jSONObject2 = jSONObject.toString();
            if (j.c().b()) {
                j c2 = j.c();
                c2.a("saveCurrentCacheToSend content: " + jSONObject2);
            }
            b(context, jSONObject2);
            b(context, !z);
            this.l = true;
        }
    }

    private void b(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, this, context, jSONObject) == null) {
            CooperService.instance().getHeadObject().installHeader(context, jSONObject);
            try {
                jSONObject.put("t", System.currentTimeMillis());
                jSONObject.put("sq", this.f36873f);
                jSONObject.put("ss", BDStatCore.instance().getSessionStartTime());
                jSONObject.put("at", "1");
                jSONObject.put("sign", CooperService.instance().getUUID());
            } catch (Exception unused) {
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.f36873f++;
        }
    }

    private void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, this, context, str) == null) {
            LogSender.instance().saveLogData(context, str, true);
            if (this.a != null) {
                try {
                    this.a.a(new JSONObject(str));
                } catch (Exception unused) {
                }
            }
        }
    }

    public void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            CooperService.instance().getHeadObject().installHeader(context, this.f36874g);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:11|(2:12|13)|(6:29|30|16|17|(2:22|23)|(1:20))|15|16|17|(0)|(0)) */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONArray a(JSONArray jSONArray, JSONObject jSONObject) {
        InterceptResult invokeLL;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONArray jSONArray2;
        JSONObject jSONObject4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, jSONArray, jSONObject)) == null) {
            if (jSONObject == null || jSONArray == null || jSONObject.optLong("s") <= 0) {
                return jSONArray;
            }
            JSONArray jSONArray3 = new JSONArray();
            JSONObject jSONObject5 = null;
            if (jSONArray.length() == 0) {
                try {
                    jSONObject2 = new JSONObject(jSONObject.toString());
                } catch (Exception unused) {
                }
                try {
                    jSONObject2.put("p", new JSONArray());
                } catch (Exception unused2) {
                    jSONObject5 = jSONObject2;
                    jSONObject2 = jSONObject5;
                    if (jSONObject2 != null) {
                    }
                    return jSONArray3;
                }
                if (jSONObject2 != null) {
                    jSONArray3.put(jSONObject2);
                }
            } else {
                try {
                    jSONObject3 = jSONArray.getJSONObject(0);
                } catch (Exception unused3) {
                    jSONObject3 = null;
                }
                if (jSONObject3 != null) {
                    try {
                        jSONArray2 = jSONObject3.getJSONArray("p");
                    } catch (Exception unused4) {
                    }
                    jSONObject4 = new JSONObject(jSONObject.toString());
                    if (jSONArray2 != null) {
                        try {
                            jSONObject4.put("p", jSONArray2);
                        } catch (Exception unused5) {
                            jSONObject5 = jSONObject4;
                            jSONObject4 = jSONObject5;
                            if (jSONObject4 != null) {
                            }
                            return jSONArray3;
                        }
                    }
                    if (jSONObject4 != null) {
                        jSONArray3.put(jSONObject4);
                    }
                }
                jSONArray2 = null;
                jSONObject4 = new JSONObject(jSONObject.toString());
                if (jSONArray2 != null) {
                }
                if (jSONObject4 != null) {
                }
            }
            return jSONArray3;
        }
        return (JSONArray) invokeLL.objValue;
    }
}
