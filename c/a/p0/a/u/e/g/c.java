package c.a.p0.a.u.e.g;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends c.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.g.d f8852e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8853f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8854g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f8855h;

        public a(c cVar, c.a.p0.a.h0.g.d dVar, String str, String str2) {
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
            this.f8855h = cVar;
            this.f8852e = dVar;
            this.f8853f = str;
            this.f8854g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.h0.g.d dVar = this.f8852e;
                boolean z = true;
                if (!((dVar == null || !dVar.m2(this.f8853f, true)) ? false : false)) {
                    c.a.p0.a.e0.d.b("Api-NavigationBar", "set title fail");
                    this.f8855h.d(this.f8854g, new c.a.p0.a.u.h.b(1001));
                }
                this.f8855h.d(this.f8854g, new c.a.p0.a.u.h.b(0));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.g.d f8856e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8857f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f8858g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f8859h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8860i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c f8861j;

        public b(c cVar, c.a.p0.a.h0.g.d dVar, String str, String str2, String str3, JSONObject jSONObject) {
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
            this.f8861j = cVar;
            this.f8856e = dVar;
            this.f8857f = str;
            this.f8858g = str2;
            this.f8859h = str3;
            this.f8860i = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.h0.g.d dVar = this.f8856e;
                if (dVar != null && dVar.t2(this.f8857f, true)) {
                    if (!this.f8856e.k2(SwanAppConfigData.s(this.f8859h), true)) {
                        c.a.p0.a.e0.d.b("Api-NavigationBar", "set title background fail");
                        this.f8861j.d(this.f8858g, new c.a.p0.a.u.h.b(1001));
                        return;
                    }
                    JSONObject jSONObject = this.f8860i;
                    if (jSONObject != null) {
                        this.f8856e.i2(jSONObject.optInt("duration"), this.f8860i.optString("timingFunc"));
                        c.a.p0.a.e0.d.g("Api-NavigationBar", "set action bar animator");
                    }
                    this.f8861j.d(this.f8858g, new c.a.p0.a.u.h.b(0));
                    return;
                }
                c.a.p0.a.e0.d.b("Api-NavigationBar", "set title color fail");
                this.f8861j.d(this.f8858g, new c.a.p0.a.u.h.b(1001));
            }
        }
    }

    /* renamed from: c.a.p0.a.u.e.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0396c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.g.d f8862e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f8863f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f8864g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f8865h;

        public RunnableC0396c(c cVar, c.a.p0.a.h0.g.d dVar, String str, boolean z) {
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
            this.f8865h = cVar;
            this.f8862e = dVar;
            this.f8863f = str;
            this.f8864g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean M1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.h0.g.d dVar = this.f8862e;
                if (dVar == null) {
                    c.a.p0.a.e0.d.b("Api-NavigationBar", "swanAppFragment is null");
                    this.f8865h.d(this.f8863f, new c.a.p0.a.u.h.b(1001));
                    return;
                }
                if (this.f8864g) {
                    M1 = dVar.B2();
                } else {
                    M1 = dVar.M1();
                }
                if (!M1) {
                    String str = this.f8864g ? "show" : "hide";
                    c.a.p0.a.e0.d.b("Api-NavigationBar", str + " navigation loading progressbar fail");
                    this.f8865h.d(this.f8863f, new c.a.p0.a.u.h.b(1001));
                    return;
                }
                this.f8865h.d(this.f8863f, new c.a.p0.a.u.h.b(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull c.a.p0.a.u.c.b bVar) {
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

    public final c.a.p0.a.u.h.b r(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            c.a.p0.a.h0.g.g W = c.a.p0.a.g1.f.V().W();
            if (W == null) {
                c.a.p0.a.e0.d.b("Api-NavigationBar", "manager is null");
                return new c.a.p0.a.u.h.b(1001);
            }
            Pair<c.a.p0.a.u.h.b, JSONObject> b2 = c.a.p0.a.u.i.b.b("Api-NavigationBar", str);
            c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (c.a.p0.a.u.c.d.f8735c) {
                    c.a.p0.a.e0.d.b("Api-NavigationBar", "parse fail");
                }
                return bVar;
            }
            String optString = ((JSONObject) b2.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.p0.a.e0.d.b("Api-NavigationBar", "callback is null");
                return new c.a.p0.a.u.h.b(1001, "callback is null");
            }
            q0.b0(new RunnableC0396c(this, W.m(), optString, z));
            return new c.a.p0.a.u.h.b(0);
        }
        return (c.a.p0.a.u.h.b) invokeLZ.objValue;
    }

    public c.a.p0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            boolean z = c.a.p0.a.u.c.d.f8735c;
            return r(str, false);
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public c.a.p0.a.u.h.b t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            boolean z = c.a.p0.a.u.c.d.f8735c;
            c.a.p0.a.h0.g.g W = c.a.p0.a.g1.f.V().W();
            if (W == null) {
                c.a.p0.a.e0.d.b("Api-NavigationBar", "manager is null");
                return new c.a.p0.a.u.h.b(1001);
            }
            Pair<c.a.p0.a.u.h.b, JSONObject> b2 = c.a.p0.a.u.i.b.b("Api-NavigationBar", str);
            c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (c.a.p0.a.u.c.d.f8735c) {
                    c.a.p0.a.e0.d.b("Api-NavigationBar", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.p0.a.e0.d.b("Api-NavigationBar", "callback is null");
                return new c.a.p0.a.u.h.b(1001, "callback is null");
            }
            q0.b0(new b(this, W.m(), jSONObject.optString("frontColor"), optString, jSONObject.optString("backgroundColor"), jSONObject.optJSONObject("animation")));
            return new c.a.p0.a.u.h.b(0);
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public c.a.p0.a.u.h.b u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            boolean z = c.a.p0.a.u.c.d.f8735c;
            Pair<c.a.p0.a.u.h.b, JSONObject> b2 = c.a.p0.a.u.i.b.b("Api-NavigationBar", str);
            c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                c.a.p0.a.e0.d.b("Api-NavigationBar", "parse fail");
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            if (jSONObject == null) {
                c.a.p0.a.e0.d.b("Api-NavigationBar", "paramsJson is null");
                return new c.a.p0.a.u.h.b(1001);
            }
            String optString = jSONObject.optString("title");
            c.a.p0.a.h0.g.g W = c.a.p0.a.g1.f.V().W();
            if (W == null) {
                c.a.p0.a.e0.d.b("Api-NavigationBar", "manager is null");
                return new c.a.p0.a.u.h.b(1001);
            }
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                c.a.p0.a.e0.d.b("Api-NavigationBar", "callback is null");
                return new c.a.p0.a.u.h.b(1001, "callback is null");
            }
            q0.b0(new a(this, W.m(), optString, optString2));
            return new c.a.p0.a.u.h.b(0);
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public c.a.p0.a.u.h.b v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            boolean z = c.a.p0.a.u.c.d.f8735c;
            c.a.p0.a.a2.e Q = c.a.p0.a.a2.e.Q();
            if (Q != null && Q.d0()) {
                boolean z2 = c.a.p0.a.u.c.d.f8735c;
                return new c.a.p0.a.u.h.b(1001, "ui operation does not supported when app is invisible.");
            }
            return r(str, true);
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }
}
