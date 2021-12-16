package c.a.s0.h2;

import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
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
/* loaded from: classes7.dex */
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
    public String f18056b;

    /* renamed from: c  reason: collision with root package name */
    public String f18057c;

    /* renamed from: d  reason: collision with root package name */
    public String f18058d;

    /* renamed from: e  reason: collision with root package name */
    public String f18059e;

    /* renamed from: f  reason: collision with root package name */
    public String f18060f;

    /* renamed from: g  reason: collision with root package name */
    public String f18061g;

    /* renamed from: h  reason: collision with root package name */
    public int f18062h;

    /* renamed from: i  reason: collision with root package name */
    public int f18063i;

    /* renamed from: j  reason: collision with root package name */
    public List<c.a.s0.c3.b> f18064j;

    /* renamed from: k  reason: collision with root package name */
    public Map<String, Long> f18065k;
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

    /* loaded from: classes7.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int b2 = c.a.r0.t.e.g.b();
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
                c.a.s0.e4.e.h().k(jSONObject, !this.a.s);
                if (this.a.y == null) {
                    this.a.y.clear();
                    return null;
                }
                return null;
            }
            JSONObject t = this.a.t();
            t.put("running", this.a.w());
            jSONObject.put("debugInfo", t);
            c.a.s0.e4.e.h().k(jSONObject, !this.a.s);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        this.f18056b = UUID.randomUUID().toString();
        this.f18057c = str;
        this.f18058d = str2;
        this.f18061g = str3;
        this.f18065k = new HashMap();
        this.f18064j = new ArrayList();
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
        int b2 = c.a.r0.t.e.g.b();
        if ((c.a.r0.t.e.g.c() || !this.s) && b2 != 3) {
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

    @Override // c.a.s0.h2.h
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.r = z;
            this.f18064j.add(new c.a.s0.c3.a(1));
            this.a = 1;
        }
    }

    @Override // c.a.s0.h2.h
    public void b(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.D = z;
            this.E = z2;
        }
    }

    @Override // c.a.s0.h2.h
    public void c(long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            this.A = j2;
            this.B = j3;
            this.C = j4;
        }
    }

    @Override // c.a.s0.h2.h
    public boolean d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            int i2 = this.a;
            if (i2 == 8 || i2 == 7 || i2 == 6 || i2 == -1 || i2 == 1) {
                return false;
            }
            this.f18059e = VideoPlatformStatic.a(str);
            this.f18060f = str2;
            y();
            this.f18064j.add(new c.a.s0.c3.a(207));
            this.a = 7;
            A();
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.s0.h2.h
    public String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            int i2 = this.a;
            if (i2 != 8 && i2 != 7 && i2 != 6 && i2 != -1) {
                this.f18059e = VideoPlatformStatic.a(str);
                this.f18060f = str2;
                y();
                this.f18065k.put("stallDuration", Long.valueOf(this.p));
                this.f18064j.add(new c.a.s0.c3.a(206));
                this.a = 6;
                A();
                return this.f18056b;
            }
            return this.f18056b;
        }
        return (String) invokeLL.objValue;
    }

    @Override // c.a.s0.h2.h
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i2 = this.a;
            if (i2 == 4 || i2 == 3) {
                if (this.m != 0) {
                    this.n += System.currentTimeMillis() - this.m;
                    this.m = 0L;
                }
                this.f18064j.add(new c.a.s0.c3.a(203));
                this.a = 5;
            }
        }
    }

    @Override // c.a.s0.h2.h
    public void g(long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            this.o++;
            this.p += j2;
            this.q.add(Integer.valueOf(i2));
        }
    }

    @Override // c.a.s0.h2.h
    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            int i3 = this.a;
            if (i3 == 5) {
                z();
            } else if (i3 != 3) {
            } else {
                this.f18062h = i2;
                this.m = System.currentTimeMillis();
                this.f18064j.add(new c.a.s0.c3.a(200));
                this.a = 4;
            }
        }
    }

    @Override // c.a.s0.h2.h
    public void i(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (i3 = this.a) == 4 || i3 == 5 || i3 == 7 || i3 == 8) {
            return;
        }
        this.f18062h = i2;
        this.s = true;
        this.t = true;
        this.f18065k.put("loadingTime", 1L);
        this.l = 0L;
        this.f18064j.add(new c.a.s0.c3.a(103));
        this.a = 3;
    }

    @Override // c.a.s0.h2.h
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l = System.currentTimeMillis();
            this.f18064j.add(new c.a.s0.c3.a(3));
            this.a = 0;
        }
    }

    @Override // c.a.s0.h2.h
    public void k(String str, String str2) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) || (i2 = this.a) == 8 || i2 == 7 || i2 == 6 || i2 == -1) {
            return;
        }
        this.f18059e = VideoPlatformStatic.a(str);
        this.f18060f = str2;
        y();
        this.f18064j.add(new c.a.s0.c3.a(205));
        this.a = 8;
        A();
    }

    @Override // c.a.s0.h2.h
    public void l(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (i3 = this.a) == 4 || i3 == 5 || i3 == 7 || i3 == 8) {
            return;
        }
        this.f18062h = i2;
        this.s = true;
        long currentTimeMillis = System.currentTimeMillis() - this.l;
        if (currentTimeMillis > 86400000) {
            currentTimeMillis = 10000;
        }
        this.f18065k.put("loadingTime", Long.valueOf(currentTimeMillis));
        this.l = 0L;
        this.f18064j.add(new c.a.s0.c3.a(102));
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
                    for (int i2 = 0; i2 < size; i2++) {
                        this.y.get(i2).c(c2);
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
                jSONObject.put("uuid", this.f18056b);
                if (!StringUtils.isNull(this.f18061g)) {
                    jSONObject.put("parentUuid", this.f18061g);
                }
                jSONObject.put("tid", this.f18057c);
                jSONObject.put("videoUrl", this.f18058d);
                jSONObject.put("source", this.f18059e);
                jSONObject.put("playerType", VideoPlatformStatic.b(this.f18062h));
                jSONObject.put("urlType", this.f18063i);
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
                    for (int i2 = 0; i2 < size; i2++) {
                        this.y.get(i2).b(jSONObject);
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
                for (Map.Entry<String, Long> entry : this.f18065k.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                if (!this.f18065k.containsKey("loadingTime")) {
                    jSONObject.put("loadingTime", 0L);
                }
                if (!this.f18065k.containsKey("playDuration")) {
                    jSONObject.put("playDuration", 0L);
                }
                if (!this.f18065k.containsKey("stallCount")) {
                    jSONObject.put("stallCount", 0);
                }
                if (!this.f18065k.containsKey("stallDuration")) {
                    jSONObject.put("stallDuration", 0L);
                }
                int i2 = 1;
                jSONObject.put("isCacheHit", this.r ? 1 : 0);
                jSONObject.put("playSuccess", this.s ? 1 : 0);
                jSONObject.put("startPlayTimeInfo", v());
                if (!this.u) {
                    i2 = 0;
                }
                jSONObject.put("retryError", i2);
                jSONObject.put("error", this.v);
                if (this.y != null) {
                    int size = this.y.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        this.y.get(i3).a(jSONObject);
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
                jSONObject.put("startTime", this.B);
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
            List<c.a.s0.c3.b> list = this.f18064j;
            if (list == null) {
                return jSONArray;
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                jSONArray.put(this.f18064j.get(i2).a());
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && c.a.r0.r0.k.d().g() && this.f18065k != null) {
            c.a.d.f.n.a a2 = c.a.r0.r0.j.a();
            a2.b("action", "video_monitor");
            a2.c("play_time", this.f18065k.get("playDuration"));
            a2.c("caton_time", this.f18065k.get("stallDuration"));
            a2.c("loading_time", Long.valueOf(this.C));
            Object[] objArr = new Object[2];
            objArr[0] = "pcdn";
            objArr[1] = Integer.valueOf((this.E ? 2 : 0) | (this.D ? 1 : 0));
            a2.c(objArr);
            a2.c("hit_cache", Boolean.valueOf(this.r));
            a2.c("direct_play", Integer.valueOf(this.t ? 1 : 0));
            a2.b("page_code", this.f18060f);
            a2.b("nettype", c.a.d.f.n.e.a(BdBaseApplication.getInst()));
            BdStatisticsManager.getInstance().performance("video", a2);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.m != 0) {
                this.n += System.currentTimeMillis() - this.m;
            }
            this.f18065k.put("playDuration", Long.valueOf(this.n));
            this.f18065k.put("stallCount", Long.valueOf(this.o));
            this.f18065k.put("stallDuration", Long.valueOf(this.p));
            if (!this.f18065k.containsKey("loadingTime")) {
                this.f18065k.put("loadingTime", 0L);
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
            this.f18064j.add(new c.a.s0.c3.a(204));
            this.a = 4;
        }
    }
}
