package com.baidu.live.tbadk.core.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.live.adp.widget.listview.BdIListPullView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.PullViewHelper;
/* loaded from: classes2.dex */
public class TbListCommonPullView extends BdIListPullView {
    public static final long COMPLETE_ANIM_TIME = 2000;
    private boolean isManualTrigger;
    protected AnimationDrawable mAnimImage;
    protected View mHeaderView;
    private ListPullRefreshFinishedListener mListPullRefreshFinishedListener;
    private ListPullRefreshListener mListPullRefreshListener;
    private ListPullToRefreshListener mListPullToRefreshListener;
    protected ImageView mPullImage;
    protected LinearLayout mPullRoot;
    protected int mSkinType;

    /* loaded from: classes2.dex */
    public interface ListPullRefreshFinishedListener {
        void onListPullRefreshFinished(View view, boolean z);
    }

    /* loaded from: classes2.dex */
    public interface ListPullRefreshListener {
        void onListPullRefresh(boolean z);
    }

    /* loaded from: classes2.dex */
    public interface ListPullToRefreshListener {
        void onListPullToRefresh(boolean z);
    }

    public TbListCommonPullView(Context context) {
        super(context);
        this.mHeaderView = null;
        this.mPullRoot = null;
        this.mPullImage = null;
        this.mListPullRefreshListener = null;
        this.mListPullRefreshFinishedListener = null;
        this.mListPullToRefreshListener = null;
        this.mSkinType = Integer.MIN_VALUE;
        this.isManualTrigger = false;
    }

    @Override // com.baidu.live.adp.widget.listview.BdIListPullView
    public View createView() {
        this.mHeaderView = LayoutInflater.from(getContext()).inflate(a.h.sdk_tb_pull_view, (ViewGroup) null);
        this.mPullRoot = (LinearLayout) this.mHeaderView.findViewById(a.g.pull_root);
        this.mPullImage = (ImageView) this.mHeaderView.findViewById(a.g.pull_image);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.mSkinType != Integer.MIN_VALUE) {
            skinType = this.mSkinType;
        }
        this.mAnimImage = PullViewHelper.getInstance().getDefaultAnimationDrawable(skinType);
        this.mPullImage.setBackgroundDrawable(this.mAnimImage);
        changeSkin(skinType);
        initPullView();
        return this.mHeaderView;
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    public View getHeaderView() {
        if (this.mHeaderView == null) {
            this.mHeaderView = createView();
        }
        return this.mHeaderView;
    }

    public LinearLayout getPullRoot() {
        return this.mPullRoot;
    }

    public ImageView getPullImage() {
        return this.mPullImage;
    }

    @Override // com.baidu.live.adp.widget.listview.BdIListPullView
    public void releaseToRefresh() {
        if (this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.live.adp.widget.listview.BdIListPullView
    public void pullToRefresh(boolean z) {
        if (this.mListPullToRefreshListener != null) {
            this.mListPullToRefreshListener.onListPullToRefresh(z);
        }
        initPullView();
        this.isManualTrigger = true;
        if (this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage.getFrame(0));
        }
    }

    @Override // com.baidu.live.adp.widget.listview.BdIListPullView
    public void refreshing() {
        initPullView();
        if (this.mAnimImage != null && this.mPullImage != null) {
            this.mAnimImage.stop();
            this.mPullImage.setBackgroundDrawable(this.mAnimImage);
            this.mPullImage.post(new Runnable() { // from class: com.baidu.live.tbadk.core.view.TbListCommonPullView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TbListCommonPullView.this.mAnimImage != null) {
                        TbListCommonPullView.this.mAnimImage.start();
                    }
                }
            });
        }
    }

    @Override // com.baidu.live.adp.widget.listview.BdIListPullView
    public void done(boolean z) {
        this.isManualTrigger = false;
        if (this.mAnimImage != null) {
            this.mAnimImage.stop();
        }
        release();
        if (this.mListPullRefreshFinishedListener != null) {
            this.mListPullRefreshFinishedListener.onListPullRefreshFinished(this.mHeaderView, z);
        }
    }

    @Override // com.baidu.live.adp.widget.listview.BdIListPullView
    public void onRefresh(boolean z) {
        if (this.mListPullRefreshListener != null) {
            this.mListPullRefreshListener.onListPullRefresh(z);
        }
    }

    @Override // com.baidu.live.adp.widget.listview.BdIListPullView
    public void onCompletePullRefresh() {
    }

    public void setListPullRefreshListener(ListPullRefreshListener listPullRefreshListener) {
        this.mListPullRefreshListener = listPullRefreshListener;
    }

    public void setListPullRefreshFinishedListener(ListPullRefreshFinishedListener listPullRefreshFinishedListener) {
        this.mListPullRefreshFinishedListener = listPullRefreshFinishedListener;
    }

    public void setListPullToRefreshListener(ListPullToRefreshListener listPullToRefreshListener) {
        this.mListPullToRefreshListener = listPullToRefreshListener;
    }

    public void changeSkin(int i) {
    }

    private void initPullView() {
        if (this.mPullImage != null && this.mPullImage.getVisibility() != 0) {
            this.mPullImage.setVisibility(0);
        }
    }

    private void release() {
        if (this.mAnimImage != null) {
            this.mAnimImage.stop();
            this.mAnimImage = null;
        }
    }

    @Override // com.baidu.live.adp.widget.listview.BdIListPullView, com.baidu.live.adp.widget.refresh.BdSwipeRefreshLayout.IProgressView
    public long getCompleteAnimTime() {
        return 2000L;
    }
}
