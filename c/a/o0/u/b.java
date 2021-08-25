package c.a.o0.u;

import android.content.Context;
import android.text.TextUtils;
import c.a.o0.u.c.c;
import c.a.o0.u.c.d;
import c.a.o0.u.c.e;
import c.a.o0.u.c.f;
import c.a.o0.u.c.g;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f12360c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a<String> f12361a;

    /* renamed from: b  reason: collision with root package name */
    public String f12362b;

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
        this.f12361a = aVar;
        if (context == null) {
            return;
        }
        aVar.a(new c(context));
        this.f12361a.a(new e(context));
        this.f12361a.a(new d(context));
        this.f12361a.a(new g(context));
        this.f12361a.a(new c.a.o0.u.c.a(context));
        this.f12361a.a(new f(context));
    }

    public static b b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f12360c == null) {
                synchronized (b.class) {
                    if (f12360c == null) {
                        f12360c = new b(context);
                    }
                }
            }
            return f12360c;
        }
        return (b) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f12362b)) {
                synchronized (this) {
                    if (TextUtils.isEmpty(this.f12362b)) {
                        String b2 = this.f12361a.b();
                        this.f12362b = b2;
                        this.f12361a.d(b2);
                    }
                }
            }
            return this.f12362b;
        }
        return (String) invokeV.objValue;
    }
}
