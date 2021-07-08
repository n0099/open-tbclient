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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AppUtils;
import com.baidu.mobads.container.util.CommonUtils;
import com.baidu.mobads.container.util.ViewVisibilityUtil;
import com.baidu.mobads.container.widget.player.AdVideoViewListener;
import com.baidu.mobads.container.widget.player.BaseMediaPlayer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
/* loaded from: classes2.dex */
public class AdVideoView extends RelativeLayout implements IAdVideoView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "AdVideoView";
    public static final int UPDATE_DELAY = 200;
    public transient /* synthetic */ FieldHolder $fh;
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
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdVideoView this$0;

        public ScreenBroadcastReceiver(AdVideoView adVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = adVideoView;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                String action = intent.getAction();
                if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    Context context2 = this.this$0.mViewContext;
                    if (AppUtils.isForeground(context2, context2.getPackageName())) {
                        return;
                    }
                    this.this$0.mIsScreenLock = true;
                    this.this$0.stopAndRelease();
                } else if ("android.intent.action.USER_PRESENT".equals(action)) {
                    this.this$0.mIsScreenLock = false;
                    this.this$0.retryPlay();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class UpdateProgressRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SoftReference<AdVideoView> adVideoViewReference;
        public boolean mProcessing;

        public UpdateProgressRunnable(AdVideoView adVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mProcessing = false;
            this.adVideoViewReference = new SoftReference<>(adVideoView);
        }

        @Override // java.lang.Runnable
        public void run() {
            SoftReference<AdVideoView> softReference;
            AdVideoView adVideoView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (softReference = this.adVideoViewReference) == null || (adVideoView = softReference.get()) == null) {
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.mProcessing = z;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdVideoView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
        this.mTextureListener = new ITextureListener(this) { // from class: com.baidu.mobads.container.widget.player.AdVideoView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdVideoView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.mobads.container.widget.player.ITextureListener
            public void surfaceCreated(Surface surface) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, surface) == null) {
                    this.this$0.mSurface = surface;
                    this.this$0.mSurfaceAvailable = true;
                    this.this$0.retryPlay();
                }
            }

            @Override // com.baidu.mobads.container.widget.player.ITextureListener
            public void surfaceDestroy() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.this$0.mDestroyListener != null) {
                        this.this$0.mDestroyListener.onDestroyed();
                    }
                    this.this$0.mIsFront = false;
                    this.this$0.mSurfaceAvailable = false;
                    this.this$0.stopAndRelease();
                }
            }
        };
        this.mSurfaceListener = new ISurfaceListener(this) { // from class: com.baidu.mobads.container.widget.player.AdVideoView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdVideoView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.mobads.container.widget.player.ISurfaceListener
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, surfaceHolder) == null) {
                    this.this$0.mSurfaceHolder = surfaceHolder;
                    this.this$0.mSurfaceAvailable = true;
                    this.this$0.retryPlay();
                }
            }

            @Override // com.baidu.mobads.container.widget.player.ISurfaceListener
            public void surfaceDestroy() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.this$0.mDestroyListener != null) {
                        this.this$0.mDestroyListener.onDestroyed();
                    }
                    this.this$0.mIsFront = false;
                    this.this$0.mSurfaceAvailable = false;
                    this.this$0.stopAndRelease();
                }
            }
        };
        this.mViewContext = context;
        init();
    }

    private void addVideoView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            removeAllViews();
            this.mVideoPlaying = false;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            setBackgroundColor(Color.parseColor("#000000"));
            addView((View) this.mSurfaceView, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchPlayerEvent(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65549, this, i2) == null) {
            switch (i2) {
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
                    int i3 = this.mLastPosition;
                    if (i3 > 0) {
                        this.mMediaPlayer.seekTo(i3);
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
    }

    private void hideLoadingView() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || (view = this.mLoadingView) == null) {
            return;
        }
        view.setVisibility(8);
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
        }
    }

    private void initMediaPlayer() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65552, this) == null) && this.mMediaPlayer == null) {
            this.mPlayerHasReleased = false;
            BaseMediaPlayer baseMediaPlayer = new BaseMediaPlayer(this.mViewContext);
            this.mMediaPlayer = baseMediaPlayer;
            baseMediaPlayer.setOnPlayStateListener(new OnPlayStateListener(this) { // from class: com.baidu.mobads.container.widget.player.AdVideoView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdVideoView this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.mobads.container.widget.player.OnPlayStateListener
                public void playStateChanged(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        this.this$0.dispatchPlayerEvent(i2);
                    }
                }
            });
        }
    }

    private void initProgressBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
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
    }

    private void initSurfaceView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, this, z) == null) {
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
    }

    private void onStart() {
        BaseMediaPlayer baseMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65555, this) == null) || (baseMediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        if (this.mIsSurfaceView) {
            baseMediaPlayer.setDisplay(this.mSurfaceHolder);
            this.mMediaPlayer.setScreenOnWhilePlaying(true);
        } else {
            baseMediaPlayer.setSurface(this.mSurface);
            this.mMediaPlayer.setWakeMode(this.mViewContext, 10);
        }
        this.mMediaPlayer.start();
    }

    private void playError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            AdVideoViewListener adVideoViewListener = this.mVideoViewListener;
            if (adVideoViewListener != null) {
                adVideoViewListener.playFailure();
            }
            hideLoadingView();
            stopAndRelease();
        }
    }

    private void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryPlay() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65558, this) == null) && !TextUtils.isEmpty(this.mPlayUrl) && this.mIsFront && this.mSurfaceAvailable) {
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
        BaseMediaPlayer baseMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65559, this) == null) || (baseMediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        this.mLastPosition = baseMediaPlayer.getCurrentPosition();
    }

    private void setVolume(float f2, float f3) {
        BaseMediaPlayer baseMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65560, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (baseMediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        baseMediaPlayer.setVolume(f2, f3);
    }

    private void showLoadingView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
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
    }

    private void unRegisterListener() {
        Context context;
        ScreenBroadcastReceiver screenBroadcastReceiver;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65562, this) == null) || (context = this.mViewContext) == null || (screenBroadcastReceiver = this.mScreenReceiver) == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mPlayUrl = "";
        }
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BaseMediaPlayer baseMediaPlayer = this.mMediaPlayer;
            if (baseMediaPlayer != null) {
                return baseMediaPlayer.getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BaseMediaPlayer baseMediaPlayer = this.mMediaPlayer;
            if (baseMediaPlayer != null) {
                return baseMediaPlayer.getDuration();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getLastPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mLastPosition : invokeV.intValue;
    }

    public void initAdVideoView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            initMediaPlayer();
            initSurfaceView(false);
            addVideoView();
            initProgressBar();
        }
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            BaseMediaPlayer baseMediaPlayer = this.mMediaPlayer;
            if (baseMediaPlayer != null) {
                return baseMediaPlayer.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onAttachedToWindow();
            registerListener();
        }
    }

    @Override // android.view.View, com.baidu.mobads.container.widget.player.IAdVideoView
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, configuration) == null) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDetachedFromWindow();
            unRegisterListener();
            stopAndRelease();
        }
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
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
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.mIsFront = true;
            retryPlay();
        }
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public void seekTo(int i2) {
        BaseMediaPlayer baseMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (baseMediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        baseMediaPlayer.seekTo(i2);
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public void setAdVideoViewListener(AdVideoViewListener adVideoViewListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, adVideoViewListener) == null) {
            this.mVideoViewListener = adVideoViewListener;
        }
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public void setDestroyedListener(AdVideoViewListener.DestroyedListener destroyedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, destroyedListener) == null) {
            this.mDestroyListener = destroyedListener;
        }
    }

    public void setDisplayMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.mDisplayMode = i2;
        }
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public void setPlayBackSpeed(float f2) {
        BaseMediaPlayer baseMediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048592, this, f2) == null) || (baseMediaPlayer = this.mMediaPlayer) == null) {
            return;
        }
        baseMediaPlayer.setPlayBackSpeed(f2);
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public void setPreparedListener(AdVideoViewListener.PreparedListener preparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, preparedListener) == null) {
            this.mPreparedListener = preparedListener;
        }
    }

    public void setProgressBar(boolean z, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.mShowProgressBar = z;
            this.mProgressBg = i2;
            this.mProgressColor = i3;
            this.mProgressHeight = CommonUtils.dip2px(getContext(), i4);
        }
    }

    public void setProgressBarVisibility(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048595, this, i2) == null) && this.mShowProgressBar) {
            this.mVideoProgress.setVisibility(i2);
        }
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public void setVideoMute(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.mIsMute = z;
            if (z) {
                setVolume(0.0f, 0.0f);
            } else {
                setVolume(1.0f, 1.0f);
            }
        }
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public void setVideoUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
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
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public void startPlay(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.mLastPosition = 0;
            this.mPlayUrl = str;
            this.mIsFront = true;
            this.mVideoPlaying = true;
            retryPlay();
        }
    }

    @Override // com.baidu.mobads.container.widget.player.IAdVideoView
    public void stopAndRelease() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || this.mMediaPlayer == null) {
            return;
        }
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

    public void initAdVideoView(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            initMediaPlayer();
            initSurfaceView(z);
            addVideoView();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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
        this.mTextureListener = new ITextureListener(this) { // from class: com.baidu.mobads.container.widget.player.AdVideoView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdVideoView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.mobads.container.widget.player.ITextureListener
            public void surfaceCreated(Surface surface) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, surface) == null) {
                    this.this$0.mSurface = surface;
                    this.this$0.mSurfaceAvailable = true;
                    this.this$0.retryPlay();
                }
            }

            @Override // com.baidu.mobads.container.widget.player.ITextureListener
            public void surfaceDestroy() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.this$0.mDestroyListener != null) {
                        this.this$0.mDestroyListener.onDestroyed();
                    }
                    this.this$0.mIsFront = false;
                    this.this$0.mSurfaceAvailable = false;
                    this.this$0.stopAndRelease();
                }
            }
        };
        this.mSurfaceListener = new ISurfaceListener(this) { // from class: com.baidu.mobads.container.widget.player.AdVideoView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdVideoView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.mobads.container.widget.player.ISurfaceListener
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, surfaceHolder) == null) {
                    this.this$0.mSurfaceHolder = surfaceHolder;
                    this.this$0.mSurfaceAvailable = true;
                    this.this$0.retryPlay();
                }
            }

            @Override // com.baidu.mobads.container.widget.player.ISurfaceListener
            public void surfaceDestroy() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.this$0.mDestroyListener != null) {
                        this.this$0.mDestroyListener.onDestroyed();
                    }
                    this.this$0.mIsFront = false;
                    this.this$0.mSurfaceAvailable = false;
                    this.this$0.stopAndRelease();
                }
            }
        };
        this.mViewContext = context;
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
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
        this.mTextureListener = new ITextureListener(this) { // from class: com.baidu.mobads.container.widget.player.AdVideoView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdVideoView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.mobads.container.widget.player.ITextureListener
            public void surfaceCreated(Surface surface) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, surface) == null) {
                    this.this$0.mSurface = surface;
                    this.this$0.mSurfaceAvailable = true;
                    this.this$0.retryPlay();
                }
            }

            @Override // com.baidu.mobads.container.widget.player.ITextureListener
            public void surfaceDestroy() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.this$0.mDestroyListener != null) {
                        this.this$0.mDestroyListener.onDestroyed();
                    }
                    this.this$0.mIsFront = false;
                    this.this$0.mSurfaceAvailable = false;
                    this.this$0.stopAndRelease();
                }
            }
        };
        this.mSurfaceListener = new ISurfaceListener(this) { // from class: com.baidu.mobads.container.widget.player.AdVideoView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdVideoView this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.mobads.container.widget.player.ISurfaceListener
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, surfaceHolder) == null) {
                    this.this$0.mSurfaceHolder = surfaceHolder;
                    this.this$0.mSurfaceAvailable = true;
                    this.this$0.retryPlay();
                }
            }

            @Override // com.baidu.mobads.container.widget.player.ISurfaceListener
            public void surfaceDestroy() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.this$0.mDestroyListener != null) {
                        this.this$0.mDestroyListener.onDestroyed();
                    }
                    this.this$0.mIsFront = false;
                    this.this$0.mSurfaceAvailable = false;
                    this.this$0.stopAndRelease();
                }
            }
        };
        this.mViewContext = context;
        init();
    }
}
