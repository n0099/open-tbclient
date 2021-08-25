package c.a.o0.a.u.e.i;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.o0.a.a2.e;
import c.a.o0.a.c1.d.d;
import c.a.o0.a.e2.c.i;
import c.a.o0.a.e2.c.j.b;
import c.a.o0.a.g1.f;
import c.a.o0.a.u.c.d;
import c.a.o0.a.u.e.i.b;
import c.a.o0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends d implements b.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.o0.a.u.e.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0401a implements c.a.o0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f8912e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8913f;

        public C0401a(a aVar, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8913f = aVar;
            this.f8912e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                this.f8913f.t(iVar, this.f8912e, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.o0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8914e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8915f;

        /* renamed from: c.a.o0.a.u.e.i.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0402a implements d.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0402a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.o0.a.c1.d.d.a
            public void a(c.a.o0.a.c2.f.k0.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", bVar.a().toString());
                    f.V().v(new c.a.o0.a.o0.d.b("locationChange", hashMap));
                }
            }

            @Override // c.a.o0.a.c1.d.d.a
            public void onFailed(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                }
            }
        }

        public b(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8915f = aVar;
            this.f8914e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.o0.a.e2.c.d.h(iVar)) {
                    int b2 = iVar.b();
                    this.f8915f.d(this.f8914e, new c.a.o0.a.u.h.b(b2, c.a.o0.a.e2.c.d.f(b2)));
                } else if (!q0.L()) {
                    this.f8915f.d(this.f8914e, new c.a.o0.a.u.h.b(10005, c.a.o0.a.e2.c.d.f(10005)));
                } else {
                    this.f8915f.d(this.f8914e, new c.a.o0.a.u.h.b(0));
                    c.a.o0.a.c1.a.E().e(new C0402a(this));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f8916a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f8917b;

        /* renamed from: c  reason: collision with root package name */
        public String f8918c;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static c b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                c cVar = new c();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("type");
                    cVar.f8916a = optString;
                    if (TextUtils.isEmpty(optString)) {
                        cVar.f8916a = CoordinateType.WGS84;
                    }
                    cVar.f8917b = jSONObject.optBoolean("altitude");
                    String optString2 = jSONObject.optString("cb");
                    cVar.f8918c = optString2;
                    if (TextUtils.isEmpty(optString2)) {
                        return null;
                    }
                    return cVar;
                } catch (JSONException e2) {
                    if (c.a.o0.a.u.c.d.f8699c) {
                        String str2 = "parse failed: " + Log.getStackTraceString(e2);
                    }
                    c.a.o0.a.e0.d.b("Api-GetLocationAction", "parse failed: " + Log.getStackTraceString(e2));
                    return null;
                }
            }
            return (c) invokeL.objValue;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.equals(this.f8916a, CoordinateType.WGS84) || TextUtils.equals(this.f8916a, "gcj02") || TextUtils.equals(this.f8916a, "bd09ll")) && !TextUtils.isEmpty(this.f8918c) : invokeV.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.o0.a.u.c.b bVar) {
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
                super((c.a.o0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.o0.a.u.e.i.b.c
    public void b(c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
            c.a.o0.a.e0.d.b("Api-GetLocationAction", "request location error code : " + i2);
            d(cVar.f8918c, new c.a.o0.a.u.h.b(1001, String.valueOf(i2)));
        }
    }

    @Override // c.a.o0.a.u.e.i.b.c
    public void f(c cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, str) == null) {
            d(cVar.f8918c, new c.a.o0.a.u.h.b(10005, "system deny"));
        }
    }

    @Override // c.a.o0.a.u.e.i.b.c
    public void g(c cVar, c.a.o0.a.c2.f.k0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, bVar) == null) {
            if (c.a.o0.a.u.c.d.f8699c) {
                String str = "convert info : " + bVar.a();
            }
            d(cVar.f8918c, new c.a.o0.a.u.h.b(0, "success", bVar.a()));
        }
    }

    public c.a.o0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (c.a.o0.a.u.c.d.f8699c) {
                String str2 = "handle: " + str;
            }
            e Q = e.Q();
            if (Q == null) {
                return new c.a.o0.a.u.h.b(1001, "SwanApp is null");
            }
            Pair<c.a.o0.a.u.h.b, JSONObject> b2 = c.a.o0.a.u.i.b.b("Api-GetLocationAction", str);
            c.a.o0.a.u.h.b bVar = (c.a.o0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (c.a.o0.a.u.c.d.f8699c) {
                    c.a.o0.a.e0.d.b("Api-GetLocationAction", "parse fail");
                }
                return bVar;
            }
            c b3 = c.b(((JSONObject) b2.second).toString());
            if (b3 != null && b3.a()) {
                if (TextUtils.isEmpty(b3.f8918c)) {
                    c.a.o0.a.e0.d.b("Api-GetLocationAction", "empty cb");
                    return new c.a.o0.a.u.h.b(201, "empty cb");
                }
                Q.T().g(i(), "mapp_location", new C0401a(this, b3));
                return new c.a.o0.a.u.h.b(0);
            }
            c.a.o0.a.e0.d.b("Api-GetLocationAction", "params is invalid");
            return new c.a.o0.a.u.h.b(201, "params is invalid");
        }
        return (c.a.o0.a.u.h.b) invokeL.objValue;
    }

    public final void t(i<b.e> iVar, c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, iVar, cVar, z) == null) {
            c.a.o0.a.e0.d.g("Api-GetLocationAction", "authorized result is " + iVar);
            if (c.a.o0.a.e2.c.d.h(iVar)) {
                c.a.o0.a.u.e.i.b.d().e(cVar, this, z);
                return;
            }
            int b2 = iVar.b();
            d(cVar.f8918c, new c.a.o0.a.u.h.b(b2, c.a.o0.a.e2.c.d.f(b2)));
        }
    }

    public c.a.o0.a.u.h.b u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (c.a.o0.a.u.c.d.f8699c) {
                String str2 = "handle: " + str;
            }
            e Q = e.Q();
            if (Q == null) {
                return new c.a.o0.a.u.h.b(1001, "SwanApp is null");
            }
            Pair<c.a.o0.a.u.h.b, JSONObject> b2 = c.a.o0.a.u.i.b.b("Api-GetLocationAction", str);
            c.a.o0.a.u.h.b bVar = (c.a.o0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (c.a.o0.a.u.c.d.f8699c) {
                    c.a.o0.a.e0.d.b("Api-GetLocationAction", "parse fail");
                }
                return bVar;
            }
            String optString = ((JSONObject) b2.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new c.a.o0.a.u.h.b(201, "empty cb");
            }
            Q.T().g(i(), "mapp_location", new b(this, optString));
            return new c.a.o0.a.u.h.b(0);
        }
        return (c.a.o0.a.u.h.b) invokeL.objValue;
    }

    public c.a.o0.a.u.h.b v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.o0.a.c1.a.E().d();
            return new c.a.o0.a.u.h.b(0);
        }
        return (c.a.o0.a.u.h.b) invokeV.objValue;
    }
}
