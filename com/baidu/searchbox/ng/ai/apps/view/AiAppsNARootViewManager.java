package com.baidu.searchbox.ng.ai.apps.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.ng.ai.apps.core.container.NgWebView;
import com.baidu.searchbox.ng.ai.apps.core.container.PullToRefreshWebView;
import com.baidu.searchbox.ng.ai.apps.core.listener.IOnScrollChangedListener;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlaveManager;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsRectPosition;
import com.baidu.searchbox.ng.ai.apps.view.container.IAiAppsNAViewRoot;
import com.baidu.searchbox.ng.ai.apps.view.container.model.NAViewCache;
/* loaded from: classes2.dex */
public class AiAppsNARootViewManager implements PullToRefreshWebView.OnPullToRefreshScrollChangeListener, IOnScrollChangedListener, IAiAppsNAViewRoot {
    private static final boolean DEBUG = false;
    private static final String TAG = "NAParentViewManager";
    private Context mContext;
    private NAViewCache mCoverViewCache = new NAViewCache();
    private FrameLayout mNAFrameLayout;
    private NgWebView mNgWebView;
    private FrameLayout mParentFrameLayout;
    private PullToRefreshWebView mPullToRefreshWebView;
    private AiAppsSlaveManager mSlaveManager;

    public AiAppsNARootViewManager(Context context, @NonNull AiAppsSlaveManager aiAppsSlaveManager, @NonNull FrameLayout frameLayout) {
        this.mContext = context;
        this.mParentFrameLayout = frameLayout;
        this.mSlaveManager = aiAppsSlaveManager;
        createViewAndListener(aiAppsSlaveManager);
    }

    public FrameLayout getNAFrameLayout() {
        return this.mNAFrameLayout;
    }

    public int getNAFrameLayoutChildCount() {
        return this.mNAFrameLayout.getChildCount();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.view.container.IAiAppsNAViewRoot
    public boolean insertView(View view, AiAppsRectPosition aiAppsRectPosition) {
        if (this.mContext == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aiAppsRectPosition.getWidth(), aiAppsRectPosition.getHeight());
        layoutParams.leftMargin = aiAppsRectPosition.getLeft();
        layoutParams.topMargin = aiAppsRectPosition.getTop();
        this.mNAFrameLayout.addView(view, layoutParams);
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.view.container.IAiAppsNAViewRoot
    public boolean removeView(View view) {
        if (this.mNAFrameLayout != null && aViewIsChildOfbViewGroup(view, this.mNAFrameLayout)) {
            this.mNAFrameLayout.removeView(view);
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.view.container.IAiAppsNAViewRoot
    public boolean updateView(View view, AiAppsRectPosition aiAppsRectPosition) {
        if (view == null || this.mNAFrameLayout == null || aiAppsRectPosition == null || !aViewIsChildOfbViewGroup(view, this.mNAFrameLayout)) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aiAppsRectPosition.getWidth(), aiAppsRectPosition.getHeight());
        layoutParams.leftMargin = aiAppsRectPosition.getLeft();
        layoutParams.topMargin = aiAppsRectPosition.getTop();
        this.mNAFrameLayout.updateViewLayout(view, layoutParams);
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.view.container.IAiAppsNAViewRoot
    public NAViewCache getNAViewCache() {
        return this.mCoverViewCache;
    }

    private boolean aViewIsChildOfbViewGroup(View view, ViewGroup viewGroup) {
        return view != null && viewGroup != null && view.getParent() == viewGroup && viewGroup.indexOfChild(view) >= 0;
    }

    private boolean createViewAndListener(AiAppsSlaveManager aiAppsSlaveManager) {
        aiAppsSlaveManager.addOnScrollChangedListener(this);
        this.mNgWebView = aiAppsSlaveManager.getWebView();
        if (this.mNgWebView == null) {
            return false;
        }
        this.mNAFrameLayout = new FrameLayout(this.mContext);
        this.mParentFrameLayout.addView(this.mNAFrameLayout, new FrameLayout.LayoutParams(-1, -1));
        this.mPullToRefreshWebView = aiAppsSlaveManager.getPullToRefreshWebView();
        if (this.mPullToRefreshWebView != null) {
            this.mPullToRefreshWebView.setOnPullToRefreshScrollChangeListener(this);
        }
        return true;
    }

    public void setParentViewVisibility(int i) {
        this.mNAFrameLayout.setVisibility(i);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.view.container.IAiAppsNAViewRoot
    public int getMeasuredHeight() {
        return this.mNAFrameLayout.getMeasuredHeight();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.view.container.IAiAppsNAViewRoot
    public int getMeasuredWidth() {
        return this.mNAFrameLayout.getMeasuredWidth();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.listener.IOnScrollChangedListener
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        this.mNAFrameLayout.scrollTo(i, i2);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.core.container.PullToRefreshWebView.OnPullToRefreshScrollChangeListener
    public void onPullToRefreshScrollChanged(int i, int i2, int i3, int i4) {
        this.mNAFrameLayout.scrollTo(i, i2);
    }

    public void destroy() {
        this.mCoverViewCache.clear();
        this.mSlaveManager.removeOnScrollChangedListener(this);
    }
}
