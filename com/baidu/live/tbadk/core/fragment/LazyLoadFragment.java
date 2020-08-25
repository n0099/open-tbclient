package com.baidu.live.tbadk.core.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes7.dex */
public abstract class LazyLoadFragment extends SupportXFragment {
    private ILazyLoadFragmentController mController;
    protected boolean mInitialed;
    protected boolean mVisible;

    protected abstract ILazyLoadFragmentController createController();

    protected abstract View genRootView();

    protected abstract boolean lazy();

    protected abstract void onInflate(View view, Bundle bundle);

    protected abstract void onInitial();

    @Override // com.baidu.live.tbadk.core.fragment.SupportXFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mController = createController();
        this.mView = genRootView();
        onInflate(this.mView, bundle);
        return this.mView;
    }

    @Override // com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (!lazy() || (this.mVisible && !this.mInitialed)) {
            initData();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.mVisible = z;
        if (getView() != null) {
            if (lazy() && !this.mInitialed && z) {
                initData();
            }
            onVisibilityChanged(z);
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onResume() {
        super.onResume();
        if (this.mController != null) {
            this.mController.onResume();
        }
    }

    @Override // com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onPause() {
        if (this.mController != null) {
            this.mController.onPause();
        }
        super.onPause();
    }

    @Override // com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroyView() {
        if (this.mController != null) {
            this.mController.onDestoryView();
        }
        this.mInitialed = false;
        super.onDestroyView();
    }

    @Override // com.baidu.live.tbadk.core.fragment.SupportXFragment
    public void onDestroy() {
        if (this.mController != null) {
            this.mController.onDestroy();
        }
        super.onDestroy();
    }

    private void initData() {
        this.mInitialed = true;
        onInitial();
        if (this.mController != null) {
            this.mController.onInitial();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onVisibilityChanged(boolean z) {
        if (this.mController != null) {
            this.mController.onVisibilityChanged(z);
        }
    }
}
