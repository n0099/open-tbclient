package c.a.p0.b.n;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import c.a.p0.a.d2.e;
import c.a.p0.a.h2.c.i;
import c.a.p0.a.h2.c.j.b;
import c.a.p0.a.u.c.c;
import c.a.p0.a.u.c.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.b.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0567a extends c.a.p0.a.u.c.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f9270d;

        /* renamed from: c.a.p0.b.n.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0568a implements c.a.p0.a.z2.g1.c<i<b.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.b f9271e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ C0567a f9272f;

            public C0568a(C0567a c0567a, c.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0567a, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f9272f = c0567a;
                this.f9271e = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.p0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(i<b.e> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    if (c.a.p0.a.h2.c.d.h(iVar)) {
                        this.f9271e.a(this.f9272f.f9270d.z());
                        return;
                    }
                    int b2 = iVar.b();
                    this.f9271e.a(new c.a.p0.a.u.h.b(b2, c.a.p0.a.h2.c.d.f(b2)));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0567a(a aVar, String str) {
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
            this.f9270d = aVar;
        }

        @Override // c.a.p0.a.u.c.c
        @NonNull
        public c.a.p0.a.u.h.b d(@NonNull JSONObject jSONObject, @NonNull c.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
                e a0 = e.a0();
                if (a0 == null) {
                    return new c.a.p0.a.u.h.b(1001, "null swan runtime");
                }
                a0.d0().g(c.a.p0.a.d2.d.J(), "mapp_i_get_bduss", new C0568a(this, bVar));
                return c.a.p0.a.u.h.b.f();
            }
            return (c.a.p0.a.u.h.b) invokeLL.objValue;
        }

        @Override // c.a.p0.a.u.c.c
        @NonNull
        public c.a.p0.a.u.h.b e(@NonNull JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) ? this.f9270d.z() : (c.a.p0.a.u.h.b) invokeL.objValue;
        }

        @Override // c.a.p0.a.u.c.c
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? c.a.p0.a.d2.d.J().D() && c.a.p0.a.d2.d.J().r().d0().f("mapp_i_get_bduss") : invokeV.booleanValue;
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

    @Override // c.a.p0.a.u.c.d
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "PrivateAccount" : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "GetBdussApi" : (String) invokeV.objValue;
    }

    @SuppressLint({"SwanBindApiNote"})
    public c.a.p0.a.u.h.b y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getBduss", false);
            return m(str, new C0567a(this, "getBDUSS"));
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    @NonNull
    public final c.a.p0.a.u.h.b z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String i2 = c.a.p0.b.l.a.i(c.a.p0.a.d2.d.J());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("bduss", i2);
                return new c.a.p0.a.u.h.b(0, jSONObject);
            } catch (JSONException e2) {
                p("#getBdussResult json put data fail", e2, false);
                return new c.a.p0.a.u.h.b(1001, "json put data fail");
            }
        }
        return (c.a.p0.a.u.h.b) invokeV.objValue;
    }
}
