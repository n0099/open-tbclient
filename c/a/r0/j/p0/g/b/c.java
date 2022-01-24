package c.a.r0.j.p0.g.b;

import android.text.TextUtils;
import c.a.r0.a.n2.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final String f11332b = null;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-774795316, "Lc/a/r0/j/p0/g/b/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-774795316, "Lc/a/r0/j/p0/g/b/c;");
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
    }

    public final String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, str3)) == null) ? String.format("%s_%s:%s", str, str2, str3) : (String) invokeLLL.objValue;
    }

    public void b(int i2, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, str2, str3}) == null) {
            String g2 = g(i2);
            String N = c.a.r0.a.d2.e.L() == null ? null : c.a.r0.a.d2.e.L().N();
            c.a.r0.a.n2.s.e eVar = new c.a.r0.a.n2.s.e();
            eVar.f8119b = "click";
            eVar.f8124g = g2;
            eVar.f8122e = str;
            if (str2 != null) {
                eVar.a("target_appkey", str2);
            }
            eVar.a("current_appkey", N);
            if (!TextUtils.isEmpty(str3)) {
                eVar.a("location", str3);
            }
            n.g(eVar);
        }
    }

    public void c(int i2, c.a.r0.j.p0.g.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, aVar) == null) {
            String g2 = g(i2);
            JSONArray f2 = f(aVar);
            c.a.r0.a.n2.s.e eVar = new c.a.r0.a.n2.s.e();
            eVar.f8119b = "show";
            eVar.f8124g = g2;
            if (f2 != null) {
                eVar.a(GameGuideConfigInfo.KEY_GAME_LIST, f2);
            }
            n.g(eVar);
        }
    }

    public void d(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048579, this, i2, str, str2) == null) {
            String g2 = g(i2);
            String a = a(g2, str, str2);
            if (this.a.contains(a)) {
                return;
            }
            String N = c.a.r0.a.d2.e.L() == null ? null : c.a.r0.a.d2.e.L().N();
            c.a.r0.a.n2.s.e eVar = new c.a.r0.a.n2.s.e();
            eVar.f8119b = "click";
            eVar.f8124g = g2;
            eVar.f8122e = str;
            if (str2 != null) {
                eVar.a("target_appkey", str2);
            }
            eVar.a("current_appkey", N);
            n.g(eVar);
            this.a.add(a);
        }
    }

    public void e(int i2, c.a.r0.j.p0.g.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i2, aVar) == null) {
            String g2 = g(i2);
            JSONArray f2 = f(aVar);
            c.a.r0.a.n2.s.e eVar = new c.a.r0.a.n2.s.e();
            eVar.f8119b = "show";
            eVar.f8124g = g2;
            if (f2 != null) {
                eVar.a(GameGuideConfigInfo.KEY_GAME_LIST, f2);
            }
            n.g(eVar);
            this.a.clear();
        }
    }

    public final JSONArray f(c.a.r0.j.p0.g.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            if (aVar == null || aVar.f11341b == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (RecommendItemModel recommendItemModel : aVar.f11341b) {
                jSONArray.put(recommendItemModel.appKey);
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public final String g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return null;
                    }
                    return "popview";
                }
                return "list";
            }
            return "carousel";
        }
        return (String) invokeI.objValue;
    }
}
