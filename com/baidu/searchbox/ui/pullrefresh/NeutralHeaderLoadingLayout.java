package com.baidu.searchbox.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.ui.pullrefresh.ILoadingLayout;
/* loaded from: classes4.dex */
public class NeutralHeaderLoadingLayout extends LoadingLayout {
    public static final boolean DEBUG = false;
    public static final int DURATION_ALPHA_ANIM = 150;
    public static final int HEADER_H = 50;
    public static final float REFRESHING_HEIGHT_MULTIPLE = 1.5f;
    public static final int REFRESHING_VIEW_SIZE_IN_DP = 29;
    public static final String TAG = "NeutralLoadingLayout";
    public static final float TRIGGER_REFRESH_LENGTH_MULTIPLE = 2.4f;
    public NeutralRefreshAnimView mAnimView;
    public int mRefreshingHeight;
    public int mRefreshingViewSizeInPixel;
    public View mRootChild;
    public int mScrollStartLength;
    public int mTriggerRefreshLength;

    public NeutralHeaderLoadingLayout(Context context) {
        super(context);
        this.mRefreshingViewSizeInPixel = 0;
        init();
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
            this.mAnimView.setAnimPercent(calculateOffsetAnimPercent(i));
        }
        int i2 = this.mScrollStartLength;
        if (i > i2) {
            setTranslationY((i2 - i) / 2);
        }
    }

    private void init() {
        this.mAnimView = (NeutralRefreshAnimView) findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f0918f1);
        int dp2px = DeviceUtil.ScreenInfo.dp2px(getContext(), 29.0f);
        this.mRefreshingViewSizeInPixel = dp2px;
        this.mTriggerRefreshLength = (int) (dp2px * 2.4f);
        int i = (int) (dp2px * 1.5f);
        this.mRefreshingHeight = i;
        this.mScrollStartLength = i;
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
        this.mAnimView.setAlpha(1.0f);
        this.mAnimView.stopAnim();
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onRefreshing() {
        this.mAnimView.onRefreshingAnim();
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onReleaseToLongRefresh() {
        this.mAnimView.setAnimPercent(1.0f);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onReleaseToRefresh() {
        this.mAnimView.setAnimPercent(1.0f);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onReset() {
        this.mAnimView.stopAnim();
        this.mAnimView.setAlpha(1.0f);
        setTranslationY(0.0f);
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public View createLoadingView(Context context, ViewGroup viewGroup, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(getContext()).inflate(com.baidu.tieba.R.layout.obfuscated_res_0x7f0d06eb, viewGroup, false);
        this.mRootChild = inflate;
        return inflate;
    }

    @Override // com.baidu.searchbox.ui.pullrefresh.LoadingLayout
    public void onPullRefreshComplete(boolean z, String str, final Runnable runnable) {
        this.mAnimView.stopAnim();
        this.mAnimView.onRefreshCompleteAnim();
        post(new Runnable() { // from class: com.baidu.searchbox.ui.pullrefresh.NeutralHeaderLoadingLayout.1
            @Override // java.lang.Runnable
            public void run() {
                runnable.run();
            }
        });
    }
}
