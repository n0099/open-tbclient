package b.a.r.h.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.codec.digest4util.XXHash32;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int[] f15328a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f15329b;

    /* renamed from: c  reason: collision with root package name */
    public final int f15330c;

    /* renamed from: d  reason: collision with root package name */
    public int f15331d;

    /* renamed from: e  reason: collision with root package name */
    public int f15332e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g() {
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

    public g(int i2) {
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
        this.f15328a = new int[4];
        this.f15329b = new byte[16];
        this.f15330c = i2;
        f();
    }

    public static int a(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, bArr, i2)) == null) ? (int) (d(bArr, i2, 4) & 4294967295L) : invokeLI.intValue;
    }

    public static long d(byte[] bArr, int i2, int i3) {
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

    public void b(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048576, this, bArr, i2, i3) == null) || i3 <= 0) {
            return;
        }
        this.f15331d += i3;
        int i4 = i2 + i3;
        int i5 = this.f15332e;
        if (i5 + i3 < 16) {
            System.arraycopy(bArr, i2, this.f15329b, i5, i3);
            this.f15332e += i3;
            return;
        }
        if (i5 > 0) {
            int i6 = 16 - i5;
            System.arraycopy(bArr, i2, this.f15329b, i5, i6);
            e(this.f15329b, 0);
            i2 += i6;
        }
        int i7 = i4 - 16;
        while (i2 <= i7) {
            e(bArr, i2);
            i2 += 16;
        }
        if (i2 < i4) {
            int i8 = i4 - i2;
            this.f15332e = i8;
            System.arraycopy(bArr, i2, this.f15329b, 0, i8);
        }
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = 0;
            int rotateLeft = (this.f15331d > 16 ? Integer.rotateLeft(this.f15328a[0], 1) + Integer.rotateLeft(this.f15328a[1], 7) + Integer.rotateLeft(this.f15328a[2], 12) + Integer.rotateLeft(this.f15328a[3], 18) : this.f15328a[2] + XXHash32.PRIME5) + this.f15331d;
            int i3 = this.f15332e - 4;
            while (i2 <= i3) {
                rotateLeft = Integer.rotateLeft(rotateLeft + (a(this.f15329b, i2) * XXHash32.PRIME3), 17) * XXHash32.PRIME4;
                i2 += 4;
            }
            while (i2 < this.f15332e) {
                rotateLeft = Integer.rotateLeft(rotateLeft + ((this.f15329b[i2] & 255) * XXHash32.PRIME5), 11) * XXHash32.PRIME1;
                i2++;
            }
            int i4 = (rotateLeft ^ (rotateLeft >>> 15)) * XXHash32.PRIME2;
            int i5 = (i4 ^ (i4 >>> 13)) * XXHash32.PRIME3;
            return (i5 ^ (i5 >>> 16)) & 4294967295L;
        }
        return invokeV.longValue;
    }

    public final void e(byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, bArr, i2) == null) {
            int[] iArr = this.f15328a;
            int i3 = iArr[0];
            int i4 = iArr[1];
            int i5 = iArr[2];
            int i6 = iArr[3];
            int rotateLeft = Integer.rotateLeft(i3 + (a(bArr, i2) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
            int rotateLeft2 = Integer.rotateLeft(i4 + (a(bArr, i2 + 4) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
            int rotateLeft3 = Integer.rotateLeft(i5 + (a(bArr, i2 + 8) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
            int rotateLeft4 = Integer.rotateLeft(i6 + (a(bArr, i2 + 12) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
            int[] iArr2 = this.f15328a;
            iArr2[0] = rotateLeft;
            iArr2[1] = rotateLeft2;
            iArr2[2] = rotateLeft3;
            iArr2[3] = rotateLeft4;
            this.f15332e = 0;
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int[] iArr = this.f15328a;
            int i2 = this.f15330c;
            iArr[0] = i2 + XXHash32.PRIME1 + XXHash32.PRIME2;
            iArr[1] = XXHash32.PRIME2 + i2;
            iArr[2] = i2;
            iArr[3] = i2 - XXHash32.PRIME1;
        }
    }
}
