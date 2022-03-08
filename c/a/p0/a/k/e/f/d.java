package c.a.p0.a.k.e.f;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.p0.a.p2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends c.a.p0.a.k.e.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x.g.d f5958e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5959f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f5960g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f5961h;

        public a(d dVar, c.a.p0.a.x.g.d dVar2, String str, String str2) {
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
            this.f5961h = dVar;
            this.f5958e = dVar2;
            this.f5959f = str;
            this.f5960g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.x.g.d dVar = this.f5958e;
                boolean z = true;
                if (!((dVar == null || !dVar.q2(this.f5959f, true)) ? false : false)) {
                    c.a.p0.a.u.d.c("NavigationBarApi", "set title fail");
                    this.f5961h.d(this.f5960g, new c.a.p0.a.k.h.b(1001));
                }
                this.f5961h.d(this.f5960g, new c.a.p0.a.k.h.b(0));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x.g.d f5962e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5963f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f5964g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f5965h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONObject f5966i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ d f5967j;

        public b(d dVar, c.a.p0.a.x.g.d dVar2, String str, String str2, String str3, JSONObject jSONObject) {
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
            this.f5967j = dVar;
            this.f5962e = dVar2;
            this.f5963f = str;
            this.f5964g = str2;
            this.f5965h = str3;
            this.f5966i = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.x.g.d dVar = this.f5962e;
                if (dVar != null && dVar.y2(this.f5963f, true)) {
                    if (!this.f5962e.o2(SwanAppConfigData.t(this.f5965h), true)) {
                        c.a.p0.a.u.d.c("NavigationBarApi", "set title background fail");
                        this.f5967j.d(this.f5964g, new c.a.p0.a.k.h.b(1001));
                        return;
                    }
                    JSONObject jSONObject = this.f5966i;
                    if (jSONObject != null) {
                        this.f5962e.m2(jSONObject.optInt("duration"), this.f5966i.optString("timingFunc"));
                        c.a.p0.a.u.d.i("NavigationBarApi", "set action bar animator");
                    }
                    this.f5967j.d(this.f5964g, new c.a.p0.a.k.h.b(0));
                    return;
                }
                c.a.p0.a.u.d.c("NavigationBarApi", "set title color fail");
                this.f5967j.d(this.f5964g, new c.a.p0.a.k.h.b(1001));
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x.g.d f5968e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5969f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f5970g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f5971h;

        public c(d dVar, c.a.p0.a.x.g.d dVar2, String str, boolean z) {
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
            this.f5971h = dVar;
            this.f5968e = dVar2;
            this.f5969f = str;
            this.f5970g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean M1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.x.g.d dVar = this.f5968e;
                if (dVar == null) {
                    c.a.p0.a.u.d.c("NavigationBarApi", "swanAppFragment is null");
                    this.f5971h.d(this.f5969f, new c.a.p0.a.k.h.b(1001));
                    return;
                }
                if (this.f5970g) {
                    M1 = dVar.H2();
                } else {
                    M1 = dVar.M1();
                }
                if (!M1) {
                    String str = this.f5970g ? "show" : "hide";
                    c.a.p0.a.u.d.c("NavigationBarApi", str + " navigation loading progressbar fail");
                    this.f5971h.d(this.f5969f, new c.a.p0.a.k.h.b(1001));
                    return;
                }
                this.f5971h.d(this.f5969f, new c.a.p0.a.k.h.b(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull c.a.p0.a.k.c.b bVar) {
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
                super((c.a.p0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c.a.p0.a.k.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#setNavigationBarTitle", false);
            Pair<c.a.p0.a.k.h.b, JSONObject> s = s(str);
            c.a.p0.a.k.h.b bVar = (c.a.p0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                if (jSONObject == null) {
                    return new c.a.p0.a.k.h.b(1001);
                }
                String optString = jSONObject.optString("title");
                c.a.p0.a.x.g.g V = c.a.p0.a.w0.f.U().V();
                if (V == null) {
                    c.a.p0.a.u.d.c("NavigationBarApi", "manager is null");
                    return new c.a.p0.a.k.h.b(1001);
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    p("cb is empty", null, true);
                    return new c.a.p0.a.k.h.b(1001, "cb is empty");
                }
                q0.e0(new a(this, V.m(), optString, optString2));
                return c.a.p0.a.k.h.b.f();
            }
            return bVar;
        }
        return (c.a.p0.a.k.h.b) invokeL.objValue;
    }

    public c.a.p0.a.k.h.b B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#showNavigationBarLoading", false);
            c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
            if (a0 != null && a0.m0()) {
                return new c.a.p0.a.k.h.b(1001, "ui operation does not supported when app is invisible.");
            }
            return x(str, true);
        }
        return (c.a.p0.a.k.h.b) invokeL.objValue;
    }

    @Override // c.a.p0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigationBarApi" : (String) invokeV.objValue;
    }

    public final c.a.p0.a.k.h.b x(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            c.a.p0.a.x.g.g V = c.a.p0.a.w0.f.U().V();
            if (V == null) {
                c.a.p0.a.u.d.c("NavigationBarApi", "manager is null");
                return new c.a.p0.a.k.h.b(1001);
            }
            Pair<c.a.p0.a.k.h.b, JSONObject> s = s(str);
            c.a.p0.a.k.h.b bVar = (c.a.p0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    p("cb is empty", null, true);
                    return new c.a.p0.a.k.h.b(1001, "cb is empty");
                }
                q0.e0(new c(this, V.m(), optString, z));
                return c.a.p0.a.k.h.b.f();
            }
            return bVar;
        }
        return (c.a.p0.a.k.h.b) invokeLZ.objValue;
    }

    public c.a.p0.a.k.h.b y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#hideNavigationBarLoading", false);
            return x(str, false);
        }
        return (c.a.p0.a.k.h.b) invokeL.objValue;
    }

    public c.a.p0.a.k.h.b z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#setNavigationBarColor", false);
            c.a.p0.a.x.g.g V = c.a.p0.a.w0.f.U().V();
            if (V == null) {
                c.a.p0.a.u.d.c("NavigationBarApi", "manager is null");
                return new c.a.p0.a.k.h.b(1001);
            }
            Pair<c.a.p0.a.k.h.b, JSONObject> s = s(str);
            c.a.p0.a.k.h.b bVar = (c.a.p0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    p("cb is empty", null, true);
                    return new c.a.p0.a.k.h.b(1001, "cb is empty");
                }
                q0.e0(new b(this, V.m(), jSONObject.optString("frontColor"), optString, jSONObject.optString("backgroundColor"), jSONObject.optJSONObject("animation")));
                return c.a.p0.a.k.h.b.f();
            }
            return bVar;
        }
        return (c.a.p0.a.k.h.b) invokeL.objValue;
    }
}
