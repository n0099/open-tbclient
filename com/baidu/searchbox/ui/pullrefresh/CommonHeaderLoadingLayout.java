package com.baidu.searchbox.ui.pullrefresh;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes4.dex */
public class CommonHeaderLoadingLayout extends LoadingLayout {
    public static final int HEADER_H = 50;
    public static final float REFRESHING_HEIGHT_MULTIPLE = 1.5f;
    public static final int REFRESHING_VIEW_SIZE_IN_DP = 29;
    public static final int REFRESH_OVER_TIP_ANIM_IN_DURATION = 150;
    public static final int REFRESH_OVER_TIP_HOLD_TIME = 800;
    public static final float TRIGGER_REFRESH_LENGTH_MULTIPLE = 2.4f;
    public HeaderRefreshIndicator mRefreshOverTip;
    public int mRefreshingHeight;
    public RefreshingAnimView mRefreshingView;
    public int mRefreshingViewSizeInPixel;
    public View mRootChild;
    public int mScrollStartLength;
    public int mTriggerRefreshLength;

    public CommonHeaderLoadingLayout(Context context) {
        super(context);
        this.mRefreshingViewSizeInPixel = 0;
        this.mRefreshingView = (RefreshingAnimView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091eba);
        int dp2px = DeviceUtil.ScreenInfo.dp2px(getContext(), 29.0f);
        this.mRefreshingViewSizeInPixel = dp2px;
        this.mTriggerRefreshLength = (int) (dp2px * 2.4f);
        int i = (int) (dp2px * 1.5f);
        this.mRefreshingHeight = i;
        this.mScrollStartLength = i;
        HeaderRefreshIndicator headerRefreshIndicator = (HeaderRefreshIndicator) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f091eb7);
        this.mRefreshOverTip = headerRefreshIndicator;
        headerRefreshIndicator.initIfNeed();
    }

    public float calculateOffsetAnimPercent(int i) {
        float f;
        int i2 = this.mTriggerRefreshLength;
        float f2 = 0.0f;
        if (i < i2) {
            int i3 = this.mRefreshingViewSizeInPixel;
            if (i < i3) {
                f = 0.0f;
            } else {
                f = (i - i3) / (i2 - i3);
            }
        } else {
            f = 1.0f;
        }
        if (f >= 0.0f) {
            f2 = f;
        }
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onPullLength(int i) {
        if (getState() == ILoadingLayout.State.PULL_TO_REFRESH) {
            this.mRefreshingView.setAnimPercent(calculateOffsetAnimPercent(i));
        }
        int i2 = this.mScrollStartLength;
        if (i > i2) {
            setTranslationY((i2 - i) / 2);
        }
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void setHeaderBackgroundResource(int i) {
        super.setHeaderBackgroundResource(i);
        this.mRefreshOverTip.initResources();
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public View createLoadingView(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate(com.baidu.tieba.R.layout.obfuscated_res_0x7f0d0218, viewGroup, false);
        this.mRootChild = inflate;
        return inflate;
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public int getCanRefreshPullLength() {
        return this.mTriggerRefreshLength;
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout, com.baidu.searchbox.ui.pullrefresh.ILoadingLayout
    public int getContentSize() {
        View view2 = this.mRootChild;
        if (view2 != null) {
            return view2.getHeight();
        }
        return DeviceUtil.ScreenInfo.dp2px(getContext(), 50.0f);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public int getRefreshingHeight() {
        return this.mRefreshingHeight;
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onPullToRefresh() {
        this.mRefreshingView.setAlpha(1.0f);
        this.mRefreshingView.stopAnim();
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onRefreshing() {
        this.mRefreshingView.startMagnifierRotate();
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onReleaseToLongRefresh() {
        this.mRefreshingView.setAnimPercent(1.0f);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onReleaseToRefresh() {
        this.mRefreshingView.setAnimPercent(1.0f);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onReset() {
        setTranslationY(0.0f);
        this.mRefreshingView.setAlpha(1.0f);
        this.mRefreshingView.stopAnim();
        this.mRefreshOverTip.setVisibility(4);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onPullRefreshComplete(boolean z, String str, final Runnable runnable) {
        if (z) {
            this.mRefreshingView.setAlpha(0.0f);
            if (TextUtils.isEmpty(str)) {
                this.mRefreshOverTip.setText(getResources().getText(com.baidu.tieba.R.string.obfuscated_res_0x7f0f1180));
            } else {
                this.mRefreshOverTip.setText(str);
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(this.mRefreshOverTip.getHeight(), 0);
            ofInt.setDuration(150L);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.ui.pullrefresh.CommonHeaderLoadingLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CommonHeaderLoadingLayout.this.mRefreshOverTip.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.searchbox.ui.pullrefresh.CommonHeaderLoadingLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    CommonHeaderLoadingLayout.this.postDelayed(runnable, 800L);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    CommonHeaderLoadingLayout.this.mRefreshOverTip.setTranslationY(0.0f);
                    CommonHeaderLoadingLayout.this.mRefreshOverTip.setVisibility(0);
                }
            });
            ofInt.start();
            return;
        }
        setState(ILoadingLayout.State.PULL_TO_REFRESH);
        runnable.run();
    }
}
