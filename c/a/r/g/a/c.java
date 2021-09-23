package c.a.r.g.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f15396b = 5;

    /* renamed from: c  reason: collision with root package name */
    public static int f15397c = 40;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.helios.common.cc.a f15398a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1844765967, "Lc/a/r/g/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1844765967, "Lc/a/r/g/a/c;");
        }
    }

    public c() {
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
        com.baidu.helios.common.cc.a aVar = new com.baidu.helios.common.cc.a(f15397c);
        this.f15398a = aVar;
        aVar.a(0, f15397c, true);
    }

    public void a(com.baidu.helios.common.cc.a aVar, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048576, this, aVar, i2, i3, i4) == null) {
            com.baidu.helios.common.cc.a d2 = this.f15398a.d(i2, i2 + i3);
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        d2.e(aVar);
                    } else if (i4 == 3) {
                        d2.c(aVar);
                    }
                }
                d2.d(aVar);
            } else {
                d2.b(aVar);
            }
            for (int i5 = 0; i5 < i3; i5++) {
                this.f15398a.a(i2 + i5, d2.d(i5));
            }
        }
    }

    public byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f15398a.a() : (byte[]) invokeV.objValue;
    }
}
