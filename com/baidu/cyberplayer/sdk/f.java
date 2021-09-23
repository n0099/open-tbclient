package com.baidu.cyberplayer.sdk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f39130a;

    /* renamed from: b  reason: collision with root package name */
    public int f39131b;

    /* renamed from: c  reason: collision with root package name */
    public int f39132c;

    /* renamed from: d  reason: collision with root package name */
    public int f39133d;

    /* renamed from: e  reason: collision with root package name */
    public int f39134e;

    /* renamed from: f  reason: collision with root package name */
    public int f39135f;

    /* renamed from: g  reason: collision with root package name */
    public int f39136g;

    /* renamed from: h  reason: collision with root package name */
    public int f39137h;

    /* renamed from: i  reason: collision with root package name */
    public int f39138i;

    /* renamed from: j  reason: collision with root package name */
    public int f39139j;
    public float[] k;
    public float[] l;

    public f() {
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
        this.f39130a = 0;
        this.f39131b = 0;
        this.f39132c = 1;
        this.f39133d = 1;
        this.f39134e = 0;
        this.f39135f = 0;
        this.f39136g = 0;
        this.f39137h = 0;
        this.f39138i = 0;
        this.f39139j = 0;
        this.k = r3;
        float[] fArr = {1.0f, 1.0f};
        this.l = r3;
        float[] fArr2 = {0.0f, 0.0f};
        this.f39139j = 2;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f39130a = 0;
            this.f39131b = 0;
            this.f39132c = 1;
            this.f39133d = 1;
            this.f39134e = 0;
            this.f39135f = 0;
            this.f39136g = 0;
            this.f39137h = 0;
            this.f39138i = 0;
            float[] fArr = this.k;
            fArr[0] = 1.0f;
            fArr[1] = 1.0f;
            this.f39139j = 2;
        }
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (this.f39135f != i2) {
                this.f39135f = i2;
                this.f39136g = ((this.f39134e + 360) - i2) % 360;
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) == null) {
            if (this.f39130a == i2 && this.f39131b == i3) {
                return false;
            }
            this.f39130a = i2;
            this.f39131b = i3;
            return true;
        }
        return invokeII.booleanValue;
    }

    public boolean a(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048579, this, i2, i3, i4, i5)) == null) {
            if (this.f39137h == i2 && i3 == this.f39138i && this.f39132c == i4 && this.f39133d == i5) {
                return false;
            }
            this.f39137h = i2;
            this.f39138i = i3;
            if (i5 == 0 || i4 == 0) {
                this.f39132c = 1;
                this.f39133d = 1;
            } else {
                this.f39132c = i4;
                this.f39133d = i5;
            }
            return true;
        }
        return invokeIIII.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c0, code lost:
        if (r5 > r3) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0104, code lost:
        if (0.5625f > r3) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x010b, code lost:
        if (0.75f > r3) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0113, code lost:
        if (0.8f > r3) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0115, code lost:
        r3 = r3 / r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0117, code lost:
        r5 = r0 / r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x011c, code lost:
        if (r5 > r3) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0125, code lost:
        if (r5 > r3) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011f A[PHI: r4 r7 
      PHI: (r4v1 float) = (r4v0 float), (r4v6 float) binds: [B:33:0x00bb, B:72:0x012a] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r7v3 float) = (r7v2 float), (r7v5 float) binds: [B:33:0x00bb, B:72:0x012a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        int i2;
        float f2;
        int i3;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f39130a == 0 || this.f39131b == 0 || this.f39137h == 0 || this.f39138i == 0) {
            return;
        }
        int i4 = this.f39139j;
        boolean z = i4 == 0 || i4 == 2;
        float f8 = 1.0f;
        float f9 = (this.f39131b * 1.0f) / this.f39130a;
        float f10 = (this.f39138i * 1.0f) / this.f39137h;
        int i5 = this.f39136g;
        if ((i5 != 90 && i5 != 270) || (i2 = this.f39138i) == 0) {
            if (z) {
                f2 = this.f39133d * 1.0f;
                i3 = this.f39132c;
                f10 *= f2 / i3;
            }
            CyberLog.d("CyberRenderSizeHelper", "updateDisplaySize called mVideoWidth:" + this.f39137h + " mVideoHeight:" + this.f39138i + " mVideoSarNum:" + this.f39132c + " mVideoSarDen:" + this.f39133d + " mSurfaceWidth:" + this.f39130a + " mSurfaceHeight:" + this.f39131b + " mDisplayMode:" + this.f39139j);
            float f11 = 0.0f;
            switch (this.f39139j) {
            }
            float[] fArr = this.k;
            fArr[0] = f8;
            fArr[1] = f4;
            float[] fArr2 = this.l;
            fArr2[0] = f11;
            fArr2[1] = f3;
            CyberLog.d("CyberRenderSizeHelper", "updateDisplaySize called sx:" + f8 + " sy:" + f4 + " translateX:" + f11 + " translateY:" + f3);
        }
        f10 = (this.f39137h * 1.0f) / i2;
        if (z) {
            f2 = this.f39132c * 1.0f;
            i3 = this.f39133d;
            f10 *= f2 / i3;
        }
        CyberLog.d("CyberRenderSizeHelper", "updateDisplaySize called mVideoWidth:" + this.f39137h + " mVideoHeight:" + this.f39138i + " mVideoSarNum:" + this.f39132c + " mVideoSarDen:" + this.f39133d + " mSurfaceWidth:" + this.f39130a + " mSurfaceHeight:" + this.f39131b + " mDisplayMode:" + this.f39139j);
        float f112 = 0.0f;
        switch (this.f39139j) {
            case 1:
                f3 = 0.0f;
                f4 = 1.0f;
                break;
            case 3:
                f5 = 0.8f;
                break;
            case 4:
                f5 = 0.75f;
                break;
            case 5:
                f5 = 0.5625f;
                break;
            case 6:
                float f12 = (this.f39137h * 1.0f) / this.f39130a;
                f4 = (this.f39138i * 1.0f) / this.f39131b;
                f8 = f12;
                f3 = 0.0f;
                break;
            case 7:
                if (f10 <= f9) {
                    f6 = f9 / f10;
                    f7 = 1.0f - f6;
                    f112 = f7;
                    f8 = f6;
                    f3 = 0.0f;
                    f4 = 1.0f;
                    break;
                }
                f4 = f10 / f9;
                f3 = 0.0f;
                break;
            case 8:
                if (f10 <= f9) {
                    f6 = f9 / f10;
                    f7 = f6 - 1.0f;
                    f112 = f7;
                    f8 = f6;
                    f3 = 0.0f;
                    f4 = 1.0f;
                    break;
                }
                f4 = f10 / f9;
                f3 = 0.0f;
                break;
            case 9:
                if (f10 > f9) {
                    f4 = f10 / f9;
                    f3 = f4 - 1.0f;
                    break;
                }
                f6 = f9 / f10;
                f8 = f6;
                f3 = 0.0f;
                f4 = 1.0f;
                break;
            case 10:
                if (f10 > f9) {
                    f4 = f10 / f9;
                    f3 = 1.0f - f4;
                    break;
                }
                f6 = f9 / f10;
                f8 = f6;
                f3 = 0.0f;
                f4 = 1.0f;
                break;
        }
        float[] fArr3 = this.k;
        fArr3[0] = f8;
        fArr3[1] = f4;
        float[] fArr22 = this.l;
        fArr22[0] = f112;
        fArr22[1] = f3;
        CyberLog.d("CyberRenderSizeHelper", "updateDisplaySize called sx:" + f8 + " sy:" + f4 + " translateX:" + f112 + " translateY:" + f3);
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (this.f39134e != i2) {
                this.f39134e = i2;
                this.f39136g = ((360 - this.f39135f) + i2) % 360;
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (this.f39139j != i2) {
                this.f39139j = i2;
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public float[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : (float[]) invokeV.objValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f39139j : invokeV.intValue;
    }

    public float[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.l : (float[]) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i2 = this.f39139j;
            return i2 == 7 || i2 == 8 || i2 == 9 || i2 == 10;
        }
        return invokeV.booleanValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f39136g : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f39137h : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f39138i : invokeV.intValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f39130a : invokeV.intValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f39131b : invokeV.intValue;
    }
}
