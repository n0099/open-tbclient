package com.baidu.cyberplayer.sdk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public float[] k;
    public float[] l;

    public f() {
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
        this.a = 0;
        this.b = 0;
        this.c = 1;
        this.d = 1;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = r3;
        float[] fArr = {1.0f, 1.0f};
        this.l = r3;
        float[] fArr2 = {0.0f, 0.0f};
        this.j = 2;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = 0;
            this.b = 0;
            this.c = 1;
            this.d = 1;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            float[] fArr = this.k;
            fArr[0] = 1.0f;
            fArr[1] = 1.0f;
            this.j = 2;
        }
    }

    public boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (this.f != i) {
                this.f = i;
                this.g = ((this.e + 360) - i) % 360;
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2)) == null) {
            if (this.a == i && this.b == i2) {
                return false;
            }
            this.a = i;
            this.b = i2;
            return true;
        }
        return invokeII.booleanValue;
    }

    public boolean a(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048579, this, i, i2, i3, i4)) == null) {
            if (this.h == i && i2 == this.i && this.c == i3 && this.d == i4) {
                return false;
            }
            this.h = i;
            this.i = i2;
            if (i4 == 0 || i3 == 0) {
                this.c = 1;
                this.d = 1;
            } else {
                this.c = i3;
                this.d = i4;
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
        int i;
        float f;
        int i2;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a == 0 || this.b == 0 || this.h == 0 || this.i == 0) {
            return;
        }
        int i3 = this.j;
        boolean z = i3 == 0 || i3 == 2;
        float f7 = 1.0f;
        float f8 = (this.b * 1.0f) / this.a;
        float f9 = (this.i * 1.0f) / this.h;
        int i4 = this.g;
        if ((i4 != 90 && i4 != 270) || (i = this.i) == 0) {
            if (z) {
                f = this.d * 1.0f;
                i2 = this.c;
                f9 *= f / i2;
            }
            CyberLog.d("CyberRenderSizeHelper", "updateDisplaySize called mVideoWidth:" + this.h + " mVideoHeight:" + this.i + " mVideoSarNum:" + this.c + " mVideoSarDen:" + this.d + " mSurfaceWidth:" + this.a + " mSurfaceHeight:" + this.b + " mDisplayMode:" + this.j);
            float f10 = 0.0f;
            switch (this.j) {
            }
            float[] fArr = this.k;
            fArr[0] = f7;
            fArr[1] = f3;
            float[] fArr2 = this.l;
            fArr2[0] = f10;
            fArr2[1] = f2;
            CyberLog.d("CyberRenderSizeHelper", "updateDisplaySize called sx:" + f7 + " sy:" + f3 + " translateX:" + f10 + " translateY:" + f2);
        }
        f9 = (this.h * 1.0f) / i;
        if (z) {
            f = this.c * 1.0f;
            i2 = this.d;
            f9 *= f / i2;
        }
        CyberLog.d("CyberRenderSizeHelper", "updateDisplaySize called mVideoWidth:" + this.h + " mVideoHeight:" + this.i + " mVideoSarNum:" + this.c + " mVideoSarDen:" + this.d + " mSurfaceWidth:" + this.a + " mSurfaceHeight:" + this.b + " mDisplayMode:" + this.j);
        float f102 = 0.0f;
        switch (this.j) {
            case 1:
                f2 = 0.0f;
                f3 = 1.0f;
                break;
            case 3:
                f4 = 0.8f;
                break;
            case 4:
                f4 = 0.75f;
                break;
            case 5:
                f4 = 0.5625f;
                break;
            case 6:
                float f11 = (this.h * 1.0f) / this.a;
                f3 = (this.i * 1.0f) / this.b;
                f7 = f11;
                f2 = 0.0f;
                break;
            case 7:
                if (f9 <= f8) {
                    f5 = f8 / f9;
                    f6 = 1.0f - f5;
                    f102 = f6;
                    f7 = f5;
                    f2 = 0.0f;
                    f3 = 1.0f;
                    break;
                }
                f3 = f9 / f8;
                f2 = 0.0f;
                break;
            case 8:
                if (f9 <= f8) {
                    f5 = f8 / f9;
                    f6 = f5 - 1.0f;
                    f102 = f6;
                    f7 = f5;
                    f2 = 0.0f;
                    f3 = 1.0f;
                    break;
                }
                f3 = f9 / f8;
                f2 = 0.0f;
                break;
            case 9:
                if (f9 > f8) {
                    f3 = f9 / f8;
                    f2 = f3 - 1.0f;
                    break;
                }
                f5 = f8 / f9;
                f7 = f5;
                f2 = 0.0f;
                f3 = 1.0f;
                break;
            case 10:
                if (f9 > f8) {
                    f3 = f9 / f8;
                    f2 = 1.0f - f3;
                    break;
                }
                f5 = f8 / f9;
                f7 = f5;
                f2 = 0.0f;
                f3 = 1.0f;
                break;
        }
        float[] fArr3 = this.k;
        fArr3[0] = f7;
        fArr3[1] = f3;
        float[] fArr22 = this.l;
        fArr22[0] = f102;
        fArr22[1] = f2;
        CyberLog.d("CyberRenderSizeHelper", "updateDisplaySize called sx:" + f7 + " sy:" + f3 + " translateX:" + f102 + " translateY:" + f2);
    }

    public boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (this.e != i) {
                this.e = i;
                this.g = ((360 - this.f) + i) % 360;
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (this.j != i) {
                this.j = i;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j : invokeV.intValue;
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
            int i = this.j;
            return i == 7 || i == 8 || i == 9 || i == 10;
        }
        return invokeV.booleanValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.g : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.h : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.i : invokeV.intValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.a : invokeV.intValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.b : invokeV.intValue;
    }
}
