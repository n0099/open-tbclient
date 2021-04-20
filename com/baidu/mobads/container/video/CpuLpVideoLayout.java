package com.baidu.mobads.container.video;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.landingpage.JsWithPlayerData;
import com.baidu.mobads.container.util.XAdSimpleImageLoader;
import com.baidu.mobads.container.widget.player.AdVideoView;
import com.baidu.mobads.container.widget.player.AdVideoViewListener;
/* loaded from: classes2.dex */
public class CpuLpVideoLayout extends RelativeLayout {
    public static final int SOURCE_CHANGE = 1;
    public static final int SOURCE_REGISTER = 2;
    public static final String TAG = "CpuLpVideoLayout";
    public int clvIndex;
    public JsWithPlayerData mAdData;
    public AdVideoView mAdVideoView;
    public final ImageView mCoverImg;
    public CpuLpVideoControllerDecoration mCpuLpVideoControllerView;
    public JsWithPlayerData mJsWithPlayerData;
    public OnVideoStatusListener mOnVideoStatusListener;
    public boolean mOnlyNotifyUser;
    public ViewGroup mParentView;
    public boolean mPauseByUser;
    public LinearLayout.LayoutParams mPortraitParams;
    public final ProgressBar mProgressBar;
    public final AdVideoViewListener mVideoListener;
    public final Runnable updateTimeRunnable;

    /* loaded from: classes2.dex */
    public interface OnVideoStatusListener {
        void chooseNextVideo(JsWithPlayerData jsWithPlayerData);

        void choosePrevVideo(JsWithPlayerData jsWithPlayerData);

        void clickPrerolls(JsWithPlayerData jsWithPlayerData);

        void closePrerolls(JsWithPlayerData jsWithPlayerData);

        void completeVideoPlay(JsWithPlayerData jsWithPlayerData);

        void fiveSecondsLeft(JsWithPlayerData jsWithPlayerData);

        void isFullScreenStatus(boolean z);

        void occurErrorVideoPlay(JsWithPlayerData jsWithPlayerData);

        void pauseVideoPlay(JsWithPlayerData jsWithPlayerData);

        void resumeVideoPlay(JsWithPlayerData jsWithPlayerData);

        void setVideoLocation(boolean z);

        void videoNotVisible();
    }

    public CpuLpVideoLayout(Context context) {
        super(context);
        this.mOnlyNotifyUser = true;
        this.updateTimeRunnable = new Runnable() { // from class: com.baidu.mobads.container.video.CpuLpVideoLayout.1
            @Override // java.lang.Runnable
            public void run() {
                int duration = CpuLpVideoLayout.this.mAdVideoView.getDuration();
                int currentPosition = CpuLpVideoLayout.this.mAdVideoView.getCurrentPosition();
                int i = (duration - currentPosition) / 1000;
                CpuLpVideoLayout.this.mCpuLpVideoControllerView.upDateVideoTime(currentPosition, duration);
                if (i == 5 && CpuLpVideoLayout.this.mOnlyNotifyUser) {
                    CpuLpVideoLayout.this.mOnlyNotifyUser = false;
                    CpuLpVideoLayout cpuLpVideoLayout = CpuLpVideoLayout.this;
                    cpuLpVideoLayout.mOnVideoStatusListener.fiveSecondsLeft(cpuLpVideoLayout.mJsWithPlayerData);
                }
                CpuLpVideoLayout.this.postDelayed(this, 1000L);
            }
        };
        this.mVideoListener = new AdVideoViewListener() { // from class: com.baidu.mobads.container.video.CpuLpVideoLayout.2
            @Override // com.baidu.mobads.container.widget.player.AdVideoViewListener
            public void playCompletion() {
                Log.d(CpuLpVideoLayout.TAG, "playCompletion: ");
                if (TextUtils.isEmpty(CpuLpVideoLayout.this.mJsWithPlayerData.nextVideoTitle)) {
                    CpuLpVideoLayout.this.mCpuLpVideoControllerView.replayPlayIcon();
                }
                CpuLpVideoLayout cpuLpVideoLayout = CpuLpVideoLayout.this;
                if (cpuLpVideoLayout.mOnVideoStatusListener != null) {
                    cpuLpVideoLayout.mJsWithPlayerData.setCurVideoStatus("video_completion");
                    CpuLpVideoLayout.this.mJsWithPlayerData.setCurVideoPlayTime(String.valueOf(CpuLpVideoLayout.this.mAdVideoView.getCurrentPosition()));
                    CpuLpVideoLayout.this.mJsWithPlayerData.setCurVideoUserAction("video_completion");
                    CpuLpVideoLayout cpuLpVideoLayout2 = CpuLpVideoLayout.this;
                    cpuLpVideoLayout2.mOnVideoStatusListener.completeVideoPlay(cpuLpVideoLayout2.mJsWithPlayerData);
                }
            }

            @Override // com.baidu.mobads.container.widget.player.AdVideoViewListener
            public void playFailure() {
                Log.d(CpuLpVideoLayout.TAG, "playFailure: ");
                CpuLpVideoLayout cpuLpVideoLayout = CpuLpVideoLayout.this;
                if (cpuLpVideoLayout.mOnVideoStatusListener != null) {
                    cpuLpVideoLayout.mJsWithPlayerData.setCurVideoStatus("play_error");
                    CpuLpVideoLayout.this.mJsWithPlayerData.setCurVideoPlayTime(String.valueOf(CpuLpVideoLayout.this.mAdVideoView.getCurrentPosition()));
                    CpuLpVideoLayout.this.mJsWithPlayerData.setCurVideoUserAction("play_error");
                    CpuLpVideoLayout cpuLpVideoLayout2 = CpuLpVideoLayout.this;
                    cpuLpVideoLayout2.mOnVideoStatusListener.occurErrorVideoPlay(cpuLpVideoLayout2.mJsWithPlayerData);
                }
            }

            @Override // com.baidu.mobads.container.widget.player.AdVideoViewListener
            public void playPause() {
                Log.d(CpuLpVideoLayout.TAG, "playPause: ");
                CpuLpVideoLayout.this.mCpuLpVideoControllerView.mVideoStatus = 11;
                CpuLpVideoLayout.this.mCpuLpVideoControllerView.pausePlayIcon();
                CpuLpVideoLayout cpuLpVideoLayout = CpuLpVideoLayout.this;
                if (cpuLpVideoLayout.mOnVideoStatusListener != null) {
                    cpuLpVideoLayout.mJsWithPlayerData.setCurVideoStatus("video_pause");
                    CpuLpVideoLayout.this.mJsWithPlayerData.setCurVideoPlayTime(String.valueOf(CpuLpVideoLayout.this.mAdVideoView.getCurrentPosition()));
                    CpuLpVideoLayout.this.mJsWithPlayerData.setCurVideoUserAction("video_pause");
                    CpuLpVideoLayout cpuLpVideoLayout2 = CpuLpVideoLayout.this;
                    cpuLpVideoLayout2.mOnVideoStatusListener.pauseVideoPlay(cpuLpVideoLayout2.mJsWithPlayerData);
                }
            }

            @Override // com.baidu.mobads.container.widget.player.AdVideoViewListener
            public void playResume() {
                Log.d(CpuLpVideoLayout.TAG, "playResume: ");
                CpuLpVideoLayout.this.mCpuLpVideoControllerView.mVideoStatus = 10;
                CpuLpVideoLayout.this.mCpuLpVideoControllerView.resumePlayIcon();
                CpuLpVideoLayout.this.mAdVideoView.setPlayBackSpeed(CpuLpVideoLayout.this.mCpuLpVideoControllerView.mPlayBackSpeed);
                CpuLpVideoLayout.this.startCounter();
                CpuLpVideoLayout.this.mCpuLpVideoControllerView.setChildrenVisible();
                CpuLpVideoLayout cpuLpVideoLayout = CpuLpVideoLayout.this;
                if (cpuLpVideoLayout.mOnVideoStatusListener != null) {
                    cpuLpVideoLayout.mJsWithPlayerData.setCurVideoUserAction("video_resume");
                    CpuLpVideoLayout.this.mJsWithPlayerData.setCurVideoPlayTime(String.valueOf(CpuLpVideoLayout.this.mAdVideoView.getCurrentPosition()));
                    CpuLpVideoLayout.this.mJsWithPlayerData.setCurVideoStatus("video_resume");
                    CpuLpVideoLayout cpuLpVideoLayout2 = CpuLpVideoLayout.this;
                    cpuLpVideoLayout2.mOnVideoStatusListener.resumeVideoPlay(cpuLpVideoLayout2.mJsWithPlayerData);
                }
            }

            @Override // com.baidu.mobads.container.widget.player.AdVideoViewListener
            public void renderingStart() {
                Log.d(CpuLpVideoLayout.TAG, "renderingStart: ");
                CpuLpVideoLayout.this.mAdVideoView.setPlayBackSpeed(CpuLpVideoLayout.this.mCpuLpVideoControllerView.mPlayBackSpeed);
                CpuLpVideoLayout.this.mCpuLpVideoControllerView.mVideoStatus = 10;
                CpuLpVideoLayout.this.startCounter();
                CpuLpVideoLayout.this.mCpuLpVideoControllerView.mProgressSeekBar.setMax(CpuLpVideoLayout.this.mAdVideoView.getDuration());
            }
        };
        this.mCoverImg = new ImageView(context);
        addView(this.mCoverImg, new RelativeLayout.LayoutParams(-1, -1));
        this.mProgressBar = new ProgressBar(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.mProgressBar, layoutParams);
        initVideoView();
        initControlVideoView();
    }

    private void initControlVideoView() {
        CpuLpVideoControllerDecoration cpuLpVideoControllerDecoration = new CpuLpVideoControllerDecoration(getContext(), this);
        this.mCpuLpVideoControllerView = cpuLpVideoControllerDecoration;
        cpuLpVideoControllerDecoration.setChildrenVisible();
    }

    private void initVideoView() {
        this.mAdVideoView = new AdVideoView(getContext());
        addView(this.mAdVideoView, new RelativeLayout.LayoutParams(-1, -1));
        this.mAdVideoView.setAdVideoViewListener(this.mVideoListener);
        this.mAdVideoView.initAdVideoView();
        this.mAdVideoView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCounter() {
        this.mOnlyNotifyUser = true;
        postDelayed(this.updateTimeRunnable, 1000L);
    }

    private void stopCounter() {
        removeCallbacks(this.updateTimeRunnable);
    }

    public void addPrerolls(JsWithPlayerData jsWithPlayerData) {
        this.mAdData = jsWithPlayerData;
        this.mCpuLpVideoControllerView.setAdData(jsWithPlayerData);
    }

    public void changePlayProgress(int i) {
        this.mAdVideoView.seekTo(i);
    }

    public void changeVideoSound(boolean z) {
        AdVideoView adVideoView = this.mAdVideoView;
        if (adVideoView != null) {
            adVideoView.setVideoMute(z);
        }
    }

    public void changeVideoUrl(JsWithPlayerData jsWithPlayerData) {
        this.mJsWithPlayerData = jsWithPlayerData;
        this.mAdVideoView.stopAndRelease();
        this.mAdVideoView.setVideoUrl(this.mJsWithPlayerData.videoUrl);
        this.mAdVideoView.startPlay(this.mJsWithPlayerData.videoUrl);
        this.mCpuLpVideoControllerView.fillFloatViewWithData(jsWithPlayerData, 1);
    }

    public void clickPreRollsAd() {
        OnVideoStatusListener onVideoStatusListener = this.mOnVideoStatusListener;
        if (onVideoStatusListener != null) {
            onVideoStatusListener.clickPrerolls(this.mAdData);
        }
    }

    public void closePrerollsAd() {
        resumeVideo();
        OnVideoStatusListener onVideoStatusListener = this.mOnVideoStatusListener;
        if (onVideoStatusListener != null) {
            onVideoStatusListener.closePrerolls(this.mAdData);
        }
    }

    public void fullScreen() {
        if (getContext() instanceof Activity) {
            ((Activity) getContext()).setRequestedOrientation(0);
            View findViewById = getRootView().findViewById(16908290);
            ViewParent parent = getParent();
            this.mPortraitParams = (LinearLayout.LayoutParams) getLayoutParams();
            if (parent instanceof ViewGroup) {
                if (this.mParentView == null) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    this.mParentView = viewGroup;
                    this.clvIndex = viewGroup.indexOfChild(this);
                }
                ((ViewGroup) parent).removeView(this);
            }
            if (findViewById instanceof ViewGroup) {
                ((ViewGroup) findViewById).addView(this, new FrameLayout.LayoutParams(-1, -1));
            }
        }
        AdVideoView adVideoView = this.mAdVideoView;
        if (adVideoView != null) {
            adVideoView.onResume();
        }
        this.mCpuLpVideoControllerView.mTopTipsView.setVisibility(8);
        this.mCpuLpVideoControllerView.modifyUIAfterOrientationChanged(false);
        OnVideoStatusListener onVideoStatusListener = this.mOnVideoStatusListener;
        if (onVideoStatusListener != null) {
            onVideoStatusListener.isFullScreenStatus(true);
        }
    }

    public void initLayoutWithVideoData(JsWithPlayerData jsWithPlayerData) {
        this.mJsWithPlayerData = jsWithPlayerData;
        this.mAdVideoView.setVisibility(0);
        this.mCpuLpVideoControllerView.fillFloatViewWithData(this.mJsWithPlayerData, 2);
        this.mCoverImg.setVisibility(8);
        this.mProgressBar.setVisibility(8);
    }

    public void nextVideo() {
        if (this.mAdVideoView == null || this.mOnVideoStatusListener == null) {
            return;
        }
        this.mJsWithPlayerData.setCurVideoUserAction("next_video");
        this.mJsWithPlayerData.setCurVideoStatus("next_video");
        this.mJsWithPlayerData.setCurVideoPlayTime(String.valueOf(this.mAdVideoView.getCurrentPosition()));
        this.mOnVideoStatusListener.chooseNextVideo(this.mJsWithPlayerData);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AdVideoView adVideoView = this.mAdVideoView;
        if (adVideoView != null) {
            adVideoView.stopAndRelease();
            stopCounter();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.mCpuLpVideoControllerView.setChildrenVisible();
        }
        return true;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 8) {
            this.mAdVideoView.stopAndRelease();
            OnVideoStatusListener onVideoStatusListener = this.mOnVideoStatusListener;
            if (onVideoStatusListener != null) {
                onVideoStatusListener.videoNotVisible();
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        AdVideoView adVideoView;
        AdVideoView adVideoView2;
        super.onWindowFocusChanged(z);
        if (getVisibility() != 0 || this.mPauseByUser) {
            return;
        }
        if (!z && (adVideoView2 = this.mAdVideoView) != null && adVideoView2.isPlaying()) {
            this.mAdVideoView.onPause();
        } else if (!z || (adVideoView = this.mAdVideoView) == null) {
        } else {
            adVideoView.onResume();
        }
    }

    public void pauseVideo() {
        AdVideoView adVideoView = this.mAdVideoView;
        if (adVideoView == null || !adVideoView.isPlaying()) {
            return;
        }
        this.mAdVideoView.onPause();
        this.mPauseByUser = true;
    }

    public void playVideo() {
        AdVideoView adVideoView;
        if (!this.mJsWithPlayerData.isAutoPlayThis || (adVideoView = this.mAdVideoView) == null) {
            return;
        }
        adVideoView.clearData();
        this.mAdVideoView.stopAndRelease();
        this.mAdVideoView.setVideoUrl(this.mJsWithPlayerData.videoUrl);
        this.mAdVideoView.startPlay(this.mJsWithPlayerData.videoUrl);
    }

    public void prevVideo() {
        if (this.mAdVideoView == null || this.mOnVideoStatusListener == null) {
            return;
        }
        this.mJsWithPlayerData.setCurVideoUserAction("prev_video");
        this.mJsWithPlayerData.setCurVideoStatus("prev_video");
        this.mJsWithPlayerData.setCurVideoPlayTime(String.valueOf(this.mAdVideoView.getCurrentPosition()));
        this.mOnVideoStatusListener.choosePrevVideo(this.mJsWithPlayerData);
    }

    public void resumeVideo() {
        AdVideoView adVideoView = this.mAdVideoView;
        if (adVideoView != null) {
            adVideoView.onResume();
            this.mPauseByUser = false;
        }
    }

    public void retryPlay() {
        if (this.mOnVideoStatusListener != null) {
            this.mJsWithPlayerData.setCurVideoStatus("video_replay");
            this.mJsWithPlayerData.setCurVideoPlayTime(String.valueOf(this.mAdVideoView.getCurrentPosition()));
            this.mJsWithPlayerData.setCurVideoUserAction("video_replay");
            this.mOnVideoStatusListener.completeVideoPlay(this.mJsWithPlayerData);
        }
    }

    public void setCoverPic(String str) {
        XAdSimpleImageLoader.obtain(getContext()).load(this.mCoverImg, str);
    }

    public void setOnVideoStatusListener(OnVideoStatusListener onVideoStatusListener) {
        this.mOnVideoStatusListener = onVideoStatusListener;
    }

    public void setPlayBackSpeed(float f2) {
        AdVideoView adVideoView = this.mAdVideoView;
        if (adVideoView != null) {
            adVideoView.setPlayBackSpeed(f2);
        }
    }

    public void setVideoLocation(boolean z) {
        OnVideoStatusListener onVideoStatusListener = this.mOnVideoStatusListener;
        if (onVideoStatusListener != null) {
            onVideoStatusListener.setVideoLocation(z);
        }
    }

    public void shrinkScreen() {
        if (((Activity) getContext()).getRequestedOrientation() == 1) {
            return;
        }
        ((Activity) getContext()).setRequestedOrientation(1);
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
        ViewGroup viewGroup = this.mParentView;
        if (viewGroup != null && viewGroup.getParent() != null) {
            this.mParentView.addView(this, this.clvIndex, this.mPortraitParams);
        }
        AdVideoView adVideoView = this.mAdVideoView;
        if (adVideoView != null) {
            adVideoView.onResume();
        }
        this.mCpuLpVideoControllerView.mTopTipsView.setVisibility(0);
        this.mCpuLpVideoControllerView.modifyUIAfterOrientationChanged(true);
        OnVideoStatusListener onVideoStatusListener = this.mOnVideoStatusListener;
        if (onVideoStatusListener != null) {
            onVideoStatusListener.isFullScreenStatus(false);
        }
    }
}
