package c.i.b.a.a0;

import androidx.core.view.InputDeviceCompat;
import c.i.b.a.i0.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes4.dex */
public final class b implements f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f32463g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c.i.b.a.h0.e f32464a;

    /* renamed from: b  reason: collision with root package name */
    public final long f32465b;

    /* renamed from: c  reason: collision with root package name */
    public long f32466c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f32467d;

    /* renamed from: e  reason: collision with root package name */
    public int f32468e;

    /* renamed from: f  reason: collision with root package name */
    public int f32469f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-724485184, "Lc/i/b/a/a0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-724485184, "Lc/i/b/a/a0/b;");
                return;
            }
        }
        f32463g = new byte[4096];
    }

    public b(c.i.b.a.h0.e eVar, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32464a = eVar;
        this.f32466c = j2;
        this.f32465b = j3;
        this.f32467d = new byte[65536];
    }

    @Override // c.i.b.a.a0.f
    public boolean a(byte[] bArr, int i2, int i3, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            int m = m(bArr, i2, i3);
            while (m < i3 && m != -1) {
                m = l(bArr, i2, i3, m, z);
            }
            j(m);
            return m != -1;
        }
        return invokeCommon.booleanValue;
    }

    @Override // c.i.b.a.a0.f
    public int b(int i2) throws IOException, InterruptedException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            int n = n(i2);
            if (n == 0) {
                byte[] bArr = f32463g;
                n = l(bArr, 0, Math.min(i2, bArr.length), 0, true);
            }
            j(n);
            return n;
        }
        return invokeI.intValue;
    }

    @Override // c.i.b.a.a0.f
    public void c(byte[] bArr, int i2, int i3) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i2, i3) == null) {
            d(bArr, i2, i3, false);
        }
    }

    @Override // c.i.b.a.a0.f
    public boolean d(byte[] bArr, int i2, int i3, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            if (i(i3, z)) {
                System.arraycopy(this.f32467d, this.f32468e - i3, bArr, i2, i3);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // c.i.b.a.a0.f
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f32468e = 0;
        }
    }

    @Override // c.i.b.a.a0.f
    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f32466c + this.f32468e : invokeV.longValue;
    }

    @Override // c.i.b.a.a0.f
    public void g(int i2) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            i(i2, false);
        }
    }

    @Override // c.i.b.a.a0.f
    public long getLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f32465b : invokeV.longValue;
    }

    @Override // c.i.b.a.a0.f
    public long getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f32466c : invokeV.longValue;
    }

    @Override // c.i.b.a.a0.f
    public void h(int i2) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            o(i2, false);
        }
    }

    public boolean i(int i2, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            k(i2);
            int min = Math.min(this.f32469f - this.f32468e, i2);
            while (min < i2) {
                min = l(this.f32467d, this.f32468e, i2, min, z);
                if (min == -1) {
                    return false;
                }
            }
            int i3 = this.f32468e + i2;
            this.f32468e = i3;
            this.f32469f = Math.max(this.f32469f, i3);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void j(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || i2 == -1) {
            return;
        }
        this.f32466c += i2;
    }

    public final void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            int i3 = this.f32468e + i2;
            byte[] bArr = this.f32467d;
            if (i3 > bArr.length) {
                this.f32467d = Arrays.copyOf(this.f32467d, v.k(bArr.length * 2, 65536 + i3, i3 + 524288));
            }
        }
    }

    public final int l(byte[] bArr, int i2, int i3, int i4, boolean z) throws InterruptedException, IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)})) == null) {
            if (!Thread.interrupted()) {
                int read = this.f32464a.read(bArr, i2 + i4, i3 - i4);
                if (read == -1) {
                    if (i4 == 0 && z) {
                        return -1;
                    }
                    throw new EOFException();
                }
                return i4 + read;
            }
            throw new InterruptedException();
        }
        return invokeCommon.intValue;
    }

    public final int m(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048590, this, bArr, i2, i3)) == null) {
            int i4 = this.f32469f;
            if (i4 == 0) {
                return 0;
            }
            int min = Math.min(i4, i3);
            System.arraycopy(this.f32467d, 0, bArr, i2, min);
            p(min);
            return min;
        }
        return invokeLII.intValue;
    }

    public final int n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            int min = Math.min(this.f32469f, i2);
            p(min);
            return min;
        }
        return invokeI.intValue;
    }

    public boolean o(int i2, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int n = n(i2);
            while (n < i2 && n != -1) {
                byte[] bArr = f32463g;
                n = l(bArr, -n, Math.min(i2, bArr.length + n), n, z);
            }
            j(n);
            return n != -1;
        }
        return invokeCommon.booleanValue;
    }

    public final void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            int i3 = this.f32469f - i2;
            this.f32469f = i3;
            this.f32468e = 0;
            byte[] bArr = this.f32467d;
            if (i3 < bArr.length - 524288) {
                bArr = new byte[i3 + 65536];
            }
            System.arraycopy(this.f32467d, i2, bArr, 0, this.f32469f);
            this.f32467d = bArr;
        }
    }

    @Override // c.i.b.a.a0.f
    public int read(byte[] bArr, int i2, int i3) throws IOException, InterruptedException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048594, this, bArr, i2, i3)) == null) {
            int m = m(bArr, i2, i3);
            if (m == 0) {
                m = l(bArr, i2, i3, 0, true);
            }
            j(m);
            return m;
        }
        return invokeLII.intValue;
    }

    @Override // c.i.b.a.a0.f
    public void readFully(byte[] bArr, int i2, int i3) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048595, this, bArr, i2, i3) == null) {
            a(bArr, i2, i3, false);
        }
    }
}
