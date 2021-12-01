package c.a.n0.e;

import c.a.n0.a;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0157a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0155a f3908e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f3909f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f3910g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ArrayList f3911h;

        /* renamed from: c.a.n0.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0158a extends c.a.n0.k.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a.InterfaceC0155a f3912f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ RunnableC0157a f3913g;

            public C0158a(RunnableC0157a runnableC0157a, a.InterfaceC0155a interfaceC0155a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0157a, interfaceC0155a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f3913g = runnableC0157a;
                this.f3912f = interfaceC0155a;
            }

            @Override // c.a.n0.k.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f3912f.onFinish(this.f3913g.f3909f);
                }
            }
        }

        public RunnableC0157a(a.InterfaceC0155a interfaceC0155a, String str, int i2, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC0155a, str, Integer.valueOf(i2), arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3908e = interfaceC0155a;
            this.f3909f = str;
            this.f3910g = i2;
            this.f3911h = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3908e.onFinish(this.f3909f);
                if (this.f3910g != 1 || this.f3911h == null) {
                    return;
                }
                for (int i2 = 0; i2 < this.f3911h.size(); i2++) {
                    a.InterfaceC0155a interfaceC0155a = (a.InterfaceC0155a) this.f3911h.get(i2);
                    if (interfaceC0155a != null) {
                        c.a.n0.k.e.c().b(new C0158a(this, interfaceC0155a));
                    }
                }
            }
        }
    }

    public static int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) {
            if (i2 == 1) {
                return 2010;
            }
            if (i2 == 2) {
                return 2011;
            }
            if (i2 == 3) {
                return 2012;
            }
            if (i2 == 4) {
                return 2013;
            }
            if (i2 == 5) {
                return 2014;
            }
            if (i2 == 6) {
                return SpeedStatsStampTable.INIT_VERSION_STAMP_KEY;
            }
            return 2009;
        }
        return invokeI.intValue;
    }

    public static void b(a.InterfaceC0155a interfaceC0155a, h hVar, int i2, ArrayList<a.InterfaceC0155a> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{interfaceC0155a, hVar, Integer.valueOf(i2), arrayList, Boolean.valueOf(z)}) == null) || hVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", hVar.a);
            jSONObject.put("1", hVar.f3977b);
            jSONObject.put("2", String.valueOf(hVar.f3978c));
            jSONObject.put("3", hVar.f3979d);
            String jSONObject2 = jSONObject.toString();
            if (interfaceC0155a != null) {
                if (i2 == 1) {
                    if (z) {
                        c.a.n0.c.a.c().f(false);
                    }
                } else if (i2 == 2) {
                    if (z) {
                        c.a.n0.c.a.c().d(false);
                    }
                } else if (i2 == 3) {
                    if (z) {
                        c.a.n0.c.a.c().j(false);
                    }
                } else if (z) {
                    c.a.n0.c.a.c().m(false);
                }
                new Thread(new RunnableC0157a(interfaceC0155a, jSONObject2, i2, arrayList)).start();
            }
        } catch (Throwable th) {
            c.a.n0.l.c.d(th);
        }
    }
}
