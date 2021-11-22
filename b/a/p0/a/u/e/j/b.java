package b.a.p0.a.u.e.j;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.u1.h;
import b.a.p0.a.u1.i;
import b.a.p0.a.z2.q0;
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
public class b extends b.a.p0.a.u.e.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f8740e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.d f8741f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g f8742g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g.b f8743h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f8744i;

        public a(b bVar, int i2, b.a.p0.a.h0.g.d dVar, g gVar, g.b bVar2) {
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
            this.f8744i = bVar;
            this.f8740e = i2;
            this.f8741f = dVar;
            this.f8742g = gVar;
            this.f8743h = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f8740e > 1 && !this.f8741f.G0) {
                    b.a.p0.a.z2.g.b(this.f8742g, this.f8744i.getContext(), 1);
                }
                this.f8743h.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull b.a.p0.a.u.c.b bVar) {
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
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        b.a.p0.a.d2.e a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || (a0 = b.a.p0.a.d2.e.a0()) == null) {
            return;
        }
        a0.B().H(a0.getAppId());
    }

    public b.a.p0.a.u.h.b A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (b.a.p0.a.u.h.b) invokeV.objValue;
    }

    public b.a.p0.a.u.h.b B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<b.a.p0.a.u.h.b, JSONObject> s = s(str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) s.first;
            return !bVar.isSuccess() ? bVar : z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    @Override // b.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigateBackApi" : (String) invokeV.objValue;
    }

    public final b.a.p0.a.u.h.b z(int i2, String str, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)})) == null) {
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            g V = b.a.p0.a.g1.f.U().V();
            if (V == null) {
                b.a.p0.a.e0.d.c("NavigateBackApi", "manager is null");
                return new b.a.p0.a.u.h.b(1001, "manager is null");
            }
            int k = V.k();
            if (k == 1) {
                b.a.p0.a.e0.d.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new b.a.p0.a.u.h.b(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i2 >= k) {
                i2 = k - 1;
            }
            b.a.p0.a.m1.b f2 = b.a.p0.a.n2.i.f(uuid, i2);
            b.a.p0.a.h0.g.d m = V.m();
            if (m == null) {
                b.a.p0.a.e0.d.c("NavigateBackApi", "slave container is null");
                return new b.a.p0.a.u.h.b(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.G0) {
                b.a.p0.a.e0.d.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new b.a.p0.a.u.h.b(1001, "hideModalPage api can only work after showModalPage");
            } else {
                i.c(i3, uuid);
                g.b i4 = V.i(str);
                i4.n(g.f5480i, g.f5479h);
                i4.h(i2);
                q0.a0(new a(this, k, m, V, i4));
                b.a.p0.a.h0.g.f o = V.o();
                b.a.p0.a.m1.b j3 = o == null ? null : o.j3();
                h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid).F(new UbcFlowEvent("na_push_page_end"));
                i.a(uuid, j3);
                if (!(V.m() instanceof b.a.p0.a.h0.g.f)) {
                    b.a.p0.a.e0.d.c("NavigateBackApi", "top fragment error");
                    b.a.p0.a.n2.i.i(f2);
                    return new b.a.p0.a.u.h.b(1001, "top fragment error");
                }
                b.a.p0.a.h0.g.f fVar = (b.a.p0.a.h0.g.f) V.m();
                return new b.a.p0.a.u.h.b(0, b.a.p0.a.f2.f.o0.a.c(fVar != null ? fVar.q3() : ""));
            }
        }
        return (b.a.p0.a.u.h.b) invokeCommon.objValue;
    }
}
