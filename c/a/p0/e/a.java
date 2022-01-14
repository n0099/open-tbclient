package c.a.p0.e;

import c.a.p0.a;
import com.baidu.android.imsdk.IMConstants;
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

    /* renamed from: c.a.p0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0224a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0222a f4574e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4575f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4576g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ArrayList f4577h;

        /* renamed from: c.a.p0.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0225a extends c.a.p0.k.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a.InterfaceC0222a f4578f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ RunnableC0224a f4579g;

            public C0225a(RunnableC0224a runnableC0224a, a.InterfaceC0222a interfaceC0222a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0224a, interfaceC0222a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4579g = runnableC0224a;
                this.f4578f = interfaceC0222a;
            }

            @Override // c.a.p0.k.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f4578f.onFinish(this.f4579g.f4575f);
                }
            }
        }

        public RunnableC0224a(a.InterfaceC0222a interfaceC0222a, String str, int i2, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC0222a, str, Integer.valueOf(i2), arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4574e = interfaceC0222a;
            this.f4575f = str;
            this.f4576g = i2;
            this.f4577h = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4574e.onFinish(this.f4575f);
                if (this.f4576g != 1 || this.f4577h == null) {
                    return;
                }
                for (int i2 = 0; i2 < this.f4577h.size(); i2++) {
                    a.InterfaceC0222a interfaceC0222a = (a.InterfaceC0222a) this.f4577h.get(i2);
                    if (interfaceC0222a != null) {
                        c.a.p0.k.e.c().b(new C0225a(this, interfaceC0222a));
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
            return i2 == 3 ? IMConstants.IM_MSG_TYPE_SHIELD_ME : i2 == 4 ? IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME : i2 == 5 ? IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME_SEND_FAIL : i2 == 6 ? 2015 : 2009;
        }
        return invokeI.intValue;
    }

    public static void b(a.InterfaceC0222a interfaceC0222a, h hVar, int i2, ArrayList<a.InterfaceC0222a> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{interfaceC0222a, hVar, Integer.valueOf(i2), arrayList, Boolean.valueOf(z)}) == null) || hVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", hVar.a);
            jSONObject.put("1", hVar.f4643b);
            jSONObject.put("2", String.valueOf(hVar.f4644c));
            jSONObject.put("3", hVar.f4645d);
            String jSONObject2 = jSONObject.toString();
            if (interfaceC0222a != null) {
                if (i2 == 1) {
                    if (z) {
                        c.a.p0.c.a.c().f(false);
                    }
                } else if (i2 == 2) {
                    if (z) {
                        c.a.p0.c.a.c().d(false);
                    }
                } else if (i2 == 3) {
                    if (z) {
                        c.a.p0.c.a.c().j(false);
                    }
                } else if (z) {
                    c.a.p0.c.a.c().m(false);
                }
                new Thread(new RunnableC0224a(interfaceC0222a, jSONObject2, i2, arrayList)).start();
            }
        } catch (Throwable th) {
            c.a.p0.l.c.d(th);
        }
    }
}
