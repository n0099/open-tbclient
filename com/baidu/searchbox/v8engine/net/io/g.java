package com.baidu.searchbox.v8engine.net.io;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes11.dex */
public final class g extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final transient byte[][] f38310f;

    /* renamed from: g  reason: collision with root package name */
    public final transient int[] f38311g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(a aVar, int i2) {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((byte[]) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        j.a(aVar.f38298b, 0L, i2);
        e eVar = aVar.a;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i2) {
            int i8 = eVar.f38304c;
            int i9 = eVar.f38303b;
            if (i8 != i9) {
                i6 += i8 - i9;
                i7++;
                eVar = eVar.f38307f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f38310f = new byte[i7];
        this.f38311g = new int[i7 * 2];
        e eVar2 = aVar.a;
        int i10 = 0;
        while (i5 < i2) {
            this.f38310f[i10] = eVar2.a;
            i5 += eVar2.f38304c - eVar2.f38303b;
            if (i5 > i2) {
                i5 = i2;
            }
            int[] iArr = this.f38311g;
            iArr[i10] = i5;
            iArr[this.f38310f.length + i10] = eVar2.f38303b;
            eVar2.f38305d = true;
            i10++;
            eVar2 = eVar2.f38307f;
        }
    }

    private d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? new d(d()) : (d) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? e().a() : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? e().b() : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f38311g[this.f38310f.length - 1] : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int[] iArr = this.f38311g;
            byte[][] bArr = this.f38310f;
            byte[] bArr2 = new byte[iArr[bArr.length - 1]];
            int length = bArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int[] iArr2 = this.f38311g;
                int i4 = iArr2[length + i2];
                int i5 = iArr2[i2];
                System.arraycopy(this.f38310f[i2], i4, bArr2, i3, i5 - i3);
                i2++;
                i3 = i5;
            }
            return bArr2;
        }
        return (byte[]) invokeV.objValue;
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
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int i2 = this.f38301d;
            if (i2 != 0) {
                return i2;
            }
            int length = this.f38310f.length;
            int i3 = 0;
            int i4 = 0;
            int i5 = 1;
            while (i3 < length) {
                byte[] bArr = this.f38310f[i3];
                int[] iArr = this.f38311g;
                int i6 = iArr[length + i3];
                int i7 = iArr[i3];
                int i8 = (i7 - i4) + i6;
                while (i6 < i8) {
                    i5 = (i5 * 31) + bArr[i6];
                    i6++;
                }
                i3++;
                i4 = i7;
            }
            this.f38301d = i5;
            return i5;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? e().toString() : (String) invokeV.objValue;
    }

    private int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            int binarySearch = Arrays.binarySearch(this.f38311g, 0, this.f38310f.length, i2 + 1);
            return binarySearch >= 0 ? binarySearch : ~binarySearch;
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public d a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) ? e().a(i2, i3) : (d) invokeII.objValue;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public byte a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            j.a(this.f38311g[this.f38310f.length - 1], i2, 1L);
            int b2 = b(i2);
            int i3 = b2 == 0 ? 0 : this.f38311g[b2 - 1];
            int[] iArr = this.f38311g;
            byte[][] bArr = this.f38310f;
            return bArr[b2][(i2 - i3) + iArr[bArr.length + b2]];
        }
        return invokeI.byteValue;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public boolean a(int i2, d dVar, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), dVar, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i2 < 0 || i2 > c() - i4) {
                return false;
            }
            int b2 = b(i2);
            while (i4 > 0) {
                int i5 = b2 == 0 ? 0 : this.f38311g[b2 - 1];
                int min = Math.min(i4, ((this.f38311g[b2] - i5) + i5) - i2);
                int[] iArr = this.f38311g;
                byte[][] bArr = this.f38310f;
                if (!dVar.a(i3, bArr[b2], (i2 - i5) + iArr[bArr.length + b2], min)) {
                    return false;
                }
                i2 += min;
                i3 += min;
                i4 -= min;
                b2++;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.searchbox.v8engine.net.io.d
    public boolean a(int i2, byte[] bArr, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), bArr, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i2 < 0 || i2 > c() - i4 || i3 < 0 || i3 > bArr.length - i4) {
                return false;
            }
            int b2 = b(i2);
            while (i4 > 0) {
                int i5 = b2 == 0 ? 0 : this.f38311g[b2 - 1];
                int min = Math.min(i4, ((this.f38311g[b2] - i5) + i5) - i2);
                int[] iArr = this.f38311g;
                byte[][] bArr2 = this.f38310f;
                if (!j.a(bArr2[b2], (i2 - i5) + iArr[bArr2.length + b2], bArr, i3, min)) {
                    return false;
                }
                i2 += min;
                i3 += min;
                i4 -= min;
                b2++;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
