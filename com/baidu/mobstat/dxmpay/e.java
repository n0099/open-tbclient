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
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static e f37444b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f37445c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f37446d;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f37447e;

    /* renamed from: f  reason: collision with root package name */
    public int f37448f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f37449g;

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f37450h;

    /* renamed from: i  reason: collision with root package name */
    public JSONArray f37451i;

    /* renamed from: j  reason: collision with root package name */
    public JSONArray f37452j;

    /* renamed from: k  reason: collision with root package name */
    public JSONArray f37453k;
    public boolean l;
    public List<JSONObject> m;
    public List<String> n;
    public List<String> o;

    /* loaded from: classes8.dex */
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
        f37444b = new e();
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
        this.f37445c = new HandlerThread("fullTraceHandleThread");
        this.f37449g = new JSONObject();
        this.f37450h = new JSONArray();
        this.f37451i = new JSONArray();
        this.f37452j = new JSONArray();
        this.f37453k = new JSONArray();
        this.l = false;
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.f37445c.start();
        this.f37445c.setPriority(10);
        this.f37446d = new Handler(this.f37445c.getLooper());
    }

    private void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, jSONObject) == null) {
        }
    }

    private void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, context) == null) {
            this.f37451i = a(this.f37451i, BDStatCore.instance().getPageSessionHead());
            a(context, false);
            b();
        }
    }

    public void b(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, context, z) == null) {
            this.f37449g = new JSONObject();
            a(context);
            this.f37451i = new JSONArray();
            this.f37450h = new JSONArray();
            this.f37452j = new JSONArray();
            this.f37453k = new JSONArray();
            if (!z) {
                c.a().b();
            }
            b(context);
        }
    }

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f37444b : (e) invokeV.objValue;
    }

    public void a(Context context, String str, String str2, String str3, int i2, long j2, String str4, JSONArray jSONArray, String str5, JSONArray jSONArray2, String str6, Map<String, String> map, boolean z, JSONObject jSONObject, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, str2, str3, Integer.valueOf(i2), Long.valueOf(j2), str4, jSONArray, str5, jSONArray2, str6, map, Boolean.valueOf(z), jSONObject, str7}) == null) {
            this.f37446d.post(new Runnable(this, context, str, str2, str3, i2, j2, str4, jSONArray, str5, jSONArray2, str6, map, z, jSONObject, str7) { // from class: com.baidu.mobstat.dxmpay.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f37454b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f37455c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ String f37456d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ int f37457e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ long f37458f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ String f37459g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ JSONArray f37460h;

                /* renamed from: i  reason: collision with root package name */
                public final /* synthetic */ String f37461i;

                /* renamed from: j  reason: collision with root package name */
                public final /* synthetic */ JSONArray f37462j;

                /* renamed from: k  reason: collision with root package name */
                public final /* synthetic */ String f37463k;
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
                    this.f37454b = str;
                    this.f37455c = str2;
                    this.f37456d = str3;
                    this.f37457e = i2;
                    this.f37458f = j2;
                    this.f37459g = str4;
                    this.f37460h = jSONArray;
                    this.f37461i = str5;
                    this.f37462j = jSONArray2;
                    this.f37463k = str6;
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
                        this.p.a(this.a, sessionStartTime, this.f37454b, this.f37455c, this.f37456d, this.f37457e, this.f37458f, this.f37459g, this.f37460h, this.f37461i, this.f37462j, this.f37463k, this.l, this.m, this.n, this.o);
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
            this.f37448f = 0;
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
                jSONObject.put("he", new JSONObject(this.f37449g.toString()));
                jSONObject.put("pr", new JSONArray(this.f37451i.toString()));
                jSONObject.put("ev", new JSONArray(this.f37450h.toString()));
                jSONObject.put("ti", new JSONArray(this.f37452j.toString()));
                jSONObject.put("sv", new JSONArray(this.f37453k.toString()));
                jSONObject.put("pd", c.a().a(c.a.f37442b));
                jSONObject.put("ed", c.a().a(c.a.a));
                jSONObject.put("sd", c.a().a(c.a.f37443c));
            } catch (Exception unused) {
            }
            String jSONObject2 = jSONObject.toString();
            int length = jSONObject2.getBytes().length;
            if (length >= 184320) {
                return;
            }
            this.f37447e = length;
            String k2 = w.k(context);
            o.a(context, k2 + Config.STAT_FULL_CACHE_FILE_NAME, jSONObject2, false);
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
                c3.a("checkExceedLogLimit exceed:true; mCacheLogSize: " + this.f37447e + "; addedSize:" + jSONObject2.length());
            }
            c(context);
        }
        EventAnalysis.doEventMerge(this.f37450h, jSONObject);
    }

    private boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, context, str)) == null) {
            return (str != null ? str.getBytes().length : 0) + this.f37447e > 184320;
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
                b(context, this.f37449g);
            } catch (Exception unused) {
            }
            if (this.f37450h.length() == 0 && this.f37451i.length() == 0 && this.f37452j.length() == 0 && this.f37453k.length() == 0) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("he", this.f37449g);
            } catch (Exception unused2) {
            }
            try {
                jSONObject.put("pr", this.f37451i);
            } catch (Exception unused3) {
            }
            try {
                jSONObject.put("ev", this.f37450h);
            } catch (Exception unused4) {
            }
            try {
                jSONObject.put("ti", this.f37452j);
            } catch (Exception unused5) {
            }
            try {
                jSONObject.put("sv", this.f37453k);
            } catch (Exception unused6) {
            }
            try {
                jSONObject.put("pd", c.a().a(c.a.f37442b));
            } catch (Exception unused7) {
            }
            try {
                jSONObject.put("ed", c.a().a(c.a.a));
            } catch (Exception unused8) {
            }
            try {
                jSONObject.put("sd", c.a().a(c.a.f37443c));
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
                jSONObject.put("sq", this.f37448f);
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
            this.f37448f++;
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
            CooperService.instance().getHeadObject().installHeader(context, this.f37449g);
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
