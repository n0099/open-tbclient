package c.a.v0.l;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.RecordConstants;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.v0.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1412a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f30335a;

        /* renamed from: b  reason: collision with root package name */
        public final int f30336b;

        public C1412a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30335a = i2;
            this.f30336b = i3;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30336b : invokeV.intValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f30335a : invokeV.intValue;
        }
    }

    public static int[] a(float f2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)})) == null) {
            int[] iArr = new int[2];
            if (f2 > 1.0f) {
                iArr[0] = i2;
                iArr[1] = (int) (i2 * f2);
                int i3 = iArr[1] % 16;
                if (i3 > 8) {
                    iArr[1] = iArr[1] + (16 - i3);
                } else {
                    iArr[1] = iArr[1] - i3;
                }
            } else {
                iArr[1] = i2;
                iArr[0] = (int) (i2 * (1.0f / f2));
                int i4 = iArr[0] % 16;
                if (i4 > 8) {
                    iArr[0] = iArr[0] + (16 - i4);
                } else {
                    iArr[0] = iArr[0] - i4;
                }
            }
            return iArr;
        }
        return (int[]) invokeCommon.objValue;
    }

    public static int[] b(float f2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            int[] iArr = new int[2];
            if (i2 > i3) {
                int i4 = (f2 > 1.0f ? 1 : (f2 == 1.0f ? 0 : -1));
                if (i4 == 0) {
                    iArr[0] = c(i2);
                    iArr[1] = c(i2);
                    return iArr;
                }
                if (i4 > 0) {
                    iArr[1] = i2;
                    iArr[0] = (int) (i2 * (1.0f / f2));
                } else {
                    iArr[1] = i3;
                    iArr[0] = (int) (i3 * (1.0f / f2));
                }
                iArr[0] = c(iArr[0]);
            } else {
                int i5 = (f2 > 1.0f ? 1 : (f2 == 1.0f ? 0 : -1));
                if (i5 == 0) {
                    iArr[0] = c(i3);
                    iArr[1] = c(i3);
                    return iArr;
                }
                if (i5 > 0) {
                    iArr[0] = i2;
                    iArr[1] = (int) (i2 * f2);
                } else {
                    iArr[0] = i3;
                    iArr[1] = (int) (i3 * f2);
                }
                iArr[1] = c(iArr[1]);
            }
            return iArr;
        }
        return (int[]) invokeCommon.objValue;
    }

    public static int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            int i3 = i2 % 16;
            return i3 > 8 ? i2 + (16 - i3) : i2 - i3;
        }
        return invokeI.intValue;
    }

    public static C1412a d(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) {
            if (i2 > 1920 || i3 > 1920) {
                int[] a2 = a(i3 / i2, RecordConstants.VIDEO_CONSTANT_WIDTH);
                return new C1412a(a2[0], a2[1]);
            }
            return new C1412a(i2, i3);
        }
        return (C1412a) invokeII.objValue;
    }

    public static C1412a e(float f2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)})) == null) {
            if (f2 <= 0.0f) {
                return new C1412a(RecordConstants.VIDEO_CONSTANT_WIDTH, RecordConstants.VIDEO_CONSTANT_HEIGHT);
            }
            int[] a2 = a(f2, i2);
            return new C1412a(a2[0], a2[1]);
        }
        return (C1412a) invokeCommon.objValue;
    }

    public static C1412a f(float f2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (f2 <= 0.0f) {
                return new C1412a(RecordConstants.VIDEO_CONSTANT_WIDTH, RecordConstants.VIDEO_CONSTANT_HEIGHT);
            }
            int[] b2 = b(f2, i2, i3);
            return new C1412a(b2[0], b2[1]);
        }
        return (C1412a) invokeCommon.objValue;
    }

    public static boolean g(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(AdIconUtil.BAIDU_LOGO_ID, null, i2, i3)) == null) ? i2 > 1920 || i3 > 1920 : invokeII.booleanValue;
    }
}
