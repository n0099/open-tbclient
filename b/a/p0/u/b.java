package b.a.p0.u;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.u.c.c;
import b.a.p0.u.c.d;
import b.a.p0.u.c.e;
import b.a.p0.u.c.f;
import b.a.p0.u.c.g;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f11572c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a<String> f11573a;

    /* renamed from: b  reason: collision with root package name */
    public String f11574b;

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
        this.f11573a = aVar;
        if (context == null) {
            return;
        }
        aVar.a(new c(context));
        this.f11573a.a(new e(context));
        this.f11573a.a(new d(context));
        this.f11573a.a(new g(context));
        this.f11573a.a(new b.a.p0.u.c.a(context));
        this.f11573a.a(new f(context));
    }

    public static b b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f11572c == null) {
                synchronized (b.class) {
                    if (f11572c == null) {
                        f11572c = new b(context);
                    }
                }
            }
            return f11572c;
        }
        return (b) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f11574b)) {
                synchronized (this) {
                    if (TextUtils.isEmpty(this.f11574b)) {
                        String b2 = this.f11573a.b();
                        this.f11574b = b2;
                        this.f11573a.d(b2);
                    }
                }
            }
            return this.f11574b;
        }
        return (String) invokeV.objValue;
    }
}
