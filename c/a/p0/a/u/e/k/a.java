package c.a.p0.a.u.e.k;

import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.p0.a.a2.e;
import c.a.p0.a.g1.f;
import c.a.p0.a.h0.g.g;
import c.a.p0.a.j2.h;
import c.a.p0.a.r1.i;
import c.a.p0.a.v2.q0;
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
public class a extends c.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.u.e.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0407a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f9006e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f9007f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g.b f9008g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f9009h;

        public RunnableC0407a(a aVar, int i2, g gVar, g.b bVar) {
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
            this.f9009h = aVar;
            this.f9006e = i2;
            this.f9007f = gVar;
            this.f9008g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f9006e > 1) {
                    c.a.p0.a.v2.g.b(this.f9007f, this.f9009h.i(), 1);
                }
                this.f9008g.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.p0.a.u.c.b bVar) {
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

    public c.a.p0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (c.a.p0.a.u.c.d.f8735c) {
                String str2 = "handle: " + str;
            }
            e Q = e.Q();
            if (Q != null) {
                Q.B().e(Q.getAppId());
            }
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            Pair<c.a.p0.a.u.h.b, JSONObject> b2 = c.a.p0.a.u.i.b.b("Api-NavigateBack", str);
            c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (c.a.p0.a.u.c.d.f8735c) {
                    c.a.p0.a.e0.d.b("Api-NavigateBack", "parse fail");
                }
                return bVar;
            }
            int optInt = ((JSONObject) b2.second).optInt("delta", 1);
            g W = f.V().W();
            if (W == null) {
                c.a.p0.a.e0.d.b("Api-NavigateBack", "manager is null");
                return new c.a.p0.a.u.h.b(1001, "manager is null");
            }
            if (c.a.p0.a.u.c.d.f8735c) {
                String str3 = "back delta: " + optInt;
            }
            int k = W.k();
            if (c.a.p0.a.u.c.d.f8735c) {
                String str4 = "fragment count " + k;
            }
            if (k == 1) {
                c.a.p0.a.e0.d.b("Api-NavigateBack", "navigateBack api can only work when slave's count greater than 1");
                return new c.a.p0.a.u.h.b(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (optInt >= k) {
                optInt = k - 1;
            }
            if (c.a.p0.a.u.c.d.f8735c) {
                String str5 = "real back delta: " + optInt;
            }
            c.a.p0.a.h0.g.d j2 = W.j((k - optInt) - 1);
            h.f((j2 == null || j2.I1() == null) ? "" : j2.I1().g(), "1");
            i.c(1, uuid);
            g.b i2 = W.i("navigateBack");
            i2.n(g.f5938i, g.f5937h);
            i2.h(optInt);
            q0.X(new RunnableC0407a(this, k, W, i2));
            c.a.p0.a.h0.g.f o = W.o();
            c.a.p0.a.l1.b X2 = o == null ? null : o.X2();
            c.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid).C(new UbcFlowEvent("na_push_page_end"));
            i.a(uuid, X2);
            if (!(W.m() instanceof c.a.p0.a.h0.g.f)) {
                c.a.p0.a.e0.d.b("Api-NavigateBack", "top fragment error");
                return new c.a.p0.a.u.h.b(1001, "top fragment error");
            }
            c.a.p0.a.h0.g.f fVar = (c.a.p0.a.h0.g.f) W.m();
            return new c.a.p0.a.u.h.b(0, c.a.p0.a.c2.f.p0.a.c(fVar != null ? fVar.e3() : ""));
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }
}
