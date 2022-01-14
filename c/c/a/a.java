package c.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public long f27545b;

    public a(boolean z, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Long.valueOf(j2), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27545b = j2;
        this.a = i2;
    }

    public static a b(String str, int i2, int i3) {
        InterceptResult invokeLII;
        long j2;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, str, i2, i3)) == null) {
            if (i2 >= i3) {
                return null;
            }
            long j3 = 0;
            int i5 = i2;
            while (i5 < i3) {
                char charAt = str.charAt(i5);
                if (charAt < '0' || charAt > '9') {
                    if (charAt >= 'A' && charAt <= 'F') {
                        j2 = j3 * 16;
                        i4 = charAt - 'A';
                    } else if (charAt < 'a' || charAt > 'f') {
                        break;
                    } else {
                        j2 = j3 * 16;
                        i4 = charAt - 'a';
                    }
                    j3 = j2 + i4 + 10;
                } else {
                    j3 = (j3 * 16) + (charAt - '0');
                }
                if (j3 > 4294967295L) {
                    return null;
                }
                i5++;
            }
            if (i5 == i2) {
                return null;
            }
            return new a(false, j3, i5);
        }
        return (a) invokeLII.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (int) this.f27545b : invokeV.intValue;
    }
}
