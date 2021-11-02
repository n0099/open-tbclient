package b.a.p0.a.u.e.g;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8164e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f8165f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f8166g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f8167h;

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
            this.f8167h = gVar;
            this.f8164e = str;
            this.f8165f = z;
            this.f8166g = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.o2.b.a s = g.s();
                if (s == null) {
                    b.a.p0.a.e0.d.b("Api-TabBar", "tabBarViewController is null");
                    this.f8167h.d(this.f8164e, new b.a.p0.a.u.h.b(1001));
                    return;
                }
                if (this.f8165f) {
                    j = s.r(this.f8166g);
                } else {
                    j = s.j(this.f8166g);
                }
                if (!j) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f8165f ? "open" : IntentConfig.CLOSE);
                    sb.append("bottom bar fail");
                    b.a.p0.a.e0.d.b("Api-TabBar", sb.toString());
                    this.f8167h.d(this.f8164e, new b.a.p0.a.u.h.b(1001));
                }
                this.f8167h.d(this.f8164e, new b.a.p0.a.u.h.b(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NonNull b.a.p0.a.u.c.b bVar) {
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

    public static b.a.p0.a.o2.b.a s() {
        InterceptResult invokeV;
        b.a.p0.a.h0.g.f l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            b.a.p0.a.h0.g.g U = b.a.p0.a.g1.f.T().U();
            if (U == null || (l = U.l()) == null) {
                return null;
            }
            return l.c3();
        }
        return (b.a.p0.a.o2.b.a) invokeV.objValue;
    }

    public static boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            b.a.p0.a.h0.g.g U = b.a.p0.a.g1.f.T().U();
            return U == null || U.o() == null || !U.o().T1();
        }
        return invokeV.booleanValue;
    }

    public b.a.p0.a.u.h.b q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            boolean z = b.a.p0.a.u.c.d.f8000c;
            return t(str, false);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (b.a.p0.a.u.c.d.f8000c) {
                String str2 = "handle: " + str;
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-TabBar", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-TabBar", "parse fail");
                }
                return bVar;
            }
            int optInt = ((JSONObject) b2.second).optInt("index");
            if (u()) {
                b.a.p0.a.e0.d.b("Api-TabBar", "fail not TabBar page");
                return new b.a.p0.a.u.h.b(1001, "fail not TabBar page");
            }
            b.a.p0.a.o2.b.a s = s();
            if (s == null) {
                b.a.p0.a.e0.d.b("Api-TabBar", "tabBarViewController is null");
                return new b.a.p0.a.u.h.b(1001, "tabBarViewController is null");
            } else if (!s.k(optInt)) {
                b.a.p0.a.e0.d.b("Api-TabBar", "close red dot fail");
                return new b.a.p0.a.u.h.b(1001, "close red dot fail");
            } else {
                return new b.a.p0.a.u.h.b(0);
            }
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public final b.a.p0.a.u.h.b t(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) {
            if (u()) {
                b.a.p0.a.e0.d.b("Api-TabBar", "fail not TabBar page");
                return new b.a.p0.a.u.h.b(1001, "fail not TabBar page");
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-TabBar", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-TabBar", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                b.a.p0.a.e0.d.b("Api-TabBar", "callback is null");
                return new b.a.p0.a.u.h.b(1001, "callback is null");
            }
            q0.b0(new a(this, optString, z, jSONObject.optBoolean("animation")));
            return new b.a.p0.a.u.h.b(0);
        }
        return (b.a.p0.a.u.h.b) invokeLZ.objValue;
    }

    public b.a.p0.a.u.h.b v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            boolean z = b.a.p0.a.u.c.d.f8000c;
            return t(str, true);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (b.a.p0.a.u.c.d.f8000c) {
                String str2 = "handle: " + str;
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-TabBar", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-TabBar", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            if (u()) {
                b.a.p0.a.e0.d.b("Api-TabBar", "fail not TabBar page");
                return new b.a.p0.a.u.h.b(1001, "fail not TabBar page");
            }
            b.a.p0.a.o2.b.a s = s();
            if (s == null) {
                b.a.p0.a.e0.d.b("Api-TabBar", "tabBarViewController is null");
                return new b.a.p0.a.u.h.b(1001, "tabBarViewController is null");
            } else if (!s.x(jSONObject.optInt("index"), jSONObject.optString("text"), jSONObject.optString("iconPath"), jSONObject.optString("selectedIconPath"))) {
                b.a.p0.a.e0.d.b("Api-TabBar", "set tab bar item fail");
                return new b.a.p0.a.u.h.b(1001, "set tab bar item fail");
            } else {
                return new b.a.p0.a.u.h.b(0);
            }
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
