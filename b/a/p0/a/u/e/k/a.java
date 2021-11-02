package b.a.p0.a.u.e.k;

import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.a2.e;
import b.a.p0.a.g1.f;
import b.a.p0.a.h0.g.g;
import b.a.p0.a.j2.h;
import b.a.p0.a.r1.i;
import b.a.p0.a.v2.q0;
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
public class a extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.u.e.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0402a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f8263e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f8264f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g.b f8265g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f8266h;

        public RunnableC0402a(a aVar, int i2, g gVar, g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), gVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8266h = aVar;
            this.f8263e = i2;
            this.f8264f = gVar;
            this.f8265g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f8263e > 1) {
                    b.a.p0.a.v2.g.b(this.f8264f, this.f8266h.getContext(), 1);
                }
                this.f8265g.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull b.a.p0.a.u.c.b bVar) {
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

    public b.a.p0.a.u.h.b r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (b.a.p0.a.u.c.d.f8000c) {
                String str2 = "handle: " + str;
            }
            e P = e.P();
            if (P != null) {
                P.B().e(P.getAppId());
            }
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-NavigateBack", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-NavigateBack", "parse fail");
                }
                return bVar;
            }
            int optInt = ((JSONObject) b2.second).optInt("delta", 1);
            g U = f.T().U();
            if (U == null) {
                b.a.p0.a.e0.d.b("Api-NavigateBack", "manager is null");
                return new b.a.p0.a.u.h.b(1001, "manager is null");
            }
            if (b.a.p0.a.u.c.d.f8000c) {
                String str3 = "back delta: " + optInt;
            }
            int k = U.k();
            if (b.a.p0.a.u.c.d.f8000c) {
                String str4 = "fragment count " + k;
            }
            if (k == 1) {
                b.a.p0.a.e0.d.b("Api-NavigateBack", "navigateBack api can only work when slave's count greater than 1");
                return new b.a.p0.a.u.h.b(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (optInt >= k) {
                optInt = k - 1;
            }
            if (b.a.p0.a.u.c.d.f8000c) {
                String str5 = "real back delta: " + optInt;
            }
            b.a.p0.a.h0.g.d j = U.j((k - optInt) - 1);
            h.f((j == null || j.E1() == null) ? "" : j.E1().g(), "1");
            i.c(1, uuid);
            g.b i2 = U.i("navigateBack");
            i2.n(g.f5282i, g.f5281h);
            i2.h(optInt);
            q0.X(new RunnableC0402a(this, k, U, i2));
            b.a.p0.a.h0.g.f o = U.o();
            b.a.p0.a.l1.b T2 = o == null ? null : o.T2();
            b.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid).C(new UbcFlowEvent("na_push_page_end"));
            i.a(uuid, T2);
            if (!(U.m() instanceof b.a.p0.a.h0.g.f)) {
                b.a.p0.a.e0.d.b("Api-NavigateBack", "top fragment error");
                return new b.a.p0.a.u.h.b(1001, "top fragment error");
            }
            b.a.p0.a.h0.g.f fVar = (b.a.p0.a.h0.g.f) U.m();
            return new b.a.p0.a.u.h.b(0, b.a.p0.a.c2.f.p0.a.c(fVar != null ? fVar.a3() : ""));
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
