package androidx.viewpager2;

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
    public static final int[] RecyclerView;
    public static final int RecyclerView_android_clipToPadding = 1;
    public static final int RecyclerView_android_descendantFocusability = 2;
    public static final int RecyclerView_android_orientation = 0;
    public static final int RecyclerView_fastScrollEnabled = 3;
    public static final int RecyclerView_fastScrollHorizontalThumbDrawable = 4;
    public static final int RecyclerView_fastScrollHorizontalTrackDrawable = 5;
    public static final int RecyclerView_fastScrollVerticalThumbDrawable = 6;
    public static final int RecyclerView_fastScrollVerticalTrackDrawable = 7;
    public static final int RecyclerView_layoutManager = 8;
    public static final int RecyclerView_reverseLayout = 9;
    public static final int RecyclerView_spanCount = 10;
    public static final int RecyclerView_stackFromEnd = 11;
    public static final int[] ViewPager2;
    public static final int ViewPager2_android_orientation = 0;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1012427453, "Landroidx/viewpager2/R$styleable;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1012427453, "Landroidx/viewpager2/R$styleable;");
                return;
            }
        }
        ColorStateListItem = new int[]{16843173, 16843551, R.attr.alpha};
        FontFamily = new int[]{R.attr.fontProviderAuthority, R.attr.fontProviderCerts, R.attr.fontProviderFetchStrategy, R.attr.fontProviderFetchTimeout, R.attr.fontProviderPackage, R.attr.fontProviderQuery};
        FontFamilyFont = new int[]{16844082, 16844083, 16844095, 16844143, 16844144, R.attr.font, R.attr.fontStyle, R.attr.fontVariationSettings, R.attr.fontWeight, R.attr.ttcIndex};
        GradientColor = new int[]{16843165, 16843166, 16843169, 16843170, 16843171, 16843172, 16843265, 16843275, 16844048, 16844049, 16844050, 16844051};
        GradientColorItem = new int[]{16843173, 16844052};
        RecyclerView = new int[]{16842948, 16842987, 16842993, R.attr.fastScrollEnabled, R.attr.fastScrollHorizontalThumbDrawable, R.attr.fastScrollHorizontalTrackDrawable, R.attr.fastScrollVerticalThumbDrawable, R.attr.fastScrollVerticalTrackDrawable, R.attr.layoutManager, R.attr.reverseLayout, R.attr.spanCount, R.attr.stackFromEnd};
        ViewPager2 = new int[]{16842948};
    }

    public R$styleable() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
