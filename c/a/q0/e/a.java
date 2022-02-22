package c.a.q0.e;

import c.a.q0.a;
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

    /* renamed from: c.a.q0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class RunnableC0239a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.InterfaceC0237a f4791e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4792f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4793g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ ArrayList f4794h;

        /* renamed from: c.a.q0.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0240a extends c.a.q0.k.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a.InterfaceC0237a f4795f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ RunnableC0239a f4796g;

            public C0240a(RunnableC0239a runnableC0239a, a.InterfaceC0237a interfaceC0237a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {runnableC0239a, interfaceC0237a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4796g = runnableC0239a;
                this.f4795f = interfaceC0237a;
            }

            @Override // c.a.q0.k.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f4795f.onFinish(this.f4796g.f4792f);
                }
            }
        }

        public RunnableC0239a(a.InterfaceC0237a interfaceC0237a, String str, int i2, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC0237a, str, Integer.valueOf(i2), arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4791e = interfaceC0237a;
            this.f4792f = str;
            this.f4793g = i2;
            this.f4794h = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f4791e.onFinish(this.f4792f);
                if (this.f4793g != 1 || this.f4794h == null) {
                    return;
                }
                for (int i2 = 0; i2 < this.f4794h.size(); i2++) {
                    a.InterfaceC0237a interfaceC0237a = (a.InterfaceC0237a) this.f4794h.get(i2);
                    if (interfaceC0237a != null) {
                        c.a.q0.k.e.c().b(new C0240a(this, interfaceC0237a));
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

    public static void b(a.InterfaceC0237a interfaceC0237a, h hVar, int i2, ArrayList<a.InterfaceC0237a> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{interfaceC0237a, hVar, Integer.valueOf(i2), arrayList, Boolean.valueOf(z)}) == null) || hVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", hVar.a);
            jSONObject.put("1", hVar.f4860b);
            jSONObject.put("2", String.valueOf(hVar.f4861c));
            jSONObject.put("3", hVar.f4862d);
            String jSONObject2 = jSONObject.toString();
            if (interfaceC0237a != null) {
                if (i2 == 1) {
                    if (z) {
                        c.a.q0.c.a.c().f(false);
                    }
                } else if (i2 == 2) {
                    if (z) {
                        c.a.q0.c.a.c().d(false);
                    }
                } else if (i2 == 3) {
                    if (z) {
                        c.a.q0.c.a.c().j(false);
                    }
                } else if (z) {
                    c.a.q0.c.a.c().m(false);
                }
                new Thread(new RunnableC0239a(interfaceC0237a, jSONObject2, i2, arrayList)).start();
            }
        } catch (Throwable th) {
            c.a.q0.l.c.d(th);
        }
    }
}
