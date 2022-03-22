package c.a.n0.a.k.e.h;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.k.c.d;
import c.a.n0.a.k.e.h.b;
import c.a.n0.a.p2.q0;
import c.a.n0.a.s0.d.e;
import c.a.n0.a.w0.f;
import c.a.n0.a.x1.c.i;
import c.a.n0.a.x1.c.j.b;
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

    /* renamed from: c.a.n0.a.k.e.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0341a implements c.a.n0.a.p2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f5090b;

        public C0341a(a aVar, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5090b = aVar;
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                this.f5090b.z(iVar, this.a, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.n0.a.p2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f5091b;

        /* renamed from: c.a.n0.a.k.e.h.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0342a implements e.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0342a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.n0.a.s0.d.e.a
            public void a(c.a.n0.a.v1.f.j0.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", bVar.a().toString());
                    f.U().u(new c.a.n0.a.e0.d.c("locationChange", hashMap));
                }
            }

            @Override // c.a.n0.a.s0.d.e.a
            public void onFailed(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    c.a.n0.a.d2.u.a.b("startLocationUpdate", 4000, "sdk's errCode is " + i, -1, "");
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5091b = aVar;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!c.a.n0.a.x1.c.d.h(iVar)) {
                    int b2 = iVar.b();
                    c.a.n0.a.d2.u.a.b("startLocationUpdate", 5000, c.a.n0.a.x1.c.d.f(b2), b2, c.a.n0.a.x1.c.d.f(b2));
                    this.f5091b.d(this.a, new c.a.n0.a.k.h.b(b2, c.a.n0.a.x1.c.d.f(b2)));
                } else if (!q0.M()) {
                    c.a.n0.a.d2.u.a.b("startLocationUpdate", 5004, "user no permission", 10005, c.a.n0.a.x1.c.d.f(10005));
                    this.f5091b.d(this.a, new c.a.n0.a.k.h.b(10005, c.a.n0.a.x1.c.d.f(10005)));
                } else {
                    this.f5091b.d(this.a, new c.a.n0.a.k.h.b(0));
                    c.a.n0.a.s0.a.I().f(new C0342a(this));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f5092b;

        /* renamed from: c  reason: collision with root package name */
        public String f5093c;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                    cVar.a = optString;
                    if (TextUtils.isEmpty(optString)) {
                        cVar.a = CoordinateType.WGS84;
                    }
                    cVar.f5092b = jSONObject.optBoolean("altitude");
                    String optString2 = jSONObject.optString("cb");
                    cVar.f5093c = optString2;
                    if (TextUtils.isEmpty(optString2)) {
                        return null;
                    }
                    return cVar;
                } catch (JSONException e2) {
                    c.a.n0.a.u.d.d("GetLocationApi", "# parseFromJSON error", e2);
                    return null;
                }
            }
            return (c) invokeL.objValue;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.equals(this.a, CoordinateType.WGS84) || TextUtils.equals(this.a, "gcj02") || TextUtils.equals(this.a, "bd09ll")) && !TextUtils.isEmpty(this.f5093c) : invokeV.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.n0.a.k.c.b bVar) {
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
            q("#startLocationUpdate", false);
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            if (a0 == null) {
                c.a.n0.a.d2.u.a.b("startLocationUpdate", 2001, "SwanApp is null", 1001, "SwanApp is null");
                return new c.a.n0.a.k.h.b(1001, "SwanApp is null");
            }
            Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
            c.a.n0.a.k.h.b bVar = (c.a.n0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c.a.n0.a.d2.u.a.b("startLocationUpdate", 1001, "empty cb", 201, "empty cb");
                    c.a.n0.a.u.d.c("GetLocationApi", "empty cb");
                    return new c.a.n0.a.k.h.b(201, "empty cb");
                }
                a0.d0().g(getContext(), "mapp_location", new b(this, optString));
                return c.a.n0.a.k.h.b.f();
            }
            return bVar;
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    public c.a.n0.a.k.h.b B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.n0.a.s0.a.I().e();
            return c.a.n0.a.k.h.b.f();
        }
        return (c.a.n0.a.k.h.b) invokeV.objValue;
    }

    @Override // c.a.n0.a.k.e.h.b.c
    public void b(c cVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, cVar, i) == null) {
            c.a.n0.a.u.d.c("GetLocationApi", "request location error code : " + i);
            d(cVar.f5093c, new c.a.n0.a.k.h.b(1001, String.valueOf(i)));
        }
    }

    @Override // c.a.n0.a.k.e.h.b.c
    public void f(c cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cVar, str) == null) {
            d(cVar.f5093c, new c.a.n0.a.k.h.b(10005, "system deny"));
        }
    }

    @Override // c.a.n0.a.k.e.h.b.c
    public void g(c cVar, c.a.n0.a.v1.f.j0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, cVar, bVar) == null) {
            d(cVar.f5093c, new c.a.n0.a.k.h.b(0, "success", bVar.a()));
        }
    }

    @Override // c.a.n0.a.k.c.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "LocationService" : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "GetLocationApi" : (String) invokeV.objValue;
    }

    public c.a.n0.a.k.h.b y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#getLocation", false);
            c.a.n0.a.t1.e a0 = c.a.n0.a.t1.e.a0();
            if (a0 == null) {
                c.a.n0.a.d2.u.a.b("getLocation", 2001, "SwanApp is null", 1001, "SwanApp is null");
                return new c.a.n0.a.k.h.b(1001, "SwanApp is null");
            }
            Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
            c.a.n0.a.k.h.b bVar = (c.a.n0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                c b2 = c.b(((JSONObject) s.second).toString());
                if (b2 != null && b2.a()) {
                    if (TextUtils.isEmpty(b2.f5093c)) {
                        c.a.n0.a.d2.u.a.b("getLocation", 1001, "empty cb", 201, "empty cb");
                        c.a.n0.a.u.d.c("GetLocationApi", "empty cb");
                        return new c.a.n0.a.k.h.b(201, "empty cb");
                    }
                    a0.d0().g(getContext(), "mapp_location", new C0341a(this, b2));
                    return c.a.n0.a.k.h.b.f();
                }
                c.a.n0.a.d2.u.a.b("getLocation", 1001, "params is invalid", 201, "params is invalid");
                p("params is invalid", null, true);
                return new c.a.n0.a.k.h.b(201, "params is invalid");
            }
            return bVar;
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    public final void z(i<b.e> iVar, c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, iVar, cVar, z) == null) {
            c.a.n0.a.u.d.i("GetLocationApi", "authorized result is " + iVar);
            if (c.a.n0.a.x1.c.d.h(iVar)) {
                c.a.n0.a.k.e.h.b.d().e(cVar, this, z);
                return;
            }
            int b2 = iVar.b();
            c.a.n0.a.d2.u.a.b("getLocation", 5000, c.a.n0.a.x1.c.d.f(b2), b2, c.a.n0.a.x1.c.d.f(b2));
            d(cVar.f5093c, new c.a.n0.a.k.h.b(b2, c.a.n0.a.x1.c.d.f(b2)));
        }
    }
}
