package c.a.v0.l;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.RecordConstants;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.v0.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1605a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f21668b;

        public C1605a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.f21668b = i2;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f21668b : invokeV.intValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : invokeV.intValue;
        }
    }

    public static int[] a(float f2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Float.valueOf(f2), Integer.valueOf(i)})) == null) {
            int[] iArr = new int[2];
            if (f2 > 1.0f) {
                iArr[0] = i;
                iArr[1] = (int) (i * f2);
                int i2 = iArr[1] % 16;
                if (i2 > 8) {
                    iArr[1] = iArr[1] + (16 - i2);
                } else {
                    iArr[1] = iArr[1] - i2;
                }
            } else {
                iArr[1] = i;
                iArr[0] = (int) (i * (1.0f / f2));
                int i3 = iArr[0] % 16;
                if (i3 > 8) {
                    iArr[0] = iArr[0] + (16 - i3);
                } else {
                    iArr[0] = iArr[0] - i3;
                }
            }
            return iArr;
        }
        return (int[]) invokeCommon.objValue;
    }

    public static int[] b(float f2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            int[] iArr = new int[2];
            if (i > i2) {
                int i3 = (f2 > 1.0f ? 1 : (f2 == 1.0f ? 0 : -1));
                if (i3 == 0) {
                    iArr[0] = c(i);
                    iArr[1] = c(i);
                    return iArr;
                }
                if (i3 > 0) {
                    iArr[1] = i;
                    iArr[0] = (int) (i * (1.0f / f2));
                } else {
                    iArr[1] = i2;
                    iArr[0] = (int) (i2 * (1.0f / f2));
                }
                iArr[0] = c(iArr[0]);
            } else {
                int i4 = (f2 > 1.0f ? 1 : (f2 == 1.0f ? 0 : -1));
                if (i4 == 0) {
                    iArr[0] = c(i2);
                    iArr[1] = c(i2);
                    return iArr;
                }
                if (i4 > 0) {
                    iArr[0] = i;
                    iArr[1] = (int) (i * f2);
                } else {
                    iArr[0] = i2;
                    iArr[1] = (int) (i2 * f2);
                }
                iArr[1] = c(iArr[1]);
            }
            return iArr;
        }
        return (int[]) invokeCommon.objValue;
    }

    public static int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            int i2 = i % 16;
            return i2 > 8 ? i + (16 - i2) : i - i2;
        }
        return invokeI.intValue;
    }

    public static C1605a d(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i, i2)) == null) {
            if (i > 1920 || i2 > 1920) {
                int[] a = a(i2 / i, RecordConstants.VIDEO_CONSTANT_WIDTH);
                return new C1605a(a[0], a[1]);
            }
            return new C1605a(i, i2);
        }
        return (C1605a) invokeII.objValue;
    }

    public static C1605a e(float f2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Float.valueOf(f2), Integer.valueOf(i)})) == null) {
            if (f2 <= 0.0f) {
                return new C1605a(RecordConstants.VIDEO_CONSTANT_WIDTH, RecordConstants.VIDEO_CONSTANT_HEIGHT);
            }
            int[] a = a(f2, i);
            return new C1605a(a[0], a[1]);
        }
        return (C1605a) invokeCommon.objValue;
    }

    public static C1605a f(float f2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (f2 <= 0.0f) {
                return new C1605a(RecordConstants.VIDEO_CONSTANT_WIDTH, RecordConstants.VIDEO_CONSTANT_HEIGHT);
            }
            int[] b2 = b(f2, i, i2);
            return new C1605a(b2[0], b2[1]);
        }
        return (C1605a) invokeCommon.objValue;
    }

    public static boolean g(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65542, null, i, i2)) == null) ? i > 1920 || i2 > 1920 : invokeII.booleanValue;
    }
}
