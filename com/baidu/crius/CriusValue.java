package com.baidu.crius;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.crius.annotations.DoNotStrip;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
@DoNotStrip
/* loaded from: classes3.dex */
public class CriusValue {
    public static /* synthetic */ Interceptable $ic;
    public static final CriusValue AUTO;
    public static final CriusValue UNDEFINED;
    public static final CriusValue ZERO;
    public transient /* synthetic */ FieldHolder $fh;
    public final CriusUnit unit;
    public final float value;

    /* renamed from: com.baidu.crius.CriusValue$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$crius$CriusUnit;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1606098288, "Lcom/baidu/crius/CriusValue$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1606098288, "Lcom/baidu/crius/CriusValue$1;");
                    return;
                }
            }
            int[] iArr = new int[CriusUnit.values().length];
            $SwitchMap$com$baidu$crius$CriusUnit = iArr;
            try {
                iArr[CriusUnit.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$crius$CriusUnit[CriusUnit.POINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$crius$CriusUnit[CriusUnit.PERCENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$crius$CriusUnit[CriusUnit.AUTO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-864240131, "Lcom/baidu/crius/CriusValue;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-864240131, "Lcom/baidu/crius/CriusValue;");
                return;
            }
        }
        UNDEFINED = new CriusValue(Float.NaN, CriusUnit.UNDEFINED);
        ZERO = new CriusValue(0.0f, CriusUnit.POINT);
        AUTO = new CriusValue(Float.NaN, CriusUnit.AUTO);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @DoNotStrip
    public CriusValue(float f, int i) {
        this(f, CriusUnit.fromInt(i));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f), Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Float) objArr2[0]).floatValue(), (CriusUnit) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public CriusValue(float f, CriusUnit criusUnit) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f), criusUnit};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.value = f;
        this.unit = criusUnit;
    }

    public static CriusValue parse(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null) {
                return null;
            }
            if (SessionMonitorEngine.PUBLIC_DATA_UNDIFNED.equals(str)) {
                return UNDEFINED;
            }
            if ("auto".equals(str)) {
                return AUTO;
            }
            if (str.endsWith("%")) {
                return new CriusValue(Float.parseFloat(str.substring(0, str.length() - 1)), CriusUnit.PERCENT);
            }
            return new CriusValue(Float.parseFloat(str), CriusUnit.POINT);
        }
        return (CriusValue) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (!(obj instanceof CriusValue)) {
                return false;
            }
            CriusValue criusValue = (CriusValue) obj;
            CriusUnit criusUnit = this.unit;
            if (criusUnit != criusValue.unit) {
                return false;
            }
            if (criusUnit != CriusUnit.UNDEFINED && Float.compare(this.value, criusValue.value) != 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return Float.floatToIntBits(this.value) + this.unit.intValue();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = AnonymousClass1.$SwitchMap$com$baidu$crius$CriusUnit[this.unit.ordinal()];
            if (i == 1) {
                return SessionMonitorEngine.PUBLIC_DATA_UNDIFNED;
            }
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (!CriusConstants.DEBUG) {
                            return SessionMonitorEngine.PUBLIC_DATA_UNDIFNED;
                        }
                        throw new IllegalStateException();
                    }
                    return "auto";
                }
                return this.value + "%";
            }
            return Float.toString(this.value);
        }
        return (String) invokeV.objValue;
    }
}
