package com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.TranslateAnimation;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.res.ui.DrawableCenterTextView;
import com.baidu.searchbox.ng.ai.apps.skin.AiAppNightModeHelper;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
/* loaded from: classes2.dex */
public class HeaderRefreshIndicator extends DrawableCenterTextView {
    private static final long ANIMATION_DURATION_MS = 280;
    private static final int DEFAULT_BORDER_DIRECTION = 3;
    private static final int DEFAULT_REFRESH_RESULT = -1;
    public boolean isInited;
    private boolean mIsHomePage;
    private boolean mIsNightMode;
    private int mRefreshResult;

    public HeaderRefreshIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public HeaderRefreshIndicator(Context context, boolean z) {
        this(context, null, z);
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isInited = false;
        this.mRefreshResult = -1;
        this.mIsNightMode = false;
    }

    public HeaderRefreshIndicator(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        this.isInited = false;
        this.mRefreshResult = -1;
        this.mIsNightMode = false;
        this.mIsHomePage = z;
    }

    public void initIfNeed() {
        if (!this.isInited) {
            this.isInited = true;
            this.mIsNightMode = AiAppNightModeHelper.getNightModeSwitcherState();
            initResources();
            setTextSize(1, 11.0f);
            setCompoundDrawablePadding(AiAppsUIUtils.dip2px(getContext(), 5.0f));
            initCornerRadius(0);
        }
    }

    public void startAnim() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, getHeight(), 0.0f);
        translateAnimation.setDuration(ANIMATION_DURATION_MS);
        setAnimation(translateAnimation);
        translateAnimation.startNow();
    }

    public void resetTheme() {
        boolean nightModeSwitcherState = AiAppNightModeHelper.getNightModeSwitcherState();
        if (this.mIsNightMode != nightModeSwitcherState) {
            initResources();
            this.mIsNightMode = nightModeSwitcherState;
        }
    }

    public void changeTheme(boolean z) {
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        resetTheme();
    }

    public void initResources() {
        setBackground(getResources().getDrawable(R.drawable.aiapps_pull_refresh_success_tip_bg));
        setTextColor(getResources().getColor(R.color.aiapps_pull_refresh_result_text_color));
        initDrawable(getResources().getDrawable(R.drawable.aiapps_pull_refresh_success_tip_icon), 0, AiAppsUIUtils.dip2px(getContext(), 11.0f), AiAppsUIUtils.dip2px(getContext(), 11.0f));
    }
}
