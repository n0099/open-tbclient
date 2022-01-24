package com.baidu.mobstat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.mobstat.au;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class aw {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static aw f36493b;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;

    /* renamed from: c  reason: collision with root package name */
    public HandlerThread f36494c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f36495d;

    /* renamed from: e  reason: collision with root package name */
    public volatile int f36496e;

    /* renamed from: f  reason: collision with root package name */
    public int f36497f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f36498g;

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f36499h;

    /* renamed from: i  reason: collision with root package name */
    public JSONArray f36500i;

    /* renamed from: j  reason: collision with root package name */
    public JSONArray f36501j;
    public JSONArray k;

    /* loaded from: classes10.dex */
    public interface a {
        void a(JSONObject jSONObject);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581657532, "Lcom/baidu/mobstat/aw;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581657532, "Lcom/baidu/mobstat/aw;");
                return;
            }
        }
        f36493b = new aw();
    }

    public aw() {
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
        this.f36494c = new HandlerThread("fullTraceHandleThread");
        this.f36498g = new JSONObject();
        this.f36499h = new JSONArray();
        this.f36500i = new JSONArray();
        this.f36501j = new JSONArray();
        this.k = new JSONArray();
        this.f36494c.start();
        this.f36494c.setPriority(10);
        this.f36495d = new Handler(this.f36494c.getLooper());
    }

    private void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, this, jSONObject) == null) {
        }
    }

    private void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, this, context) == null) {
            this.f36500i = b(this.f36500i, BDStatCore.instance().getPageSessionHead());
            b(context, false);
            b();
        }
    }

    public void c(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, context, z) == null) {
            this.f36498g = new JSONObject();
            b(context);
            this.f36500i = new JSONArray();
            this.f36499h = new JSONArray();
            this.f36501j = new JSONArray();
            this.k = new JSONArray();
            if (!z) {
                au.a().b();
            }
            c(context);
        }
    }

    public void b(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, context, z) == null) {
            if (z) {
                c();
            } else {
                b();
            }
            try {
                b(context, this.f36498g);
            } catch (Exception unused) {
            }
            if (this.f36499h.length() == 0 && this.f36500i.length() == 0 && this.f36501j.length() == 0 && this.k.length() == 0) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("he", this.f36498g);
            } catch (Exception unused2) {
            }
            try {
                jSONObject.put("pr", this.f36500i);
            } catch (Exception unused3) {
            }
            try {
                jSONObject.put("ev", this.f36499h);
            } catch (Exception unused4) {
            }
            try {
                jSONObject.put("ti", this.f36501j);
            } catch (Exception unused5) {
            }
            try {
                jSONObject.put("sv", this.k);
            } catch (Exception unused6) {
            }
            try {
                jSONObject.put("pd", au.a().a(au.a.f36491b));
            } catch (Exception unused7) {
            }
            try {
                jSONObject.put("ed", au.a().a(au.a.a));
            } catch (Exception unused8) {
            }
            try {
                jSONObject.put("sd", au.a().a(au.a.f36492c));
            } catch (Exception unused9) {
            }
            c(context, jSONObject);
            b(jSONObject);
            String jSONObject2 = jSONObject.toString();
            if (bh.c().b()) {
                bh c2 = bh.c();
                c2.a("saveCurrentCacheToSend content: " + jSONObject2);
            }
            b(context, jSONObject2);
            c(context, !z);
        }
    }

    private void d(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65569, this, context, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (bh.c().b()) {
            bh c2 = bh.c();
            c2.a("putPage: " + jSONObject.toString());
        }
        String jSONObject2 = jSONObject.toString();
        if (a(context, jSONObject2)) {
            if (bh.c().b()) {
                bh c3 = bh.c();
                c3.a("checkExceedLogLimit exceed:true; mCacheLogSize: " + this.f36496e + "; addedSize:" + jSONObject2.length());
            }
            d(context);
        }
        a(this.f36500i, jSONObject);
    }

    public static aw a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f36493b : (aw) invokeV.objValue;
    }

    public void a(Context context) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        JSONArray optJSONArray3;
        JSONArray optJSONArray4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || context == null) {
            return;
        }
        String str = bw.u(context) + Config.STAT_FULL_CACHE_FILE_NAME;
        if (bo.c(context, str)) {
            String a2 = bo.a(context, str);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(a2);
            } catch (Exception unused) {
            }
            if (jSONObject == null) {
                return;
            }
            try {
                optJSONArray = jSONObject.optJSONArray("ev");
                optJSONArray2 = jSONObject.optJSONArray("pr");
                optJSONArray3 = jSONObject.optJSONArray("ti");
                optJSONArray4 = jSONObject.optJSONArray("sv");
            } catch (Exception unused2) {
            }
            if ((optJSONArray != null && optJSONArray.length() != 0) || ((optJSONArray2 != null && optJSONArray2.length() != 0) || ((optJSONArray3 != null && optJSONArray3.length() != 0) || (optJSONArray4 != null && optJSONArray4.length() != 0)))) {
                b(context, jSONObject.getJSONObject("he"));
                c(context, jSONObject);
                b(jSONObject);
                a2 = jSONObject.toString();
                if (bh.c().b()) {
                    bh.c().a("saveLastCacheToSend content: " + a2);
                }
                b(context, a2);
                c(context, false);
                return;
            }
            if (bh.c().b()) {
                bh.c().a("saveLastCacheToSend content:empty, return");
            }
        }
    }

    public void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("he", new JSONObject(this.f36498g.toString()));
                jSONObject.put("pr", new JSONArray(this.f36500i.toString()));
                jSONObject.put("ev", new JSONArray(this.f36499h.toString()));
                jSONObject.put("ti", new JSONArray(this.f36501j.toString()));
                jSONObject.put("sv", new JSONArray(this.k.toString()));
                jSONObject.put("pd", au.a().a(au.a.f36491b));
                jSONObject.put("ed", au.a().a(au.a.a));
                jSONObject.put("sd", au.a().a(au.a.f36492c));
            } catch (Exception unused) {
            }
            String jSONObject2 = jSONObject.toString();
            int length = jSONObject2.getBytes().length;
            if (length >= 184320) {
                return;
            }
            this.f36496e = length;
            String u = bw.u(context);
            bo.a(context, u + Config.STAT_FULL_CACHE_FILE_NAME, jSONObject2, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context, ArrayList<aq> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65568, this, context, arrayList) == null) || context == null || arrayList == null || arrayList.size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<aq> it = arrayList.iterator();
        while (it.hasNext()) {
            aq next = it.next();
            JSONObject a2 = next.a(au.a().a(next.b(), au.a.f36491b), au.a().a(next.f(), au.a.f36492c), bj.c(next.c()));
            if (a2 != null) {
                jSONArray.put(a2);
            }
        }
        b(context, jSONArray);
        c(context);
    }

    public void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            CooperService.instance().getHeadObject().installHeader(context, this.f36498g);
        }
    }

    private void b(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, this, context, jSONObject) == null) {
            CooperService.instance().getHeadObject().installHeader(context, jSONObject);
            try {
                jSONObject.put("t", System.currentTimeMillis());
                jSONObject.put("sq", this.f36497f);
                jSONObject.put("ss", BDStatCore.instance().getSessionStartTime());
                jSONObject.put("at", "1");
                jSONObject.put("sign", CooperService.instance().getUUID());
            } catch (Exception unused) {
            }
        }
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            this.f36497f = 0;
        }
    }

    private void c(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65566, this, context, jSONObject) == null) || jSONObject == null) {
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

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            this.f36497f++;
        }
    }

    private void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65557, this, context, str) == null) {
            LogSender.instance().saveLogData(context, str, true);
            if (this.a != null) {
                try {
                    this.a.a(new JSONObject(str));
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, ArrayList<ap> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65565, this, context, arrayList) == null) || context == null || arrayList == null || arrayList.size() == 0) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<ap> it = arrayList.iterator();
        while (it.hasNext()) {
            ap next = it.next();
            JSONObject a2 = next.a(au.a().a(next.a(), au.a.f36492c));
            if (a2 != null) {
                jSONArray.put(a2);
            }
        }
        a(context, jSONArray);
        c(context);
    }

    public void a(Context context, String str, String str2, int i2, long j2, String str3, JSONArray jSONArray, String str4, JSONArray jSONArray2, String str5, Map<String, String> map, JSONObject jSONObject, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, str2, Integer.valueOf(i2), Long.valueOf(j2), str3, jSONArray, str4, jSONArray2, str5, map, jSONObject, str6}) == null) {
            a(context, str, str2, i2, j2, str3, jSONArray, str4, jSONArray2, str5, map, false, jSONObject, str6);
        }
    }

    public void a(Context context, String str, String str2, int i2, long j2, String str3, JSONArray jSONArray, String str4, JSONArray jSONArray2, String str5, Map<String, String> map, boolean z, JSONObject jSONObject, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, str, str2, Integer.valueOf(i2), Long.valueOf(j2), str3, jSONArray, str4, jSONArray2, str5, map, Boolean.valueOf(z), jSONObject, str6}) == null) {
            this.f36495d.post(new Runnable(this, context, str, str2, i2, j2, str3, jSONArray, str4, jSONArray2, str5, map, z, jSONObject, str6) { // from class: com.baidu.mobstat.aw.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ String f36502b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ String f36503c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ int f36504d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ long f36505e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ String f36506f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ JSONArray f36507g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ String f36508h;

                /* renamed from: i  reason: collision with root package name */
                public final /* synthetic */ JSONArray f36509i;

                /* renamed from: j  reason: collision with root package name */
                public final /* synthetic */ String f36510j;
                public final /* synthetic */ Map k;
                public final /* synthetic */ boolean l;
                public final /* synthetic */ JSONObject m;
                public final /* synthetic */ String n;
                public final /* synthetic */ aw o;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, str, str2, Integer.valueOf(i2), Long.valueOf(j2), str3, jSONArray, str4, jSONArray2, str5, map, Boolean.valueOf(z), jSONObject, str6};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.o = this;
                    this.a = context;
                    this.f36502b = str;
                    this.f36503c = str2;
                    this.f36504d = i2;
                    this.f36505e = j2;
                    this.f36506f = str3;
                    this.f36507g = jSONArray;
                    this.f36508h = str4;
                    this.f36509i = jSONArray2;
                    this.f36510j = str5;
                    this.k = map;
                    this.l = z;
                    this.m = jSONObject;
                    this.n = str6;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        long sessionStartTime = BDStatCore.instance().getSessionStartTime();
                        if (sessionStartTime <= 0) {
                            return;
                        }
                        this.o.a(this.a, sessionStartTime, this.f36502b, this.f36503c, this.f36504d, this.f36505e, this.f36506f, this.f36507g, this.f36508h, this.f36509i, this.f36510j, this.k, this.l, this.m, this.n);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, long j2, String str, String str2, int i2, long j3, String str3, JSONArray jSONArray, String str4, JSONArray jSONArray2, String str5, Map<String, String> map, boolean z, JSONObject jSONObject, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{context, Long.valueOf(j2), str, str2, Integer.valueOf(i2), Long.valueOf(j3), str3, jSONArray, str4, jSONArray2, str5, map, Boolean.valueOf(z), jSONObject, str6}) == null) {
            a(context, EventAnalysis.getEvent(context, j2, str, str2, i2, j3, 0L, "", null, null, bj.a(str3), bj.a(str4), str5, Config.EventViewType.EDIT.getValue(), 3, null, map, bj.c(jSONArray), bj.d(jSONArray2), z, jSONObject, str6));
            c(context);
        }
    }

    public void b(Context context, ArrayList<aq> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, arrayList) == null) {
            this.f36495d.post(new Runnable(this, context, arrayList) { // from class: com.baidu.mobstat.aw.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ArrayList f36518b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ aw f36519c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, arrayList};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36519c = this;
                    this.a = context;
                    this.f36518b = arrayList;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f36519c.d(this.a, this.f36518b);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, ao aoVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65556, this, context, aoVar) == null) || context == null || aoVar == null) {
            return;
        }
        JSONArray b2 = b(this.f36500i, BDStatCore.instance().getPageSessionHead());
        this.f36500i = b2;
        if (b2.length() == 0) {
            return;
        }
        long a2 = a(this.f36500i);
        if (a2 <= 0) {
            return;
        }
        d(context, aoVar.a(a2, au.a().a(aoVar.a(), au.a.f36491b), au.a().a(aoVar.b(), au.a.f36492c)));
        c(context);
    }

    private void a(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, this, context, jSONObject) == null) || jSONObject == null) {
            return;
        }
        if (bh.c().b()) {
            bh c2 = bh.c();
            c2.a("putEvent: " + jSONObject.toString());
        }
        String jSONObject2 = jSONObject.toString();
        if (a(context, jSONObject2)) {
            if (bh.c().b()) {
                bh c3 = bh.c();
                c3.a("checkExceedLogLimit exceed:true; mCacheLogSize: " + this.f36496e + "; addedSize:" + jSONObject2.length());
            }
            d(context);
        }
        EventAnalysis.doEventMerge(this.f36499h, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(8:11|(2:12|13)|(6:29|30|16|17|(2:22|23)|(1:20))|15|16|17|(0)|(0)) */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONArray b(JSONArray jSONArray, JSONObject jSONObject) {
        InterceptResult invokeLL;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONArray jSONArray2;
        JSONObject jSONObject4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, this, jSONArray, jSONObject)) == null) {
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

    private boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, this, context, str)) == null) {
            return (str != null ? str.getBytes().length : 0) + this.f36496e > 184320;
        }
        return invokeLL.booleanValue;
    }

    public void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, context, z) == null) {
            this.f36495d.post(new Runnable(this, context, z) { // from class: com.baidu.mobstat.aw.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ boolean f36511b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ aw f36512c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36512c = this;
                    this.a = context;
                    this.f36511b = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f36512c.b(this.a, this.f36511b);
                    }
                }
            });
        }
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONObject) == null) {
            this.f36495d.post(new Runnable(this, jSONObject) { // from class: com.baidu.mobstat.aw.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ JSONObject a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ aw f36513b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, jSONObject};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36513b = this;
                    this.a = jSONObject;
                }

                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (jSONObject2 = this.a) == null || jSONObject2.length() == 0) {
                        return;
                    }
                    aw awVar = this.f36513b;
                    awVar.f36500i = awVar.b(awVar.f36500i, this.a);
                }
            });
        }
    }

    public void a(Context context, ao aoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aoVar) == null) {
            this.f36495d.post(new Runnable(this, context, aoVar) { // from class: com.baidu.mobstat.aw.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ao f36514b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ aw f36515c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, aoVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36515c = this;
                    this.a = context;
                    this.f36514b = aoVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || BDStatCore.instance().getSessionStartTime() <= 0) {
                        return;
                    }
                    this.f36515c.b(this.a, this.f36514b);
                }
            });
        }
    }

    public void a(Context context, ArrayList<ap> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, context, arrayList) == null) {
            this.f36495d.post(new Runnable(this, context, arrayList) { // from class: com.baidu.mobstat.aw.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ArrayList f36516b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ aw f36517c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, arrayList};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36517c = this;
                    this.a = context;
                    this.f36516b = arrayList;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f36517c.c(this.a, this.f36516b);
                    }
                }
            });
        }
    }

    private void a(JSONArray jSONArray, JSONObject jSONObject) {
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, this, jSONArray, jSONObject) == null) {
            JSONArray jSONArray2 = null;
            try {
                jSONObject2 = jSONArray.getJSONObject(0);
            } catch (Exception unused) {
                jSONObject2 = null;
            }
            if (jSONObject2 != null) {
                try {
                    jSONArray2 = jSONObject2.optJSONArray("p");
                } catch (Exception unused2) {
                }
            }
            if (jSONArray2 == null) {
                JSONArray jSONArray3 = new JSONArray();
                jSONArray3.put(jSONObject);
                if (jSONObject2 != null) {
                    try {
                        jSONObject2.put("p", jSONArray3);
                        return;
                    } catch (Exception unused3) {
                        return;
                    }
                }
                return;
            }
            jSONArray2.put(jSONObject);
        }
    }

    private void b(Context context, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65558, this, context, jSONArray) == null) || context == null || this.k == null || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        if (bh.c().b()) {
            bh c2 = bh.c();
            c2.a("putFeedListItem: " + jSONArray.toString());
        }
        String jSONArray2 = jSONArray.toString();
        if (a(context, jSONArray2)) {
            if (bh.c().b()) {
                bh c3 = bh.c();
                c3.a("checkExceedLogLimit exceed:true; mCacheLogSize: " + this.f36496e + "; addedSize:" + jSONArray2.length());
            }
            d(context);
        }
        b(this.k, jSONArray);
    }

    private long a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, jSONArray)) == null) {
            if (jSONArray == null || jSONArray.length() == 0) {
                return 0L;
            }
            try {
                return jSONArray.getJSONObject(0).optLong("s");
            } catch (Exception unused) {
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    private void a(Context context, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, this, context, jSONArray) == null) || context == null || this.f36501j == null || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        if (bh.c().b()) {
            bh c2 = bh.c();
            c2.a("putFeedList: " + jSONArray.toString());
        }
        String jSONArray2 = jSONArray.toString();
        if (a(context, jSONArray2)) {
            if (bh.c().b()) {
                bh c3 = bh.c();
                c3.a("checkExceedLogLimit exceed:true; mCacheLogSize: " + this.f36496e + "; addedSize:" + jSONArray2.length());
            }
            d(context);
        }
        a(this.f36501j, jSONArray);
    }

    private void b(JSONArray jSONArray, JSONArray jSONArray2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65561, this, jSONArray, jSONArray2) == null) || jSONArray == null || jSONArray2 == null) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            try {
                JSONObject jSONObject = jSONArray2.getJSONObject(i2);
                if (jSONObject != null && jSONObject.length() != 0) {
                    JSONObject jSONObject2 = null;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= jSONArray.length()) {
                            break;
                        }
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                        if (jSONObject3 != null && jSONObject3.length() != 0 && a(jSONObject3, jSONObject)) {
                            jSONObject2 = jSONObject3;
                            break;
                        }
                        i3++;
                    }
                    if (jSONObject2 == null) {
                        jSONArray.put(jSONObject);
                    } else {
                        b(jSONObject2, jSONObject);
                    }
                }
            } catch (Exception unused) {
                return;
            }
        }
    }

    private void a(JSONArray jSONArray, JSONArray jSONArray2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65549, this, jSONArray, jSONArray2) == null) || jSONArray == null || jSONArray2 == null) {
            return;
        }
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            try {
                jSONArray.put(jSONArray2.getJSONObject(i2));
            } catch (Exception unused) {
                return;
            }
        }
    }

    private boolean a(JSONObject jSONObject, JSONObject jSONObject2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, this, jSONObject, jSONObject2)) == null) {
            if (jSONObject == null || jSONObject2 == null) {
                return false;
            }
            String optString = jSONObject.optString("id");
            jSONObject.optString("d");
            String optString2 = jSONObject.optString("p");
            String optString3 = jSONObject.optString("path");
            String optString4 = jSONObject.optString("title");
            String optString5 = jSONObject.optString("index");
            String optString6 = jSONObject.optString("n");
            int optInt = jSONObject.optInt("user");
            jSONObject.optInt("c");
            jSONObject.optLong("t");
            jSONObject.optString("ps");
            String optString7 = jSONObject2.optString("id");
            jSONObject2.optString("d");
            String optString8 = jSONObject2.optString("p");
            String optString9 = jSONObject2.optString("path");
            String optString10 = jSONObject2.optString("title");
            String optString11 = jSONObject2.optString("index");
            String optString12 = jSONObject2.optString("n");
            int optInt2 = jSONObject2.optInt("user");
            jSONObject2.optInt("c");
            jSONObject2.optLong("t");
            jSONObject2.optString("ps");
            return a(optString, optString7) && a(optString2, optString8) && a(optString3, optString9) && a(optString4, optString10) && a(optString5, optString11) && a(optString6, optString12) && optInt == optInt2;
        }
        return invokeLL.booleanValue;
    }

    private void b(JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        String str2;
        String str3;
        long j2;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65563, this, jSONObject, jSONObject2) == null) {
            String optString = jSONObject.optString("d");
            int optInt = jSONObject.optInt("c");
            long optLong = jSONObject.optLong("t");
            String optString2 = jSONObject.optString("ps");
            String optString3 = jSONObject2.optString("d");
            int optInt2 = jSONObject2.optInt("c");
            long optLong2 = jSONObject2.optLong("t");
            String optString4 = jSONObject2.optString("ps");
            int i2 = optInt + optInt2;
            int i3 = (optLong > optLong2 ? 1 : (optLong == optLong2 ? 0 : -1));
            long j4 = i3 <= 0 ? optLong : optLong2;
            if (i3 <= 0) {
                str = "ps";
                str2 = optString + "|" + optString3;
            } else {
                str = "ps";
                str2 = optString3 + "|" + optString;
            }
            int i4 = 0;
            long j5 = 0;
            if (i3 <= 0) {
                long j6 = optLong2 - optLong;
                StringBuilder sb = new StringBuilder();
                String[] split = optString4.split("\\|");
                if (split != null && split.length != 0) {
                    int length = split.length;
                    while (i4 < length) {
                        String str4 = split[i4];
                        if (!TextUtils.isEmpty(sb.toString())) {
                            sb.append("|");
                        }
                        try {
                            j3 = Long.valueOf(str4).longValue();
                        } catch (Exception unused) {
                            j3 = 0;
                        }
                        sb.append(j3 + j6);
                        i4++;
                    }
                } else {
                    try {
                        j5 = Long.valueOf(optString4).longValue();
                    } catch (Exception unused2) {
                    }
                    sb.append(j6 + j5);
                }
                str3 = optString2 + "|" + sb.toString();
            } else {
                long j7 = optLong - optLong2;
                StringBuilder sb2 = new StringBuilder();
                String[] split2 = optString2.split("\\|");
                if (split2 != null && split2.length != 0) {
                    int length2 = split2.length;
                    while (i4 < length2) {
                        String str5 = split2[i4];
                        if (!TextUtils.isEmpty(sb2.toString())) {
                            sb2.append("|");
                        }
                        try {
                            j2 = Long.valueOf(str5).longValue();
                        } catch (Exception unused3) {
                            j2 = 0;
                        }
                        sb2.append(j2 + j7);
                        i4++;
                    }
                } else {
                    try {
                        j5 = Long.valueOf(optString2).longValue();
                    } catch (Exception unused4) {
                    }
                    sb2.append(j7 + j5);
                }
                str3 = optString4 + "|" + sb2.toString();
            }
            try {
                jSONObject.put("c", i2);
                jSONObject.put("t", j4);
                jSONObject.put("d", str2);
                jSONObject.put(str, str3);
            } catch (Exception unused5) {
            }
        }
    }

    private boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, this, str, str2)) == null) {
            if (str == str2) {
                return true;
            }
            return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.equals(str2)) ? false : true;
        }
        return invokeLL.booleanValue;
    }
}
