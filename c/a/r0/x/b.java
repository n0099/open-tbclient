package c.a.r0.x;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import c.a.r0.x.c.c;
import c.a.r0.x.c.d;
import c.a.r0.x.c.e;
import c.a.r0.x.c.f;
import c.a.r0.x.c.g;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f11925c;
    public transient /* synthetic */ FieldHolder $fh;
    public final a<String> a;

    /* renamed from: b  reason: collision with root package name */
    public String f11926b;

    @SuppressLint({"BDThrowableCheck"})
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
        this.a = aVar;
        if (context == null) {
            return;
        }
        aVar.a(new c(context));
        this.a.a(new e(context));
        this.a.a(new d(context));
        this.a.a(new g(context));
        this.a.a(new c.a.r0.x.c.a(context));
        this.a.a(new f(context));
    }

    public static b b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f11925c == null) {
                synchronized (b.class) {
                    if (f11925c == null) {
                        f11925c = new b(context);
                    }
                }
            }
            return f11925c;
        }
        return (b) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f11926b)) {
                synchronized (this) {
                    if (TextUtils.isEmpty(this.f11926b)) {
                        String b2 = this.a.b();
                        this.f11926b = b2;
                        this.a.d(b2);
                    }
                }
            }
            return this.f11926b;
        }
        return (String) invokeV.objValue;
    }
}
