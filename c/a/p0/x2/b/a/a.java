package c.a.p0.x2.b.a;

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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f20648b;

    /* renamed from: c  reason: collision with root package name */
    public int f20649c;

    /* renamed from: d  reason: collision with root package name */
    public int f20650d;

    /* renamed from: e  reason: collision with root package name */
    public int f20651e;

    /* renamed from: f  reason: collision with root package name */
    public int f20652f;

    /* renamed from: g  reason: collision with root package name */
    public int f20653g;

    /* renamed from: h  reason: collision with root package name */
    public int f20654h;
    public boolean i;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20649c = 0;
        this.f20650d = 0;
        this.f20651e = -1;
        this.f20653g = -1;
        this.f20654h = 0;
        this.i = false;
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
            if (bitmap == null || !this.i) {
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
                    if (this.f20653g >= 0) {
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
            int i = length / 3;
            this.m = new byte[i];
            c cVar = new c(bArr, length, this.v);
            this.o = cVar.h();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                byte[] bArr2 = this.o;
                if (i3 >= bArr2.length) {
                    break;
                }
                byte b2 = bArr2[i3];
                int i4 = i3 + 2;
                bArr2[i3] = bArr2[i4];
                bArr2[i4] = b2;
                this.p[i3 / 3] = false;
                i3 += 3;
            }
            int i5 = 0;
            while (i2 < i) {
                byte[] bArr3 = this.l;
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                int g2 = cVar.g(bArr3[i5] & 255, bArr3[i6] & 255, bArr3[i7] & 255);
                this.p[g2] = true;
                this.m[i2] = (byte) g2;
                i2++;
                i5 = i7 + 1;
            }
            this.l = null;
            this.n = 8;
            this.q = 7;
            int i8 = this.f20651e;
            if (i8 != -1) {
                this.f20652f = c(i8);
            }
        }
    }

    public int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            byte[] bArr = this.o;
            if (bArr == null) {
                return -1;
            }
            int i2 = (i >> 16) & 255;
            int i3 = (i >> 8) & 255;
            int i4 = 0;
            int i5 = (i >> 0) & 255;
            int length = bArr.length;
            int i6 = 0;
            int i7 = 16777216;
            while (i4 < length) {
                byte[] bArr2 = this.o;
                int i8 = i4 + 1;
                int i9 = i2 - (bArr2[i4] & 255);
                int i10 = i8 + 1;
                int i11 = i3 - (bArr2[i8] & 255);
                int i12 = i5 - (bArr2[i10] & 255);
                int i13 = (i9 * i9) + (i11 * i11) + (i12 * i12);
                int i14 = i10 / 3;
                if (this.p[i14] && i13 < i7) {
                    i7 = i13;
                    i6 = i14;
                }
                i4 = i10 + 1;
            }
            return i6;
        }
        return invokeI.intValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.i) {
                this.i = false;
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
                this.f20652f = 0;
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
            if (width != this.a || height != this.f20648b) {
                Bitmap createBitmap = Bitmap.createBitmap(this.a, this.f20648b, Bitmap.Config.RGB_565);
                new Canvas(createBitmap).drawBitmap(this.k, 0.0f, 0.0f, new Paint());
                this.k = createBitmap;
            }
            int[] e2 = e(this.k);
            this.l = new byte[e2.length * 3];
            for (int i = 0; i < e2.length; i++) {
                int i2 = e2[i];
                int i3 = i * 3;
                byte[] bArr = this.l;
                int i4 = i3 + 1;
                bArr[i3] = (byte) ((i2 >> 0) & 255);
                bArr[i4] = (byte) ((i2 >> 8) & 255);
                bArr[i4 + 1] = (byte) ((i2 >> 16) & 255);
            }
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || i < 0) {
            return;
        }
        this.f20653g = i;
    }

    public void h(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
            this.a = i;
            this.f20648b = i2;
            if (i < 1) {
                this.a = MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP;
            }
            if (this.f20648b < 1) {
                this.f20648b = 240;
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
            this.i = z;
            return z;
        }
        return invokeL.booleanValue;
    }

    public void j() throws IOException {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.j.write(33);
            this.j.write(249);
            this.j.write(4);
            if (this.f20651e == -1) {
                i = 0;
                i2 = 0;
            } else {
                i = 1;
                i2 = 2;
            }
            int i3 = this.r;
            if (i3 >= 0) {
                i2 = i3 & 7;
            }
            this.j.write(i | (i2 << 2) | 0 | 0);
            p(this.f20654h);
            this.j.write(this.f20652f);
            this.j.write(0);
        }
    }

    public void k() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.j.write(44);
            p(this.f20649c);
            p(this.f20650d);
            p(this.a);
            p(this.f20648b);
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
            p(this.a);
            p(this.f20648b);
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
            p(this.f20653g);
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
            for (int i = 0; i < length; i++) {
                this.j.write(0);
            }
        }
    }

    public void o() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            new b(this.a, this.f20648b, this.m, this.n).f(this.j);
        }
    }

    public void p(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.j.write(i & 255);
            this.j.write((i >> 8) & 255);
        }
    }

    public void q(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            for (int i = 0; i < str.length(); i++) {
                this.j.write((byte) str.charAt(i));
            }
        }
    }
}
