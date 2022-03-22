package c.a.n0.a.k.e.f;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.n0.a.p2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends c.a.n0.a.k.e.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.x.g.d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5022b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f5023c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f5024d;

        public a(d dVar, c.a.n0.a.x.g.d dVar2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, dVar2, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5024d = dVar;
            this.a = dVar2;
            this.f5022b = str;
            this.f5023c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.x.g.d dVar = this.a;
                boolean z = true;
                if (!((dVar == null || !dVar.u2(this.f5022b, true)) ? false : false)) {
                    c.a.n0.a.u.d.c("NavigationBarApi", "set title fail");
                    this.f5024d.d(this.f5023c, new c.a.n0.a.k.h.b(1001));
                }
                this.f5024d.d(this.f5023c, new c.a.n0.a.k.h.b(0));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.x.g.d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5025b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f5026c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f5027d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f5028e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f5029f;

        public b(d dVar, c.a.n0.a.x.g.d dVar2, String str, String str2, String str3, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, dVar2, str, str2, str3, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5029f = dVar;
            this.a = dVar2;
            this.f5025b = str;
            this.f5026c = str2;
            this.f5027d = str3;
            this.f5028e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.x.g.d dVar = this.a;
                if (dVar != null && dVar.C2(this.f5025b, true)) {
                    if (!this.a.s2(SwanAppConfigData.t(this.f5027d), true)) {
                        c.a.n0.a.u.d.c("NavigationBarApi", "set title background fail");
                        this.f5029f.d(this.f5026c, new c.a.n0.a.k.h.b(1001));
                        return;
                    }
                    JSONObject jSONObject = this.f5028e;
                    if (jSONObject != null) {
                        this.a.q2(jSONObject.optInt("duration"), this.f5028e.optString("timingFunc"));
                        c.a.n0.a.u.d.i("NavigationBarApi", "set action bar animator");
                    }
                    this.f5029f.d(this.f5026c, new c.a.n0.a.k.h.b(0));
                    return;
                }
                c.a.n0.a.u.d.c("NavigationBarApi", "set title color fail");
                this.f5029f.d(this.f5026c, new c.a.n0.a.k.h.b(1001));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.x.g.d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f5030b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f5031c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f5032d;

        public c(d dVar, c.a.n0.a.x.g.d dVar2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, dVar2, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5032d = dVar;
            this.a = dVar2;
            this.f5030b = str;
            this.f5031c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean Q1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.x.g.d dVar = this.a;
                if (dVar == null) {
                    c.a.n0.a.u.d.c("NavigationBarApi", "swanAppFragment is null");
                    this.f5032d.d(this.f5030b, new c.a.n0.a.k.h.b(1001));
                    return;
                }
                if (this.f5031c) {
                    Q1 = dVar.L2();
                } else {
                    Q1 = dVar.Q1();
                }
                if (!Q1) {
                    String str = this.f5031c ? "show" : "hide";
                    c.a.n0.a.u.d.c("NavigationBarApi", str + " navigation loading progressbar fail");
                    this.f5032d.d(this.f5030b, new c.a.n0.a.k.h.b(1001));
                    return;
                }
                this.f5032d.d(this.f5030b, new c.a.n0.a.k.h.b(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull c.a.n0.a.k.c.b bVar) {
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

    public c.a.n0.a.k.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#setNavigationBarTitle", false);
            Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
            c.a.n0.a.k.h.b bVar = (c.a.n0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                if (jSONObject == null) {
                    return new c.a.n0.a.k.h.b(1001);
                }
                String optString = jSONObject.optString("title");
                c.a.n0.a.x.g.g V = c.a.n0.a.w0.f.U().V();
                if (V == null) {
                    c.a.n0.a.u.d.c("NavigationBarApi", "manager is null");
                    return new c.a.n0.a.k.h.b(1001);
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    p("cb is empty", null, true);
                    return new c.a.n0.a.k.h.b(1001, "cb is empty");
                }
                q0.e0(new a(this, V.m(), optString, optString2));
                return c.a.n0.a.k.h.b.f();
            }
            return bVar;
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    public c.a.n0.a.k.h.b B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#showNavigationBarLoading", false);
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            if (a0 != null && a0.m0()) {
                return new c.a.n0.a.k.h.b(1001, "ui operation does not supported when app is invisible.");
            }
            return x(str, true);
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    @Override // c.a.n0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigationBarApi" : (String) invokeV.objValue;
    }

    public final c.a.n0.a.k.h.b x(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            c.a.n0.a.x.g.g V = c.a.n0.a.w0.f.U().V();
            if (V == null) {
                c.a.n0.a.u.d.c("NavigationBarApi", "manager is null");
                return new c.a.n0.a.k.h.b(1001);
            }
            Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
            c.a.n0.a.k.h.b bVar = (c.a.n0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    p("cb is empty", null, true);
                    return new c.a.n0.a.k.h.b(1001, "cb is empty");
                }
                q0.e0(new c(this, V.m(), optString, z));
                return c.a.n0.a.k.h.b.f();
            }
            return bVar;
        }
        return (c.a.n0.a.k.h.b) invokeLZ.objValue;
    }

    public c.a.n0.a.k.h.b y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#hideNavigationBarLoading", false);
            return x(str, false);
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    public c.a.n0.a.k.h.b z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#setNavigationBarColor", false);
            c.a.n0.a.x.g.g V = c.a.n0.a.w0.f.U().V();
            if (V == null) {
                c.a.n0.a.u.d.c("NavigationBarApi", "manager is null");
                return new c.a.n0.a.k.h.b(1001);
            }
            Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
            c.a.n0.a.k.h.b bVar = (c.a.n0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    p("cb is empty", null, true);
                    return new c.a.n0.a.k.h.b(1001, "cb is empty");
                }
                q0.e0(new b(this, V.m(), jSONObject.optString("frontColor"), optString, jSONObject.optString("backgroundColor"), jSONObject.optJSONObject("animation")));
                return c.a.n0.a.k.h.b.f();
            }
            return bVar;
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }
}
