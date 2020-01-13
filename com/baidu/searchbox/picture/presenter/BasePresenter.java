package com.baidu.searchbox.picture.presenter;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.searchbox.picture.adapter.PictureBrowseAdapter;
import com.baidu.searchbox.picture.component.BaseBrowseView;
import com.baidu.searchbox.picture.component.HugePhotoDraweeView;
import com.baidu.searchbox.picture.contract.IPresenter;
import com.baidu.searchbox.picture.contract.IViewer;
import com.baidu.searchbox.picture.model.BaseConfig;
import com.baidu.searchbox.picture.model.PictureInfo;
import java.util.ArrayList;
/* loaded from: classes12.dex */
public abstract class BasePresenter implements View.OnLongClickListener, IPresenter {
    public static BaseConfig sConfig;
    protected BaseConfig mConfigParams;
    protected PictureBrowseAdapter mPageAdapter;
    protected ArrayList<PictureInfo> mPictureInfoList;
    private ViewPager mViewPager;
    protected IViewer mViewer;

    protected abstract void exit();

    protected abstract PictureBrowseAdapter getPageAdapter(Activity activity, ArrayList<PictureInfo> arrayList);

    protected abstract void initBottomViews();

    public BasePresenter(IViewer iViewer) {
        this.mViewer = iViewer;
    }

    @Override // com.baidu.searchbox.picture.contract.IPresenter
    public final void initBrowser() {
        processConfigParams();
        initMainViews();
        initBottomViews();
    }

    protected final void processConfigParams() {
        this.mConfigParams = sConfig;
        sConfig = null;
        if (this.mConfigParams == null) {
            exit();
            return;
        }
        this.mPictureInfoList = (ArrayList) this.mConfigParams.getPictureInfoList();
        if (this.mPictureInfoList == null || this.mPictureInfoList.size() <= 0) {
            exit();
        } else {
            onProcessConfigParams();
        }
    }

    private void initMainViews() {
        this.mPageAdapter = getPageAdapter(this.mViewer.getHostContext(), this.mPictureInfoList);
        this.mViewPager = this.mViewer.getViewPager();
        this.mViewPager.setAdapter(this.mPageAdapter);
        onInitMainViews();
    }

    protected void onInitMainViews() {
    }

    protected void onProcessConfigParams() {
    }

    @Override // com.baidu.searchbox.picture.contract.IPresenter
    public void onDestroy() {
    }

    @Override // com.baidu.searchbox.picture.contract.IPresenter
    public void onResume() {
    }

    @Override // com.baidu.searchbox.picture.contract.IPresenter
    public void onPause() {
    }

    @Override // com.baidu.searchbox.picture.contract.IPresenter
    public void onStop() {
    }

    @Override // com.baidu.searchbox.picture.contract.IPresenter
    public void onStart() {
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        return false;
    }

    public BaseBrowseView getBrowseView(int i) {
        if (this.mPageAdapter == null || !(this.mPageAdapter.getCurrentView(i) instanceof BaseBrowseView)) {
            return null;
        }
        return (BaseBrowseView) this.mPageAdapter.getCurrentView(i);
    }

    public HugePhotoDraweeView getDraweeView(int i) {
        BaseBrowseView browseView = getBrowseView(i);
        if (browseView != null) {
            return browseView.getHugePhotoDraweeView();
        }
        return null;
    }
}
