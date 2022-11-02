package androidx.core.graphics;

import androidx.annotation.RequiresApi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class BlendModeCompat {
    public static final /* synthetic */ BlendModeCompat[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final BlendModeCompat CLEAR;
    @RequiresApi(29)
    public static final BlendModeCompat COLOR;
    @RequiresApi(29)
    public static final BlendModeCompat COLOR_BURN;
    @RequiresApi(29)
    public static final BlendModeCompat COLOR_DODGE;
    public static final BlendModeCompat DARKEN;
    @RequiresApi(29)
    public static final BlendModeCompat DIFFERENCE;
    public static final BlendModeCompat DST;
    public static final BlendModeCompat DST_ATOP;
    public static final BlendModeCompat DST_IN;
    public static final BlendModeCompat DST_OUT;
    public static final BlendModeCompat DST_OVER;
    @RequiresApi(29)
    public static final BlendModeCompat EXCLUSION;
    @RequiresApi(29)
    public static final BlendModeCompat HARD_LIGHT;
    @RequiresApi(29)
    public static final BlendModeCompat HUE;
    public static final BlendModeCompat LIGHTEN;
    @RequiresApi(29)
    public static final BlendModeCompat LUMINOSITY;
    public static final BlendModeCompat MODULATE;
    @RequiresApi(29)
    public static final BlendModeCompat MULTIPLY;
    public static final BlendModeCompat OVERLAY;
    public static final BlendModeCompat PLUS;
    @RequiresApi(29)
    public static final BlendModeCompat SATURATION;
    public static final BlendModeCompat SCREEN;
    @RequiresApi(29)
    public static final BlendModeCompat SOFT_LIGHT;
    public static final BlendModeCompat SRC;
    public static final BlendModeCompat SRC_ATOP;
    public static final BlendModeCompat SRC_IN;
    public static final BlendModeCompat SRC_OUT;
    public static final BlendModeCompat SRC_OVER;
    public static final BlendModeCompat XOR;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(746215059, "Landroidx/core/graphics/BlendModeCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(746215059, "Landroidx/core/graphics/BlendModeCompat;");
                return;
            }
        }
        CLEAR = new BlendModeCompat("CLEAR", 0);
        SRC = new BlendModeCompat("SRC", 1);
        DST = new BlendModeCompat("DST", 2);
        SRC_OVER = new BlendModeCompat("SRC_OVER", 3);
        DST_OVER = new BlendModeCompat("DST_OVER", 4);
        SRC_IN = new BlendModeCompat("SRC_IN", 5);
        DST_IN = new BlendModeCompat("DST_IN", 6);
        SRC_OUT = new BlendModeCompat("SRC_OUT", 7);
        DST_OUT = new BlendModeCompat("DST_OUT", 8);
        SRC_ATOP = new BlendModeCompat("SRC_ATOP", 9);
        DST_ATOP = new BlendModeCompat("DST_ATOP", 10);
        XOR = new BlendModeCompat("XOR", 11);
        PLUS = new BlendModeCompat("PLUS", 12);
        MODULATE = new BlendModeCompat("MODULATE", 13);
        SCREEN = new BlendModeCompat("SCREEN", 14);
        OVERLAY = new BlendModeCompat("OVERLAY", 15);
        DARKEN = new BlendModeCompat("DARKEN", 16);
        LIGHTEN = new BlendModeCompat("LIGHTEN", 17);
        COLOR_DODGE = new BlendModeCompat("COLOR_DODGE", 18);
        COLOR_BURN = new BlendModeCompat("COLOR_BURN", 19);
        HARD_LIGHT = new BlendModeCompat("HARD_LIGHT", 20);
        SOFT_LIGHT = new BlendModeCompat("SOFT_LIGHT", 21);
        DIFFERENCE = new BlendModeCompat("DIFFERENCE", 22);
        EXCLUSION = new BlendModeCompat("EXCLUSION", 23);
        MULTIPLY = new BlendModeCompat("MULTIPLY", 24);
        HUE = new BlendModeCompat("HUE", 25);
        SATURATION = new BlendModeCompat("SATURATION", 26);
        COLOR = new BlendModeCompat("COLOR", 27);
        BlendModeCompat blendModeCompat = new BlendModeCompat("LUMINOSITY", 28);
        LUMINOSITY = blendModeCompat;
        $VALUES = new BlendModeCompat[]{CLEAR, SRC, DST, SRC_OVER, DST_OVER, SRC_IN, DST_IN, SRC_OUT, DST_OUT, SRC_ATOP, DST_ATOP, XOR, PLUS, MODULATE, SCREEN, OVERLAY, DARKEN, LIGHTEN, COLOR_DODGE, COLOR_BURN, HARD_LIGHT, SOFT_LIGHT, DIFFERENCE, EXCLUSION, MULTIPLY, HUE, SATURATION, COLOR, blendModeCompat};
    }

    public BlendModeCompat(String str, int i) {
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

    public static BlendModeCompat valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (BlendModeCompat) Enum.valueOf(BlendModeCompat.class, str);
        }
        return (BlendModeCompat) invokeL.objValue;
    }

    public static BlendModeCompat[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (BlendModeCompat[]) $VALUES.clone();
        }
        return (BlendModeCompat[]) invokeV.objValue;
    }
}
