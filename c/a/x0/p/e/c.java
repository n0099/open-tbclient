package c.a.x0.p.e;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import c.a.x0.t.p;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.Random;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: i  reason: collision with root package name */
    public static int f31095i = 500;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile int f31096a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f31097b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f31098c;

    /* renamed from: d  reason: collision with root package name */
    public int f31099d;

    /* renamed from: e  reason: collision with root package name */
    public int f31100e;

    /* renamed from: f  reason: collision with root package name */
    public String f31101f;

    /* renamed from: g  reason: collision with root package name */
    public volatile String f31102g;

    /* renamed from: h  reason: collision with root package name */
    public Context f31103h;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ byte[] f31104e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f31105f;

        public a(c cVar, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31105f = cVar;
            this.f31104e = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Bitmap a2 = new p(this.f31105f.f31103h).a(this.f31105f.j(this.f31104e, this.f31105f.f31100e, this.f31105f.f31099d), this.f31105f.f31099d, this.f31105f.f31100e);
                    this.f31105f.f31102g = this.f31105f.b(a2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1790528242, "Lc/a/x0/p/e/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1790528242, "Lc/a/x0/p/e/c;");
        }
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f31096a = 0;
        this.f31097b = -1;
        this.f31103h = context;
    }

    public final String b(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmap)) == null) {
            File file = new File(new File(this.f31101f), "samplecover.dat");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                if (bitmap != null) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            g(file);
            return file.getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public void e(int i2, int i3, int i4, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Boolean.valueOf(z)}) == null) {
            this.f31099d = i2;
            this.f31100e = i3;
            this.f31101f = str;
            this.f31098c = z;
        }
    }

    public final void f(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void g(File file) {
        RandomAccessFile randomAccessFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, file) == null) {
            Closeable closeable = null;
            try {
                try {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[f31095i];
                randomAccessFile.read(bArr, 0, f31095i);
                byte[] m = m(bArr);
                randomAccessFile.seek(0L);
                randomAccessFile.write(m, 0, f31095i);
                f(randomAccessFile);
            } catch (Exception e3) {
                e = e3;
                closeable = randomAccessFile;
                e.printStackTrace();
                f(closeable);
            } catch (Throwable th2) {
                th = th2;
                closeable = randomAccessFile;
                f(closeable);
                throw th;
            }
        }
    }

    public void h(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) {
            if (this.f31097b > 0 && this.f31098c && this.f31096a == this.f31097b) {
                byte[] bArr2 = new byte[bArr.length];
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    bArr2[i2] = bArr[i2];
                }
                new Thread(new a(this, bArr2), "yuvtobitmap").start();
            }
            this.f31096a++;
        }
    }

    public final byte[] j(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, bArr, i2, i3)) == null) {
            int i4 = i2 * i3;
            byte[] bArr2 = new byte[(i4 * 3) / 2];
            int i5 = i2 - 1;
            int i6 = 0;
            for (int i7 = i5; i7 >= 0; i7--) {
                for (int i8 = 0; i8 < i3; i8++) {
                    bArr2[i6] = bArr[(i8 * i2) + i7];
                    i6++;
                }
            }
            int i9 = i4;
            while (i5 > 0) {
                for (int i10 = 0; i10 < i3 / 2; i10++) {
                    int i11 = (i10 * i2) + i4;
                    bArr2[i9] = bArr[i11 + i5];
                    int i12 = i9 + 1;
                    bArr2[i12] = bArr[i11 + (i5 - 1)];
                    i9 = i12 + 1;
                }
                i5 -= 2;
            }
            n(bArr2, i3, i2);
            return bArr2;
        }
        return (byte[]) invokeLII.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f31097b >= 0) {
            return;
        }
        this.f31097b = new Random().nextInt(240);
    }

    public final byte[] m(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bArr)) == null) {
            int i2 = f31095i;
            int i3 = i2 / 2;
            byte[] bArr2 = new byte[i2];
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                bArr2[i4] = bArr[i5];
                int i6 = i4 + 1;
                bArr2[i6] = bArr[i3 + i5];
                i4 = i6 + 1;
            }
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }

    public final byte[] n(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, i2, i3)) == null) {
            for (int i4 = 0; i4 < (i3 * 3) / 2; i4++) {
                for (int i5 = 0; i5 < i2 / 2; i5++) {
                    int i6 = (i4 * i2) + i5;
                    byte b2 = bArr[i6];
                    int i7 = (((i4 + 1) * i2) - 1) - i5;
                    bArr[i6] = bArr[i7];
                    bArr[i7] = b2;
                }
            }
            return bArr;
        }
        return (byte[]) invokeLII.objValue;
    }
}
