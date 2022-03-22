package c.a.n0.a.x.q.d;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d implements c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f7418c;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.n0.a.x.q.c.a f7419b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1307974356, "Lc/a/n0/a/x/q/d/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1307974356, "Lc/a/n0/a/x/q/d/d;");
                return;
            }
        }
        f7418c = c.a.n0.a.a.a;
    }

    public d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = i >= 20 ? Math.min(i, 300) : 20;
        this.f7419b = new c.a.n0.a.x.q.c.d(10);
    }

    @Override // c.a.n0.a.x.q.d.c
    public c.a.n0.a.x.q.c.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f7419b : (c.a.n0.a.x.q.c.a) invokeV.objValue;
    }

    @Override // c.a.n0.a.x.q.d.c
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.x.q.d.c
    public boolean c(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3)) == null) {
            if (f7418c) {
                Log.d("LocalLruStrategy", "prelink url - " + str3);
            }
            c.a.n0.a.x.q.c.b a = this.f7419b.a(str2, str3);
            if (a == null) {
                if (f7418c) {
                    Log.d("LocalLruStrategy", "url not in LRU, do prelink");
                }
                return true;
            }
            boolean z = System.currentTimeMillis() - a.f7413b >= ((long) (this.a * 1000));
            if (f7418c) {
                Log.d("LocalLruStrategy", "url in LRU, time is out - " + z);
            }
            return z;
        }
        return invokeLLL.booleanValue;
    }
}
