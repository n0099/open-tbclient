package c.a.n0.i.d;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import c.a.n0.a.f.d.l1;
import c.a.n0.i.a.c.f;
import c.a.n0.i.a.c.g;
import c.a.n0.i.a.c.h;
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
/* loaded from: classes2.dex */
public class b implements l1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f8549b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, a> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1810197487, "Lc/a/n0/i/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1810197487, "Lc/a/n0/i/d/b;");
                return;
            }
        }
        f8549b = c.a.n0.a.a.a;
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        c();
    }

    @Override // c.a.n0.a.f.d.l1
    public c.a.n0.a.k.h.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull c.a.n0.a.k0.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, bVar)) == null) ? b(str, jSONObject, bVar) : (c.a.n0.a.k.h.b) invokeLLL.objValue;
    }

    public final c.a.n0.a.k.h.b b(String str, JSONObject jSONObject, c.a.n0.a.k0.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject, bVar)) == null) {
            a aVar = this.a.get(str);
            if (aVar != null) {
                if (f8549b) {
                    Log.i("GameCenterDispatcher", "action: " + str + " params: " + jSONObject);
                }
                return aVar.a(jSONObject, bVar);
            }
            if (f8549b) {
                Log.i("GameCenterDispatcher", "action has not found: " + str + ", params: " + jSONObject);
            }
            return new c.a.n0.a.k.h.b(10002, "no such api.");
        }
        return (c.a.n0.a.k.h.b) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d(new c.a.n0.i.c.a());
            d(new c.a.n0.i.c.b());
            d(new c.a.n0.i.a.c.b());
            d(new f());
            d(new c.a.n0.i.a.c.c());
            d(new c.a.n0.i.g.e.a());
            d(new c.a.n0.i.a.c.d());
            d(new c.a.n0.i.e.a());
            d(new c.a.n0.i.g.c.b());
            d(new c.a.n0.i.a.c.a());
            d(new h());
            d(new c.a.n0.i.a.c.e());
            d(new g());
            d(new c.a.n0.i.g.a.a());
            d(new c.a.n0.i.g.d.b());
            d(new c.a.n0.i.g.b.a());
            d(new c.a.n0.i.g.c.a());
            d(new c.a.n0.i.g.b.b());
        }
    }

    public void d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (f8549b && TextUtils.isEmpty(aVar.a)) {
                throw new IllegalArgumentException("action name is null");
            }
            if (f8549b && this.a.containsKey(aVar.a)) {
                throw new IllegalArgumentException("duplicate action: " + aVar);
            }
            this.a.put(aVar.a, aVar);
        }
    }
}
