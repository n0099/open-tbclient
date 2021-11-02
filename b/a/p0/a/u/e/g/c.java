package b.a.p0.a.u.e.g;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.d f8114e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8115f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8116g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f8117h;

        public a(c cVar, b.a.p0.a.h0.g.d dVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, dVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8117h = cVar;
            this.f8114e = dVar;
            this.f8115f = str;
            this.f8116g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.h0.g.d dVar = this.f8114e;
                boolean z = true;
                if (!((dVar == null || !dVar.i2(this.f8115f, true)) ? false : false)) {
                    b.a.p0.a.e0.d.b("Api-NavigationBar", "set title fail");
                    this.f8117h.d(this.f8116g, new b.a.p0.a.u.h.b(1001));
                }
                this.f8117h.d(this.f8116g, new b.a.p0.a.u.h.b(0));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.d f8118e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8119f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8120g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8121h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8122i;
        public final /* synthetic */ c j;

        public b(c cVar, b.a.p0.a.h0.g.d dVar, String str, String str2, String str3, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, dVar, str, str2, str3, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = cVar;
            this.f8118e = dVar;
            this.f8119f = str;
            this.f8120g = str2;
            this.f8121h = str3;
            this.f8122i = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.h0.g.d dVar = this.f8118e;
                if (dVar != null && dVar.p2(this.f8119f, true)) {
                    if (!this.f8118e.g2(SwanAppConfigData.s(this.f8121h), true)) {
                        b.a.p0.a.e0.d.b("Api-NavigationBar", "set title background fail");
                        this.j.d(this.f8120g, new b.a.p0.a.u.h.b(1001));
                        return;
                    }
                    JSONObject jSONObject = this.f8122i;
                    if (jSONObject != null) {
                        this.f8118e.e2(jSONObject.optInt("duration"), this.f8122i.optString("timingFunc"));
                        b.a.p0.a.e0.d.g("Api-NavigationBar", "set action bar animator");
                    }
                    this.j.d(this.f8120g, new b.a.p0.a.u.h.b(0));
                    return;
                }
                b.a.p0.a.e0.d.b("Api-NavigationBar", "set title color fail");
                this.j.d(this.f8120g, new b.a.p0.a.u.h.b(1001));
            }
        }
    }

    /* renamed from: b.a.p0.a.u.e.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0391c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.d f8123e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8124f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f8125g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f8126h;

        public RunnableC0391c(c cVar, b.a.p0.a.h0.g.d dVar, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, dVar, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8126h = cVar;
            this.f8123e = dVar;
            this.f8124f = str;
            this.f8125g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean I1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.h0.g.d dVar = this.f8123e;
                if (dVar == null) {
                    b.a.p0.a.e0.d.b("Api-NavigationBar", "swanAppFragment is null");
                    this.f8126h.d(this.f8124f, new b.a.p0.a.u.h.b(1001));
                    return;
                }
                if (this.f8125g) {
                    I1 = dVar.x2();
                } else {
                    I1 = dVar.I1();
                }
                if (!I1) {
                    String str = this.f8125g ? "show" : "hide";
                    b.a.p0.a.e0.d.b("Api-NavigationBar", str + " navigation loading progressbar fail");
                    this.f8126h.d(this.f8124f, new b.a.p0.a.u.h.b(1001));
                    return;
                }
                this.f8126h.d(this.f8124f, new b.a.p0.a.u.h.b(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull b.a.p0.a.u.c.b bVar) {
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

    public final b.a.p0.a.u.h.b q(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            b.a.p0.a.h0.g.g U = b.a.p0.a.g1.f.T().U();
            if (U == null) {
                b.a.p0.a.e0.d.b("Api-NavigationBar", "manager is null");
                return new b.a.p0.a.u.h.b(1001);
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-NavigationBar", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-NavigationBar", "parse fail");
                }
                return bVar;
            }
            String optString = ((JSONObject) b2.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                b.a.p0.a.e0.d.b("Api-NavigationBar", "callback is null");
                return new b.a.p0.a.u.h.b(1001, "callback is null");
            }
            q0.b0(new RunnableC0391c(this, U.m(), optString, z));
            return new b.a.p0.a.u.h.b(0);
        }
        return (b.a.p0.a.u.h.b) invokeLZ.objValue;
    }

    public b.a.p0.a.u.h.b r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            boolean z = b.a.p0.a.u.c.d.f8000c;
            return q(str, false);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            boolean z = b.a.p0.a.u.c.d.f8000c;
            b.a.p0.a.h0.g.g U = b.a.p0.a.g1.f.T().U();
            if (U == null) {
                b.a.p0.a.e0.d.b("Api-NavigationBar", "manager is null");
                return new b.a.p0.a.u.h.b(1001);
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-NavigationBar", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-NavigationBar", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                b.a.p0.a.e0.d.b("Api-NavigationBar", "callback is null");
                return new b.a.p0.a.u.h.b(1001, "callback is null");
            }
            q0.b0(new b(this, U.m(), jSONObject.optString("frontColor"), optString, jSONObject.optString("backgroundColor"), jSONObject.optJSONObject("animation")));
            return new b.a.p0.a.u.h.b(0);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            boolean z = b.a.p0.a.u.c.d.f8000c;
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-NavigationBar", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                b.a.p0.a.e0.d.b("Api-NavigationBar", "parse fail");
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            if (jSONObject == null) {
                b.a.p0.a.e0.d.b("Api-NavigationBar", "paramsJson is null");
                return new b.a.p0.a.u.h.b(1001);
            }
            String optString = jSONObject.optString("title");
            b.a.p0.a.h0.g.g U = b.a.p0.a.g1.f.T().U();
            if (U == null) {
                b.a.p0.a.e0.d.b("Api-NavigationBar", "manager is null");
                return new b.a.p0.a.u.h.b(1001);
            }
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                b.a.p0.a.e0.d.b("Api-NavigationBar", "callback is null");
                return new b.a.p0.a.u.h.b(1001, "callback is null");
            }
            q0.b0(new a(this, U.m(), optString, optString2));
            return new b.a.p0.a.u.h.b(0);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            boolean z = b.a.p0.a.u.c.d.f8000c;
            b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
            if (P != null && P.c0()) {
                boolean z2 = b.a.p0.a.u.c.d.f8000c;
                return new b.a.p0.a.u.h.b(1001, "ui operation does not supported when app is invisible.");
            }
            return q(str, true);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
