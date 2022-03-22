package c.a.l0.d;

import c.a.l0.a;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.InterfaceC0197a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f3560b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3561c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ ArrayList f3562d;

        /* renamed from: c.a.l0.d.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0199a extends c.a.l0.l.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a.InterfaceC0197a f3563b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f3564c;

            public C0199a(a aVar, a.InterfaceC0197a interfaceC0197a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, interfaceC0197a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f3564c = aVar;
                this.f3563b = interfaceC0197a;
            }

            @Override // c.a.l0.l.c
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f3563b.onFinish(this.f3564c.f3560b);
                }
            }
        }

        public a(a.InterfaceC0197a interfaceC0197a, String str, int i, ArrayList arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC0197a, str, Integer.valueOf(i), arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = interfaceC0197a;
            this.f3560b = str;
            this.f3561c = i;
            this.f3562d = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.onFinish(this.f3560b);
                if (this.f3561c != 1 || this.f3562d == null) {
                    return;
                }
                for (int i = 0; i < this.f3562d.size(); i++) {
                    a.InterfaceC0197a interfaceC0197a = (a.InterfaceC0197a) this.f3562d.get(i);
                    if (interfaceC0197a != null) {
                        c.a.l0.l.e.c().b(new C0199a(this, interfaceC0197a));
                    }
                }
            }
        }
    }

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) {
            if (i == 1) {
                return 2010;
            }
            if (i == 2) {
                return 2011;
            }
            return i == 3 ? IMConstants.IM_MSG_TYPE_SHIELD_ME : i == 4 ? IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME : i == 5 ? IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME_SEND_FAIL : i == 6 ? 2015 : 2009;
        }
        return invokeI.intValue;
    }

    public static void b(a.InterfaceC0197a interfaceC0197a, c cVar, int i, ArrayList<a.InterfaceC0197a> arrayList, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{interfaceC0197a, cVar, Integer.valueOf(i), arrayList, Boolean.valueOf(z)}) == null) || cVar == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", cVar.a);
            jSONObject.put("1", cVar.f3546b);
            jSONObject.put("2", String.valueOf(cVar.f3547c));
            jSONObject.put("3", cVar.f3548d);
            String jSONObject2 = jSONObject.toString();
            if (interfaceC0197a != null) {
                if (i == 1) {
                    if (z) {
                        c.a.l0.c.a.c().f(false);
                    }
                } else if (i == 2) {
                    if (z) {
                        c.a.l0.c.a.c().d(false);
                    }
                } else if (i == 3) {
                    if (z) {
                        c.a.l0.c.a.c().j(false);
                    }
                } else if (z) {
                    c.a.l0.c.a.c().n(false);
                }
                new Thread(new a(interfaceC0197a, jSONObject2, i, arrayList)).start();
            }
        } catch (Throwable th) {
            c.a.l0.m.c.d(th);
        }
    }
}
