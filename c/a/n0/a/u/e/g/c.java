package c.a.n0.a.u.e.g;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.n0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends c.a.n0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.g.d f8570e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8571f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8572g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f8573h;

        public a(c cVar, c.a.n0.a.h0.g.d dVar, String str, String str2) {
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
            this.f8573h = cVar;
            this.f8570e = dVar;
            this.f8571f = str;
            this.f8572g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.h0.g.d dVar = this.f8570e;
                boolean z = true;
                if (!((dVar == null || !dVar.m2(this.f8571f, true)) ? false : false)) {
                    c.a.n0.a.e0.d.b("Api-NavigationBar", "set title fail");
                    this.f8573h.d(this.f8572g, new c.a.n0.a.u.h.b(1001));
                }
                this.f8573h.d(this.f8572g, new c.a.n0.a.u.h.b(0));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.g.d f8574e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8575f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8576g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8577h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8578i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c f8579j;

        public b(c cVar, c.a.n0.a.h0.g.d dVar, String str, String str2, String str3, JSONObject jSONObject) {
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
            this.f8579j = cVar;
            this.f8574e = dVar;
            this.f8575f = str;
            this.f8576g = str2;
            this.f8577h = str3;
            this.f8578i = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.h0.g.d dVar = this.f8574e;
                if (dVar != null && dVar.t2(this.f8575f, true)) {
                    if (!this.f8574e.k2(SwanAppConfigData.s(this.f8577h), true)) {
                        c.a.n0.a.e0.d.b("Api-NavigationBar", "set title background fail");
                        this.f8579j.d(this.f8576g, new c.a.n0.a.u.h.b(1001));
                        return;
                    }
                    JSONObject jSONObject = this.f8578i;
                    if (jSONObject != null) {
                        this.f8574e.i2(jSONObject.optInt("duration"), this.f8578i.optString("timingFunc"));
                        c.a.n0.a.e0.d.g("Api-NavigationBar", "set action bar animator");
                    }
                    this.f8579j.d(this.f8576g, new c.a.n0.a.u.h.b(0));
                    return;
                }
                c.a.n0.a.e0.d.b("Api-NavigationBar", "set title color fail");
                this.f8579j.d(this.f8576g, new c.a.n0.a.u.h.b(1001));
            }
        }
    }

    /* renamed from: c.a.n0.a.u.e.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0386c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.g.d f8580e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8581f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f8582g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f8583h;

        public RunnableC0386c(c cVar, c.a.n0.a.h0.g.d dVar, String str, boolean z) {
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
            this.f8583h = cVar;
            this.f8580e = dVar;
            this.f8581f = str;
            this.f8582g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean M1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.h0.g.d dVar = this.f8580e;
                if (dVar == null) {
                    c.a.n0.a.e0.d.b("Api-NavigationBar", "swanAppFragment is null");
                    this.f8583h.d(this.f8581f, new c.a.n0.a.u.h.b(1001));
                    return;
                }
                if (this.f8582g) {
                    M1 = dVar.B2();
                } else {
                    M1 = dVar.M1();
                }
                if (!M1) {
                    String str = this.f8582g ? "show" : "hide";
                    c.a.n0.a.e0.d.b("Api-NavigationBar", str + " navigation loading progressbar fail");
                    this.f8583h.d(this.f8581f, new c.a.n0.a.u.h.b(1001));
                    return;
                }
                this.f8583h.d(this.f8581f, new c.a.n0.a.u.h.b(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull c.a.n0.a.u.c.b bVar) {
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
                super((c.a.n0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final c.a.n0.a.u.h.b r(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            c.a.n0.a.h0.g.g W = c.a.n0.a.g1.f.V().W();
            if (W == null) {
                c.a.n0.a.e0.d.b("Api-NavigationBar", "manager is null");
                return new c.a.n0.a.u.h.b(1001);
            }
            Pair<c.a.n0.a.u.h.b, JSONObject> b2 = c.a.n0.a.u.i.b.b("Api-NavigationBar", str);
            c.a.n0.a.u.h.b bVar = (c.a.n0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (c.a.n0.a.u.c.d.f8453c) {
                    c.a.n0.a.e0.d.b("Api-NavigationBar", "parse fail");
                }
                return bVar;
            }
            String optString = ((JSONObject) b2.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.n0.a.e0.d.b("Api-NavigationBar", "callback is null");
                return new c.a.n0.a.u.h.b(1001, "callback is null");
            }
            q0.b0(new RunnableC0386c(this, W.m(), optString, z));
            return new c.a.n0.a.u.h.b(0);
        }
        return (c.a.n0.a.u.h.b) invokeLZ.objValue;
    }

    public c.a.n0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            boolean z = c.a.n0.a.u.c.d.f8453c;
            return r(str, false);
        }
        return (c.a.n0.a.u.h.b) invokeL.objValue;
    }

    public c.a.n0.a.u.h.b t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            boolean z = c.a.n0.a.u.c.d.f8453c;
            c.a.n0.a.h0.g.g W = c.a.n0.a.g1.f.V().W();
            if (W == null) {
                c.a.n0.a.e0.d.b("Api-NavigationBar", "manager is null");
                return new c.a.n0.a.u.h.b(1001);
            }
            Pair<c.a.n0.a.u.h.b, JSONObject> b2 = c.a.n0.a.u.i.b.b("Api-NavigationBar", str);
            c.a.n0.a.u.h.b bVar = (c.a.n0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (c.a.n0.a.u.c.d.f8453c) {
                    c.a.n0.a.e0.d.b("Api-NavigationBar", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.n0.a.e0.d.b("Api-NavigationBar", "callback is null");
                return new c.a.n0.a.u.h.b(1001, "callback is null");
            }
            q0.b0(new b(this, W.m(), jSONObject.optString("frontColor"), optString, jSONObject.optString("backgroundColor"), jSONObject.optJSONObject("animation")));
            return new c.a.n0.a.u.h.b(0);
        }
        return (c.a.n0.a.u.h.b) invokeL.objValue;
    }

    public c.a.n0.a.u.h.b u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            boolean z = c.a.n0.a.u.c.d.f8453c;
            Pair<c.a.n0.a.u.h.b, JSONObject> b2 = c.a.n0.a.u.i.b.b("Api-NavigationBar", str);
            c.a.n0.a.u.h.b bVar = (c.a.n0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                c.a.n0.a.e0.d.b("Api-NavigationBar", "parse fail");
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            if (jSONObject == null) {
                c.a.n0.a.e0.d.b("Api-NavigationBar", "paramsJson is null");
                return new c.a.n0.a.u.h.b(1001);
            }
            String optString = jSONObject.optString("title");
            c.a.n0.a.h0.g.g W = c.a.n0.a.g1.f.V().W();
            if (W == null) {
                c.a.n0.a.e0.d.b("Api-NavigationBar", "manager is null");
                return new c.a.n0.a.u.h.b(1001);
            }
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                c.a.n0.a.e0.d.b("Api-NavigationBar", "callback is null");
                return new c.a.n0.a.u.h.b(1001, "callback is null");
            }
            q0.b0(new a(this, W.m(), optString, optString2));
            return new c.a.n0.a.u.h.b(0);
        }
        return (c.a.n0.a.u.h.b) invokeL.objValue;
    }

    public c.a.n0.a.u.h.b v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            boolean z = c.a.n0.a.u.c.d.f8453c;
            c.a.n0.a.a2.e Q = c.a.n0.a.a2.e.Q();
            if (Q != null && Q.d0()) {
                boolean z2 = c.a.n0.a.u.c.d.f8453c;
                return new c.a.n0.a.u.h.b(1001, "ui operation does not supported when app is invisible.");
            }
            return r(str, true);
        }
        return (c.a.n0.a.u.h.b) invokeL.objValue;
    }
}
