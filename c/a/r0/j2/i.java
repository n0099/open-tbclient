package c.a.r0.j2;

import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
    public String f18294b;

    /* renamed from: c  reason: collision with root package name */
    public String f18295c;

    /* renamed from: d  reason: collision with root package name */
    public String f18296d;

    /* renamed from: e  reason: collision with root package name */
    public String f18297e;

    /* renamed from: f  reason: collision with root package name */
    public String f18298f;

    /* renamed from: g  reason: collision with root package name */
    public String f18299g;

    /* renamed from: h  reason: collision with root package name */
    public int f18300h;

    /* renamed from: i  reason: collision with root package name */
    public int f18301i;

    /* renamed from: j  reason: collision with root package name */
    public List<c.a.r0.c3.b> f18302j;
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
            int b2 = c.a.q0.s.e.g.b();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("baseInfo", this.a.r());
                jSONObject.put("kpiInfo", this.a.t());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (b2 != 0 && (b2 != 4 || !this.a.s)) {
                if (b2 == 2) {
                    jSONObject.put("debugInfo", this.a.s());
                }
                c.a.r0.g4.e.h().k(jSONObject, !this.a.s);
                if (this.a.y == null) {
                    this.a.y.clear();
                    return null;
                }
                return null;
            }
            JSONObject s = this.a.s();
            s.put("running", this.a.v());
            jSONObject.put("debugInfo", s);
            c.a.r0.g4.e.h().k(jSONObject, !this.a.s);
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
        this.f18294b = UUID.randomUUID().toString();
        this.f18295c = str;
        this.f18296d = str2;
        this.f18299g = str3;
        this.k = new HashMap();
        this.f18302j = new ArrayList();
        this.l = 0L;
        this.m = 0L;
        this.n = 0L;
        this.q = new ArrayList<>();
        A();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.A = 0L;
            this.B = 0L;
            this.C = 0L;
        }
    }

    @Override // c.a.r0.j2.h
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.r = z;
            this.f18302j.add(new c.a.r0.c3.a(1));
            this.a = 1;
        }
    }

    @Override // c.a.r0.j2.h
    public void b(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.D = z;
            this.E = z2;
        }
    }

    @Override // c.a.r0.j2.h
    public boolean c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            int i2 = this.a;
            if (i2 == 8 || i2 == 7 || i2 == 6 || i2 == -1 || i2 == 1) {
                return false;
            }
            this.f18297e = VideoPlatformStatic.a(str);
            this.f18298f = str2;
            x();
            this.f18302j.add(new c.a.r0.c3.a(207));
            this.a = 7;
            z();
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.r0.j2.h
    public String d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            int i2 = this.a;
            if (i2 != 8 && i2 != 7 && i2 != 6 && i2 != -1) {
                this.f18297e = VideoPlatformStatic.a(str);
                this.f18298f = str2;
                x();
                this.k.put("stallDuration", Long.valueOf(this.p));
                this.f18302j.add(new c.a.r0.c3.a(206));
                this.a = 6;
                z();
                return this.f18294b;
            }
            return this.f18294b;
        }
        return (String) invokeLL.objValue;
    }

    @Override // c.a.r0.j2.h
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i2 = this.a;
            if (i2 == 4 || i2 == 3) {
                if (this.m != 0) {
                    this.n += System.currentTimeMillis() - this.m;
                    this.m = 0L;
                }
                this.f18302j.add(new c.a.r0.c3.a(203));
                this.a = 5;
            }
        }
    }

    @Override // c.a.r0.j2.h
    public void f(long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            this.o++;
            this.p += j2;
            this.q.add(Integer.valueOf(i2));
        }
    }

    @Override // c.a.r0.j2.h
    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            int i3 = this.a;
            if (i3 == 5) {
                y();
            } else if (i3 != 3) {
            } else {
                this.f18300h = i2;
                this.m = System.currentTimeMillis();
                this.f18302j.add(new c.a.r0.c3.a(200));
                this.a = 4;
            }
        }
    }

    @Override // c.a.r0.j2.h
    public void h(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (i3 = this.a) == 4 || i3 == 5 || i3 == 7 || i3 == 8) {
            return;
        }
        this.f18300h = i2;
        this.s = true;
        this.t = true;
        this.k.put("loadingTime", 1L);
        this.l = 0L;
        this.f18302j.add(new c.a.r0.c3.a(103));
        this.a = 3;
    }

    @Override // c.a.r0.j2.h
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.l = System.currentTimeMillis();
            this.f18302j.add(new c.a.r0.c3.a(3));
            this.a = 0;
        }
    }

    @Override // c.a.r0.j2.h
    public void j(String str, String str2) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) || (i2 = this.a) == 8 || i2 == 7 || i2 == 6 || i2 == -1) {
            return;
        }
        this.f18297e = VideoPlatformStatic.a(str);
        this.f18298f = str2;
        x();
        this.f18302j.add(new c.a.r0.c3.a(205));
        this.a = 8;
        z();
    }

    @Override // c.a.r0.j2.h
    public void k(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (i3 = this.a) == 4 || i3 == 5 || i3 == 7 || i3 == 8) {
            return;
        }
        this.f18300h = i2;
        this.s = true;
        long currentTimeMillis = System.currentTimeMillis() - this.l;
        if (currentTimeMillis > 86400000) {
            currentTimeMillis = 10000;
        }
        this.k.put("loadingTime", Long.valueOf(currentTimeMillis));
        this.l = 0L;
        this.f18302j.add(new c.a.r0.c3.a(102));
        this.a = 3;
    }

    public final JSONObject r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
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

    @Override // c.a.r0.j2.h
    public void recordPlayTimeInfo(long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            this.A = j2;
            this.B = j3;
            this.C = j4;
        }
    }

    public final JSONObject s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("uuid", this.f18294b);
                if (!StringUtils.isNull(this.f18299g)) {
                    jSONObject.put("parentUuid", this.f18299g);
                }
                jSONObject.put("tid", this.f18295c);
                jSONObject.put("videoUrl", this.f18296d);
                jSONObject.put("source", this.f18297e);
                jSONObject.put("playerType", VideoPlatformStatic.b(this.f18300h));
                jSONObject.put("urlType", this.f18301i);
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

    public final JSONObject t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
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
                int i2 = 1;
                jSONObject.put("isCacheHit", this.r ? 1 : 0);
                jSONObject.put("playSuccess", this.s ? 1 : 0);
                jSONObject.put("startPlayTimeInfo", u());
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

    public final JSONObject u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("preparedTime", this.A);
                jSONObject.put(FetchLog.START_TIME, this.B);
                jSONObject.put("totalTime", this.C);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            A();
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONArray v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            List<c.a.r0.c3.b> list = this.f18302j;
            if (list == null) {
                return jSONArray;
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                jSONArray.put(this.f18302j.get(i2).a());
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && this.k != null) {
            c.a.d.f.n.a a2 = c.a.q0.r0.j.a();
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
            a2.b("page_code", this.f18298f);
            a2.b("nettype", c.a.d.f.n.e.a(BdBaseApplication.getInst()));
            BdStatisticsManager.getInstance().performance("video", a2);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
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

    public void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.a == 5) {
            this.m = System.currentTimeMillis();
            this.f18302j.add(new c.a.r0.c3.a(204));
            this.a = 4;
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || this.w) {
            return;
        }
        w();
        int b2 = c.a.q0.s.e.g.b();
        if ((c.a.q0.s.e.g.c() || !this.s) && b2 != 3) {
            this.w = true;
            new a(this).execute(new Void[0]);
        }
    }
}
