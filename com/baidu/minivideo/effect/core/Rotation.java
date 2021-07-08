package com.baidu.minivideo.effect.core;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class Rotation {
    public static final /* synthetic */ Rotation[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final Rotation NORMAL;
    public static final Rotation ROTATION_180;
    public static final Rotation ROTATION_270;
    public static final Rotation ROTATION_90;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f8177a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(730265909, "Lcom/baidu/minivideo/effect/core/Rotation$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(730265909, "Lcom/baidu/minivideo/effect/core/Rotation$a;");
                    return;
                }
            }
            int[] iArr = new int[Rotation.values().length];
            f8177a = iArr;
            try {
                iArr[Rotation.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8177a[Rotation.ROTATION_90.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8177a[Rotation.ROTATION_180.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8177a[Rotation.ROTATION_270.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1632043026, "Lcom/baidu/minivideo/effect/core/Rotation;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1632043026, "Lcom/baidu/minivideo/effect/core/Rotation;");
                return;
            }
        }
        NORMAL = new Rotation("NORMAL", 0);
        ROTATION_90 = new Rotation("ROTATION_90", 1);
        ROTATION_180 = new Rotation("ROTATION_180", 2);
        Rotation rotation = new Rotation("ROTATION_270", 3);
        ROTATION_270 = rotation;
        $VALUES = new Rotation[]{NORMAL, ROTATION_90, ROTATION_180, rotation};
    }

    public Rotation(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Rotation fromInt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 90) {
                    if (i2 != 180) {
                        if (i2 != 270) {
                            if (i2 == 360) {
                                return NORMAL;
                            }
                            throw new IllegalStateException(i2 + " is an unknown rotation. Needs to be either 0, 90, 180 or 270!");
                        }
                        return ROTATION_270;
                    }
                    return ROTATION_180;
                }
                return ROTATION_90;
            }
            return NORMAL;
        }
        return (Rotation) invokeI.objValue;
    }

    public static Rotation valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (Rotation) Enum.valueOf(Rotation.class, str) : (Rotation) invokeL.objValue;
    }

    public static Rotation[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (Rotation[]) $VALUES.clone() : (Rotation[]) invokeV.objValue;
    }

    public int asInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = a.f8177a[ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            return 270;
                        }
                        throw new IllegalStateException("Unknown Rotation!");
                    }
                    return 180;
                }
                return 90;
            }
            return 0;
        }
        return invokeV.intValue;
    }
}
