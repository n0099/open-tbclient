package b.a.n0.e;

import b.a.n0.a;
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

    /* renamed from: b.a.n0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0099a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0097a f3534e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f3535f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f3536g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ArrayList f3537h;

        /* renamed from: b.a.n0.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0100a extends b.a.n0.k.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a.InterfaceC0097a f3538f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ RunnableC0099a f3539g;

            public C0100a(RunnableC0099a runnableC0099a, a.InterfaceC0097a interfaceC0097a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0099a, interfaceC0097a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f3539g = runnableC0099a;
                this.f3538f = interfaceC0097a;
            }

            @Override // b.a.n0.k.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f3538f.onFinish(this.f3539g.f3535f);
                }
            }
        }

        public RunnableC0099a(a.InterfaceC0097a interfaceC0097a, String str, int i2, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC0097a, str, Integer.valueOf(i2), arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3534e = interfaceC0097a;
            this.f3535f = str;
            this.f3536g = i2;
            this.f3537h = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3534e.onFinish(this.f3535f);
                if (this.f3536g != 1 || this.f3537h == null) {
                    return;
                }
                for (int i2 = 0; i2 < this.f3537h.size(); i2++) {
                    a.InterfaceC0097a interfaceC0097a = (a.InterfaceC0097a) this.f3537h.get(i2);
                    if (interfaceC0097a != null) {
                        b.a.n0.k.e.c().b(new C0100a(this, interfaceC0097a));
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

    public static void b(a.InterfaceC0097a interfaceC0097a, h hVar, int i2, ArrayList<a.InterfaceC0097a> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{interfaceC0097a, hVar, Integer.valueOf(i2), arrayList, Boolean.valueOf(z)}) == null) || hVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", hVar.f3615a);
            jSONObject.put("1", hVar.f3616b);
            jSONObject.put("2", String.valueOf(hVar.f3617c));
            jSONObject.put("3", hVar.f3618d);
            String jSONObject2 = jSONObject.toString();
            if (interfaceC0097a != null) {
                if (i2 == 1) {
                    if (z) {
                        b.a.n0.c.a.c().f(false);
                    }
                } else if (i2 == 2) {
                    if (z) {
                        b.a.n0.c.a.c().d(false);
                    }
                } else if (i2 == 3) {
                    if (z) {
                        b.a.n0.c.a.c().j(false);
                    }
                } else if (z) {
                    b.a.n0.c.a.c().m(false);
                }
                new Thread(new RunnableC0099a(interfaceC0097a, jSONObject2, i2, arrayList)).start();
            }
        } catch (Throwable th) {
            b.a.n0.l.c.d(th);
        }
    }
}
