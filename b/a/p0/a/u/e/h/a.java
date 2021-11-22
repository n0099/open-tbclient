package b.a.p0.a.u.e.h;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.c1.d.e;
import b.a.p0.a.g1.f;
import b.a.p0.a.h2.c.i;
import b.a.p0.a.h2.c.j.b;
import b.a.p0.a.u.c.d;
import b.a.p0.a.u.e.h.b;
import b.a.p0.a.z2.q0;
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

    /* renamed from: b.a.p0.a.u.e.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0427a implements b.a.p0.a.z2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f8678e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8679f;

        public C0427a(a aVar, c cVar) {
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
            this.f8679f = aVar;
            this.f8678e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                this.f8679f.z(iVar, this.f8678e, false);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.z2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8680e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8681f;

        /* renamed from: b.a.p0.a.u.e.h.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0428a implements e.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0428a(b bVar) {
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

            @Override // b.a.p0.a.c1.d.e.a
            public void a(b.a.p0.a.f2.f.j0.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", bVar.a().toString());
                    f.U().u(new b.a.p0.a.o0.d.c("locationChange", hashMap));
                }
            }

            @Override // b.a.p0.a.c1.d.e.a
            public void onFailed(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    b.a.p0.a.n2.u.a.b("startLocationUpdate", 4000, "sdk's errCode is " + i2, -1, "");
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
            this.f8681f = aVar;
            this.f8680e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!b.a.p0.a.h2.c.d.h(iVar)) {
                    int b2 = iVar.b();
                    b.a.p0.a.n2.u.a.b("startLocationUpdate", 5000, b.a.p0.a.h2.c.d.f(b2), b2, b.a.p0.a.h2.c.d.f(b2));
                    this.f8681f.d(this.f8680e, new b.a.p0.a.u.h.b(b2, b.a.p0.a.h2.c.d.f(b2)));
                } else if (!q0.M()) {
                    b.a.p0.a.n2.u.a.b("startLocationUpdate", 5004, "user no permission", 10005, b.a.p0.a.h2.c.d.f(10005));
                    this.f8681f.d(this.f8680e, new b.a.p0.a.u.h.b(10005, b.a.p0.a.h2.c.d.f(10005)));
                } else {
                    this.f8681f.d(this.f8680e, new b.a.p0.a.u.h.b(0));
                    b.a.p0.a.c1.a.I().f(new C0428a(this));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f8682a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f8683b;

        /* renamed from: c  reason: collision with root package name */
        public String f8684c;

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
                    cVar.f8682a = optString;
                    if (TextUtils.isEmpty(optString)) {
                        cVar.f8682a = CoordinateType.WGS84;
                    }
                    cVar.f8683b = jSONObject.optBoolean("altitude");
                    String optString2 = jSONObject.optString("cb");
                    cVar.f8684c = optString2;
                    if (TextUtils.isEmpty(optString2)) {
                        return null;
                    }
                    return cVar;
                } catch (JSONException e2) {
                    b.a.p0.a.e0.d.d("GetLocationApi", "# parseFromJSON error", e2);
                    return null;
                }
            }
            return (c) invokeL.objValue;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.equals(this.f8682a, CoordinateType.WGS84) || TextUtils.equals(this.f8682a, "gcj02") || TextUtils.equals(this.f8682a, "bd09ll")) && !TextUtils.isEmpty(this.f8684c) : invokeV.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull b.a.p0.a.u.c.b bVar) {
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
            q("#startLocationUpdate", false);
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
            if (a0 == null) {
                b.a.p0.a.n2.u.a.b("startLocationUpdate", 2001, "SwanApp is null", 1001, "SwanApp is null");
                return new b.a.p0.a.u.h.b(1001, "SwanApp is null");
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> s = s(str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    b.a.p0.a.n2.u.a.b("startLocationUpdate", 1001, "empty cb", 201, "empty cb");
                    b.a.p0.a.e0.d.c("GetLocationApi", "empty cb");
                    return new b.a.p0.a.u.h.b(201, "empty cb");
                }
                a0.d0().g(getContext(), "mapp_location", new b(this, optString));
                return b.a.p0.a.u.h.b.f();
            }
            return bVar;
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b.a.p0.a.c1.a.I().e();
            return b.a.p0.a.u.h.b.f();
        }
        return (b.a.p0.a.u.h.b) invokeV.objValue;
    }

    @Override // b.a.p0.a.u.e.h.b.c
    public void b(c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, cVar, i2) == null) {
            b.a.p0.a.e0.d.c("GetLocationApi", "request location error code : " + i2);
            d(cVar.f8684c, new b.a.p0.a.u.h.b(1001, String.valueOf(i2)));
        }
    }

    @Override // b.a.p0.a.u.e.h.b.c
    public void f(c cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cVar, str) == null) {
            d(cVar.f8684c, new b.a.p0.a.u.h.b(10005, "system deny"));
        }
    }

    @Override // b.a.p0.a.u.e.h.b.c
    public void g(c cVar, b.a.p0.a.f2.f.j0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, cVar, bVar) == null) {
            d(cVar.f8684c, new b.a.p0.a.u.h.b(0, "success", bVar.a()));
        }
    }

    @Override // b.a.p0.a.u.c.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "LocationService" : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "GetLocationApi" : (String) invokeV.objValue;
    }

    public b.a.p0.a.u.h.b y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#getLocation", false);
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
            if (a0 == null) {
                b.a.p0.a.n2.u.a.b("getLocation", 2001, "SwanApp is null", 1001, "SwanApp is null");
                return new b.a.p0.a.u.h.b(1001, "SwanApp is null");
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> s = s(str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                c b2 = c.b(((JSONObject) s.second).toString());
                if (b2 != null && b2.a()) {
                    if (TextUtils.isEmpty(b2.f8684c)) {
                        b.a.p0.a.n2.u.a.b("getLocation", 1001, "empty cb", 201, "empty cb");
                        b.a.p0.a.e0.d.c("GetLocationApi", "empty cb");
                        return new b.a.p0.a.u.h.b(201, "empty cb");
                    }
                    a0.d0().g(getContext(), "mapp_location", new C0427a(this, b2));
                    return b.a.p0.a.u.h.b.f();
                }
                b.a.p0.a.n2.u.a.b("getLocation", 1001, "params is invalid", 201, "params is invalid");
                p("params is invalid", null, true);
                return new b.a.p0.a.u.h.b(201, "params is invalid");
            }
            return bVar;
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final void z(i<b.e> iVar, c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, iVar, cVar, z) == null) {
            b.a.p0.a.e0.d.i("GetLocationApi", "authorized result is " + iVar);
            if (b.a.p0.a.h2.c.d.h(iVar)) {
                b.a.p0.a.u.e.h.b.d().e(cVar, this, z);
                return;
            }
            int b2 = iVar.b();
            b.a.p0.a.n2.u.a.b("getLocation", 5000, b.a.p0.a.h2.c.d.f(b2), b2, b.a.p0.a.h2.c.d.f(b2));
            d(cVar.f8684c, new b.a.p0.a.u.h.b(b2, b.a.p0.a.h2.c.d.f(b2)));
        }
    }
}
