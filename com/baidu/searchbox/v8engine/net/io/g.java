package com.baidu.searchbox.v8engine.net.io;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes2.dex */
public final class g extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final transient byte[][] f;
    public final transient int[] g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(a aVar, int i) {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((byte[]) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        j.a(aVar.b, 0L, i);
        e eVar = aVar.a;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i) {
            int i7 = eVar.c;
            int i8 = eVar.b;
            if (i7 != i8) {
                i5 += i7 - i8;
                i6++;
                eVar = eVar.f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f = new byte[i6];
        this.g = new int[i6 * 2];
        e eVar2 = aVar.a;
        int i9 = 0;
        while (i4 < i) {
            this.f[i9] = eVar2.a;
            i4 += eVar2.c - eVar2.b;
            if (i4 > i) {
                i4 = i;
            }
            int[] iArr = this.g;
            iArr[i9] = i4;
            iArr[this.f.length + i9] = eVar2.b;
            eVar2.d = true;
            i9++;
            eVar2 = eVar2.f;
        }
    }

    private int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
            int binarySearch = Arrays.binarySearch(this.g, 0, this.f.length, i + 1);
            if (binarySearch < 0) {
                return ~binarySearch;
            }
            return binarySearch;
        }
        return invokeI.intValue;
    }

    private d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            return new d(d());
        }
        return (d) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return e().a();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return e().b();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g[this.f.length - 1];
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return e().toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public byte a(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            j.a(this.g[this.f.length - 1], i, 1L);
            int b = b(i);
            if (b == 0) {
                i2 = 0;
            } else {
                i2 = this.g[b - 1];
            }
            int[] iArr = this.g;
            byte[][] bArr = this.f;
            return bArr[b][(i - i2) + iArr[bArr.length + b]];
        }
        return invokeI.byteValue;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof d) {
                d dVar = (d) obj;
                if (dVar.c() == c() && a(0, dVar, 0, c())) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public d a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
            return e().a(i, i2);
        }
        return (d) invokeII.objValue;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public boolean a(int i, d dVar, int i2, int i3) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), dVar, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (i < 0 || i > c() - i3) {
                return false;
            }
            int b = b(i);
            while (i3 > 0) {
                if (b == 0) {
                    i4 = 0;
                } else {
                    i4 = this.g[b - 1];
                }
                int min = Math.min(i3, ((this.g[b] - i4) + i4) - i);
                int[] iArr = this.g;
                byte[][] bArr = this.f;
                if (!dVar.a(i2, bArr[b], (i - i4) + iArr[bArr.length + b], min)) {
                    return false;
                }
                i += min;
                i2 += min;
                i3 -= min;
                b++;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public boolean a(int i, byte[] bArr, int i2, int i3) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), bArr, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (i < 0 || i > c() - i3 || i2 < 0 || i2 > bArr.length - i3) {
                return false;
            }
            int b = b(i);
            while (i3 > 0) {
                if (b == 0) {
                    i4 = 0;
                } else {
                    i4 = this.g[b - 1];
                }
                int min = Math.min(i3, ((this.g[b] - i4) + i4) - i);
                int[] iArr = this.g;
                byte[][] bArr2 = this.f;
                if (!j.a(bArr2[b], (i - i4) + iArr[bArr2.length + b], bArr, i2, min)) {
                    return false;
                }
                i += min;
                i2 += min;
                i3 -= min;
                b++;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int[] iArr = this.g;
            byte[][] bArr = this.f;
            byte[] bArr2 = new byte[iArr[bArr.length - 1]];
            int length = bArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int[] iArr2 = this.g;
                int i3 = iArr2[length + i];
                int i4 = iArr2[i];
                System.arraycopy(this.f[i], i3, bArr2, i2, i4 - i2);
                i++;
                i2 = i4;
            }
            return bArr2;
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i = this.d;
            if (i != 0) {
                return i;
            }
            int length = this.f.length;
            int i2 = 0;
            int i3 = 0;
            int i4 = 1;
            while (i2 < length) {
                byte[] bArr = this.f[i2];
                int[] iArr = this.g;
                int i5 = iArr[length + i2];
                int i6 = iArr[i2];
                int i7 = (i6 - i3) + i5;
                while (i5 < i7) {
                    i4 = (i4 * 31) + bArr[i5];
                    i5++;
                }
                i2++;
                i3 = i6;
            }
            this.d = i4;
            return i4;
        }
        return invokeV.intValue;
    }
}
