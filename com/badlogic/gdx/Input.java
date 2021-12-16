package com.badlogic.gdx;

import com.baidu.down.manage.DownloadConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public interface Input {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class OnscreenKeyboardType {
        public static final /* synthetic */ OnscreenKeyboardType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final OnscreenKeyboardType Default;
        public static final OnscreenKeyboardType Email;
        public static final OnscreenKeyboardType NumberPad;
        public static final OnscreenKeyboardType Password;
        public static final OnscreenKeyboardType PhonePad;
        public static final OnscreenKeyboardType URI;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-556092315, "Lcom/badlogic/gdx/Input$OnscreenKeyboardType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-556092315, "Lcom/badlogic/gdx/Input$OnscreenKeyboardType;");
                    return;
                }
            }
            Default = new OnscreenKeyboardType("Default", 0);
            NumberPad = new OnscreenKeyboardType("NumberPad", 1);
            PhonePad = new OnscreenKeyboardType("PhonePad", 2);
            Email = new OnscreenKeyboardType("Email", 3);
            Password = new OnscreenKeyboardType("Password", 4);
            OnscreenKeyboardType onscreenKeyboardType = new OnscreenKeyboardType(DownloadConstants.DownloadColumns.COLUMN_URI, 5);
            URI = onscreenKeyboardType;
            $VALUES = new OnscreenKeyboardType[]{Default, NumberPad, PhonePad, Email, Password, onscreenKeyboardType};
        }

        public OnscreenKeyboardType(String str, int i2) {
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

        public static OnscreenKeyboardType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (OnscreenKeyboardType) Enum.valueOf(OnscreenKeyboardType.class, str) : (OnscreenKeyboardType) invokeL.objValue;
        }

        public static OnscreenKeyboardType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (OnscreenKeyboardType[]) $VALUES.clone() : (OnscreenKeyboardType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class Orientation {
        public static final /* synthetic */ Orientation[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Orientation Landscape;
        public static final Orientation Portrait;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1553810795, "Lcom/badlogic/gdx/Input$Orientation;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1553810795, "Lcom/badlogic/gdx/Input$Orientation;");
                    return;
                }
            }
            Landscape = new Orientation("Landscape", 0);
            Orientation orientation = new Orientation("Portrait", 1);
            Portrait = orientation;
            $VALUES = new Orientation[]{Landscape, orientation};
        }

        public Orientation(String str, int i2) {
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

        public static Orientation valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Orientation) Enum.valueOf(Orientation.class, str) : (Orientation) invokeL.objValue;
        }

        public static Orientation[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Orientation[]) $VALUES.clone() : (Orientation[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class Peripheral {
        public static final /* synthetic */ Peripheral[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Peripheral Accelerometer;
        public static final Peripheral Compass;
        public static final Peripheral Gyroscope;
        public static final Peripheral HardwareKeyboard;
        public static final Peripheral MultitouchScreen;
        public static final Peripheral OnscreenKeyboard;
        public static final Peripheral Pressure;
        public static final Peripheral RotationVector;
        public static final Peripheral Vibrator;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2026912043, "Lcom/badlogic/gdx/Input$Peripheral;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2026912043, "Lcom/badlogic/gdx/Input$Peripheral;");
                    return;
                }
            }
            HardwareKeyboard = new Peripheral("HardwareKeyboard", 0);
            OnscreenKeyboard = new Peripheral("OnscreenKeyboard", 1);
            MultitouchScreen = new Peripheral("MultitouchScreen", 2);
            Accelerometer = new Peripheral("Accelerometer", 3);
            Compass = new Peripheral("Compass", 4);
            Vibrator = new Peripheral("Vibrator", 5);
            Gyroscope = new Peripheral("Gyroscope", 6);
            RotationVector = new Peripheral("RotationVector", 7);
            Peripheral peripheral = new Peripheral("Pressure", 8);
            Pressure = peripheral;
            $VALUES = new Peripheral[]{HardwareKeyboard, OnscreenKeyboard, MultitouchScreen, Accelerometer, Compass, Vibrator, Gyroscope, RotationVector, peripheral};
        }

        public Peripheral(String str, int i2) {
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

        public static Peripheral valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Peripheral) Enum.valueOf(Peripheral.class, str) : (Peripheral) invokeL.objValue;
        }

        public static Peripheral[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Peripheral[]) $VALUES.clone() : (Peripheral[]) invokeV.objValue;
        }
    }
}
