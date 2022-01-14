package com.baidu.cyberplayer.sdk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f33488b;

    /* renamed from: c  reason: collision with root package name */
    public int f33489c;

    /* renamed from: d  reason: collision with root package name */
    public int f33490d;

    /* renamed from: e  reason: collision with root package name */
    public int f33491e;

    /* renamed from: f  reason: collision with root package name */
    public int f33492f;

    /* renamed from: g  reason: collision with root package name */
    public int f33493g;

    /* renamed from: h  reason: collision with root package name */
    public int f33494h;

    /* renamed from: i  reason: collision with root package name */
    public int f33495i;

    /* renamed from: j  reason: collision with root package name */
    public int f33496j;
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
        this.a = 0;
        this.f33488b = 0;
        this.f33489c = 1;
        this.f33490d = 1;
        this.f33491e = 0;
        this.f33492f = 0;
        this.f33493g = 0;
        this.f33494h = 0;
        this.f33495i = 0;
        this.f33496j = 0;
        this.k = r3;
        float[] fArr = {1.0f, 1.0f};
        this.l = r3;
        float[] fArr2 = {0.0f, 0.0f};
        this.f33496j = 2;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = 0;
            this.f33488b = 0;
            this.f33489c = 1;
            this.f33490d = 1;
            this.f33491e = 0;
            this.f33492f = 0;
            this.f33493g = 0;
            this.f33494h = 0;
            this.f33495i = 0;
            float[] fArr = this.k;
            fArr[0] = 1.0f;
            fArr[1] = 1.0f;
            this.f33496j = 2;
        }
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (this.f33492f != i2) {
                this.f33492f = i2;
                this.f33493g = ((this.f33491e + 360) - i2) % 360;
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
            if (this.a == i2 && this.f33488b == i3) {
                return false;
            }
            this.a = i2;
            this.f33488b = i3;
            return true;
        }
        return invokeII.booleanValue;
    }

    public boolean a(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048579, this, i2, i3, i4, i5)) == null) {
            if (this.f33494h == i2 && i3 == this.f33495i && this.f33489c == i4 && this.f33490d == i5) {
                return false;
            }
            this.f33494h = i2;
            this.f33495i = i3;
            if (i5 == 0 || i4 == 0) {
                this.f33489c = 1;
                this.f33490d = 1;
            } else {
                this.f33489c = i4;
                this.f33490d = i5;
            }
            return true;
        }
        return invokeIIII.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bf, code lost:
        if (r5 > r3) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0103, code lost:
        if (0.5625f > r3) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x010a, code lost:
        if (0.75f > r3) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0112, code lost:
        if (0.8f > r3) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0114, code lost:
        r3 = r3 / r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0116, code lost:
        r5 = r0 / r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x011b, code lost:
        if (r5 > r3) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0124, code lost:
        if (r5 > r3) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011e A[PHI: r4 r7 
      PHI: (r4v1 float) = (r4v0 float), (r4v6 float) binds: [B:33:0x00ba, B:72:0x0129] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r7v3 float) = (r7v2 float), (r7v5 float) binds: [B:33:0x00ba, B:72:0x0129] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0122  */
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.a == 0 || this.f33488b == 0 || this.f33494h == 0 || this.f33495i == 0) {
            return;
        }
        int i4 = this.f33496j;
        boolean z = i4 == 0 || i4 == 2;
        float f8 = 1.0f;
        float f9 = (this.f33488b * 1.0f) / this.a;
        float f10 = (this.f33495i * 1.0f) / this.f33494h;
        int i5 = this.f33493g;
        if ((i5 != 90 && i5 != 270) || (i2 = this.f33495i) == 0) {
            if (z) {
                f2 = this.f33490d * 1.0f;
                i3 = this.f33489c;
                f10 *= f2 / i3;
            }
            CyberLog.d("CyberRenderSizeHelper", "updateDisplaySize called mVideoWidth:" + this.f33494h + " mVideoHeight:" + this.f33495i + " mVideoSarNum:" + this.f33489c + " mVideoSarDen:" + this.f33490d + " mSurfaceWidth:" + this.a + " mSurfaceHeight:" + this.f33488b + " mDisplayMode:" + this.f33496j);
            float f11 = 0.0f;
            switch (this.f33496j) {
            }
            float[] fArr = this.k;
            fArr[0] = f8;
            fArr[1] = f4;
            float[] fArr2 = this.l;
            fArr2[0] = f11;
            fArr2[1] = f3;
            CyberLog.d("CyberRenderSizeHelper", "updateDisplaySize called sx:" + f8 + " sy:" + f4 + " translateX:" + f11 + " translateY:" + f3);
        }
        f10 = (this.f33494h * 1.0f) / i2;
        if (z) {
            f2 = this.f33489c * 1.0f;
            i3 = this.f33490d;
            f10 *= f2 / i3;
        }
        CyberLog.d("CyberRenderSizeHelper", "updateDisplaySize called mVideoWidth:" + this.f33494h + " mVideoHeight:" + this.f33495i + " mVideoSarNum:" + this.f33489c + " mVideoSarDen:" + this.f33490d + " mSurfaceWidth:" + this.a + " mSurfaceHeight:" + this.f33488b + " mDisplayMode:" + this.f33496j);
        float f112 = 0.0f;
        switch (this.f33496j) {
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
                float f12 = (this.f33494h * 1.0f) / this.a;
                f4 = (this.f33495i * 1.0f) / this.f33488b;
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
            if (this.f33491e != i2) {
                this.f33491e = i2;
                this.f33493g = ((360 - this.f33492f) + i2) % 360;
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
            if (this.f33496j != i2) {
                this.f33496j = i2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f33496j : invokeV.intValue;
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
            int i2 = this.f33496j;
            return i2 == 7 || i2 == 8 || i2 == 9 || i2 == 10;
        }
        return invokeV.booleanValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f33493g : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f33494h : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f33495i : invokeV.intValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.a : invokeV.intValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f33488b : invokeV.intValue;
    }
}
