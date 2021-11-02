package com.baidu.adp.gif;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.h;
import b.a.e.e.p.i;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class NSGif implements b.a.e.d.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final String f34376e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f34377f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f34378a;

    /* renamed from: b  reason: collision with root package name */
    public final int f34379b;

    /* renamed from: c  reason: collision with root package name */
    public final int f34380c;

    /* renamed from: d  reason: collision with root package name */
    public final int f34381d;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f34382e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NSGif f34383f;

        public a(NSGif nSGif, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nSGif, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34383f = nSGif;
            this.f34382e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NSGif.nativeDestroy(this.f34382e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.e.e.p.i
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                NSGif.f34377f = z;
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
        f34376e = BdBaseApplication.getInst().getCacheDir().getAbsolutePath();
        f34377f = h.f().k("nsgif_jni", 2, new b());
    }

    public NSGif(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f34378a = i2;
        this.f34379b = nativeGetWidth(i2);
        this.f34380c = nativeGetHeight(i2);
        this.f34381d = nativeGetFrameCount(i2);
    }

    public static NSGif e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            int nativeCreate = nativeCreate(f34376e, str);
            if (nativeCreate != 0) {
                return new NSGif(nativeCreate);
            }
            return null;
        }
        return (NSGif) invokeL.objValue;
    }

    public static NSGif f(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i2, i3)) == null) {
            int nativeCreate = nativeCreate(f34376e, bArr, i2, i3);
            if (nativeCreate != 0) {
                return new NSGif(nativeCreate);
            }
            return null;
        }
        return (NSGif) invokeLII.objValue;
    }

    public static native int nativeCreate(String str, String str2);

    public static native int nativeCreate(String str, byte[] bArr, int i2, int i3);

    public static native boolean nativeDecodeFrame(int i2, int i3);

    public static native int nativeDestroy(int i2);

    public static native int nativeGetCurrentFrame(int i2);

    public static native int nativeGetFrameCount(int i2);

    public static native int nativeGetFrameDelay(int i2, int i3);

    public static native int nativeGetHeight(int i2);

    public static native int nativeGetWidth(int i2);

    public static native boolean nativeWriteTo(int i2, Bitmap bitmap);

    @Override // b.a.e.d.b
    public boolean a(Bitmap bitmap, Canvas canvas) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bitmap, canvas)) == null) {
            if (bitmap == null) {
                return false;
            }
            return nativeWriteTo(this.f34378a, bitmap);
        }
        return invokeLL.booleanValue;
    }

    @Override // b.a.e.d.b
    public int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            int nativeGetFrameDelay = nativeGetFrameDelay(this.f34378a, i2);
            if (nativeGetFrameDelay <= 0) {
                return 100;
            }
            return nativeGetFrameDelay * 10;
        }
        return invokeI.intValue;
    }

    @Override // b.a.e.d.b
    public boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? nativeDecodeFrame(this.f34378a, i2) : invokeI.booleanValue;
    }

    @Override // b.a.e.d.b
    public void close() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (i2 = this.f34378a) == 0) {
            return;
        }
        this.f34378a = 0;
        b.a.e.e.m.h.a().c(new a(this, i2));
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

    @Override // b.a.e.d.b
    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f34381d : invokeV.intValue;
    }

    @Override // b.a.e.d.b
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f34380c : invokeV.intValue;
    }

    @Override // b.a.e.d.b
    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f34379b : invokeV.intValue;
    }
}
