package c.i.b.a.d0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.util.Arrays;
/* loaded from: classes4.dex */
public final class s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f33160a;

    /* renamed from: b  reason: collision with root package name */
    public final Format[] f33161b;

    /* renamed from: c  reason: collision with root package name */
    public int f33162c;

    public s(Format... formatArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {formatArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c.i.b.a.i0.a.f(formatArr.length > 0);
        this.f33161b = formatArr;
        this.f33160a = formatArr.length;
    }

    public Format a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f33161b[i2] : (Format) invokeI.objValue;
    }

    public int b(Format format) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, format)) != null) {
            return invokeL.intValue;
        }
        int i2 = 0;
        while (true) {
            Format[] formatArr = this.f33161b;
            if (i2 >= formatArr.length) {
                return -1;
            }
            if (format == formatArr[i2]) {
                return i2;
            }
            i2++;
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || s.class != obj.getClass()) {
                return false;
            }
            s sVar = (s) obj;
            return this.f33160a == sVar.f33160a && Arrays.equals(this.f33161b, sVar.f33161b);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f33162c == 0) {
                this.f33162c = 527 + Arrays.hashCode(this.f33161b);
            }
            return this.f33162c;
        }
        return invokeV.intValue;
    }
}
