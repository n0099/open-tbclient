package c.a.n0.u;

import android.content.Context;
import android.text.TextUtils;
import c.a.n0.u.c.c;
import c.a.n0.u.c.d;
import c.a.n0.u.c.e;
import c.a.n0.u.c.f;
import c.a.n0.u.c.g;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f12114c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a<String> f12115a;

    /* renamed from: b  reason: collision with root package name */
    public String f12116b;

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a<String> aVar = new a<>();
        this.f12115a = aVar;
        if (context == null) {
            return;
        }
        aVar.a(new c(context));
        this.f12115a.a(new e(context));
        this.f12115a.a(new d(context));
        this.f12115a.a(new g(context));
        this.f12115a.a(new c.a.n0.u.c.a(context));
        this.f12115a.a(new f(context));
    }

    public static b b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f12114c == null) {
                synchronized (b.class) {
                    if (f12114c == null) {
                        f12114c = new b(context);
                    }
                }
            }
            return f12114c;
        }
        return (b) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f12116b)) {
                synchronized (this) {
                    if (TextUtils.isEmpty(this.f12116b)) {
                        String b2 = this.f12115a.b();
                        this.f12116b = b2;
                        this.f12115a.d(b2);
                    }
                }
            }
            return this.f12116b;
        }
        return (String) invokeV.objValue;
    }
}
