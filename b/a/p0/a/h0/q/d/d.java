package b.a.p0.a.h0.q.d;

import b.a.p0.a.k;
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
    public static final boolean f6061c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f6062a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a.p0.a.h0.q.c.a f6063b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2087172273, "Lb/a/p0/a/h0/q/d/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2087172273, "Lb/a/p0/a/h0/q/d/d;");
                return;
            }
        }
        f6061c = k.f6863a;
    }

    public d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f6062a = i2 >= 20 ? Math.min(i2, 300) : 20;
        this.f6063b = new b.a.p0.a.h0.q.c.d(10);
    }

    @Override // b.a.p0.a.h0.q.d.c
    public b.a.p0.a.h0.q.c.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f6063b : (b.a.p0.a.h0.q.c.a) invokeV.objValue;
    }

    @Override // b.a.p0.a.h0.q.d.c
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.h0.q.d.c
    public boolean c(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3)) == null) {
            if (f6061c) {
                String str4 = "prelink url - " + str3;
            }
            b.a.p0.a.h0.q.c.b a2 = this.f6063b.a(str2, str3);
            if (a2 == null) {
                boolean z = f6061c;
                return true;
            }
            boolean z2 = System.currentTimeMillis() - a2.f6052b >= ((long) (this.f6062a * 1000));
            if (f6061c) {
                String str5 = "url in LRU, time is out - " + z2;
            }
            return z2;
        }
        return invokeLLL.booleanValue;
    }
}
