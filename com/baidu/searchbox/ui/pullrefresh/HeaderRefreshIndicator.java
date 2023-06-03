package com.baidu.searchbox.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.TranslateAnimation;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import com.baidu.android.common.others.UIUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.skin.NightModeHelper;
/* loaded from: classes4.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    public static final long ANIMATION_DURATION_MS = 280;
    public static final int DEFAULT_BG_ID = 2131235340;
    public static final int DEFAULT_BORDER_DIRECTION = 3;
    public static final int DEFAULT_REFRESH_RESULT = -1;
    public static final int DEFAULT_SUCCESS_TIP_ICON = 2131235341;
    public static final int DEFAULT_TEXT_COLOR_ID = 2131102046;
    public boolean isInited;
    @DrawableRes
    public int mBackgroundDrawableId;
    public int mDrawableWidth;
    public boolean mIsHomePage;
    public boolean mIsNightMode;
    public boolean mNeedResetTheme;
    public int mRefreshResult;
    @DrawableRes
    public int mSuccessTipIcon;
    @ColorRes
    public int mTextColorId;

    public void changeTheme(boolean z) {
    }

    public HeaderRefreshIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public void needResetTheme(boolean z) {
        this.mNeedResetTheme = z;
    }

    public HeaderRefreshIndicator setBackgroundDrawableId(@DrawableRes int i) {
        this.mBackgroundDrawableId = i;
        return this;
    }

    public HeaderRefreshIndicator setSuccessTipIcon(@DrawableRes int i) {
        this.mSuccessTipIcon = i;
        return this;
    }

    public HeaderRefreshIndicator setTextColorId(@ColorRes int i) {
        this.mTextColorId = i;
        return this;
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isInited = false;
        this.mRefreshResult = -1;
        this.mIsNightMode = false;
        this.mNeedResetTheme = true;
        this.mBackgroundDrawableId = DEFAULT_BG_ID;
        this.mTextColorId = DEFAULT_TEXT_COLOR_ID;
        this.mSuccessTipIcon = DEFAULT_SUCCESS_TIP_ICON;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.isInited = false;
        this.mRefreshResult = -1;
        this.mIsNightMode = false;
        this.mNeedResetTheme = true;
        this.mBackgroundDrawableId = DEFAULT_BG_ID;
        this.mTextColorId = DEFAULT_TEXT_COLOR_ID;
        this.mSuccessTipIcon = DEFAULT_SUCCESS_TIP_ICON;
        this.mIsHomePage = z;
        this.mDrawableWidth = DeviceUtil.ScreenInfo.dp2px(getContext(), 11.0f);
    }

    public HeaderRefreshIndicator(Context context, boolean z) {
        this(context, null, z);
    }

    public int getDrawWidth() {
        return UIUtils.getTextViewWidth(this) + this.mDrawableWidth + getCompoundDrawablePadding();
    }

    public void initIfNeed() {
        if (this.isInited) {
            return;
        }
        this.isInited = true;
        this.mIsNightMode = NightModeHelper.getNightModeSwitcherState();
        initResources();
        setTextSize(1, 11.0f);
        setCompoundDrawablePadding(DeviceUtil.ScreenInfo.dp2px(getContext(), 5.0f));
        initCornerRadius(0);
    }

    public void initResources() {
        setBackground(getResources().getDrawable(this.mBackgroundDrawableId));
        setTextColor(getResources().getColor(this.mTextColorId));
        initTipIcon();
    }

    public void initTipIcon() {
        initDrawable(getResources().getDrawable(this.mSuccessTipIcon), 0, this.mDrawableWidth, DeviceUtil.ScreenInfo.dp2px(getContext(), 11.0f));
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resetTheme();
    }

    public void resetTheme() {
        boolean nightModeSwitcherState = NightModeHelper.getNightModeSwitcherState();
        if (this.mIsNightMode != nightModeSwitcherState) {
            if (this.mNeedResetTheme) {
                initResources();
            } else {
                initTipIcon();
            }
            this.mIsNightMode = nightModeSwitcherState;
        }
    }

    public void startAnim() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, getHeight(), 0.0f);
        translateAnimation.setDuration(280L);
        setAnimation(translateAnimation);
        translateAnimation.startNow();
    }
}
