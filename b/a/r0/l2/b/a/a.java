package b.a.r0.l2.b.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.OutputStream;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f21978a;

    /* renamed from: b  reason: collision with root package name */
    public int f21979b;

    /* renamed from: c  reason: collision with root package name */
    public int f21980c;

    /* renamed from: d  reason: collision with root package name */
    public int f21981d;

    /* renamed from: e  reason: collision with root package name */
    public int f21982e;

    /* renamed from: f  reason: collision with root package name */
    public int f21983f;

    /* renamed from: g  reason: collision with root package name */
    public int f21984g;

    /* renamed from: h  reason: collision with root package name */
    public int f21985h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21986i;
    public OutputStream j;
    public Bitmap k;
    public byte[] l;
    public byte[] m;
    public int n;
    public byte[] o;
    public boolean[] p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;

    public a() {
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
        this.f21980c = 0;
        this.f21981d = 0;
        this.f21982e = -1;
        this.f21984g = -1;
        this.f21985h = 0;
        this.f21986i = false;
        this.p = new boolean[256];
        this.q = 7;
        this.r = -1;
        this.s = false;
        this.t = true;
        this.u = false;
        this.v = 10;
    }

    public boolean a(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmap)) == null) {
            if (bitmap == null || !this.f21986i) {
                return false;
            }
            try {
                if (!this.u) {
                    h(bitmap.getWidth(), bitmap.getHeight());
                }
                this.k = bitmap;
                f();
                b();
                if (this.t) {
                    l();
                    n();
                    if (this.f21984g >= 0) {
                        m();
                    }
                }
                j();
                k();
                if (!this.t) {
                    n();
                }
                o();
                this.t = false;
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            byte[] bArr = this.l;
            int length = bArr.length;
            int i2 = length / 3;
            this.m = new byte[i2];
            c cVar = new c(bArr, length, this.v);
            this.o = cVar.h();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                byte[] bArr2 = this.o;
                if (i4 >= bArr2.length) {
                    break;
                }
                byte b2 = bArr2[i4];
                int i5 = i4 + 2;
                bArr2[i4] = bArr2[i5];
                bArr2[i5] = b2;
                this.p[i4 / 3] = false;
                i4 += 3;
            }
            int i6 = 0;
            while (i3 < i2) {
                byte[] bArr3 = this.l;
                int i7 = i6 + 1;
                int i8 = i7 + 1;
                int g2 = cVar.g(bArr3[i6] & 255, bArr3[i7] & 255, bArr3[i8] & 255);
                this.p[g2] = true;
                this.m[i3] = (byte) g2;
                i3++;
                i6 = i8 + 1;
            }
            this.l = null;
            this.n = 8;
            this.q = 7;
            int i9 = this.f21982e;
            if (i9 != -1) {
                this.f21983f = c(i9);
            }
        }
    }

    public int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            byte[] bArr = this.o;
            if (bArr == null) {
                return -1;
            }
            int i3 = (i2 >> 16) & 255;
            int i4 = (i2 >> 8) & 255;
            int i5 = 0;
            int i6 = (i2 >> 0) & 255;
            int length = bArr.length;
            int i7 = 0;
            int i8 = 16777216;
            while (i5 < length) {
                byte[] bArr2 = this.o;
                int i9 = i5 + 1;
                int i10 = i3 - (bArr2[i5] & 255);
                int i11 = i9 + 1;
                int i12 = i4 - (bArr2[i9] & 255);
                int i13 = i6 - (bArr2[i11] & 255);
                int i14 = (i10 * i10) + (i12 * i12) + (i13 * i13);
                int i15 = i11 / 3;
                if (this.p[i15] && i14 < i8) {
                    i8 = i14;
                    i7 = i15;
                }
                i5 = i11 + 1;
            }
            return i7;
        }
        return invokeI.intValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f21986i) {
                this.f21986i = false;
                try {
                    this.j.write(59);
                    this.j.flush();
                    if (this.s) {
                        this.j.close();
                    }
                    z = true;
                } catch (IOException unused) {
                    z = false;
                }
                this.f21983f = 0;
                this.j = null;
                this.k = null;
                this.l = null;
                this.m = null;
                this.o = null;
                this.s = false;
                this.t = true;
                return z;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int[] e(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bitmap)) == null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int width = this.k.getWidth();
            int height = this.k.getHeight();
            if (width != this.f21978a || height != this.f21979b) {
                Bitmap createBitmap = Bitmap.createBitmap(this.f21978a, this.f21979b, Bitmap.Config.RGB_565);
                new Canvas(createBitmap).drawBitmap(this.k, 0.0f, 0.0f, new Paint());
                this.k = createBitmap;
            }
            int[] e2 = e(this.k);
            this.l = new byte[e2.length * 3];
            for (int i2 = 0; i2 < e2.length; i2++) {
                int i3 = e2[i2];
                int i4 = i2 * 3;
                byte[] bArr = this.l;
                int i5 = i4 + 1;
                bArr[i4] = (byte) ((i3 >> 0) & 255);
                bArr[i5] = (byte) ((i3 >> 8) & 255);
                bArr[i5 + 1] = (byte) ((i3 >> 16) & 255);
            }
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || i2 < 0) {
            return;
        }
        this.f21984g = i2;
    }

    public void h(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            this.f21978a = i2;
            this.f21979b = i3;
            if (i2 < 1) {
                this.f21978a = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;
            }
            if (this.f21979b < 1) {
                this.f21979b = 240;
            }
            this.u = true;
        }
    }

    public boolean i(OutputStream outputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, outputStream)) == null) {
            boolean z = false;
            if (outputStream == null) {
                return false;
            }
            this.s = false;
            this.j = outputStream;
            try {
                q("GIF89a");
                z = true;
            } catch (IOException unused) {
            }
            this.f21986i = z;
            return z;
        }
        return invokeL.booleanValue;
    }

    public void j() throws IOException {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.j.write(33);
            this.j.write(249);
            this.j.write(4);
            if (this.f21982e == -1) {
                i2 = 0;
                i3 = 0;
            } else {
                i2 = 1;
                i3 = 2;
            }
            int i4 = this.r;
            if (i4 >= 0) {
                i3 = i4 & 7;
            }
            this.j.write(i2 | (i3 << 2) | 0 | 0);
            p(this.f21985h);
            this.j.write(this.f21983f);
            this.j.write(0);
        }
    }

    public void k() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.j.write(44);
            p(this.f21980c);
            p(this.f21981d);
            p(this.f21978a);
            p(this.f21979b);
            if (this.t) {
                this.j.write(0);
            } else {
                this.j.write(this.q | 128);
            }
        }
    }

    public void l() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            p(this.f21978a);
            p(this.f21979b);
            this.j.write(this.q | 240);
            this.j.write(0);
            this.j.write(0);
        }
    }

    public void m() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.j.write(33);
            this.j.write(255);
            this.j.write(11);
            q("NETSCAPE2.0");
            this.j.write(3);
            this.j.write(1);
            p(this.f21984g);
            this.j.write(0);
        }
    }

    public void n() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            OutputStream outputStream = this.j;
            byte[] bArr = this.o;
            outputStream.write(bArr, 0, bArr.length);
            int length = 768 - this.o.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.j.write(0);
            }
        }
    }

    public void o() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            new b(this.f21978a, this.f21979b, this.m, this.n).f(this.j);
        }
    }

    public void p(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.j.write(i2 & 255);
            this.j.write((i2 >> 8) & 255);
        }
    }

    public void q(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                this.j.write((byte) str.charAt(i2));
            }
        }
    }
}
