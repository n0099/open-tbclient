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
    public static class RunnableC0233a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0231a f4716e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4717f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4718g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ArrayList f4719h;

        /* renamed from: c.a.p0.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0234a extends c.a.p0.k.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a.InterfaceC0231a f4720f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ RunnableC0233a f4721g;

            public C0234a(RunnableC0233a runnableC0233a, a.InterfaceC0231a interfaceC0231a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0233a, interfaceC0231a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4721g = runnableC0233a;
                this.f4720f = interfaceC0231a;
            }

            @Override // c.a.p0.k.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f4720f.onFinish(this.f4721g.f4717f);
                }
            }
        }

        public RunnableC0233a(a.InterfaceC0231a interfaceC0231a, String str, int i2, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC0231a, str, Integer.valueOf(i2), arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4716e = interfaceC0231a;
            this.f4717f = str;
            this.f4718g = i2;
            this.f4719h = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4716e.onFinish(this.f4717f);
                if (this.f4718g != 1 || this.f4719h == null) {
                    return;
                }
                for (int i2 = 0; i2 < this.f4719h.size(); i2++) {
                    a.InterfaceC0231a interfaceC0231a = (a.InterfaceC0231a) this.f4719h.get(i2);
                    if (interfaceC0231a != null) {
                        c.a.p0.k.e.c().b(new C0234a(this, interfaceC0231a));
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

    public static void b(a.InterfaceC0231a interfaceC0231a, h hVar, int i2, ArrayList<a.InterfaceC0231a> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{interfaceC0231a, hVar, Integer.valueOf(i2), arrayList, Boolean.valueOf(z)}) == null) || hVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", hVar.a);
            jSONObject.put("1", hVar.f4785b);
            jSONObject.put("2", String.valueOf(hVar.f4786c));
            jSONObject.put("3", hVar.f4787d);
            String jSONObject2 = jSONObject.toString();
            if (interfaceC0231a != null) {
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
                new Thread(new RunnableC0233a(interfaceC0231a, jSONObject2, i2, arrayList)).start();
            }
        } catch (Throwable th) {
            c.a.p0.l.c.d(th);
        }
    }
}
