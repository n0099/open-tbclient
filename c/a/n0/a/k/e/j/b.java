package c.a.n0.a.k.e.j;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.n0.a.k1.h;
import c.a.n0.a.k1.i;
import c.a.n0.a.p2.q0;
import c.a.n0.a.x.g.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends c.a.n0.a.k.e.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.x.g.d f5132b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f5133c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ g.b f5134d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f5135e;

        public a(b bVar, int i, c.a.n0.a.x.g.d dVar, g gVar, g.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i), dVar, gVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5135e = bVar;
            this.a = i;
            this.f5132b = dVar;
            this.f5133c = gVar;
            this.f5134d = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.f5132b.D0) {
                    c.a.n0.a.p2.g.b(this.f5133c, this.f5135e.getContext(), 1);
                }
                this.f5134d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull c.a.n0.a.k.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.n0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        c.a.n0.a.t1.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || (a0 = c.a.n0.a.t1.e.a0()) == null) {
            return;
        }
        a0.B().H(a0.getAppId());
    }

    public c.a.n0.a.k.h.b A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (c.a.n0.a.k.h.b) invokeV.objValue;
    }

    public c.a.n0.a.k.h.b B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
            c.a.n0.a.k.h.b bVar = (c.a.n0.a.k.h.b) s.first;
            return !bVar.isSuccess() ? bVar : z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    @Override // c.a.n0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigateBackApi" : (String) invokeV.objValue;
    }

    public final c.a.n0.a.k.h.b z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            g V = c.a.n0.a.w0.f.U().V();
            if (V == null) {
                c.a.n0.a.u.d.c("NavigateBackApi", "manager is null");
                return new c.a.n0.a.k.h.b(1001, "manager is null");
            }
            int k = V.k();
            if (k == 1) {
                c.a.n0.a.u.d.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new c.a.n0.a.k.h.b(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            c.a.n0.a.c1.b f2 = c.a.n0.a.d2.i.f(uuid, i);
            c.a.n0.a.x.g.d m = V.m();
            if (m == null) {
                c.a.n0.a.u.d.c("NavigateBackApi", "slave container is null");
                return new c.a.n0.a.k.h.b(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.D0) {
                c.a.n0.a.u.d.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new c.a.n0.a.k.h.b(1001, "hideModalPage api can only work after showModalPage");
            } else {
                i.c(i2, uuid);
                g.b i3 = V.i(str);
                i3.n(g.i, g.f7049h);
                i3.h(i);
                q0.a0(new a(this, k, m, V, i3));
                c.a.n0.a.x.g.f o = V.o();
                c.a.n0.a.c1.b k3 = o == null ? null : o.k3();
                h.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                i.a(uuid, k3);
                if (!(V.m() instanceof c.a.n0.a.x.g.f)) {
                    c.a.n0.a.u.d.c("NavigateBackApi", "top fragment error");
                    c.a.n0.a.d2.i.i(f2);
                    return new c.a.n0.a.k.h.b(1001, "top fragment error");
                }
                c.a.n0.a.x.g.f fVar = (c.a.n0.a.x.g.f) V.m();
                return new c.a.n0.a.k.h.b(0, c.a.n0.a.v1.f.o0.a.c(fVar != null ? fVar.r3() : ""));
            }
        }
        return (c.a.n0.a.k.h.b) invokeCommon.objValue;
    }
}
