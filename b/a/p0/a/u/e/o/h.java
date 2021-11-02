package b.a.p0.a.u.e.o;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.e2.c.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8353e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h f8354f;

        public a(h hVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8354f = hVar;
            this.f8353e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.e2.c.d.h(iVar)) {
                    boolean a2 = b.a.p0.u.d.c.a(this.f8354f.getContext(), "android.permission.READ_CONTACTS");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("isAuthorized", a2);
                        this.f8354f.d(this.f8353e, new b.a.p0.a.u.h.b(0, jSONObject));
                        this.f8354f.t(a2);
                        return;
                    } catch (JSONException e2) {
                        if (b.a.p0.a.u.c.d.f8000c) {
                            e2.printStackTrace();
                        }
                        this.f8354f.d(this.f8353e, new b.a.p0.a.u.h.b(1001));
                        return;
                    }
                }
                int b2 = iVar.b();
                this.f8354f.d(this.f8353e, new b.a.p0.a.u.h.b(b2, b.a.p0.a.e2.c.d.f(b2)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NonNull b.a.p0.a.u.c.b bVar) {
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

    public b.a.p0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-Base", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (bVar.isSuccess() && (obj = b2.second) != null) {
                String optString = ((JSONObject) obj).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new b.a.p0.a.u.h.b(201, "cb is empty");
                }
                b.a.p0.a.a2.e P = b.a.p0.a.a2.e.P();
                if (P == null) {
                    return new b.a.p0.a.u.h.b(201);
                }
                P.S().g(getContext(), "scope_phone_contact_authorize", new a(this, optString));
                return new b.a.p0.a.u.h.b(0);
            }
            b.a.p0.a.e0.d.b("Api-Base", "parse fail");
            return bVar;
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            b.a.p0.a.j2.p.f fVar = new b.a.p0.a.j2.p.f();
            fVar.f6387e = String.valueOf(z);
            fVar.a("appid", b.a.p0.a.a2.d.g().getAppId());
            fVar.a("appname", b.a.p0.a.a2.d.g().r().N());
            b.a.p0.a.j2.k.u("1717", fVar);
        }
    }
}
