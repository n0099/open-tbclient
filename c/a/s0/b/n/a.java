package c.a.s0.b.n;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import c.a.s0.a.d2.e;
import c.a.s0.a.h2.c.i;
import c.a.s0.a.h2.c.j.b;
import c.a.s0.a.u.c.c;
import c.a.s0.a.u.c.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.s0.b.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0680a extends c.a.s0.a.u.c.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f10332d;

        /* renamed from: c.a.s0.b.n.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0681a implements c.a.s0.a.z2.g1.c<i<b.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.b f10333e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C0680a f10334f;

            public C0681a(C0680a c0680a, c.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0680a, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f10334f = c0680a;
                this.f10333e = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.s0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(i<b.e> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    if (c.a.s0.a.h2.c.d.h(iVar)) {
                        this.f10333e.a(this.f10334f.f10332d.z());
                        return;
                    }
                    int b2 = iVar.b();
                    this.f10333e.a(new c.a.s0.a.u.h.b(b2, c.a.s0.a.h2.c.d.f(b2)));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0680a(a aVar, String str) {
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
            this.f10332d = aVar;
        }

        @Override // c.a.s0.a.u.c.c
        @NonNull
        public c.a.s0.a.u.h.b d(@NonNull JSONObject jSONObject, @NonNull c.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
                e a0 = e.a0();
                if (a0 == null) {
                    return new c.a.s0.a.u.h.b(1001, "null swan runtime");
                }
                a0.d0().g(c.a.s0.a.d2.d.J(), "mapp_i_get_bduss", new C0681a(this, bVar));
                return c.a.s0.a.u.h.b.f();
            }
            return (c.a.s0.a.u.h.b) invokeLL.objValue;
        }

        @Override // c.a.s0.a.u.c.c
        @NonNull
        public c.a.s0.a.u.h.b e(@NonNull JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) ? this.f10332d.z() : (c.a.s0.a.u.h.b) invokeL.objValue;
        }

        @Override // c.a.s0.a.u.c.c
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.a.s0.a.d2.d.J().D() && c.a.s0.a.d2.d.J().r().d0().f("mapp_i_get_bduss") : invokeV.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull c.a.s0.a.u.c.b bVar) {
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
                super((c.a.s0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.s0.a.u.c.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "PrivateAccount" : (String) invokeV.objValue;
    }

    @Override // c.a.s0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "GetBdussApi" : (String) invokeV.objValue;
    }

    @SuppressLint({"SwanBindApiNote"})
    public c.a.s0.a.u.h.b y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getBduss", false);
            return m(str, new C0680a(this, "getBDUSS"));
        }
        return (c.a.s0.a.u.h.b) invokeL.objValue;
    }

    @NonNull
    public final c.a.s0.a.u.h.b z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String i2 = c.a.s0.b.l.a.i(c.a.s0.a.d2.d.J());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("bduss", i2);
                return new c.a.s0.a.u.h.b(0, jSONObject);
            } catch (JSONException e2) {
                p("#getBdussResult json put data fail", e2, false);
                return new c.a.s0.a.u.h.b(1001, "json put data fail");
            }
        }
        return (c.a.s0.a.u.h.b) invokeV.objValue;
    }
}
