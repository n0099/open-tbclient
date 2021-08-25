package c.a.o0.g.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.o0.a.k;
import c.a.o0.a.p.d.f1;
import c.a.o0.g.c.c.f;
import c.a.o0.g.c.c.g;
import c.a.o0.g.c.c.h;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements f1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f10906b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, a> f10907a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(620116626, "Lc/a/o0/g/f/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(620116626, "Lc/a/o0/g/f/b;");
                return;
            }
        }
        f10906b = k.f7049a;
    }

    public b() {
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
        this.f10907a = new HashMap<>();
        c();
    }

    @Override // c.a.o0.a.p.d.f1
    public c.a.o0.a.u.h.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull c.a.o0.a.u0.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, bVar)) == null) ? b(str, jSONObject, bVar) : (c.a.o0.a.u.h.b) invokeLLL.objValue;
    }

    public final c.a.o0.a.u.h.b b(String str, JSONObject jSONObject, c.a.o0.a.u0.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject, bVar)) == null) {
            a aVar = this.f10907a.get(str);
            if (aVar != null) {
                if (f10906b) {
                    String str2 = "action: " + str + " params: " + jSONObject;
                }
                return aVar.a(jSONObject, bVar);
            }
            if (f10906b) {
                String str3 = "action has not found: " + str + ", params: " + jSONObject;
            }
            return new c.a.o0.a.u.h.b(10002, "no such api.");
        }
        return (c.a.o0.a.u.h.b) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d(new c.a.o0.g.e.a());
            d(new c.a.o0.g.e.b());
            d(new c.a.o0.g.c.c.b());
            d(new f());
            d(new c.a.o0.g.c.c.c());
            d(new c.a.o0.g.i.e.a());
            d(new c.a.o0.g.c.c.d());
            d(new c.a.o0.g.g.a());
            d(new c.a.o0.g.i.c.b());
            d(new c.a.o0.g.c.c.a());
            d(new h());
            d(new c.a.o0.g.c.c.e());
            d(new g());
            d(new c.a.o0.g.i.a.a());
            d(new c.a.o0.g.i.d.b());
            d(new c.a.o0.g.i.b.a());
            d(new c.a.o0.g.i.c.a());
            d(new c.a.o0.g.i.b.b());
        }
    }

    public void d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (f10906b && TextUtils.isEmpty(aVar.f10905a)) {
                throw new IllegalArgumentException("action name is null");
            }
            if (f10906b && this.f10907a.containsKey(aVar.f10905a)) {
                throw new IllegalArgumentException("duplicate action: " + aVar);
            }
            this.f10907a.put(aVar.f10905a, aVar);
        }
    }
}
