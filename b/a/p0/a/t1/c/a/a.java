package b.a.p0.a.t1.c.a;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.t1.c.d.e;
import b.a.p0.a.u.c.d;
import b.a.p0.n.h.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.t1.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0373a implements b.a.p0.a.h0.j.b<b.a.p0.a.t1.c.c.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f7931a;

        public C0373a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7931a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.h0.j.b
        /* renamed from: b */
        public void a(b.a.p0.a.t1.c.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f7931a.v(aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.h0.j.b<b.a.p0.a.t1.c.c.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f7932a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7932a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.h0.j.b
        /* renamed from: b */
        public void a(b.a.p0.a.t1.c.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f7932a.v(aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a.p0.a.h0.j.b<b.a.p0.a.t1.c.c.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f7933a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7933a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.h0.j.b
        /* renamed from: b */
        public void a(b.a.p0.a.t1.c.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f7933a.v(aVar);
            }
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

    public b.a.p0.a.u.h.b r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            b.a.p0.a.t1.c.b.b u = u(str);
            if (u.b()) {
                b.a.p0.a.t1.d.a.a(u.toString());
                return u.f7948i;
            }
            return new b.a.p0.a.t1.c.d.c().l(u, new b(this));
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            b.a.p0.a.t1.c.b.b u = u(str);
            if (u.b()) {
                b.a.p0.a.t1.d.a.a(u.toString());
                return u.f7948i;
            }
            return new e().l(u, new C0373a(this));
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            b.a.p0.a.t1.c.b.b u = u(str);
            if (u.b()) {
                b.a.p0.a.t1.d.a.a(u.toString());
                return u.f7948i;
            }
            return new b.a.p0.a.t1.c.d.d().l(u, new c(this));
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final b.a.p0.a.t1.c.b.b u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            b.a.p0.a.t1.c.b.b bVar = new b.a.p0.a.t1.c.b.b();
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-Base", str);
            bVar.f7948i = (b.a.p0.a.u.h.b) b2.first;
            JSONObject jSONObject = (JSONObject) b2.second;
            if (jSONObject == null) {
                return bVar;
            }
            String optString = jSONObject.optString("pluginProvider");
            if (TextUtils.isEmpty(optString)) {
                bVar.f7948i = new b.a.p0.a.u.h.b(201, "pluginProvider is empty");
                return bVar;
            }
            h g2 = b.a.p0.a.t1.g.b.g(optString);
            if (g2 != null) {
                String str2 = g2.r;
                if (!TextUtils.isEmpty(str2)) {
                    String optString2 = jSONObject.optString("providerRootPath");
                    if (TextUtils.isEmpty(optString2)) {
                        bVar.f7948i = new b.a.p0.a.u.h.b(201, "providerRootPath is empty");
                        return bVar;
                    }
                    String optString3 = jSONObject.optString("slaveId");
                    if (TextUtils.isEmpty(optString3)) {
                        bVar.f7948i = new b.a.p0.a.u.h.b(201, "slaveId is empty");
                        return bVar;
                    }
                    String optString4 = jSONObject.optString("componentId");
                    if (TextUtils.isEmpty(optString4)) {
                        bVar.f7948i = new b.a.p0.a.u.h.b(201, "componentId is empty");
                        return bVar;
                    }
                    String optString5 = jSONObject.optString("pluginVersion", "release");
                    String str3 = TextUtils.isEmpty(optString5) ? "release" : optString5;
                    JSONObject optJSONObject = jSONObject.optJSONObject("args");
                    String optString6 = jSONObject.optString("cb");
                    bVar.f7940a = str2;
                    bVar.f7941b = optString;
                    bVar.f7942c = optString2;
                    bVar.f7943d = str3;
                    bVar.f7944e = optString3;
                    bVar.f7945f = optString4;
                    bVar.f7946g = optJSONObject;
                    bVar.f7947h = optString6;
                    return bVar;
                }
            }
            bVar.f7948i = new b.a.p0.a.u.h.b(201, "pluginProvider exchange for truth app key，but empty");
            return bVar;
        }
        return (b.a.p0.a.t1.c.b.b) invokeL.objValue;
    }

    public final void v(b.a.p0.a.t1.c.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null) {
            return;
        }
        aVar.b();
    }
}
