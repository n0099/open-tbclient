package c.a.p0.j2.b.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f20792a;

    /* renamed from: b  reason: collision with root package name */
    public int f20793b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f20794c;

    /* renamed from: d  reason: collision with root package name */
    public int f20795d;

    /* renamed from: e  reason: collision with root package name */
    public int f20796e;

    /* renamed from: f  reason: collision with root package name */
    public int f20797f;

    /* renamed from: g  reason: collision with root package name */
    public int f20798g;

    /* renamed from: h  reason: collision with root package name */
    public int f20799h;

    /* renamed from: i  reason: collision with root package name */
    public int f20800i;

    /* renamed from: j  reason: collision with root package name */
    public int f20801j;
    public int[] k;
    public int[] l;
    public int m;
    public int n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int[] u;
    public int v;
    public byte[] w;

    public b(int i2, int i3, byte[] bArr, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), bArr, Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20799h = 12;
        this.f20801j = 4096;
        this.k = new int[5003];
        this.l = new int[5003];
        this.m = 5003;
        this.n = 0;
        this.o = false;
        this.s = 0;
        this.t = 0;
        this.u = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
        this.w = new byte[256];
        this.f20792a = i2;
        this.f20793b = i3;
        this.f20794c = bArr;
        this.f20795d = Math.max(2, i4);
    }

    public final int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? (1 << i2) - 1 : invokeI.intValue;
    }

    public void b(byte b2, OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Byte.valueOf(b2), outputStream}) == null) {
            byte[] bArr = this.w;
            int i2 = this.v;
            int i3 = i2 + 1;
            this.v = i3;
            bArr[i2] = b2;
            if (i3 >= 254) {
                g(outputStream);
            }
        }
    }

    public void c(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, outputStream) == null) {
            d(this.m);
            int i2 = this.q;
            this.n = i2 + 2;
            this.o = true;
            i(i2, outputStream);
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            for (int i3 = 0; i3 < i2; i3++) {
                this.k[i3] = -1;
            }
        }
    }

    public void e(int i2, OutputStream outputStream) throws IOException {
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeIL(1048580, this, i2, outputStream) != null) {
            return;
        }
        this.p = i2;
        int i3 = 0;
        this.o = false;
        this.f20798g = i2;
        this.f20800i = a(i2);
        int i4 = 1 << (i2 - 1);
        this.q = i4;
        this.r = i4 + 1;
        this.n = i4 + 2;
        this.v = 0;
        int h2 = h();
        for (int i5 = this.m; i5 < 65536; i5 *= 2) {
            i3++;
        }
        int i6 = 8 - i3;
        int i7 = this.m;
        d(i7);
        i(this.q, outputStream);
        while (true) {
            int h3 = h();
            if (h3 != -1) {
                int i8 = (h3 << this.f20799h) + h2;
                int i9 = (h3 << i6) ^ h2;
                int[] iArr2 = this.k;
                if (iArr2[i9] == i8) {
                    h2 = this.l[i9];
                } else {
                    if (iArr2[i9] >= 0) {
                        int i10 = i7 - i9;
                        if (i9 == 0) {
                            i10 = 1;
                        }
                        do {
                            i9 -= i10;
                            if (i9 < 0) {
                                i9 += i7;
                            }
                            iArr = this.k;
                            if (iArr[i9] == i8) {
                                h2 = this.l[i9];
                                break;
                            }
                        } while (iArr[i9] >= 0);
                    }
                    i(h2, outputStream);
                    int i11 = this.n;
                    if (i11 < this.f20801j) {
                        int[] iArr3 = this.l;
                        this.n = i11 + 1;
                        iArr3[i9] = i11;
                        this.k[i9] = i8;
                    } else {
                        c(outputStream);
                    }
                    h2 = h3;
                }
            } else {
                i(h2, outputStream);
                i(this.r, outputStream);
                return;
            }
        }
    }

    public void f(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, outputStream) == null) {
            outputStream.write(this.f20795d);
            this.f20796e = this.f20792a * this.f20793b;
            this.f20797f = 0;
            e(this.f20795d + 1, outputStream);
            outputStream.write(0);
        }
    }

    public void g(OutputStream outputStream) throws IOException {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, outputStream) == null) || (i2 = this.v) <= 0) {
            return;
        }
        outputStream.write(i2);
        outputStream.write(this.w, 0, this.v);
        this.v = 0;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i2 = this.f20796e;
            if (i2 == 0) {
                return -1;
            }
            this.f20796e = i2 - 1;
            byte[] bArr = this.f20794c;
            int i3 = this.f20797f;
            this.f20797f = i3 + 1;
            return bArr[i3] & 255;
        }
        return invokeV.intValue;
    }

    public void i(int i2, OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, outputStream) == null) {
            int i3 = this.s;
            int[] iArr = this.u;
            int i4 = this.t;
            int i5 = i3 & iArr[i4];
            this.s = i5;
            if (i4 > 0) {
                this.s = i5 | (i2 << i4);
            } else {
                this.s = i2;
            }
            this.t += this.f20798g;
            while (this.t >= 8) {
                b((byte) (this.s & 255), outputStream);
                this.s >>= 8;
                this.t -= 8;
            }
            if (this.n > this.f20800i || this.o) {
                if (this.o) {
                    int i6 = this.p;
                    this.f20798g = i6;
                    this.f20800i = a(i6);
                    this.o = false;
                } else {
                    int i7 = this.f20798g + 1;
                    this.f20798g = i7;
                    if (i7 == this.f20799h) {
                        this.f20800i = this.f20801j;
                    } else {
                        this.f20800i = a(i7);
                    }
                }
            }
            if (i2 == this.r) {
                while (this.t > 0) {
                    b((byte) (this.s & 255), outputStream);
                    this.s >>= 8;
                    this.t -= 8;
                }
                g(outputStream);
            }
        }
    }
}
