package com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.ILoadingLayout;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
/* loaded from: classes2.dex */
public class CommonHeaderLoadingLayout extends LoadingLayout {
    private static final int HEADER_H = 50;
    private static final float REFRESHING_HEIGHT_MULTIPLE = 1.5f;
    private static final int REFRESHING_VIEW_SIZE_IN_DP = 29;
    private static final int REFRESH_OVER_TIP_ANIM_IN_DURATION = 150;
    private static final int REFRESH_OVER_TIP_HOLD_TIME = 800;
    private static final float TRIGGER_REFRESH_LENGTH_MULTIPLE = 2.4f;
    private HeaderRefreshIndicator mRefreshOverTip;
    private int mRefreshingHeight;
    private RefreshingAnimView mRefreshingView;
    private int mRefreshingViewSizeInPixel;
    private View mRootChild;
    private int mScrollStartLength;
    private int mTriggerRefreshLength;

    public CommonHeaderLoadingLayout(Context context) {
        super(context);
        this.mRefreshingViewSizeInPixel = 0;
        this.mRefreshingView = (RefreshingAnimView) findViewById(R.id.refreshing_anim_view);
        this.mRefreshingViewSizeInPixel = AiAppsUIUtils.dip2px(getContext(), 29.0f);
        this.mTriggerRefreshLength = (int) (TRIGGER_REFRESH_LENGTH_MULTIPLE * this.mRefreshingViewSizeInPixel);
        this.mRefreshingHeight = (int) (REFRESHING_HEIGHT_MULTIPLE * this.mRefreshingViewSizeInPixel);
        this.mScrollStartLength = this.mRefreshingHeight;
        this.mRefreshOverTip = (HeaderRefreshIndicator) findViewById(R.id.refresh_over_tip);
        this.mRefreshOverTip.initIfNeed();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout, com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.ILoadingLayout
    public int getContentSize() {
        return this.mRootChild != null ? this.mRootChild.getHeight() : AiAppsUIUtils.dip2px(getContext(), 50.0f);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    protected View createLoadingView(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        this.mRootChild = LayoutInflater.from(context).inflate(R.layout.aiapps_common_pull_to_refresh_header, viewGroup, false);
        return this.mRootChild;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        setTranslationY(0.0f);
        this.mRefreshingView.setAlpha(1.0f);
        this.mRefreshingView.stopAnim();
        this.mRefreshOverTip.setVisibility(4);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.mRefreshingView.setAlpha(1.0f);
        this.mRefreshingView.stopAnim();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    public void setHeaderBackgroundResource(int i) {
        super.setHeaderBackgroundResource(i);
        this.mRefreshOverTip.initResources();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    public void onReleaseToLongRefresh() {
        this.mRefreshingView.setAnimPercent(1.0f);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.mRefreshingView.setAnimPercent(1.0f);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        this.mRefreshingView.startMagnifierRotate();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    public int getCanRefreshPullLength() {
        return this.mTriggerRefreshLength;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    public void onPullLength(int i) {
        if (getState() == ILoadingLayout.State.PULL_TO_REFRESH) {
            this.mRefreshingView.setAnimPercent(calculateOffsetAnimPercent(i));
        }
        if (i > this.mScrollStartLength) {
            setTranslationY((this.mScrollStartLength - i) / 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    public int getRefreshingHeight() {
        return this.mRefreshingHeight;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    public void onPullRefreshComplete(boolean z, String str, final Runnable runnable) {
        if (z) {
            this.mRefreshingView.setAlpha(0.0f);
            if (TextUtils.isEmpty(str)) {
                this.mRefreshOverTip.setText(getResources().getText(R.string.aiapps_pull_down_refresh_success));
            } else {
                this.mRefreshOverTip.setText(str);
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(this.mRefreshOverTip.getHeight(), 0);
            ofInt.setDuration(150L);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.CommonHeaderLoadingLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CommonHeaderLoadingLayout.this.mRefreshOverTip.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            ofInt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.CommonHeaderLoadingLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    CommonHeaderLoadingLayout.this.mRefreshOverTip.setTranslationY(0.0f);
                    CommonHeaderLoadingLayout.this.mRefreshOverTip.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    CommonHeaderLoadingLayout.this.postDelayed(runnable, 800L);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            ofInt.start();
            return;
        }
        setState(ILoadingLayout.State.PULL_TO_REFRESH);
        runnable.run();
    }

    protected float calculateOffsetAnimPercent(int i) {
        float f;
        if (i < this.mTriggerRefreshLength) {
            f = i < this.mRefreshingViewSizeInPixel ? 0.0f : (i - this.mRefreshingViewSizeInPixel) / (this.mTriggerRefreshLength - this.mRefreshingViewSizeInPixel);
        } else {
            f = 1.0f;
        }
        float f2 = f >= 0.0f ? f : 0.0f;
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }
}
