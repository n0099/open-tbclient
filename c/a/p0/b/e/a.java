package c.a.p0.b.e;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import c.a.p0.a.k.c.c;
import c.a.p0.a.k.c.d;
import c.a.p0.a.t1.e;
import c.a.p0.a.x1.c.i;
import c.a.p0.a.x1.c.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0625a extends c.a.p0.a.k.c.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f9557d;

        /* renamed from: c.a.p0.b.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0626a implements c.a.p0.a.p2.g1.c<i<b.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.b f9558e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C0625a f9559f;

            public C0626a(C0625a c0625a, c.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0625a, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9559f = c0625a;
                this.f9558e = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.p2.g1.c
            /* renamed from: a */
            public void onCallback(i<b.e> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    if (c.a.p0.a.x1.c.d.h(iVar)) {
                        this.f9558e.a(this.f9559f.f9557d.z());
                        return;
                    }
                    int b2 = iVar.b();
                    this.f9558e.a(new c.a.p0.a.k.h.b(b2, c.a.p0.a.x1.c.d.f(b2)));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0625a(a aVar, String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f9557d = aVar;
        }

        @Override // c.a.p0.a.k.c.c
        @NonNull
        public c.a.p0.a.k.h.b d(@NonNull JSONObject jSONObject, @NonNull c.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
                e a0 = e.a0();
                if (a0 == null) {
                    return new c.a.p0.a.k.h.b(1001, "null swan runtime");
                }
                a0.d0().g(c.a.p0.a.t1.d.J(), "mapp_i_get_bduss", new C0626a(this, bVar));
                return c.a.p0.a.k.h.b.f();
            }
            return (c.a.p0.a.k.h.b) invokeLL.objValue;
        }

        @Override // c.a.p0.a.k.c.c
        @NonNull
        public c.a.p0.a.k.h.b e(@NonNull JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) ? this.f9557d.z() : (c.a.p0.a.k.h.b) invokeL.objValue;
        }

        @Override // c.a.p0.a.k.c.c
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.a.p0.a.t1.d.J().D() && c.a.p0.a.t1.d.J().r().d0().f("mapp_i_get_bduss") : invokeV.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.p0.a.k.c.b bVar) {
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

    @Override // c.a.p0.a.k.c.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "PrivateAccount" : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "GetBdussApi" : (String) invokeV.objValue;
    }

    @SuppressLint({"SwanBindApiNote"})
    public c.a.p0.a.k.h.b y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getBduss", false);
            return m(str, new C0625a(this, "getBDUSS"));
        }
        return (c.a.p0.a.k.h.b) invokeL.objValue;
    }

    @NonNull
    public final c.a.p0.a.k.h.b z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String i2 = c.a.p0.b.c.a.i(c.a.p0.a.t1.d.J());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("bduss", i2);
                return new c.a.p0.a.k.h.b(0, jSONObject);
            } catch (JSONException e2) {
                p("#getBdussResult json put data fail", e2, false);
                return new c.a.p0.a.k.h.b(1001, "json put data fail");
            }
        }
        return (c.a.p0.a.k.h.b) invokeV.objValue;
    }
}
