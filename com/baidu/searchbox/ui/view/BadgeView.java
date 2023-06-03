package com.baidu.searchbox.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TabWidget;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.tieba.R;
import java.text.DecimalFormat;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes4.dex */
public class BadgeView extends TextView {
    public int backgroundColor;
    public int backgroundColorNight;
    public RelativeLayout.LayoutParams badgeLayoutParams;
    public int bigTextHeight;
    public int bigTextSize;
    public View bindBadgeView;
    public int currentFontLevel;
    public int dotSize;
    public boolean isChangeBackgroundColor;
    public CountFormatType mCountFormatType;
    public boolean mHideOnNull;
    public boolean mIsNormalSize;
    public int mLrPaddingInBigTextType;
    public GradientDrawable mRoundRectBg;
    public Type mType;
    public Drawable smallTextBg;
    public int smallTextSize;
    public int viewBottomMargin;
    public int viewLeftMargin;
    public DefaultPosition viewPositionType;

    /* loaded from: classes4.dex */
    public enum DefaultPosition {
        ICON_DOT_NORMAL,
        ICON_DOT_SPECIAL,
        ICON_SMALL_TXT_NORMAL,
        ICON_SMALL_TXT_SPECIAL,
        TXT_DOT,
        TXT_SMALL_TXT
    }

    /* renamed from: com.baidu.searchbox.ui.view.BadgeView$3  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$view$BadgeView$CountFormatType;
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$view$BadgeView$DefaultPosition;
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$view$BadgeView$Type;

        static {
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

    public BadgeView(Context context) {
        this(context, null);
    }

    private int dip2Px(float f) {
        return DeviceUtil.ScreenInfo.dp2px(getContext(), f);
    }

    public void decrementBadgeCount(int i) {
        incrementBadgeCount(-i);
    }

    public void incrementBadgeCount(int i) {
        Integer badgeCount = getBadgeCount();
        if (badgeCount == null) {
            setBadgeCount(i);
        } else {
            setBadgeCount(i + badgeCount.intValue());
        }
    }

    public void setBadgeCount(int i) {
        setBadgeText(formatCount(i));
    }

    public void setBadgeGravity(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i;
            setLayoutParams(layoutParams);
        }
    }

    public void setBadgeMargin(int i) {
        setBadgeMargin(i, i, i, i);
    }

    public void setBadgeMarginInPx(int i) {
        setBadgeMarginInPx(i, i, i, i);
    }

    public void setBadgeText(String str) {
        if (this.mType == Type.DOT) {
            setType(Type.SMALL_TEXT);
        }
        setText(str);
    }

    public void setCountFormatType(CountFormatType countFormatType) {
        this.mCountFormatType = countFormatType;
    }

    public void setHideOnNull(boolean z) {
        this.mHideOnNull = z;
        setText(getText());
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        setTypeParams();
    }

    public void setLayoutParamsOnly(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    public void setNormalSizeBadge(boolean z) {
        this.mIsNormalSize = z;
    }

    public void setType(Type type) {
        this.mType = type;
        setTypeParams();
    }

    /* loaded from: classes4.dex */
    public enum CountFormatType {
        ORIGIN(0),
        MAX_99(1),
        MAX_999(2),
        LOW_PRECISION(3);
        
        public int value;

        CountFormatType(int i) {
            this.value = i;
        }

        public static CountFormatType getCountFormatType(int i) {
            CountFormatType[] values;
            for (CountFormatType countFormatType : values()) {
                if (countFormatType.value == i) {
                    return countFormatType;
                }
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public enum Type {
        DOT(0),
        SMALL_TEXT(1),
        BIG_TEXT(2);
        
        public int value;

        Type(int i) {
            this.value = i;
        }

        public static Type getType(int i) {
            Type[] values;
            for (Type type : values()) {
                if (type.value == i) {
                    return type;
                }
            }
            return null;
        }
    }

    public BadgeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public void bindView(TabWidget tabWidget, int i) {
        bindView(tabWidget.getChildTabViewAt(i));
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        Type type;
        if (isHideOnNull() && (((type = this.mType) == Type.SMALL_TEXT || type == Type.BIG_TEXT) && (TextUtils.isEmpty(charSequence) || charSequence.toString().equalsIgnoreCase("0")))) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
        super.setText(charSequence, bufferType);
    }

    public BadgeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = null;
        this.mCountFormatType = null;
        this.mHideOnNull = true;
        this.currentFontLevel = -1;
        this.mIsNormalSize = false;
        init(context, attributeSet);
    }

    public void changeBackgroundColor(boolean z, int i, int i2) {
        this.isChangeBackgroundColor = z;
        this.backgroundColor = i;
        this.backgroundColorNight = i2;
        updateNightMode();
    }

    private int createNormalBg() {
        int color = getResources().getColor(R.color.obfuscated_res_0x7f06037c);
        if (this.isChangeBackgroundColor) {
            if (NightModeHelper.isNightMode()) {
                return this.backgroundColorNight;
            }
            return this.backgroundColor;
        }
        return color;
    }

    private Drawable createSmallTextBg() {
        Drawable scaledDrawableRes = FontSizeHelper.getScaledDrawableRes(0, getDrawableResource());
        if (this.isChangeBackgroundColor && scaledDrawableRes != null) {
            scaledDrawableRes = DrawableCompat.wrap(scaledDrawableRes.mutate());
            if (NightModeHelper.isNightMode()) {
                DrawableCompat.setTint(scaledDrawableRes, this.backgroundColorNight);
            } else {
                DrawableCompat.setTint(scaledDrawableRes, this.backgroundColor);
            }
        }
        return scaledDrawableRes;
    }

    private void ensureShapeBg() {
        if (this.mRoundRectBg == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.mRoundRectBg = gradientDrawable;
            gradientDrawable.setColor(createNormalBg());
            this.mRoundRectBg.setCornerRadius(FontSizeHelper.getScaledSize(0, getHeight() / 2, 2));
        }
    }

    private int getDrawableResource() {
        if (this.mIsNormalSize) {
            return R.drawable.badge_bg_small_text_normal_style;
        }
        return R.drawable.obfuscated_res_0x7f080226;
    }

    private void updateBadgeLayout() {
        DefaultPosition defaultPosition;
        View view2;
        if ((getLayoutParams() instanceof RelativeLayout.LayoutParams) && (defaultPosition = this.viewPositionType) != null && (view2 = this.bindBadgeView) != null) {
            setBadgeStyle(view2, this.badgeLayoutParams, defaultPosition);
        }
    }

    public Integer getBadgeCount() {
        if (getText() == null) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(getText().toString()));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public int getBadgeGravity() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return ((FrameLayout.LayoutParams) layoutParams).gravity;
        }
        return 0;
    }

    public int[] getBadgeMargin() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        return new int[]{marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin};
    }

    public Type getType() {
        return this.mType;
    }

    public int getViewBottomMargin() {
        return this.viewBottomMargin;
    }

    public int getViewLeftMargin() {
        return this.viewLeftMargin;
    }

    public boolean isHideOnNull() {
        return this.mHideOnNull;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateNightMode();
        NightModeHelper.subscribeNightModeChangeEvent(this, new NightModeChangeListener() { // from class: com.baidu.searchbox.ui.view.BadgeView.1
            @Override // com.baidu.searchbox.skin.callback.NightModeChangeListener
            public void onNightModeChanged(boolean z) {
                BadgeView.this.updateNightMode();
            }
        });
        BdEventBus.Companion.getDefault().register(this, FontSizeChangeMessage.class, 1, new Action<FontSizeChangeMessage>() { // from class: com.baidu.searchbox.ui.view.BadgeView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.bdeventbus.Action
            public void call(FontSizeChangeMessage fontSizeChangeMessage) {
                BadgeView.this.updateSizeAndPosition();
                BadgeView.this.requestLayout();
            }
        });
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        NightModeHelper.unsubscribeNightModeChangedEvent(this);
        BdEventBus.Companion.getDefault().unregister(this);
    }

    public void unbind() {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
    }

    public void updateNightMode() {
        setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06037b));
        if (this.mType == Type.SMALL_TEXT) {
            Drawable createSmallTextBg = createSmallTextBg();
            this.smallTextBg = createSmallTextBg;
            setBackground(createSmallTextBg);
            return;
        }
        GradientDrawable gradientDrawable = this.mRoundRectBg;
        if (gradientDrawable != null) {
            gradientDrawable.setColor(createNormalBg());
        }
    }

    public void updateSizeAndPosition() {
        if (this.mType == null) {
            this.currentFontLevel = -1;
            return;
        }
        updateBadgeSize();
        updateBadgeLayout();
    }

    private String formatCount(int i) {
        int i2 = AnonymousClass3.$SwitchMap$com$baidu$searchbox$ui$view$BadgeView$CountFormatType[this.mCountFormatType.ordinal()];
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 != 4) {
                    return i + "";
                } else if (i < 10000) {
                    return i + "";
                } else if (10000 <= i && i < 100000) {
                    return new DecimalFormat("#.#").format(i / 10000.0f) + "万";
                } else if (100000 <= i && i < 100000000) {
                    return (i / 10000) + "万";
                } else if (100000000 <= i && i < 1000000000) {
                    return new DecimalFormat("#.#").format(i / 1.0E8f) + "亿";
                } else {
                    return (i / 100000000) + "亿";
                }
            } else if (i > 999) {
                return "999+";
            } else {
                return i + "";
            }
        } else if (i > 99) {
            return "99+";
        } else {
            return i + "";
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mLrPaddingInBigTextType = FontSizeHelper.getScaledSize(0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07018c), 2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.android.common.ui.R.styleable.badge);
        this.mType = Type.getType(obtainStyledAttributes.getInt(1, Type.DOT.value));
        this.mCountFormatType = CountFormatType.getCountFormatType(obtainStyledAttributes.getInt(0, CountFormatType.MAX_99.value));
        obtainStyledAttributes.recycle();
        if (getLayoutParams() == null) {
            setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 53));
        }
        setTextColor(getResources().getColor(R.color.obfuscated_res_0x7f06037b));
        setGravity(17);
    }

    private void setBadgeStyle(View view2, RelativeLayout.LayoutParams layoutParams, DefaultPosition defaultPosition) {
        Resources resources = getResources();
        switch (AnonymousClass3.$SwitchMap$com$baidu$searchbox$ui$view$BadgeView$DefaultPosition[defaultPosition.ordinal()]) {
            case 1:
                setBadgeViewPosition(view2, layoutParams, resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070191), resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07018f));
                return;
            case 2:
                setBadgeViewPosition(view2, layoutParams, resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070192), resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070190));
                return;
            case 3:
                setBadgeViewPosition(view2, layoutParams, resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070195), resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070193));
                return;
            case 4:
                setBadgeViewPosition(view2, layoutParams, resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070196), resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070194));
                return;
            case 5:
                setBadgeViewPosition(view2, layoutParams, 0, 0);
                return;
            case 6:
                setBadgeViewPosition(view2, layoutParams, resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07019d), resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07019b));
                return;
            default:
                return;
        }
    }

    private void setBadgeViewPosition(View view2, RelativeLayout.LayoutParams layoutParams, int i, int i2) {
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view2.getLayoutParams();
        int paddingRight = layoutParams2.rightMargin + view2.getPaddingRight();
        int paddingTop = layoutParams2.topMargin + view2.getPaddingTop();
        this.viewLeftMargin = i - paddingRight;
        this.viewBottomMargin = i2 - paddingTop;
        layoutParams.leftMargin = FontSizeHelper.getScaledSize(0, i, 2) - paddingRight;
        layoutParams.bottomMargin = FontSizeHelper.getScaledSize(0, i2, 2) - paddingTop;
    }

    public void setBadgeMargin(int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        marginLayoutParams.leftMargin = dip2Px(i);
        marginLayoutParams.topMargin = dip2Px(i2);
        marginLayoutParams.rightMargin = dip2Px(i3);
        marginLayoutParams.bottomMargin = dip2Px(i4);
        setLayoutParams(marginLayoutParams);
    }

    public void setBadgeMarginInPx(int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        marginLayoutParams.leftMargin = i;
        marginLayoutParams.topMargin = i2;
        marginLayoutParams.rightMargin = i3;
        marginLayoutParams.bottomMargin = i4;
        setLayoutParams(marginLayoutParams);
    }

    private void setTypeParams() {
        int i;
        if (this.mType == null) {
            return;
        }
        int i2 = this.currentFontLevel;
        this.currentFontLevel = FontSizeHelper.getFontSizeType();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int i3 = AnonymousClass3.$SwitchMap$com$baidu$searchbox$ui$view$BadgeView$Type[this.mType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    layoutParams.width = -2;
                    if (this.bigTextHeight == 0 || this.bigTextSize == 0 || i2 != this.currentFontLevel) {
                        this.bigTextHeight = FontSizeHelper.getScaledSize(0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07018b), 2);
                        this.bigTextSize = FontSizeHelper.getScaledSizeRes(0, R.dimen.obfuscated_res_0x7f0702da, 2);
                    }
                    layoutParams.height = this.bigTextHeight;
                    int i4 = this.mLrPaddingInBigTextType;
                    setPadding(i4, 0, i4, 0);
                    ensureShapeBg();
                    setBackground(this.mRoundRectBg);
                    setMinWidth(this.bigTextHeight);
                    setTextSize(0, this.bigTextSize);
                    if (TextUtils.isEmpty(getText())) {
                        setVisibility(8);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.mIsNormalSize) {
                i = FontSizeHelper.getScaledSize(0, getResources().getDimensionPixelSize(R.dimen.badge_small_text_normal_size), 2);
            } else {
                i = -2;
            }
            layoutParams.width = -2;
            layoutParams.height = i;
            if (this.smallTextBg == null || this.smallTextSize == 0 || i2 != this.currentFontLevel || this.mIsNormalSize) {
                this.smallTextBg = createSmallTextBg();
                this.smallTextSize = FontSizeHelper.getScaledSizeRes(0, R.dimen.obfuscated_res_0x7f070332, 2);
            }
            setBackground(this.smallTextBg);
            setMinWidth(0);
            setTextSize(0, this.smallTextSize);
            if (TextUtils.isEmpty(getText())) {
                setVisibility(8);
                return;
            }
            return;
        }
        if (this.dotSize == 0 || i2 != this.currentFontLevel) {
            this.dotSize = FontSizeHelper.getScaledSize(0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07018d), 2);
        }
        if (this.mIsNormalSize) {
            this.dotSize = FontSizeHelper.getScaledSize(0, getResources().getDimensionPixelSize(R.dimen.badge_dot_normal_size), 2);
        }
        int i5 = this.dotSize;
        layoutParams.width = i5;
        layoutParams.height = i5;
        ensureShapeBg();
        setBackground(this.mRoundRectBg);
        setMinWidth(0);
        setText("");
    }

    private void updateBadgeSize() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int i = AnonymousClass3.$SwitchMap$com$baidu$searchbox$ui$view$BadgeView$Type[this.mType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    this.bigTextHeight = FontSizeHelper.getScaledSize(0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07018b), 2);
                    this.bigTextSize = FontSizeHelper.getScaledSizeRes(0, R.dimen.obfuscated_res_0x7f0702da, 2);
                    layoutParams.height = this.bigTextHeight;
                    int scaledSize = FontSizeHelper.getScaledSize(0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07018c), 2);
                    this.mLrPaddingInBigTextType = scaledSize;
                    setPadding(scaledSize, 0, scaledSize, 0);
                    setTextSize(0, this.bigTextSize);
                    return;
                }
                return;
            }
            this.smallTextBg = createSmallTextBg();
            this.smallTextSize = FontSizeHelper.getScaledSizeRes(0, R.dimen.obfuscated_res_0x7f070332, 2);
            setBackground(this.smallTextBg);
            setTextSize(0, this.smallTextSize);
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07018d);
        if (this.mIsNormalSize) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.badge_dot_normal_size);
        }
        int scaledSize2 = FontSizeHelper.getScaledSize(0, dimensionPixelSize, 2);
        this.dotSize = scaledSize2;
        layoutParams.width = scaledSize2;
        layoutParams.height = scaledSize2;
    }

    @Deprecated
    public void bindView(View view2) {
        ViewGroup viewGroup;
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        if (view2 == null || (viewGroup = (ViewGroup) view2.getParent()) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            setLayoutParams(new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height));
        }
        ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
        if ((viewGroup instanceof FrameLayout) && layoutParams2.width == -1 && layoutParams2.height == -1) {
            viewGroup.addView(this);
            return;
        }
        int indexOfChild = viewGroup.indexOfChild(view2);
        viewGroup.removeView(view2);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(layoutParams2);
        viewGroup.addView(frameLayout, indexOfChild, layoutParams2);
        view2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.addView(view2);
        frameLayout.addView(this);
    }

    @Deprecated
    public void bindView(View view2, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            layoutParams = new FrameLayout.LayoutParams(layoutParams.width, layoutParams.height);
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.gravity = i;
        layoutParams2.leftMargin = i2;
        layoutParams2.topMargin = i3;
        layoutParams2.rightMargin = i4;
        layoutParams2.bottomMargin = i5;
        setLayoutParams(layoutParams);
        bindView(view2);
    }

    public void bindViewInRelativeLayout(View view2, RelativeLayout relativeLayout, DefaultPosition defaultPosition) {
        int id;
        this.bindBadgeView = view2;
        this.viewPositionType = defaultPosition;
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        if (view2.getParent() == relativeLayout && (id = view2.getId()) != -1) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height);
            layoutParams2.addRule(1, id);
            layoutParams2.addRule(2, id);
            this.badgeLayoutParams = layoutParams2;
            setBadgeStyle(view2, layoutParams2, defaultPosition);
            relativeLayout.addView(this, layoutParams2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        GradientDrawable gradientDrawable = this.mRoundRectBg;
        if (gradientDrawable != null) {
            gradientDrawable.setCornerRadius(FontSizeHelper.getScaledSize(0, getHeight() / 2, 2));
        }
    }

    @Deprecated
    public void setBadgeCount(String str) {
        if (this.mType == Type.DOT) {
            setType(Type.SMALL_TEXT);
        }
        setText(str);
    }
}
