package c.a.n0.a.k.e.f;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import c.a.n0.a.p2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends c.a.n0.a.k.e.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f5059b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f5060c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ h f5061d;

        public a(h hVar, String str, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, str, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5061d = hVar;
            this.a = str;
            this.f5059b = z;
            this.f5060c = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.a.i2.b.a z = h.z();
                if (z == null) {
                    c.a.n0.a.u.d.c("TabBarApi", "tabBarViewController is null");
                    this.f5061d.d(this.a, new c.a.n0.a.k.h.b(1001));
                    return;
                }
                if (this.f5059b) {
                    j = z.r(this.f5060c);
                } else {
                    j = z.j(this.f5060c);
                }
                if (!j) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f5059b ? "open" : IntentConfig.CLOSE);
                    sb.append("bottom bar fail");
                    c.a.n0.a.u.d.c("TabBarApi", sb.toString());
                    this.f5061d.d(this.a, new c.a.n0.a.k.h.b(1001));
                }
                this.f5061d.d(this.a, new c.a.n0.a.k.h.b(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NonNull c.a.n0.a.k.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.n0.a.k.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            c.a.n0.a.x.g.g V = c.a.n0.a.w0.f.U().V();
            return V == null || V.o() == null || !V.o().c2();
        }
        return invokeV.booleanValue;
    }

    public static c.a.n0.a.i2.b.a z() {
        InterceptResult invokeV;
        c.a.n0.a.x.g.f l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            c.a.n0.a.x.g.g V = c.a.n0.a.w0.f.U().V();
            if (V == null || (l = V.l()) == null) {
                return null;
            }
            return l.t3();
        }
        return (c.a.n0.a.i2.b.a) invokeV.objValue;
    }

    public final c.a.n0.a.k.h.b A(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            if (B()) {
                c.a.n0.a.u.d.c("TabBarApi", "fail not TabBar page");
                return new c.a.n0.a.k.h.b(1001, "fail not TabBar page");
            }
            Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
            c.a.n0.a.k.h.b bVar = (c.a.n0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c.a.n0.a.u.d.c("TabBarApi", "callback is null");
                    return new c.a.n0.a.k.h.b(1001, "callback is null");
                }
                q0.e0(new a(this, optString, z, jSONObject.optBoolean("animation")));
                return c.a.n0.a.k.h.b.f();
            }
            return bVar;
        }
        return (c.a.n0.a.k.h.b) invokeLZ.objValue;
    }

    public c.a.n0.a.k.h.b C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#openTabBar", false);
            return A(str, true);
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    public c.a.n0.a.k.h.b D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#setTabBarItem", false);
            Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
            c.a.n0.a.k.h.b bVar = (c.a.n0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                if (B()) {
                    c.a.n0.a.u.d.c("TabBarApi", "fail not TabBar page");
                    return new c.a.n0.a.k.h.b(1001, "fail not TabBar page");
                }
                c.a.n0.a.i2.b.a z = z();
                if (z == null) {
                    c.a.n0.a.u.d.c("TabBarApi", "tabBarViewController is null");
                    return new c.a.n0.a.k.h.b(1001, "tabBarViewController is null");
                } else if (!z.x(jSONObject.optInt("index"), jSONObject.optString("text"), jSONObject.optString("iconPath"), jSONObject.optString("selectedIconPath"))) {
                    c.a.n0.a.u.d.c("TabBarApi", "set tab bar item fail");
                    return new c.a.n0.a.k.h.b(1001, "set tab bar item fail");
                } else {
                    return c.a.n0.a.k.h.b.f();
                }
            }
            return bVar;
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    @Override // c.a.n0.a.k.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "TabBarApi" : (String) invokeV.objValue;
    }

    public c.a.n0.a.k.h.b x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#closeTabBar", false);
            return A(str, false);
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }

    public c.a.n0.a.k.h.b y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#closeTabBarRedDot", false);
            Pair<c.a.n0.a.k.h.b, JSONObject> s = s(str);
            c.a.n0.a.k.h.b bVar = (c.a.n0.a.k.h.b) s.first;
            if (bVar.isSuccess()) {
                int optInt = ((JSONObject) s.second).optInt("index");
                if (B()) {
                    c.a.n0.a.u.d.c("TabBarApi", "fail not TabBar page");
                    return new c.a.n0.a.k.h.b(1001, "fail not TabBar page");
                }
                c.a.n0.a.i2.b.a z = z();
                if (z == null) {
                    c.a.n0.a.u.d.c("TabBarApi", "tabBarViewController is null");
                    return new c.a.n0.a.k.h.b(1001, "tabBarViewController is null");
                } else if (!z.k(optInt)) {
                    c.a.n0.a.u.d.c("TabBarApi", "close red dot fail");
                    return new c.a.n0.a.k.h.b(1001, "close red dot fail");
                } else {
                    return c.a.n0.a.k.h.b.f();
                }
            }
            return bVar;
        }
        return (c.a.n0.a.k.h.b) invokeL.objValue;
    }
}
