package com.baidu.mobads.component;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobad.feeds.XAdNativeResponse;
import com.baidu.mobads.component.FeedPortraitVideoView;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.q;
/* loaded from: classes4.dex */
public class XNativeView extends RelativeLayout implements FeedPortraitVideoView.IPortraitVideoViewClickListener {
    private static final String TAG = "XNativeView";
    private q mAdLogger;
    private XAdNativeResponse mCurrentNativeItem;
    private INativeVideoListener mFeedVideoListener;
    private INativeViewClickListener mNativeViewListener;
    private int mProgressBg;
    private int mProgressColor;
    private int mProgressHeight;
    private boolean mShowProgressBar;
    private FeedPortraitVideoView mVideoView;
    private boolean videoMute;

    /* loaded from: classes4.dex */
    public interface INativeViewClickListener {
        void onNativeViewClick(XNativeView xNativeView);
    }

    public XNativeView(Context context) {
        super(context);
        this.videoMute = true;
        this.mProgressColor = -1;
        this.mProgressBg = ViewCompat.MEASURED_STATE_MASK;
        this.mShowProgressBar = false;
        this.mProgressHeight = 1;
        this.mAdLogger = new q();
        setBackgroundColor(Color.parseColor("#000000"));
        XNativeViewManager.getInstance().addItem(this);
    }

    public XNativeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.videoMute = true;
        this.mProgressColor = -1;
        this.mProgressBg = ViewCompat.MEASURED_STATE_MASK;
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
        this.mProgressBg = ViewCompat.MEASURED_STATE_MASK;
        this.mShowProgressBar = false;
        this.mProgressHeight = 1;
        this.mAdLogger = new q();
        setBackgroundColor(Color.parseColor("#000000"));
        XNativeViewManager.getInstance().addItem(this);
    }

    public void setNativeItem(XAdNativeResponse xAdNativeResponse) {
        this.mCurrentNativeItem = xAdNativeResponse;
        renderView();
    }

    public void setNativeItem(NativeResponse nativeResponse) {
        this.mCurrentNativeItem = (XAdNativeResponse) nativeResponse;
        renderView();
    }

    public void setNativeViewClickListener(INativeViewClickListener iNativeViewClickListener) {
        this.mNativeViewListener = iNativeViewClickListener;
        if (this.mVideoView != null) {
            this.mVideoView.setOnPortraitViewClickListener(this);
        }
    }

    public void setNativeVideoListener(INativeVideoListener iNativeVideoListener) {
        this.mFeedVideoListener = iNativeVideoListener;
    }

    public void setVideoMute(boolean z) {
        this.videoMute = z;
        if (this.mVideoView != null) {
            this.mVideoView.setVideoMute(this.videoMute);
        }
    }

    private void renderView() {
        if (this.mCurrentNativeItem != null) {
            NativeResponse.MaterialType materialType = this.mCurrentNativeItem.getMaterialType();
            if (this.mVideoView == null) {
                this.mVideoView = new FeedPortraitVideoView(getContext());
                this.mVideoView.setShowProgress(this.mShowProgressBar);
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
    }

    public void pause() {
        if (this.mVideoView != null) {
            this.mVideoView.pause();
        }
    }

    public void resume() {
        if (this.mVideoView != null) {
            this.mVideoView.resume();
        }
    }

    public void render() {
        if (shouldAutoPlay()) {
            play();
        }
    }

    public void stop() {
        if (this.mVideoView != null) {
            this.mVideoView.stop();
        }
    }

    private void play() {
        if (this.mVideoView != null) {
            initAdVideoView();
            this.mVideoView.play();
        }
    }

    private boolean shouldAutoPlay() {
        boolean z = this.mCurrentNativeItem != null && this.mCurrentNativeItem.isAutoPlay();
        boolean z2 = this.mCurrentNativeItem == null || this.mCurrentNativeItem.isNonWifiAutoPlay();
        Boolean isWifiConnected = XAdSDKFoundationFacade.getInstance().getSystemUtils().isWifiConnected(getContext().getApplicationContext());
        if (z && isWifiConnected.booleanValue()) {
            return true;
        }
        return z2 && !isWifiConnected.booleanValue();
    }

    public void setShowProgress(boolean z) {
        this.mShowProgressBar = z;
        if (this.mVideoView != null) {
            this.mVideoView.setShowProgress(z);
        }
    }

    public void setProgressBackgroundColor(int i) {
        this.mProgressBg = i;
        if (this.mVideoView != null) {
            this.mVideoView.setProgressBackgroundColor(i);
        }
    }

    public void setProgressBarColor(int i) {
        this.mProgressColor = i;
        if (this.mVideoView != null) {
            this.mVideoView.setProgressBarColor(i);
        }
    }

    public void setProgressHeightInDp(int i) {
        this.mProgressHeight = i;
        if (this.mVideoView != null) {
            this.mVideoView.setProgressHeightInDp(i);
        }
    }

    private void initAdVideoView() {
        if (this.mVideoView != null) {
            this.mVideoView.setCanClickVideo(true);
            this.mVideoView.setAdData(this.mCurrentNativeItem);
            this.mVideoView.setVideoMute(this.videoMute);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        XNativeViewManager.getInstance().removeNativeView(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        XNativeViewManager.getInstance().addItem(this);
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            render();
        }
    }

    public void onScroll() {
        if (!isVisible(this, 50)) {
            pause();
        }
    }

    private boolean isVisible(View view, int i) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null) {
            return false;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            long height = rect.height() * rect.width();
            long height2 = view.getHeight() * view.getWidth();
            return height2 > 0 && height * 100 >= height2 * ((long) i);
        }
        return false;
    }

    @Override // com.baidu.mobads.component.FeedPortraitVideoView.IPortraitVideoViewClickListener
    public void onPortraitViewClick(FeedPortraitVideoView feedPortraitVideoView) {
        if (this.mNativeViewListener != null) {
            this.mNativeViewListener.onNativeViewClick(this);
        }
    }
}
