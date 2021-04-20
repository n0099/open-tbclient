package com.baidu.mobads.container.widget.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.util.AppUtils;
import com.baidu.mobads.container.util.CommonUtils;
import com.baidu.mobads.container.util.ViewVisibilityUtil;
import com.baidu.mobads.container.widget.player.AdVideoViewListener;
import com.baidu.mobads.container.widget.player.BaseMediaPlayer;
import java.lang.ref.SoftReference;
/* loaded from: classes2.dex */
public class AdVideoView extends RelativeLayout implements IAdVideoView {
    public static final String TAG = "AdVideoView";
    public static final int UPDATE_DELAY = 200;
    public AdVideoViewListener.DestroyedListener mDestroyListener;
    public int mDisplayMode;
    public boolean mIsFront;
    public boolean mIsMute;
    public boolean mIsScreenLock;
    public boolean mIsSurfaceView;
    public int mLastPosition;
    public View mLoadingView;
    public BaseMediaPlayer mMediaPlayer;
    public String mPlayUrl;
    public boolean mPlayerHasReleased;
    public boolean mPreparePlaying;
    public AdVideoViewListener.PreparedListener mPreparedListener;
    public int mProgressBg;
    public int mProgressColor;
    public int mProgressHeight;
    public UpdateProgressRunnable mProgressRunnable;
    public ScreenBroadcastReceiver mScreenReceiver;
    public boolean mShowProgressBar;
    public Surface mSurface;
    public boolean mSurfaceAvailable;
    public SurfaceHolder mSurfaceHolder;
    public ISurfaceListener mSurfaceListener;
    public ISurfaceView mSurfaceView;
    public ITextureListener mTextureListener;
    public boolean mVideoPlaying;
    public AdVideoProgressBar mVideoProgress;
    public AdVideoViewListener mVideoViewListener;
    public Context mViewContext;

    /* loaded from: classes2.dex */
    public class ScreenBroadcastReceiver extends BroadcastReceiver {
        public ScreenBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                Context context2 = AdVideoView.this.mViewContext;
                if (AppUtils.isForeground(context2, context2.getPackageName())) {
                    return;
                }
                AdVideoView.this.mIsScreenLock = true;
                AdVideoView.this.stopAndRelease();
            } else if ("android.intent.action.USER_PRESENT".equals(action)) {
                AdVideoView.this.mIsScreenLock = false;
                AdVideoView.this.retryPlay();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class UpdateProgressRunnable implements Runnable {
        public SoftReference<AdVideoView> adVideoViewReference;
        public boolean mProcessing = false;

        public UpdateProgressRunnable(AdVideoView adVideoView) {
            this.adVideoViewReference = new SoftReference<>(adVideoView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AdVideoView adVideoView;
            SoftReference<AdVideoView> softReference = this.adVideoViewReference;
            if (softReference == null || (adVideoView = softReference.get()) == null) {
                return;
            }
            int currentPosition = adVideoView.getCurrentPosition();
            int duration = adVideoView.getDuration();
            if (adVideoView.mVideoProgress != null && duration > 0) {
                adVideoView.mVideoProgress.setProgress(currentPosition / duration);
            }
            if (this.mProcessing) {
                adVideoView.postDelayed(this, 200L);
            }
        }

        public void setProcessRunning(boolean z) {
            this.mProcessing = z;
        }
    }

    public AdVideoView(Context context) {
        super(context);
        this.mProgressColor = -1;
        this.mProgressBg = -16777216;
        this.mShowProgressBar = false;
        this.mProgressHeight = 4;
        this.mPlayUrl = "";
        this.mSurfaceAvailable = false;
        this.mIsScreenLock = false;
        this.mPreparePlaying = false;
        this.mVideoPlaying = false;
        this.mDisplayMode = 1;
        this.mIsSurfaceView = false;
        this.mTextureListener = new ITextureListener() { // from class: com.baidu.mobads.container.widget.player.AdVideoView.2
            @Override // com.baidu.mobads.container.widget.player.ITextureListener
            public void surfaceCreated(Surface surface) {
                AdVideoView.this.mSurface = surface;
                AdVideoView.this.mSurfaceAvailable = true;
                AdVideoView.this.retryPlay();
            }

            @Override // com.baidu.mobads.container.widget.player.ITextureListener
            public void surfaceDestroy() {
                if (AdVideoView.this.mDestroyListener != null) {
                    AdVideoView.this.mDestroyListener.onDestroyed();
                }
                AdVideoView.this.mIsFront = false;
                AdVideoView.this.mSurfaceAvailable = false;
                AdVideoView.this.stopAndRelease();
            }
        };
        this.mSurfaceListener = new ISurfaceListener() { // from class: com.baidu.mobads.container.widget.player.AdVideoView.3
            @Override // com.baidu.mobads.container.widget.player.ISurfaceListener
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                AdVideoView.this.mSurfaceHolder = surfaceHolder;
                AdVideoView.this.mSurfaceAvailable = true;
                AdVideoView.this.retryPlay();
            }

            @Override // com.baidu.mobads.container.widget.player.ISurfaceListener
            public void surfaceDestroy() {
                if (AdVideoView.this.mDestroyListener != null) {
                    AdVideoView.this.mDestroyListener.onDestroyed();
                }
                AdVideoView.this.mIsFront = false;
                AdVideoView.this.mSurfaceAvailable = false;
                AdVideoView.this.stopAndRelease();
            }
        };
        this.mViewContext = context;
        init();
    }

    private void addVideoView() {
        removeAllViews();
        this.mVideoPlaying = false;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        setBackgroundColor(Color.parseColor("#000000"));
        addView((View) this.mSurfaceView, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchPlayerEvent(int i) {
        switch (i) {
            case 256:
                this.mLastPosition = 0;
                this.mVideoPlaying = false;
                hideLoadingView();
                AdVideoViewListener adVideoViewListener = this.mVideoViewListener;
                if (adVideoViewListener != null) {
                    adVideoViewListener.playCompletion();
                    return;
                }
                return;
            case 257:
                this.mVideoPlaying = false;
                this.mLastPosition = 0;
                playError();
                return;
            case 258:
                AdVideoViewListener.PreparedListener preparedListener = this.mPreparedListener;
                if (preparedListener != null) {
                    preparedListener.onPrepared();
                }
                int i2 = this.mLastPosition;
                if (i2 > 0) {
                    this.mMediaPlayer.seekTo(i2);
                }
                setVideoMute(this.mIsMute);
                ISurfaceView iSurfaceView = this.mSurfaceView;
                if (iSurfaceView != null) {
                    iSurfaceView.onVideoSizeChanged(this.mMediaPlayer.getVideoWidth(), this.mMediaPlayer.getVideoHeight());
                }
                AdVideoProgressBar adVideoProgressBar = this.mVideoProgress;
                if (adVideoProgressBar != null) {
                    adVideoProgressBar.setProgress(this.mLastPosition / getDuration());
                    UpdateProgressRunnable updateProgressRunnable = this.mProgressRunnable;
                    if (updateProgressRunnable != null) {
                        removeCallbacks(updateProgressRunnable);
                        this.mProgressRunnable.setProcessRunning(true);
                        postDelayed(this.mProgressRunnable, 200L);
                    }
                }
                if (this.mIsFront && ViewVisibilityUtil.isVisible(this)) {
                    onStart();
                    return;
                }
                return;
            case 259:
            default:
                return;
            case 260:
                this.mVideoPlaying = true;
                hideLoadingView();
                AdVideoViewListener adVideoViewListener2 = this.mVideoViewListener;
                if (adVideoViewListener2 != null) {
                    adVideoViewListener2.renderingStart();
                    return;
                }
                return;
            case PlayerEvent.PLAY_LOADING_START /* 261 */:
                showLoadingView();
                return;
            case PlayerEvent.PLAY_LOADING_END /* 262 */:
                hideLoadingView();
                return;
        }
    }

    private void hideLoadingView() {
        View view = this.mLoadingView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void init() {
    }

    private void initMediaPlayer() {
        if (this.mMediaPlayer == null) {
            this.mPlayerHasReleased = false;
            BaseMediaPlayer baseMediaPlayer = new BaseMediaPlayer(this.mViewContext);
            this.mMediaPlayer = baseMediaPlayer;
            baseMediaPlayer.setOnPlayStateListener(new OnPlayStateListener() { // from class: com.baidu.mobads.container.widget.player.AdVideoView.1
                @Override // com.baidu.mobads.container.widget.player.OnPlayStateListener
                public void playStateChanged(int i) {
                    AdVideoView.this.dispatchPlayerEvent(i);
                }
            });
        }
    }

    private void initProgressBar() {
        if (this.mShowProgressBar) {
            AdVideoProgressBar adVideoProgressBar = new AdVideoProgressBar(this.mViewContext);
            this.mVideoProgress = adVideoProgressBar;
            adVideoProgressBar.setProgressColor(this.mProgressColor);
            this.mVideoProgress.setProgressBackgroundColor(this.mProgressBg);
            this.mVideoProgress.setProgressHeight(this.mProgressHeight);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mProgressHeight);
            layoutParams.addRule(12);
            addView(this.mVideoProgress, layoutParams);
            this.mVideoProgress.setProgress(0.0f);
            this.mVideoProgress.setVisibility(4);
            this.mProgressRunnable = new UpdateProgressRunnable(this);
            return;
        }
        AdVideoProgressBar adVideoProgressBar2 = this.mVideoProgress;
        if (adVideoProgressBar2 != null) {
            adVideoProgressBar2.setVisibility(8);
        }
    }

    private void initSurfaceView(boolean z) {
        if (z) {
            this.mIsSurfaceView = true;
            this.mSurfaceView = new BaseSurfaceView(this.mViewContext, this.mSurfaceListener);
        } else if (Build.VERSION.SDK_INT >= 14) {
            this.mIsSurfaceView = false;
            this.mSurfaceView = new BaseTextureView(this.mViewContext, this.mTextureListener);
        } else {
            this.mIsSurfaceView = true;
            this.mSurfaceView = new BaseSurfaceView(this.mViewContext, this.mSurfaceListener);
        }
        this.mSurfaceView.setDisplayMode(this.mDisplayMode);
    }

    private void onStart() {
        BaseMediaPlayer baseMediaPlayer = this.mMediaPlayer;
        if (baseMediaPlayer != null) {
            if (this.mIsSurfaceView) {
                baseMediaPlayer.setDisplay(this.mSurfaceHolder);
                this.mMediaPlayer.setScreenOnWhilePlaying(true);
            } else {
                baseMediaPlayer.setSurface(this.mSurface);
                this.mMediaPlayer.setWakeMode(this.mViewContext, 10);
            }
            this.mMediaPlayer.start();
        }
    }

    private void playError() {
        AdVideoViewListener adVideoViewListener = this.mVideoViewListener;
        if (adVideoViewListener != null) {
            adVideoViewListener.playFailure();
        }
        hideLoadingView();
        stopAndRelease();
    }

    private void registerListener() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        if (this.mViewContext == null || this.mScreenReceiver != null) {
            return;
        }
        ScreenBroadcastReceiver screenBroadcastReceiver = new ScreenBroadcastReceiver();
        this.mScreenReceiver = screenBroadcastReceiver;
        this.mViewContext.registerReceiver(screenBroadcastReceiver, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryPlay() {
        if (!TextUtils.isEmpty(this.mPlayUrl) && this.mIsFront && this.mSurfaceAvailable) {
            Context context = this.mViewContext;
            if ((AppUtils.isForeground(context, context.getPackageName()) || !this.mIsScreenLock) && this.mVideoPlaying) {
                AdVideoViewListener adVideoViewListener = this.mVideoViewListener;
                if (adVideoViewListener != null) {
                    adVideoViewListener.playResume();
                }
                if (!this.mPlayerHasReleased) {
                    onStart();
                } else if (this.mPreparePlaying) {
                } else {
                    stopAndRelease();
                    this.mPreparePlaying = true;
                    initMediaPlayer();
                    setVideoUrl(this.mPlayUrl);
                    onStart();
                }
            }
        }
    }

    private void setLastPostion() {
        BaseMediaPlayer baseMediaPlayer = this.mMediaPlayer;
        if (baseMediaPlayer == null) {
            return;
        }
        this.mLastPosition = baseMediaPlayer.getCurrentPosition();
    }

    private void setVolume(float f2, float f3) {
        BaseMediaPlayer baseMediaPlayer = this.mMediaPlayer;
        if (baseMediaPlayer != null) {
            baseMediaPlayer.setVolume(f2, f3);
        }
    }

    private void showLoadingView() {
        View view = this.mLoadingView;
        if (view == null) {
            this.mLoadingView = new ProgressBar(this.mViewContext);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.mLoadingView.setLayoutParams(layoutParams);
            addView(this.mLoadingView);
            return;
        }
        view.setVisibility(0);
    }

    private void unRegisterListener() {
        ScreenBroadcastReceiver screenBroadcastReceiver;
        Context context = this.mViewContext;
        if (context == null || (screenBroadcastReceiver = this.mScreenReceiver) == null) {
            return;
        }
        try {
            context.unregisterReceiver(screenBroadcastReceiver);
            this.mScreenReceiver = null;
        } catch (Throwable unused) {
            this.mScreenReceiver = null;
        }
    }

    public void clearData() {
        this.mPlayUrl = "";
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public int getCurrentPosition() {
        BaseMediaPlayer baseMediaPlayer = this.mMediaPlayer;
        if (baseMediaPlayer != null) {
            return baseMediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public int getDuration() {
        BaseMediaPlayer baseMediaPlayer = this.mMediaPlayer;
        if (baseMediaPlayer != null) {
            return baseMediaPlayer.getDuration();
        }
        return 0;
    }

    public int getLastPosition() {
        return this.mLastPosition;
    }

    public void initAdVideoView() {
        initMediaPlayer();
        initSurfaceView(false);
        addVideoView();
        initProgressBar();
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public boolean isPlaying() {
        BaseMediaPlayer baseMediaPlayer = this.mMediaPlayer;
        if (baseMediaPlayer != null) {
            return baseMediaPlayer.isPlaying();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        registerListener();
    }

    @Override // android.view.View, com.baidu.mobads.container.widget.player.IAdVideoView
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        unRegisterListener();
        stopAndRelease();
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public void onPause() {
        this.mIsFront = false;
        BaseMediaPlayer baseMediaPlayer = this.mMediaPlayer;
        if (baseMediaPlayer == null || baseMediaPlayer.mCurState == BaseMediaPlayer.State.PLAYBACKCOMPLETED) {
            return;
        }
        baseMediaPlayer.pause();
        AdVideoViewListener adVideoViewListener = this.mVideoViewListener;
        if (adVideoViewListener != null) {
            adVideoViewListener.playPause();
        }
        setLastPostion();
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public void onResume() {
        this.mIsFront = true;
        retryPlay();
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public void seekTo(int i) {
        BaseMediaPlayer baseMediaPlayer = this.mMediaPlayer;
        if (baseMediaPlayer != null) {
            baseMediaPlayer.seekTo(i);
        }
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public void setAdVideoViewListener(AdVideoViewListener adVideoViewListener) {
        this.mVideoViewListener = adVideoViewListener;
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public void setDestroyedListener(AdVideoViewListener.DestroyedListener destroyedListener) {
        this.mDestroyListener = destroyedListener;
    }

    public void setDisplayMode(int i) {
        this.mDisplayMode = i;
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public void setPlayBackSpeed(float f2) {
        BaseMediaPlayer baseMediaPlayer = this.mMediaPlayer;
        if (baseMediaPlayer != null) {
            baseMediaPlayer.setPlayBackSpeed(f2);
        }
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public void setPreparedListener(AdVideoViewListener.PreparedListener preparedListener) {
        this.mPreparedListener = preparedListener;
    }

    public void setProgressBar(boolean z, int i, int i2, int i3) {
        this.mShowProgressBar = z;
        this.mProgressBg = i;
        this.mProgressColor = i2;
        this.mProgressHeight = CommonUtils.dip2px(getContext(), i3);
    }

    public void setProgressBarVisibility(int i) {
        if (this.mShowProgressBar) {
            this.mVideoProgress.setVisibility(i);
        }
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public void setVideoMute(boolean z) {
        this.mIsMute = z;
        if (z) {
            setVolume(0.0f, 0.0f);
        } else {
            setVolume(1.0f, 1.0f);
        }
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public void setVideoUrl(String str) {
        this.mPlayUrl = str;
        if (TextUtils.isEmpty(str)) {
            playError();
            return;
        }
        BaseMediaPlayer baseMediaPlayer = this.mMediaPlayer;
        if (baseMediaPlayer != null) {
            baseMediaPlayer.setVideoPath(str);
        }
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public void startPlay(String str) {
        this.mLastPosition = 0;
        this.mPlayUrl = str;
        this.mIsFront = true;
        this.mVideoPlaying = true;
        retryPlay();
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public void stopAndRelease() {
        if (this.mMediaPlayer != null) {
            setLastPostion();
            this.mPlayerHasReleased = true;
            this.mPreparePlaying = false;
            this.mMediaPlayer.setOnPlayStateListener(null);
            this.mMediaPlayer.stop();
            this.mMediaPlayer.reset();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            UpdateProgressRunnable updateProgressRunnable = this.mProgressRunnable;
            if (updateProgressRunnable != null) {
                updateProgressRunnable.setProcessRunning(false);
            }
        }
    }

    public void initAdVideoView(boolean z) {
        initMediaPlayer();
        initSurfaceView(z);
        addVideoView();
    }

    public AdVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mProgressColor = -1;
        this.mProgressBg = -16777216;
        this.mShowProgressBar = false;
        this.mProgressHeight = 4;
        this.mPlayUrl = "";
        this.mSurfaceAvailable = false;
        this.mIsScreenLock = false;
        this.mPreparePlaying = false;
        this.mVideoPlaying = false;
        this.mDisplayMode = 1;
        this.mIsSurfaceView = false;
        this.mTextureListener = new ITextureListener() { // from class: com.baidu.mobads.container.widget.player.AdVideoView.2
            @Override // com.baidu.mobads.container.widget.player.ITextureListener
            public void surfaceCreated(Surface surface) {
                AdVideoView.this.mSurface = surface;
                AdVideoView.this.mSurfaceAvailable = true;
                AdVideoView.this.retryPlay();
            }

            @Override // com.baidu.mobads.container.widget.player.ITextureListener
            public void surfaceDestroy() {
                if (AdVideoView.this.mDestroyListener != null) {
                    AdVideoView.this.mDestroyListener.onDestroyed();
                }
                AdVideoView.this.mIsFront = false;
                AdVideoView.this.mSurfaceAvailable = false;
                AdVideoView.this.stopAndRelease();
            }
        };
        this.mSurfaceListener = new ISurfaceListener() { // from class: com.baidu.mobads.container.widget.player.AdVideoView.3
            @Override // com.baidu.mobads.container.widget.player.ISurfaceListener
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                AdVideoView.this.mSurfaceHolder = surfaceHolder;
                AdVideoView.this.mSurfaceAvailable = true;
                AdVideoView.this.retryPlay();
            }

            @Override // com.baidu.mobads.container.widget.player.ISurfaceListener
            public void surfaceDestroy() {
                if (AdVideoView.this.mDestroyListener != null) {
                    AdVideoView.this.mDestroyListener.onDestroyed();
                }
                AdVideoView.this.mIsFront = false;
                AdVideoView.this.mSurfaceAvailable = false;
                AdVideoView.this.stopAndRelease();
            }
        };
        this.mViewContext = context;
        init();
    }

    public AdVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgressColor = -1;
        this.mProgressBg = -16777216;
        this.mShowProgressBar = false;
        this.mProgressHeight = 4;
        this.mPlayUrl = "";
        this.mSurfaceAvailable = false;
        this.mIsScreenLock = false;
        this.mPreparePlaying = false;
        this.mVideoPlaying = false;
        this.mDisplayMode = 1;
        this.mIsSurfaceView = false;
        this.mTextureListener = new ITextureListener() { // from class: com.baidu.mobads.container.widget.player.AdVideoView.2
            @Override // com.baidu.mobads.container.widget.player.ITextureListener
            public void surfaceCreated(Surface surface) {
                AdVideoView.this.mSurface = surface;
                AdVideoView.this.mSurfaceAvailable = true;
                AdVideoView.this.retryPlay();
            }

            @Override // com.baidu.mobads.container.widget.player.ITextureListener
            public void surfaceDestroy() {
                if (AdVideoView.this.mDestroyListener != null) {
                    AdVideoView.this.mDestroyListener.onDestroyed();
                }
                AdVideoView.this.mIsFront = false;
                AdVideoView.this.mSurfaceAvailable = false;
                AdVideoView.this.stopAndRelease();
            }
        };
        this.mSurfaceListener = new ISurfaceListener() { // from class: com.baidu.mobads.container.widget.player.AdVideoView.3
            @Override // com.baidu.mobads.container.widget.player.ISurfaceListener
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                AdVideoView.this.mSurfaceHolder = surfaceHolder;
                AdVideoView.this.mSurfaceAvailable = true;
                AdVideoView.this.retryPlay();
            }

            @Override // com.baidu.mobads.container.widget.player.ISurfaceListener
            public void surfaceDestroy() {
                if (AdVideoView.this.mDestroyListener != null) {
                    AdVideoView.this.mDestroyListener.onDestroyed();
                }
                AdVideoView.this.mIsFront = false;
                AdVideoView.this.mSurfaceAvailable = false;
                AdVideoView.this.stopAndRelease();
            }
        };
        this.mViewContext = context;
        init();
    }
}
