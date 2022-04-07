package com.baidu.android.util.io;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
@Deprecated
/* loaded from: classes.dex */
public class ByteUnitConverter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int GB = 1073741824;
    public static final int KB = 1024;
    public static final int MB = 1048576;
    public static final int UNIT = 1024;
    public transient /* synthetic */ FieldHolder $fh;
    public String convertStr;

    /* renamed from: com.baidu.android.util.io.ByteUnitConverter$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$android$util$io$ByteUnitConverter$UNITS;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-128415100, "Lcom/baidu/android/util/io/ByteUnitConverter$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-128415100, "Lcom/baidu/android/util/io/ByteUnitConverter$1;");
                    return;
                }
            }
            int[] iArr = new int[UNITS.values().length];
            $SwitchMap$com$baidu$android$util$io$ByteUnitConverter$UNITS = iArr;
            try {
                iArr[UNITS.B.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$android$util$io$ByteUnitConverter$UNITS[UNITS.KB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$android$util$io$ByteUnitConverter$UNITS[UNITS.MB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$android$util$io$ByteUnitConverter$UNITS[UNITS.GB.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class UNITS {
        public static final /* synthetic */ UNITS[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final UNITS B;
        public static final UNITS GB;
        public static final UNITS KB;
        public static final UNITS MB;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-354135514, "Lcom/baidu/android/util/io/ByteUnitConverter$UNITS;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-354135514, "Lcom/baidu/android/util/io/ByteUnitConverter$UNITS;");
                    return;
                }
            }
            B = new UNITS("B", 0);
            KB = new UNITS("KB", 1);
            MB = new UNITS("MB", 2);
            UNITS units = new UNITS("GB", 3);
            GB = units;
            $VALUES = new UNITS[]{B, KB, MB, units};
        }

        public UNITS(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static UNITS valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (UNITS) Enum.valueOf(UNITS.class, str) : (UNITS) invokeL.objValue;
        }

        public static UNITS[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (UNITS[]) $VALUES.clone() : (UNITS[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ByteUnitConverter(double d) {
        this(d, UNITS.B);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Double.valueOf(d)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Double) objArr2[0]).doubleValue(), (UNITS) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void convertByte(double d) {
        float f;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Double.valueOf(d)}) == null) {
            if (d < 1024.0d) {
                f = (float) d;
                str = "B";
            } else if (d < 1048576.0d) {
                f = ((float) d) / 1024.0f;
                str = "KB";
            } else if (d < 1.073741824E9d) {
                f = ((float) d) / 1048576.0f;
                str = "MB";
            } else {
                f = ((float) d) / 1.0737418E9f;
                str = "GB";
            }
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            this.convertStr = decimalFormat.format(f) + str;
        }
    }

    private void convertGigaByte(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Double.valueOf(d)}) == null) {
            convertMegaByte(d * 1024.0d);
        }
    }

    private void convertKiloByte(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Double.valueOf(d)}) == null) {
            convertByte(d * 1024.0d);
        }
    }

    private void convertMegaByte(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Double.valueOf(d)}) == null) {
            convertKiloByte(d * 1024.0d);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.convertStr : (String) invokeV.objValue;
    }

    public ByteUnitConverter(double d, UNITS units) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Double.valueOf(d), units};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int i3 = AnonymousClass1.$SwitchMap$com$baidu$android$util$io$ByteUnitConverter$UNITS[units.ordinal()];
        if (i3 == 1) {
            convertByte(d);
        } else if (i3 == 2) {
            convertKiloByte(d);
        } else if (i3 == 3) {
            convertMegaByte(d);
        } else if (i3 != 4) {
        } else {
            convertGigaByte(d);
        }
    }
}
