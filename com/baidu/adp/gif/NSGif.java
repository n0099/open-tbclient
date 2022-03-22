package com.baidu.adp.gif;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.h;
import c.a.d.f.p.j;
import c.a.d.f.p.k;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class NSGif implements c.a.d.d.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final String f23808e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f23809f;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public final int f23810b;

    /* renamed from: c  reason: collision with root package name */
    public final int f23811c;

    /* renamed from: d  reason: collision with root package name */
    public final int f23812d;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NSGif f23813b;

        public a(NSGif nSGif, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nSGif, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23813b = nSGif;
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NSGif.nativeDestroy(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.d.f.p.k
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                NSGif.f23809f = z;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-109840841, "Lcom/baidu/adp/gif/NSGif;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-109840841, "Lcom/baidu/adp/gif/NSGif;");
                return;
            }
        }
        f23808e = BdBaseApplication.getInst().getCacheDir().getAbsolutePath();
        f23809f = j.d().i("nsgif_jni", 2, new b());
    }

    public NSGif(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = j;
        this.f23810b = nativeGetWidth(j);
        this.f23811c = nativeGetHeight(j);
        this.f23812d = nativeGetFrameCount(j);
    }

    public static NSGif e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            long nativeCreate = nativeCreate(f23808e, str);
            if (nativeCreate != 0) {
                return new NSGif(nativeCreate);
            }
            return null;
        }
        return (NSGif) invokeL.objValue;
    }

    public static NSGif f(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i, i2)) == null) {
            long nativeCreate = nativeCreate(f23808e, bArr, i, i2);
            if (nativeCreate != 0) {
                return new NSGif(nativeCreate);
            }
            return null;
        }
        return (NSGif) invokeLII.objValue;
    }

    public static native long nativeCreate(String str, String str2);

    public static native long nativeCreate(String str, byte[] bArr, int i, int i2);

    public static native boolean nativeDecodeFrame(long j, int i);

    public static native int nativeDestroy(long j);

    public static native int nativeGetCurrentFrame(long j);

    public static native int nativeGetFrameCount(long j);

    public static native int nativeGetFrameDelay(long j, int i);

    public static native int nativeGetHeight(long j);

    public static native int nativeGetWidth(long j);

    public static native boolean nativeWriteTo(long j, Bitmap bitmap);

    @Override // c.a.d.d.b
    public boolean a(Bitmap bitmap, Canvas canvas) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bitmap, canvas)) == null) {
            if (bitmap == null) {
                return false;
            }
            return nativeWriteTo(this.a, bitmap);
        }
        return invokeLL.booleanValue;
    }

    @Override // c.a.d.d.b
    public int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            int nativeGetFrameDelay = nativeGetFrameDelay(this.a, i);
            if (nativeGetFrameDelay <= 0) {
                return 100;
            }
            return nativeGetFrameDelay * 10;
        }
        return invokeI.intValue;
    }

    @Override // c.a.d.d.b
    public boolean c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? nativeDecodeFrame(this.a, i) : invokeI.booleanValue;
    }

    @Override // c.a.d.d.b
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            long j = this.a;
            if (j == 0) {
                return;
            }
            this.a = 0L;
            h.a().c(new a(this, j));
        }
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                close();
                super.finalize();
            } catch (Exception unused) {
            }
        }
    }

    @Override // c.a.d.d.b
    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f23812d : invokeV.intValue;
    }

    @Override // c.a.d.d.b
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f23811c : invokeV.intValue;
    }

    @Override // c.a.d.d.b
    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f23810b : invokeV.intValue;
    }
}
