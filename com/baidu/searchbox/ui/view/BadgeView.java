package com.baidu.searchbox.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TabWidget;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.ui.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
/* loaded from: classes7.dex */
public class BadgeView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CountFormatType mCountFormatType;
    public boolean mHideOnNull;
    public int mLrPaddingInBigTextType;
    public GradientDrawable mRoundRectBg;
    public Type mType;

    /* renamed from: com.baidu.searchbox.ui.view.BadgeView$2  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$view$BadgeView$CountFormatType;
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$view$BadgeView$DefaultPosition;
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$view$BadgeView$Type;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1781050894, "Lcom/baidu/searchbox/ui/view/BadgeView$2;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1781050894, "Lcom/baidu/searchbox/ui/view/BadgeView$2;");
                    return;
                }
            }
            int[] iArr = new int[DefaultPosition.values().length];
            $SwitchMap$com$baidu$searchbox$ui$view$BadgeView$DefaultPosition = iArr;
            try {
                iArr[DefaultPosition.ICON_DOT_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$view$BadgeView$DefaultPosition[DefaultPosition.ICON_DOT_SPECIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$view$BadgeView$DefaultPosition[DefaultPosition.ICON_SMALL_TXT_NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$view$BadgeView$DefaultPosition[DefaultPosition.ICON_SMALL_TXT_SPECIAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$view$BadgeView$DefaultPosition[DefaultPosition.TXT_DOT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$view$BadgeView$DefaultPosition[DefaultPosition.TXT_SMALL_TXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[CountFormatType.values().length];
            $SwitchMap$com$baidu$searchbox$ui$view$BadgeView$CountFormatType = iArr2;
            try {
                iArr2[CountFormatType.ORIGIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$view$BadgeView$CountFormatType[CountFormatType.MAX_99.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$view$BadgeView$CountFormatType[CountFormatType.MAX_999.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$view$BadgeView$CountFormatType[CountFormatType.LOW_PRECISION.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr3 = new int[Type.values().length];
            $SwitchMap$com$baidu$searchbox$ui$view$BadgeView$Type = iArr3;
            try {
                iArr3[Type.DOT.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$view$BadgeView$Type[Type.SMALL_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$view$BadgeView$Type[Type.BIG_TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class CountFormatType {
        public static final /* synthetic */ CountFormatType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CountFormatType LOW_PRECISION;
        public static final CountFormatType MAX_99;
        public static final CountFormatType MAX_999;
        public static final CountFormatType ORIGIN;
        public transient /* synthetic */ FieldHolder $fh;
        public int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1198806752, "Lcom/baidu/searchbox/ui/view/BadgeView$CountFormatType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1198806752, "Lcom/baidu/searchbox/ui/view/BadgeView$CountFormatType;");
                    return;
                }
            }
            ORIGIN = new CountFormatType("ORIGIN", 0, 0);
            MAX_99 = new CountFormatType("MAX_99", 1, 1);
            MAX_999 = new CountFormatType("MAX_999", 2, 2);
            CountFormatType countFormatType = new CountFormatType("LOW_PRECISION", 3, 3);
            LOW_PRECISION = countFormatType;
            $VALUES = new CountFormatType[]{ORIGIN, MAX_99, MAX_999, countFormatType};
        }

        public CountFormatType(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = i3;
        }

        public static CountFormatType getCountFormatType(int i2) {
            InterceptResult invokeI;
            CountFormatType[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
                for (CountFormatType countFormatType : values()) {
                    if (countFormatType.value == i2) {
                        return countFormatType;
                    }
                }
                return null;
            }
            return (CountFormatType) invokeI.objValue;
        }

        public static CountFormatType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (CountFormatType) Enum.valueOf(CountFormatType.class, str) : (CountFormatType) invokeL.objValue;
        }

        public static CountFormatType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? (CountFormatType[]) $VALUES.clone() : (CountFormatType[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class DefaultPosition {
        public static final /* synthetic */ DefaultPosition[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DefaultPosition ICON_DOT_NORMAL;
        public static final DefaultPosition ICON_DOT_SPECIAL;
        public static final DefaultPosition ICON_SMALL_TXT_NORMAL;
        public static final DefaultPosition ICON_SMALL_TXT_SPECIAL;
        public static final DefaultPosition TXT_DOT;
        public static final DefaultPosition TXT_SMALL_TXT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1808449046, "Lcom/baidu/searchbox/ui/view/BadgeView$DefaultPosition;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1808449046, "Lcom/baidu/searchbox/ui/view/BadgeView$DefaultPosition;");
                    return;
                }
            }
            ICON_DOT_NORMAL = new DefaultPosition("ICON_DOT_NORMAL", 0);
            ICON_DOT_SPECIAL = new DefaultPosition("ICON_DOT_SPECIAL", 1);
            ICON_SMALL_TXT_NORMAL = new DefaultPosition("ICON_SMALL_TXT_NORMAL", 2);
            ICON_SMALL_TXT_SPECIAL = new DefaultPosition("ICON_SMALL_TXT_SPECIAL", 3);
            TXT_DOT = new DefaultPosition("TXT_DOT", 4);
            DefaultPosition defaultPosition = new DefaultPosition("TXT_SMALL_TXT", 5);
            TXT_SMALL_TXT = defaultPosition;
            $VALUES = new DefaultPosition[]{ICON_DOT_NORMAL, ICON_DOT_SPECIAL, ICON_SMALL_TXT_NORMAL, ICON_SMALL_TXT_SPECIAL, TXT_DOT, defaultPosition};
        }

        public DefaultPosition(String str, int i2) {
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

        public static DefaultPosition valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DefaultPosition) Enum.valueOf(DefaultPosition.class, str) : (DefaultPosition) invokeL.objValue;
        }

        public static DefaultPosition[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DefaultPosition[]) $VALUES.clone() : (DefaultPosition[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class Type {
        public static final /* synthetic */ Type[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Type BIG_TEXT;
        public static final Type DOT;
        public static final Type SMALL_TEXT;
        public transient /* synthetic */ FieldHolder $fh;
        public int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-705434052, "Lcom/baidu/searchbox/ui/view/BadgeView$Type;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-705434052, "Lcom/baidu/searchbox/ui/view/BadgeView$Type;");
                    return;
                }
            }
            DOT = new Type("DOT", 0, 0);
            SMALL_TEXT = new Type("SMALL_TEXT", 1, 1);
            Type type = new Type("BIG_TEXT", 2, 2);
            BIG_TEXT = type;
            $VALUES = new Type[]{DOT, SMALL_TEXT, type};
        }

        public Type(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = i3;
        }

        public static Type getType(int i2) {
            InterceptResult invokeI;
            Type[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
                for (Type type : values()) {
                    if (type.value == i2) {
                        return type;
                    }
                }
                return null;
            }
            return (Type) invokeI.objValue;
        }

        public static Type valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (Type) Enum.valueOf(Type.class, str) : (Type) invokeL.objValue;
        }

        public static Type[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? (Type[]) $VALUES.clone() : (Type[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BadgeView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private int dip2Px(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65539, this, f2)) == null) ? DeviceUtil.ScreenInfo.dp2px(getContext(), f2) : invokeF.intValue;
    }

    private void ensureShapeBg() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && this.mRoundRectBg == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.mRoundRectBg = gradientDrawable;
            gradientDrawable.setColor(getResources().getColor(R.color.UC26));
            this.mRoundRectBg.setCornerRadius(getHeight() / 2);
        }
    }

    private String formatCount(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2)) == null) {
            int i3 = AnonymousClass2.$SwitchMap$com$baidu$searchbox$ui$view$BadgeView$CountFormatType[this.mCountFormatType.ordinal()];
            if (i3 == 2) {
                if (i2 > 99) {
                    return "99+";
                }
                return i2 + "";
            } else if (i3 == 3) {
                if (i2 > 999) {
                    return "999+";
                }
                return i2 + "";
            } else if (i3 != 4) {
                return i2 + "";
            } else if (i2 < 10000) {
                return i2 + "";
            } else if (10000 <= i2 && i2 < 100000) {
                return new DecimalFormat("#.#").format(i2 / 10000.0f) + "万";
            } else if (100000 <= i2 && i2 < 100000000) {
                return (i2 / 10000) + "万";
            } else if (100000000 <= i2 && i2 < 1000000000) {
                return new DecimalFormat("#.#").format(i2 / 1.0E8f) + "亿";
            } else {
                return (i2 / 100000000) + "亿";
            }
        }
        return (String) invokeI.objValue;
    }

    private void init(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, context, attributeSet) == null) {
            this.mLrPaddingInBigTextType = getResources().getDimensionPixelSize(R.dimen.badge_big_text_padding);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.badge);
            this.mType = Type.getType(obtainStyledAttributes.getInt(R.styleable.badge_type, Type.DOT.value));
            this.mCountFormatType = CountFormatType.getCountFormatType(obtainStyledAttributes.getInt(R.styleable.badge_count_format_type, CountFormatType.MAX_99.value));
            obtainStyledAttributes.recycle();
            if (getLayoutParams() == null) {
                setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 53));
            }
            setTextColor(getResources().getColor(R.color.UC25));
            setGravity(17);
        }
    }

    private void setTypeParams() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.mType == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int i2 = AnonymousClass2.$SwitchMap$com$baidu$searchbox$ui$view$BadgeView$Type[this.mType.ordinal()];
        if (i2 == 1) {
            layoutParams.width = getResources().getDimensionPixelSize(R.dimen.badge_dot_l);
            layoutParams.height = getResources().getDimensionPixelSize(R.dimen.badge_dot_l);
            ensureShapeBg();
            setBackground(this.mRoundRectBg);
            setMinWidth(0);
            setText("");
        } else if (i2 == 2) {
            layoutParams.width = -2;
            layoutParams.height = -2;
            setBackground(getResources().getDrawable(R.drawable.badge_bg_small_text));
            setMinWidth(0);
            setTextSize(1, 9.0f);
            if (TextUtils.isEmpty(getText())) {
                setVisibility(8);
            }
        } else if (i2 != 3) {
        } else {
            layoutParams.width = -2;
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.badge_big_text_h);
            layoutParams.height = dimensionPixelSize;
            int i3 = this.mLrPaddingInBigTextType;
            setPadding(i3, 0, i3, 0);
            ensureShapeBg();
            setBackground(this.mRoundRectBg);
            setMinWidth(dimensionPixelSize);
            setTextSize(1, 10.0f);
            if (TextUtils.isEmpty(getText())) {
                setVisibility(8);
            }
        }
    }

    public void bindView(TabWidget tabWidget, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tabWidget, i2) == null) {
            bindView(tabWidget.getChildTabViewAt(i2));
        }
    }

    public void bindViewInRelativeLayout(View view, RelativeLayout relativeLayout, DefaultPosition defaultPosition) {
        int id;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, view, relativeLayout, defaultPosition) == null) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            if (view.getParent() != relativeLayout || (id = view.getId()) == -1) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(layoutParams2.width, layoutParams2.height);
            layoutParams3.addRule(1, id);
            layoutParams3.addRule(2, id);
            Resources resources = getResources();
            switch (AnonymousClass2.$SwitchMap$com$baidu$searchbox$ui$view$BadgeView$DefaultPosition[defaultPosition.ordinal()]) {
                case 1:
                    layoutParams3.leftMargin = (resources.getDimensionPixelSize(R.dimen.badge_icon_dot_left_normal) - layoutParams.rightMargin) - view.getPaddingRight();
                    layoutParams3.bottomMargin = (resources.getDimensionPixelSize(R.dimen.badge_icon_dot_bottom_normal) - layoutParams.topMargin) - view.getPaddingTop();
                    break;
                case 2:
                    layoutParams3.leftMargin = (resources.getDimensionPixelSize(R.dimen.badge_icon_dot_left_special) - layoutParams.rightMargin) - view.getPaddingRight();
                    layoutParams3.bottomMargin = (resources.getDimensionPixelSize(R.dimen.badge_icon_dot_bottom_special) - layoutParams.topMargin) - view.getPaddingTop();
                    break;
                case 3:
                    layoutParams3.leftMargin = (resources.getDimensionPixelSize(R.dimen.badge_icon_small_text_left_normal) - layoutParams.rightMargin) - view.getPaddingRight();
                    layoutParams3.bottomMargin = (resources.getDimensionPixelSize(R.dimen.badge_icon_small_text_bottom_normal) - layoutParams.topMargin) - view.getPaddingTop();
                    break;
                case 4:
                    layoutParams3.leftMargin = (resources.getDimensionPixelSize(R.dimen.badge_icon_small_text_left_special) - layoutParams.rightMargin) - view.getPaddingRight();
                    layoutParams3.bottomMargin = (resources.getDimensionPixelSize(R.dimen.badge_icon_small_text_bottom_special) - layoutParams.topMargin) - view.getPaddingTop();
                    break;
                case 5:
                    layoutParams3.leftMargin = (-layoutParams.rightMargin) - view.getPaddingRight();
                    layoutParams3.bottomMargin = (resources.getDimensionPixelSize(R.dimen.badge_text_dot_bottom) - layoutParams.topMargin) - view.getPaddingTop();
                    break;
                case 6:
                    layoutParams3.leftMargin = (resources.getDimensionPixelSize(R.dimen.badge_text_small_text_left) - layoutParams.rightMargin) - view.getPaddingRight();
                    layoutParams3.bottomMargin = (resources.getDimensionPixelSize(R.dimen.badge_text_small_text_bottom) - layoutParams.topMargin) - view.getPaddingTop();
                    break;
            }
            relativeLayout.addView(this, layoutParams3);
        }
    }

    public void decrementBadgeCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            incrementBadgeCount(-i2);
        }
    }

    public Integer getBadgeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (getText() == null) {
                return null;
            }
            try {
                return Integer.valueOf(Integer.parseInt(getText().toString()));
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return (Integer) invokeV.objValue;
    }

    public int getBadgeGravity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                return ((FrameLayout.LayoutParams) layoutParams).gravity;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int[] getBadgeMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            return new int[]{marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin};
        }
        return (int[]) invokeV.objValue;
    }

    public void incrementBadgeCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            Integer badgeCount = getBadgeCount();
            if (badgeCount == null) {
                setBadgeCount(i2);
            } else {
                setBadgeCount(i2 + badgeCount.intValue());
            }
        }
    }

    public boolean isHideOnNull() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mHideOnNull : invokeV.booleanValue;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onAttachedToWindow();
            updateNightMode();
            NightModeHelper.subscribeNightModeChangeEvent(this, new NightModeChangeListener(this) { // from class: com.baidu.searchbox.ui.view.BadgeView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BadgeView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.searchbox.skin.callback.NightModeChangeListener
                public void onNightModeChanged(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                        this.this$0.updateNightMode();
                    }
                }
            });
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDetachedFromWindow();
            NightModeHelper.unsubscribeNightModeChangedEvent(this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            GradientDrawable gradientDrawable = this.mRoundRectBg;
            if (gradientDrawable != null) {
                gradientDrawable.setCornerRadius(getHeight() / 2);
            }
        }
    }

    public void setBadgeCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            setBadgeText(formatCount(i2));
        }
    }

    public void setBadgeGravity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity = i2;
                setLayoutParams(layoutParams);
            }
        }
    }

    public void setBadgeMargin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            setBadgeMargin(i2, i2, i2, i2);
        }
    }

    public void setBadgeMarginInPx(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            setBadgeMarginInPx(i2, i2, i2, i2);
        }
    }

    public void setBadgeText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            if (this.mType == Type.DOT) {
                setType(Type.SMALL_TEXT);
            }
            setText(str);
        }
    }

    public void setCountFormatType(CountFormatType countFormatType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, countFormatType) == null) {
            this.mCountFormatType = countFormatType;
        }
    }

    public void setHideOnNull(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.mHideOnNull = z;
            setText(getText());
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, layoutParams) == null) {
            super.setLayoutParams(layoutParams);
            setTypeParams();
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        Type type;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, charSequence, bufferType) == null) {
            if (isHideOnNull() && (((type = this.mType) == Type.SMALL_TEXT || type == Type.BIG_TEXT) && (TextUtils.isEmpty(charSequence) || charSequence.toString().equalsIgnoreCase("0")))) {
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            super.setText(charSequence, bufferType);
        }
    }

    public void setType(Type type) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, type) == null) {
            this.mType = type;
            setTypeParams();
        }
    }

    public void unbind() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || getParent() == null) {
            return;
        }
        ((ViewGroup) getParent()).removeView(this);
    }

    public void updateNightMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            setTextColor(getResources().getColor(R.color.UC25));
            if (this.mType == Type.SMALL_TEXT) {
                setBackground(getResources().getDrawable(R.drawable.badge_bg_small_text));
                return;
            }
            GradientDrawable gradientDrawable = this.mRoundRectBg;
            if (gradientDrawable != null) {
                gradientDrawable.setColor(getResources().getColor(R.color.UC26));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BadgeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Deprecated
    public void setBadgeCount(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            if (this.mType == Type.DOT) {
                setType(Type.SMALL_TEXT);
            }
            setText(str);
        }
    }

    public void setBadgeMargin(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048593, this, i2, i3, i4, i5) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.leftMargin = dip2Px(i2);
            marginLayoutParams.topMargin = dip2Px(i3);
            marginLayoutParams.rightMargin = dip2Px(i4);
            marginLayoutParams.bottomMargin = dip2Px(i5);
            setLayoutParams(marginLayoutParams);
        }
    }

    public void setBadgeMarginInPx(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048595, this, i2, i3, i4, i5) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.leftMargin = i2;
            marginLayoutParams.topMargin = i3;
            marginLayoutParams.rightMargin = i4;
            marginLayoutParams.bottomMargin = i5;
            setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BadgeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mType = null;
        this.mCountFormatType = null;
        this.mHideOnNull = true;
        init(context, attributeSet);
    }

    @Deprecated
    public void bindView(View view) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            if (view == null || (viewGroup = (ViewGroup) view.getParent()) == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
                setLayoutParams(new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height));
            }
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if ((viewGroup instanceof FrameLayout) && layoutParams2.width == -1 && layoutParams2.height == -1) {
                viewGroup.addView(this);
                return;
            }
            int indexOfChild = viewGroup.indexOfChild(view);
            viewGroup.removeView(view);
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(layoutParams2);
            viewGroup.addView(frameLayout, indexOfChild, layoutParams2);
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            frameLayout.addView(view);
            frameLayout.addView(this);
        }
    }

    @Deprecated
    public void bindView(View view, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
                layoutParams = new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height);
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = i2;
            layoutParams2.leftMargin = i3;
            layoutParams2.topMargin = i4;
            layoutParams2.rightMargin = i5;
            layoutParams2.bottomMargin = i6;
            setLayoutParams(layoutParams);
            bindView(view);
        }
    }
}
