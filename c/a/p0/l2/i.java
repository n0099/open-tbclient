package c.a.p0.l2;

import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.tieba.VideoPlatformStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class i implements h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public long B;
    public long C;
    public boolean D;
    public boolean E;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f16085b;

    /* renamed from: c  reason: collision with root package name */
    public String f16086c;

    /* renamed from: d  reason: collision with root package name */
    public String f16087d;

    /* renamed from: e  reason: collision with root package name */
    public String f16088e;

    /* renamed from: f  reason: collision with root package name */
    public String f16089f;

    /* renamed from: g  reason: collision with root package name */
    public String f16090g;

    /* renamed from: h  reason: collision with root package name */
    public int f16091h;
    public int i;
    public List<c.a.p0.e3.b> j;
    public Map<String, Long> k;
    public long l;
    public long m;
    public long n;
    public long o;
    public long p;
    public ArrayList<Integer> q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public boolean w;
    public String x;
    public List<b> y;
    public int z;

    /* loaded from: classes2.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i a;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) != null) {
                return (Void) invokeL.objValue;
            }
            int b2 = c.a.o0.s.e.g.b();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("baseInfo", this.a.s());
                jSONObject.put("kpiInfo", this.a.u());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (b2 != 0 && (b2 != 4 || !this.a.s)) {
                if (b2 == 2) {
                    jSONObject.put("debugInfo", this.a.t());
                }
                c.a.p0.i4.e.h().k(jSONObject, !this.a.s);
                if (this.a.y == null) {
                    this.a.y.clear();
                    return null;
                }
                return null;
            }
            JSONObject t = this.a.t();
            t.put("running", this.a.w());
            jSONObject.put("debugInfo", t);
            c.a.p0.i4.e.h().k(jSONObject, !this.a.s);
            if (this.a.y == null) {
            }
        }
    }

    public i(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.s = true;
        this.t = false;
        this.u = false;
        this.D = false;
        this.E = false;
        this.a = 0;
        this.f16085b = UUID.randomUUID().toString();
        this.f16086c = str;
        this.f16087d = str2;
        this.f16090g = str3;
        this.k = new HashMap();
        this.j = new ArrayList();
        this.l = 0L;
        this.m = 0L;
        this.n = 0L;
        this.q = new ArrayList<>();
        B();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.w) {
            return;
        }
        x();
        int b2 = c.a.o0.s.e.g.b();
        if ((c.a.o0.s.e.g.c() || !this.s) && b2 != 3) {
            this.w = true;
            new a(this).execute(new Void[0]);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.A = 0L;
            this.B = 0L;
            this.C = 0L;
        }
    }

    @Override // c.a.p0.l2.h
    public void a(long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.A = j;
            this.B = j2;
            this.C = j3;
        }
    }

    @Override // c.a.p0.l2.h
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.r = z;
            this.j.add(new c.a.p0.e3.a(1));
            this.a = 1;
        }
    }

    @Override // c.a.p0.l2.h
    public void c(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.D = z;
            this.E = z2;
        }
    }

    @Override // c.a.p0.l2.h
    public boolean d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            int i = this.a;
            if (i == 8 || i == 7 || i == 6 || i == -1 || i == 1) {
                return false;
            }
            this.f16088e = VideoPlatformStatic.a(str);
            this.f16089f = str2;
            y();
            this.j.add(new c.a.p0.e3.a(207));
            this.a = 7;
            A();
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.p0.l2.h
    public String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            int i = this.a;
            if (i != 8 && i != 7 && i != 6 && i != -1) {
                this.f16088e = VideoPlatformStatic.a(str);
                this.f16089f = str2;
                y();
                this.k.put("stallDuration", Long.valueOf(this.p));
                this.j.add(new c.a.p0.e3.a(206));
                this.a = 6;
                A();
                return this.f16085b;
            }
            return this.f16085b;
        }
        return (String) invokeLL.objValue;
    }

    @Override // c.a.p0.l2.h
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i = this.a;
            if (i == 4 || i == 3) {
                if (this.m != 0) {
                    this.n += System.currentTimeMillis() - this.m;
                    this.m = 0L;
                }
                this.j.add(new c.a.p0.e3.a(203));
                this.a = 5;
            }
        }
    }

    @Override // c.a.p0.l2.h
    public void g(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            this.o++;
            this.p += j;
            this.q.add(Integer.valueOf(i));
        }
    }

    @Override // c.a.p0.l2.h
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            int i2 = this.a;
            if (i2 == 5) {
                z();
            } else if (i2 != 3) {
            } else {
                this.f16091h = i;
                this.m = System.currentTimeMillis();
                this.j.add(new c.a.p0.e3.a(200));
                this.a = 4;
            }
        }
    }

    @Override // c.a.p0.l2.h
    public void i(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i) == null) || (i2 = this.a) == 4 || i2 == 5 || i2 == 7 || i2 == 8) {
            return;
        }
        this.f16091h = i;
        this.s = true;
        this.t = true;
        this.k.put("loadingTime", 1L);
        this.l = 0L;
        this.j.add(new c.a.p0.e3.a(103));
        this.a = 3;
    }

    @Override // c.a.p0.l2.h
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l = System.currentTimeMillis();
            this.j.add(new c.a.p0.e3.a(3));
            this.a = 0;
        }
    }

    @Override // c.a.p0.l2.h
    public void k(String str, String str2) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) || (i = this.a) == 8 || i == 7 || i == 6 || i == -1) {
            return;
        }
        this.f16088e = VideoPlatformStatic.a(str);
        this.f16089f = str2;
        y();
        this.j.add(new c.a.p0.e3.a(205));
        this.a = 8;
        A();
    }

    @Override // c.a.p0.l2.h
    public void l(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i) == null) || (i2 = this.a) == 4 || i2 == 5 || i2 == 7 || i2 == 8) {
            return;
        }
        this.f16091h = i;
        this.s = true;
        long currentTimeMillis = System.currentTimeMillis() - this.l;
        if (currentTimeMillis > 86400000) {
            currentTimeMillis = 10000;
        }
        this.k.put("loadingTime", Long.valueOf(currentTimeMillis));
        this.l = 0L;
        this.j.add(new c.a.p0.e3.a(102));
        this.a = 3;
    }

    public final JSONObject s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            JSONObject c2 = VideoPlatformStatic.c();
            List<b> list = this.y;
            if (list != null) {
                try {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        this.y.get(i).c(c2);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return c2;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONObject t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("uuid", this.f16085b);
                if (!StringUtils.isNull(this.f16090g)) {
                    jSONObject.put("parentUuid", this.f16090g);
                }
                jSONObject.put("tid", this.f16086c);
                jSONObject.put("videoUrl", this.f16087d);
                jSONObject.put("source", this.f16088e);
                jSONObject.put("playerType", VideoPlatformStatic.b(this.f16091h));
                jSONObject.put("urlType", this.i);
                jSONObject.put("sub_error", this.z);
                jSONObject.put("current_pid", Process.myPid());
                jSONObject.put("directPrepare", this.t ? 1 : 0);
                jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
                jSONObject.put("stallTypes", this.q);
                String str = "1";
                jSONObject.put("pcdn_used", this.D ? "1" : "0");
                if (!this.E) {
                    str = "0";
                }
                jSONObject.put("p2p_used", str);
                if (!StringUtils.isNull(this.x)) {
                    jSONObject.put("error_stack", this.x);
                }
                if (this.y != null) {
                    int size = this.y.size();
                    for (int i = 0; i < size; i++) {
                        this.y.get(i).b(jSONObject);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONObject u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, Long> entry : this.k.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                if (!this.k.containsKey("loadingTime")) {
                    jSONObject.put("loadingTime", 0L);
                }
                if (!this.k.containsKey("playDuration")) {
                    jSONObject.put("playDuration", 0L);
                }
                if (!this.k.containsKey("stallCount")) {
                    jSONObject.put("stallCount", 0);
                }
                if (!this.k.containsKey("stallDuration")) {
                    jSONObject.put("stallDuration", 0L);
                }
                int i = 1;
                jSONObject.put("isCacheHit", this.r ? 1 : 0);
                jSONObject.put("playSuccess", this.s ? 1 : 0);
                jSONObject.put("startPlayTimeInfo", v());
                if (!this.u) {
                    i = 0;
                }
                jSONObject.put("retryError", i);
                jSONObject.put("error", this.v);
                if (this.y != null) {
                    int size = this.y.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        this.y.get(i2).a(jSONObject);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONObject v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("preparedTime", this.A);
                jSONObject.put(FetchLog.START_TIME, this.B);
                jSONObject.put("totalTime", this.C);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            B();
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONArray w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            List<c.a.p0.e3.b> list = this.j;
            if (list == null) {
                return jSONArray;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                jSONArray.put(this.j.get(i).a());
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && this.k != null) {
            c.a.d.f.n.a a2 = c.a.o0.r0.j.a();
            a2.b("action", "video_monitor");
            a2.c("play_time", this.k.get("playDuration"));
            a2.c("caton_time", this.k.get("stallDuration"));
            a2.c("loading_time", Long.valueOf(this.C));
            Object[] objArr = new Object[2];
            objArr[0] = "pcdn";
            objArr[1] = Integer.valueOf((this.E ? 2 : 0) | (this.D ? 1 : 0));
            a2.c(objArr);
            a2.c("hit_cache", Boolean.valueOf(this.r));
            a2.c("direct_play", Integer.valueOf(this.t ? 1 : 0));
            a2.b("page_code", this.f16089f);
            a2.b(FpsTracer.UBC_KEY_NET_TYPE, c.a.d.f.n.e.a(BdBaseApplication.getInst()));
            BdStatisticsManager.getInstance().performance("video", a2);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.m != 0) {
                this.n += System.currentTimeMillis() - this.m;
            }
            this.k.put("playDuration", Long.valueOf(this.n));
            this.k.put("stallCount", Long.valueOf(this.o));
            this.k.put("stallDuration", Long.valueOf(this.p));
            if (!this.k.containsKey("loadingTime")) {
                this.k.put("loadingTime", 0L);
            }
            this.l = 0L;
            this.m = 0L;
            this.n = 0L;
            this.o = 0L;
            this.p = 0L;
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && this.a == 5) {
            this.m = System.currentTimeMillis();
            this.j.add(new c.a.p0.e3.a(204));
            this.a = 4;
        }
    }
}
