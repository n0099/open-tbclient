package c.a.m.h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f4361b = 5;

    /* renamed from: c  reason: collision with root package name */
    public static int f4362c = 40;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.cesium.i.b a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1271291226, "Lc/a/m/h/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1271291226, "Lc/a/m/h/d;");
        }
    }

    public d() {
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
        com.baidu.cesium.i.b bVar = new com.baidu.cesium.i.b(f4362c);
        this.a = bVar;
        bVar.a(0, f4362c, true);
    }

    public void a(com.baidu.cesium.i.b bVar, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048576, this, bVar, i2, i3, i4) == null) {
            com.baidu.cesium.i.b d2 = this.a.d(i2, i2 + i3);
            if (i4 == 0) {
                d2.a(bVar);
            } else if (i4 == 2) {
                d2.b(bVar);
            } else if (i4 != 3) {
                d2.e(bVar);
            } else {
                d2.d(bVar);
            }
            for (int i5 = 0; i5 < i3; i5++) {
                this.a.a(i2 + i5, d2.e(i5));
            }
        }
    }

    public byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.h() : (byte[]) invokeV.objValue;
    }
}
