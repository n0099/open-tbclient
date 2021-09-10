package c.a.p0.g.i.c;

import android.content.Intent;
import androidx.annotation.NonNull;
import c.a.p0.a.a2.e;
import c.a.p0.a.k;
import c.a.p0.a.v2.a0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends c.a.p0.g.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f10948c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1515548157, "Lc/a/p0/g/i/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1515548157, "Lc/a/p0/g/i/c/a;");
                return;
            }
        }
        f10948c = k.f7077a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super("StartAppUsagePage");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.g.f.a
    public c.a.p0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull c.a.p0.a.u0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
            e Q = e.Q();
            if (Q != null && Q.x() != null) {
                try {
                    Q.x().startActivity(new Intent("android.settings.USAGE_ACCESS_SETTINGS"));
                } catch (Exception e2) {
                    if (f10948c) {
                        e2.printStackTrace();
                    }
                    a0.f(Q.x());
                }
                bVar.a(null);
            } else {
                bVar.onFail(100, "swan or activity is null");
                boolean z = f10948c;
            }
            return null;
        }
        return (c.a.p0.a.u.h.b) invokeLL.objValue;
    }
}
