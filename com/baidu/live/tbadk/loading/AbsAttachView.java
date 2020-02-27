package com.baidu.live.tbadk.loading;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes3.dex */
public class AbsAttachView {
    protected View attachedView;
    private boolean isAttached;

    public AbsAttachView(View view) {
        this.attachedView = view;
    }

    public boolean isViewAttached() {
        return this.isAttached;
    }

    public void attachView(View view, boolean z) {
        if (view != null && this.attachedView != null && this.attachedView.getParent() == null) {
            this.isAttached = true;
            LayoutStrategyFactory.getStategy(view).attachView(view, this.attachedView, z);
            onViewAttached();
        }
    }

    public void dettachView(View view) {
        if (view != null && this.attachedView != null && this.attachedView.getParent() != null && (view instanceof ViewGroup)) {
            try {
                onViewDettached();
                ((ViewGroup) view).removeView(this.attachedView);
                this.isAttached = false;
            } catch (Exception e) {
            }
        }
    }

    public void attachView(View view) {
        attachView(view, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onViewAttached() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onViewDettached() {
    }
}
