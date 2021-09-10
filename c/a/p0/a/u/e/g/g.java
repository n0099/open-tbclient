package c.a.p0.a.u.e.g;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g extends c.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8898e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f8899f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f8900g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f8901h;

        public a(g gVar, String str, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8901h = gVar;
            this.f8898e = str;
            this.f8899f = z;
            this.f8900g = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.a.o2.b.a t = g.t();
                if (t == null) {
                    c.a.p0.a.e0.d.b("Api-TabBar", "tabBarViewController is null");
                    this.f8901h.d(this.f8898e, new c.a.p0.a.u.h.b(1001));
                    return;
                }
                if (this.f8899f) {
                    j2 = t.r(this.f8900g);
                } else {
                    j2 = t.j(this.f8900g);
                }
                if (!j2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f8899f ? "open" : IntentConfig.CLOSE);
                    sb.append("bottom bar fail");
                    c.a.p0.a.e0.d.b("Api-TabBar", sb.toString());
                    this.f8901h.d(this.f8898e, new c.a.p0.a.u.h.b(1001));
                }
                this.f8901h.d(this.f8898e, new c.a.p0.a.u.h.b(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NonNull c.a.p0.a.u.c.b bVar) {
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

    public static c.a.p0.a.o2.b.a t() {
        InterceptResult invokeV;
        c.a.p0.a.h0.g.f l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            c.a.p0.a.h0.g.g W = c.a.p0.a.g1.f.V().W();
            if (W == null || (l = W.l()) == null) {
                return null;
            }
            return l.g3();
        }
        return (c.a.p0.a.o2.b.a) invokeV.objValue;
    }

    public static boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            c.a.p0.a.h0.g.g W = c.a.p0.a.g1.f.V().W();
            return W == null || W.o() == null || !W.o().X1();
        }
        return invokeV.booleanValue;
    }

    public c.a.p0.a.u.h.b r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            boolean z = c.a.p0.a.u.c.d.f8727c;
            return u(str, false);
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public c.a.p0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (c.a.p0.a.u.c.d.f8727c) {
                String str2 = "handle: " + str;
            }
            Pair<c.a.p0.a.u.h.b, JSONObject> b2 = c.a.p0.a.u.i.b.b("Api-TabBar", str);
            c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (c.a.p0.a.u.c.d.f8727c) {
                    c.a.p0.a.e0.d.b("Api-TabBar", "parse fail");
                }
                return bVar;
            }
            int optInt = ((JSONObject) b2.second).optInt("index");
            if (v()) {
                c.a.p0.a.e0.d.b("Api-TabBar", "fail not TabBar page");
                return new c.a.p0.a.u.h.b(1001, "fail not TabBar page");
            }
            c.a.p0.a.o2.b.a t = t();
            if (t == null) {
                c.a.p0.a.e0.d.b("Api-TabBar", "tabBarViewController is null");
                return new c.a.p0.a.u.h.b(1001, "tabBarViewController is null");
            } else if (!t.k(optInt)) {
                c.a.p0.a.e0.d.b("Api-TabBar", "close red dot fail");
                return new c.a.p0.a.u.h.b(1001, "close red dot fail");
            } else {
                return new c.a.p0.a.u.h.b(0);
            }
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final c.a.p0.a.u.h.b u(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) {
            if (v()) {
                c.a.p0.a.e0.d.b("Api-TabBar", "fail not TabBar page");
                return new c.a.p0.a.u.h.b(1001, "fail not TabBar page");
            }
            Pair<c.a.p0.a.u.h.b, JSONObject> b2 = c.a.p0.a.u.i.b.b("Api-TabBar", str);
            c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (c.a.p0.a.u.c.d.f8727c) {
                    c.a.p0.a.e0.d.b("Api-TabBar", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c.a.p0.a.e0.d.b("Api-TabBar", "callback is null");
                return new c.a.p0.a.u.h.b(1001, "callback is null");
            }
            q0.b0(new a(this, optString, z, jSONObject.optBoolean("animation")));
            return new c.a.p0.a.u.h.b(0);
        }
        return (c.a.p0.a.u.h.b) invokeLZ.objValue;
    }

    public c.a.p0.a.u.h.b w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            boolean z = c.a.p0.a.u.c.d.f8727c;
            return u(str, true);
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }

    public c.a.p0.a.u.h.b x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (c.a.p0.a.u.c.d.f8727c) {
                String str2 = "handle: " + str;
            }
            Pair<c.a.p0.a.u.h.b, JSONObject> b2 = c.a.p0.a.u.i.b.b("Api-TabBar", str);
            c.a.p0.a.u.h.b bVar = (c.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (c.a.p0.a.u.c.d.f8727c) {
                    c.a.p0.a.e0.d.b("Api-TabBar", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            if (v()) {
                c.a.p0.a.e0.d.b("Api-TabBar", "fail not TabBar page");
                return new c.a.p0.a.u.h.b(1001, "fail not TabBar page");
            }
            c.a.p0.a.o2.b.a t = t();
            if (t == null) {
                c.a.p0.a.e0.d.b("Api-TabBar", "tabBarViewController is null");
                return new c.a.p0.a.u.h.b(1001, "tabBarViewController is null");
            } else if (!t.x(jSONObject.optInt("index"), jSONObject.optString("text"), jSONObject.optString("iconPath"), jSONObject.optString("selectedIconPath"))) {
                c.a.p0.a.e0.d.b("Api-TabBar", "set tab bar item fail");
                return new c.a.p0.a.u.h.b(1001, "set tab bar item fail");
            } else {
                return new c.a.p0.a.u.h.b(0);
            }
        }
        return (c.a.p0.a.u.h.b) invokeL.objValue;
    }
}
