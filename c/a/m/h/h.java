package c.a.m.h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.codec.digest4util.XXHash32;
/* loaded from: classes.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f3746b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3747c;

    /* renamed from: d  reason: collision with root package name */
    public int f3748d;

    /* renamed from: e  reason: collision with root package name */
    public int f3749e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h() {
        this(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new int[4];
        this.f3746b = new byte[16];
        this.f3747c = i;
        e();
    }

    public static int a(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, bArr, i)) == null) ? (int) (d(bArr, i, 4) & 4294967295L) : invokeLI.intValue;
    }

    public static long d(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, bArr, i, i2)) == null) {
            if (i2 <= 8) {
                long j = 0;
                for (int i3 = 0; i3 < i2; i3++) {
                    j |= (bArr[i + i3] & 255) << (i3 * 8);
                }
                return j;
            }
            throw new IllegalArgumentException("can't read more than eight bytes into a long value");
        }
        return invokeLII.longValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = 0;
            int rotateLeft = (this.f3748d > 16 ? Integer.rotateLeft(this.a[0], 1) + Integer.rotateLeft(this.a[1], 7) + Integer.rotateLeft(this.a[2], 12) + Integer.rotateLeft(this.a[3], 18) : this.a[2] + XXHash32.PRIME5) + this.f3748d;
            int i2 = this.f3749e - 4;
            while (i <= i2) {
                rotateLeft = Integer.rotateLeft(rotateLeft + (a(this.f3746b, i) * XXHash32.PRIME3), 17) * XXHash32.PRIME4;
                i += 4;
            }
            while (i < this.f3749e) {
                rotateLeft = Integer.rotateLeft(rotateLeft + ((this.f3746b[i] & 255) * XXHash32.PRIME5), 11) * XXHash32.PRIME1;
                i++;
            }
            int i3 = (rotateLeft ^ (rotateLeft >>> 15)) * XXHash32.PRIME2;
            int i4 = (i3 ^ (i3 >>> 13)) * XXHash32.PRIME3;
            return (i4 ^ (i4 >>> 16)) & 4294967295L;
        }
        return invokeV.longValue;
    }

    public void c(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i, i2) == null) || i2 <= 0) {
            return;
        }
        this.f3748d += i2;
        int i3 = i + i2;
        int i4 = this.f3749e;
        if (i4 + i2 < 16) {
            System.arraycopy(bArr, i, this.f3746b, i4, i2);
            this.f3749e += i2;
            return;
        }
        if (i4 > 0) {
            int i5 = 16 - i4;
            System.arraycopy(bArr, i, this.f3746b, i4, i5);
            f(this.f3746b, 0);
            i += i5;
        }
        int i6 = i3 - 16;
        while (i <= i6) {
            f(bArr, i);
            i += 16;
        }
        if (i < i3) {
            int i7 = i3 - i;
            this.f3749e = i7;
            System.arraycopy(bArr, i, this.f3746b, 0, i7);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int[] iArr = this.a;
            int i = this.f3747c;
            iArr[0] = i + XXHash32.PRIME1 + XXHash32.PRIME2;
            iArr[1] = XXHash32.PRIME2 + i;
            iArr[2] = i;
            iArr[3] = i - XXHash32.PRIME1;
        }
    }

    public final void f(byte[] bArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, bArr, i) == null) {
            int[] iArr = this.a;
            int i2 = iArr[0];
            int i3 = iArr[1];
            int i4 = iArr[2];
            int i5 = iArr[3];
            int rotateLeft = Integer.rotateLeft(i2 + (a(bArr, i) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
            int rotateLeft2 = Integer.rotateLeft(i3 + (a(bArr, i + 4) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
            int rotateLeft3 = Integer.rotateLeft(i4 + (a(bArr, i + 8) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
            int rotateLeft4 = Integer.rotateLeft(i5 + (a(bArr, i + 12) * XXHash32.PRIME2), 13) * XXHash32.PRIME1;
            int[] iArr2 = this.a;
            iArr2[0] = rotateLeft;
            iArr2[1] = rotateLeft2;
            iArr2[2] = rotateLeft3;
            iArr2[3] = rotateLeft4;
            this.f3749e = 0;
        }
    }
}
