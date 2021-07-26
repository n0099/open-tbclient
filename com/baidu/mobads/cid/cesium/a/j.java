package com.baidu.mobads.cid.cesium.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.codec.digest4util.XXHash32;
/* loaded from: classes2.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f8229a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f8230b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f8231c;

    /* renamed from: d  reason: collision with root package name */
    public final int f8232d;

    /* renamed from: e  reason: collision with root package name */
    public int f8233e;

    /* renamed from: f  reason: collision with root package name */
    public int f8234f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j() {
        this(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public j(int i2) {
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
        this.f8229a = new byte[1];
        this.f8230b = new int[4];
        this.f8231c = new byte[16];
        this.f8232d = i2;
        b();
    }

    public static int a(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, bArr, i2)) == null) ? (int) (b(bArr, i2, 4) & 4294967295L) : invokeLI.intValue;
    }

    public static long b(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, bArr, i2, i3)) == null) {
            if (i3 <= 8) {
                long j = 0;
                for (int i4 = 0; i4 < i3; i4++) {
                    j |= (bArr[i2 + i4] & 255) << (i4 * 8);
                }
                return j;
            }
            throw new IllegalArgumentException("can't read more than eight bytes into a long value");
        }
        return invokeLII.longValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            int[] iArr = this.f8230b;
            int i2 = this.f8232d;
            iArr[0] = i2 + XXHash32.PRIME1 + XXHash32.PRIME2;
            iArr[1] = XXHash32.PRIME2 + i2;
            iArr[2] = i2;
            iArr[3] = i2 - XXHash32.PRIME1;
        }
    }

    private void b(byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, this, bArr, i2) == null) {
            int[] iArr = this.f8230b;
            int i3 = iArr[0];
            int i4 = iArr[1];
            int i5 = iArr[2];
            int i6 = iArr[3];
            int rotateLeft = Integer.rotateLeft(i3 + (a(bArr, i2) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
            int rotateLeft2 = Integer.rotateLeft(i4 + (a(bArr, i2 + 4) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
            int rotateLeft3 = Integer.rotateLeft(i5 + (a(bArr, i2 + 8) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
            int rotateLeft4 = Integer.rotateLeft(i6 + (a(bArr, i2 + 12) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
            int[] iArr2 = this.f8230b;
            iArr2[0] = rotateLeft;
            iArr2[1] = rotateLeft2;
            iArr2[2] = rotateLeft3;
            iArr2[3] = rotateLeft4;
            this.f8234f = 0;
        }
    }

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = 0;
            int rotateLeft = (this.f8233e > 16 ? Integer.rotateLeft(this.f8230b[0], 1) + Integer.rotateLeft(this.f8230b[1], 7) + Integer.rotateLeft(this.f8230b[2], 12) + Integer.rotateLeft(this.f8230b[3], 18) : this.f8230b[2] + XXHash32.PRIME5) + this.f8233e;
            int i3 = this.f8234f - 4;
            while (i2 <= i3) {
                rotateLeft = Integer.rotateLeft(rotateLeft + (a(this.f8231c, i2) * XXHash32.PRIME3), 17) * XXHash32.PRIME4;
                i2 += 4;
            }
            while (i2 < this.f8234f) {
                rotateLeft = Integer.rotateLeft(rotateLeft + ((this.f8231c[i2] & 255) * XXHash32.PRIME5), 11) * XXHash32.PRIME1;
                i2++;
            }
            int i4 = (rotateLeft ^ (rotateLeft >>> 15)) * XXHash32.PRIME2;
            int i5 = (i4 ^ (i4 >>> 13)) * XXHash32.PRIME3;
            return (i5 ^ (i5 >>> 16)) & 4294967295L;
        }
        return invokeV.longValue;
    }

    public void a(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2, i3) == null) || i3 <= 0) {
            return;
        }
        this.f8233e += i3;
        int i4 = i2 + i3;
        int i5 = this.f8234f;
        if (i5 + i3 < 16) {
            System.arraycopy(bArr, i2, this.f8231c, i5, i3);
            this.f8234f += i3;
            return;
        }
        if (i5 > 0) {
            int i6 = 16 - i5;
            System.arraycopy(bArr, i2, this.f8231c, i5, i6);
            b(this.f8231c, 0);
            i2 += i6;
        }
        int i7 = i4 - 16;
        while (i2 <= i7) {
            b(bArr, i2);
            i2 += 16;
        }
        if (i2 < i4) {
            int i8 = i4 - i2;
            this.f8234f = i8;
            System.arraycopy(bArr, i2, this.f8231c, 0, i8);
        }
    }
}
