package c.a.o0.e;

import c.a.o0.a;
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

    /* renamed from: c.a.o0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0191a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0189a f4217e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4218f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4219g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ArrayList f4220h;

        /* renamed from: c.a.o0.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0192a extends c.a.o0.k.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a.InterfaceC0189a f4221f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ RunnableC0191a f4222g;

            public C0192a(RunnableC0191a runnableC0191a, a.InterfaceC0189a interfaceC0189a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0191a, interfaceC0189a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4222g = runnableC0191a;
                this.f4221f = interfaceC0189a;
            }

            @Override // c.a.o0.k.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f4221f.onFinish(this.f4222g.f4218f);
                }
            }
        }

        public RunnableC0191a(a.InterfaceC0189a interfaceC0189a, String str, int i2, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC0189a, str, Integer.valueOf(i2), arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4217e = interfaceC0189a;
            this.f4218f = str;
            this.f4219g = i2;
            this.f4220h = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4217e.onFinish(this.f4218f);
                if (this.f4219g != 1 || this.f4220h == null) {
                    return;
                }
                for (int i2 = 0; i2 < this.f4220h.size(); i2++) {
                    a.InterfaceC0189a interfaceC0189a = (a.InterfaceC0189a) this.f4220h.get(i2);
                    if (interfaceC0189a != null) {
                        c.a.o0.k.e.c().b(new C0192a(this, interfaceC0189a));
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

    public static void b(a.InterfaceC0189a interfaceC0189a, h hVar, int i2, ArrayList<a.InterfaceC0189a> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{interfaceC0189a, hVar, Integer.valueOf(i2), arrayList, Boolean.valueOf(z)}) == null) || hVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", hVar.a);
            jSONObject.put("1", hVar.f4286b);
            jSONObject.put("2", String.valueOf(hVar.f4287c));
            jSONObject.put("3", hVar.f4288d);
            String jSONObject2 = jSONObject.toString();
            if (interfaceC0189a != null) {
                if (i2 == 1) {
                    if (z) {
                        c.a.o0.c.a.c().f(false);
                    }
                } else if (i2 == 2) {
                    if (z) {
                        c.a.o0.c.a.c().d(false);
                    }
                } else if (i2 == 3) {
                    if (z) {
                        c.a.o0.c.a.c().j(false);
                    }
                } else if (z) {
                    c.a.o0.c.a.c().m(false);
                }
                new Thread(new RunnableC0191a(interfaceC0189a, jSONObject2, i2, arrayList)).start();
            }
        } catch (Throwable th) {
            c.a.o0.l.c.d(th);
        }
    }
}
