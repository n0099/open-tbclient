package c.a.s0.a.u.e.f;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.s0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends c.a.s0.a.u.e.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.h0.g.d f9230e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9231f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f9232g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f9233h;

        public a(d dVar, c.a.s0.a.h0.g.d dVar2, String str, String str2) {
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
            this.f9233h = dVar;
            this.f9230e = dVar2;
            this.f9231f = str;
            this.f9232g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.a.h0.g.d dVar = this.f9230e;
                boolean z = true;
                if (!((dVar == null || !dVar.q2(this.f9231f, true)) ? false : false)) {
                    c.a.s0.a.e0.d.c("NavigationBarApi", "set title fail");
                    this.f9233h.d(this.f9232g, new c.a.s0.a.u.h.b(1001));
                }
                this.f9233h.d(this.f9232g, new c.a.s0.a.u.h.b(0));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.h0.g.d f9234e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9235f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f9236g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f9237h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONObject f9238i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ d f9239j;

        public b(d dVar, c.a.s0.a.h0.g.d dVar2, String str, String str2, String str3, JSONObject jSONObject) {
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
            this.f9239j = dVar;
            this.f9234e = dVar2;
            this.f9235f = str;
            this.f9236g = str2;
            this.f9237h = str3;
            this.f9238i = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.a.h0.g.d dVar = this.f9234e;
                if (dVar != null && dVar.y2(this.f9235f, true)) {
                    if (!this.f9234e.o2(SwanAppConfigData.t(this.f9237h), true)) {
                        c.a.s0.a.e0.d.c("NavigationBarApi", "set title background fail");
                        this.f9239j.d(this.f9236g, new c.a.s0.a.u.h.b(1001));
                        return;
                    }
                    JSONObject jSONObject = this.f9238i;
                    if (jSONObject != null) {
                        this.f9234e.m2(jSONObject.optInt("duration"), this.f9238i.optString("timingFunc"));
                        c.a.s0.a.e0.d.i("NavigationBarApi", "set action bar animator");
                    }
                    this.f9239j.d(this.f9236g, new c.a.s0.a.u.h.b(0));
                    return;
                }
                c.a.s0.a.e0.d.c("NavigationBarApi", "set title color fail");
                this.f9239j.d(this.f9236g, new c.a.s0.a.u.h.b(1001));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.a.h0.g.d f9240e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9241f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f9242g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f9243h;

        public c(d dVar, c.a.s0.a.h0.g.d dVar2, String str, boolean z) {
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
            this.f9243h = dVar;
            this.f9240e = dVar2;
            this.f9241f = str;
            this.f9242g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean M1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.a.h0.g.d dVar = this.f9240e;
                if (dVar == null) {
                    c.a.s0.a.e0.d.c("NavigationBarApi", "swanAppFragment is null");
                    this.f9243h.d(this.f9241f, new c.a.s0.a.u.h.b(1001));
                    return;
                }
                if (this.f9242g) {
                    M1 = dVar.H2();
                } else {
                    M1 = dVar.M1();
                }
                if (!M1) {
                    String str = this.f9242g ? "show" : "hide";
                    c.a.s0.a.e0.d.c("NavigationBarApi", str + " navigation loading progressbar fail");
                    this.f9243h.d(this.f9241f, new c.a.s0.a.u.h.b(1001));
                    return;
                }
                this.f9243h.d(this.f9241f, new c.a.s0.a.u.h.b(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull c.a.s0.a.u.c.b bVar) {
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
                super((c.a.s0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c.a.s0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#setNavigationBarTitle", false);
            Pair<c.a.s0.a.u.h.b, JSONObject> s = s(str);
            c.a.s0.a.u.h.b bVar = (c.a.s0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                if (jSONObject == null) {
                    return new c.a.s0.a.u.h.b(1001);
                }
                String optString = jSONObject.optString("title");
                c.a.s0.a.h0.g.g V = c.a.s0.a.g1.f.U().V();
                if (V == null) {
                    c.a.s0.a.e0.d.c("NavigationBarApi", "manager is null");
                    return new c.a.s0.a.u.h.b(1001);
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    p("cb is empty", null, true);
                    return new c.a.s0.a.u.h.b(1001, "cb is empty");
                }
                q0.e0(new a(this, V.m(), optString, optString2));
                return c.a.s0.a.u.h.b.f();
            }
            return bVar;
        }
        return (c.a.s0.a.u.h.b) invokeL.objValue;
    }

    public c.a.s0.a.u.h.b B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#showNavigationBarLoading", false);
            c.a.s0.a.d2.e a0 = c.a.s0.a.d2.e.a0();
            if (a0 != null && a0.m0()) {
                return new c.a.s0.a.u.h.b(1001, "ui operation does not supported when app is invisible.");
            }
            return x(str, true);
        }
        return (c.a.s0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.s0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigationBarApi" : (String) invokeV.objValue;
    }

    public final c.a.s0.a.u.h.b x(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            c.a.s0.a.h0.g.g V = c.a.s0.a.g1.f.U().V();
            if (V == null) {
                c.a.s0.a.e0.d.c("NavigationBarApi", "manager is null");
                return new c.a.s0.a.u.h.b(1001);
            }
            Pair<c.a.s0.a.u.h.b, JSONObject> s = s(str);
            c.a.s0.a.u.h.b bVar = (c.a.s0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    p("cb is empty", null, true);
                    return new c.a.s0.a.u.h.b(1001, "cb is empty");
                }
                q0.e0(new c(this, V.m(), optString, z));
                return c.a.s0.a.u.h.b.f();
            }
            return bVar;
        }
        return (c.a.s0.a.u.h.b) invokeLZ.objValue;
    }

    public c.a.s0.a.u.h.b y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#hideNavigationBarLoading", false);
            return x(str, false);
        }
        return (c.a.s0.a.u.h.b) invokeL.objValue;
    }

    public c.a.s0.a.u.h.b z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#setNavigationBarColor", false);
            c.a.s0.a.h0.g.g V = c.a.s0.a.g1.f.U().V();
            if (V == null) {
                c.a.s0.a.e0.d.c("NavigationBarApi", "manager is null");
                return new c.a.s0.a.u.h.b(1001);
            }
            Pair<c.a.s0.a.u.h.b, JSONObject> s = s(str);
            c.a.s0.a.u.h.b bVar = (c.a.s0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    p("cb is empty", null, true);
                    return new c.a.s0.a.u.h.b(1001, "cb is empty");
                }
                q0.e0(new b(this, V.m(), jSONObject.optString("frontColor"), optString, jSONObject.optString("backgroundColor"), jSONObject.optJSONObject("animation")));
                return c.a.s0.a.u.h.b.f();
            }
            return bVar;
        }
        return (c.a.s0.a.u.h.b) invokeL.objValue;
    }
}
