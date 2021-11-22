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
    public static class RunnableC0101a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0099a f3624e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f3625f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f3626g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ArrayList f3627h;

        /* renamed from: b.a.n0.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0102a extends b.a.n0.k.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a.InterfaceC0099a f3628f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ RunnableC0101a f3629g;

            public C0102a(RunnableC0101a runnableC0101a, a.InterfaceC0099a interfaceC0099a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0101a, interfaceC0099a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f3629g = runnableC0101a;
                this.f3628f = interfaceC0099a;
            }

            @Override // b.a.n0.k.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f3628f.onFinish(this.f3629g.f3625f);
                }
            }
        }

        public RunnableC0101a(a.InterfaceC0099a interfaceC0099a, String str, int i2, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC0099a, str, Integer.valueOf(i2), arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3624e = interfaceC0099a;
            this.f3625f = str;
            this.f3626g = i2;
            this.f3627h = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f3624e.onFinish(this.f3625f);
                if (this.f3626g != 1 || this.f3627h == null) {
                    return;
                }
                for (int i2 = 0; i2 < this.f3627h.size(); i2++) {
                    a.InterfaceC0099a interfaceC0099a = (a.InterfaceC0099a) this.f3627h.get(i2);
                    if (interfaceC0099a != null) {
                        b.a.n0.k.e.c().b(new C0102a(this, interfaceC0099a));
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

    public static void b(a.InterfaceC0099a interfaceC0099a, h hVar, int i2, ArrayList<a.InterfaceC0099a> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{interfaceC0099a, hVar, Integer.valueOf(i2), arrayList, Boolean.valueOf(z)}) == null) || hVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", hVar.f3705a);
            jSONObject.put("1", hVar.f3706b);
            jSONObject.put("2", String.valueOf(hVar.f3707c));
            jSONObject.put("3", hVar.f3708d);
            String jSONObject2 = jSONObject.toString();
            if (interfaceC0099a != null) {
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
                new Thread(new RunnableC0101a(interfaceC0099a, jSONObject2, i2, arrayList)).start();
            }
        } catch (Throwable th) {
            b.a.n0.l.c.d(th);
        }
    }
}
