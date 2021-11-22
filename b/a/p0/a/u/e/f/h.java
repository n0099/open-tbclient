package b.a.p0.a.u.e.f;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import b.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends b.a.p0.a.u.e.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8636e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f8637f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f8638g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ h f8639h;

        public a(h hVar, String str, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, str, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8639h = hVar;
            this.f8636e = str;
            this.f8637f = z;
            this.f8638g = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.a.s2.b.a z = h.z();
                if (z == null) {
                    b.a.p0.a.e0.d.c("TabBarApi", "tabBarViewController is null");
                    this.f8639h.d(this.f8636e, new b.a.p0.a.u.h.b(1001));
                    return;
                }
                if (this.f8637f) {
                    j = z.r(this.f8638g);
                } else {
                    j = z.j(this.f8638g);
                }
                if (!j) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f8637f ? "open" : IntentConfig.CLOSE);
                    sb.append("bottom bar fail");
                    b.a.p0.a.e0.d.c("TabBarApi", sb.toString());
                    this.f8639h.d(this.f8636e, new b.a.p0.a.u.h.b(1001));
                }
                this.f8639h.d(this.f8636e, new b.a.p0.a.u.h.b(0));
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

    public static boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            b.a.p0.a.h0.g.g V = b.a.p0.a.g1.f.U().V();
            return V == null || V.o() == null || !V.o().b2();
        }
        return invokeV.booleanValue;
    }

    public static b.a.p0.a.s2.b.a z() {
        InterceptResult invokeV;
        b.a.p0.a.h0.g.f l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            b.a.p0.a.h0.g.g V = b.a.p0.a.g1.f.U().V();
            if (V == null || (l = V.l()) == null) {
                return null;
            }
            return l.s3();
        }
        return (b.a.p0.a.s2.b.a) invokeV.objValue;
    }

    public final b.a.p0.a.u.h.b A(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            if (B()) {
                b.a.p0.a.e0.d.c("TabBarApi", "fail not TabBar page");
                return new b.a.p0.a.u.h.b(1001, "fail not TabBar page");
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> s = s(str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    b.a.p0.a.e0.d.c("TabBarApi", "callback is null");
                    return new b.a.p0.a.u.h.b(1001, "callback is null");
                }
                q0.e0(new a(this, optString, z, jSONObject.optBoolean("animation")));
                return b.a.p0.a.u.h.b.f();
            }
            return bVar;
        }
        return (b.a.p0.a.u.h.b) invokeLZ.objValue;
    }

    public b.a.p0.a.u.h.b C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#openTabBar", false);
            return A(str, true);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#setTabBarItem", false);
            Pair<b.a.p0.a.u.h.b, JSONObject> s = s(str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                if (B()) {
                    b.a.p0.a.e0.d.c("TabBarApi", "fail not TabBar page");
                    return new b.a.p0.a.u.h.b(1001, "fail not TabBar page");
                }
                b.a.p0.a.s2.b.a z = z();
                if (z == null) {
                    b.a.p0.a.e0.d.c("TabBarApi", "tabBarViewController is null");
                    return new b.a.p0.a.u.h.b(1001, "tabBarViewController is null");
                } else if (!z.x(jSONObject.optInt("index"), jSONObject.optString("text"), jSONObject.optString("iconPath"), jSONObject.optString("selectedIconPath"))) {
                    b.a.p0.a.e0.d.c("TabBarApi", "set tab bar item fail");
                    return new b.a.p0.a.u.h.b(1001, "set tab bar item fail");
                } else {
                    return b.a.p0.a.u.h.b.f();
                }
            }
            return bVar;
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    @Override // b.a.p0.a.u.c.d
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "TabBarApi" : (String) invokeV.objValue;
    }

    public b.a.p0.a.u.h.b x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#closeTabBar", false);
            return A(str, false);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#closeTabBarRedDot", false);
            Pair<b.a.p0.a.u.h.b, JSONObject> s = s(str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) s.first;
            if (bVar.isSuccess()) {
                int optInt = ((JSONObject) s.second).optInt("index");
                if (B()) {
                    b.a.p0.a.e0.d.c("TabBarApi", "fail not TabBar page");
                    return new b.a.p0.a.u.h.b(1001, "fail not TabBar page");
                }
                b.a.p0.a.s2.b.a z = z();
                if (z == null) {
                    b.a.p0.a.e0.d.c("TabBarApi", "tabBarViewController is null");
                    return new b.a.p0.a.u.h.b(1001, "tabBarViewController is null");
                } else if (!z.k(optInt)) {
                    b.a.p0.a.e0.d.c("TabBarApi", "close red dot fail");
                    return new b.a.p0.a.u.h.b(1001, "close red dot fail");
                } else {
                    return b.a.p0.a.u.h.b.f();
                }
            }
            return bVar;
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
