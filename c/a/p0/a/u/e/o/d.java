package c.a.p0.a.u.e.o;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.p0.a.n2.f.a;
import c.a.p0.a.u.c.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d extends c.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f9084a;

        /* renamed from: c.a.p0.a.u.e.o.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0418a implements a.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ l f9085a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ a f9086b;

            public C0418a(a aVar, l lVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, lVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9086b = aVar;
                this.f9085a = lVar;
            }

            @Override // c.a.p0.a.n2.f.a.c
            public void a(float f2, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("direction", f2);
                        jSONObject.put("accuracy", c.a.p0.a.n2.f.a.h(i2));
                        this.f9085a.d(this.f9086b.f9084a, jSONObject);
                    } catch (JSONException e2) {
                        c.a.p0.a.e0.d.b("Api-Compass", "handle compass,json error，" + e2.toString());
                        this.f9085a.f(this.f9086b.f9084a, "Json error");
                    }
                }
            }
        }

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9084a = dVar;
        }

        @Override // c.a.p0.a.u.c.d.b
        public c.a.p0.a.u.h.b a(c.a.p0.a.a2.e eVar, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, eVar, jSONObject, str)) == null) {
                c.a.p0.a.e0.d.g("Api-Compass", " init ");
                l lVar = new l("compassChange", jSONObject, str);
                c.a.p0.a.n2.f.a i2 = c.a.p0.a.n2.f.a.i();
                i2.l(this.f9084a.i());
                i2.o(new C0418a(this, lVar));
                c.a.p0.a.e0.d.g("Api-Compass", "start listen compass");
                i2.p();
                lVar.b(this.f9084a);
                return new c.a.p0.a.u.h.b(0);
            }
            return (c.a.p0.a.u.h.b) invokeLLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull c.a.p0.a.u.c.b bVar) {
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
            boolean z = c.a.p0.a.u.c.d.f8727c;
            return j(str, true, new a(this));
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public c.a.p0.a.u.h.b t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            boolean z = c.a.p0.a.u.c.d.f8727c;
            c.a.p0.a.e0.d.g("Api-Compass", "stop listen compass");
            c.a.p0.a.n2.f.a.i().q();
            return new c.a.p0.a.u.h.b(0);
        }
        return (c.a.p0.a.u.h.b) invokeV.objValue;
    }
}
