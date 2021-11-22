package b.a.p0.a.u.e.f;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends b.a.p0.a.u.e.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.d f8586e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8587f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8588g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f8589h;

        public a(d dVar, b.a.p0.a.h0.g.d dVar2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, dVar2, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8589h = dVar;
            this.f8586e = dVar2;
            this.f8587f = str;
            this.f8588g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.h0.g.d dVar = this.f8586e;
                boolean z = true;
                if (!((dVar == null || !dVar.t2(this.f8587f, true)) ? false : false)) {
                    b.a.p0.a.e0.d.c("NavigationBarApi", "set title fail");
                    this.f8589h.d(this.f8588g, new b.a.p0.a.u.h.b(1001));
                }
                this.f8589h.d(this.f8588g, new b.a.p0.a.u.h.b(0));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.d f8590e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8591f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8592g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8593h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8594i;
        public final /* synthetic */ d j;

        public b(d dVar, b.a.p0.a.h0.g.d dVar2, String str, String str2, String str3, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, dVar2, str, str2, str3, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = dVar;
            this.f8590e = dVar2;
            this.f8591f = str;
            this.f8592g = str2;
            this.f8593h = str3;
            this.f8594i = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.h0.g.d dVar = this.f8590e;
                if (dVar != null && dVar.B2(this.f8591f, true)) {
                    if (!this.f8590e.r2(SwanAppConfigData.t(this.f8593h), true)) {
                        b.a.p0.a.e0.d.c("NavigationBarApi", "set title background fail");
                        this.j.d(this.f8592g, new b.a.p0.a.u.h.b(1001));
                        return;
                    }
                    JSONObject jSONObject = this.f8594i;
                    if (jSONObject != null) {
                        this.f8590e.p2(jSONObject.optInt("duration"), this.f8594i.optString("timingFunc"));
                        b.a.p0.a.e0.d.i("NavigationBarApi", "set action bar animator");
                    }
                    this.j.d(this.f8592g, new b.a.p0.a.u.h.b(0));
                    return;
                }
                b.a.p0.a.e0.d.c("NavigationBarApi", "set title color fail");
                this.j.d(this.f8592g, new b.a.p0.a.u.h.b(1001));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.g.d f8595e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8596f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f8597g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f8598h;

        public c(d dVar, b.a.p0.a.h0.g.d dVar2, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, dVar2, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8598h = dVar;
            this.f8595e = dVar2;
            this.f8596f = str;
            this.f8597g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean P1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.h0.g.d dVar = this.f8595e;
                if (dVar == null) {
                    b.a.p0.a.e0.d.c("NavigationBarApi", "swanAppFragment is null");
                    this.f8598h.d(this.f8596f, new b.a.p0.a.u.h.b(1001));
                    return;
                }
                if (this.f8597g) {
                    P1 = dVar.K2();
                } else {
                    P1 = dVar.P1();
                }
                if (!P1) {
                    String str = this.f8597g ? "show" : "hide";
                    b.a.p0.a.e0.d.c("NavigationBarApi", str + " navigation loading progressbar fail");
                    this.f8598h.d(this.f8596f, new b.a.p0.a.u.h.b(1001));
                    return;
                }
                this.f8598h.d(this.f8596f, new b.a.p0.a.u.h.b(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull b.a.p0.a.u.c.b bVar) {
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

    public b.a.p0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#setNavigationBarTitle", false);
            Pair<b.a.p0.a.u.h.b, JSONObject> s = s(str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                if (jSONObject == null) {
                    return new b.a.p0.a.u.h.b(1001);
                }
                String optString = jSONObject.optString("title");
                b.a.p0.a.h0.g.g V = b.a.p0.a.g1.f.U().V();
                if (V == null) {
                    b.a.p0.a.e0.d.c("NavigationBarApi", "manager is null");
                    return new b.a.p0.a.u.h.b(1001);
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    p("cb is empty", null, true);
                    return new b.a.p0.a.u.h.b(1001, "cb is empty");
                }
                q0.e0(new a(this, V.m(), optString, optString2));
                return b.a.p0.a.u.h.b.f();
            }
            return bVar;
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#showNavigationBarLoading", false);
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
            if (a0 != null && a0.m0()) {
                return new b.a.p0.a.u.h.b(1001, "ui operation does not supported when app is invisible.");
            }
            return x(str, true);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    @Override // b.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigationBarApi" : (String) invokeV.objValue;
    }

    public final b.a.p0.a.u.h.b x(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            b.a.p0.a.h0.g.g V = b.a.p0.a.g1.f.U().V();
            if (V == null) {
                b.a.p0.a.e0.d.c("NavigationBarApi", "manager is null");
                return new b.a.p0.a.u.h.b(1001);
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> s = s(str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    p("cb is empty", null, true);
                    return new b.a.p0.a.u.h.b(1001, "cb is empty");
                }
                q0.e0(new c(this, V.m(), optString, z));
                return b.a.p0.a.u.h.b.f();
            }
            return bVar;
        }
        return (b.a.p0.a.u.h.b) invokeLZ.objValue;
    }

    public b.a.p0.a.u.h.b y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#hideNavigationBarLoading", false);
            return x(str, false);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#setNavigationBarColor", false);
            b.a.p0.a.h0.g.g V = b.a.p0.a.g1.f.U().V();
            if (V == null) {
                b.a.p0.a.e0.d.c("NavigationBarApi", "manager is null");
                return new b.a.p0.a.u.h.b(1001);
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> s = s(str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    p("cb is empty", null, true);
                    return new b.a.p0.a.u.h.b(1001, "cb is empty");
                }
                q0.e0(new b(this, V.m(), jSONObject.optString("frontColor"), optString, jSONObject.optString("backgroundColor"), jSONObject.optJSONObject("animation")));
                return b.a.p0.a.u.h.b.f();
            }
            return bVar;
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
