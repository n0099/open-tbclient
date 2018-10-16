package com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.ILoadingLayout;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
/* loaded from: classes2.dex */
public class NeutralHeaderLoadingLayout extends LoadingLayout {
    private static final boolean DEBUG = false;
    private static final int DURATION_ALPHA_ANIM = 150;
    private static final int HEADER_H = 50;
    private static final float REFRESHING_HEIGHT_MULTIPLE = 1.5f;
    private static final int REFRESHING_VIEW_SIZE_IN_DP = 29;
    private static final String TAG = "NeutralLoadingLayout";
    private static final float TRIGGER_REFRESH_LENGTH_MULTIPLE = 2.4f;
    private NeutralRefreshAnimView mAnimView;
    private int mRefreshingHeight;
    private int mRefreshingViewSizeInPixel;
    private View mRootChild;
    private int mScrollStartLength;
    private int mTriggerRefreshLength;

    public NeutralHeaderLoadingLayout(Context context) {
        super(context);
        this.mRefreshingViewSizeInPixel = 0;
        init();
    }

    private void init() {
        this.mAnimView = (NeutralRefreshAnimView) findViewById(R.id.neutral_refresh_anim_view);
        this.mRefreshingViewSizeInPixel = AiAppsUIUtils.dip2px(getContext(), 29.0f);
        this.mTriggerRefreshLength = (int) (TRIGGER_REFRESH_LENGTH_MULTIPLE * this.mRefreshingViewSizeInPixel);
        this.mRefreshingHeight = (int) (REFRESHING_HEIGHT_MULTIPLE * this.mRefreshingViewSizeInPixel);
        this.mScrollStartLength = this.mRefreshingHeight;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout, com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.ILoadingLayout
    public int getContentSize() {
        return this.mRootChild != null ? this.mRootChild.getHeight() : AiAppsUIUtils.dip2px(getContext(), 50.0f);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    protected View createLoadingView(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        this.mRootChild = LayoutInflater.from(getContext()).inflate(R.layout.aiapps_neutral_pull_to_refresh_header, viewGroup, false);
        return this.mRootChild;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReset() {
        this.mAnimView.stopAnim();
        this.mAnimView.setAlpha(1.0f);
        setTranslationY(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    public void onPullLength(int i) {
        if (getState() == ILoadingLayout.State.PULL_TO_REFRESH) {
            this.mAnimView.setAnimPercent(calculateOffsetAnimPercent(i));
        }
        if (i > this.mScrollStartLength) {
            setTranslationY((this.mScrollStartLength - i) / 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    public void onPullRefreshComplete(boolean z, String str, final Runnable runnable) {
        this.mAnimView.stopAnim();
        this.mAnimView.onRefreshCompleteAnim();
        post(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.NeutralHeaderLoadingLayout.1
            @Override // java.lang.Runnable
            public void run() {
                runnable.run();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    public void onReleaseToLongRefresh() {
        this.mAnimView.setAnimPercent(1.0f);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    protected void onReleaseToRefresh() {
        this.mAnimView.setAnimPercent(1.0f);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    protected void onPullToRefresh() {
        this.mAnimView.setAlpha(1.0f);
        this.mAnimView.stopAnim();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    public int getRefreshingHeight() {
        return this.mRefreshingHeight;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    public int getCanRefreshPullLength() {
        return this.mTriggerRefreshLength;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.res.ui.pullrefresh.LoadingLayout
    protected void onRefreshing() {
        this.mAnimView.onRefreshingAnim();
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
