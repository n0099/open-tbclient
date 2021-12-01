package c.b.b.q;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long[] a;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new long[]{0};
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            long[] jArr = this.a;
            if (i2 >= jArr.length) {
                long[] jArr2 = new long[i2 + 1];
                System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
                this.a = jArr2;
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Arrays.fill(this.a, 0L);
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            int i3 = i2 >>> 6;
            long[] jArr = this.a;
            if (i3 >= jArr.length) {
                return;
            }
            jArr[i3] = jArr[i3] & (~(1 << (i2 & 63)));
        }
    }

    public boolean d(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dVar)) == null) {
            long[] jArr = this.a;
            long[] jArr2 = dVar.a;
            int length = jArr2.length;
            int length2 = jArr.length;
            for (int i2 = length2; i2 < length; i2++) {
                if (jArr2[i2] != 0) {
                    return false;
                }
            }
            for (int min = Math.min(length2, length) - 1; min >= 0; min--) {
                if ((jArr[min] & jArr2[min]) != jArr2[min]) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            int i3 = i2 >>> 6;
            long[] jArr = this.a;
            return i3 < jArr.length && (jArr[i3] & (1 << (i2 & 63))) != 0;
        }
        return invokeI.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && d.class == obj.getClass()) {
                d dVar = (d) obj;
                long[] jArr = dVar.a;
                int min = Math.min(this.a.length, jArr.length);
                for (int i2 = 0; min > i2; i2++) {
                    if (this.a[i2] != jArr[i2]) {
                        return false;
                    }
                }
                return this.a.length == jArr.length || h() == dVar.h();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean f(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, dVar)) == null) {
            long[] jArr = this.a;
            long[] jArr2 = dVar.a;
            for (int min = Math.min(jArr.length, jArr2.length) - 1; min >= 0; min--) {
                if ((jArr[min] & jArr2[min]) != 0) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            for (long j2 : this.a) {
                if (j2 != 0) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            long[] jArr = this.a;
            for (int length = jArr.length - 1; length >= 0; length--) {
                long j2 = jArr[length];
                if (j2 != 0) {
                    for (int i2 = 63; i2 >= 0; i2--) {
                        if (((1 << (i2 & 63)) & j2) != 0) {
                            return (length << 6) + i2 + 1;
                        }
                    }
                    continue;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int h2 = h() >>> 6;
            int i2 = 0;
            for (int i3 = 0; h2 >= i3; i3++) {
                long[] jArr = this.a;
                i2 = (i2 * 127) + ((int) (jArr[i3] ^ (jArr[i3] >>> 32)));
            }
            return i2;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
        return (r1 << 6) + r15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int i(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048586, this, i2)) != null) {
            return invokeI.intValue;
        }
        long[] jArr = this.a;
        int i4 = i2 >>> 6;
        int length = jArr.length;
        if (i4 >= length) {
            return -1;
        }
        long j2 = jArr[i4];
        if (j2 != 0) {
            i3 = i2 & 63;
            while (i3 < 64) {
                if (((1 << (i3 & 63)) & j2) != 0) {
                    break;
                }
                i3++;
            }
        }
        loop1: while (true) {
            i4++;
            if (i4 >= length) {
                return -1;
            }
            if (i4 != 0) {
                long j3 = jArr[i4];
                if (j3 != 0) {
                    i3 = 0;
                    while (i3 < 64) {
                        if (((1 << (i3 & 63)) & j3) != 0) {
                            break loop1;
                        }
                        i3++;
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
    }

    public void j(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            int min = Math.min(this.a.length, dVar.a.length);
            for (int i2 = 0; min > i2; i2++) {
                long[] jArr = this.a;
                jArr[i2] = jArr[i2] | dVar.a[i2];
            }
            long[] jArr2 = dVar.a;
            if (min < jArr2.length) {
                a(jArr2.length);
                int length = dVar.a.length;
                while (length > min) {
                    this.a[min] = dVar.a[min];
                    min++;
                }
            }
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            int i3 = i2 >>> 6;
            a(i3);
            long[] jArr = this.a;
            jArr[i3] = jArr[i3] | (1 << (i2 & 63));
        }
    }
}
