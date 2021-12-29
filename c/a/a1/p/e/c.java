package c.a.a1.p.e;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import c.a.a1.t.p;
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
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: i  reason: collision with root package name */
    public static int f1415i = 500;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile int a;

    /* renamed from: b  reason: collision with root package name */
    public volatile int f1416b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f1417c;

    /* renamed from: d  reason: collision with root package name */
    public int f1418d;

    /* renamed from: e  reason: collision with root package name */
    public int f1419e;

    /* renamed from: f  reason: collision with root package name */
    public String f1420f;

    /* renamed from: g  reason: collision with root package name */
    public volatile String f1421g;

    /* renamed from: h  reason: collision with root package name */
    public Context f1422h;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ byte[] f1423e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f1424f;

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
            this.f1424f = cVar;
            this.f1423e = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Bitmap a = new p(this.f1424f.f1422h).a(this.f1424f.j(this.f1423e, this.f1424f.f1419e, this.f1424f.f1418d), this.f1424f.f1418d, this.f1424f.f1419e);
                    this.f1424f.f1421g = this.f1424f.b(a);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2139849030, "Lc/a/a1/p/e/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2139849030, "Lc/a/a1/p/e/c;");
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
        this.a = 0;
        this.f1416b = -1;
        this.f1422h = context;
    }

    public final String b(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmap)) == null) {
            File file = new File(new File(this.f1420f), "samplecover.dat");
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
            this.f1418d = i2;
            this.f1419e = i3;
            this.f1420f = str;
            this.f1417c = z;
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
                byte[] bArr = new byte[f1415i];
                randomAccessFile.read(bArr, 0, f1415i);
                byte[] m = m(bArr);
                randomAccessFile.seek(0L);
                randomAccessFile.write(m, 0, f1415i);
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
            if (this.f1416b > 0 && this.f1417c && this.a == this.f1416b) {
                byte[] bArr2 = new byte[bArr.length];
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    bArr2[i2] = bArr[i2];
                }
                new Thread(new a(this, bArr2), "yuvtobitmap").start();
            }
            this.a++;
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
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f1416b >= 0) {
            return;
        }
        this.f1416b = new Random().nextInt(240);
    }

    public final byte[] m(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bArr)) == null) {
            int i2 = f1415i;
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
