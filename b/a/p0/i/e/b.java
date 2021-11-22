package b.a.p0.i.e;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.a.k;
import b.a.p0.a.p.d.l1;
import b.a.p0.i.b.c.f;
import b.a.p0.i.b.c.g;
import b.a.p0.i.b.c.h;
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
/* loaded from: classes4.dex */
public class b implements l1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f10817b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, a> f10818a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-836706319, "Lb/a/p0/i/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-836706319, "Lb/a/p0/i/e/b;");
                return;
            }
        }
        f10817b = k.f6863a;
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
        this.f10818a = new HashMap<>();
        c();
    }

    @Override // b.a.p0.a.p.d.l1
    public b.a.p0.a.u.h.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull b.a.p0.a.u0.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, bVar)) == null) ? b(str, jSONObject, bVar) : (b.a.p0.a.u.h.b) invokeLLL.objValue;
    }

    public final b.a.p0.a.u.h.b b(String str, JSONObject jSONObject, b.a.p0.a.u0.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject, bVar)) == null) {
            a aVar = this.f10818a.get(str);
            if (aVar != null) {
                if (f10817b) {
                    String str2 = "action: " + str + " params: " + jSONObject;
                }
                return aVar.a(jSONObject, bVar);
            }
            if (f10817b) {
                String str3 = "action has not found: " + str + ", params: " + jSONObject;
            }
            return new b.a.p0.a.u.h.b(10002, "no such api.");
        }
        return (b.a.p0.a.u.h.b) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d(new b.a.p0.i.d.a());
            d(new b.a.p0.i.d.b());
            d(new b.a.p0.i.b.c.b());
            d(new f());
            d(new b.a.p0.i.b.c.c());
            d(new b.a.p0.i.h.e.a());
            d(new b.a.p0.i.b.c.d());
            d(new b.a.p0.i.f.a());
            d(new b.a.p0.i.h.c.b());
            d(new b.a.p0.i.b.c.a());
            d(new h());
            d(new b.a.p0.i.b.c.e());
            d(new g());
            d(new b.a.p0.i.h.a.a());
            d(new b.a.p0.i.h.d.b());
            d(new b.a.p0.i.h.b.a());
            d(new b.a.p0.i.h.c.a());
            d(new b.a.p0.i.h.b.b());
        }
    }

    public void d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            if (f10817b && TextUtils.isEmpty(aVar.f10816a)) {
                throw new IllegalArgumentException("action name is null");
            }
            if (f10817b && this.f10818a.containsKey(aVar.f10816a)) {
                throw new IllegalArgumentException("duplicate action: " + aVar);
            }
            this.f10818a.put(aVar.f10816a, aVar);
        }
    }
}
