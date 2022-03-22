package c.a.w0.e;

import android.content.Context;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f21952b = "UnionIDFactory";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f21953c;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.w0.e.f.c a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-492672559, "Lc/a/w0/e/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-492672559, "Lc/a/w0/e/d;");
                return;
            }
        }
        f21953c = a.e();
    }

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int a = b.a();
        if (f21953c) {
            String str = f21952b;
            Log.e(str, "UnionIDFactory manufacturer:" + a);
        }
        if (a == 10001) {
            this.a = new c.a.w0.e.g.a(context);
        } else if (a != 10002) {
            this.a = new c.a.w0.e.g.b(context);
        } else {
            if (f21953c) {
                Log.e(f21952b, "UnionIDFactory XMUnionID");
            }
            this.a = new c.a.w0.e.g.c(context);
        }
    }

    public c.a.w0.e.f.c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (c.a.w0.e.f.c) invokeV.objValue;
    }
}
