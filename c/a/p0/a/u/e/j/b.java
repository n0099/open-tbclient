package c.a.p0.a.u.e.j;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.p0.a.h0.g.g;
import c.a.p0.a.u1.h;
import c.a.p0.a.u1.i;
import c.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends c.a.p0.a.u.e.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f8292e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.g.d f8293f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f8294g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g.b f8295h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f8296i;

        public a(b bVar, int i2, c.a.p0.a.h0.g.d dVar, g gVar, g.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), dVar, gVar, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8296i = bVar;
            this.f8292e = i2;
            this.f8293f = dVar;
            this.f8294g = gVar;
            this.f8295h = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f8292e > 1 && !this.f8293f.H0) {
                    c.a.p0.a.z2.g.b(this.f8294g, this.f8296i.getContext(), 1);
                }
                this.f8295h.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull c.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        c.a.p0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || (a0 = c.a.p0.a.d2.e.a0()) == null) {
            return;
        }
        a0.B().H(a0.getAppId());
    }

    public c.a.p0.a.u.h.b A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (c.a.p0.a.u.h.b) invokeV.objValue;
    }

    public c.a.p0.a.u.h.b B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<c.a.p0.a.u.h.b, JSONObject> s = s(str);
            c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) s.first;
            return !bVar.isSuccess() ? bVar : z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigateBackApi" : (String) invokeV.objValue;
    }

    public final c.a.p0.a.u.h.b z(int i2, String str, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)})) == null) {
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            g V = c.a.p0.a.g1.f.U().V();
            if (V == null) {
                c.a.p0.a.e0.d.c("NavigateBackApi", "manager is null");
                return new c.a.p0.a.u.h.b(1001, "manager is null");
            }
            int k2 = V.k();
            if (k2 == 1) {
                c.a.p0.a.e0.d.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new c.a.p0.a.u.h.b(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i2 >= k2) {
                i2 = k2 - 1;
            }
            c.a.p0.a.m1.b f2 = c.a.p0.a.n2.i.f(uuid, i2);
            c.a.p0.a.h0.g.d m = V.m();
            if (m == null) {
                c.a.p0.a.e0.d.c("NavigateBackApi", "slave container is null");
                return new c.a.p0.a.u.h.b(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.H0) {
                c.a.p0.a.e0.d.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new c.a.p0.a.u.h.b(1001, "hideModalPage api can only work after showModalPage");
            } else {
                i.c(i3, uuid);
                g.b i4 = V.i(str);
                i4.n(g.f5498i, g.f5497h);
                i4.h(i2);
                q0.a0(new a(this, k2, m, V, i4));
                c.a.p0.a.h0.g.f o = V.o();
                c.a.p0.a.m1.b n3 = o == null ? null : o.n3();
                h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid).F(new UbcFlowEvent("na_push_page_end"));
                i.a(uuid, n3);
                if (!(V.m() instanceof c.a.p0.a.h0.g.f)) {
                    c.a.p0.a.e0.d.c("NavigateBackApi", "top fragment error");
                    c.a.p0.a.n2.i.i(f2);
                    return new c.a.p0.a.u.h.b(1001, "top fragment error");
                }
                c.a.p0.a.h0.g.f fVar = (c.a.p0.a.h0.g.f) V.m();
                return new c.a.p0.a.u.h.b(0, c.a.p0.a.f2.f.o0.a.c(fVar != null ? fVar.u3() : ""));
            }
        }
        return (c.a.p0.a.u.h.b) invokeCommon.objValue;
    }
}
