package b.a.p0.a.s.a.i;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.d2.e;
import b.a.p0.a.h2.c.d;
import b.a.p0.a.h2.c.i;
import b.a.p0.a.h2.c.j.b;
import b.a.p0.a.z2.g1.c;
import b.a.p0.a.z2.w;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends b.a.p0.a.u.e.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.s.a.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0399a implements c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8300e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8301f;

        public C0399a(a aVar, String str) {
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
            this.f8301f = aVar;
            this.f8300e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.h(iVar)) {
                    this.f8301f.z(this.f8300e);
                    return;
                }
                int b2 = iVar.b();
                d.f(b2);
                this.f8301f.d(this.f8300e, new b.a.p0.a.u.h.b(b2, d.f(b2)));
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

    @Override // b.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "AllianceAccountApi" : (String) invokeV.objValue;
    }

    public b.a.p0.a.u.h.b y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getUnionBDUSS", false);
            e a0 = e.a0();
            if (a0 == null) {
                return new b.a.p0.a.u.h.b(1001, "swan app is null");
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> s = s(str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new b.a.p0.a.u.h.b(201, "cb is empty");
                }
                a0.d0().g(b.a.p0.a.d2.d.J(), "account_get_union_bduss", new C0399a(this, optString));
                return b.a.p0.a.u.h.b.f();
            }
            return bVar;
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            JSONObject jSONObject = new JSONObject();
            w.f(jSONObject, "bduss", b.a.p0.a.s.a.d.f8288a.a());
            d(str, new b.a.p0.a.u.h.b(0, jSONObject));
        }
    }
}
