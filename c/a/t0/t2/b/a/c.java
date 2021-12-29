package c.a.t0.t2.b.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f24555b;

    /* renamed from: c  reason: collision with root package name */
    public int f24556c;

    /* renamed from: d  reason: collision with root package name */
    public int f24557d;

    /* renamed from: e  reason: collision with root package name */
    public int[][] f24558e;

    /* renamed from: f  reason: collision with root package name */
    public int[] f24559f;

    /* renamed from: g  reason: collision with root package name */
    public int[] f24560g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f24561h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f24562i;

    public c(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f24559f = new int[256];
        this.f24560g = new int[256];
        this.f24561h = new int[256];
        this.f24562i = new int[32];
        this.f24555b = bArr;
        this.f24556c = i2;
        this.f24557d = i3;
        this.f24558e = new int[256];
        for (int i6 = 0; i6 < 256; i6++) {
            int[][] iArr = this.f24558e;
            iArr[i6] = new int[4];
            int[] iArr2 = iArr[i6];
            int i7 = (i6 << 12) / 256;
            iArr2[2] = i7;
            iArr2[1] = i7;
            iArr2[0] = i7;
            this.f24561h[i6] = 256;
            this.f24560g[i6] = 0;
        }
    }

    public void a(int i2, int i3, int i4, int i5, int i6) {
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) != null) {
            return;
        }
        int i8 = i3 - i2;
        int i9 = i8 >= -1 ? i8 : -1;
        int i10 = i3 + i2;
        int i11 = i10 <= 256 ? i10 : 256;
        int i12 = i3 + 1;
        int i13 = i3 - 1;
        int i14 = 1;
        while (true) {
            if (i12 >= i11 && i13 <= i9) {
                return;
            }
            int i15 = i14 + 1;
            int i16 = this.f24562i[i14];
            if (i12 < i11) {
                i7 = i12 + 1;
                int[] iArr = this.f24558e[i12];
                try {
                    iArr[0] = iArr[0] - (((iArr[0] - i4) * i16) / 262144);
                    iArr[1] = iArr[1] - (((iArr[1] - i5) * i16) / 262144);
                    iArr[2] = iArr[2] - (((iArr[2] - i6) * i16) / 262144);
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            } else {
                i7 = i12;
            }
            if (i13 > i9) {
                int i17 = i13 - 1;
                int[] iArr2 = this.f24558e[i13];
                try {
                    iArr2[0] = iArr2[0] - (((iArr2[0] - i4) * i16) / 262144);
                    iArr2[1] = iArr2[1] - (((iArr2[1] - i5) * i16) / 262144);
                    iArr2[2] = iArr2[2] - ((i16 * (iArr2[2] - i6)) / 262144);
                } catch (Exception e3) {
                    BdLog.e(e3.getMessage());
                }
                i14 = i15;
                i13 = i17;
            } else {
                i14 = i15;
            }
            i12 = i7;
        }
    }

    public void b(int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            int[] iArr = this.f24558e[i3];
            iArr[0] = iArr[0] - (((iArr[0] - i4) * i2) / 1024);
            iArr[1] = iArr[1] - (((iArr[1] - i5) * i2) / 1024);
            iArr[2] = iArr[2] - ((i2 * (iArr[2] - i6)) / 1024);
        }
    }

    public byte[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            byte[] bArr = new byte[768];
            int[] iArr = new int[256];
            for (int i2 = 0; i2 < 256; i2++) {
                iArr[this.f24558e[i2][3]] = i2;
            }
            int i3 = 0;
            int i4 = 0;
            while (i3 < 256) {
                int i5 = iArr[i3];
                int i6 = i4 + 1;
                int[][] iArr2 = this.f24558e;
                bArr[i4] = (byte) iArr2[i5][0];
                int i7 = i6 + 1;
                bArr[i6] = (byte) iArr2[i5][1];
                bArr[i7] = (byte) iArr2[i5][2];
                i3++;
                i4 = i7 + 1;
            }
            return bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    public int d(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048579, this, i2, i3, i4)) == null) {
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            int i7 = -1;
            int i8 = -1;
            for (int i9 = 0; i9 < 256; i9++) {
                int[] iArr = this.f24558e[i9];
                int i10 = iArr[0] - i2;
                if (i10 < 0) {
                    i10 = -i10;
                }
                int i11 = iArr[1] - i3;
                if (i11 < 0) {
                    i11 = -i11;
                }
                int i12 = i10 + i11;
                int i13 = iArr[2] - i4;
                if (i13 < 0) {
                    i13 = -i13;
                }
                int i14 = i12 + i13;
                if (i14 < i5) {
                    i7 = i9;
                    i5 = i14;
                }
                int i15 = i14 - (this.f24560g[i9] >> 12);
                if (i15 < i6) {
                    i8 = i9;
                    i6 = i15;
                }
                int[] iArr2 = this.f24561h;
                int i16 = iArr2[i9] >> 10;
                iArr2[i9] = iArr2[i9] - i16;
                int[] iArr3 = this.f24560g;
                iArr3[i9] = iArr3[i9] + (i16 << 10);
            }
            int[] iArr4 = this.f24561h;
            iArr4[i7] = iArr4[i7] + 64;
            int[] iArr5 = this.f24560g;
            iArr5[i7] = iArr5[i7] - 65536;
            return i8;
        }
        return invokeIII.intValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i2 < 256) {
                int[] iArr = this.f24558e[i2];
                int i5 = iArr[1];
                int i6 = i2 + 1;
                int i7 = i2;
                for (int i8 = i6; i8 < 256; i8++) {
                    int[] iArr2 = this.f24558e[i8];
                    if (iArr2[1] < i5) {
                        i5 = iArr2[1];
                        i7 = i8;
                    }
                }
                int[] iArr3 = this.f24558e[i7];
                if (i2 != i7) {
                    int i9 = iArr3[0];
                    iArr3[0] = iArr[0];
                    iArr[0] = i9;
                    int i10 = iArr3[1];
                    iArr3[1] = iArr[1];
                    iArr[1] = i10;
                    int i11 = iArr3[2];
                    iArr3[2] = iArr[2];
                    iArr[2] = i11;
                    int i12 = iArr3[3];
                    iArr3[3] = iArr[3];
                    iArr[3] = i12;
                }
                if (i5 != i3) {
                    this.f24559f[i3] = (i4 + i2) >> 1;
                    while (true) {
                        i3++;
                        if (i3 >= i5) {
                            break;
                        }
                        this.f24559f[i3] = i2;
                    }
                    i4 = i2;
                    i3 = i5;
                }
                i2 = i6;
            }
            this.f24559f[i3] = (i4 + 255) >> 1;
            for (int i13 = i3 + 1; i13 < 256; i13++) {
                this.f24559f[i13] = 255;
            }
        }
    }

    public void f() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f24556c < 1509) {
                this.f24557d = 1;
            }
            int i3 = this.f24557d;
            this.a = ((i3 - 1) / 3) + 30;
            byte[] bArr = this.f24555b;
            int i4 = this.f24556c;
            int i5 = i4 / (i3 * 3);
            int i6 = i5 / 100;
            for (int i7 = 0; i7 < 32; i7++) {
                this.f24562i[i7] = 1024 * (((1024 - (i7 * i7)) * 256) / 1024);
            }
            int i8 = this.f24556c;
            if (i8 < 1509) {
                i2 = 3;
            } else if (i8 % DownloadConstants.STATUS_DEVICE_NOT_FOUND_ERROR != 0) {
                i2 = 1497;
            } else if (i8 % 491 != 0) {
                i2 = 1473;
            } else {
                i2 = i8 % 487 != 0 ? 1461 : 1509;
            }
            int i9 = i6;
            int i10 = 0;
            int i11 = 2048;
            int i12 = 32;
            int i13 = 1024;
            int i14 = 0;
            while (i10 < i5) {
                int i15 = (bArr[i14 + 0] & 255) << 4;
                int i16 = (bArr[i14 + 1] & 255) << 4;
                int i17 = (bArr[i14 + 2] & 255) << 4;
                int d2 = d(i15, i16, i17);
                int i18 = i10;
                b(i13, d2, i15, i16, i17);
                if (i12 != 0) {
                    a(i12, d2, i15, i16, i17);
                }
                int i19 = i14 + i2;
                if (i19 >= i4) {
                    i19 -= this.f24556c;
                }
                i14 = i19;
                i10 = i18 + 1;
                if (i9 == 0) {
                    i9 = 1;
                }
                if (i10 % i9 == 0) {
                    i13 -= i13 / this.a;
                    i11 -= i11 / 30;
                    int i20 = i11 >> 6;
                    i12 = i20 <= 1 ? 0 : i20;
                    for (int i21 = 0; i21 < i12; i21++) {
                        int i22 = i12 * i12;
                        this.f24562i[i21] = (((i22 - (i21 * i21)) * 256) / i22) * i13;
                    }
                }
            }
        }
    }

    public int g(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeIII = interceptable.invokeIII(1048582, this, i2, i3, i4)) != null) {
            return invokeIII.intValue;
        }
        int i5 = this.f24559f[i3];
        int i6 = i5 - 1;
        int i7 = 1000;
        int i8 = -1;
        while (true) {
            if (i5 >= 256 && i6 < 0) {
                return i8;
            }
            if (i5 < 256) {
                int[] iArr = this.f24558e[i5];
                int i9 = iArr[1] - i3;
                if (i9 >= i7) {
                    i5 = 256;
                } else {
                    i5++;
                    if (i9 < 0) {
                        i9 = -i9;
                    }
                    int i10 = iArr[0] - i2;
                    if (i10 < 0) {
                        i10 = -i10;
                    }
                    int i11 = i9 + i10;
                    if (i11 < i7) {
                        int i12 = iArr[2] - i4;
                        if (i12 < 0) {
                            i12 = -i12;
                        }
                        int i13 = i11 + i12;
                        if (i13 < i7) {
                            i8 = iArr[3];
                            i7 = i13;
                        }
                    }
                }
            }
            if (i6 >= 0) {
                int[] iArr2 = this.f24558e[i6];
                int i14 = i3 - iArr2[1];
                if (i14 >= i7) {
                    i6 = -1;
                } else {
                    i6--;
                    if (i14 < 0) {
                        i14 = -i14;
                    }
                    int i15 = iArr2[0] - i2;
                    if (i15 < 0) {
                        i15 = -i15;
                    }
                    int i16 = i14 + i15;
                    if (i16 < i7) {
                        int i17 = iArr2[2] - i4;
                        if (i17 < 0) {
                            i17 = -i17;
                        }
                        int i18 = i17 + i16;
                        if (i18 < i7) {
                            i8 = iArr2[3];
                            i7 = i18;
                        }
                    }
                }
            }
        }
    }

    public byte[] h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            f();
            i();
            e();
            return c();
        }
        return (byte[]) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (int i2 = 0; i2 < 256; i2++) {
                int[][] iArr = this.f24558e;
                int[] iArr2 = iArr[i2];
                iArr2[0] = iArr2[0] >> 4;
                int[] iArr3 = iArr[i2];
                iArr3[1] = iArr3[1] >> 4;
                int[] iArr4 = iArr[i2];
                iArr4[2] = iArr4[2] >> 4;
                iArr[i2][3] = i2;
            }
        }
    }
}
