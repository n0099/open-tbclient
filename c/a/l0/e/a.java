package c.a.l0.e;

import c.a.l0.a;
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

    /* renamed from: c.a.l0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0091a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0089a f3699e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f3700f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f3701g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ArrayList f3702h;

        /* renamed from: c.a.l0.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0092a extends c.a.l0.k.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a.InterfaceC0089a f3703f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ RunnableC0091a f3704g;

            public C0092a(RunnableC0091a runnableC0091a, a.InterfaceC0089a interfaceC0089a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0091a, interfaceC0089a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f3704g = runnableC0091a;
                this.f3703f = interfaceC0089a;
            }

            @Override // c.a.l0.k.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f3703f.onFinish(this.f3704g.f3700f);
                }
            }
        }

        public RunnableC0091a(a.InterfaceC0089a interfaceC0089a, String str, int i2, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC0089a, str, Integer.valueOf(i2), arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3699e = interfaceC0089a;
            this.f3700f = str;
            this.f3701g = i2;
            this.f3702h = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3699e.onFinish(this.f3700f);
                if (this.f3701g != 1 || this.f3702h == null) {
                    return;
                }
                for (int i2 = 0; i2 < this.f3702h.size(); i2++) {
                    a.InterfaceC0089a interfaceC0089a = (a.InterfaceC0089a) this.f3702h.get(i2);
                    if (interfaceC0089a != null) {
                        c.a.l0.k.e.c().b(new C0092a(this, interfaceC0089a));
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

    public static void b(a.InterfaceC0089a interfaceC0089a, h hVar, int i2, ArrayList<a.InterfaceC0089a> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{interfaceC0089a, hVar, Integer.valueOf(i2), arrayList, Boolean.valueOf(z)}) == null) || hVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", hVar.f3780a);
            jSONObject.put("1", hVar.f3781b);
            jSONObject.put("2", String.valueOf(hVar.f3782c));
            jSONObject.put("3", hVar.f3783d);
            String jSONObject2 = jSONObject.toString();
            if (interfaceC0089a != null) {
                if (i2 == 1) {
                    if (z) {
                        c.a.l0.c.a.c().f(false);
                    }
                } else if (i2 == 2) {
                    if (z) {
                        c.a.l0.c.a.c().d(false);
                    }
                } else if (i2 == 3) {
                    if (z) {
                        c.a.l0.c.a.c().j(false);
                    }
                } else if (z) {
                    c.a.l0.c.a.c().m(false);
                }
                new Thread(new RunnableC0091a(interfaceC0089a, jSONObject2, i2, arrayList)).start();
            }
        } catch (Throwable th) {
            c.a.l0.l.c.d(th);
        }
    }
}
