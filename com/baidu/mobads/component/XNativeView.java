package com.baidu.mobads.component;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobad.feeds.XAdNativeResponse;
import com.baidu.mobads.component.FeedPortraitVideoView;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.q;
/* loaded from: classes2.dex */
public class XNativeView extends RelativeLayout implements FeedPortraitVideoView.IPortraitVideoViewClickListener {
    public static final String TAG = "XNativeView";
    public q mAdLogger;
    public XAdNativeResponse mCurrentNativeItem;
    public INativeVideoListener mFeedVideoListener;
    public INativeViewClickListener mNativeViewListener;
    public int mProgressBg;
    public int mProgressColor;
    public int mProgressHeight;
    public boolean mShowProgressBar;
    public FeedPortraitVideoView mVideoView;
    public boolean videoMute;

    /* loaded from: classes2.dex */
    public interface INativeViewClickListener {
        void onNativeViewClick(XNativeView xNativeView);
    }

    public XNativeView(Context context) {
        super(context);
        this.videoMute = true;
        this.mProgressColor = -1;
        this.mProgressBg = -16777216;
        this.mShowProgressBar = false;
        this.mProgressHeight = 1;
        this.mAdLogger = new q();
        setBackgroundColor(Color.parseColor("#000000"));
        XNativeViewManager.getInstance().addItem(this);
    }

    private void initAdVideoView() {
        FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView == null) {
            return;
        }
        feedPortraitVideoView.setCanClickVideo(true);
        this.mVideoView.setAdData(this.mCurrentNativeItem);
        this.mVideoView.setVideoMute(this.videoMute);
    }

    private boolean isVisible(View view, int i) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null) {
            return false;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            long height = rect.height() * rect.width();
            long height2 = view.getHeight() * view.getWidth();
            return height2 > 0 && height * 100 >= ((long) i) * height2;
        }
        return false;
    }

    private void play() {
        if (this.mVideoView != null) {
            initAdVideoView();
            this.mVideoView.play();
        }
    }

    private void renderView() {
        XAdNativeResponse xAdNativeResponse = this.mCurrentNativeItem;
        if (xAdNativeResponse == null) {
            return;
        }
        NativeResponse.MaterialType materialType = xAdNativeResponse.getMaterialType();
        if (this.mVideoView == null) {
            FeedPortraitVideoView feedPortraitVideoView = new FeedPortraitVideoView(getContext());
            this.mVideoView = feedPortraitVideoView;
            feedPortraitVideoView.setShowProgress(this.mShowProgressBar);
            this.mVideoView.setProgressBarColor(this.mProgressColor);
            this.mVideoView.setProgressBackgroundColor(this.mProgressBg);
            this.mVideoView.setProgressHeightInDp(this.mProgressHeight);
            this.mVideoView.setCanClickVideo(true);
            this.mVideoView.setCanShowCoverImage(false);
            addView(this.mVideoView, new RelativeLayout.LayoutParams(-1, -1));
            this.mVideoView.setFeedPortraitListener(new a(this));
            if (this.mNativeViewListener != null) {
                this.mVideoView.setOnPortraitViewClickListener(this);
            }
        }
        if (materialType == NativeResponse.MaterialType.NORMAL) {
            this.mVideoView.showNormalPic(this.mCurrentNativeItem);
        } else if (materialType == NativeResponse.MaterialType.VIDEO) {
            this.mVideoView.showView(this.mCurrentNativeItem);
        }
    }

    private boolean shouldAutoPlay() {
        XAdNativeResponse xAdNativeResponse = this.mCurrentNativeItem;
        boolean z = xAdNativeResponse != null && xAdNativeResponse.isAutoPlay();
        XAdNativeResponse xAdNativeResponse2 = this.mCurrentNativeItem;
        boolean z2 = xAdNativeResponse2 == null || xAdNativeResponse2.isNonWifiAutoPlay();
        Boolean isWifiConnected = XAdSDKFoundationFacade.getInstance().getSystemUtils().isWifiConnected(getContext().getApplicationContext());
        if (z && isWifiConnected.booleanValue()) {
            return true;
        }
        return z2 && !isWifiConnected.booleanValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        XNativeViewManager.getInstance().addItem(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        XNativeViewManager.getInstance().removeNativeView(this);
    }

    @Override // com.baidu.mobads.component.FeedPortraitVideoView.IPortraitVideoViewClickListener
    public void onPortraitViewClick(FeedPortraitVideoView feedPortraitVideoView) {
        INativeViewClickListener iNativeViewClickListener = this.mNativeViewListener;
        if (iNativeViewClickListener != null) {
            iNativeViewClickListener.onNativeViewClick(this);
        }
    }

    public void onScroll() {
        if (isVisible(this, 50)) {
            return;
        }
        pause();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            render();
        }
    }

    public void pause() {
        FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.pause();
        }
    }

    public void render() {
        if (shouldAutoPlay()) {
            play();
        }
    }

    public void resume() {
        FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.resume();
        }
    }

    public void setNativeItem(XAdNativeResponse xAdNativeResponse) {
        this.mCurrentNativeItem = xAdNativeResponse;
        renderView();
    }

    public void setNativeVideoListener(INativeVideoListener iNativeVideoListener) {
        this.mFeedVideoListener = iNativeVideoListener;
    }

    public void setNativeViewClickListener(INativeViewClickListener iNativeViewClickListener) {
        this.mNativeViewListener = iNativeViewClickListener;
        FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setOnPortraitViewClickListener(this);
        }
    }

    public void setProgressBackgroundColor(int i) {
        this.mProgressBg = i;
        FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setProgressBackgroundColor(i);
        }
    }

    public void setProgressBarColor(int i) {
        this.mProgressColor = i;
        FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setProgressBarColor(i);
        }
    }

    public void setProgressHeightInDp(int i) {
        this.mProgressHeight = i;
        FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setProgressHeightInDp(i);
        }
    }

    public void setShowProgress(boolean z) {
        this.mShowProgressBar = z;
        FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setShowProgress(z);
        }
    }

    public void setVideoMute(boolean z) {
        this.videoMute = z;
        FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setVideoMute(z);
        }
    }

    public void stop() {
        FeedPortraitVideoView feedPortraitVideoView = this.mVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.stop();
        }
    }

    public void setNativeItem(NativeResponse nativeResponse) {
        this.mCurrentNativeItem = (XAdNativeResponse) nativeResponse;
        renderView();
    }

    public XNativeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.videoMute = true;
        this.mProgressColor = -1;
        this.mProgressBg = -16777216;
        this.mShowProgressBar = false;
        this.mProgressHeight = 1;
        this.mAdLogger = new q();
        setBackgroundColor(Color.parseColor("#000000"));
        XNativeViewManager.getInstance().addItem(this);
    }

    public XNativeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.videoMute = true;
        this.mProgressColor = -1;
        this.mProgressBg = -16777216;
        this.mShowProgressBar = false;
        this.mProgressHeight = 1;
        this.mAdLogger = new q();
        setBackgroundColor(Color.parseColor("#000000"));
        XNativeViewManager.getInstance().addItem(this);
    }
}
