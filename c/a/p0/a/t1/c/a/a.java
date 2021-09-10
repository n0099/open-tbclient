package c.a.p0.a.t1.c.a;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.p0.a.t1.c.d.e;
import c.a.p0.a.u.c.d;
import c.a.p0.n.h.h;
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

    /* renamed from: c.a.p0.a.t1.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0378a implements c.a.p0.a.h0.j.b<c.a.p0.a.t1.c.c.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f8657a;

        public C0378a(a aVar) {
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
            this.f8657a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.h0.j.b
        /* renamed from: b */
        public void a(c.a.p0.a.t1.c.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f8657a.w(aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.h0.j.b<c.a.p0.a.t1.c.c.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f8658a;

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
            this.f8658a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.h0.j.b
        /* renamed from: b */
        public void a(c.a.p0.a.t1.c.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f8658a.w(aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.a.h0.j.b<c.a.p0.a.t1.c.c.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f8659a;

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
            this.f8659a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.h0.j.b
        /* renamed from: b */
        public void a(c.a.p0.a.t1.c.c.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.f8659a.w(aVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.p0.a.u.c.b bVar) {
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

    public c.a.p0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            c.a.p0.a.t1.c.b.b v = v(str);
            if (v.b()) {
                c.a.p0.a.t1.d.a.a(v.toString());
                return v.f8674i;
            }
            return new c.a.p0.a.t1.c.d.c().l(v, new b(this));
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public c.a.p0.a.u.h.b t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            c.a.p0.a.t1.c.b.b v = v(str);
            if (v.b()) {
                c.a.p0.a.t1.d.a.a(v.toString());
                return v.f8674i;
            }
            return new e().l(v, new C0378a(this));
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public c.a.p0.a.u.h.b u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            c.a.p0.a.t1.c.b.b v = v(str);
            if (v.b()) {
                c.a.p0.a.t1.d.a.a(v.toString());
                return v.f8674i;
            }
            return new c.a.p0.a.t1.c.d.d().l(v, new c(this));
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final c.a.p0.a.t1.c.b.b v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            c.a.p0.a.t1.c.b.b bVar = new c.a.p0.a.t1.c.b.b();
            Pair<c.a.p0.a.u.h.b, JSONObject> b2 = c.a.p0.a.u.i.b.b("Api-Base", str);
            bVar.f8674i = (c.a.p0.a.u.h.b) b2.first;
            JSONObject jSONObject = (JSONObject) b2.second;
            if (jSONObject == null) {
                return bVar;
            }
            String optString = jSONObject.optString("pluginProvider");
            if (TextUtils.isEmpty(optString)) {
                bVar.f8674i = new c.a.p0.a.u.h.b(201, "pluginProvider is empty");
                return bVar;
            }
            h g2 = c.a.p0.a.t1.g.b.g(optString);
            if (g2 != null) {
                String str2 = g2.r;
                if (!TextUtils.isEmpty(str2)) {
                    String optString2 = jSONObject.optString("providerRootPath");
                    if (TextUtils.isEmpty(optString2)) {
                        bVar.f8674i = new c.a.p0.a.u.h.b(201, "providerRootPath is empty");
                        return bVar;
                    }
                    String optString3 = jSONObject.optString("slaveId");
                    if (TextUtils.isEmpty(optString3)) {
                        bVar.f8674i = new c.a.p0.a.u.h.b(201, "slaveId is empty");
                        return bVar;
                    }
                    String optString4 = jSONObject.optString("componentId");
                    if (TextUtils.isEmpty(optString4)) {
                        bVar.f8674i = new c.a.p0.a.u.h.b(201, "componentId is empty");
                        return bVar;
                    }
                    String optString5 = jSONObject.optString("pluginVersion", "release");
                    String str3 = TextUtils.isEmpty(optString5) ? "release" : optString5;
                    JSONObject optJSONObject = jSONObject.optJSONObject("args");
                    String optString6 = jSONObject.optString("cb");
                    bVar.f8666a = str2;
                    bVar.f8667b = optString;
                    bVar.f8668c = optString2;
                    bVar.f8669d = str3;
                    bVar.f8670e = optString3;
                    bVar.f8671f = optString4;
                    bVar.f8672g = optJSONObject;
                    bVar.f8673h = optString6;
                    return bVar;
                }
            }
            bVar.f8674i = new c.a.p0.a.u.h.b(201, "pluginProvider exchange for truth app key，but empty");
            return bVar;
        }
        return (c.a.p0.a.t1.c.b.b) invokeL.objValue;
    }

    public final void w(c.a.p0.a.t1.c.c.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null) {
            return;
        }
        aVar.b();
    }
}
