package c.a.a0.b.a;

import com.baidu.minivideo.effect.core.Rotation;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final float[] f1834a;

    /* renamed from: b  reason: collision with root package name */
    public static final float[] f1835b;

    /* renamed from: c  reason: collision with root package name */
    public static final float[] f1836c;

    /* renamed from: d  reason: collision with root package name */
    public static final float[] f1837d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f1838a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1947934646, "Lc/a/a0/b/a/i$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1947934646, "Lc/a/a0/b/a/i$a;");
                    return;
                }
            }
            int[] iArr = new int[Rotation.values().length];
            f1838a = iArr;
            try {
                iArr[Rotation.ROTATION_90.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1838a[Rotation.ROTATION_180.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1838a[Rotation.ROTATION_270.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1838a[Rotation.NORMAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(11380839, "Lc/a/a0/b/a/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(11380839, "Lc/a/a0/b/a/i;");
                return;
            }
        }
        f1834a = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        f1835b = new float[]{1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};
        f1836c = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
        f1837d = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    }

    public static float a(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65537, null, f2)) == null) ? f2 == 0.0f ? 1.0f : 0.0f : invokeF.floatValue;
    }

    public static float[] b(Rotation rotation, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        float[] fArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{rotation, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int i2 = a.f1838a[rotation.ordinal()];
            if (i2 == 1) {
                fArr = f1835b;
            } else if (i2 == 2) {
                fArr = f1836c;
            } else if (i2 != 3) {
                fArr = f1834a;
            } else {
                fArr = f1837d;
            }
            if (z) {
                fArr = new float[]{a(fArr[0]), fArr[1], a(fArr[2]), fArr[3], a(fArr[4]), fArr[5], a(fArr[6]), fArr[7]};
            }
            return z2 ? new float[]{fArr[0], a(fArr[1]), fArr[2], a(fArr[3]), fArr[4], a(fArr[5]), fArr[6], a(fArr[7])} : fArr;
        }
        return (float[]) invokeCommon.objValue;
    }
}
