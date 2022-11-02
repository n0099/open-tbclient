package com.baidu.adp.gif;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ch;
import com.baidu.tieba.dc;
import com.baidu.tieba.ui;
import com.baidu.tieba.vi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class NSGif implements dc {
    public static /* synthetic */ Interceptable $ic;
    public static final String e;
    public static boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public final int b;
    public final int c;
    public final int d;

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

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ NSGif b;

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
            this.b = nSGif;
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            NSGif.nativeDestroy(this.a);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends vi {
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

        @Override // com.baidu.tieba.vi
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                NSGif.f = z;
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
        e = BdBaseApplication.getInst().getCacheDir().getAbsolutePath();
        f = ui.d().i("nsgif_jni", 2, new b());
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
        this.b = nativeGetWidth(j);
        this.c = nativeGetHeight(j);
        this.d = nativeGetFrameCount(j);
    }

    public static NSGif e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            long nativeCreate = nativeCreate(e, str);
            if (nativeCreate != 0) {
                return new NSGif(nativeCreate);
            }
            return null;
        }
        return (NSGif) invokeL.objValue;
    }

    @Override // com.baidu.tieba.dc
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

    @Override // com.baidu.tieba.dc
    public boolean c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return nativeDecodeFrame(this.a, i);
        }
        return invokeI.booleanValue;
    }

    public static NSGif f(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i, i2)) == null) {
            long nativeCreate = nativeCreate(e, bArr, i, i2);
            if (nativeCreate != 0) {
                return new NSGif(nativeCreate);
            }
            return null;
        }
        return (NSGif) invokeLII.objValue;
    }

    @Override // com.baidu.tieba.dc
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

    @Override // com.baidu.tieba.dc
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            long j = this.a;
            if (j == 0) {
                return;
            }
            this.a = 0L;
            ch.a().c(new a(this, j));
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

    @Override // com.baidu.tieba.dc
    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.dc
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.dc
    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }
}
