package b.a.x.b.h;

import android.opengl.Matrix;
import androidx.core.view.InputDeviceCompat;
import b.a.x.b.f.c;
import b.a.x.b.f.d;
import com.baidu.mario.gldraw2d.params.MirrorType;
import com.baidu.mario.gldraw2d.params.ScaleType;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30286a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(404114702, "Lb/a/x/b/h/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(404114702, "Lb/a/x/b/h/b$a;");
                    return;
                }
            }
            int[] iArr = new int[ScaleType.values().length];
            f30286a = iArr;
            try {
                iArr[ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30286a[ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30286a[ScaleType.CENTER_CROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30286a[ScaleType.EQUAL_SCALE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-249858517, "Lb/a/x/b/h/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-249858517, "Lb/a/x/b/h/b;");
        }
    }

    public static void a(float[] fArr, MirrorType mirrorType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, fArr, mirrorType) == null) {
            if (mirrorType == MirrorType.HORIZONTALLY) {
                Matrix.rotateM(fArr, 0, 180.0f, 0.0f, 1.0f, 0.0f);
            } else if (mirrorType == MirrorType.VERTICALLY) {
                Matrix.rotateM(fArr, 0, 180.0f, 1.0f, 0.0f, 0.0f);
                fArr[6] = 0.0f;
                fArr[9] = 0.0f;
            }
        }
    }

    public static void b(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, fArr) == null) {
            Matrix.setIdentityM(fArr, 0);
        }
    }

    public static void c(float[] fArr, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65539, null, fArr, f2) == null) {
            Matrix.rotateM(fArr, 0, f2, 0.0f, 0.0f, 1.0f);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
        if (r0 > r5) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005f, code lost:
        if (r0 > r5) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0061, code lost:
        r5 = r5 / r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0065, code lost:
        r8 = r0 / r5;
        r5 = 1.0f;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(float[] fArr, d dVar, c cVar, ScaleType scaleType, float f2) {
        float f3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{fArr, dVar, cVar, scaleType, Float.valueOf(f2)}) == null) || fArr == null || dVar == null || dVar.e() <= 0 || dVar.b() <= 0 || cVar == null || cVar.c() <= 0 || cVar.b() <= 0) {
            return;
        }
        float e2 = (dVar.e() * 1.0f) / dVar.b();
        float c2 = (cVar.c() * 1.0f) / cVar.b();
        int i2 = a.f30286a[scaleType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        f3 = f2;
                    }
                }
            }
            Matrix.scaleM(fArr, 0, f2, f3, 1.0f);
        }
        f3 = 1.0f;
        f2 = 1.0f;
        Matrix.scaleM(fArr, 0, f2, f3, 1.0f);
    }

    public static void e(float[] fArr, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{fArr, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            Matrix.translateM(fArr, 0, f2, f3, 1.0f);
        }
    }
}
