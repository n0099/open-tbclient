package c.a.h0;

import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public final class k {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] MaxHeightScrollView;
    public static final int MaxHeightScrollView_maxHeightRatio = 0;
    public static final int MaxHeightScrollView_minHeightRatio = 1;
    public static final int[] PolyVerificationCodeView;
    public static final int PolyVerificationCodeView_vcv_et_bg = 0;
    public static final int PolyVerificationCodeView_vcv_et_cursor = 1;
    public static final int PolyVerificationCodeView_vcv_et_cursor_visible = 2;
    public static final int PolyVerificationCodeView_vcv_et_number = 3;
    public static final int PolyVerificationCodeView_vcv_et_spacing = 4;
    public static final int PolyVerificationCodeView_vcv_et_text_color = 5;
    public static final int PolyVerificationCodeView_vcv_et_text_size = 6;
    public static final int PolyVerificationCodeView_vcv_et_width = 7;
    public static final int[] PopupWindow;
    public static final int PopupWindow_android_popupAnimationStyle = 1;
    public static final int PopupWindow_android_popupBackground = 0;
    public static final int PopupWindow_overlapAnchor = 2;
    public static final int PopupWindow_popupAnimationStyle = 3;
    public static final int PopupWindow_popupBackground = 4;
    public static final int[] ProgressButton;
    public static final int ProgressButton_textColor = 0;
    public static final int[] SwitchButton;
    public static final int SwitchButton_kswAnimationDuration = 0;
    public static final int SwitchButton_kswBackColor = 1;
    public static final int SwitchButton_kswBackDrawable = 2;
    public static final int SwitchButton_kswBackRadius = 3;
    public static final int SwitchButton_kswFadeBack = 4;
    public static final int SwitchButton_kswTextAdjust = 5;
    public static final int SwitchButton_kswTextExtra = 6;
    public static final int SwitchButton_kswTextOff = 7;
    public static final int SwitchButton_kswTextOn = 8;
    public static final int SwitchButton_kswTextThumbInset = 9;
    public static final int SwitchButton_kswThumbColor = 10;
    public static final int SwitchButton_kswThumbDrawable = 11;
    public static final int SwitchButton_kswThumbHeight = 12;
    public static final int SwitchButton_kswThumbMargin = 13;
    public static final int SwitchButton_kswThumbMarginBottom = 14;
    public static final int SwitchButton_kswThumbMarginLeft = 15;
    public static final int SwitchButton_kswThumbMarginRight = 16;
    public static final int SwitchButton_kswThumbMarginTop = 17;
    public static final int SwitchButton_kswThumbRadius = 18;
    public static final int SwitchButton_kswThumbRangeRatio = 19;
    public static final int SwitchButton_kswThumbWidth = 20;
    public static final int SwitchButton_kswTintColor = 21;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1339823153, "Lc/a/h0/k;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1339823153, "Lc/a/h0/k;");
                return;
            }
        }
        MaxHeightScrollView = new int[]{R.attr.maxHeightRatio, R.attr.minHeightRatio};
        PolyVerificationCodeView = new int[]{R.attr.vcv_et_bg, R.attr.vcv_et_cursor, R.attr.vcv_et_cursor_visible, R.attr.vcv_et_number, R.attr.vcv_et_spacing, R.attr.vcv_et_text_color, R.attr.vcv_et_text_size, R.attr.vcv_et_width};
        PopupWindow = new int[]{16843126, 16843465, R.attr.overlapAnchor, R.attr.popupAnimationStyle, R.attr.popupBackground};
        ProgressButton = new int[]{R.attr.textColor};
        SwitchButton = new int[]{R.attr.kswAnimationDuration, R.attr.kswBackColor, R.attr.kswBackDrawable, R.attr.kswBackRadius, R.attr.kswFadeBack, R.attr.kswTextAdjust, R.attr.kswTextExtra, R.attr.kswTextOff, R.attr.kswTextOn, R.attr.kswTextThumbInset, R.attr.kswThumbColor, R.attr.kswThumbDrawable, R.attr.kswThumbHeight, R.attr.kswThumbMargin, R.attr.kswThumbMarginBottom, R.attr.kswThumbMarginLeft, R.attr.kswThumbMarginRight, R.attr.kswThumbMarginTop, R.attr.kswThumbRadius, R.attr.kswThumbRangeRatio, R.attr.kswThumbWidth, R.attr.kswTintColor};
    }
}
