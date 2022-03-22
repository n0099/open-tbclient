package androidx.core;

import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class R$styleable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] ColorStateListItem;
    public static final int ColorStateListItem_alpha = 2;
    public static final int ColorStateListItem_android_alpha = 1;
    public static final int ColorStateListItem_android_color = 0;
    public static final int[] FontFamily;
    public static final int[] FontFamilyFont;
    public static final int FontFamilyFont_android_font = 0;
    public static final int FontFamilyFont_android_fontStyle = 2;
    public static final int FontFamilyFont_android_fontVariationSettings = 4;
    public static final int FontFamilyFont_android_fontWeight = 1;
    public static final int FontFamilyFont_android_ttcIndex = 3;
    public static final int FontFamilyFont_font = 5;
    public static final int FontFamilyFont_fontStyle = 6;
    public static final int FontFamilyFont_fontVariationSettings = 7;
    public static final int FontFamilyFont_fontWeight = 8;
    public static final int FontFamilyFont_ttcIndex = 9;
    public static final int FontFamily_fontProviderAuthority = 0;
    public static final int FontFamily_fontProviderCerts = 1;
    public static final int FontFamily_fontProviderFetchStrategy = 2;
    public static final int FontFamily_fontProviderFetchTimeout = 3;
    public static final int FontFamily_fontProviderPackage = 4;
    public static final int FontFamily_fontProviderQuery = 5;
    public static final int[] GradientColor;
    public static final int[] GradientColorItem;
    public static final int GradientColorItem_android_color = 0;
    public static final int GradientColorItem_android_offset = 1;
    public static final int GradientColor_android_centerColor = 7;
    public static final int GradientColor_android_centerX = 3;
    public static final int GradientColor_android_centerY = 4;
    public static final int GradientColor_android_endColor = 1;
    public static final int GradientColor_android_endX = 10;
    public static final int GradientColor_android_endY = 11;
    public static final int GradientColor_android_gradientRadius = 5;
    public static final int GradientColor_android_startColor = 0;
    public static final int GradientColor_android_startX = 8;
    public static final int GradientColor_android_startY = 9;
    public static final int GradientColor_android_tileMode = 6;
    public static final int GradientColor_android_type = 2;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-786078792, "Landroidx/core/R$styleable;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-786078792, "Landroidx/core/R$styleable;");
                return;
            }
        }
        ColorStateListItem = new int[]{16843173, 16843551, R.attr.obfuscated_res_0x7f040087};
        FontFamily = new int[]{R.attr.obfuscated_res_0x7f04021c, R.attr.obfuscated_res_0x7f04021d, R.attr.obfuscated_res_0x7f040247, R.attr.obfuscated_res_0x7f040250, R.attr.obfuscated_res_0x7f040251, R.attr.obfuscated_res_0x7f040252};
        FontFamilyFont = new int[]{16844082, 16844083, 16844095, 16844143, 16844144, R.attr.obfuscated_res_0x7f04021a, R.attr.obfuscated_res_0x7f040253, R.attr.obfuscated_res_0x7f040254, R.attr.obfuscated_res_0x7f040256, R.attr.obfuscated_res_0x7f04066c};
        GradientColor = new int[]{16843165, 16843166, 16843169, 16843170, 16843171, 16843172, 16843265, 16843275, 16844048, 16844049, 16844050, 16844051};
        GradientColorItem = new int[]{16843173, 16844052};
    }

    public R$styleable() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
